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

package com.liferay.sb.test.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SampleSB}.
 * </p>
 *
 * @author "yasuflatland"
 * @see SampleSB
 * @generated
 */
public class SampleSBWrapper
	extends BaseModelWrapper<SampleSB>
	implements ModelWrapper<SampleSB>, SampleSB {

	public SampleSBWrapper(SampleSB sampleSB) {
		super(sampleSB);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("samplesbId", getSamplesbId());
		attributes.put("title", getTitle());
		attributes.put("samplesbBooleanStat", isSamplesbBooleanStat());
		attributes.put("samplesbDateTime", getSamplesbDateTime());
		attributes.put("samplesbDocumentLibrary", getSamplesbDocumentLibrary());
		attributes.put("samplesbDouble", getSamplesbDouble());
		attributes.put("samplesbInteger", getSamplesbInteger());
		attributes.put("samplesbRichText", getSamplesbRichText());
		attributes.put("samplesbText", getSamplesbText());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("urlTitle", getUrlTitle());
		attributes.put("samplesbTitleName", getSamplesbTitleName());
		attributes.put("samplesbSummaryName", getSamplesbSummaryName());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long samplesbId = (Long)attributes.get("samplesbId");

		if (samplesbId != null) {
			setSamplesbId(samplesbId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Boolean samplesbBooleanStat = (Boolean)attributes.get(
			"samplesbBooleanStat");

		if (samplesbBooleanStat != null) {
			setSamplesbBooleanStat(samplesbBooleanStat);
		}

		Date samplesbDateTime = (Date)attributes.get("samplesbDateTime");

		if (samplesbDateTime != null) {
			setSamplesbDateTime(samplesbDateTime);
		}

		String samplesbDocumentLibrary = (String)attributes.get(
			"samplesbDocumentLibrary");

		if (samplesbDocumentLibrary != null) {
			setSamplesbDocumentLibrary(samplesbDocumentLibrary);
		}

		Double samplesbDouble = (Double)attributes.get("samplesbDouble");

		if (samplesbDouble != null) {
			setSamplesbDouble(samplesbDouble);
		}

		Integer samplesbInteger = (Integer)attributes.get("samplesbInteger");

		if (samplesbInteger != null) {
			setSamplesbInteger(samplesbInteger);
		}

		String samplesbRichText = (String)attributes.get("samplesbRichText");

		if (samplesbRichText != null) {
			setSamplesbRichText(samplesbRichText);
		}

		String samplesbText = (String)attributes.get("samplesbText");

		if (samplesbText != null) {
			setSamplesbText(samplesbText);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String urlTitle = (String)attributes.get("urlTitle");

		if (urlTitle != null) {
			setUrlTitle(urlTitle);
		}

		String samplesbTitleName = (String)attributes.get("samplesbTitleName");

		if (samplesbTitleName != null) {
			setSamplesbTitleName(samplesbTitleName);
		}

		String samplesbSummaryName = (String)attributes.get(
			"samplesbSummaryName");

		if (samplesbSummaryName != null) {
			setSamplesbSummaryName(samplesbSummaryName);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	/**
	 * Returns the company ID of this sample sb.
	 *
	 * @return the company ID of this sample sb
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this sample sb.
	 *
	 * @return the create date of this sample sb
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this sample sb.
	 *
	 * @return the group ID of this sample sb
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this sample sb.
	 *
	 * @return the modified date of this sample sb
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this sample sb.
	 *
	 * @return the mvcc version of this sample sb
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this sample sb.
	 *
	 * @return the primary key of this sample sb
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the samplesb boolean stat of this sample sb.
	 *
	 * @return the samplesb boolean stat of this sample sb
	 */
	@Override
	public boolean getSamplesbBooleanStat() {
		return model.getSamplesbBooleanStat();
	}

	/**
	 * Returns the samplesb date time of this sample sb.
	 *
	 * @return the samplesb date time of this sample sb
	 */
	@Override
	public Date getSamplesbDateTime() {
		return model.getSamplesbDateTime();
	}

	/**
	 * Returns the samplesb document library of this sample sb.
	 *
	 * @return the samplesb document library of this sample sb
	 */
	@Override
	public String getSamplesbDocumentLibrary() {
		return model.getSamplesbDocumentLibrary();
	}

	/**
	 * Returns the samplesb double of this sample sb.
	 *
	 * @return the samplesb double of this sample sb
	 */
	@Override
	public double getSamplesbDouble() {
		return model.getSamplesbDouble();
	}

	/**
	 * Returns the samplesb ID of this sample sb.
	 *
	 * @return the samplesb ID of this sample sb
	 */
	@Override
	public long getSamplesbId() {
		return model.getSamplesbId();
	}

	/**
	 * Returns the samplesb integer of this sample sb.
	 *
	 * @return the samplesb integer of this sample sb
	 */
	@Override
	public int getSamplesbInteger() {
		return model.getSamplesbInteger();
	}

	/**
	 * Returns the samplesb rich text of this sample sb.
	 *
	 * @return the samplesb rich text of this sample sb
	 */
	@Override
	public String getSamplesbRichText() {
		return model.getSamplesbRichText();
	}

	/**
	 * Returns the samplesb summary name of this sample sb.
	 *
	 * @return the samplesb summary name of this sample sb
	 */
	@Override
	public String getSamplesbSummaryName() {
		return model.getSamplesbSummaryName();
	}

	/**
	 * Returns the samplesb text of this sample sb.
	 *
	 * @return the samplesb text of this sample sb
	 */
	@Override
	public String getSamplesbText() {
		return model.getSamplesbText();
	}

	/**
	 * Returns the samplesb title name of this sample sb.
	 *
	 * @return the samplesb title name of this sample sb
	 */
	@Override
	public String getSamplesbTitleName() {
		return model.getSamplesbTitleName();
	}

	/**
	 * Returns the status of this sample sb.
	 *
	 * @return the status of this sample sb
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this sample sb.
	 *
	 * @return the status by user ID of this sample sb
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this sample sb.
	 *
	 * @return the status by user name of this sample sb
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this sample sb.
	 *
	 * @return the status by user uuid of this sample sb
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this sample sb.
	 *
	 * @return the status date of this sample sb
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the title of this sample sb.
	 *
	 * @return the title of this sample sb
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the trash entry created when this sample sb was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this sample sb.
	 *
	 * @return the trash entry created when this sample sb was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this sample sb.
	 *
	 * @return the class primary key of the trash entry for this sample sb
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this sample sb.
	 *
	 * @return the trash handler for this sample sb
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the url title of this sample sb.
	 *
	 * @return the url title of this sample sb
	 */
	@Override
	public String getUrlTitle() {
		return model.getUrlTitle();
	}

	/**
	 * Returns the user ID of this sample sb.
	 *
	 * @return the user ID of this sample sb
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this sample sb.
	 *
	 * @return the user name of this sample sb
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this sample sb.
	 *
	 * @return the user uuid of this sample sb
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this sample sb.
	 *
	 * @return the uuid of this sample sb
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this sample sb is approved.
	 *
	 * @return <code>true</code> if this sample sb is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this sample sb is denied.
	 *
	 * @return <code>true</code> if this sample sb is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this sample sb is a draft.
	 *
	 * @return <code>true</code> if this sample sb is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this sample sb is expired.
	 *
	 * @return <code>true</code> if this sample sb is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this sample sb is inactive.
	 *
	 * @return <code>true</code> if this sample sb is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this sample sb is incomplete.
	 *
	 * @return <code>true</code> if this sample sb is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this sample sb is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this sample sb is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this sample sb is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this sample sb is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrashContainer() {
		return model.isInTrashContainer();
	}

	@Override
	public boolean isInTrashExplicitly() {
		return model.isInTrashExplicitly();
	}

	@Override
	public boolean isInTrashImplicitly() {
		return model.isInTrashImplicitly();
	}

	/**
	 * Returns <code>true</code> if this sample sb is pending.
	 *
	 * @return <code>true</code> if this sample sb is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this sample sb is samplesb boolean stat.
	 *
	 * @return <code>true</code> if this sample sb is samplesb boolean stat; <code>false</code> otherwise
	 */
	@Override
	public boolean isSamplesbBooleanStat() {
		return model.isSamplesbBooleanStat();
	}

	/**
	 * Returns <code>true</code> if this sample sb is scheduled.
	 *
	 * @return <code>true</code> if this sample sb is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this sample sb.
	 *
	 * @param companyId the company ID of this sample sb
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this sample sb.
	 *
	 * @param createDate the create date of this sample sb
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this sample sb.
	 *
	 * @param groupId the group ID of this sample sb
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this sample sb.
	 *
	 * @param modifiedDate the modified date of this sample sb
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this sample sb.
	 *
	 * @param mvccVersion the mvcc version of this sample sb
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this sample sb.
	 *
	 * @param primaryKey the primary key of this sample sb
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this sample sb is samplesb boolean stat.
	 *
	 * @param samplesbBooleanStat the samplesb boolean stat of this sample sb
	 */
	@Override
	public void setSamplesbBooleanStat(boolean samplesbBooleanStat) {
		model.setSamplesbBooleanStat(samplesbBooleanStat);
	}

	/**
	 * Sets the samplesb date time of this sample sb.
	 *
	 * @param samplesbDateTime the samplesb date time of this sample sb
	 */
	@Override
	public void setSamplesbDateTime(Date samplesbDateTime) {
		model.setSamplesbDateTime(samplesbDateTime);
	}

	/**
	 * Sets the samplesb document library of this sample sb.
	 *
	 * @param samplesbDocumentLibrary the samplesb document library of this sample sb
	 */
	@Override
	public void setSamplesbDocumentLibrary(String samplesbDocumentLibrary) {
		model.setSamplesbDocumentLibrary(samplesbDocumentLibrary);
	}

	/**
	 * Sets the samplesb double of this sample sb.
	 *
	 * @param samplesbDouble the samplesb double of this sample sb
	 */
	@Override
	public void setSamplesbDouble(double samplesbDouble) {
		model.setSamplesbDouble(samplesbDouble);
	}

	/**
	 * Sets the samplesb ID of this sample sb.
	 *
	 * @param samplesbId the samplesb ID of this sample sb
	 */
	@Override
	public void setSamplesbId(long samplesbId) {
		model.setSamplesbId(samplesbId);
	}

	/**
	 * Sets the samplesb integer of this sample sb.
	 *
	 * @param samplesbInteger the samplesb integer of this sample sb
	 */
	@Override
	public void setSamplesbInteger(int samplesbInteger) {
		model.setSamplesbInteger(samplesbInteger);
	}

	/**
	 * Sets the samplesb rich text of this sample sb.
	 *
	 * @param samplesbRichText the samplesb rich text of this sample sb
	 */
	@Override
	public void setSamplesbRichText(String samplesbRichText) {
		model.setSamplesbRichText(samplesbRichText);
	}

	/**
	 * Sets the samplesb summary name of this sample sb.
	 *
	 * @param samplesbSummaryName the samplesb summary name of this sample sb
	 */
	@Override
	public void setSamplesbSummaryName(String samplesbSummaryName) {
		model.setSamplesbSummaryName(samplesbSummaryName);
	}

	/**
	 * Sets the samplesb text of this sample sb.
	 *
	 * @param samplesbText the samplesb text of this sample sb
	 */
	@Override
	public void setSamplesbText(String samplesbText) {
		model.setSamplesbText(samplesbText);
	}

	/**
	 * Sets the samplesb title name of this sample sb.
	 *
	 * @param samplesbTitleName the samplesb title name of this sample sb
	 */
	@Override
	public void setSamplesbTitleName(String samplesbTitleName) {
		model.setSamplesbTitleName(samplesbTitleName);
	}

	/**
	 * Sets the status of this sample sb.
	 *
	 * @param status the status of this sample sb
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this sample sb.
	 *
	 * @param statusByUserId the status by user ID of this sample sb
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this sample sb.
	 *
	 * @param statusByUserName the status by user name of this sample sb
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this sample sb.
	 *
	 * @param statusByUserUuid the status by user uuid of this sample sb
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this sample sb.
	 *
	 * @param statusDate the status date of this sample sb
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this sample sb.
	 *
	 * @param title the title of this sample sb
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the url title of this sample sb.
	 *
	 * @param urlTitle the url title of this sample sb
	 */
	@Override
	public void setUrlTitle(String urlTitle) {
		model.setUrlTitle(urlTitle);
	}

	/**
	 * Sets the user ID of this sample sb.
	 *
	 * @param userId the user ID of this sample sb
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this sample sb.
	 *
	 * @param userName the user name of this sample sb
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this sample sb.
	 *
	 * @param userUuid the user uuid of this sample sb
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this sample sb.
	 *
	 * @param uuid the uuid of this sample sb
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected SampleSBWrapper wrap(SampleSB sampleSB) {
		return new SampleSBWrapper(sampleSB);
	}

}