/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.sb.test.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.sb.test.model.SampleSB;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SampleSB in entity cache.
 *
 * @author "yasuflatland"
 * @generated
 */
public class SampleSBCacheModel
	implements CacheModel<SampleSB>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SampleSBCacheModel)) {
			return false;
		}

		SampleSBCacheModel sampleSBCacheModel = (SampleSBCacheModel)obj;

		if ((samplesbId == sampleSBCacheModel.samplesbId) &&
			(mvccVersion == sampleSBCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, samplesbId);

		return HashUtil.hash(hashCode, mvccVersion);
	}

	@Override
	public long getMvccVersion() {
		return mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", samplesbId=");
		sb.append(samplesbId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", samplesbBooleanStat=");
		sb.append(samplesbBooleanStat);
		sb.append(", samplesbDateTime=");
		sb.append(samplesbDateTime);
		sb.append(", samplesbDocumentLibrary=");
		sb.append(samplesbDocumentLibrary);
		sb.append(", samplesbDouble=");
		sb.append(samplesbDouble);
		sb.append(", samplesbInteger=");
		sb.append(samplesbInteger);
		sb.append(", samplesbRichText=");
		sb.append(samplesbRichText);
		sb.append(", samplesbText=");
		sb.append(samplesbText);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", urlTitle=");
		sb.append(urlTitle);
		sb.append(", samplesbTitleName=");
		sb.append(samplesbTitleName);
		sb.append(", samplesbSummaryName=");
		sb.append(samplesbSummaryName);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SampleSB toEntityModel() {
		SampleSBImpl sampleSBImpl = new SampleSBImpl();

		sampleSBImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			sampleSBImpl.setUuid("");
		}
		else {
			sampleSBImpl.setUuid(uuid);
		}

		sampleSBImpl.setSamplesbId(samplesbId);

		if (title == null) {
			sampleSBImpl.setTitle("");
		}
		else {
			sampleSBImpl.setTitle(title);
		}

		sampleSBImpl.setSamplesbBooleanStat(samplesbBooleanStat);

		if (samplesbDateTime == Long.MIN_VALUE) {
			sampleSBImpl.setSamplesbDateTime(null);
		}
		else {
			sampleSBImpl.setSamplesbDateTime(new Date(samplesbDateTime));
		}

		if (samplesbDocumentLibrary == null) {
			sampleSBImpl.setSamplesbDocumentLibrary("");
		}
		else {
			sampleSBImpl.setSamplesbDocumentLibrary(samplesbDocumentLibrary);
		}

		sampleSBImpl.setSamplesbDouble(samplesbDouble);
		sampleSBImpl.setSamplesbInteger(samplesbInteger);

		if (samplesbRichText == null) {
			sampleSBImpl.setSamplesbRichText("");
		}
		else {
			sampleSBImpl.setSamplesbRichText(samplesbRichText);
		}

		if (samplesbText == null) {
			sampleSBImpl.setSamplesbText("");
		}
		else {
			sampleSBImpl.setSamplesbText(samplesbText);
		}

		sampleSBImpl.setGroupId(groupId);
		sampleSBImpl.setCompanyId(companyId);
		sampleSBImpl.setUserId(userId);

		if (userName == null) {
			sampleSBImpl.setUserName("");
		}
		else {
			sampleSBImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			sampleSBImpl.setCreateDate(null);
		}
		else {
			sampleSBImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			sampleSBImpl.setModifiedDate(null);
		}
		else {
			sampleSBImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (urlTitle == null) {
			sampleSBImpl.setUrlTitle("");
		}
		else {
			sampleSBImpl.setUrlTitle(urlTitle);
		}

		if (samplesbTitleName == null) {
			sampleSBImpl.setSamplesbTitleName("");
		}
		else {
			sampleSBImpl.setSamplesbTitleName(samplesbTitleName);
		}

		if (samplesbSummaryName == null) {
			sampleSBImpl.setSamplesbSummaryName("");
		}
		else {
			sampleSBImpl.setSamplesbSummaryName(samplesbSummaryName);
		}

		sampleSBImpl.setStatus(status);
		sampleSBImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			sampleSBImpl.setStatusByUserName("");
		}
		else {
			sampleSBImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			sampleSBImpl.setStatusDate(null);
		}
		else {
			sampleSBImpl.setStatusDate(new Date(statusDate));
		}

		sampleSBImpl.resetOriginalValues();

		return sampleSBImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		samplesbId = objectInput.readLong();
		title = objectInput.readUTF();

		samplesbBooleanStat = objectInput.readBoolean();
		samplesbDateTime = objectInput.readLong();
		samplesbDocumentLibrary = objectInput.readUTF();

		samplesbDouble = objectInput.readDouble();

		samplesbInteger = objectInput.readInt();
		samplesbRichText = objectInput.readUTF();
		samplesbText = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		urlTitle = objectInput.readUTF();
		samplesbTitleName = objectInput.readUTF();
		samplesbSummaryName = objectInput.readUTF();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(samplesbId);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeBoolean(samplesbBooleanStat);
		objectOutput.writeLong(samplesbDateTime);

		if (samplesbDocumentLibrary == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(samplesbDocumentLibrary);
		}

		objectOutput.writeDouble(samplesbDouble);

		objectOutput.writeInt(samplesbInteger);

		if (samplesbRichText == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(samplesbRichText);
		}

		if (samplesbText == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(samplesbText);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (urlTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(urlTitle);
		}

		if (samplesbTitleName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(samplesbTitleName);
		}

		if (samplesbSummaryName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(samplesbSummaryName);
		}

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public long mvccVersion;
	public String uuid;
	public long samplesbId;
	public String title;
	public boolean samplesbBooleanStat;
	public long samplesbDateTime;
	public String samplesbDocumentLibrary;
	public double samplesbDouble;
	public int samplesbInteger;
	public String samplesbRichText;
	public String samplesbText;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String urlTitle;
	public String samplesbTitleName;
	public String samplesbSummaryName;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}