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

package com.liferay.sb.test.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.sb.test.constants.SampleSBPortletKeys;
import com.liferay.sb.test.exception.SampleSBValidateException;
import com.liferay.sb.test.model.SampleSB;
import com.liferay.sb.test.service.SampleSBService;
import com.liferay.sb.test.web.constants.SampleSBWebKeys;
import com.liferay.sb.test.web.internal.security.permission.resource.SampleSBEntryPermission;
import com.liferay.sb.test.web.upload.SampleSBItemSelectorHelper;

// //
//  //

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * CRUD Render
 *
 * @author yasuflatland
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SampleSBPortletKeys.SAMPLESB,
		"mvc.command.name=/samplesb/crud"
	},
	service = MVCRenderCommand.class
)
public class SampleSBCrudMVCRenderCommand implements MVCRenderCommand {

	/**
	 * Edit Page JSP file
	 */
	public String getEditPageJSP() {
		return SampleSBWebKeys.EDIT_JSP;
	}

	/**
	 * View Page JSP file
	 */
	public String getViewPageJSP() {
		return SampleSBWebKeys.VIEW_JSP;
	}

	/**
	 * View Record JSP file
	 */
	public String getViewRecordPageJSP() {
		return SampleSBWebKeys.VIEW_RECORD_JSP;
	}

	@Override
	public String render(RenderRequest request, RenderResponse response)
		throws PortletException {

		String renderJSP = getViewPageJSP();

		// Fetch command

		String cmd = ParamUtil.getString(request, Constants.CMD);

		// Fetch primary key

		long primaryKey = ParamUtil.getLong(request, "resourcePrimKey", 0);
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		try {
			if (cmd.equalsIgnoreCase(Constants.UPDATE)) {
				renderJSP = update(request, themeDisplay, primaryKey);
			}
			else if (cmd.equalsIgnoreCase(Constants.VIEW)) {
				renderJSP = view(request, themeDisplay, primaryKey);
			}
			else {
				renderJSP = add(request, themeDisplay, primaryKey);
			}
		}
		catch (PortalException pe) {
			throw new PortletException(pe.getMessage());
		}

//  //
// //
		
		request.setAttribute(
			SampleSBWebKeys.SAMPLESB_ITEM_SELECTOR_HELPER,
			_sampleSBItemSelectorHelper);

		return renderJSP;
	}

	/**
	 * Add record
	 *
	 * @param request
	 * @param themeDisplay
	 * @param primaryKey
	 * @return JSP file path
	 * @throws PortalException
	 * @throws SampleSBValidateException
	 * @throws PortletException
	 */
	protected String add(
			RenderRequest request, ThemeDisplay themeDisplay, long primaryKey)
		throws PortalException, PortletException, SampleSBValidateException {

		SampleSB record = null;

		if (Validator.isNull(request.getParameter("addErrors"))) {
			record = _sampleSBService.getInitializedSampleSB(
				primaryKey, request);
		}
		else {
			record = _sampleSBService.getSampleSBFromRequest(
				primaryKey, request);
		}

		request.setAttribute("sampleSB", record);

		return getEditPageJSP();
	}

	/**
	 * Update record
	 *
	 * @param request
	 * @param themeDisplay
	 * @param primaryKey
	 * @return JSP file path to open
	 * @throws PortalException
	 * @throws SampleSBValidateException
	 */
	protected String update(
			RenderRequest request, ThemeDisplay themeDisplay, long primaryKey)
		throws PortalException, SampleSBValidateException {

		SampleSB record = _sampleSBService.getSampleSB(primaryKey);

		if (!SampleSBEntryPermission.contains(
				themeDisplay.getPermissionChecker(), record,
				ActionKeys.UPDATE)) {

			List<String> error = new ArrayList<>();
			error.add("permission-error");

			throw new SampleSBValidateException(error);
		}

		request.setAttribute("sampleSB", record);

		return getEditPageJSP();
	}

	/**
	 * View record
	 *
	 * @param request
	 * @param themeDisplay
	 * @param primaryKey
	 * @return
	 * @throws PortalException
	 * @throws SampleSBValidateException
	 */
	protected String view(
			RenderRequest request, ThemeDisplay themeDisplay, long primaryKey)
		throws PortalException, SampleSBValidateException {

		SampleSB record = _sampleSBService.getSampleSB(primaryKey);

		if (!SampleSBEntryPermission.contains(
				themeDisplay.getPermissionChecker(), record, ActionKeys.VIEW)) {

			List<String> error = new ArrayList<>();
			error.add("permission-error");

			throw new SampleSBValidateException(error);
		}

		request.setAttribute("sampleSB", record);

		return getViewRecordPageJSP();
	}

	@Reference
	private SampleSBService _sampleSBService;

//  //
// //

	@Reference
	private SampleSBItemSelectorHelper _sampleSBItemSelectorHelper;

}
