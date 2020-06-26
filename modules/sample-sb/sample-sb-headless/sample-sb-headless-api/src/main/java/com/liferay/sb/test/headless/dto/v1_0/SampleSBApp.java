package com.liferay.sb.test.headless.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.validation.constraints.NotEmpty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Yasuyuki Takeo
 * @generated
 */
@Generated("")
@GraphQLName("SampleSBApp")
@JsonFilter("Liferay.Vulcan")
@Schema(requiredProperties = {"title"})
@XmlRootElement(name = "SampleSBApp")
public class SampleSBApp {

	@Schema(description = "The primary key for the SampleSB entity.")
	public Long getSampleSbId() {
		return sampleSbId;
	}

	public void setSampleSbId(Long sampleSbId) {
		this.sampleSbId = sampleSbId;
	}

	@JsonIgnore
	public void setSampleSbId(
		UnsafeSupplier<Long, Exception> sampleSbIdUnsafeSupplier) {

		try {
			sampleSbId = sampleSbIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Long sampleSbId;

	@Schema(description = "SampleSBApp's samplesbBooleanStat.")
	public Boolean getSamplesbBooleanStat() {
		return samplesbBooleanStat;
	}

	public void setSamplesbBooleanStat(Boolean samplesbBooleanStat) {
		this.samplesbBooleanStat = samplesbBooleanStat;
	}

	@JsonIgnore
	public void setSamplesbBooleanStat(
		UnsafeSupplier<Boolean, Exception> samplesbBooleanStatUnsafeSupplier) {

		try {
			samplesbBooleanStat = samplesbBooleanStatUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Boolean samplesbBooleanStat;

	@Schema(description = "SampleSBApp's samplesbDateTime.")
	public String getSamplesbDateTime() {
		return samplesbDateTime;
	}

	public void setSamplesbDateTime(String samplesbDateTime) {
		this.samplesbDateTime = samplesbDateTime;
	}

	@JsonIgnore
	public void setSamplesbDateTime(
		UnsafeSupplier<String, Exception> samplesbDateTimeUnsafeSupplier) {

		try {
			samplesbDateTime = samplesbDateTimeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String samplesbDateTime;

	@Schema(description = "SampleSBApp's samplesbDocumentLibrary.")
	public String getSamplesbDocumentLibrary() {
		return samplesbDocumentLibrary;
	}

	public void setSamplesbDocumentLibrary(String samplesbDocumentLibrary) {
		this.samplesbDocumentLibrary = samplesbDocumentLibrary;
	}

	@JsonIgnore
	public void setSamplesbDocumentLibrary(
		UnsafeSupplier<String, Exception>
			samplesbDocumentLibraryUnsafeSupplier) {

		try {
			samplesbDocumentLibrary =
				samplesbDocumentLibraryUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String samplesbDocumentLibrary;

	@Schema(description = "SampleSBApp's samplesbDouble.")
	public Double getSamplesbDouble() {
		return samplesbDouble;
	}

	public void setSamplesbDouble(Double samplesbDouble) {
		this.samplesbDouble = samplesbDouble;
	}

	@JsonIgnore
	public void setSamplesbDouble(
		UnsafeSupplier<Double, Exception> samplesbDoubleUnsafeSupplier) {

		try {
			samplesbDouble = samplesbDoubleUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Double samplesbDouble;

	@Schema(description = "SampleSBApp's samplesbInteger.")
	public Integer getSamplesbInteger() {
		return samplesbInteger;
	}

	public void setSamplesbInteger(Integer samplesbInteger) {
		this.samplesbInteger = samplesbInteger;
	}

	@JsonIgnore
	public void setSamplesbInteger(
		UnsafeSupplier<Integer, Exception> samplesbIntegerUnsafeSupplier) {

		try {
			samplesbInteger = samplesbIntegerUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Integer samplesbInteger;

	@Schema(description = "SampleSBApp's samplesbRichText.")
	public String getSamplesbRichText() {
		return samplesbRichText;
	}

	public void setSamplesbRichText(String samplesbRichText) {
		this.samplesbRichText = samplesbRichText;
	}

	@JsonIgnore
	public void setSamplesbRichText(
		UnsafeSupplier<String, Exception> samplesbRichTextUnsafeSupplier) {

		try {
			samplesbRichText = samplesbRichTextUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String samplesbRichText;

	@Schema(description = "SampleSBApp's samplesbSummaryName.")
	public String getSamplesbSummaryName() {
		return samplesbSummaryName;
	}

	public void setSamplesbSummaryName(String samplesbSummaryName) {
		this.samplesbSummaryName = samplesbSummaryName;
	}

	@JsonIgnore
	public void setSamplesbSummaryName(
		UnsafeSupplier<String, Exception> samplesbSummaryNameUnsafeSupplier) {

		try {
			samplesbSummaryName = samplesbSummaryNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String samplesbSummaryName;

	@Schema(description = "SampleSBApp's samplesbText.")
	public String getSamplesbText() {
		return samplesbText;
	}

	public void setSamplesbText(String samplesbText) {
		this.samplesbText = samplesbText;
	}

	@JsonIgnore
	public void setSamplesbText(
		UnsafeSupplier<String, Exception> samplesbTextUnsafeSupplier) {

		try {
			samplesbText = samplesbTextUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String samplesbText;

	@Schema(description = "SampleSBApp's samplesbTitleName.")
	public String getSamplesbTitleName() {
		return samplesbTitleName;
	}

	public void setSamplesbTitleName(String samplesbTitleName) {
		this.samplesbTitleName = samplesbTitleName;
	}

	@JsonIgnore
	public void setSamplesbTitleName(
		UnsafeSupplier<String, Exception> samplesbTitleNameUnsafeSupplier) {

		try {
			samplesbTitleName = samplesbTitleNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String samplesbTitleName;

	@Schema(description = "SampleSBApp's title.")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonIgnore
	public void setTitle(
		UnsafeSupplier<String, Exception> titleUnsafeSupplier) {

		try {
			title = titleUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotEmpty
	protected String title;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SampleSBApp)) {
			return false;
		}

		SampleSBApp sampleSBApp = (SampleSBApp)object;

		return Objects.equals(toString(), sampleSBApp.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (sampleSbId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"sampleSbId\": ");

			sb.append(sampleSbId);
		}

		if (samplesbBooleanStat != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"samplesbBooleanStat\": ");

			sb.append(samplesbBooleanStat);
		}

		if (samplesbDateTime != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"samplesbDateTime\": ");

			sb.append("\"");

			sb.append(_escape(samplesbDateTime));

			sb.append("\"");
		}

		if (samplesbDocumentLibrary != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"samplesbDocumentLibrary\": ");

			sb.append("\"");

			sb.append(_escape(samplesbDocumentLibrary));

			sb.append("\"");
		}

		if (samplesbDouble != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"samplesbDouble\": ");

			sb.append(samplesbDouble);
		}

		if (samplesbInteger != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"samplesbInteger\": ");

			sb.append(samplesbInteger);
		}

		if (samplesbRichText != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"samplesbRichText\": ");

			sb.append("\"");

			sb.append(_escape(samplesbRichText));

			sb.append("\"");
		}

		if (samplesbSummaryName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"samplesbSummaryName\": ");

			sb.append("\"");

			sb.append(_escape(samplesbSummaryName));

			sb.append("\"");
		}

		if (samplesbText != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"samplesbText\": ");

			sb.append("\"");

			sb.append(_escape(samplesbText));

			sb.append("\"");
		}

		if (samplesbTitleName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"samplesbTitleName\": ");

			sb.append("\"");

			sb.append(_escape(samplesbTitleName));

			sb.append("\"");
		}

		if (title != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(title));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
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

}