// 
/*   */
/**
*  Copyright (C) 2020 Yasuyuki Takeo All rights reserved.
*
*  This program is free software: you can redistribute it and/or modify
*  it under the terms of the GNU Lesser General Public License as published by
*  the Free Software Foundation, either version 3 of the License, or
*  (at your option) any later version.
*
*  This program is distributed in the hope that it will be useful,
*  but WITHOUT ANY WARRANTY; without even the implied warranty of
*  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
*  GNU Lesser General Public License for more details.
*/
/*  */ 

package com.liferay.sb.test.service.impl;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.exportimport.kernel.lar.ExportImportThreadLocal;
import com.liferay.friendly.url.exception.DuplicateFriendlyURLEntryException;
import com.liferay.friendly.url.model.FriendlyURLEntry;
import com.liferay.friendly.url.service.FriendlyURLEntryLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.comment.CommentManagerUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.ModelHintsUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.ModelValidator;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ClassNameLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.permission.ModelPermissions;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.sb.test.exception.SampleSBValidateException;
import com.liferay.sb.test.model.SampleSB;
import com.liferay.sb.test.service.base.SampleSBLocalServiceBaseImpl;
import com.liferay.sb.test.service.util.SampleSBValidator;
import com.liferay.trash.exception.RestoreEntryException;
import com.liferay.trash.exception.TrashEntryException;
import com.liferay.trash.model.TrashEntry;
import com.liferay.trash.service.TrashEntryLocalService;

import java.io.Serializable;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The implementation of the SampleSB local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.liferay.sb.test.service.SampleSBLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author yasuflatland
 * @see SampleSBLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.sb.test.model.SampleSB",
	service = AopService.class
)
public class SampleSBLocalServiceImpl extends SampleSBLocalServiceBaseImpl {

	/**
	 * Add Entry
	 *
	 * @param orgEntry       SampleSB model
	 * @param serviceContext ServiceContext
	 * @exception PortalException
	 * @exception SampleSBValidateException
	 * @return created SampleSB model.
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SampleSB addEntry(SampleSB orgEntry, ServiceContext serviceContext)
		throws PortalException, SampleSBValidateException {

		long userId = serviceContext.getUserId();

		// Validation

		ModelValidator<SampleSB> modelValidator = new SampleSBValidator();
		modelValidator.validate(orgEntry);

		SampleSB entry = _addEntry(orgEntry, serviceContext);

		// Resources

		if (serviceContext.isAddGroupPermissions() ||
			serviceContext.isAddGuestPermissions()) {

			addEntryResources(
				entry, serviceContext.isAddGroupPermissions(),
				serviceContext.isAddGuestPermissions());
		}
		else {
			addEntryResources(entry, serviceContext.getModelPermissions());
		}

		// Asset

		updateAsset(
			userId, entry, serviceContext.getAssetCategoryIds(),
			serviceContext.getAssetTagNames(),
			serviceContext.getAssetLinkEntryIds(),
			serviceContext.getAssetPriority());

		// Workflow

		return startWorkflowInstance(userId, entry, serviceContext);
	}

	@Override
	public void addEntryResources(
			long entryId, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException {

		SampleSB entry = sampleSBPersistence.findByPrimaryKey(entryId);

		addEntryResources(entry, addGroupPermissions, addGuestPermissions);
	}

	@Override
	public void addEntryResources(
			long entryId, ModelPermissions modelPermissions)
		throws PortalException {

		SampleSB entry = sampleSBPersistence.findByPrimaryKey(entryId);

		addEntryResources(entry, modelPermissions);
	}

	@Override
	public void addEntryResources(
			SampleSB entry, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException {

		resourceLocalService.addResources(
			entry.getCompanyId(), entry.getGroupId(), entry.getUserId(),
			SampleSB.class.getName(), entry.getPrimaryKey(), false,
			addGroupPermissions, addGuestPermissions);
	}

	@Override
	public void addEntryResources(
			SampleSB entry, ModelPermissions modelPermissions)
		throws PortalException {

		resourceLocalService.addModelResources(
			entry.getCompanyId(), entry.getGroupId(), entry.getUserId(),
			SampleSB.class.getName(), entry.getPrimaryKey(), modelPermissions);
	}

	public int countAllInGroup(long groupId) {
		int count = sampleSBPersistence.countByGroupId(groupId);

		return count;
	}

	public int countAllInGroup(long groupId, int[] status) {
		int count = sampleSBPersistence.countByG_S(groupId, status);

		return count;
	}

	public int countAllInUser(long userId) {
		int count = sampleSBPersistence.countByUserId(userId);

		return count;
	}

	public int countAllInUser(long userId, int[] status) {
		int count = sampleSBPersistence.countByU_S(userId, status);

		return count;
	}

	public int countAllInUserAndGroup(long userId, long groupId) {
		int count = sampleSBPersistence.countByUserIdGroupId(userId, groupId);

		return count;
	}

	public int countAllInUserAndGroup(long userId, long groupId, int[] status) {
		int count = sampleSBPersistence.countByG_U_S(groupId, userId, status);

		return count;
	}

	/**
	 * Delete entry
	 */
	public SampleSB deleteEntry(long primaryKey) throws PortalException {
		SampleSB entry = getSampleSB(primaryKey);

		return deleteEntry(entry);
	}

