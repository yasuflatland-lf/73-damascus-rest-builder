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

import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.search.spi.model.query.contributor.ModelPreFilterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchSettings;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * SampleSB Model PreFilter Contributor
 *
 * Filters search results before they are returned from the search engine.
 *
 * @author yasuflatland
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.sb.test.model.SampleSB",
	service = ModelPreFilterContributor.class
)
public class SampleSBModelPreFilterContributor implements ModelPreFilterContributor {

	@Override
	public void contribute(BooleanFilter booleanFilter, ModelSearchSettings modelSearchSettings, SearchContext searchContext) {

		// TODO: Adjust as necessary to filter results that should not normally be included as search results.

		// exclude non-approved entities from the search results.
		addWorkflowStatusFilter(booleanFilter, modelSearchSettings, searchContext);
	}

	protected void addWorkflowStatusFilter(BooleanFilter booleanFilter, ModelSearchSettings modelSearchSettings, SearchContext searchContext) {
		workflowStatusModelPreFilterContributor.contribute(booleanFilter, modelSearchSettings, searchContext);
	}

	@Reference(target = "(model.pre.filter.contributor.id=WorkflowStatus)")
	protected ModelPreFilterContributor workflowStatusModelPreFilterContributor;
}