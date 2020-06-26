package com.liferay.sb.test.headless.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.sb.test.headless.dto.v1_0.SampleSBApp;
import com.liferay.sb.test.headless.resource.v1_0.SampleSBAppResource;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLInvokeDetached;
import graphql.annotations.annotationTypes.GraphQLName;

import java.util.Collection;

import javax.annotation.Generated;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Yasuyuki Takeo
 * @generated
 */
@Generated("")
public class Query {

	public static void setSampleSBAppResourceComponentServiceObjects(
		ComponentServiceObjects<SampleSBAppResource>
			sampleSBAppResourceComponentServiceObjects) {

		_sampleSBAppResourceComponentServiceObjects =
			sampleSBAppResourceComponentServiceObjects;
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<SampleSBApp> getSamplesbsPage(
			@GraphQLName("keywords") String keywords,
			@GraphQLName("filter") Filter filter,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page, @GraphQLName("sorts") Sort[] sorts)
		throws Exception {

		return _applyComponentServiceObjects(
			_sampleSBAppResourceComponentServiceObjects,
			this::_populateResourceContext,
			sampleSBAppResource -> {
				Page paginationPage = sampleSBAppResource.getSamplesbsPage(
					keywords, filter, Pagination.of(pageSize, page), sorts);

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public SampleSBApp getSamplesbSampleSb(
			@GraphQLName("entityId") Long entityId)
		throws Exception {

		return _applyComponentServiceObjects(
			_sampleSBAppResourceComponentServiceObjects,
			this::_populateResourceContext,
			sampleSBAppResource -> sampleSBAppResource.getSamplesbSampleSb(
				entityId));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(
			SampleSBAppResource sampleSBAppResource)
		throws Exception {

		sampleSBAppResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));
	}

	private static ComponentServiceObjects<SampleSBAppResource>
		_sampleSBAppResourceComponentServiceObjects;

}