package com.liferay.sb.test.headless.internal.graphql.servlet.v1_0;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;
import com.liferay.sb.test.headless.internal.graphql.mutation.v1_0.Mutation;
import com.liferay.sb.test.headless.internal.graphql.query.v1_0.Query;
import com.liferay.sb.test.headless.resource.v1_0.SampleSBAppResource;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author Yasuyuki Takeo
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setSampleSBAppResourceComponentServiceObjects(
			_sampleSBAppResourceComponentServiceObjects);

		Query.setSampleSBAppResourceComponentServiceObjects(
			_sampleSBAppResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/sample-sb-headless-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<SampleSBAppResource>
		_sampleSBAppResourceComponentServiceObjects;

}