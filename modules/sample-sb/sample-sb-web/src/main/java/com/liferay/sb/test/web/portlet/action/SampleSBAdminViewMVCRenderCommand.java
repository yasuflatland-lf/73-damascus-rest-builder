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

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.sb.test.constants.SampleSBPortletKeys;
import com.liferay.sb.test.web.constants.SampleSBWebKeys;
import com.liferay.sb.test.web.internal.display.context.SampleSBDisplayContext;
import com.liferay.sb.test.web.util.SampleSBViewHelper;
import com.liferay.trash.TrashHelper;

// //
// //

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author yasuflatland
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SampleSBPortletKeys.SAMPLESB_ADMIN,
		"mvc.command.name=/", "mvc.command.name=/samplesb/view"
	},
	service = MVCRenderCommand.class
)
public class SampleSBAdminViewMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest request, RenderResponse response) {
		request.setAttribute(
			SampleSBWebKeys.SAMPLESB_DISPLAY_CONTEXT,
			new SampleSBDisplayContext(
				_portal.getLiferayPortletRequest(request),
				_portal.getLiferayPortletResponse(response), _trashHelper,
				_sampleSBViewHelper));

		request.setAttribute(
			SampleSBWebKeys.SAMPLESB_VIEW_HELPER, _sampleSBViewHelper);

// //
// //
		
		return SampleSBWebKeys.ADMIN_VIEW_JSP;
	}

	@Reference
	private Portal _portal;

	@Reference
	private SampleSBViewHelper _sampleSBViewHelper;

	@Reference
	private TrashHelper _trashHelper;
	
// //
// //	

}