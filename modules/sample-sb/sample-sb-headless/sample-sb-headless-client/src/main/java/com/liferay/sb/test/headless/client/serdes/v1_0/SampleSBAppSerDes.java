package com.liferay.sb.test.headless.client.serdes.v1_0;

import com.liferay.sb.test.headless.client.dto.v1_0.SampleSBApp;
import com.liferay.sb.test.headless.client.json.BaseJSONParser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

/**
 * @author Yasuyuki Takeo
 * @generated
 */
@Generated("")
public class SampleSBAppSerDes {

	public static SampleSBApp toDTO(String json) {
		SampleSBAppJSONParser sampleSBAppJSONParser =
			new SampleSBAppJSONParser();

		return sampleSBAppJSONParser.parseToDTO(json);
	}

	public static SampleSBApp[] toDTOs(String json) {
		SampleSBAppJSONParser sampleSBAppJSONParser =
			new SampleSBAppJSONParser();

		return sampleSBAppJSONParser.parseToDTOs(json);
	}

	public static String toJSON(SampleSBApp sampleSBApp) {
		if (sampleSBApp == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (sampleSBApp.getSampleSbId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"sampleSbId\": ");

			sb.append(sampleSBApp.getSampleSbId());
		}

		if (sampleSBApp.getSamplesbBooleanStat() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"samplesbBooleanStat\": ");

			sb.append(sampleSBApp.getSamplesbBooleanStat());
		}

		if (sampleSBApp.getSamplesbDateTime() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"samplesbDateTime\": ");

			sb.append("\"");

			sb.append(_escape(sampleSBApp.getSamplesbDateTime()));

