package com.liferay.sb.test.headless.internal.resource.v1_0;

import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.TransformUtil;
import com.liferay.sb.test.headless.dto.v1_0.SampleSB;
import com.liferay.sb.test.headless.resource.v1_0.SampleSBResource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Generated;

import javax.validation.constraints.NotNull;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * @author Yasuyuki Takeo
 * @generated
 */
@Generated("")
@Path("/v1.0")
public abstract class BaseSampleSBResourceImpl implements SampleSBResource {

	@Override
	@GET
	@Operation(
		description = "Retrieve the list of SampleSBs. Results can be paginated, filtered, searched and sorted."
	)
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.QUERY, name = "keywords"),
			@Parameter(in = ParameterIn.QUERY, name = "filter"),
			@Parameter(in = ParameterIn.QUERY, name = "page"),
			@Parameter(in = ParameterIn.QUERY, name = "pageSize"),
			@Parameter(in = ParameterIn.QUERY, name = "sort")
		}
	)
	@Path("/samplesbs")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "SampleSB")})
	public Page<SampleSB> getSampleSBsPage(
			@Parameter(hidden = true) @QueryParam("keywords") String keywords,
			@Context Filter filter, @Context Pagination pagination,
			@Context Sort[] sorts)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@Operation(description = "Create a new SampleSB entity.")
	@POST
	@Path("/samplesbs")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "SampleSB")})
	public SampleSB postSampleSB(SampleSB sampleSB) throws Exception {
		return new SampleSB();
	}

	@Override
	@DELETE
	@Operation(description = "Deletes the target office entity.")
	@Parameters(
		value = {@Parameter(in = ParameterIn.PATH, name = "sampleSbId")}
	)
	@Path("/samplesbs/{sampleSbId}")
	@Produces("application/json")
	@Tags(value = {@Tag(name = "SampleSB")})
	public void deleteSampleSB(
			@NotNull @Parameter(hidden = true) @PathParam("sampleSbId") Long
				sampleSbId)
		throws Exception {
	}

	@Override
	@GET
	@Operation(description = "Retrieves the SampleSB via its ID")
	@Parameters(
		value = {@Parameter(in = ParameterIn.PATH, name = "sampleSbId")}
	)
	@Path("/samplesbs/{sampleSbId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "SampleSB")})
	public SampleSB getSampleSB(
			@NotNull @Parameter(hidden = true) @PathParam("sampleSbId") Long
				sampleSbId)
		throws Exception {

		return new SampleSB();
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@Operation(description = "Updates and overwrites existing SampleSB entity.")
	@PUT
	@Parameters(
		value = {@Parameter(in = ParameterIn.PATH, name = "sampleSbId")}
	)
	@Path("/samplesbs/{sampleSbId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "SampleSB")})
	public SampleSB putSampleSB(
			@NotNull @Parameter(hidden = true) @PathParam("sampleSbId") Long
				sampleSbId,
			SampleSB sampleSB)
		throws Exception {

		return new SampleSB();
	}

	public void setContextCompany(Company contextCompany) {
		this.contextCompany = contextCompany;
	}

	protected void preparePatch(SampleSB sampleSB, SampleSB existingSampleSB) {
	}

	protected <T, R> List<R> transform(
		Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transform(collection, unsafeFunction);
	}

	protected <T, R> R[] transform(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction,
		Class<?> clazz) {

		return TransformUtil.transform(array, unsafeFunction, clazz);
	}

	protected <T, R> R[] transformToArray(
		Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction, Class<?> clazz) {

		return TransformUtil.transformToArray(
			collection, unsafeFunction, clazz);
	}

	protected <T, R> List<R> transformToList(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transformToList(array, unsafeFunction);
	}

	@Context
	protected AcceptLanguage contextAcceptLanguage;

	@Context
	protected Company contextCompany;

	@Context
	protected UriInfo contextUriInfo;

}