// 
/*  */
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

package com.liferay.sb.test.exception;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author yasuflatland
 */
@ProviderType
public class SampleSBValidateException extends PortalException {

	public SampleSBValidateException() {
	}

	public SampleSBValidateException(List<String> errors) {
		_errors = errors;
	}

	public List<String> getErrors() {
		return _errors;
	}

	protected List<String> _errors = null;

}