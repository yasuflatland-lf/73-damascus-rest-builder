package com.liferay.sb.test.headless.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.sb.test.headless.dto.v1_0.SampleSBApp;
import com.liferay.sb.test.headless.resource.v1_0.SampleSBAppResource;

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

	public static void setSampleSBAppResourceComponentServiceObjects(
		ComponentServiceObjects<SampleSBAppResource>
			sampleSBAppResourceComponentServiceObjects) {

		_sampleSBAppResourceComponentServiceObjects =
			sampleSBAppResourceComponentServiceObjects;
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public SampleSBApp postSamplesb(
			@GraphQLName("sampleSBApp") SampleSBApp sampleSBApp)
		throws Exception {

		return _applyComponentServiceObjects(
			_sampleSBAppResourceComponentServiceObjects,
			this::_populateResourceContext,
			sampleSBAppResource -> sampleSBAppResource.postSamplesb(
				sampleSBApp));
	}

	@GraphQLInvokeDetached
	public void deleteSamplesbSampleSb(@GraphQLName("entityId") Long entityId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_sampleSBAppResourceComponentServiceObjects,
			this::_populateResourceContext,
			sampleSBAppResource -> sampleSBAppResource.deleteSamplesbSampleSb(
				entityId));
	}

	@GraphQLInvokeDetached
	public SampleSBApp putSamplesbSampleSb(
			@GraphQLName("entityId") Long entityId,
			@GraphQLName("sampleSBApp") SampleSBApp sampleSBApp)
		throws Exception {

		return _applyComponentServiceObjects(
			_sampleSBAppResourceComponentServiceObjects,
			this::_populateResourceContext,
			sampleSBAppResource -> sampleSBAppResource.putSamplesbSampleSb(
				entityId, sampleSBApp));
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