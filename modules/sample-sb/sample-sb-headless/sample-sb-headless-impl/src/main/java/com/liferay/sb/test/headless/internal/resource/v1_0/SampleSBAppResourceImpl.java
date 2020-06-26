package com.liferay.sb.test.headless.internal.resource.v1_0;

import com.liferay.headless.common.spi.service.context.ServiceContextUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.service.ResourceLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.resource.EntityModelResource;
import com.liferay.portal.vulcan.util.SearchUtil;
import com.liferay.sb.test.constants.SampleSBConstants;
import com.liferay.sb.test.headless.dto.v1_0.SampleSBApp;
import com.liferay.sb.test.headless.internal.odata.entity.v1_0.SampleSBAppEntityModel;
import com.liferay.sb.test.headless.resource.v1_0.SampleSBAppResource;
import com.liferay.sb.test.model.SampleSB;
import com.liferay.sb.test.service.SampleSBLocalService;

import java.text.SimpleDateFormat;
import java.util.Collections;

import javax.validation.constraints.NotNull;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.MultivaluedMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Yasuyuki Takeo
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/sample-sb-app.properties",
	scope = ServiceScope.PROTOTYPE, service = SampleSBAppResource.class
)
public class SampleSBAppResourceImpl extends BaseSampleSBAppResourceImpl implements EntityModelResource {

	@Override
	public void deleteSamplesbSampleSb(@NotNull Long sampleSbId) throws Exception {
		_modelResourcePermission.check(PermissionThreadLocal.getPermissionChecker(), sampleSbId, ActionKeys.DELETE);

		_sampleSBLocalService.deleteEntry(sampleSbId);
	}

	@Override
	public SampleSBApp getSamplesbSampleSb(@NotNull Long sampleSbId) throws Exception {
		_modelResourcePermission.check(PermissionThreadLocal.getPermissionChecker(), sampleSbId, ActionKeys.VIEW);

		return _toSampleSB(_sampleSBLocalService.getSampleSB(sampleSbId));
	}

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap) throws Exception {

		return _entityModel;
	}

	@Override
	public Page<SampleSBApp> getSamplesbsPage(String keywords, Filter filter, Pagination pagination, Sort[] sorts)
			throws Exception {
		if (pagination.getPageSize() > 250) {
			throw new BadRequestException(LanguageUtil.format(contextAcceptLanguage.getPreferredLocale(),
					"page-size-is-greater-than-x", 250));
		}

		if (ArrayUtil.isEmpty(sorts)) {
			sorts = new Sort[] { new Sort(Field.getSortableFieldName(Field.MODIFIED_DATE), Sort.STRING_TYPE, true) };
		}

		return SearchUtil.search(Collections.emptyMap(), booleanQuery -> {
		}, null, com.liferay.sb.test.model.SampleSB.class, keywords, pagination,
				queryConfig -> queryConfig.setSelectedFieldNames(Field.ENTRY_CLASS_PK), searchContext -> {
					searchContext.setAttribute(Field.CLASS_NAME_ID,
							_portal.getClassNameId(com.liferay.sb.test.model.SampleSB.class));
					searchContext.setAttribute(Field.NAME, keywords);
					searchContext.setCompanyId(contextCompany.getCompanyId());
				}, sorts, document -> _toSampleSB(
						_sampleSBLocalService.getSampleSB(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)))));
	}

	@Override
	public SampleSBApp postSamplesb(SampleSBApp sampleSb) throws Exception {
		_modelResourcePermission.check(PermissionThreadLocal.getPermissionChecker(), sampleSb.getSampleSbId(), ActionKeys.ADD_ENTRY);
		
		ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();
		
		com.liferay.sb.test.model.SampleSB sampleSbModel = _sampleSBLocalService.addEntry(
				sampleSb.getSampleSbId(), 
				sampleSb.getTitle(),
				sampleSb.getSamplesbBooleanStat(),
				sampleSb.getSamplesbDateTime(), 
				sampleSb.getSamplesbDocumentLibrary(), 
				sampleSb.getSamplesbDouble(),
				sampleSb.getSamplesbInteger(),
				sampleSb.getSamplesbRichText(),
				sampleSb.getSamplesbText(),
				sampleSb.getSamplesbTitleName(),
				sampleSb.getSamplesbSummaryName(),
				serviceContext);
		
		return _toSampleSB(sampleSbModel);		
	}

	@Override
	public SampleSBApp putSamplesbSampleSb(@NotNull Long sampleSbId, @NotNull SampleSBApp sampleSBApp) throws Exception {
		ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();
		
		com.liferay.sb.test.model.SampleSB sampleSbModel = _sampleSBLocalService.updateEntry(
				sampleSBApp.getSampleSbId(), 
				sampleSBApp.getTitle(),
				sampleSBApp.getSamplesbBooleanStat(),
				sampleSBApp.getSamplesbDateTime(), 
				sampleSBApp.getSamplesbDocumentLibrary(), 
				sampleSBApp.getSamplesbDouble(),
				sampleSBApp.getSamplesbInteger(),
				sampleSBApp.getSamplesbRichText(),
				sampleSBApp.getSamplesbText(),
				sampleSBApp.getSamplesbTitleName(),
				sampleSBApp.getSamplesbSummaryName(),
				serviceContext);
		
		return _toSampleSB(sampleSbModel);			
	}

	/**
	 * REST to Servie Builder Model Converter
	 * 
	 * @param sampleSb
	 * @return
	 */
	protected SampleSBApp _toSampleSB(SampleSB sampleSB) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return new SampleSBApp() {
			{
				sampleSbId = sampleSB.getPrimaryKey();
				title = sampleSB.getTitle();
				samplesbBooleanStat = sampleSB.getSamplesbBooleanStat();
				samplesbDateTime = simpleDateFormat.format(sampleSB.getSamplesbDateTime());
				samplesbDocumentLibrary = sampleSB.getSamplesbDocumentLibrary();
				samplesbDouble = sampleSB.getSamplesbDouble();
				samplesbInteger = sampleSB.getSamplesbInteger();
				samplesbRichText = sampleSB.getSamplesbRichText();
				samplesbText = sampleSB.getSamplesbText();
				samplesbTitleName = sampleSB.getSamplesbTitleName();
				samplesbSummaryName = sampleSB.getSamplesbSummaryName();
			}
		};
	}

	protected ServiceContext _getServiceContext() {
		ServiceContext serviceContext = ServiceContextUtil.createServiceContext(0, "anyone");
		serviceContext.setCompanyId(contextCompany.getCompanyId());

		long userId = PrincipalThreadLocal.getUserId();
		serviceContext.setUserId(userId);

		return serviceContext;
	}

	private static final EntityModel _entityModel = new SampleSBAppEntityModel();

	@Reference
	private SampleSBLocalService _sampleSBLocalService;

	private ModelResourcePermission<com.liferay.sb.test.model.SampleSB> _modelResourcePermission;

	@Reference
	private Portal _portal;

	@Reference(target = "(resource.name=" + SampleSBConstants.RESOURCE_NAME + ")")
	private PortletResourcePermission _portletResourcePermission;

	@Reference
	private ResourceLocalService _resourceLocalService;
	
}