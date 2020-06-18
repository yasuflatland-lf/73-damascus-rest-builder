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

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.sb.test.constants.SampleSBConstants;
import com.liferay.sb.test.exception.SampleSBValidateException;
import com.liferay.sb.test.model.SampleSB;
import com.liferay.sb.test.service.base.SampleSBServiceBaseImpl;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * The implementation of the SampleSB remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.sb.test.service.SampleSBService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author yasuflatland
 * @see SampleSBServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=samplesb",
		"json.web.service.context.path=SampleSB"
	},
	service = AopService.class
)
public class SampleSBServiceImpl extends SampleSBServiceBaseImpl {

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
	public SampleSB addEntry(SampleSB orgEntry, ServiceContext serviceContext)
		throws PortalException, SampleSBValidateException {

		_portletResourcePermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.ADD_ENTRY);

		return sampleSBLocalService.addEntry(orgEntry, serviceContext);
	}

	/**
	 * Delete Entry
	 *
	 * @param primaryKey
	 * @return SampleSB
	 * @throws PortalException
	 */
	public void deleteEntry(long primaryKey) throws PortalException {
		_sampleSBModelResourcePermission.check(
			getPermissionChecker(), primaryKey, ActionKeys.DELETE);

		sampleSBLocalService.deleteEntry(primaryKey);
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
	public SampleSB getInitializedSampleSB(
			long primaryKey, PortletRequest request)
		throws PortalException, PortletException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			request);

		_portletResourcePermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.ADD_ENTRY);

		return sampleSBLocalService.getNewObject(primaryKey);
	}

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return ServiceContext serviceContext
	 * @throws PrincipalException
	 * @throws PortletException
	 */
	public SampleSB getNewObject(long primaryKey, ServiceContext serviceContext)
		throws PrincipalException {

		primaryKey = (primaryKey <= 0) ? 0 :
		counterLocalService.increment(SampleSB.class.getName());

		_portletResourcePermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.UPDATE);

		return sampleSBLocalService.getNewObject(primaryKey);
	}

	/**
	 * Returns the samplesb with the primary key.
	 *
	 * @param samplesbId the primary key of the sample sb
	 * @return the samplesb
	 * @throws PortalException if a samplesb with the primary key could not be found
	 */
	@Override
	public SampleSB getSampleSB(long primaryKey) throws PortalException {
		_sampleSBModelResourcePermission.check(
			getPermissionChecker(), primaryKey, ActionKeys.VIEW);

		return sampleSBLocalService.getSampleSB(primaryKey);
	}

	/**
	 * Returns the samplesb
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	public SampleSB getSampleSB(long groupId, String urlTitle)
		throws PortalException {

		SampleSB entry = sampleSBLocalService.getSampleSB(groupId, urlTitle);

		_sampleSBModelResourcePermission.check(
			getPermissionChecker(), entry, ActionKeys.VIEW);

		return entry;
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return SampleSB Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	public SampleSB getSampleSBFromRequest(
			long primaryKey, PortletRequest request)
		throws PortalException, PortletException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			request);

		_portletResourcePermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.VIEW);

		return sampleSBLocalService.getSampleSBFromRequest(primaryKey, request);
	}

	/**
	 * Move an entry to the trush can
	 *
	 * @param userId
	 * @param entryId
	 * @return SampleSB
	 * @throws PortalException
	 */
	public SampleSB moveEntryToTrash(long entryId) throws PortalException {
		_sampleSBModelResourcePermission.check(
			getPermissionChecker(), entryId, ActionKeys.DELETE);

		return sampleSBLocalService.moveEntryToTrash(getUserId(), entryId);
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
	public SampleSB updateEntry(
			SampleSB orgEntry, ServiceContext serviceContext)
		throws PortalException, SampleSBValidateException {

		_sampleSBModelResourcePermission.check(
			getPermissionChecker(), orgEntry.getPrimaryKey(),
			ActionKeys.UPDATE);

		return sampleSBLocalService.updateEntry(orgEntry, serviceContext);
	}

	private static volatile ModelResourcePermission<SampleSB>
		_sampleSBModelResourcePermission =
			ModelResourcePermissionFactory.getInstance(
				SampleSBServiceImpl.class, "_sampleSBModelResourcePermission",
				SampleSB.class);

	@Reference(
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY,
		target = "(resource.name=" + SampleSBConstants.RESOURCE_NAME + ")"
	)
	private volatile PortletResourcePermission _portletResourcePermission;

}