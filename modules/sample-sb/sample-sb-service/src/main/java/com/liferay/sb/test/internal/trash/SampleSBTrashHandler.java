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

package com.liferay.sb.test.internal.trash;

import com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.model.TrashedModel;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionHelper;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.trash.BaseTrashHandler;
import com.liferay.portal.kernel.trash.TrashHandler;
import com.liferay.portal.kernel.trash.TrashRenderer;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.sb.test.model.SampleSB;
import com.liferay.sb.test.service.SampleSBLocalService;
import com.liferay.trash.constants.TrashActionKeys;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * SampleSB Trash handler
 *
 * @author yasuflatland
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.sb.test.model.SampleSB",
	service = TrashHandler.class
)
public class SampleSBTrashHandler extends BaseTrashHandler {

	@Override
	public void deleteTrashEntry(long classPK) throws PortalException {
		_sampleSBLocalService.deleteEntry(classPK);
	}

	@Override
	public String getClassName() {
		return SampleSB.class.getName();
	}

	@Override
	public String getRestoreContainedModelLink(
			PortletRequest portletRequest, long classPK)
		throws PortalException {

		SampleSB entry = _sampleSBLocalService.getSampleSB(classPK);

		PortletURL portletURL = getRestoreURL(portletRequest, classPK, false);

		portletURL.setParameter("urlTitle", entry.getUrlTitle());
		portletURL.setParameter(Constants.CMD, Constants.UPDATE);
		portletURL.setParameter(
			"resourcePrimKey", String.valueOf(entry.getPrimaryKey()));

		return portletURL.toString();
	}

	@Override
	public String getRestoreContainerModelLink(
			PortletRequest portletRequest, long classPK)
		throws PortalException {

		PortletURL portletURL = getRestoreURL(portletRequest, classPK, true);

		return portletURL.toString();
	}

	@Override
	public String getRestoreMessage(
		PortletRequest portletRequest, long classPK) {

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		return themeDisplay.translate("samplesb");
	}

	@Override
	public TrashedModel getTrashedModel(long classPK) {
		return _sampleSBLocalService.fetchSampleSB(classPK);
	}

	@Override
	public TrashRenderer getTrashRenderer(long classPK) throws PortalException {
		AssetRendererFactory<SampleSB> assetRendererFactory =
			AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClass(
				SampleSB.class);

		SampleSB entry = _sampleSBLocalService.getSampleSB(classPK);

		return (TrashRenderer)assetRendererFactory.getAssetRenderer(
			entry.getPrimaryKey());
	}

	@Override
	public boolean hasTrashPermission(
			PermissionChecker permissionChecker, long groupId, long classPK,
			String trashActionId)
		throws PortalException {

		if (trashActionId.equals(TrashActionKeys.MOVE)) {
			return ModelResourcePermissionHelper.contains(
				_sampleSBModelResourcePermission, permissionChecker, groupId,
				classPK, ActionKeys.ADD_ENTRY);
		}

		return super.hasTrashPermission(
			permissionChecker, groupId, classPK, trashActionId);
	}

	@Override
	public boolean isInTrash(long classPK) throws PortalException {
		SampleSB entry = _sampleSBLocalService.getSampleSB(classPK);

		return entry.isInTrash();
	}

	@Override
	public boolean isRestorable(long classPK) throws PortalException {
		SampleSB entry = _sampleSBLocalService.getSampleSB(classPK);

		if (!hasTrashPermission(
				PermissionThreadLocal.getPermissionChecker(),
				entry.getGroupId(), classPK, TrashActionKeys.RESTORE)) {

			return false;
		}

		return !entry.isInTrashContainer();
	}

	@Override
	public void restoreTrashEntry(long userId, long classPK)
		throws PortalException {

		_sampleSBLocalService.restoreEntryFromTrash(userId, classPK);
	}

	/**
	 * Get Restore URL
	 *
	 * @param portletRequest
	 * @param classPK
	 * @param containerModel
	 * @return
	 * @throws PortalException
	 */
	protected PortletURL getRestoreURL(
			PortletRequest portletRequest, long classPK, boolean containerModel)
		throws PortalException {

		PortletURL portletURL = null;

		SampleSB entry = _sampleSBLocalService.getSampleSB(classPK);
		String portletId = PortletProviderUtil.getPortletId(
			SampleSB.class.getName(), PortletProvider.Action.VIEW);

		long plid = _portal.getPlidFromPortletId(entry.getGroupId(), portletId);

		if (plid == LayoutConstants.DEFAULT_PLID) {
			portletId = PortletProviderUtil.getPortletId(
				SampleSB.class.getName(), PortletProvider.Action.MANAGE);

			portletURL = _portal.getControlPanelPortletURL(
				portletRequest, portletId, PortletRequest.RENDER_PHASE);
		}
		else {
			portletURL = PortletURLFactoryUtil.create(
				portletRequest, portletId, plid, PortletRequest.RENDER_PHASE);
		}

		if (!containerModel) {
			portletURL.setParameter("mvcRenderCommandName", "/samplesb/view");
		}

		return portletURL;
	}

	@Override
	protected boolean hasPermission(
			PermissionChecker permissionChecker, long classPK, String actionId)
		throws PortalException {

		return _sampleSBModelResourcePermission.contains(
			permissionChecker, classPK, actionId);
	}

	@Reference
	private Portal _portal;

	@Reference
	private SampleSBLocalService _sampleSBLocalService;

	@Reference(target = "(model.class.name=com.liferay.sb.test.model.SampleSB)")
	private ModelResourcePermission<SampleSB> _sampleSBModelResourcePermission;

}