// 
//  //
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
//  //
package com.liferay.sb.test.web.internal.security.permission.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.sb.test.model.SampleSB;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * Entry　Permission
 *
 * @author yasuflatland
 */
@Component(immediate = true, service = {})
public class SampleSBEntryPermission {

	public static boolean contains(
			PermissionChecker permissionChecker, long entryId, String actionId)
		throws PortalException {

		return _sampleSBModelResourcePermission.contains(
			permissionChecker, entryId, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, SampleSB entry,
			String actionId)
		throws PortalException {

		return _sampleSBModelResourcePermission.contains(
			permissionChecker, entry, actionId);
	}

	@Reference(
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY,
		target = "(model.class.name=com.liferay.sb.test.model.SampleSB)"
	)
	protected void setSampleSBModelResourcePermission(
		ModelResourcePermission<SampleSB> modelResourcePermission) {

		_sampleSBModelResourcePermission = modelResourcePermission;
	}

	protected void unsetSampleSBModelResourcePermission(
		ModelResourcePermission<SampleSB> modelResourcePermission) {
	}

	private static ModelResourcePermission<SampleSB>
		_sampleSBModelResourcePermission;

}