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

import aQute.bnd.annotation.metatype.Configurable;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.sb.test.constants.SampleSBPortletKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SampleSB Configuraion Aciton
 *
 * Determine the scope of the portlet configuration in DS properties of Portlet
 * class The default of this generator is Portlet Instance scope.
 *
 * Look at the elements preferences-company-wide, preferences-unique-per-layout
 * and preferences-owned-by-group to determine the right scope. The following
 * table maps out the scopes:
 *
 * liferay-portlet.xml Scope preferences-company-wide=true Company
 * preferences-owned-by-group=true AND preferences-unique-per-layout=false Group
 * preferences-owned-by-group=true AND preferences-unique-per-layout=true
 * Portlet Instance
 *
 * @author yasuflatland
 *
 */
@Component(
	configurationPid = SampleSBPortletKeys.SAMPLESB_CONFIG,
	configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true,
	property = "javax.portlet.name=" + SampleSBPortletKeys.SAMPLESB,
	service = ConfigurationAction.class
)
public class SampleSBConfigurationAction extends DefaultConfigurationAction {

	@Override
	public String getJspPath(HttpServletRequest httpServletRequest) {
		return "/sample_sb/configuration.jsp";
	}

	@Override
	public void include(
			PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws Exception {

		if (_log.isDebugEnabled()) {
			_log.debug("SampleSB Portlet configuration include");
		}

		httpServletRequest.setAttribute(
			SampleSBConfiguration.class.getName(), _sampleSBConfiguration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Override
	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		int prefsViewType = ParamUtil.getInteger(
			actionRequest, SampleSBConfiguration.CONF_PREFS_VIEW_TYPE,
			Integer.valueOf(SampleSBConfiguration.PREFS_VIEW_TYPE_DEFAULT));
		String dateFormat = ParamUtil.getString(
			actionRequest, SampleSBConfiguration.CONF_DATE_FORMAT);
		String datetimeFormat = ParamUtil.getString(
			actionRequest, SampleSBConfiguration.CONF_DATETIME_FORMAT);

		if (_log.isDebugEnabled()) {
			_log.debug("Prefs View Type :" + prefsViewType);
			_log.debug("Date Format     :" + dateFormat);
			_log.debug("Date Time Format:" + datetimeFormat);
		}

		List<String> errors = new ArrayList<>();

		if (validate(dateFormat, datetimeFormat, errors)) {
			setPreference(
				actionRequest, SampleSBConfiguration.CONF_PREFS_VIEW_TYPE,
				String.valueOf(prefsViewType));
			setPreference(
				actionRequest, SampleSBConfiguration.CONF_DATE_FORMAT,
				dateFormat);
			setPreference(
				actionRequest, SampleSBConfiguration.CONF_DATETIME_FORMAT,
				datetimeFormat);

			SessionMessages.add(actionRequest, "prefsSuccess");
		}

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_sampleSBConfiguration = Configurable.createConfigurable(
			SampleSBConfiguration.class, properties);
	}

	/**
	 * Validate Preference
	 *
	 * @param dateFormat Date Format
	 * @param datetimeFormat Date Time Format
	 * @param errors
	 * @return boolean
	 */
	protected boolean validate(
		String dateFormat, String datetimeFormat, List<String> errors) {

		boolean valid = true;

		if (Validator.isNull(dateFormat)) {
			errors.add("date-format-required");
			valid = false;
		}
		else if (Validator.isNull(datetimeFormat)) {
			errors.add("datetime-format.required");
			valid = false;
		}

		return valid;
	}

	private static final Logger _log = LoggerFactory.getLogger(
		SampleSBConfigurationAction.class);

	private volatile SampleSBConfiguration _sampleSBConfiguration;

}