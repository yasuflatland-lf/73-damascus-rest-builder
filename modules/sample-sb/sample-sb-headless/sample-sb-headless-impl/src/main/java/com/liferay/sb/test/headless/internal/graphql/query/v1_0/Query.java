package com.liferay.sb.test.headless.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.sb.test.headless.dto.v1_0.SampleSB;
import com.liferay.sb.test.headless.resource.v1_0.SampleSBResource;

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

	public static void setSampleSBResourceComponentServiceObjects(
		ComponentServiceObjects<SampleSBResource>
			sampleSBResourceComponentServiceObjects) {

		_sampleSBResourceComponentServiceObjects =
			sampleSBResourceComponentServiceObjects;
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<SampleSB> getSampleSBsPage(
			@GraphQLName("keywords") String keywords,
			@GraphQLName("filter") Filter filter,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page, @GraphQLName("sorts") Sort[] sorts)
		throws Exception {

		return _applyComponentServiceObjects(
			_sampleSBResourceComponentServiceObjects,
			this::_populateResourceContext,
			sampleSBResource -> {
				Page paginationPage = sampleSBResource.getSampleSBsPage(
					keywords, filter, Pagination.of(pageSize, page), sorts);

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public SampleSB getSampleSB(@GraphQLName("sampleSbId") Long sampleSbId)
		throws Exception {

		return _applyComponentServiceObjects(
			_sampleSBResourceComponentServiceObjects,
			this::_populateResourceContext,
			sampleSBResource -> sampleSBResource.getSampleSB(sampleSbId));
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

	private void _populateResourceContext(SampleSBResource sampleSBResource)
		throws Exception {

		sampleSBResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));
	}

	private static ComponentServiceObjects<SampleSBResource>
		_sampleSBResourceComponentServiceObjects;

}