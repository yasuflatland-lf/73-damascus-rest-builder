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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for SampleSB. This utility wraps
 * <code>com.liferay.sb.test.service.impl.SampleSBServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author "yasuflatland"
 * @see SampleSBService
 * @generated
 */
public class SampleSBServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.sb.test.service.impl.SampleSBServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
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
	public static com.liferay.sb.test.model.SampleSB addEntry(
			com.liferay.sb.test.model.SampleSB orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.sb.test.exception.SampleSBValidateException {

		return getService().addEntry(orgEntry, serviceContext);
	}

	/**
	 * Delete Entry
	 *
	 * @param primaryKey
	 * @return SampleSB
	 * @throws PortalException
	 */
	public static void deleteEntry(long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteEntry(primaryKey);
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
	public static com.liferay.sb.test.model.SampleSB getInitializedSampleSB(
			long primaryKey, javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		return getService().getInitializedSampleSB(primaryKey, request);
	}

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return ServiceContext serviceContext
	 * @throws PrincipalException
	 * @throws PortletException
	 */
	public static com.liferay.sb.test.model.SampleSB getNewObject(
			long primaryKey,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return getService().getNewObject(primaryKey, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * Returns the samplesb with the primary key.
	 *
	 * @param samplesbId the primary key of the sample sb
	 * @return the samplesb
	 * @throws PortalException if a samplesb with the primary key could not be found
	 */
	public static com.liferay.sb.test.model.SampleSB getSampleSB(
			long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getSampleSB(primaryKey);
	}

	/**
	 * Returns the samplesb
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	public static com.liferay.sb.test.model.SampleSB getSampleSB(
			long groupId, String urlTitle)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getSampleSB(groupId, urlTitle);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return SampleSB Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	public static com.liferay.sb.test.model.SampleSB getSampleSBFromRequest(
			long primaryKey, javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		return getService().getSampleSBFromRequest(primaryKey, request);
	}

	/**
	 * Move an entry to the trush can
	 *
	 * @param userId
	 * @param entryId
	 * @return SampleSB
	 * @throws PortalException
	 */
	public static com.liferay.sb.test.model.SampleSB moveEntryToTrash(
			long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().moveEntryToTrash(entryId);
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
	public static com.liferay.sb.test.model.SampleSB updateEntry(
			com.liferay.sb.test.model.SampleSB orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.sb.test.exception.SampleSBValidateException {

		return getService().updateEntry(orgEntry, serviceContext);
	}

	public static SampleSBService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SampleSBService, SampleSBService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SampleSBService.class);

		ServiceTracker<SampleSBService, SampleSBService> serviceTracker =
			new ServiceTracker<SampleSBService, SampleSBService>(
				bundle.getBundleContext(), SampleSBService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}