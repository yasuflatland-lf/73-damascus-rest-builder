package com.liferay.sb.test.headless.resource.v1_0;

import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.sb.test.headless.dto.v1_0.SampleSBApp;

import javax.annotation.Generated;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/sample-sb-headless/v1.0
 *
 * @author Yasuyuki Takeo
 * @generated
 */
@Generated("")
public interface SampleSBAppResource {

	public Page<SampleSBApp> getSamplesbsPage(
			String keywords, Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception;

	public SampleSBApp postSamplesb(SampleSBApp sampleSBApp) throws Exception;

	public void deleteSamplesbSampleSb(Long entityId) throws Exception;

	public SampleSBApp getSamplesbSampleSb(Long entityId) throws Exception;

	public SampleSBApp putSamplesbSampleSb(
			Long entityId, SampleSBApp sampleSBApp)
		throws Exception;

	public void setContextCompany(Company contextCompany);

}