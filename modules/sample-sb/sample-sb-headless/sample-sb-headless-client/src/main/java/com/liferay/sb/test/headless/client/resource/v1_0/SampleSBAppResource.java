package com.liferay.sb.test.headless.client.resource.v1_0;

import com.liferay.sb.test.headless.client.dto.v1_0.SampleSBApp;
import com.liferay.sb.test.headless.client.http.HttpInvoker;
import com.liferay.sb.test.headless.client.pagination.Page;
import com.liferay.sb.test.headless.client.pagination.Pagination;
import com.liferay.sb.test.headless.client.serdes.v1_0.SampleSBAppSerDes;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Generated;

/**
 * @author Yasuyuki Takeo
 * @generated
 */
@Generated("")
public class SampleSBAppResource {

	public static Page<SampleSBApp> getSamplesbsPage(
			String keywords, String filterString, Pagination pagination,
			String sortString)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse = getSamplesbsPageHttpResponse(
			keywords, filterString, pagination, sortString);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		return Page.of(content, SampleSBAppSerDes::toDTO);
	}

	public static HttpInvoker.HttpResponse getSamplesbsPageHttpResponse(
			String keywords, String filterString, Pagination pagination,
			String sortString)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

		if (keywords != null) {
			httpInvoker.parameter("keywords", String.valueOf(keywords));
		}

		if (filterString != null) {
			httpInvoker.parameter("filter", filterString);
		}

		if (pagination != null) {
			httpInvoker.parameter("page", String.valueOf(pagination.getPage()));
			httpInvoker.parameter(
				"pageSize", String.valueOf(pagination.getPageSize()));
		}

		if (sortString != null) {
			httpInvoker.parameter("sort", sortString);
		}

		httpInvoker.path(
			"http://localhost:8080/o/sample-sb-headless/v1.0/samplesbs");

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static SampleSBApp postSamplesb(SampleSBApp sampleSBApp)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse = postSamplesbHttpResponse(
			sampleSBApp);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return SampleSBAppSerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse postSamplesbHttpResponse(
			SampleSBApp sampleSBApp)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(sampleSBApp.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

		httpInvoker.path(
			"http://localhost:8080/o/sample-sb-headless/v1.0/samplesbs");

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static void deleteSamplesbSampleSb(Long entityId) throws Exception {
		HttpInvoker.HttpResponse httpResponse =
			deleteSamplesbSampleSbHttpResponse(entityId);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());
	}

	public static HttpInvoker.HttpResponse deleteSamplesbSampleSbHttpResponse(
			Long entityId)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

		httpInvoker.path(
			"http://localhost:8080/o/sample-sb-headless/v1.0/samplesbs/{sampleSbId}",
			entityId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static SampleSBApp getSamplesbSampleSb(Long entityId)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse = getSamplesbSampleSbHttpResponse(
			entityId);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return SampleSBAppSerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse getSamplesbSampleSbHttpResponse(
			Long entityId)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

		httpInvoker.path(
			"http://localhost:8080/o/sample-sb-headless/v1.0/samplesbs/{sampleSbId}",
			entityId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static SampleSBApp putSamplesbSampleSb(
			Long entityId, SampleSBApp sampleSBApp)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse = putSamplesbSampleSbHttpResponse(
			entityId, sampleSBApp);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return SampleSBAppSerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse putSamplesbSampleSbHttpResponse(
			Long entityId, SampleSBApp sampleSBApp)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(sampleSBApp.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.PUT);

		httpInvoker.path(
			"http://localhost:8080/o/sample-sb-headless/v1.0/samplesbs/{sampleSbId}",
			entityId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	private static final Logger _logger = Logger.getLogger(
		SampleSBAppResource.class.getName());

}