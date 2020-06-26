package com.liferay.sb.test.headless.client.serdes.v1_0;

import com.liferay.sb.test.headless.client.dto.v1_0.DateTime;
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
public class DateTimeSerDes {

	public static DateTime toDTO(String json) {
		DateTimeJSONParser dateTimeJSONParser = new DateTimeJSONParser();

		return dateTimeJSONParser.parseToDTO(json);
	}

	public static DateTime[] toDTOs(String json) {
		DateTimeJSONParser dateTimeJSONParser = new DateTimeJSONParser();

		return dateTimeJSONParser.parseToDTOs(json);
	}

	public static String toJSON(DateTime dateTime) {
		if (dateTime == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (dateTime.getData() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"data\": ");

			sb.append("\"");

			sb.append(_escape(dateTime.getData()));

			sb.append("\"");
		}

		if (dateTime.getFormat() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"format\": ");

			sb.append("\"");

			sb.append(_escape(dateTime.getFormat()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		DateTimeJSONParser dateTimeJSONParser = new DateTimeJSONParser();

		return dateTimeJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(DateTime dateTime) {
		if (dateTime == null) {
			return null;
		}

		Map<String, String> map = new HashMap<>();

		if (dateTime.getData() == null) {
			map.put("data", null);
		}
		else {
			map.put("data", String.valueOf(dateTime.getData()));
		}

		if (dateTime.getFormat() == null) {
			map.put("format", null);
		}
		else {
			map.put("format", String.valueOf(dateTime.getFormat()));
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

	private static class DateTimeJSONParser extends BaseJSONParser<DateTime> {

		@Override
		protected DateTime createDTO() {
			return new DateTime();
		}

		@Override
		protected DateTime[] createDTOArray(int size) {
			return new DateTime[size];
		}

		@Override
		protected void setField(
			DateTime dateTime, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "data")) {
				if (jsonParserFieldValue != null) {
					dateTime.setData((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "format")) {
				if (jsonParserFieldValue != null) {
					dateTime.setFormat((String)jsonParserFieldValue);
				}
			}
			else {
				throw new IllegalArgumentException(
					"Unsupported field name " + jsonParserFieldName);
			}
		}

	}

}