package com.liferay.sb.test.headless.client.dto.v1_0;

import com.liferay.sb.test.headless.client.function.UnsafeSupplier;
import com.liferay.sb.test.headless.client.serdes.v1_0.SampleSBAppSerDes;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Yasuyuki Takeo
 * @generated
 */
@Generated("")
public class SampleSBApp {

	public Long getSampleSbId() {
		return sampleSbId;
	}

	public void setSampleSbId(Long sampleSbId) {
		this.sampleSbId = sampleSbId;
	}

	public void setSampleSbId(
		UnsafeSupplier<Long, Exception> sampleSbIdUnsafeSupplier) {

		try {
			sampleSbId = sampleSbIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long sampleSbId;

	public Boolean getSamplesbBooleanStat() {
		return samplesbBooleanStat;
	}

	public void setSamplesbBooleanStat(Boolean samplesbBooleanStat) {
		this.samplesbBooleanStat = samplesbBooleanStat;
	}

	public void setSamplesbBooleanStat(
		UnsafeSupplier<Boolean, Exception> samplesbBooleanStatUnsafeSupplier) {

		try {
			samplesbBooleanStat = samplesbBooleanStatUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean samplesbBooleanStat;

	public String getSamplesbDateTime() {
		return samplesbDateTime;
	}

	public void setSamplesbDateTime(String samplesbDateTime) {
		this.samplesbDateTime = samplesbDateTime;
	}

	public void setSamplesbDateTime(
		UnsafeSupplier<String, Exception> samplesbDateTimeUnsafeSupplier) {

		try {
			samplesbDateTime = samplesbDateTimeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String samplesbDateTime;

	public String getSamplesbDocumentLibrary() {
		return samplesbDocumentLibrary;
	}

	public void setSamplesbDocumentLibrary(String samplesbDocumentLibrary) {
		this.samplesbDocumentLibrary = samplesbDocumentLibrary;
	}

	public void setSamplesbDocumentLibrary(
		UnsafeSupplier<String, Exception>
			samplesbDocumentLibraryUnsafeSupplier) {

		try {
			samplesbDocumentLibrary =
				samplesbDocumentLibraryUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String samplesbDocumentLibrary;

	public Double getSamplesbDouble() {
		return samplesbDouble;
	}

	public void setSamplesbDouble(Double samplesbDouble) {
		this.samplesbDouble = samplesbDouble;
	}

	public void setSamplesbDouble(
		UnsafeSupplier<Double, Exception> samplesbDoubleUnsafeSupplier) {

		try {
			samplesbDouble = samplesbDoubleUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Double samplesbDouble;

	public Integer getSamplesbInteger() {
		return samplesbInteger;
	}

	public void setSamplesbInteger(Integer samplesbInteger) {
		this.samplesbInteger = samplesbInteger;
	}

	public void setSamplesbInteger(
		UnsafeSupplier<Integer, Exception> samplesbIntegerUnsafeSupplier) {

		try {
			samplesbInteger = samplesbIntegerUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer samplesbInteger;

	public String getSamplesbRichText() {
		return samplesbRichText;
	}

	public void setSamplesbRichText(String samplesbRichText) {
		this.samplesbRichText = samplesbRichText;
	}

	public void setSamplesbRichText(
		UnsafeSupplier<String, Exception> samplesbRichTextUnsafeSupplier) {

		try {
			samplesbRichText = samplesbRichTextUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String samplesbRichText;

	public String getSamplesbSummaryName() {
		return samplesbSummaryName;
	}

	public void setSamplesbSummaryName(String samplesbSummaryName) {
		this.samplesbSummaryName = samplesbSummaryName;
	}

	public void setSamplesbSummaryName(
		UnsafeSupplier<String, Exception> samplesbSummaryNameUnsafeSupplier) {

		try {
			samplesbSummaryName = samplesbSummaryNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String samplesbSummaryName;

	public String getSamplesbText() {
		return samplesbText;
	}

	public void setSamplesbText(String samplesbText) {
		this.samplesbText = samplesbText;
	}

	public void setSamplesbText(
		UnsafeSupplier<String, Exception> samplesbTextUnsafeSupplier) {

		try {
			samplesbText = samplesbTextUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String samplesbText;

	public String getSamplesbTitleName() {
		return samplesbTitleName;
	}

	public void setSamplesbTitleName(String samplesbTitleName) {
		this.samplesbTitleName = samplesbTitleName;
	}

	public void setSamplesbTitleName(
		UnsafeSupplier<String, Exception> samplesbTitleNameUnsafeSupplier) {

		try {
			samplesbTitleName = samplesbTitleNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String samplesbTitleName;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTitle(
		UnsafeSupplier<String, Exception> titleUnsafeSupplier) {

		try {
			title = titleUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

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
		return SampleSBAppSerDes.toJSON(this);
	}

}