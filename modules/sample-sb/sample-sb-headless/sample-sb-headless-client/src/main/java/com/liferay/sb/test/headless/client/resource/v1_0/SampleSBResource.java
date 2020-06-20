package com.liferay.sb.test.headless.client.resource.v1_0;

import com.liferay.sb.test.headless.client.dto.v1_0.SampleSB;
import com.liferay.sb.test.headless.client.http.HttpInvoker;
import com.liferay.sb.test.headless.client.pagination.Page;
import com.liferay.sb.test.headless.client.pagination.Pagination;
import com.liferay.sb.test.headless.client.serdes.v1_0.SampleSBSerDes;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Generated;

/**
 * @author Yasuyuki Takeo
 * @generated
 */
@Generated("")
public class SampleSBResource {

	public static Page<SampleSB> getSampleSBsPage(
			String keywords, String filterString, Pagination pagination,
			String sortString)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse = getSampleSBsPageHttpResponse(
			keywords, filterString, pagination, sortString);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		return Page.of(content, SampleSBSerDes::toDTO);
	}

	public static HttpInvoker.HttpResponse getSampleSBsPageHttpResponse(
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

	public static SampleSB postSampleSB(SampleSB sampleSB) throws Exception {
		HttpInvoker.HttpResponse httpResponse = postSampleSBHttpResponse(
			sampleSB);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return SampleSBSerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse postSampleSBHttpResponse(
			SampleSB sampleSB)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(sampleSB.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

		httpInvoker.path(
			"http://localhost:8080/o/sample-sb-headless/v1.0/samplesbs");

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static void deleteSampleSB(Long sampleSbId) throws Exception {
		HttpInvoker.HttpResponse httpResponse = deleteSampleSBHttpResponse(
			sampleSbId);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());
	}

	public static HttpInvoker.HttpResponse deleteSampleSBHttpResponse(
			Long sampleSbId)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

		httpInvoker.path(
			"http://localhost:8080/o/sample-sb-headless/v1.0/samplesbs/{sampleSbId}",
			sampleSbId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static SampleSB getSampleSB(Long sampleSbId) throws Exception {
		HttpInvoker.HttpResponse httpResponse = getSampleSBHttpResponse(
			sampleSbId);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return SampleSBSerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse getSampleSBHttpResponse(
			Long sampleSbId)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

		httpInvoker.path(
			"http://localhost:8080/o/sample-sb-headless/v1.0/samplesbs/{sampleSbId}",
			sampleSbId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static SampleSB putSampleSB(Long sampleSbId, SampleSB sampleSB)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse = putSampleSBHttpResponse(
			sampleSbId, sampleSB);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return SampleSBSerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse putSampleSBHttpResponse(
			Long sampleSbId, SampleSB sampleSB)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(sampleSB.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.PUT);

		httpInvoker.path(
			"http://localhost:8080/o/sample-sb-headless/v1.0/samplesbs/{sampleSbId}",
			sampleSbId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	private static final Logger _logger = Logger.getLogger(
		SampleSBResource.class.getName());

}