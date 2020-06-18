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
package com.liferay.sb.test.internal.search.query.contributor;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * SampleSB Keyword Query Contributor
 *
 * Contributes clauses to the ongoing search query to control how the model entities are searched.
 *
 * @author yasuflatland
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.sb.test.model.SampleSB",
	service = KeywordQueryContributor.class
)
public class SampleSBKeywordQueryContributor implements KeywordQueryContributor {

	@Override
	public void contribute(String keywords, BooleanQuery booleanQuery,KeywordQueryContributorHelper keywordQueryContributorHelper) {
		SearchContext searchContext = keywordQueryContributorHelper.getSearchContext();

		// TODO: Adjust as necessary to support the search for the entity

		queryHelper.addSearchTerm(booleanQuery, searchContext, Field.ARTICLE_ID, false);
		queryHelper.addSearchTerm(booleanQuery, searchContext, Field.CLASS_PK, false);
		queryHelper.addSearchTerm(booleanQuery, searchContext, Field.ENTRY_CLASS_PK, false);
		queryHelper.addSearchTerm(booleanQuery, searchContext, Field.USER_NAME, false);
		queryHelper.addSearchLocalizedTerm(booleanQuery, searchContext, Field.CONTENT, false);
		queryHelper.addSearchLocalizedTerm(booleanQuery, searchContext, Field.DESCRIPTION, false);
		queryHelper.addSearchLocalizedTerm(booleanQuery, searchContext, Field.TITLE, false);
		queryHelper.addSearchLocalizedTerm(booleanQuery, searchContext, Field.SUBTITLE, false);
	}

	@Reference
	protected QueryHelper queryHelper;
}