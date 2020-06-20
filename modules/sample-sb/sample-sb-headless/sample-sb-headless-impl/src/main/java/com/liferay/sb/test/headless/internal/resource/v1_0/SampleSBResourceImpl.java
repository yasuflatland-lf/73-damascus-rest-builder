package com.liferay.sb.test.headless.internal.resource.v1_0;

import com.liferay.sb.test.headless.resource.v1_0.SampleSBResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Yasuyuki Takeo
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/sample-sb.properties",
	scope = ServiceScope.PROTOTYPE, service = SampleSBResource.class
)
public class SampleSBResourceImpl extends BaseSampleSBResourceImpl {
}