	/**
	 * Delete entry
	 *
	 * @param entry SampleSB
	 * @return SampleSB oject
	 * @exception PortalException
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	@SystemEvent(type = SystemEventConstants.TYPE_DELETE)
	public SampleSB deleteEntry(SampleSB entry) throws PortalException {

		// Entry

		sampleSBPersistence.remove(entry);

		// Resources

		resourceLocalService.deleteResource(
			entry.getCompanyId(), SampleSB.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, entry.getPrimaryKey());

		// Asset

		assetEntryLocalService.deleteEntry(
			SampleSB.class.getName(), entry.getPrimaryKey());

		// Comment

		deleteDiscussion(entry);

		// Friendly URL

		_friendlyURLEntryLocalService.deleteFriendlyURLEntry(
			entry.getGroupId(), SampleSB.class, entry.getPrimaryKey());	

		// Trash

		_trashEntryLocalService.deleteEntry(
			SampleSB.class.getName(), entry.getPrimaryKey());

		// Workflow

		workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
			entry.getCompanyId(), entry.getGroupId(), SampleSB.class.getName(),
			entry.getPrimaryKey());

		return entry;
	}

	public List<SampleSB> findAllInGroup(long groupId) {
		List<SampleSB> list = (List<SampleSB>)sampleSBPersistence.findByGroupId(
			groupId);

		return list;
	}

	public List<SampleSB> findAllInGroup(
		long groupId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findAllInGroup(
			groupId, start, end, orderByComparator,
			new int[] {WorkflowConstants.STATUS_APPROVED});
	}

	public List<SampleSB> findAllInGroup(
		long groupId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, int[] status) {

		List<SampleSB> list = (List<SampleSB>)sampleSBPersistence.findByG_S(
			groupId, status, start, end, orderByComparator);

		return list;
	}

	public List<SampleSB> findAllInGroup(long groupId, int[] status) {
		List<SampleSB> list = (List<SampleSB>)sampleSBPersistence.findByG_S(
			groupId, status);

		return list;
	}

	public List<SampleSB> findAllInGroup(
		long groupId, OrderByComparator<SampleSB> orderByComparator) {

		List<SampleSB> list = (List<SampleSB>)findAllInGroup(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);

		return list;
	}

	public List<SampleSB> findAllInUser(long userId) {
		List<SampleSB> list = (List<SampleSB>)sampleSBPersistence.findByUserId(
			userId);

		return list;
	}

	public List<SampleSB> findAllInUser(
		long userId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		List<SampleSB> list = (List<SampleSB>)sampleSBPersistence.findByUserId(
			userId, start, end, orderByComparator);

		return list;
	}

	public List<SampleSB> findAllInUser(
		long userId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, int[] status) {

		List<SampleSB> list = (List<SampleSB>)sampleSBPersistence.findByU_S(
			userId, status, start, end, orderByComparator);

		return list;
	}

	public List<SampleSB> findAllInUser(long userId, int[] status) {
		List<SampleSB> list = (List<SampleSB>)sampleSBPersistence.findByU_S(
			userId, status);

		return list;
	}

	public List<SampleSB> findAllInUser(
		long userId, OrderByComparator<SampleSB> orderByComparator) {

		List<SampleSB> list = (List<SampleSB>)findAllInUser(
			userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);

		return list;
	}

	public List<SampleSB> findAllInUserAndGroup(long userId, long groupId) {
		List<SampleSB> list =
			(List<SampleSB>)sampleSBPersistence.findByUserIdGroupId(
				userId, groupId);

		return list;
	}

	public List<SampleSB> findAllInUserAndGroup(
		long userId, long groupId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		List<SampleSB> list =
			(List<SampleSB>)sampleSBPersistence.findByUserIdGroupId(
				groupId, userId, start, end, orderByComparator);

		return list;
	}

	public List<SampleSB> findAllInUserAndGroup(
		long userId, long groupId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, int[] status) {

		List<SampleSB> list = (List<SampleSB>)sampleSBPersistence.findByG_U_S(
			groupId, userId, status, start, end, orderByComparator);

		return list;
	}

	public List<SampleSB> findAllInUserAndGroup(
		long userId, long groupId, int[] status) {

		List<SampleSB> list = (List<SampleSB>)sampleSBPersistence.findByG_U_S(
			groupId, userId, status);

		return list;
	}

	public List<SampleSB> findAllInUserAndGroup(
		long userId, long groupId,
		OrderByComparator<SampleSB> orderByComparator) {

		List<SampleSB> list = (List<SampleSB>)findAllInUserAndGroup(
			groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			orderByComparator);

		return list;
	}

	/**
	 * Get Company entries
	 *
	 * @param companyId Company Id
	 * @param status    Workflow status
	 * @param start     start index of entries
	 * @param end       end index of entries
	 * @return
	 * @throws SystemException
	 */
	public List<SampleSB> getCompanyEntries(
		long companyId, int status, int start, int end) {

		if (status == WorkflowConstants.STATUS_ANY) {
			return sampleSBPersistence.findByCompanyId(companyId, start, end);
		}

		return sampleSBPersistence.findByC_S(companyId, status, start, end);
	}

