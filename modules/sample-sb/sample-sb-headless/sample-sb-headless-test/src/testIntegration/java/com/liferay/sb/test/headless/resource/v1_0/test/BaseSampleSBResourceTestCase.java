package com.liferay.sb.test.headless.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;
import com.liferay.sb.test.headless.client.dto.v1_0.SampleSB;
import com.liferay.sb.test.headless.client.http.HttpInvoker;
import com.liferay.sb.test.headless.client.pagination.Page;
import com.liferay.sb.test.headless.client.pagination.Pagination;
import com.liferay.sb.test.headless.client.resource.v1_0.SampleSBResource;
import com.liferay.sb.test.headless.client.serdes.v1_0.SampleSBSerDes;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang.time.DateUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Yasuyuki Takeo
 * @generated
 */
@Generated("")
public abstract class BaseSampleSBResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();
		testLocale = LocaleUtil.getDefault();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
			}
		};

		SampleSB sampleSB1 = randomSampleSB();

		String json = objectMapper.writeValueAsString(sampleSB1);

		SampleSB sampleSB2 = SampleSBSerDes.toDTO(json);

		Assert.assertTrue(equals(sampleSB1, sampleSB2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
			}
		};

		SampleSB sampleSB = randomSampleSB();

		String json1 = objectMapper.writeValueAsString(sampleSB);
		String json2 = SampleSBSerDes.toJSON(sampleSB);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testGetSampleSBsPage() throws Exception {
		SampleSB sampleSB1 = testGetSampleSBsPage_addSampleSB(randomSampleSB());

		SampleSB sampleSB2 = testGetSampleSBsPage_addSampleSB(randomSampleSB());

		Page<SampleSB> page = SampleSBResource.getSampleSBsPage(
			null, null, Pagination.of(1, 2), null);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(sampleSB1, sampleSB2),
			(List<SampleSB>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetSampleSBsPageWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		SampleSB sampleSB1 = randomSampleSB();

		sampleSB1 = testGetSampleSBsPage_addSampleSB(sampleSB1);

		for (EntityField entityField : entityFields) {
			Page<SampleSB> page = SampleSBResource.getSampleSBsPage(
				null, getFilterString(entityField, "between", sampleSB1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(sampleSB1),
				(List<SampleSB>)page.getItems());
		}
	}

	@Test
	public void testGetSampleSBsPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		SampleSB sampleSB1 = testGetSampleSBsPage_addSampleSB(randomSampleSB());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		SampleSB sampleSB2 = testGetSampleSBsPage_addSampleSB(randomSampleSB());

		for (EntityField entityField : entityFields) {
			Page<SampleSB> page = SampleSBResource.getSampleSBsPage(
				null, getFilterString(entityField, "eq", sampleSB1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(sampleSB1),
				(List<SampleSB>)page.getItems());
		}
	}

	@Test
	public void testGetSampleSBsPageWithPagination() throws Exception {
		SampleSB sampleSB1 = testGetSampleSBsPage_addSampleSB(randomSampleSB());

		SampleSB sampleSB2 = testGetSampleSBsPage_addSampleSB(randomSampleSB());

		SampleSB sampleSB3 = testGetSampleSBsPage_addSampleSB(randomSampleSB());

		Page<SampleSB> page1 = SampleSBResource.getSampleSBsPage(
			null, null, Pagination.of(1, 2), null);

		List<SampleSB> sampleSBs1 = (List<SampleSB>)page1.getItems();

		Assert.assertEquals(sampleSBs1.toString(), 2, sampleSBs1.size());

		Page<SampleSB> page2 = SampleSBResource.getSampleSBsPage(
			null, null, Pagination.of(2, 2), null);

		Assert.assertEquals(3, page2.getTotalCount());

		List<SampleSB> sampleSBs2 = (List<SampleSB>)page2.getItems();

		Assert.assertEquals(sampleSBs2.toString(), 1, sampleSBs2.size());

		assertEqualsIgnoringOrder(
			Arrays.asList(sampleSB1, sampleSB2, sampleSB3),
			new ArrayList<SampleSB>() {
				{
					addAll(sampleSBs1);
					addAll(sampleSBs2);
				}
			});
	}

	@Test
	public void testGetSampleSBsPageWithSortDateTime() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		SampleSB sampleSB1 = randomSampleSB();
		SampleSB sampleSB2 = randomSampleSB();

		for (EntityField entityField : entityFields) {
			BeanUtils.setProperty(
				sampleSB1, entityField.getName(),
				DateUtils.addMinutes(new Date(), -2));
		}

		sampleSB1 = testGetSampleSBsPage_addSampleSB(sampleSB1);

		sampleSB2 = testGetSampleSBsPage_addSampleSB(sampleSB2);

		for (EntityField entityField : entityFields) {
			Page<SampleSB> ascPage = SampleSBResource.getSampleSBsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(sampleSB1, sampleSB2),
				(List<SampleSB>)ascPage.getItems());

			Page<SampleSB> descPage = SampleSBResource.getSampleSBsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(sampleSB2, sampleSB1),
				(List<SampleSB>)descPage.getItems());
		}
	}

	@Test
	public void testGetSampleSBsPageWithSortString() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		SampleSB sampleSB1 = randomSampleSB();
		SampleSB sampleSB2 = randomSampleSB();

		for (EntityField entityField : entityFields) {
			BeanUtils.setProperty(sampleSB1, entityField.getName(), "Aaa");
			BeanUtils.setProperty(sampleSB2, entityField.getName(), "Bbb");
		}

		sampleSB1 = testGetSampleSBsPage_addSampleSB(sampleSB1);

		sampleSB2 = testGetSampleSBsPage_addSampleSB(sampleSB2);

		for (EntityField entityField : entityFields) {
			Page<SampleSB> ascPage = SampleSBResource.getSampleSBsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(sampleSB1, sampleSB2),
				(List<SampleSB>)ascPage.getItems());

			Page<SampleSB> descPage = SampleSBResource.getSampleSBsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(sampleSB2, sampleSB1),
				(List<SampleSB>)descPage.getItems());
		}
	}

	protected SampleSB testGetSampleSBsPage_addSampleSB(SampleSB sampleSB)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPostSampleSB() throws Exception {
		SampleSB randomSampleSB = randomSampleSB();

		SampleSB postSampleSB = testPostSampleSB_addSampleSB(randomSampleSB);

		assertEquals(randomSampleSB, postSampleSB);
		assertValid(postSampleSB);
	}

	protected SampleSB testPostSampleSB_addSampleSB(SampleSB sampleSB)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteSampleSB() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGetSampleSB() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testPutSampleSB() throws Exception {
		Assert.assertTrue(true);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(SampleSB sampleSB1, SampleSB sampleSB2) {
		Assert.assertTrue(
			sampleSB1 + " does not equal " + sampleSB2,
			equals(sampleSB1, sampleSB2));
	}

	protected void assertEquals(
		List<SampleSB> sampleSBs1, List<SampleSB> sampleSBs2) {

		Assert.assertEquals(sampleSBs1.size(), sampleSBs2.size());

		for (int i = 0; i < sampleSBs1.size(); i++) {
			SampleSB sampleSB1 = sampleSBs1.get(i);
			SampleSB sampleSB2 = sampleSBs2.get(i);

			assertEquals(sampleSB1, sampleSB2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<SampleSB> sampleSBs1, List<SampleSB> sampleSBs2) {

		Assert.assertEquals(sampleSBs1.size(), sampleSBs2.size());

		for (SampleSB sampleSB1 : sampleSBs1) {
			boolean contains = false;

			for (SampleSB sampleSB2 : sampleSBs2) {
				if (equals(sampleSB1, sampleSB2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				sampleSBs2 + " does not contain " + sampleSB1, contains);
		}
	}

	protected void assertValid(SampleSB sampleSB) {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("date", additionalAssertFieldName)) {
				if (sampleSB.getDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("endTime", additionalAssertFieldName)) {
				if (sampleSB.getEndTime() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (sampleSB.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("sampleSbId", additionalAssertFieldName)) {
				if (sampleSB.getSampleSbId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("startTime", additionalAssertFieldName)) {
				if (sampleSB.getStartTime() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<SampleSB> page) {
		boolean valid = false;

		Collection<SampleSB> sampleSBs = page.getItems();

		int size = sampleSBs.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected boolean equals(SampleSB sampleSB1, SampleSB sampleSB2) {
		if (sampleSB1 == sampleSB2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("date", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						sampleSB1.getDate(), sampleSB2.getDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("endTime", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						sampleSB1.getEndTime(), sampleSB2.getEndTime())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						sampleSB1.getName(), sampleSB2.getName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("sampleSbId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						sampleSB1.getSampleSbId(), sampleSB2.getSampleSbId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("startTime", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						sampleSB1.getStartTime(), sampleSB2.getStartTime())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected Collection<EntityField> getEntityFields() throws Exception {
		if (!(_sampleSBResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_sampleSBResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField -> Objects.equals(entityField.getType(), type)
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, SampleSB sampleSB) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("date")) {
			sb.append("'");
			sb.append(String.valueOf(sampleSB.getDate()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("endTime")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(sampleSB.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("sampleSbId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("startTime")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected SampleSB randomSampleSB() throws Exception {
		return new SampleSB() {
			{
				date = RandomTestUtil.randomString();
				name = RandomTestUtil.randomString();
				sampleSbId = RandomTestUtil.randomLong();
			}
		};
	}

	protected SampleSB randomIrrelevantSampleSB() throws Exception {
		SampleSB randomIrrelevantSampleSB = randomSampleSB();

		return randomIrrelevantSampleSB;
	}

	protected SampleSB randomPatchSampleSB() throws Exception {
		return randomSampleSB();
	}

	protected Group irrelevantGroup;
	protected Group testGroup;
	protected Locale testLocale;
	protected String testUserNameAndPassword = "test@liferay.com:test";

	private static final Log _log = LogFactoryUtil.getLog(
		BaseSampleSBResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private com.liferay.sb.test.headless.resource.v1_0.SampleSBResource
		_sampleSBResource;

}