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

import com.liferay.asset.display.page.portlet.AssetDisplayPageEntryFormProcessor;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.TrashedModel;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.sb.test.constants.SampleSBPortletKeys;
import com.liferay.sb.test.exception.SampleSBValidateException;
import com.liferay.sb.test.model.SampleSB;
import com.liferay.sb.test.service.SampleSBLocalService;
import com.liferay.sb.test.service.SampleSBService;
import com.liferay.trash.service.TrashEntryService;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yasuflatland
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SampleSBPortletKeys.SAMPLESB,
		"mvc.command.name=/samplesb/crud"
	},
	service = MVCActionCommand.class
)
public class SampleSBCrudMVCActionCommand extends BaseMVCActionCommand {

	/**
	 * Add Entry
	 *
	 * @param request
	 * @param response
	 * @throws SampleSBValidateException, Exception
	 */
	public void addEntry(ActionRequest request, ActionResponse response)
		throws Exception, SampleSBValidateException {

		long primaryKey = ParamUtil.getLong(request, "resourcePrimKey", 0);

		SampleSB entry = _sampleSBLocalService.getSampleSBFromRequest(
			primaryKey, request);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			SampleSB.class.getName(), request);

		// Add entry

		_sampleSBService.addEntry(entry, serviceContext);

		_assetDisplayPageEntryFormProcessor.process(
			SampleSB.class.getName(), entry.getPrimaryKey(), request);

		SessionMessages.add(request, "samplesbAddedSuccessfully");
	}

	/**
	 * Delte Entry
	 *
	 * @param request
	 * @param response
	 * @param moveToTrash true to move to trush.
	 * @throws PortalException
	 * @throws Exception
	 */
	public void deleteEntry(
			ActionRequest request, ActionResponse response, boolean moveToTrash)
		throws PortalException {

		long[] deleteEntryIds = null;
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		long entryId = ParamUtil.getLong(request, "resourcePrimKey", 0L);

		if (entryId > 0) {
			deleteEntryIds = new long[] {entryId};
		}
		else {
			deleteEntryIds = StringUtil.split(
				ParamUtil.getString(request, "deleteEntryIds"), 0L);
		}

		List<TrashedModel> trashedModels = new ArrayList<>();

		for (long deleteEntryId : deleteEntryIds) {
			try {
				if (moveToTrash) {
					SampleSB entry = _sampleSBService.moveEntryToTrash(
						deleteEntryId);

					trashedModels.add(entry);
				}
				else {
					_sampleSBService.deleteEntry(deleteEntryId);
				}
			}
			catch (PortalException pe) {
				ReflectionUtil.throwException(pe);
			}
		}

		if (moveToTrash && !trashedModels.isEmpty()) {
			Map<String, Object> data = new HashMap<>();

			data.put("trashedModels", trashedModels);

			addDeleteSuccessData(request, data);
		}
	}

	/**
	 * Restore Entries
	 *
	 * @param actionRequest
	 * @throws Exception
	 */
	public void restoreTrashEntries(ActionRequest actionRequest)
		throws Exception {

		long[] restoreTrashEntryIds = StringUtil.split(
			ParamUtil.getString(actionRequest, "restoreTrashEntryIds"), 0L);

		for (long restoreTrashEntryId : restoreTrashEntryIds) {
			_trashEntryService.restoreEntry(restoreTrashEntryId);
		}
	}

	/**
	 * Update Entry
	 *
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void updateEntry(ActionRequest request, ActionResponse response)
		throws Exception {

		long primaryKey = ParamUtil.getLong(request, "resourcePrimKey", 0);

		SampleSB entry = _sampleSBLocalService.getSampleSBFromRequest(
			primaryKey, request);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			SampleSB.class.getName(), request);

		//Update entry
		_sampleSBService.updateEntry(entry, serviceContext);

		_assetDisplayPageEntryFormProcessor.process(
			SampleSB.class.getName(), entry.getPrimaryKey(), request);

		SessionMessages.add(request, "samplesbUpdatedSuccessfully");
	}

	/**
	 * Single Delete
	 *
	 * @param entry
	 * @param moveToTrash
	 * @param trashedModels
	 */
	protected void _deleteEntry(
		SampleSB entry, boolean moveToTrash, List<TrashedModel> trashedModels) {

		try {
			if (moveToTrash) {
				trashedModels.add(
					_sampleSBService.moveEntryToTrash(entry.getPrimaryKey()));
			}
			else {
				_sampleSBService.deleteEntry(entry.getPrimaryKey());
			}
		}
		catch (PortalException pe) {
			ReflectionUtil.throwException(pe);
		}
	}

	@Override
	protected void doProcessAction(
			ActionRequest request, ActionResponse response)
		throws IOException {

		try {

			// Fetch command

			String cmd = ParamUtil.getString(request, Constants.CMD);

			if (cmd.equals(Constants.ADD)) {
				addEntry(request, response);
			}
			else if (cmd.equals(Constants.UPDATE)) {
				updateEntry(request, response);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteEntry(request, response, false);
			}
			else if (cmd.equals(Constants.MOVE_TO_TRASH)) {
				deleteEntry(request, response, true);
			}
			else if (cmd.equals(Constants.RESTORE)) {
				restoreTrashEntries(request);
			}
		}
		catch (SampleSBValidateException ssbve) {
			for (String error : ssbve.getErrors()) {
				SessionErrors.add(request, error);
			}

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter(
				"mvcRenderCommandName", "/samplesb/crud");
			hideDefaultSuccessMessage(request);
		}
		catch (Exception t) {
			_log.error(t.getLocalizedMessage(), t);
			SessionErrors.add(request, PortalException.class);
			hideDefaultSuccessMessage(request);
		}

		//For access from Asset Publisher
		String redirect = ParamUtil.getString(request, "redirect");
		Boolean fromAsset = ParamUtil.getBoolean(request, "fromAsset", false);

		if (Validator.isNotNull(redirect) && (true == fromAsset)) {
			sendRedirect(request, response, redirect);
		}
	}

	@Reference(unbind = "-")
	protected void setSampleSBLocalService(
		SampleSBLocalService sampleSBLocalService) {

		_sampleSBLocalService = sampleSBLocalService;
	}

	@Reference(unbind = "-")
	protected void setSampleSBService(SampleSBService sampleSBService) {
		_sampleSBService = sampleSBService;
	}

	private static Logger _log = LoggerFactory.getLogger(
		SampleSBCrudMVCActionCommand.class);

	@Reference
	private AssetDisplayPageEntryFormProcessor
		_assetDisplayPageEntryFormProcessor;

	private SampleSBLocalService _sampleSBLocalService;
	private SampleSBService _sampleSBService;

	@Reference
	private TrashEntryService _trashEntryService;

}