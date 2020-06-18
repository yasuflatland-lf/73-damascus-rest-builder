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

package com.liferay.sb.test.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.sb.test.model.SampleSB;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the sample sb service. This utility wraps <code>com.liferay.sb.test.service.persistence.impl.SampleSBPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author "yasuflatland"
 * @see SampleSBPersistence
 * @generated
 */
public class SampleSBUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(SampleSB sampleSB) {
		getPersistence().clearCache(sampleSB);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, SampleSB> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SampleSB> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SampleSB> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SampleSB> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SampleSB update(SampleSB sampleSB) {
		return getPersistence().update(sampleSB);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SampleSB update(
		SampleSB sampleSB, ServiceContext serviceContext) {

		return getPersistence().update(sampleSB, serviceContext);
	}

	/**
	 * Returns all the sample sbs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the sample sbs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sample sb in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByUuid_First(
			String uuid, OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first sample sb in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByUuid_First(
		String uuid, OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByUuid_Last(
			String uuid, OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByUuid_Last(
		String uuid, OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where uuid = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB[] findByUuid_PrevAndNext(
			long samplesbId, String uuid,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByUuid_PrevAndNext(
			samplesbId, uuid, orderByComparator);
	}

	/**
	 * Removes all the sample sbs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of sample sbs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sample sbs
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the sample sb where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSampleSBException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByUUID_G(String uuid, long groupId)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the sample sb where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the sample sb where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the sample sb where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the sample sb that was removed
	 */
	public static SampleSB removeByUUID_G(String uuid, long groupId)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of sample sbs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching sample sbs
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the sample sbs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the sample sbs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sample sb in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first sample sb in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB[] findByUuid_C_PrevAndNext(
			long samplesbId, String uuid, long companyId,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByUuid_C_PrevAndNext(
			samplesbId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the sample sbs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of sample sbs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching sample sbs
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the sample sbs where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findByC_S(long companyId, int status) {
		return getPersistence().findByC_S(companyId, status);
	}

	/**
	 * Returns a range of all the sample sbs where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findByC_S(
		long companyId, int status, int start, int end) {

		return getPersistence().findByC_S(companyId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByC_S(
		long companyId, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findByC_S(
			companyId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByC_S(
		long companyId, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByC_S(
			companyId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sample sb in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByC_S_First(
			long companyId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByC_S_First(
			companyId, status, orderByComparator);
	}

	/**
	 * Returns the first sample sb in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByC_S_First(
		long companyId, int status,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchByC_S_First(
			companyId, status, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByC_S_Last(
			long companyId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByC_S_Last(
			companyId, status, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByC_S_Last(
		long companyId, int status,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchByC_S_Last(
			companyId, status, orderByComparator);
	}

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB[] findByC_S_PrevAndNext(
			long samplesbId, long companyId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByC_S_PrevAndNext(
			samplesbId, companyId, status, orderByComparator);
	}

	/**
	 * Returns all the sample sbs where companyId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findByC_S(long companyId, int[] statuses) {
		return getPersistence().findByC_S(companyId, statuses);
	}

	/**
	 * Returns a range of all the sample sbs where companyId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findByC_S(
		long companyId, int[] statuses, int start, int end) {

		return getPersistence().findByC_S(companyId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where companyId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByC_S(
		long companyId, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findByC_S(
			companyId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where companyId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByC_S(
		long companyId, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByC_S(
			companyId, statuses, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sample sbs where companyId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 */
	public static void removeByC_S(long companyId, int status) {
		getPersistence().removeByC_S(companyId, status);
	}

	/**
	 * Returns the number of sample sbs where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching sample sbs
	 */
	public static int countByC_S(long companyId, int status) {
		return getPersistence().countByC_S(companyId, status);
	}

	/**
	 * Returns the number of sample sbs where companyId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @return the number of matching sample sbs
	 */
	public static int countByC_S(long companyId, int[] statuses) {
		return getPersistence().countByC_S(companyId, statuses);
	}

	/**
	 * Returns all the sample sbs where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the sample sbs where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sample sb in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByG_S_First(
			long groupId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first sample sb in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByG_S_Last(
			long groupId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB[] findByG_S_PrevAndNext(
			long samplesbId, long groupId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByG_S_PrevAndNext(
			samplesbId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the sample sbs that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching sample sbs that the user has permission to view
	 */
	public static List<SampleSB> filterFindByG_S(long groupId, int status) {
		return getPersistence().filterFindByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the sample sbs that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs that the user has permission to view
	 */
	public static List<SampleSB> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().filterFindByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs that the user has permission to view
	 */
	public static List<SampleSB> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().filterFindByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set of sample sbs that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB[] filterFindByG_S_PrevAndNext(
			long samplesbId, long groupId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().filterFindByG_S_PrevAndNext(
			samplesbId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the sample sbs that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the matching sample sbs that the user has permission to view
	 */
	public static List<SampleSB> filterFindByG_S(long groupId, int[] statuses) {
		return getPersistence().filterFindByG_S(groupId, statuses);
	}

	/**
	 * Returns a range of all the sample sbs that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs that the user has permission to view
	 */
	public static List<SampleSB> filterFindByG_S(
		long groupId, int[] statuses, int start, int end) {

		return getPersistence().filterFindByG_S(groupId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs that the user has permission to view
	 */
	public static List<SampleSB> filterFindByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().filterFindByG_S(
			groupId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns all the sample sbs where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findByG_S(long groupId, int[] statuses) {
		return getPersistence().findByG_S(groupId, statuses);
	}

	/**
	 * Returns a range of all the sample sbs where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findByG_S(
		long groupId, int[] statuses, int start, int end) {

		return getPersistence().findByG_S(groupId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where groupId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where groupId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, statuses, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sample sbs where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of sample sbs where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching sample sbs
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Returns the number of sample sbs where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching sample sbs
	 */
	public static int countByG_S(long groupId, int[] statuses) {
		return getPersistence().countByG_S(groupId, statuses);
	}

	/**
	 * Returns the number of sample sbs that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching sample sbs that the user has permission to view
	 */
	public static int filterCountByG_S(long groupId, int status) {
		return getPersistence().filterCountByG_S(groupId, status);
	}

	/**
	 * Returns the number of sample sbs that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching sample sbs that the user has permission to view
	 */
	public static int filterCountByG_S(long groupId, int[] statuses) {
		return getPersistence().filterCountByG_S(groupId, statuses);
	}

	/**
	 * Returns all the sample sbs where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findByC_U_S(
		long companyId, long userId, int status) {

		return getPersistence().findByC_U_S(companyId, userId, status);
	}

	/**
	 * Returns a range of all the sample sbs where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findByC_U_S(
		long companyId, long userId, int status, int start, int end) {

		return getPersistence().findByC_U_S(
			companyId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findByC_U_S(
			companyId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByC_U_S(
			companyId, userId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first sample sb in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByC_U_S_First(
			long companyId, long userId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByC_U_S_First(
			companyId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first sample sb in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByC_U_S_First(
		long companyId, long userId, int status,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchByC_U_S_First(
			companyId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByC_U_S_Last(
			long companyId, long userId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByC_U_S_Last(
			companyId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByC_U_S_Last(
		long companyId, long userId, int status,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchByC_U_S_Last(
			companyId, userId, status, orderByComparator);
	}

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB[] findByC_U_S_PrevAndNext(
			long samplesbId, long companyId, long userId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByC_U_S_PrevAndNext(
			samplesbId, companyId, userId, status, orderByComparator);
	}

	/**
	 * Returns all the sample sbs where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findByC_U_S(
		long companyId, long userId, int[] statuses) {

		return getPersistence().findByC_U_S(companyId, userId, statuses);
	}

	/**
	 * Returns a range of all the sample sbs where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end) {

		return getPersistence().findByC_U_S(
			companyId, userId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findByC_U_S(
			companyId, userId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where companyId = &#63; and userId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByC_U_S(
			companyId, userId, statuses, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Removes all the sample sbs where companyId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByC_U_S(long companyId, long userId, int status) {
		getPersistence().removeByC_U_S(companyId, userId, status);
	}

	/**
	 * Returns the number of sample sbs where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching sample sbs
	 */
	public static int countByC_U_S(long companyId, long userId, int status) {
		return getPersistence().countByC_U_S(companyId, userId, status);
	}

	/**
	 * Returns the number of sample sbs where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching sample sbs
	 */
	public static int countByC_U_S(
		long companyId, long userId, int[] statuses) {

		return getPersistence().countByC_U_S(companyId, userId, statuses);
	}

	/**
	 * Returns all the sample sbs where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().findByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns a range of all the sample sbs where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first sample sb in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByG_U_S_First(
			long groupId, long userId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByG_U_S_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first sample sb in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByG_U_S_First(
		long groupId, long userId, int status,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchByG_U_S_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByG_U_S_Last(
			long groupId, long userId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByG_U_S_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByG_U_S_Last(
		long groupId, long userId, int status,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchByG_U_S_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB[] findByG_U_S_PrevAndNext(
			long samplesbId, long groupId, long userId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByG_U_S_PrevAndNext(
			samplesbId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns all the sample sbs that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching sample sbs that the user has permission to view
	 */
	public static List<SampleSB> filterFindByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().filterFindByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns a range of all the sample sbs that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs that the user has permission to view
	 */
	public static List<SampleSB> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs that the user has permissions to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs that the user has permission to view
	 */
	public static List<SampleSB> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set of sample sbs that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB[] filterFindByG_U_S_PrevAndNext(
			long samplesbId, long groupId, long userId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().filterFindByG_U_S_PrevAndNext(
			samplesbId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns all the sample sbs that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching sample sbs that the user has permission to view
	 */
	public static List<SampleSB> filterFindByG_U_S(
		long groupId, long userId, int[] statuses) {

		return getPersistence().filterFindByG_U_S(groupId, userId, statuses);
	}

	/**
	 * Returns a range of all the sample sbs that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs that the user has permission to view
	 */
	public static List<SampleSB> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs that the user has permission to view
	 */
	public static List<SampleSB> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns all the sample sbs where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findByG_U_S(
		long groupId, long userId, int[] statuses) {

		return getPersistence().findByG_U_S(groupId, userId, statuses);
	}

	/**
	 * Returns a range of all the sample sbs where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end) {

		return getPersistence().findByG_U_S(
			groupId, userId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findByG_U_S(
			groupId, userId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where groupId = &#63; and userId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_U_S(
			groupId, userId, statuses, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Removes all the sample sbs where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByG_U_S(long groupId, long userId, int status) {
		getPersistence().removeByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of sample sbs where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching sample sbs
	 */
	public static int countByG_U_S(long groupId, long userId, int status) {
		return getPersistence().countByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of sample sbs where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching sample sbs
	 */
	public static int countByG_U_S(long groupId, long userId, int[] statuses) {
		return getPersistence().countByG_U_S(groupId, userId, statuses);
	}

	/**
	 * Returns the number of sample sbs that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching sample sbs that the user has permission to view
	 */
	public static int filterCountByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().filterCountByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of sample sbs that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching sample sbs that the user has permission to view
	 */
	public static int filterCountByG_U_S(
		long groupId, long userId, int[] statuses) {

		return getPersistence().filterCountByG_U_S(groupId, userId, statuses);
	}

	/**
	 * Returns all the sample sbs where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findByU_S(long userId, int status) {
		return getPersistence().findByU_S(userId, status);
	}

	/**
	 * Returns a range of all the sample sbs where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findByU_S(
		long userId, int status, int start, int end) {

		return getPersistence().findByU_S(userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findByU_S(
			userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByU_S(
			userId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sample sb in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByU_S_First(
			long userId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByU_S_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the first sample sb in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByU_S_First(
		long userId, int status,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchByU_S_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByU_S_Last(
			long userId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByU_S_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByU_S_Last(
		long userId, int status,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchByU_S_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB[] findByU_S_PrevAndNext(
			long samplesbId, long userId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByU_S_PrevAndNext(
			samplesbId, userId, status, orderByComparator);
	}

	/**
	 * Returns all the sample sbs where userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findByU_S(long userId, int[] statuses) {
		return getPersistence().findByU_S(userId, statuses);
	}

	/**
	 * Returns a range of all the sample sbs where userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findByU_S(
		long userId, int[] statuses, int start, int end) {

		return getPersistence().findByU_S(userId, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where userId = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByU_S(
		long userId, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findByU_S(
			userId, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where userId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByU_S(
		long userId, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByU_S(
			userId, statuses, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sample sbs where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByU_S(long userId, int status) {
		getPersistence().removeByU_S(userId, status);
	}

	/**
	 * Returns the number of sample sbs where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching sample sbs
	 */
	public static int countByU_S(long userId, int status) {
		return getPersistence().countByU_S(userId, status);
	}

	/**
	 * Returns the number of sample sbs where userId = &#63; and status = any &#63;.
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching sample sbs
	 */
	public static int countByU_S(long userId, int[] statuses) {
		return getPersistence().countByU_S(userId, statuses);
	}

	/**
	 * Returns all the sample sbs where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return getPersistence().findByG_UT_ST(groupId, urlTitle, status);
	}

	/**
	 * Returns a range of all the sample sbs where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, status, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first sample sb in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByG_UT_ST_First(
			long groupId, String urlTitle, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByG_UT_ST_First(
			groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns the first sample sb in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByG_UT_ST_First(
		long groupId, String urlTitle, int status,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchByG_UT_ST_First(
			groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByG_UT_ST_Last(
			long groupId, String urlTitle, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByG_UT_ST_Last(
			groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByG_UT_ST_Last(
		long groupId, String urlTitle, int status,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchByG_UT_ST_Last(
			groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB[] findByG_UT_ST_PrevAndNext(
			long samplesbId, long groupId, String urlTitle, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByG_UT_ST_PrevAndNext(
			samplesbId, groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns all the sample sbs that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching sample sbs that the user has permission to view
	 */
	public static List<SampleSB> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return getPersistence().filterFindByG_UT_ST(groupId, urlTitle, status);
	}

	/**
	 * Returns a range of all the sample sbs that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs that the user has permission to view
	 */
	public static List<SampleSB> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end) {

		return getPersistence().filterFindByG_UT_ST(
			groupId, urlTitle, status, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs that the user has permissions to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs that the user has permission to view
	 */
	public static List<SampleSB> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().filterFindByG_UT_ST(
			groupId, urlTitle, status, start, end, orderByComparator);
	}

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set of sample sbs that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB[] filterFindByG_UT_ST_PrevAndNext(
			long samplesbId, long groupId, String urlTitle, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().filterFindByG_UT_ST_PrevAndNext(
			samplesbId, groupId, urlTitle, status, orderByComparator);
	}

	/**
	 * Returns all the sample sbs that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the matching sample sbs that the user has permission to view
	 */
	public static List<SampleSB> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return getPersistence().filterFindByG_UT_ST(
			groupId, urlTitle, statuses);
	}

	/**
	 * Returns a range of all the sample sbs that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs that the user has permission to view
	 */
	public static List<SampleSB> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end) {

		return getPersistence().filterFindByG_UT_ST(
			groupId, urlTitle, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs that the user has permission to view
	 */
	public static List<SampleSB> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().filterFindByG_UT_ST(
			groupId, urlTitle, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns all the sample sbs where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return getPersistence().findByG_UT_ST(groupId, urlTitle, statuses);
	}

	/**
	 * Returns a range of all the sample sbs where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where groupId = &#63; and urlTitle = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_UT_ST(
			groupId, urlTitle, statuses, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Removes all the sample sbs where groupId = &#63; and urlTitle = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 */
	public static void removeByG_UT_ST(
		long groupId, String urlTitle, int status) {

		getPersistence().removeByG_UT_ST(groupId, urlTitle, status);
	}

	/**
	 * Returns the number of sample sbs where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching sample sbs
	 */
	public static int countByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return getPersistence().countByG_UT_ST(groupId, urlTitle, status);
	}

	/**
	 * Returns the number of sample sbs where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching sample sbs
	 */
	public static int countByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return getPersistence().countByG_UT_ST(groupId, urlTitle, statuses);
	}

	/**
	 * Returns the number of sample sbs that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching sample sbs that the user has permission to view
	 */
	public static int filterCountByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return getPersistence().filterCountByG_UT_ST(groupId, urlTitle, status);
	}

	/**
	 * Returns the number of sample sbs that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching sample sbs that the user has permission to view
	 */
	public static int filterCountByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return getPersistence().filterCountByG_UT_ST(
			groupId, urlTitle, statuses);
	}

	/**
	 * Returns the sample sb where groupId = &#63; and urlTitle = &#63; or throws a <code>NoSuchSampleSBException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByG_UT(long groupId, String urlTitle)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByG_UT(groupId, urlTitle);
	}

	/**
	 * Returns the sample sb where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByG_UT(long groupId, String urlTitle) {
		return getPersistence().fetchByG_UT(groupId, urlTitle);
	}

	/**
	 * Returns the sample sb where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByG_UT(
		long groupId, String urlTitle, boolean useFinderCache) {

		return getPersistence().fetchByG_UT(groupId, urlTitle, useFinderCache);
	}

	/**
	 * Removes the sample sb where groupId = &#63; and urlTitle = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the sample sb that was removed
	 */
	public static SampleSB removeByG_UT(long groupId, String urlTitle)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().removeByG_UT(groupId, urlTitle);
	}

	/**
	 * Returns the number of sample sbs where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the number of matching sample sbs
	 */
	public static int countByG_UT(long groupId, String urlTitle) {
		return getPersistence().countByG_UT(groupId, urlTitle);
	}

	/**
	 * Returns the sample sb where urlTitle = &#63; or throws a <code>NoSuchSampleSBException</code> if it could not be found.
	 *
	 * @param urlTitle the url title
	 * @return the matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByURLTitle(String urlTitle)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByURLTitle(urlTitle);
	}

	/**
	 * Returns the sample sb where urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param urlTitle the url title
	 * @return the matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByURLTitle(String urlTitle) {
		return getPersistence().fetchByURLTitle(urlTitle);
	}

	/**
	 * Returns the sample sb where urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByURLTitle(
		String urlTitle, boolean useFinderCache) {

		return getPersistence().fetchByURLTitle(urlTitle, useFinderCache);
	}

	/**
	 * Removes the sample sb where urlTitle = &#63; from the database.
	 *
	 * @param urlTitle the url title
	 * @return the sample sb that was removed
	 */
	public static SampleSB removeByURLTitle(String urlTitle)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().removeByURLTitle(urlTitle);
	}

	/**
	 * Returns the number of sample sbs where urlTitle = &#63;.
	 *
	 * @param urlTitle the url title
	 * @return the number of matching sample sbs
	 */
	public static int countByURLTitle(String urlTitle) {
		return getPersistence().countByURLTitle(urlTitle);
	}

	/**
	 * Returns all the sample sbs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the sample sbs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sample sb in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByGroupId_First(
			long groupId, OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first sample sb in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByGroupId_First(
		long groupId, OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByGroupId_Last(
			long groupId, OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByGroupId_Last(
		long groupId, OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where groupId = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB[] findByGroupId_PrevAndNext(
			long samplesbId, long groupId,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByGroupId_PrevAndNext(
			samplesbId, groupId, orderByComparator);
	}

	/**
	 * Returns all the sample sbs that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching sample sbs that the user has permission to view
	 */
	public static List<SampleSB> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	 * Returns a range of all the sample sbs that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs that the user has permission to view
	 */
	public static List<SampleSB> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs that the user has permission to view
	 */
	public static List<SampleSB> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set of sample sbs that the user has permission to view where groupId = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB[] filterFindByGroupId_PrevAndNext(
			long samplesbId, long groupId,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			samplesbId, groupId, orderByComparator);
	}

	/**
	 * Removes all the sample sbs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of sample sbs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching sample sbs
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of sample sbs that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching sample sbs that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Returns all the sample sbs where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findByUserIdGroupId(
		long userId, long groupId) {

		return getPersistence().findByUserIdGroupId(userId, groupId);
	}

	/**
	 * Returns a range of all the sample sbs where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findByUserIdGroupId(
		long userId, long groupId, int start, int end) {

		return getPersistence().findByUserIdGroupId(
			userId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findByUserIdGroupId(
			userId, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUserIdGroupId(
			userId, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sample sb in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByUserIdGroupId_First(
			long userId, long groupId,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByUserIdGroupId_First(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the first sample sb in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByUserIdGroupId_First(
		long userId, long groupId,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchByUserIdGroupId_First(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByUserIdGroupId_Last(
			long userId, long groupId,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByUserIdGroupId_Last(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByUserIdGroupId_Last(
		long userId, long groupId,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchByUserIdGroupId_Last(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB[] findByUserIdGroupId_PrevAndNext(
			long samplesbId, long userId, long groupId,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByUserIdGroupId_PrevAndNext(
			samplesbId, userId, groupId, orderByComparator);
	}

	/**
	 * Returns all the sample sbs that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching sample sbs that the user has permission to view
	 */
	public static List<SampleSB> filterFindByUserIdGroupId(
		long userId, long groupId) {

		return getPersistence().filterFindByUserIdGroupId(userId, groupId);
	}

	/**
	 * Returns a range of all the sample sbs that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs that the user has permission to view
	 */
	public static List<SampleSB> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end) {

		return getPersistence().filterFindByUserIdGroupId(
			userId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs that the user has permissions to view where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs that the user has permission to view
	 */
	public static List<SampleSB> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().filterFindByUserIdGroupId(
			userId, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set of sample sbs that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB[] filterFindByUserIdGroupId_PrevAndNext(
			long samplesbId, long userId, long groupId,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().filterFindByUserIdGroupId_PrevAndNext(
			samplesbId, userId, groupId, orderByComparator);
	}

	/**
	 * Removes all the sample sbs where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 */
	public static void removeByUserIdGroupId(long userId, long groupId) {
		getPersistence().removeByUserIdGroupId(userId, groupId);
	}

	/**
	 * Returns the number of sample sbs where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching sample sbs
	 */
	public static int countByUserIdGroupId(long userId, long groupId) {
		return getPersistence().countByUserIdGroupId(userId, groupId);
	}

	/**
	 * Returns the number of sample sbs that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching sample sbs that the user has permission to view
	 */
	public static int filterCountByUserIdGroupId(long userId, long groupId) {
		return getPersistence().filterCountByUserIdGroupId(userId, groupId);
	}

	/**
	 * Returns all the sample sbs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the sample sbs where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findByUserId(long userId, int start, int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByUserId(
		long userId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByUserId(
		long userId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sample sb in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByUserId_First(
			long userId, OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first sample sb in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByUserId_First(
		long userId, OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByUserId_Last(
			long userId, OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByUserId_Last(
		long userId, OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where userId = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB[] findByUserId_PrevAndNext(
			long samplesbId, long userId,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByUserId_PrevAndNext(
			samplesbId, userId, orderByComparator);
	}

	/**
	 * Removes all the sample sbs where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of sample sbs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching sample sbs
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the sample sbs where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findByCompanyId(long companyId) {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	 * Returns a range of all the sample sbs where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findByCompanyId(
		long companyId, int start, int end) {

		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sample sb in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByCompanyId_First(
			long companyId, OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first sample sb in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByCompanyId_First(
		long companyId, OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByCompanyId_Last(
			long companyId, OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByCompanyId_Last(
		long companyId, OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where companyId = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB[] findByCompanyId_PrevAndNext(
			long samplesbId, long companyId,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByCompanyId_PrevAndNext(
			samplesbId, companyId, orderByComparator);
	}

	/**
	 * Removes all the sample sbs where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompanyId(long companyId) {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	 * Returns the number of sample sbs where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching sample sbs
	 */
	public static int countByCompanyId(long companyId) {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	 * Returns all the sample sbs where samplesbId = &#63;.
	 *
	 * @param samplesbId the samplesb ID
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbId(long samplesbId) {
		return getPersistence().findBySamplesbId(samplesbId);
	}

	/**
	 * Returns a range of all the sample sbs where samplesbId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param samplesbId the samplesb ID
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbId(
		long samplesbId, int start, int end) {

		return getPersistence().findBySamplesbId(samplesbId, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where samplesbId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param samplesbId the samplesb ID
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbId(
		long samplesbId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findBySamplesbId(
			samplesbId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where samplesbId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param samplesbId the samplesb ID
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbId(
		long samplesbId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBySamplesbId(
			samplesbId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbId = &#63;.
	 *
	 * @param samplesbId the samplesb ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findBySamplesbId_First(
			long samplesbId, OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findBySamplesbId_First(
			samplesbId, orderByComparator);
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbId = &#63;.
	 *
	 * @param samplesbId the samplesb ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchBySamplesbId_First(
		long samplesbId, OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchBySamplesbId_First(
			samplesbId, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbId = &#63;.
	 *
	 * @param samplesbId the samplesb ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findBySamplesbId_Last(
			long samplesbId, OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findBySamplesbId_Last(
			samplesbId, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbId = &#63;.
	 *
	 * @param samplesbId the samplesb ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchBySamplesbId_Last(
		long samplesbId, OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchBySamplesbId_Last(
			samplesbId, orderByComparator);
	}

	/**
	 * Removes all the sample sbs where samplesbId = &#63; from the database.
	 *
	 * @param samplesbId the samplesb ID
	 */
	public static void removeBySamplesbId(long samplesbId) {
		getPersistence().removeBySamplesbId(samplesbId);
	}

	/**
	 * Returns the number of sample sbs where samplesbId = &#63;.
	 *
	 * @param samplesbId the samplesb ID
	 * @return the number of matching sample sbs
	 */
	public static int countBySamplesbId(long samplesbId) {
		return getPersistence().countBySamplesbId(samplesbId);
	}

	/**
	 * Returns all the sample sbs where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findByTitle(String title) {
		return getPersistence().findByTitle(title);
	}

	/**
	 * Returns a range of all the sample sbs where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findByTitle(String title, int start, int end) {
		return getPersistence().findByTitle(title, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByTitle(
		String title, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findByTitle(
			title, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findByTitle(
		String title, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByTitle(
			title, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sample sb in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByTitle_First(
			String title, OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByTitle_First(title, orderByComparator);
	}

	/**
	 * Returns the first sample sb in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByTitle_First(
		String title, OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchByTitle_First(title, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findByTitle_Last(
			String title, OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByTitle_Last(title, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchByTitle_Last(
		String title, OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchByTitle_Last(title, orderByComparator);
	}

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where title = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB[] findByTitle_PrevAndNext(
			long samplesbId, String title,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByTitle_PrevAndNext(
			samplesbId, title, orderByComparator);
	}

	/**
	 * Removes all the sample sbs where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	public static void removeByTitle(String title) {
		getPersistence().removeByTitle(title);
	}

	/**
	 * Returns the number of sample sbs where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching sample sbs
	 */
	public static int countByTitle(String title) {
		return getPersistence().countByTitle(title);
	}

	/**
	 * Returns all the sample sbs where samplesbBooleanStat = &#63;.
	 *
	 * @param samplesbBooleanStat the samplesb boolean stat
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbBooleanStat(
		boolean samplesbBooleanStat) {

		return getPersistence().findBySamplesbBooleanStat(samplesbBooleanStat);
	}

	/**
	 * Returns a range of all the sample sbs where samplesbBooleanStat = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param samplesbBooleanStat the samplesb boolean stat
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbBooleanStat(
		boolean samplesbBooleanStat, int start, int end) {

		return getPersistence().findBySamplesbBooleanStat(
			samplesbBooleanStat, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where samplesbBooleanStat = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param samplesbBooleanStat the samplesb boolean stat
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbBooleanStat(
		boolean samplesbBooleanStat, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findBySamplesbBooleanStat(
			samplesbBooleanStat, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where samplesbBooleanStat = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param samplesbBooleanStat the samplesb boolean stat
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbBooleanStat(
		boolean samplesbBooleanStat, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBySamplesbBooleanStat(
			samplesbBooleanStat, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbBooleanStat = &#63;.
	 *
	 * @param samplesbBooleanStat the samplesb boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findBySamplesbBooleanStat_First(
			boolean samplesbBooleanStat,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findBySamplesbBooleanStat_First(
			samplesbBooleanStat, orderByComparator);
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbBooleanStat = &#63;.
	 *
	 * @param samplesbBooleanStat the samplesb boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchBySamplesbBooleanStat_First(
		boolean samplesbBooleanStat,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchBySamplesbBooleanStat_First(
			samplesbBooleanStat, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbBooleanStat = &#63;.
	 *
	 * @param samplesbBooleanStat the samplesb boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findBySamplesbBooleanStat_Last(
			boolean samplesbBooleanStat,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findBySamplesbBooleanStat_Last(
			samplesbBooleanStat, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbBooleanStat = &#63;.
	 *
	 * @param samplesbBooleanStat the samplesb boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchBySamplesbBooleanStat_Last(
		boolean samplesbBooleanStat,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchBySamplesbBooleanStat_Last(
			samplesbBooleanStat, orderByComparator);
	}

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where samplesbBooleanStat = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param samplesbBooleanStat the samplesb boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB[] findBySamplesbBooleanStat_PrevAndNext(
			long samplesbId, boolean samplesbBooleanStat,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findBySamplesbBooleanStat_PrevAndNext(
			samplesbId, samplesbBooleanStat, orderByComparator);
	}

	/**
	 * Removes all the sample sbs where samplesbBooleanStat = &#63; from the database.
	 *
	 * @param samplesbBooleanStat the samplesb boolean stat
	 */
	public static void removeBySamplesbBooleanStat(
		boolean samplesbBooleanStat) {

		getPersistence().removeBySamplesbBooleanStat(samplesbBooleanStat);
	}

	/**
	 * Returns the number of sample sbs where samplesbBooleanStat = &#63;.
	 *
	 * @param samplesbBooleanStat the samplesb boolean stat
	 * @return the number of matching sample sbs
	 */
	public static int countBySamplesbBooleanStat(boolean samplesbBooleanStat) {
		return getPersistence().countBySamplesbBooleanStat(samplesbBooleanStat);
	}

	/**
	 * Returns all the sample sbs where samplesbDateTime = &#63;.
	 *
	 * @param samplesbDateTime the samplesb date time
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbDateTime(Date samplesbDateTime) {
		return getPersistence().findBySamplesbDateTime(samplesbDateTime);
	}

	/**
	 * Returns a range of all the sample sbs where samplesbDateTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param samplesbDateTime the samplesb date time
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbDateTime(
		Date samplesbDateTime, int start, int end) {

		return getPersistence().findBySamplesbDateTime(
			samplesbDateTime, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where samplesbDateTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param samplesbDateTime the samplesb date time
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbDateTime(
		Date samplesbDateTime, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findBySamplesbDateTime(
			samplesbDateTime, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where samplesbDateTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param samplesbDateTime the samplesb date time
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbDateTime(
		Date samplesbDateTime, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBySamplesbDateTime(
			samplesbDateTime, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbDateTime = &#63;.
	 *
	 * @param samplesbDateTime the samplesb date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findBySamplesbDateTime_First(
			Date samplesbDateTime,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findBySamplesbDateTime_First(
			samplesbDateTime, orderByComparator);
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbDateTime = &#63;.
	 *
	 * @param samplesbDateTime the samplesb date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchBySamplesbDateTime_First(
		Date samplesbDateTime, OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchBySamplesbDateTime_First(
			samplesbDateTime, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbDateTime = &#63;.
	 *
	 * @param samplesbDateTime the samplesb date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findBySamplesbDateTime_Last(
			Date samplesbDateTime,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findBySamplesbDateTime_Last(
			samplesbDateTime, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbDateTime = &#63;.
	 *
	 * @param samplesbDateTime the samplesb date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchBySamplesbDateTime_Last(
		Date samplesbDateTime, OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchBySamplesbDateTime_Last(
			samplesbDateTime, orderByComparator);
	}

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where samplesbDateTime = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param samplesbDateTime the samplesb date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB[] findBySamplesbDateTime_PrevAndNext(
			long samplesbId, Date samplesbDateTime,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findBySamplesbDateTime_PrevAndNext(
			samplesbId, samplesbDateTime, orderByComparator);
	}

	/**
	 * Removes all the sample sbs where samplesbDateTime = &#63; from the database.
	 *
	 * @param samplesbDateTime the samplesb date time
	 */
	public static void removeBySamplesbDateTime(Date samplesbDateTime) {
		getPersistence().removeBySamplesbDateTime(samplesbDateTime);
	}

	/**
	 * Returns the number of sample sbs where samplesbDateTime = &#63;.
	 *
	 * @param samplesbDateTime the samplesb date time
	 * @return the number of matching sample sbs
	 */
	public static int countBySamplesbDateTime(Date samplesbDateTime) {
		return getPersistence().countBySamplesbDateTime(samplesbDateTime);
	}

	/**
	 * Returns all the sample sbs where samplesbDocumentLibrary = &#63;.
	 *
	 * @param samplesbDocumentLibrary the samplesb document library
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbDocumentLibrary(
		String samplesbDocumentLibrary) {

		return getPersistence().findBySamplesbDocumentLibrary(
			samplesbDocumentLibrary);
	}

	/**
	 * Returns a range of all the sample sbs where samplesbDocumentLibrary = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param samplesbDocumentLibrary the samplesb document library
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbDocumentLibrary(
		String samplesbDocumentLibrary, int start, int end) {

		return getPersistence().findBySamplesbDocumentLibrary(
			samplesbDocumentLibrary, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where samplesbDocumentLibrary = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param samplesbDocumentLibrary the samplesb document library
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbDocumentLibrary(
		String samplesbDocumentLibrary, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findBySamplesbDocumentLibrary(
			samplesbDocumentLibrary, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where samplesbDocumentLibrary = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param samplesbDocumentLibrary the samplesb document library
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbDocumentLibrary(
		String samplesbDocumentLibrary, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBySamplesbDocumentLibrary(
			samplesbDocumentLibrary, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbDocumentLibrary = &#63;.
	 *
	 * @param samplesbDocumentLibrary the samplesb document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findBySamplesbDocumentLibrary_First(
			String samplesbDocumentLibrary,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findBySamplesbDocumentLibrary_First(
			samplesbDocumentLibrary, orderByComparator);
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbDocumentLibrary = &#63;.
	 *
	 * @param samplesbDocumentLibrary the samplesb document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchBySamplesbDocumentLibrary_First(
		String samplesbDocumentLibrary,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchBySamplesbDocumentLibrary_First(
			samplesbDocumentLibrary, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbDocumentLibrary = &#63;.
	 *
	 * @param samplesbDocumentLibrary the samplesb document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findBySamplesbDocumentLibrary_Last(
			String samplesbDocumentLibrary,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findBySamplesbDocumentLibrary_Last(
			samplesbDocumentLibrary, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbDocumentLibrary = &#63;.
	 *
	 * @param samplesbDocumentLibrary the samplesb document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchBySamplesbDocumentLibrary_Last(
		String samplesbDocumentLibrary,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchBySamplesbDocumentLibrary_Last(
			samplesbDocumentLibrary, orderByComparator);
	}

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where samplesbDocumentLibrary = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param samplesbDocumentLibrary the samplesb document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB[] findBySamplesbDocumentLibrary_PrevAndNext(
			long samplesbId, String samplesbDocumentLibrary,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findBySamplesbDocumentLibrary_PrevAndNext(
			samplesbId, samplesbDocumentLibrary, orderByComparator);
	}

	/**
	 * Removes all the sample sbs where samplesbDocumentLibrary = &#63; from the database.
	 *
	 * @param samplesbDocumentLibrary the samplesb document library
	 */
	public static void removeBySamplesbDocumentLibrary(
		String samplesbDocumentLibrary) {

		getPersistence().removeBySamplesbDocumentLibrary(
			samplesbDocumentLibrary);
	}

	/**
	 * Returns the number of sample sbs where samplesbDocumentLibrary = &#63;.
	 *
	 * @param samplesbDocumentLibrary the samplesb document library
	 * @return the number of matching sample sbs
	 */
	public static int countBySamplesbDocumentLibrary(
		String samplesbDocumentLibrary) {

		return getPersistence().countBySamplesbDocumentLibrary(
			samplesbDocumentLibrary);
	}

	/**
	 * Returns all the sample sbs where samplesbDouble = &#63;.
	 *
	 * @param samplesbDouble the samplesb double
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbDouble(double samplesbDouble) {
		return getPersistence().findBySamplesbDouble(samplesbDouble);
	}

	/**
	 * Returns a range of all the sample sbs where samplesbDouble = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param samplesbDouble the samplesb double
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbDouble(
		double samplesbDouble, int start, int end) {

		return getPersistence().findBySamplesbDouble(
			samplesbDouble, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where samplesbDouble = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param samplesbDouble the samplesb double
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbDouble(
		double samplesbDouble, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findBySamplesbDouble(
			samplesbDouble, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where samplesbDouble = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param samplesbDouble the samplesb double
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbDouble(
		double samplesbDouble, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBySamplesbDouble(
			samplesbDouble, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbDouble = &#63;.
	 *
	 * @param samplesbDouble the samplesb double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findBySamplesbDouble_First(
			double samplesbDouble,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findBySamplesbDouble_First(
			samplesbDouble, orderByComparator);
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbDouble = &#63;.
	 *
	 * @param samplesbDouble the samplesb double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchBySamplesbDouble_First(
		double samplesbDouble, OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchBySamplesbDouble_First(
			samplesbDouble, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbDouble = &#63;.
	 *
	 * @param samplesbDouble the samplesb double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findBySamplesbDouble_Last(
			double samplesbDouble,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findBySamplesbDouble_Last(
			samplesbDouble, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbDouble = &#63;.
	 *
	 * @param samplesbDouble the samplesb double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchBySamplesbDouble_Last(
		double samplesbDouble, OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchBySamplesbDouble_Last(
			samplesbDouble, orderByComparator);
	}

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where samplesbDouble = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param samplesbDouble the samplesb double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB[] findBySamplesbDouble_PrevAndNext(
			long samplesbId, double samplesbDouble,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findBySamplesbDouble_PrevAndNext(
			samplesbId, samplesbDouble, orderByComparator);
	}

	/**
	 * Removes all the sample sbs where samplesbDouble = &#63; from the database.
	 *
	 * @param samplesbDouble the samplesb double
	 */
	public static void removeBySamplesbDouble(double samplesbDouble) {
		getPersistence().removeBySamplesbDouble(samplesbDouble);
	}

	/**
	 * Returns the number of sample sbs where samplesbDouble = &#63;.
	 *
	 * @param samplesbDouble the samplesb double
	 * @return the number of matching sample sbs
	 */
	public static int countBySamplesbDouble(double samplesbDouble) {
		return getPersistence().countBySamplesbDouble(samplesbDouble);
	}

	/**
	 * Returns all the sample sbs where samplesbInteger = &#63;.
	 *
	 * @param samplesbInteger the samplesb integer
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbInteger(int samplesbInteger) {
		return getPersistence().findBySamplesbInteger(samplesbInteger);
	}

	/**
	 * Returns a range of all the sample sbs where samplesbInteger = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param samplesbInteger the samplesb integer
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbInteger(
		int samplesbInteger, int start, int end) {

		return getPersistence().findBySamplesbInteger(
			samplesbInteger, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where samplesbInteger = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param samplesbInteger the samplesb integer
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbInteger(
		int samplesbInteger, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findBySamplesbInteger(
			samplesbInteger, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where samplesbInteger = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param samplesbInteger the samplesb integer
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbInteger(
		int samplesbInteger, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBySamplesbInteger(
			samplesbInteger, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbInteger = &#63;.
	 *
	 * @param samplesbInteger the samplesb integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findBySamplesbInteger_First(
			int samplesbInteger, OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findBySamplesbInteger_First(
			samplesbInteger, orderByComparator);
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbInteger = &#63;.
	 *
	 * @param samplesbInteger the samplesb integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchBySamplesbInteger_First(
		int samplesbInteger, OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchBySamplesbInteger_First(
			samplesbInteger, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbInteger = &#63;.
	 *
	 * @param samplesbInteger the samplesb integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findBySamplesbInteger_Last(
			int samplesbInteger, OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findBySamplesbInteger_Last(
			samplesbInteger, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbInteger = &#63;.
	 *
	 * @param samplesbInteger the samplesb integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchBySamplesbInteger_Last(
		int samplesbInteger, OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchBySamplesbInteger_Last(
			samplesbInteger, orderByComparator);
	}

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where samplesbInteger = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param samplesbInteger the samplesb integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB[] findBySamplesbInteger_PrevAndNext(
			long samplesbId, int samplesbInteger,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findBySamplesbInteger_PrevAndNext(
			samplesbId, samplesbInteger, orderByComparator);
	}

	/**
	 * Removes all the sample sbs where samplesbInteger = &#63; from the database.
	 *
	 * @param samplesbInteger the samplesb integer
	 */
	public static void removeBySamplesbInteger(int samplesbInteger) {
		getPersistence().removeBySamplesbInteger(samplesbInteger);
	}

	/**
	 * Returns the number of sample sbs where samplesbInteger = &#63;.
	 *
	 * @param samplesbInteger the samplesb integer
	 * @return the number of matching sample sbs
	 */
	public static int countBySamplesbInteger(int samplesbInteger) {
		return getPersistence().countBySamplesbInteger(samplesbInteger);
	}

	/**
	 * Returns all the sample sbs where samplesbRichText = &#63;.
	 *
	 * @param samplesbRichText the samplesb rich text
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbRichText(
		String samplesbRichText) {

		return getPersistence().findBySamplesbRichText(samplesbRichText);
	}

	/**
	 * Returns a range of all the sample sbs where samplesbRichText = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param samplesbRichText the samplesb rich text
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbRichText(
		String samplesbRichText, int start, int end) {

		return getPersistence().findBySamplesbRichText(
			samplesbRichText, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where samplesbRichText = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param samplesbRichText the samplesb rich text
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbRichText(
		String samplesbRichText, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findBySamplesbRichText(
			samplesbRichText, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where samplesbRichText = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param samplesbRichText the samplesb rich text
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbRichText(
		String samplesbRichText, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBySamplesbRichText(
			samplesbRichText, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbRichText = &#63;.
	 *
	 * @param samplesbRichText the samplesb rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findBySamplesbRichText_First(
			String samplesbRichText,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findBySamplesbRichText_First(
			samplesbRichText, orderByComparator);
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbRichText = &#63;.
	 *
	 * @param samplesbRichText the samplesb rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchBySamplesbRichText_First(
		String samplesbRichText,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchBySamplesbRichText_First(
			samplesbRichText, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbRichText = &#63;.
	 *
	 * @param samplesbRichText the samplesb rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findBySamplesbRichText_Last(
			String samplesbRichText,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findBySamplesbRichText_Last(
			samplesbRichText, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbRichText = &#63;.
	 *
	 * @param samplesbRichText the samplesb rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchBySamplesbRichText_Last(
		String samplesbRichText,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchBySamplesbRichText_Last(
			samplesbRichText, orderByComparator);
	}

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where samplesbRichText = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param samplesbRichText the samplesb rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB[] findBySamplesbRichText_PrevAndNext(
			long samplesbId, String samplesbRichText,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findBySamplesbRichText_PrevAndNext(
			samplesbId, samplesbRichText, orderByComparator);
	}

	/**
	 * Removes all the sample sbs where samplesbRichText = &#63; from the database.
	 *
	 * @param samplesbRichText the samplesb rich text
	 */
	public static void removeBySamplesbRichText(String samplesbRichText) {
		getPersistence().removeBySamplesbRichText(samplesbRichText);
	}

	/**
	 * Returns the number of sample sbs where samplesbRichText = &#63;.
	 *
	 * @param samplesbRichText the samplesb rich text
	 * @return the number of matching sample sbs
	 */
	public static int countBySamplesbRichText(String samplesbRichText) {
		return getPersistence().countBySamplesbRichText(samplesbRichText);
	}

	/**
	 * Returns all the sample sbs where samplesbText = &#63;.
	 *
	 * @param samplesbText the samplesb text
	 * @return the matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbText(String samplesbText) {
		return getPersistence().findBySamplesbText(samplesbText);
	}

	/**
	 * Returns a range of all the sample sbs where samplesbText = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param samplesbText the samplesb text
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbText(
		String samplesbText, int start, int end) {

		return getPersistence().findBySamplesbText(samplesbText, start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs where samplesbText = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param samplesbText the samplesb text
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbText(
		String samplesbText, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findBySamplesbText(
			samplesbText, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs where samplesbText = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param samplesbText the samplesb text
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample sbs
	 */
	public static List<SampleSB> findBySamplesbText(
		String samplesbText, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBySamplesbText(
			samplesbText, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbText = &#63;.
	 *
	 * @param samplesbText the samplesb text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findBySamplesbText_First(
			String samplesbText, OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findBySamplesbText_First(
			samplesbText, orderByComparator);
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbText = &#63;.
	 *
	 * @param samplesbText the samplesb text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchBySamplesbText_First(
		String samplesbText, OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchBySamplesbText_First(
			samplesbText, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbText = &#63;.
	 *
	 * @param samplesbText the samplesb text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public static SampleSB findBySamplesbText_Last(
			String samplesbText, OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findBySamplesbText_Last(
			samplesbText, orderByComparator);
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbText = &#63;.
	 *
	 * @param samplesbText the samplesb text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public static SampleSB fetchBySamplesbText_Last(
		String samplesbText, OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().fetchBySamplesbText_Last(
			samplesbText, orderByComparator);
	}

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where samplesbText = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param samplesbText the samplesb text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB[] findBySamplesbText_PrevAndNext(
			long samplesbId, String samplesbText,
			OrderByComparator<SampleSB> orderByComparator)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findBySamplesbText_PrevAndNext(
			samplesbId, samplesbText, orderByComparator);
	}

	/**
	 * Removes all the sample sbs where samplesbText = &#63; from the database.
	 *
	 * @param samplesbText the samplesb text
	 */
	public static void removeBySamplesbText(String samplesbText) {
		getPersistence().removeBySamplesbText(samplesbText);
	}

	/**
	 * Returns the number of sample sbs where samplesbText = &#63;.
	 *
	 * @param samplesbText the samplesb text
	 * @return the number of matching sample sbs
	 */
	public static int countBySamplesbText(String samplesbText) {
		return getPersistence().countBySamplesbText(samplesbText);
	}

	/**
	 * Caches the sample sb in the entity cache if it is enabled.
	 *
	 * @param sampleSB the sample sb
	 */
	public static void cacheResult(SampleSB sampleSB) {
		getPersistence().cacheResult(sampleSB);
	}

	/**
	 * Caches the sample sbs in the entity cache if it is enabled.
	 *
	 * @param sampleSBs the sample sbs
	 */
	public static void cacheResult(List<SampleSB> sampleSBs) {
		getPersistence().cacheResult(sampleSBs);
	}

	/**
	 * Creates a new sample sb with the primary key. Does not add the sample sb to the database.
	 *
	 * @param samplesbId the primary key for the new sample sb
	 * @return the new sample sb
	 */
	public static SampleSB create(long samplesbId) {
		return getPersistence().create(samplesbId);
	}

	/**
	 * Removes the sample sb with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param samplesbId the primary key of the sample sb
	 * @return the sample sb that was removed
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB remove(long samplesbId)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().remove(samplesbId);
	}

	public static SampleSB updateImpl(SampleSB sampleSB) {
		return getPersistence().updateImpl(sampleSB);
	}

	/**
	 * Returns the sample sb with the primary key or throws a <code>NoSuchSampleSBException</code> if it could not be found.
	 *
	 * @param samplesbId the primary key of the sample sb
	 * @return the sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public static SampleSB findByPrimaryKey(long samplesbId)
		throws com.liferay.sb.test.exception.NoSuchSampleSBException {

		return getPersistence().findByPrimaryKey(samplesbId);
	}

	/**
	 * Returns the sample sb with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param samplesbId the primary key of the sample sb
	 * @return the sample sb, or <code>null</code> if a sample sb with the primary key could not be found
	 */
	public static SampleSB fetchByPrimaryKey(long samplesbId) {
		return getPersistence().fetchByPrimaryKey(samplesbId);
	}

	/**
	 * Returns all the sample sbs.
	 *
	 * @return the sample sbs
	 */
	public static List<SampleSB> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the sample sbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @return the range of sample sbs
	 */
	public static List<SampleSB> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the sample sbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sample sbs
	 */
	public static List<SampleSB> findAll(
		int start, int end, OrderByComparator<SampleSB> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample sbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleSBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sample sbs
	 * @param end the upper bound of the range of sample sbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sample sbs
	 */
	public static List<SampleSB> findAll(
		int start, int end, OrderByComparator<SampleSB> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sample sbs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sample sbs.
	 *
	 * @return the number of sample sbs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SampleSBPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SampleSBPersistence, SampleSBPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SampleSBPersistence.class);

		ServiceTracker<SampleSBPersistence, SampleSBPersistence>
			serviceTracker =
				new ServiceTracker<SampleSBPersistence, SampleSBPersistence>(
					bundle.getBundleContext(), SampleSBPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}