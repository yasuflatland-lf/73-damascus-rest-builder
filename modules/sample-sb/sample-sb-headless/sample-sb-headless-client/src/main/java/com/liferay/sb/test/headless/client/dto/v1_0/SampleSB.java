package com.liferay.sb.test.headless.client.dto.v1_0;

import com.liferay.sb.test.headless.client.function.UnsafeSupplier;
import com.liferay.sb.test.headless.client.serdes.v1_0.SampleSBSerDes;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Yasuyuki Takeo
 * @generated
 */
@Generated("")
public class SampleSB {

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setDate(UnsafeSupplier<String, Exception> dateUnsafeSupplier) {
		try {
			date = dateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String date;

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public void setEndTime(
		UnsafeSupplier<Time, Exception> endTimeUnsafeSupplier) {

		try {
			endTime = endTimeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Time endTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String name;

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

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public void setStartTime(
		UnsafeSupplier<Time, Exception> startTimeUnsafeSupplier) {

		try {
			startTime = startTimeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Time startTime;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SampleSB)) {
			return false;
		}

		SampleSB sampleSB = (SampleSB)object;

		return Objects.equals(toString(), sampleSB.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return SampleSBSerDes.toJSON(this);
	}

}