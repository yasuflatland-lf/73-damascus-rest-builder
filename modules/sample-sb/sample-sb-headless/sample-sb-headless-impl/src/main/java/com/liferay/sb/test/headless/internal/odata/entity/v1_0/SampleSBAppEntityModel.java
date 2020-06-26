package com.liferay.sb.test.headless.internal.odata.entity.v1_0;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.StringEntityField;

import java.util.Map;

/**
 * SampleSBApp Entity Model
 * 
 * @author Yasuyuki Takeo
 *
 */
public class SampleSBAppEntityModel implements EntityModel {
	public SampleSBAppEntityModel() {
		_entityFieldsMap = EntityModel.toEntityFieldsMap(
			new StringEntityField(
				"name",
				locale -> Field.getSortableFieldName(
					"localized_name_".concat(
						LocaleUtil.toLanguageId(locale)))));
	}

	@Override
	public Map<String, EntityField> getEntityFieldsMap() {
		return _entityFieldsMap;
	}

	private final Map<String, EntityField> _entityFieldsMap;
}
