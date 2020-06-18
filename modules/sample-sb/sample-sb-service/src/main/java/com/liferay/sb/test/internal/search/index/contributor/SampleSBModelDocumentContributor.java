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
package com.liferay.sb.test.internal.search.index.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import org.osgi.service.component.annotations.Component;
import com.liferay.sb.test.model.SampleSB;

/**
 * SampleSB Model Document Contributor
 *
 * This class is used to contribute fields to the document to be indexed.
 *
 * @author yasuflatland
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.sb.test.model.SampleSB",
	service = ModelDocumentContributor.class
)
public class SampleSBModelDocumentContributor implements ModelDocumentContributor<SampleSB> {

	@Override
	public void contribute(Document document, SampleSB entry) {

		// TODO : These fields should be modified according to your requirements.

		document.addText(Field.CAPTION, entry.getSamplesbTitleName());
		document.addText(
			Field.CONTENT,
			HtmlUtil.extractText(entry.getSamplesbSummaryName()));
		document.addText(Field.DESCRIPTION, entry.getSamplesbTitleName());
		document.addText(Field.SUBTITLE, entry.getSamplesbTitleName());
		document.addText(Field.TITLE, entry.getSamplesbTitleName());

		document.addDate(Field.MODIFIED_DATE, entry.getModifiedDate());
	}
}