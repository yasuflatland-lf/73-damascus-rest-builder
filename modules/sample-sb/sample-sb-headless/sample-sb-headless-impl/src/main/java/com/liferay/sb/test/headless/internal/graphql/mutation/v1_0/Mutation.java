package com.liferay.sb.test.headless.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.sb.test.headless.dto.v1_0.SampleSB;
import com.liferay.sb.test.headless.resource.v1_0.SampleSBResource;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLInvokeDetached;
import graphql.annotations.annotationTypes.GraphQLName;

import javax.annotation.Generated;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Yasuyuki Takeo
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setSampleSBResourceComponentServiceObjects(
		ComponentServiceObjects<SampleSBResource>
			sampleSBResourceComponentServiceObjects) {

		_sampleSBResourceComponentServiceObjects =
			sampleSBResourceComponentServiceObjects;
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public SampleSB postSampleSB(@GraphQLName("sampleSB") SampleSB sampleSB)
		throws Exception {

		return _applyComponentServiceObjects(
			_sampleSBResourceComponentServiceObjects,
			this::_populateResourceContext,
			sampleSBResource -> sampleSBResource.postSampleSB(sampleSB));
	}

	@GraphQLInvokeDetached
	public void deleteSampleSB(@GraphQLName("sampleSbId") Long sampleSbId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_sampleSBResourceComponentServiceObjects,
			this::_populateResourceContext,
			sampleSBResource -> sampleSBResource.deleteSampleSB(sampleSbId));
	}

	@GraphQLInvokeDetached
	public SampleSB putSampleSB(
			@GraphQLName("sampleSbId") Long sampleSbId,
			@GraphQLName("sampleSB") SampleSB sampleSB)
		throws Exception {

		return _applyComponentServiceObjects(
			_sampleSBResourceComponentServiceObjects,
			this::_populateResourceContext,
			sampleSBResource -> sampleSBResource.putSampleSB(
				sampleSbId, sampleSB));
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

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
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