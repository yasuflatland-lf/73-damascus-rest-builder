package com.liferay.sb.test.headless.client.serdes.v1_0;

import com.liferay.sb.test.headless.client.dto.v1_0.SampleSB;
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
public class SampleSBSerDes {

	public static SampleSB toDTO(String json) {
		SampleSBJSONParser sampleSBJSONParser = new SampleSBJSONParser();

		return sampleSBJSONParser.parseToDTO(json);
	}

	public static SampleSB[] toDTOs(String json) {
		SampleSBJSONParser sampleSBJSONParser = new SampleSBJSONParser();

		return sampleSBJSONParser.parseToDTOs(json);
	}

	public static String toJSON(SampleSB sampleSB) {
		if (sampleSB == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (sampleSB.getDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"date\": ");

			sb.append("\"");

			sb.append(_escape(sampleSB.getDate()));

			sb.append("\"");
		}

		if (sampleSB.getEndTime() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"endTime\": ");

			sb.append(String.valueOf(sampleSB.getEndTime()));
		}

		if (sampleSB.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(sampleSB.getName()));

			sb.append("\"");
		}

		if (sampleSB.getSampleSbId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"sampleSbId\": ");

			sb.append(sampleSB.getSampleSbId());
		}

		if (sampleSB.getStartTime() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"startTime\": ");

			sb.append(String.valueOf(sampleSB.getStartTime()));
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		SampleSBJSONParser sampleSBJSONParser = new SampleSBJSONParser();

		return sampleSBJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(SampleSB sampleSB) {
		if (sampleSB == null) {
			return null;
		}

		Map<String, String> map = new HashMap<>();

		if (sampleSB.getDate() == null) {
			map.put("date", null);
		}
		else {
			map.put("date", String.valueOf(sampleSB.getDate()));
		}

		if (sampleSB.getEndTime() == null) {
			map.put("endTime", null);
		}
		else {
			map.put("endTime", String.valueOf(sampleSB.getEndTime()));
		}

		if (sampleSB.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(sampleSB.getName()));
		}

		if (sampleSB.getSampleSbId() == null) {
			map.put("sampleSbId", null);
		}
		else {
			map.put("sampleSbId", String.valueOf(sampleSB.getSampleSbId()));
		}

		if (sampleSB.getStartTime() == null) {
			map.put("startTime", null);
		}
		else {
			map.put("startTime", String.valueOf(sampleSB.getStartTime()));
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

	private static class SampleSBJSONParser extends BaseJSONParser<SampleSB> {

		@Override
		protected SampleSB createDTO() {
			return new SampleSB();
		}

		@Override
		protected SampleSB[] createDTOArray(int size) {
			return new SampleSB[size];
		}

		@Override
		protected void setField(
			SampleSB sampleSB, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "date")) {
				if (jsonParserFieldValue != null) {
					sampleSB.setDate((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "endTime")) {
				if (jsonParserFieldValue != null) {
					sampleSB.setEndTime(
						TimeSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					sampleSB.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "sampleSbId")) {
				if (jsonParserFieldValue != null) {
					sampleSB.setSampleSbId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "startTime")) {
				if (jsonParserFieldValue != null) {
					sampleSB.setStartTime(
						TimeSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else {
				throw new IllegalArgumentException(
					"Unsupported field name " + jsonParserFieldName);
			}
		}

	}

}