	/**
	 * Get Company entries
	 *
	 * @param companyId Company Id
	 * @param status    Workflow status
	 * @param start     start index of entries
	 * @param end       end index of entries
	 * @param obc       Comparator for the order
	 * @return List of entries
	 * @throws SystemException
	 */
	public List<SampleSB> getCompanyEntries(
		long companyId, int status, int start, int end,
		OrderByComparator<SampleSB> obc) {

		if (status == WorkflowConstants.STATUS_ANY) {
			return sampleSBPersistence.findByCompanyId(
				companyId, start, end, obc);
		}

		return sampleSBPersistence.findByC_S(
			companyId, status, start, end, obc);
	}

	/**
	 * Get Company entries counts
	 *
	 * @param companyId
	 * @param status
	 * @return
	 * @throws SystemException
	 */
	public int getCompanyEntriesCount(long companyId, int status) {
		if (status == WorkflowConstants.STATUS_ANY) {
			return sampleSBPersistence.countByCompanyId(companyId);
		}

		return sampleSBPersistence.countByC_S(companyId, status);
	}

	/**
	 * Converte Date Time into Date()
	 *
	 * @param request PortletRequest
	 * @param prefix  Prefix of the parameter
	 * @return Date object
	 */
	public Date getDateTimeFromRequest(PortletRequest request, String prefix) {
		int Year = ParamUtil.getInteger(request, prefix + "Year");
		int Month = ParamUtil.getInteger(request, prefix + "Month") + 1;
		int Day = ParamUtil.getInteger(request, prefix + "Day");
		int Hour = ParamUtil.getInteger(request, prefix + "Hour");
		int Minute = ParamUtil.getInteger(request, prefix + "Minute");
		int AmPm = ParamUtil.getInteger(request, prefix + "AmPm");

		if (AmPm == Calendar.PM) {
			Hour += 12;
		}

		LocalDateTime ldt;

		try {
			ldt = LocalDateTime.of(Year, Month, Day, Hour, Minute, 0);
		}
		catch (Exception e) {
			_log.error(
				"Unnable get date data. Initialize with current date", e);
			Date in = new Date();

			Instant instant = in.toInstant();

			return Date.from(instant);
		}

		return Date.from(
			ldt.atZone(
				ZoneId.systemDefault()
			).toInstant());
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param primaryKey primary key
	 * @param request    PortletRequest
	 * @return SampleSB Object
	 * @throws PortletException
	 */
	public SampleSB getInitializedSampleSB(
			long primaryKey, PortletRequest request)
		throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		// Create or fetch existing data

		SampleSB entry = getNewObject(primaryKey);

/*   */
                    entry.setSamplesbId(primaryKey);
                entry.setTitle("");
                entry.setSamplesbBooleanStat(true);
                entry.setSamplesbDateTime(new Date());
                entry.setSamplesbDocumentLibrary("");
                entry.setSamplesbDouble(0.0);
                entry.setSamplesbInteger(0);
                entry.setSamplesbRichText("");
                entry.setSamplesbText("");
/*  */
		entry.setSamplesbTitleName("");
		entry.setSamplesbSummaryName("");

		entry.setCompanyId(themeDisplay.getCompanyId());
		entry.setGroupId(themeDisplay.getScopeGroupId());
		entry.setUserId(themeDisplay.getUserId());
		
		return entry;
	}

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return SampleSB object
	 * @throws PortletException
	 */
	public SampleSB getNewObject(long primaryKey) {
		primaryKey = (primaryKey <= 0) ? 0 :
		counterLocalService.increment(SampleSB.class.getName());

		return createSampleSB(primaryKey);
	}

