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
import com.liferay.sb.test.headless.client.dto.v1_0.SampleSBApp;
import com.liferay.sb.test.headless.client.http.HttpInvoker;
import com.liferay.sb.test.headless.client.pagination.Page;
import com.liferay.sb.test.headless.client.pagination.Pagination;
import com.liferay.sb.test.headless.client.resource.v1_0.SampleSBAppResource;
import com.liferay.sb.test.headless.client.serdes.v1_0.SampleSBAppSerDes;

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
public abstract class BaseSampleSBAppResourceTestCase {

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

		SampleSBApp sampleSBApp1 = randomSampleSBApp();

		String json = objectMapper.writeValueAsString(sampleSBApp1);

		SampleSBApp sampleSBApp2 = SampleSBAppSerDes.toDTO(json);

		Assert.assertTrue(equals(sampleSBApp1, sampleSBApp2));
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

		SampleSBApp sampleSBApp = randomSampleSBApp();

		String json1 = objectMapper.writeValueAsString(sampleSBApp);
		String json2 = SampleSBAppSerDes.toJSON(sampleSBApp);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testGetSamplesbsPage() throws Exception {
		SampleSBApp sampleSBApp1 = testGetSamplesbsPage_addSampleSBApp(
			randomSampleSBApp());

		SampleSBApp sampleSBApp2 = testGetSamplesbsPage_addSampleSBApp(
			randomSampleSBApp());

		Page<SampleSBApp> page = SampleSBAppResource.getSamplesbsPage(
			null, null, Pagination.of(1, 2), null);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(sampleSBApp1, sampleSBApp2),
			(List<SampleSBApp>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetSamplesbsPageWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		SampleSBApp sampleSBApp1 = randomSampleSBApp();

		sampleSBApp1 = testGetSamplesbsPage_addSampleSBApp(sampleSBApp1);

		for (EntityField entityField : entityFields) {
			Page<SampleSBApp> page = SampleSBAppResource.getSamplesbsPage(
				null, getFilterString(entityField, "between", sampleSBApp1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(sampleSBApp1),
				(List<SampleSBApp>)page.getItems());
		}
	}

	@Test
	public void testGetSamplesbsPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		SampleSBApp sampleSBApp1 = testGetSamplesbsPage_addSampleSBApp(
			randomSampleSBApp());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		SampleSBApp sampleSBApp2 = testGetSamplesbsPage_addSampleSBApp(
			randomSampleSBApp());

		for (EntityField entityField : entityFields) {
			Page<SampleSBApp> page = SampleSBAppResource.getSamplesbsPage(
				null, getFilterString(entityField, "eq", sampleSBApp1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(sampleSBApp1),
				(List<SampleSBApp>)page.getItems());
		}
	}

	@Test
	public void testGetSamplesbsPageWithPagination() throws Exception {
		SampleSBApp sampleSBApp1 = testGetSamplesbsPage_addSampleSBApp(
			randomSampleSBApp());

		SampleSBApp sampleSBApp2 = testGetSamplesbsPage_addSampleSBApp(
			randomSampleSBApp());

		SampleSBApp sampleSBApp3 = testGetSamplesbsPage_addSampleSBApp(
			randomSampleSBApp());

		Page<SampleSBApp> page1 = SampleSBAppResource.getSamplesbsPage(
			null, null, Pagination.of(1, 2), null);

		List<SampleSBApp> sampleSBApps1 = (List<SampleSBApp>)page1.getItems();

		Assert.assertEquals(sampleSBApps1.toString(), 2, sampleSBApps1.size());

		Page<SampleSBApp> page2 = SampleSBAppResource.getSamplesbsPage(
			null, null, Pagination.of(2, 2), null);

		Assert.assertEquals(3, page2.getTotalCount());

		List<SampleSBApp> sampleSBApps2 = (List<SampleSBApp>)page2.getItems();

		Assert.assertEquals(sampleSBApps2.toString(), 1, sampleSBApps2.size());

		assertEqualsIgnoringOrder(
			Arrays.asList(sampleSBApp1, sampleSBApp2, sampleSBApp3),
			new ArrayList<SampleSBApp>() {
				{
					addAll(sampleSBApps1);
					addAll(sampleSBApps2);
				}
			});
	}

	@Test
	public void testGetSamplesbsPageWithSortDateTime() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		SampleSBApp sampleSBApp1 = randomSampleSBApp();
		SampleSBApp sampleSBApp2 = randomSampleSBApp();

		for (EntityField entityField : entityFields) {
			BeanUtils.setProperty(
				sampleSBApp1, entityField.getName(),
				DateUtils.addMinutes(new Date(), -2));
		}

		sampleSBApp1 = testGetSamplesbsPage_addSampleSBApp(sampleSBApp1);

		sampleSBApp2 = testGetSamplesbsPage_addSampleSBApp(sampleSBApp2);

		for (EntityField entityField : entityFields) {
			Page<SampleSBApp> ascPage = SampleSBAppResource.getSamplesbsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(sampleSBApp1, sampleSBApp2),
				(List<SampleSBApp>)ascPage.getItems());

			Page<SampleSBApp> descPage = SampleSBAppResource.getSamplesbsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(sampleSBApp2, sampleSBApp1),
				(List<SampleSBApp>)descPage.getItems());
		}
	}

	@Test
	public void testGetSamplesbsPageWithSortString() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		SampleSBApp sampleSBApp1 = randomSampleSBApp();
		SampleSBApp sampleSBApp2 = randomSampleSBApp();

		for (EntityField entityField : entityFields) {
			BeanUtils.setProperty(sampleSBApp1, entityField.getName(), "Aaa");
			BeanUtils.setProperty(sampleSBApp2, entityField.getName(), "Bbb");
		}

		sampleSBApp1 = testGetSamplesbsPage_addSampleSBApp(sampleSBApp1);

		sampleSBApp2 = testGetSamplesbsPage_addSampleSBApp(sampleSBApp2);

		for (EntityField entityField : entityFields) {
			Page<SampleSBApp> ascPage = SampleSBAppResource.getSamplesbsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(sampleSBApp1, sampleSBApp2),
				(List<SampleSBApp>)ascPage.getItems());

			Page<SampleSBApp> descPage = SampleSBAppResource.getSamplesbsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(sampleSBApp2, sampleSBApp1),
				(List<SampleSBApp>)descPage.getItems());
		}
	}

	protected SampleSBApp testGetSamplesbsPage_addSampleSBApp(
			SampleSBApp sampleSBApp)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPostSamplesb() throws Exception {
		SampleSBApp randomSampleSBApp = randomSampleSBApp();

		SampleSBApp postSampleSBApp = testPostSamplesb_addSampleSBApp(
			randomSampleSBApp);

		assertEquals(randomSampleSBApp, postSampleSBApp);
		assertValid(postSampleSBApp);
	}

	protected SampleSBApp testPostSamplesb_addSampleSBApp(
			SampleSBApp sampleSBApp)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteSamplesbSampleSb() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGetSamplesbSampleSb() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testPutSamplesbSampleSb() throws Exception {
		Assert.assertTrue(true);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		SampleSBApp sampleSBApp1, SampleSBApp sampleSBApp2) {

		Assert.assertTrue(
			sampleSBApp1 + " does not equal " + sampleSBApp2,
			equals(sampleSBApp1, sampleSBApp2));
	}

	protected void assertEquals(
		List<SampleSBApp> sampleSBApps1, List<SampleSBApp> sampleSBApps2) {

		Assert.assertEquals(sampleSBApps1.size(), sampleSBApps2.size());

		for (int i = 0; i < sampleSBApps1.size(); i++) {
			SampleSBApp sampleSBApp1 = sampleSBApps1.get(i);
			SampleSBApp sampleSBApp2 = sampleSBApps2.get(i);

			assertEquals(sampleSBApp1, sampleSBApp2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<SampleSBApp> sampleSBApps1, List<SampleSBApp> sampleSBApps2) {

		Assert.assertEquals(sampleSBApps1.size(), sampleSBApps2.size());

		for (SampleSBApp sampleSBApp1 : sampleSBApps1) {
			boolean contains = false;

			for (SampleSBApp sampleSBApp2 : sampleSBApps2) {
				if (equals(sampleSBApp1, sampleSBApp2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				sampleSBApps2 + " does not contain " + sampleSBApp1, contains);
		}
	}

	protected void assertValid(SampleSBApp sampleSBApp) {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("sampleSbId", additionalAssertFieldName)) {
				if (sampleSBApp.getSampleSbId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"samplesbBooleanStat", additionalAssertFieldName)) {

				if (sampleSBApp.getSamplesbBooleanStat() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("samplesbDateTime", additionalAssertFieldName)) {
				if (sampleSBApp.getSamplesbDateTime() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"samplesbDocumentLibrary", additionalAssertFieldName)) {

				if (sampleSBApp.getSamplesbDocumentLibrary() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("samplesbDouble", additionalAssertFieldName)) {
				if (sampleSBApp.getSamplesbDouble() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("samplesbInteger", additionalAssertFieldName)) {
				if (sampleSBApp.getSamplesbInteger() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("samplesbRichText", additionalAssertFieldName)) {
				if (sampleSBApp.getSamplesbRichText() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"samplesbSummaryName", additionalAssertFieldName)) {

				if (sampleSBApp.getSamplesbSummaryName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("samplesbText", additionalAssertFieldName)) {
				if (sampleSBApp.getSamplesbText() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"samplesbTitleName", additionalAssertFieldName)) {

				if (sampleSBApp.getSamplesbTitleName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("title", additionalAssertFieldName)) {
				if (sampleSBApp.getTitle() == null) {
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

	protected void assertValid(Page<SampleSBApp> page) {
		boolean valid = false;

		Collection<SampleSBApp> sampleSBApps = page.getItems();

		int size = sampleSBApps.size();

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

	protected boolean equals(
		SampleSBApp sampleSBApp1, SampleSBApp sampleSBApp2) {

		if (sampleSBApp1 == sampleSBApp2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("sampleSbId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						sampleSBApp1.getSampleSbId(),
						sampleSBApp2.getSampleSbId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"samplesbBooleanStat", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						sampleSBApp1.getSamplesbBooleanStat(),
						sampleSBApp2.getSamplesbBooleanStat())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("samplesbDateTime", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						sampleSBApp1.getSamplesbDateTime(),
						sampleSBApp2.getSamplesbDateTime())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"samplesbDocumentLibrary", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						sampleSBApp1.getSamplesbDocumentLibrary(),
						sampleSBApp2.getSamplesbDocumentLibrary())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("samplesbDouble", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						sampleSBApp1.getSamplesbDouble(),
						sampleSBApp2.getSamplesbDouble())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("samplesbInteger", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						sampleSBApp1.getSamplesbInteger(),
						sampleSBApp2.getSamplesbInteger())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("samplesbRichText", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						sampleSBApp1.getSamplesbRichText(),
						sampleSBApp2.getSamplesbRichText())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"samplesbSummaryName", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						sampleSBApp1.getSamplesbSummaryName(),
						sampleSBApp2.getSamplesbSummaryName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("samplesbText", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						sampleSBApp1.getSamplesbText(),
						sampleSBApp2.getSamplesbText())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"samplesbTitleName", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						sampleSBApp1.getSamplesbTitleName(),
						sampleSBApp2.getSamplesbTitleName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("title", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						sampleSBApp1.getTitle(), sampleSBApp2.getTitle())) {

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
		if (!(_sampleSBAppResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_sampleSBAppResource;

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
		EntityField entityField, String operator, SampleSBApp sampleSBApp) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("sampleSbId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("samplesbBooleanStat")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("samplesbDateTime")) {
			sb.append("'");
			sb.append(String.valueOf(sampleSBApp.getSamplesbDateTime()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("samplesbDocumentLibrary")) {
			sb.append("'");
			sb.append(String.valueOf(sampleSBApp.getSamplesbDocumentLibrary()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("samplesbDouble")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("samplesbInteger")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("samplesbRichText")) {
			sb.append("'");
			sb.append(String.valueOf(sampleSBApp.getSamplesbRichText()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("samplesbSummaryName")) {
			sb.append("'");
			sb.append(String.valueOf(sampleSBApp.getSamplesbSummaryName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("samplesbText")) {
			sb.append("'");
			sb.append(String.valueOf(sampleSBApp.getSamplesbText()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("samplesbTitleName")) {
			sb.append("'");
			sb.append(String.valueOf(sampleSBApp.getSamplesbTitleName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("title")) {
			sb.append("'");
			sb.append(String.valueOf(sampleSBApp.getTitle()));
			sb.append("'");

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected SampleSBApp randomSampleSBApp() throws Exception {
		return new SampleSBApp() {
			{
				sampleSbId = RandomTestUtil.randomLong();
				samplesbBooleanStat = RandomTestUtil.randomBoolean();
				samplesbDateTime = RandomTestUtil.randomString();
				samplesbDocumentLibrary = RandomTestUtil.randomString();
				samplesbDouble = RandomTestUtil.randomDouble();
				samplesbRichText = RandomTestUtil.randomString();
				samplesbSummaryName = RandomTestUtil.randomString();
				samplesbText = RandomTestUtil.randomString();
				samplesbTitleName = RandomTestUtil.randomString();
				title = RandomTestUtil.randomString();
			}
		};
	}

	protected SampleSBApp randomIrrelevantSampleSBApp() throws Exception {
		SampleSBApp randomIrrelevantSampleSBApp = randomSampleSBApp();

		return randomIrrelevantSampleSBApp;
	}

	protected SampleSBApp randomPatchSampleSBApp() throws Exception {
		return randomSampleSBApp();
	}

	protected Group irrelevantGroup;
	protected Group testGroup;
	protected Locale testLocale;
	protected String testUserNameAndPassword = "test@liferay.com:test";

	private static final Log _log = LogFactoryUtil.getLog(
		BaseSampleSBAppResourceTestCase.class);

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
	private com.liferay.sb.test.headless.resource.v1_0.SampleSBAppResource
		_sampleSBAppResource;

}