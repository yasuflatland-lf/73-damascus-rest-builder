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

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.sb.test.constants.SampleSBPortletKeys;

/**
 * SampleSB Configuration
 *
 * @author yasuflatland
 */
@Meta.OCD(id = SampleSBPortletKeys.SAMPLESB_CONFIG)
public interface SampleSBConfiguration {

	public static final String CONF_PREFS_VIEW_TYPE = "prefsViewType";

	public static final String CONF_DATE_FORMAT = "dateFormat";

	public static final String CONF_DATETIME_FORMAT = "datetimeFormat";

	public static final String PREFS_VIEW_TYPE_DEFAULT = "0";

	public static final String PREFS_VIEW_TYPE_USER = "1";

	public static final String PREFS_VIEW_TYPE_USER_GROUP = "2";

	@Meta.AD(deflt = PREFS_VIEW_TYPE_DEFAULT, required = false)
	public int prefsViewType();

	@Meta.AD(deflt = "yyyy/MM/dd", required = false)
	public String dateFormat();

	@Meta.AD(deflt = "yyyy/MM/dd HH:mm", required = false)
	public String datetimeFormat();

	@Meta.AD(deflt = "%Y/%m/%d", required = false)
	public String datePickerFormat();

}