	/**
	 * Get Entity
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	public SampleSB getSampleSB(long groupId, String urlTitle)
		throws PortalException {

		FriendlyURLEntry friendlyURLEntry =
			_friendlyURLEntryLocalService.fetchFriendlyURLEntry(
				groupId, SampleSB.class, urlTitle);

		if (friendlyURLEntry != null) {
			return sampleSBPersistence.findByPrimaryKey(
				friendlyURLEntry.getClassPK());
		}

		return sampleSBPersistence.findByG_UT(groupId, urlTitle);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return SampleSB Object
	 * @throws PortletException
	 * @throws SampleSBValidateException
	 */
	public SampleSB getSampleSBFromRequest(
			long primaryKey, PortletRequest request)
		throws PortletException, SampleSBValidateException {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		// Create or fetch existing data

		SampleSB entry;

		if (primaryKey <= 0) {
			entry = getNewObject(primaryKey);
		}
		else {
			entry = fetchSampleSB(primaryKey);
		}

		try {
/*   */
            entry.setSamplesbId(primaryKey);
            entry.setTitle(ParamUtil.getString(request, "title"));
            entry.setSamplesbBooleanStat(ParamUtil.getBoolean(request, "samplesbBooleanStat"));
            entry.setSamplesbDateTime(getDateTimeFromRequest(request, "samplesbDateTime"));
            entry.setSamplesbDocumentLibrary(ParamUtil.getString(request, "samplesbDocumentLibrary"));
            entry.setSamplesbDouble(ParamUtil.getDouble(request, "samplesbDouble"));
            entry.setSamplesbInteger(ParamUtil.getInteger(request, "samplesbInteger"));
            entry.setSamplesbRichText(ParamUtil.getString(request, "samplesbRichText"));
            entry.setSamplesbText(ParamUtil.getString(request, "samplesbText"));
/*  */		

			entry.setSamplesbTitleName(
				ParamUtil.getString(request, "samplesbTitleName"));
			entry.setSamplesbSummaryName(
				ParamUtil.getString(request, "samplesbSummaryName"));

			entry.setCompanyId(themeDisplay.getCompanyId());
			entry.setGroupId(themeDisplay.getScopeGroupId());
			entry.setUserId(themeDisplay.getUserId());
		}
		catch (Exception e) {
			_log.error("Errors occur while populating the model", e);
			List<String> error = new ArrayList<>();
			error.add("value-convert-error");

			throw new SampleSBValidateException(error);
		}

		return entry;
	}

	/**
	 * Get STATUS_ANY for DB
	 *
	 * This is equivalent of WorkflowConstants.STATUS_ANY
	 *
	 * @return All statuses for Workflow
	 */
	public int[] getStatusAny() {
		return STATUS_ANY;
	}

	public SampleSB moveEntryToTrash(long userId, long entryId)
		throws PortalException {

		SampleSB entry = sampleSBPersistence.findByPrimaryKey(entryId);

		return moveEntryToTrash(userId, entry);
	}

