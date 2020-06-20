package com.liferay.sb.test.headless.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author Yasuyuki Takeo
 * @generated
 */
@Component(
	property = {
		"osgi.jaxrs.application.base=/sample-sb-headless",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=jp.co.liferay.headless.sample-sb"
	},
	service = Application.class
)
@Generated("")
public class HeadlessSampleSBApplication extends Application {
}