/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.sb.test.service;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.permission.ModelPermissions;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.sb.test.exception.SampleSBValidateException;
import com.liferay.sb.test.model.SampleSB;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for SampleSB. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author "yasuflatland"
 * @see SampleSBLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SampleSBLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SampleSBLocalServiceUtil} to access the sample sb local service. Add custom service methods to <code>com.liferay.sb.test.service.impl.SampleSBLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

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
	public SampleSB addEntry(SampleSB orgEntry, ServiceContext serviceContext)
		throws PortalException, SampleSBValidateException;

	public void addEntryResources(
			long entryId, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException;

	public void addEntryResources(
			long entryId, ModelPermissions modelPermissions)
		throws PortalException;

	public void addEntryResources(
			SampleSB entry, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException;

	public void addEntryResources(
			SampleSB entry, ModelPermissions modelPermissions)
		throws PortalException;

	/**
	 * Adds the sample sb to the database. Also notifies the appropriate model listeners.
	 *
	 * @param sampleSB the sample sb
	 * @return the sample sb that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SampleSB addSampleSB(SampleSB sampleSB);

	public int countAllInGroup(long groupId);

	public int countAllInGroup(long groupId, int[] status);

	public int countAllInUser(long userId);

	public int countAllInUser(long userId, int[] status);

	public int countAllInUserAndGroup(long userId, long groupId);

	public int countAllInUserAndGroup(long userId, long groupId, int[] status);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new sample sb with the primary key. Does not add the sample sb to the database.
	 *
	 * @param samplesbId the primary key for the new sample sb
	 * @return the new sample sb
	 */
	@Transactional(enabled = false)
	public SampleSB createSampleSB(long samplesbId);

	/**
	 * Delete entry
	 */
	public SampleSB deleteEntry(long primaryKey) throws PortalException;

	/**
	 * Delete entry
	 *
	 * @param entry SampleSB
	 * @return SampleSB oject
	 * @exception PortalException
	 */
	@Indexable(type = IndexableType.DELETE)
	@SystemEvent(type = SystemEventConstants.TYPE_DELETE)
	public SampleSB deleteEntry(SampleSB entry) throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the sample sb with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param samplesbId the primary key of the sample sb
	 * @return the sample sb that was removed
	 * @throws PortalException if a sample sb with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public SampleSB deleteSampleSB(long samplesbId) throws PortalException;

	/**
	 * Deletes the sample sb from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sampleSB the sample sb
	 * @return the sample sb that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public SampleSB deleteSampleSB(SampleSB sampleSB);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sb.test.model.impl.SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sb.test.model.impl.SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SampleSB fetchSampleSB(long samplesbId);

	/**
	 * Returns the sample sb matching the UUID and group.
	 *
	 * @param uuid the sample sb's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SampleSB fetchSampleSBByUuidAndGroupId(String uuid, long groupId);

	public List<SampleSB> findAllInGroup(long groupId);

	public List<SampleSB> findAllInGroup(
		long groupId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator);

	public List<SampleSB> findAllInGroup(
		long groupId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, int[] status);

	public List<SampleSB> findAllInGroup(long groupId, int[] status);

	public List<SampleSB> findAllInGroup(
		long groupId, OrderByComparator<SampleSB> orderByComparator);

	public List<SampleSB> findAllInUser(long userId);

	public List<SampleSB> findAllInUser(
		long userId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator);

	public List<SampleSB> findAllInUser(
		long userId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, int[] status);

	public List<SampleSB> findAllInUser(long userId, int[] status);

	public List<SampleSB> findAllInUser(
		long userId, OrderByComparator<SampleSB> orderByComparator);

	public List<SampleSB> findAllInUserAndGroup(long userId, long groupId);

	public List<SampleSB> findAllInUserAndGroup(
		long userId, long groupId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator);

	public List<SampleSB> findAllInUserAndGroup(
		long userId, long groupId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, int[] status);

	public List<SampleSB> findAllInUserAndGroup(
		long userId, long groupId, int[] status);

	public List<SampleSB> findAllInUserAndGroup(
		long userId, long groupId,
		OrderByComparator<SampleSB> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SampleSB> getCompanyEntries(
		long companyId, int status, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SampleSB> getCompanyEntries(
		long companyId, int status, int start, int end,
		OrderByComparator<SampleSB> obc);

	/**
	 * Get Company entries counts
	 *
	 * @param companyId
	 * @param status
	 * @return
	 * @throws SystemException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCompanyEntriesCount(long companyId, int status);

	/**
	 * Converte Date Time into Date()
	 *
	 * @param request PortletRequest
	 * @param prefix  Prefix of the parameter
	 * @return Date object
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Date getDateTimeFromRequest(PortletRequest request, String prefix);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Populate Model with values from a form
	 *
	 * @param primaryKey primary key
	 * @param request    PortletRequest
	 * @return SampleSB Object
	 * @throws PortletException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SampleSB getInitializedSampleSB(
			long primaryKey, PortletRequest request)
		throws PortletException;

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return SampleSB object
	 * @throws PortletException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SampleSB getNewObject(long primaryKey);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the sample sb with the primary key.
	 *
	 * @param samplesbId the primary key of the sample sb
	 * @return the sample sb
	 * @throws PortalException if a sample sb with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SampleSB getSampleSB(long samplesbId) throws PortalException;

	/**
	 * Get Entity
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SampleSB getSampleSB(long groupId, String urlTitle)
		throws PortalException;

	/**
	 * Returns the sample sb matching the UUID and group.
	 *
	 * @param uuid the sample sb's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sample sb
	 * @throws PortalException if a matching sample sb could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SampleSB getSampleSBByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return SampleSB Object
	 * @throws PortletException
	 * @throws SampleSBValidateException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SampleSB getSampleSBFromRequest(
			long primaryKey, PortletRequest request)
		throws PortletException, SampleSBValidateException;

	/**
	 * Returns a range of all the sample sbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sb.test.model.impl.SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of sample sbs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SampleSB> getSampleSBs(int start, int end);

	/**
	 * Returns all the sample sbs matching the UUID and company.
	 *
	 * @param uuid the UUID of the sample sbs
	 * @param companyId the primary key of the company
	 * @return the matching sample sbs, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SampleSB> getSampleSBsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of sample sbs matching the UUID and company.
	 *
	 * @param uuid the UUID of the sample sbs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching sample sbs, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SampleSB> getSampleSBsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator);

	/**
	 * Returns the number of sample sbs.
	 *
	 * @return the number of sample sbs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSampleSBsCount();

	/**
	 * Get STATUS_ANY for DB
	 *
	 * This is equivalent of WorkflowConstants.STATUS_ANY
	 *
	 * @return All statuses for Workflow
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int[] getStatusAny();

	public SampleSB moveEntryToTrash(long userId, long entryId)
		throws PortalException;

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
	public SampleSB moveEntryToTrash(long userId, SampleSB entry)
		throws PortalException;

	/**
	 * Restores the entry with the ID from the recycle bin. Social activity counters
	 * for this entry get activated.
	 *
	 * @param userId  the primary key of the user restoring the entry
	 * @param entryId the primary key of the entry to be restored
	 * @return the restored entry from the recycle bin
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SampleSB restoreEntryFromTrash(long userId, long entryId)
		throws PortalException;

	public void updateAsset(
			long userId, SampleSB entry, long[] assetCategoryIds,
			String[] assetTagNames, long[] assetLinkEntryIds, Double priority)
		throws PortalException;

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
	public SampleSB updateEntry(
			SampleSB orgEntry, ServiceContext serviceContext)
		throws PortalException, SampleSBValidateException;

	public void updateEntryResources(
			SampleSB entry, String[] groupPermissions,
			String[] guestPermissions)
		throws PortalException;

	/**
	 * Updates the sample sb in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param sampleSB the sample sb
	 * @return the sample sb that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SampleSB updateSampleSB(SampleSB sampleSB);

	@Indexable(type = IndexableType.REINDEX)
	public SampleSB updateStatus(
			long userId, long entryId, int status,
			ServiceContext serviceContext,
			Map<String, Serializable> workflowContext)
		throws PortalException;

}