	/**
	 * Moves the entry to the recycle bin.
	 *
	 * Social activity counters for this entry get disabled.
	 *
	 * @param userId the primary key of the user moving the entry
	 * @param entry  the entry to be moved
	 * @return the moved entry
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SampleSB moveEntryToTrash(long userId, SampleSB entry)
		throws PortalException {

		// Entry

		if (entry.isInTrash()) {
			throw new TrashEntryException();
		}

		int oldStatus = entry.getStatus();

		if (oldStatus == WorkflowConstants.STATUS_PENDING) {
			entry.setStatus(WorkflowConstants.STATUS_DRAFT);

			sampleSBPersistence.update(entry);
		}

		entry = updateStatus(
			userId, entry.getPrimaryKey(), WorkflowConstants.STATUS_IN_TRASH,
			new ServiceContext(), new HashMap<String, Serializable>());

		// Workflow

		if (oldStatus == WorkflowConstants.STATUS_PENDING) {
			workflowInstanceLinkLocalService.deleteWorkflowInstanceLink(
				entry.getCompanyId(), entry.getGroupId(),
				SampleSB.class.getName(), entry.getPrimaryKey());
		}

		return entry;
	}

	/**
	 * Restores the entry with the ID from the recycle bin. Social activity counters
	 * for this entry get activated.
	 *
	 * @param userId  the primary key of the user restoring the entry
	 * @param entryId the primary key of the entry to be restored
	 * @return the restored entry from the recycle bin
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SampleSB restoreEntryFromTrash(long userId, long entryId)
		throws PortalException {

		// Entry

		SampleSB entry = sampleSBPersistence.findByPrimaryKey(entryId);

		if (!entry.isInTrash()) {
			throw new RestoreEntryException(
				RestoreEntryException.INVALID_STATUS);
		}

		TrashEntry trashEntry = _trashEntryLocalService.getEntry(
			SampleSB.class.getName(), entryId);

		updateStatus(
			userId, entryId, trashEntry.getStatus(), new ServiceContext(),
			new HashMap<String, Serializable>());

		return entry;
	}

	@Override
	public void updateAsset(
			long userId, SampleSB entry, long[] assetCategoryIds,
			String[] assetTagNames, long[] assetLinkEntryIds, Double priority)
		throws PortalException {

		boolean visible = false;

		if (entry.isApproved()) {
			visible = true;
		}

		String summary = HtmlUtil.extractText(
			StringUtil.shorten(entry.getSamplesbSummaryName(), 500));

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(
			userId, entry.getGroupId(), entry.getCreateDate(),
			entry.getModifiedDate(), SampleSB.class.getName(),
			entry.getPrimaryKey(), entry.getUuid(), 0, assetCategoryIds,
			assetTagNames, true, visible, null, null, null, null,
			ContentTypes.TEXT_HTML, entry.getSamplesbTitleName(), null, summary,
			null, null, 0, 0, priority);

		assetLinkLocalService.updateLinks(
			userId, assetEntry.getEntryId(), assetLinkEntryIds,
			AssetLinkConstants.TYPE_RELATED);
	}

	/**
	 * Edit Entry
	 *
	 * @param orgEntry       SampleSB model
	 * @param serviceContext ServiceContext
	 * @exception PortalException
	 * @exception SampleSBValidateException
	 * @return updated SampleSB model.
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SampleSB updateEntry(
			SampleSB orgEntry, ServiceContext serviceContext)
		throws PortalException, SampleSBValidateException {

		User user = userLocalService.getUser(orgEntry.getUserId());

		// Validation

		ModelValidator<SampleSB> modelValidator = new SampleSBValidator();
		modelValidator.validate(orgEntry);

		// Update entry

		SampleSB entry = _updateEntry(
			orgEntry.getPrimaryKey(), orgEntry, serviceContext);

		if (!entry.isPending() && !entry.isDraft()) {
			entry.setStatus(WorkflowConstants.STATUS_DRAFT);
		}

		SampleSB updatedEntry = sampleSBPersistence.update(entry);

		// Asset

		updateAsset(
			updatedEntry.getUserId(), updatedEntry,
			serviceContext.getAssetCategoryIds(),
			serviceContext.getAssetTagNames(),
			serviceContext.getAssetLinkEntryIds(),
			serviceContext.getAssetPriority());

		updatedEntry = startWorkflowInstance(
			user.getUserId(), updatedEntry, serviceContext);

		return updatedEntry;
	}

	@Override
	public void updateEntryResources(
			SampleSB entry, String[] groupPermissions,
			String[] guestPermissions)
		throws PortalException {

		resourceLocalService.updateResources(
			entry.getCompanyId(), entry.getGroupId(), SampleSB.class.getName(),
			entry.getPrimaryKey(), groupPermissions, guestPermissions);
	}

	@Indexable(type = IndexableType.REINDEX)
	public SampleSB updateStatus(
			long userId, long entryId, int status,
			ServiceContext serviceContext,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		// Entry

		User user = userLocalService.getUser(userId);
		Date now = new Date();

		SampleSB entry = sampleSBPersistence.findByPrimaryKey(entryId);

		int oldStatus = entry.getStatus();

		entry.setModifiedDate(serviceContext.getModifiedDate(now));
		entry.setStatus(status);
		entry.setStatusByUserId(user.getUserId());
		entry.setStatusByUserName(user.getFullName());
		entry.setStatusDate(serviceContext.getModifiedDate(now));

		sampleSBPersistence.update(entry);

		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
			SampleSB.class.getName(), entryId);

		if ((assetEntry == null) || (assetEntry.getPublishDate() == null)) {
			serviceContext.setCommand(Constants.ADD);
		}

		JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

		extraDataJSONObject.put("title", entry.getSamplesbTitleName());

		if (status == WorkflowConstants.STATUS_APPROVED) {

			// Asset

			assetEntryLocalService.updateEntry(
				SampleSB.class.getName(), entryId, entry.getModifiedDate(),
				null, true, true);

			// Trash

			if (oldStatus == WorkflowConstants.STATUS_IN_TRASH) {
				CommentManagerUtil.restoreDiscussionFromTrash(
					SampleSB.class.getName(), entryId);

				_trashEntryLocalService.deleteEntry(
					SampleSB.class.getName(), entryId);
			}
		}
		else {

			// Asset

			assetEntryLocalService.updateVisible(
				SampleSB.class.getName(), entryId, false);

			// Trash

			if (status == WorkflowConstants.STATUS_IN_TRASH) {
				CommentManagerUtil.moveDiscussionToTrash(
					SampleSB.class.getName(), entryId);
				_trashEntryLocalService.addTrashEntry(
					userId, entry.getGroupId(), SampleSB.class.getName(),
					entry.getPrimaryKey(), entry.getUuid(), null, oldStatus,
					null, null);
			}
			else if (oldStatus == WorkflowConstants.STATUS_IN_TRASH) {
				CommentManagerUtil.restoreDiscussionFromTrash(
					SampleSB.class.getName(), entryId);

				_trashEntryLocalService.deleteEntry(
					SampleSB.class.getName(), entryId);
			}
		}

		return entry;
	}

	/**
	 * Copy models at add entry
	 *
	 * To process storing a record into database, copy the model passed into a new
	 * model object here.
	 *
	 * @param entry          model object
	 * @param serviceContext ServiceContext
	 * @return
	 * @throws PortalException
	 */
	protected SampleSB _addEntry(SampleSB entry, ServiceContext serviceContext)
		throws PortalException {

		long id = counterLocalService.increment(SampleSB.class.getName());

		SampleSB newEntry = sampleSBPersistence.create(id);

		User user = userLocalService.getUser(entry.getUserId());

		Date now = new Date();
		newEntry.setCompanyId(entry.getCompanyId());
		newEntry.setGroupId(entry.getGroupId());
		newEntry.setUserId(user.getUserId());
		newEntry.setUserName(user.getFullName());
		newEntry.setCreateDate(now);
		newEntry.setModifiedDate(now);

		newEntry.setUuid(serviceContext.getUuid());

		// Friendly URLs
		String urlTitle = getUniqueUrlTitle(newEntry, entry.getSamplesbTitleName());
		urlTitle = updateFriendlyURLs(newEntry, urlTitle, serviceContext);
		newEntry.setUrlTitle(urlTitle);

		newEntry.setSamplesbTitleName(entry.getSamplesbTitleName());
		newEntry.setSamplesbSummaryName(entry.getSamplesbSummaryName());

/*   */
        newEntry.setTitle(entry.getTitle());
        newEntry.setSamplesbBooleanStat(entry.getSamplesbBooleanStat());
        newEntry.setSamplesbDateTime(entry.getSamplesbDateTime());
        newEntry.setSamplesbDocumentLibrary(entry.getSamplesbDocumentLibrary());
        newEntry.setSamplesbDouble(entry.getSamplesbDouble());
        newEntry.setSamplesbInteger(entry.getSamplesbInteger());
        newEntry.setSamplesbRichText(entry.getSamplesbRichText());
        newEntry.setSamplesbText(entry.getSamplesbText());
/*  */	

		return sampleSBPersistence.update(newEntry);
	}

