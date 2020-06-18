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
 * Provides a wrapper for {@link SampleSBService}.
 *
 * @author "yasuflatland"
 * @see SampleSBService
 * @generated
 */
public class SampleSBServiceWrapper
	implements SampleSBService, ServiceWrapper<SampleSBService> {

	public SampleSBServiceWrapper(SampleSBService sampleSBService) {
		_sampleSBService = sampleSBService;
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

		return _sampleSBService.addEntry(orgEntry, serviceContext);
	}

	/**
	 * Delete Entry
	 *
	 * @param primaryKey
	 * @return SampleSB
	 * @throws PortalException
	 */
	@Override
	public void deleteEntry(long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		_sampleSBService.deleteEntry(primaryKey);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param primaryKey primary key
	 * @param request    PortletRequest
	 * @return SampleSB Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	@Override
	public com.liferay.sb.test.model.SampleSB getInitializedSampleSB(
			long primaryKey, javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		return _sampleSBService.getInitializedSampleSB(primaryKey, request);
	}

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return ServiceContext serviceContext
	 * @throws PrincipalException
	 * @throws PortletException
	 */
	@Override
	public com.liferay.sb.test.model.SampleSB getNewObject(
			long primaryKey,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _sampleSBService.getNewObject(primaryKey, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _sampleSBService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the samplesb with the primary key.
	 *
	 * @param samplesbId the primary key of the sample sb
	 * @return the samplesb
	 * @throws PortalException if a samplesb with the primary key could not be found
	 */
	@Override
	public com.liferay.sb.test.model.SampleSB getSampleSB(long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleSBService.getSampleSB(primaryKey);
	}

	/**
	 * Returns the samplesb
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

		return _sampleSBService.getSampleSB(groupId, urlTitle);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return SampleSB Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	@Override
	public com.liferay.sb.test.model.SampleSB getSampleSBFromRequest(
			long primaryKey, javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		return _sampleSBService.getSampleSBFromRequest(primaryKey, request);
	}

	/**
	 * Move an entry to the trush can
	 *
	 * @param userId
	 * @param entryId
	 * @return SampleSB
	 * @throws PortalException
	 */
	@Override
	public com.liferay.sb.test.model.SampleSB moveEntryToTrash(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleSBService.moveEntryToTrash(entryId);
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

		return _sampleSBService.updateEntry(orgEntry, serviceContext);
	}

	@Override
	public SampleSBService getWrappedService() {
		return _sampleSBService;
	}

	@Override
	public void setWrappedService(SampleSBService sampleSBService) {
		_sampleSBService = sampleSBService;
	}

	private SampleSBService _sampleSBService;

}