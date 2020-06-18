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

package com.liferay.sb.test.service.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ModelHintsUtil;
import com.liferay.portal.kernel.repository.model.ModelValidator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.sb.test.exception.SampleSBValidateException;
import com.liferay.sb.test.model.SampleSB;

/*   */
/*  */ 

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * SampleSB Validator 
 * 
 * @author yasuflatland
 *
 */
public class SampleSBValidator implements ModelValidator<SampleSB> {

	@Override
	public void validate(SampleSB entry) throws PortalException {
/*   */
        // Field samplesbId
        validateSamplesbId(entry.getSamplesbId());

        // Field title
        validateTitle(entry.getTitle());

        // Field samplesbBooleanStat
        validateSamplesbBooleanStat(entry.getSamplesbBooleanStat());

        // Field samplesbDateTime
        validateSamplesbDateTime(entry.getSamplesbDateTime());

        // Field samplesbDocumentLibrary
        validateSamplesbDocumentLibrary(entry.getSamplesbDocumentLibrary());

        // Field samplesbDouble
        validateSamplesbDouble(entry.getSamplesbDouble());

        // Field samplesbInteger
        validateSamplesbInteger(entry.getSamplesbInteger());

        // Field samplesbRichText
        validateSamplesbRichText(entry.getSamplesbRichText());

        // Field samplesbText
        validateSamplesbText(entry.getSamplesbText());

/*  */
        validateSamplesbTitleName(entry.getSamplesbTitleName());

		if (0 < _errors.size()) {
			throw new SampleSBValidateException(_errors);
		}
		
	}

    /**
    * samplesbTitleName field Validation
    *
    * @param samplesbTitleName
    */
    protected void validateSamplesbTitleName(String samplesbTitleName) {
        if (Validator.isNotNull(samplesbTitleName)) {
            int samplesbTitleNameMaxLength = ModelHintsUtil.getMaxLength(
                SampleSB.class.getName(), "samplesbTitleName");

            if (samplesbTitleName.length() > samplesbTitleNameMaxLength) {
                _errors.add("samplesbTitleName has more than " + samplesbTitleNameMaxLength +
                " characters");
            }
        }
    }

/*   */
    /**
    * samplesbId field Validation
    *
    * @param field samplesbId
    */
    protected void validateSamplesbId(long field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
    }

    /**
    * title field Validation
    *
    * @param field title
    */
    protected void validateTitle(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (!StringUtils.isNotEmpty(field)) {
            _errors.add("samplesb-title-required");
        }

    }

    /**
    * samplesbBooleanStat field Validation
    *
    * @param field samplesbBooleanStat
    */
    protected void validateSamplesbBooleanStat(boolean field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.

    }

    /**
    * samplesbDateTime field Validation
    *
    * @param field samplesbDateTime
    */
    protected void validateSamplesbDateTime(Date field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.

    }

    /**
    * samplesbDocumentLibrary field Validation
    *
    * @param field samplesbDocumentLibrary
    */
    protected void validateSamplesbDocumentLibrary(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.

    }

    /**
    * samplesbDouble field Validation
    *
    * @param field samplesbDouble
    */
    protected void validateSamplesbDouble(double field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.

    }

    /**
    * samplesbInteger field Validation
    *
    * @param field samplesbInteger
    */
    protected void validateSamplesbInteger(int field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.

    }

    /**
    * samplesbRichText field Validation
    *
    * @param field samplesbRichText
    */
    protected void validateSamplesbRichText(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.

    }

    /**
    * samplesbText field Validation
    *
    * @param field samplesbText
    */
    protected void validateSamplesbText(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.

    }

/*  */ 	
	

	protected List<String> _errors = new ArrayList<>();

}