	/**
	 * Copy models at update entry
	 *
	 * To process storing a record into database, copy the model passed into a new
	 * model object here.
	 *
	 * @param primaryKey     Primary key
	 * @param entry          model object
	 * @param serviceContext ServiceContext
	 * @return updated entry
	 * @throws PortalException
	 */
	protected SampleSB _updateEntry(
			long primaryKey, SampleSB entry, ServiceContext serviceContext)
		throws PortalException {

		SampleSB updateEntry = fetchSampleSB(primaryKey);

		User user = userLocalService.getUser(entry.getUserId());

		Date now = new Date();
		updateEntry.setCompanyId(entry.getCompanyId());
		updateEntry.setGroupId(entry.getGroupId());
		updateEntry.setUserId(user.getUserId());
		updateEntry.setUserName(user.getFullName());
		updateEntry.setCreateDate(entry.getCreateDate());
		updateEntry.setModifiedDate(now);

		updateEntry.setUuid(entry.getUuid());
		String urlTitle = entry.getSamplesbTitleName();
		if (Validator.isNotNull(urlTitle)) {
			long classNameId = _classNameLocalService.getClassNameId(
				SampleSB.class);

			try{
				_friendlyURLEntryLocalService.validate(
				entry.getGroupId(), classNameId, primaryKey, entry.getSamplesbTitleName());
			} catch(DuplicateFriendlyURLEntryException e) {
				List<String> error = new ArrayList<String>();
				error.add("duplicated-url-title");
				throw new SampleSBValidateException(error);
			}
		}
		else {
			urlTitle = getUniqueUrlTitle(entry, urlTitle);
		}

		if (!urlTitle.equals(entry.getUrlTitle())) {
			urlTitle = updateFriendlyURLs(entry, urlTitle, serviceContext);
		}

		updateEntry.setUrlTitle(
			getUniqueUrlTitle(updateEntry, urlTitle));

		updateEntry.setSamplesbTitleName(entry.getSamplesbTitleName());
		updateEntry.setSamplesbSummaryName(entry.getSamplesbSummaryName());

/*   */
        updateEntry.setSamplesbId(entry.getSamplesbId());
        updateEntry.setTitle(entry.getTitle());
        updateEntry.setSamplesbBooleanStat(entry.getSamplesbBooleanStat());
        updateEntry.setSamplesbDateTime(entry.getSamplesbDateTime());
        updateEntry.setSamplesbDocumentLibrary(entry.getSamplesbDocumentLibrary());
        updateEntry.setSamplesbDouble(entry.getSamplesbDouble());
        updateEntry.setSamplesbInteger(entry.getSamplesbInteger());
        updateEntry.setSamplesbRichText(entry.getSamplesbRichText());
        updateEntry.setSamplesbText(entry.getSamplesbText());
/*  */ 

		return updateEntry;
	}

