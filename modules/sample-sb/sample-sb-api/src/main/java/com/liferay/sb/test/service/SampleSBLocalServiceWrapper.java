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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SampleSBLocalService}.
 *
 * @author "yasuflatland"
 * @see SampleSBLocalService
 * @generated
 */
public class SampleSBLocalServiceWrapper
	implements SampleSBLocalService, ServiceWrapper<SampleSBLocalService> {

	public SampleSBLocalServiceWrapper(
		SampleSBLocalService sampleSBLocalService) {

		_sampleSBLocalService = sampleSBLocalService;
	}

	/**
	 * Add Entry
	 *
	 * @param primaryKey
	 * @param title
	 * @param samplesbBooleanStat
	 * @param samplesbDateTime
	 * @param samplesbDocumentLibrary
	 * @param samplesbDouble
	 * @param samplesbInteger
	 * @param samplesbRichText
	 * @param samplesbText
	 * @param samplesbTitleName
	 * @param samplesbSummaryName
	 * @param serviceContext
	 * @return
	 * @throws SampleSBValidateException
	 * @throws ParseException
	 */
	@Override
	public com.liferay.sb.test.model.SampleSB addEntry(
			long primaryKey, String title, boolean samplesbBooleanStat,
			String samplesbDateTime, String samplesbDocumentLibrary,
			double samplesbDouble, int samplesbInteger, String samplesbRichText,
			String samplesbText, String samplesbTitleName,
			String samplesbSummaryName,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.sb.test.exception.SampleSBValidateException,
			   java.text.ParseException {

		return _sampleSBLocalService.addEntry(
			primaryKey, title, samplesbBooleanStat, samplesbDateTime,
			samplesbDocumentLibrary, samplesbDouble, samplesbInteger,
			samplesbRichText, samplesbText, samplesbTitleName,
			samplesbSummaryName, serviceContext);
	}

	/**
	 * Add Entry
	 *
	 * @param orgEntry       SampleSB model
	 * @param serviceContext ServiceContext
	 * @exception PortalException
	 * @exception SampleSBValidateException
	 * @return created SampleSB model.
	 */
	@Override
	public com.liferay.sb.test.model.SampleSB addEntry(
			com.liferay.sb.test.model.SampleSB orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.sb.test.exception.SampleSBValidateException {

		return _sampleSBLocalService.addEntry(orgEntry, serviceContext);
	}

	@Override
	public void addEntryResources(
			long entryId, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_sampleSBLocalService.addEntryResources(
			entryId, addGroupPermissions, addGuestPermissions);
	}

	@Override
	public void addEntryResources(
			long entryId,
			com.liferay.portal.kernel.service.permission.ModelPermissions
				modelPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_sampleSBLocalService.addEntryResources(entryId, modelPermissions);
	}

	@Override
	public void addEntryResources(
			com.liferay.sb.test.model.SampleSB entry,
			boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_sampleSBLocalService.addEntryResources(
			entry, addGroupPermissions, addGuestPermissions);
	}

	@Override
	public void addEntryResources(
			com.liferay.sb.test.model.SampleSB entry,
			com.liferay.portal.kernel.service.permission.ModelPermissions
				modelPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_sampleSBLocalService.addEntryResources(entry, modelPermissions);
	}

	/**
	 * Adds the sample sb to the database. Also notifies the appropriate model listeners.
	 *
	 * @param sampleSB the sample sb
	 * @return the sample sb that was added
	 */
	@Override
	public com.liferay.sb.test.model.SampleSB addSampleSB(
		com.liferay.sb.test.model.SampleSB sampleSB) {

		return _sampleSBLocalService.addSampleSB(sampleSB);
	}

	@Override
	public int countAllInGroup(long groupId) {
		return _sampleSBLocalService.countAllInGroup(groupId);
	}

	@Override
	public int countAllInGroup(long groupId, int[] status) {
		return _sampleSBLocalService.countAllInGroup(groupId, status);
	}

	@Override
	public int countAllInUser(long userId) {
		return _sampleSBLocalService.countAllInUser(userId);
	}

	@Override
	public int countAllInUser(long userId, int[] status) {
		return _sampleSBLocalService.countAllInUser(userId, status);
	}

	@Override
	public int countAllInUserAndGroup(long userId, long groupId) {
		return _sampleSBLocalService.countAllInUserAndGroup(userId, groupId);
	}

	@Override
	public int countAllInUserAndGroup(long userId, long groupId, int[] status) {
		return _sampleSBLocalService.countAllInUserAndGroup(
			userId, groupId, status);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleSBLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sample sb with the primary key. Does not add the sample sb to the database.
	 *
	 * @param samplesbId the primary key for the new sample sb
	 * @return the new sample sb
	 */
	@Override
	public com.liferay.sb.test.model.SampleSB createSampleSB(long samplesbId) {
		return _sampleSBLocalService.createSampleSB(samplesbId);
	}

	/**
	 * Delete entry
	 */
	@Override
	public com.liferay.sb.test.model.SampleSB deleteEntry(long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleSBLocalService.deleteEntry(primaryKey);
	}

	/**
	 * Delete entry
	 *
	 * @param entry SampleSB
	 * @return SampleSB oject
	 * @exception PortalException
	 */
	@Override
	public com.liferay.sb.test.model.SampleSB deleteEntry(
			com.liferay.sb.test.model.SampleSB entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleSBLocalService.deleteEntry(entry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleSBLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the sample sb with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param samplesbId the primary key of the sample sb
	 * @return the sample sb that was removed
	 * @throws PortalException if a sample sb with the primary key could not be found
	 */
	@Override
	public com.liferay.sb.test.model.SampleSB deleteSampleSB(long samplesbId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleSBLocalService.deleteSampleSB(samplesbId);
	}

	/**
	 * Deletes the sample sb from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sampleSB the sample sb
	 * @return the sample sb that was removed
	 */
	@Override
	public com.liferay.sb.test.model.SampleSB deleteSampleSB(
		com.liferay.sb.test.model.SampleSB sampleSB) {

		return _sampleSBLocalService.deleteSampleSB(sampleSB);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _sampleSBLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _sampleSBLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _sampleSBLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _sampleSBLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _sampleSBLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _sampleSBLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.sb.test.model.SampleSB fetchSampleSB(long samplesbId) {
		return _sampleSBLocalService.fetchSampleSB(samplesbId);
	}

	/**
	 * Returns the sample sb matching the UUID and group.
	 *
	 * @param uuid the sample sb's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public com.liferay.sb.test.model.SampleSB fetchSampleSBByUuidAndGroupId(
		String uuid, long groupId) {

		return _sampleSBLocalService.fetchSampleSBByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.SampleSB> findAllInGroup(
		long groupId) {

		return _sampleSBLocalService.findAllInGroup(groupId);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.SampleSB> findAllInGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.sb.test.model.SampleSB> orderByComparator) {

		return _sampleSBLocalService.findAllInGroup(
			groupId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.SampleSB> findAllInGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.sb.test.model.SampleSB> orderByComparator,
		int[] status) {

		return _sampleSBLocalService.findAllInGroup(
			groupId, start, end, orderByComparator, status);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.SampleSB> findAllInGroup(
		long groupId, int[] status) {

		return _sampleSBLocalService.findAllInGroup(groupId, status);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.SampleSB> findAllInGroup(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.sb.test.model.SampleSB> orderByComparator) {

		return _sampleSBLocalService.findAllInGroup(groupId, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.SampleSB> findAllInUser(
		long userId) {

		return _sampleSBLocalService.findAllInUser(userId);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.SampleSB> findAllInUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.sb.test.model.SampleSB> orderByComparator) {

		return _sampleSBLocalService.findAllInUser(
			userId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.SampleSB> findAllInUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.sb.test.model.SampleSB> orderByComparator,
		int[] status) {

		return _sampleSBLocalService.findAllInUser(
			userId, start, end, orderByComparator, status);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.SampleSB> findAllInUser(
		long userId, int[] status) {

		return _sampleSBLocalService.findAllInUser(userId, status);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.SampleSB> findAllInUser(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.sb.test.model.SampleSB> orderByComparator) {

		return _sampleSBLocalService.findAllInUser(userId, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.SampleSB>
		findAllInUserAndGroup(long userId, long groupId) {

		return _sampleSBLocalService.findAllInUserAndGroup(userId, groupId);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.SampleSB>
		findAllInUserAndGroup(
			long userId, long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.sb.test.model.SampleSB> orderByComparator) {

		return _sampleSBLocalService.findAllInUserAndGroup(
			userId, groupId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.SampleSB>
		findAllInUserAndGroup(
			long userId, long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.sb.test.model.SampleSB> orderByComparator,
			int[] status) {

		return _sampleSBLocalService.findAllInUserAndGroup(
			userId, groupId, start, end, orderByComparator, status);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.SampleSB>
		findAllInUserAndGroup(long userId, long groupId, int[] status) {

		return _sampleSBLocalService.findAllInUserAndGroup(
			userId, groupId, status);
	}

	@Override
	public java.util.List<com.liferay.sb.test.model.SampleSB>
		findAllInUserAndGroup(
			long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.sb.test.model.SampleSB> orderByComparator) {

		return _sampleSBLocalService.findAllInUserAndGroup(
			userId, groupId, orderByComparator);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _sampleSBLocalService.getActionableDynamicQuery();
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
	@Override
	public java.util.List<com.liferay.sb.test.model.SampleSB> getCompanyEntries(
		long companyId, int status, int start, int end) {

		return _sampleSBLocalService.getCompanyEntries(
			companyId, status, start, end);
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
	@Override
	public java.util.List<com.liferay.sb.test.model.SampleSB> getCompanyEntries(
		long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.sb.test.model.SampleSB> obc) {

		return _sampleSBLocalService.getCompanyEntries(
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
	@Override
	public int getCompanyEntriesCount(long companyId, int status) {
		return _sampleSBLocalService.getCompanyEntriesCount(companyId, status);
	}

	/**
	 * Converte Date Time into Date()
	 *
	 * @param request PortletRequest
	 * @param prefix  Prefix of the parameter
	 * @return Date object
	 */
	@Override
	public java.util.Date getDateTimeFromRequest(
		javax.portlet.PortletRequest request, String prefix) {

		return _sampleSBLocalService.getDateTimeFromRequest(request, prefix);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _sampleSBLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _sampleSBLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param primaryKey primary key
	 * @param request    PortletRequest
	 * @return SampleSB Object
	 * @throws PortletException
	 */
	@Override
	public com.liferay.sb.test.model.SampleSB getInitializedSampleSB(
			long primaryKey, javax.portlet.PortletRequest request)
		throws javax.portlet.PortletException {

		return _sampleSBLocalService.getInitializedSampleSB(
			primaryKey, request);
	}

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return SampleSB object
	 * @throws PortletException
	 */
	@Override
	public com.liferay.sb.test.model.SampleSB getNewObject(long primaryKey) {
		return _sampleSBLocalService.getNewObject(primaryKey);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _sampleSBLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleSBLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sample sb with the primary key.
	 *
	 * @param samplesbId the primary key of the sample sb
	 * @return the sample sb
	 * @throws PortalException if a sample sb with the primary key could not be found
	 */
	@Override
	public com.liferay.sb.test.model.SampleSB getSampleSB(long samplesbId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleSBLocalService.getSampleSB(samplesbId);
	}

	/**
	 * Get Entity
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	@Override
	public com.liferay.sb.test.model.SampleSB getSampleSB(
			long groupId, String urlTitle)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleSBLocalService.getSampleSB(groupId, urlTitle);
	}

	/**
	 * Returns the sample sb matching the UUID and group.
	 *
	 * @param uuid the sample sb's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sample sb
	 * @throws PortalException if a matching sample sb could not be found
	 */
	@Override
	public com.liferay.sb.test.model.SampleSB getSampleSBByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleSBLocalService.getSampleSBByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return SampleSB Object
	 * @throws PortletException
	 * @throws SampleSBValidateException
	 */
	@Override
	public com.liferay.sb.test.model.SampleSB getSampleSBFromRequest(
			long primaryKey, javax.portlet.PortletRequest request)
		throws com.liferay.sb.test.exception.SampleSBValidateException,
			   javax.portlet.PortletException {

		return _sampleSBLocalService.getSampleSBFromRequest(
			primaryKey, request);
	}

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
	@Override
	public java.util.List<com.liferay.sb.test.model.SampleSB> getSampleSBs(
		int start, int end) {

		return _sampleSBLocalService.getSampleSBs(start, end);
	}

	/**
	 * Returns all the sample sbs matching the UUID and company.
	 *
	 * @param uuid the UUID of the sample sbs
	 * @param companyId the primary key of the company
	 * @return the matching sample sbs, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.liferay.sb.test.model.SampleSB>
		getSampleSBsByUuidAndCompanyId(String uuid, long companyId) {

		return _sampleSBLocalService.getSampleSBsByUuidAndCompanyId(
			uuid, companyId);
	}

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
	@Override
	public java.util.List<com.liferay.sb.test.model.SampleSB>
		getSampleSBsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.sb.test.model.SampleSB> orderByComparator) {

		return _sampleSBLocalService.getSampleSBsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of sample sbs.
	 *
	 * @return the number of sample sbs
	 */
	@Override
	public int getSampleSBsCount() {
		return _sampleSBLocalService.getSampleSBsCount();
	}

	/**
	 * Get STATUS_ANY for DB
	 *
	 * This is equivalent of WorkflowConstants.STATUS_ANY
	 *
	 * @return All statuses for Workflow
	 */
	@Override
	public int[] getStatusAny() {
		return _sampleSBLocalService.getStatusAny();
	}

	@Override
	public com.liferay.sb.test.model.SampleSB moveEntryToTrash(
			long userId, long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleSBLocalService.moveEntryToTrash(userId, entryId);
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
	@Override
	public com.liferay.sb.test.model.SampleSB moveEntryToTrash(
			long userId, com.liferay.sb.test.model.SampleSB entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleSBLocalService.moveEntryToTrash(userId, entry);
	}

	/**
	 * Restores the entry with the ID from the recycle bin. Social activity counters
	 * for this entry get activated.
	 *
	 * @param userId  the primary key of the user restoring the entry
	 * @param entryId the primary key of the entry to be restored
	 * @return the restored entry from the recycle bin
	 */
	@Override
	public com.liferay.sb.test.model.SampleSB restoreEntryFromTrash(
			long userId, long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleSBLocalService.restoreEntryFromTrash(userId, entryId);
	}

	/**
	 * To LocalDateTime
	 *
	 * @param date
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	@Override
	public java.util.Date toLocalDateTime(String date, String format)
		throws java.text.ParseException {

		return _sampleSBLocalService.toLocalDateTime(date, format);
	}

	@Override
	public void updateAsset(
			long userId, com.liferay.sb.test.model.SampleSB entry,
			long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds, Double priority)
		throws com.liferay.portal.kernel.exception.PortalException {

		_sampleSBLocalService.updateAsset(
			userId, entry, assetCategoryIds, assetTagNames, assetLinkEntryIds,
			priority);
	}

	/**
	 * Update Entry
	 *
	 * @param primaryKey
	 * @param title
	 * @param samplesbBooleanStat
	 * @param samplesbDateTime
	 * @param samplesbDocumentLibrary
	 * @param samplesbDouble
	 * @param samplesbInteger
	 * @param samplesbRichText
	 * @param samplesbText
	 * @param samplesbTitleName
	 * @param samplesbSummaryName
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 * @throws SampleSBValidateException
	 * @throws ParseException
	 */
	@Override
	public com.liferay.sb.test.model.SampleSB updateEntry(
			long primaryKey, String title, boolean samplesbBooleanStat,
			String samplesbDateTime, String samplesbDocumentLibrary,
			double samplesbDouble, int samplesbInteger, String samplesbRichText,
			String samplesbText, String samplesbTitleName,
			String samplesbSummaryName,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.sb.test.exception.SampleSBValidateException,
			   java.text.ParseException {

		return _sampleSBLocalService.updateEntry(
			primaryKey, title, samplesbBooleanStat, samplesbDateTime,
			samplesbDocumentLibrary, samplesbDouble, samplesbInteger,
			samplesbRichText, samplesbText, samplesbTitleName,
			samplesbSummaryName, serviceContext);
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
	@Override
	public com.liferay.sb.test.model.SampleSB updateEntry(
			com.liferay.sb.test.model.SampleSB orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.sb.test.exception.SampleSBValidateException {

		return _sampleSBLocalService.updateEntry(orgEntry, serviceContext);
	}

	@Override
	public void updateEntryResources(
			com.liferay.sb.test.model.SampleSB entry, String[] groupPermissions,
			String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_sampleSBLocalService.updateEntryResources(
			entry, groupPermissions, guestPermissions);
	}

	/**
	 * Updates the sample sb in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param sampleSB the sample sb
	 * @return the sample sb that was updated
	 */
	@Override
	public com.liferay.sb.test.model.SampleSB updateSampleSB(
		com.liferay.sb.test.model.SampleSB sampleSB) {

		return _sampleSBLocalService.updateSampleSB(sampleSB);
	}

	@Override
	public com.liferay.sb.test.model.SampleSB updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleSBLocalService.updateStatus(
			userId, entryId, status, serviceContext, workflowContext);
	}

	@Override
	public SampleSBLocalService getWrappedService() {
		return _sampleSBLocalService;
	}

	@Override
	public void setWrappedService(SampleSBLocalService sampleSBLocalService) {
		_sampleSBLocalService = sampleSBLocalService;
	}

	private SampleSBLocalService _sampleSBLocalService;

}