			sb.append("\"");
		}

		if (sampleSBApp.getSamplesbDocumentLibrary() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"samplesbDocumentLibrary\": ");

			sb.append("\"");

			sb.append(_escape(sampleSBApp.getSamplesbDocumentLibrary()));

			sb.append("\"");
		}

		if (sampleSBApp.getSamplesbDouble() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"samplesbDouble\": ");

			sb.append(sampleSBApp.getSamplesbDouble());
		}

		if (sampleSBApp.getSamplesbInteger() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"samplesbInteger\": ");

			sb.append(sampleSBApp.getSamplesbInteger());
		}

		if (sampleSBApp.getSamplesbRichText() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"samplesbRichText\": ");

			sb.append("\"");

			sb.append(_escape(sampleSBApp.getSamplesbRichText()));

			sb.append("\"");
		}

		if (sampleSBApp.getSamplesbSummaryName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"samplesbSummaryName\": ");

			sb.append("\"");

			sb.append(_escape(sampleSBApp.getSamplesbSummaryName()));

			sb.append("\"");
		}

		if (sampleSBApp.getSamplesbText() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"samplesbText\": ");

			sb.append("\"");

			sb.append(_escape(sampleSBApp.getSamplesbText()));

			sb.append("\"");
		}

		if (sampleSBApp.getSamplesbTitleName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"samplesbTitleName\": ");

			sb.append("\"");

			sb.append(_escape(sampleSBApp.getSamplesbTitleName()));

			sb.append("\"");
		}

		if (sampleSBApp.getTitle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(sampleSBApp.getTitle()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		SampleSBAppJSONParser sampleSBAppJSONParser =
			new SampleSBAppJSONParser();

		return sampleSBAppJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(SampleSBApp sampleSBApp) {
		if (sampleSBApp == null) {
			return null;
		}

		Map<String, String> map = new HashMap<>();

		if (sampleSBApp.getSampleSbId() == null) {
			map.put("sampleSbId", null);
		}
		else {
			map.put("sampleSbId", String.valueOf(sampleSBApp.getSampleSbId()));
		}

		if (sampleSBApp.getSamplesbBooleanStat() == null) {
			map.put("samplesbBooleanStat", null);
		}
		else {
			map.put(
				"samplesbBooleanStat",
				String.valueOf(sampleSBApp.getSamplesbBooleanStat()));
		}

		if (sampleSBApp.getSamplesbDateTime() == null) {
			map.put("samplesbDateTime", null);
		}
		else {
			map.put(
				"samplesbDateTime",
				String.valueOf(sampleSBApp.getSamplesbDateTime()));
		}

		if (sampleSBApp.getSamplesbDocumentLibrary() == null) {
			map.put("samplesbDocumentLibrary", null);
		}
		else {
			map.put(
				"samplesbDocumentLibrary",
				String.valueOf(sampleSBApp.getSamplesbDocumentLibrary()));
		}

		if (sampleSBApp.getSamplesbDouble() == null) {
			map.put("samplesbDouble", null);
		}
		else {
			map.put(
				"samplesbDouble",
				String.valueOf(sampleSBApp.getSamplesbDouble()));
		}

		if (sampleSBApp.getSamplesbInteger() == null) {
			map.put("samplesbInteger", null);
		}
		else {
			map.put(
				"samplesbInteger",
				String.valueOf(sampleSBApp.getSamplesbInteger()));
		}

		if (sampleSBApp.getSamplesbRichText() == null) {
			map.put("samplesbRichText", null);
		}
		else {
			map.put(
				"samplesbRichText",
				String.valueOf(sampleSBApp.getSamplesbRichText()));
		}

		if (sampleSBApp.getSamplesbSummaryName() == null) {
			map.put("samplesbSummaryName", null);
		}
		else {
			map.put(
				"samplesbSummaryName",
				String.valueOf(sampleSBApp.getSamplesbSummaryName()));
		}

		if (sampleSBApp.getSamplesbText() == null) {
			map.put("samplesbText", null);
		}
		else {
			map.put(
				"samplesbText", String.valueOf(sampleSBApp.getSamplesbText()));
		}

		if (sampleSBApp.getSamplesbTitleName() == null) {
			map.put("samplesbTitleName", null);
		}
		else {
			map.put(
				"samplesbTitleName",
				String.valueOf(sampleSBApp.getSamplesbTitleName()));
		}

		if (sampleSBApp.getTitle() == null) {
			map.put("title", null);
		}
		else {
			map.put("title", String.valueOf(sampleSBApp.getTitle()));
		}

		return map;
	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		return string.replaceAll("\"", "\\\\\"");
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\":");
			sb.append("\"");
			sb.append(entry.getValue());
			sb.append("\"");

			if (iterator.hasNext()) {
				sb.append(",");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static class SampleSBAppJSONParser
		extends BaseJSONParser<SampleSBApp> {

		@Override
		protected SampleSBApp createDTO() {
			return new SampleSBApp();
		}

		@Override
		protected SampleSBApp[] createDTOArray(int size) {
			return new SampleSBApp[size];
		}

		@Override
		protected void setField(
			SampleSBApp sampleSBApp, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "sampleSbId")) {
				if (jsonParserFieldValue != null) {
					sampleSBApp.setSampleSbId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "samplesbBooleanStat")) {

				if (jsonParserFieldValue != null) {
					sampleSBApp.setSamplesbBooleanStat(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "samplesbDateTime")) {
				if (jsonParserFieldValue != null) {
					sampleSBApp.setSamplesbDateTime(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "samplesbDocumentLibrary")) {

				if (jsonParserFieldValue != null) {
					sampleSBApp.setSamplesbDocumentLibrary(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "samplesbDouble")) {
				if (jsonParserFieldValue != null) {
					sampleSBApp.setSamplesbDouble((Double)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "samplesbInteger")) {
				if (jsonParserFieldValue != null) {
					sampleSBApp.setSamplesbInteger(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "samplesbRichText")) {
				if (jsonParserFieldValue != null) {
					sampleSBApp.setSamplesbRichText(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "samplesbSummaryName")) {

				if (jsonParserFieldValue != null) {
					sampleSBApp.setSamplesbSummaryName(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "samplesbText")) {
				if (jsonParserFieldValue != null) {
					sampleSBApp.setSamplesbText((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "samplesbTitleName")) {
				if (jsonParserFieldValue != null) {
					sampleSBApp.setSamplesbTitleName(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "title")) {
				if (jsonParserFieldValue != null) {
					sampleSBApp.setTitle((String)jsonParserFieldValue);
				}
			}
			else {
				throw new IllegalArgumentException(
					"Unsupported field name " + jsonParserFieldName);
			}
		}

	}

}