	/**
	* Update Friendly URLs
	*
	* @param entry SampleSB
	* @param urlTitle
	* @param serviceContext
	* @return string
	* @throws PortalException
	*/
	protected String updateFriendlyURLs(
		SampleSB entry, String urlTitle,
		ServiceContext serviceContext)
		throws PortalException {

		if (ExportImportThreadLocal.isImportInProcess() ||
			ExportImportThreadLocal.isStagingInProcess()) {

			return urlTitle;
		}

		List<FriendlyURLEntry> friendlyURLEntries =
		_friendlyURLEntryLocalService.getFriendlyURLEntries(
			entry.getGroupId(),
			classNameLocalService.getClassNameId(SampleSB.class),
			entry.getPrimaryKey());

		FriendlyURLEntry newFriendlyURLEntry =
			_friendlyURLEntryLocalService.addFriendlyURLEntry(
				entry.getGroupId(),
				classNameLocalService.getClassNameId(SampleSB.class),
				entry.getPrimaryKey(), urlTitle, serviceContext);

		for (FriendlyURLEntry friendlyURLEntry : friendlyURLEntries) {
			if (newFriendlyURLEntry.getFriendlyURLEntryId() ==
				friendlyURLEntry.getFriendlyURLEntryId()) {

				continue;
			}

			_friendlyURLEntryLocalService.deleteFriendlyURLEntry(friendlyURLEntry);
		}

		return newFriendlyURLEntry.getUrlTitle();
	}

