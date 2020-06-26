package com.liferay.sb.test.headless.client.dto.v1_0;

import com.liferay.sb.test.headless.client.function.UnsafeSupplier;
import com.liferay.sb.test.headless.client.serdes.v1_0.DateTimeSerDes;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Yasuyuki Takeo
 * @generated
 */
@Generated("")
public class DateTime {

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setData(UnsafeSupplier<String, Exception> dataUnsafeSupplier) {
		try {
			data = dataUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String data;

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public void setFormat(
		UnsafeSupplier<String, Exception> formatUnsafeSupplier) {

		try {
			format = formatUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String format;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DateTime)) {
			return false;
		}

		DateTime dateTime = (DateTime)object;

		return Objects.equals(toString(), dateTime.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return DateTimeSerDes.toJSON(this);
	}

}