	/**
	 * Delete discussion (comments)
	 *
	 * @param entry
	 * @throws PortalException
	 */
	protected void deleteDiscussion(SampleSB entry) throws PortalException {
		CommentManagerUtil.deleteDiscussion(
			SampleSB.class.getName(), entry.getPrimaryKey());
	}

	/**
	 * Generating a unique URL for asset
	 */
	protected String getUniqueUrlTitle(SampleSB entry, String newTitle) {
		long entryId = entry.getPrimaryKey();

		String urlTitle = null;

		if (newTitle == null || newTitle.equals("")) {
			urlTitle = String.valueOf(entryId);
		}
		else {
			urlTitle = StringUtil.toLowerCase(newTitle.trim());

			if (Validator.isNull(urlTitle) || Validator.isNumber(urlTitle) ||
				urlTitle.equals("rss")) {

				urlTitle = String.valueOf(entryId);
			}
			else {
				urlTitle =
					FriendlyURLNormalizerUtil.normalizeWithPeriodsAndSlashes(
						urlTitle);
			}

			urlTitle = ModelHintsUtil.trimString(
				SampleSB.class.getName(), "urlTitle", urlTitle);
		}

		long classNameId = _classNameLocalService.getClassNameId(
			SampleSB.class);

		return _friendlyURLEntryLocalService.getUniqueUrlTitle(
			entry.getGroupId(), classNameId, entry.getPrimaryKey(), urlTitle);
	}

	/**
	 * Generating URL Title for unique URL
	 *
	 * @param entryId primaryKey of the model
	 * @param title   title for the asset
	 * @return URL title string
	 */
	protected String getUrlTitle(long entryId, String title) {
		if (title == null) {
			return String.valueOf(entryId);
		}

		title = StringUtil.toLowerCase(title.trim());

		if (Validator.isNull(title) || Validator.isNumber(title)) {
			title = String.valueOf(entryId);
		}
		else {
			title = FriendlyURLNormalizerUtil.normalizeWithPeriodsAndSlashes(
				title);
		}

		return ModelHintsUtil.trimString(
			SampleSB.class.getName(), "urlTitle", title);
	}

	/**
	 * Start workflow
	 *
	 * @param userId         User id of this model's owner
	 * @param entry          model object
	 * @param serviceContext ServiceContext
	 * @return model with workflow configrations.
	 * @throws PortalException
	 */
	protected SampleSB startWorkflowInstance(
			long userId, SampleSB entry, ServiceContext serviceContext)
		throws PortalException {

		Map<String, Serializable> workflowContext = new HashMap<>();

		String userPortraitURL = StringPool.BLANK;
		String userURL = StringPool.BLANK;

		if (serviceContext.getThemeDisplay() != null) {
			User user = userLocalService.getUser(userId);

			userPortraitURL = user.getPortraitURL(
				serviceContext.getThemeDisplay());
			userURL = user.getDisplayURL(serviceContext.getThemeDisplay());
		}

		workflowContext.put(
			WorkflowConstants.CONTEXT_USER_PORTRAIT_URL, userPortraitURL);
		workflowContext.put(WorkflowConstants.CONTEXT_USER_URL, userURL);

		return WorkflowHandlerRegistryUtil.startWorkflowInstance(
			entry.getCompanyId(), entry.getGroupId(), userId,
			SampleSB.class.getName(), entry.getPrimaryKey(), entry,
			serviceContext, workflowContext);
	}

	private static final int[] STATUS_ANY = {
		WorkflowConstants.STATUS_APPROVED, WorkflowConstants.STATUS_DENIED,
		WorkflowConstants.STATUS_DRAFT, WorkflowConstants.STATUS_EXPIRED,
		WorkflowConstants.STATUS_IN_TRASH, WorkflowConstants.STATUS_INACTIVE,
		WorkflowConstants.STATUS_INCOMPLETE, WorkflowConstants.STATUS_PENDING,
		WorkflowConstants.STATUS_SCHEDULED
	};

	private static Logger _log = LoggerFactory.getLogger(
		SampleSBLocalServiceImpl.class);

	@Reference
	private ClassNameLocalService _classNameLocalService;

	@Reference
	private FriendlyURLEntryLocalService _friendlyURLEntryLocalService;

	@Reference
	private Portal _portal;

	@Reference
	private TrashEntryLocalService _trashEntryLocalService;

}
