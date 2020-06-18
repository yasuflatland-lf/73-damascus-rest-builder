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

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.sb.test.exception.NoSuchSampleSBException;
import com.liferay.sb.test.model.SampleSB;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sample sb service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author "yasuflatland"
 * @see SampleSBUtil
 * @generated
 */
@ProviderType
public interface SampleSBPersistence extends BasePersistence<SampleSB> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SampleSBUtil} to access the sample sb persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the sample sbs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sample sbs
	 */
	public java.util.List<SampleSB> findByUuid(String uuid);

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
	public java.util.List<SampleSB> findByUuid(String uuid, int start, int end);

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
	public java.util.List<SampleSB> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sample sb in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the first sample sb in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the last sample sb in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the last sample sb in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where uuid = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public SampleSB[] findByUuid_PrevAndNext(
			long samplesbId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Removes all the sample sbs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of sample sbs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sample sbs
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the sample sb where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSampleSBException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findByUUID_G(String uuid, long groupId)
		throws NoSuchSampleSBException;

	/**
	 * Returns the sample sb where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the sample sb where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the sample sb where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the sample sb that was removed
	 */
	public SampleSB removeByUUID_G(String uuid, long groupId)
		throws NoSuchSampleSBException;

	/**
	 * Returns the number of sample sbs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching sample sbs
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the sample sbs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching sample sbs
	 */
	public java.util.List<SampleSB> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<SampleSB> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<SampleSB> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sample sb in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the first sample sb in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the last sample sb in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the last sample sb in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public SampleSB[] findByUuid_C_PrevAndNext(
			long samplesbId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Removes all the sample sbs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of sample sbs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching sample sbs
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the sample sbs where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching sample sbs
	 */
	public java.util.List<SampleSB> findByC_S(long companyId, int status);

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
	public java.util.List<SampleSB> findByC_S(
		long companyId, int status, int start, int end);

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
	public java.util.List<SampleSB> findByC_S(
		long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findByC_S(
		long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sample sb in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findByC_S_First(
			long companyId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the first sample sb in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByC_S_First(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the last sample sb in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findByC_S_Last(
			long companyId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the last sample sb in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByC_S_Last(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public SampleSB[] findByC_S_PrevAndNext(
			long samplesbId, long companyId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

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
	public java.util.List<SampleSB> findByC_S(long companyId, int[] statuses);

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
	public java.util.List<SampleSB> findByC_S(
		long companyId, int[] statuses, int start, int end);

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
	public java.util.List<SampleSB> findByC_S(
		long companyId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findByC_S(
		long companyId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sample sbs where companyId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 */
	public void removeByC_S(long companyId, int status);

	/**
	 * Returns the number of sample sbs where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching sample sbs
	 */
	public int countByC_S(long companyId, int status);

	/**
	 * Returns the number of sample sbs where companyId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @return the number of matching sample sbs
	 */
	public int countByC_S(long companyId, int[] statuses);

	/**
	 * Returns all the sample sbs where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching sample sbs
	 */
	public java.util.List<SampleSB> findByG_S(long groupId, int status);

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
	public java.util.List<SampleSB> findByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<SampleSB> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sample sb in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the first sample sb in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the last sample sb in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the last sample sb in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public SampleSB[] findByG_S_PrevAndNext(
			long samplesbId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns all the sample sbs that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching sample sbs that the user has permission to view
	 */
	public java.util.List<SampleSB> filterFindByG_S(long groupId, int status);

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
	public java.util.List<SampleSB> filterFindByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<SampleSB> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public SampleSB[] filterFindByG_S_PrevAndNext(
			long samplesbId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns all the sample sbs that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the matching sample sbs that the user has permission to view
	 */
	public java.util.List<SampleSB> filterFindByG_S(
		long groupId, int[] statuses);

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
	public java.util.List<SampleSB> filterFindByG_S(
		long groupId, int[] statuses, int start, int end);

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
	public java.util.List<SampleSB> filterFindByG_S(
		long groupId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findByG_S(long groupId, int[] statuses);

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
	public java.util.List<SampleSB> findByG_S(
		long groupId, int[] statuses, int start, int end);

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
	public java.util.List<SampleSB> findByG_S(
		long groupId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findByG_S(
		long groupId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sample sbs where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of sample sbs where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching sample sbs
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Returns the number of sample sbs where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching sample sbs
	 */
	public int countByG_S(long groupId, int[] statuses);

	/**
	 * Returns the number of sample sbs that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching sample sbs that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int status);

	/**
	 * Returns the number of sample sbs that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching sample sbs that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int[] statuses);

	/**
	 * Returns all the sample sbs where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching sample sbs
	 */
	public java.util.List<SampleSB> findByC_U_S(
		long companyId, long userId, int status);

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
	public java.util.List<SampleSB> findByC_U_S(
		long companyId, long userId, int status, int start, int end);

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
	public java.util.List<SampleSB> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

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
	public SampleSB findByC_U_S_First(
			long companyId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the first sample sb in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByC_U_S_First(
		long companyId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public SampleSB findByC_U_S_Last(
			long companyId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the last sample sb in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByC_U_S_Last(
		long companyId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public SampleSB[] findByC_U_S_PrevAndNext(
			long samplesbId, long companyId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

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
	public java.util.List<SampleSB> findByC_U_S(
		long companyId, long userId, int[] statuses);

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
	public java.util.List<SampleSB> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end);

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
	public java.util.List<SampleSB> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sample sbs where companyId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByC_U_S(long companyId, long userId, int status);

	/**
	 * Returns the number of sample sbs where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching sample sbs
	 */
	public int countByC_U_S(long companyId, long userId, int status);

	/**
	 * Returns the number of sample sbs where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching sample sbs
	 */
	public int countByC_U_S(long companyId, long userId, int[] statuses);

	/**
	 * Returns all the sample sbs where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching sample sbs
	 */
	public java.util.List<SampleSB> findByG_U_S(
		long groupId, long userId, int status);

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
	public java.util.List<SampleSB> findByG_U_S(
		long groupId, long userId, int status, int start, int end);

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
	public java.util.List<SampleSB> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

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
	public SampleSB findByG_U_S_First(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the first sample sb in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByG_U_S_First(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public SampleSB findByG_U_S_Last(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the last sample sb in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByG_U_S_Last(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public SampleSB[] findByG_U_S_PrevAndNext(
			long samplesbId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns all the sample sbs that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching sample sbs that the user has permission to view
	 */
	public java.util.List<SampleSB> filterFindByG_U_S(
		long groupId, long userId, int status);

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
	public java.util.List<SampleSB> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end);

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
	public java.util.List<SampleSB> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public SampleSB[] filterFindByG_U_S_PrevAndNext(
			long samplesbId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns all the sample sbs that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching sample sbs that the user has permission to view
	 */
	public java.util.List<SampleSB> filterFindByG_U_S(
		long groupId, long userId, int[] statuses);

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
	public java.util.List<SampleSB> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end);

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
	public java.util.List<SampleSB> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findByG_U_S(
		long groupId, long userId, int[] statuses);

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
	public java.util.List<SampleSB> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end);

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
	public java.util.List<SampleSB> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sample sbs where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of sample sbs where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching sample sbs
	 */
	public int countByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of sample sbs where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching sample sbs
	 */
	public int countByG_U_S(long groupId, long userId, int[] statuses);

	/**
	 * Returns the number of sample sbs that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching sample sbs that the user has permission to view
	 */
	public int filterCountByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of sample sbs that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching sample sbs that the user has permission to view
	 */
	public int filterCountByG_U_S(long groupId, long userId, int[] statuses);

	/**
	 * Returns all the sample sbs where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching sample sbs
	 */
	public java.util.List<SampleSB> findByU_S(long userId, int status);

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
	public java.util.List<SampleSB> findByU_S(
		long userId, int status, int start, int end);

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
	public java.util.List<SampleSB> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sample sb in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findByU_S_First(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the first sample sb in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByU_S_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the last sample sb in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findByU_S_Last(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the last sample sb in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByU_S_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public SampleSB[] findByU_S_PrevAndNext(
			long samplesbId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

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
	public java.util.List<SampleSB> findByU_S(long userId, int[] statuses);

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
	public java.util.List<SampleSB> findByU_S(
		long userId, int[] statuses, int start, int end);

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
	public java.util.List<SampleSB> findByU_S(
		long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findByU_S(
		long userId, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sample sbs where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByU_S(long userId, int status);

	/**
	 * Returns the number of sample sbs where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching sample sbs
	 */
	public int countByU_S(long userId, int status);

	/**
	 * Returns the number of sample sbs where userId = &#63; and status = any &#63;.
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching sample sbs
	 */
	public int countByU_S(long userId, int[] statuses);

	/**
	 * Returns all the sample sbs where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching sample sbs
	 */
	public java.util.List<SampleSB> findByG_UT_ST(
		long groupId, String urlTitle, int status);

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
	public java.util.List<SampleSB> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end);

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
	public java.util.List<SampleSB> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

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
	public SampleSB findByG_UT_ST_First(
			long groupId, String urlTitle, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the first sample sb in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByG_UT_ST_First(
		long groupId, String urlTitle, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public SampleSB findByG_UT_ST_Last(
			long groupId, String urlTitle, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the last sample sb in the ordered set where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByG_UT_ST_Last(
		long groupId, String urlTitle, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public SampleSB[] findByG_UT_ST_PrevAndNext(
			long samplesbId, long groupId, String urlTitle, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns all the sample sbs that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching sample sbs that the user has permission to view
	 */
	public java.util.List<SampleSB> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status);

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
	public java.util.List<SampleSB> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end);

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
	public java.util.List<SampleSB> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public SampleSB[] filterFindByG_UT_ST_PrevAndNext(
			long samplesbId, long groupId, String urlTitle, int status,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns all the sample sbs that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the matching sample sbs that the user has permission to view
	 */
	public java.util.List<SampleSB> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses);

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
	public java.util.List<SampleSB> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end);

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
	public java.util.List<SampleSB> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses);

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
	public java.util.List<SampleSB> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end);

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
	public java.util.List<SampleSB> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sample sbs where groupId = &#63; and urlTitle = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 */
	public void removeByG_UT_ST(long groupId, String urlTitle, int status);

	/**
	 * Returns the number of sample sbs where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching sample sbs
	 */
	public int countByG_UT_ST(long groupId, String urlTitle, int status);

	/**
	 * Returns the number of sample sbs where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching sample sbs
	 */
	public int countByG_UT_ST(long groupId, String urlTitle, int[] statuses);

	/**
	 * Returns the number of sample sbs that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching sample sbs that the user has permission to view
	 */
	public int filterCountByG_UT_ST(long groupId, String urlTitle, int status);

	/**
	 * Returns the number of sample sbs that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching sample sbs that the user has permission to view
	 */
	public int filterCountByG_UT_ST(
		long groupId, String urlTitle, int[] statuses);

	/**
	 * Returns the sample sb where groupId = &#63; and urlTitle = &#63; or throws a <code>NoSuchSampleSBException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findByG_UT(long groupId, String urlTitle)
		throws NoSuchSampleSBException;

	/**
	 * Returns the sample sb where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByG_UT(long groupId, String urlTitle);

	/**
	 * Returns the sample sb where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByG_UT(
		long groupId, String urlTitle, boolean useFinderCache);

	/**
	 * Removes the sample sb where groupId = &#63; and urlTitle = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the sample sb that was removed
	 */
	public SampleSB removeByG_UT(long groupId, String urlTitle)
		throws NoSuchSampleSBException;

	/**
	 * Returns the number of sample sbs where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the number of matching sample sbs
	 */
	public int countByG_UT(long groupId, String urlTitle);

	/**
	 * Returns the sample sb where urlTitle = &#63; or throws a <code>NoSuchSampleSBException</code> if it could not be found.
	 *
	 * @param urlTitle the url title
	 * @return the matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findByURLTitle(String urlTitle)
		throws NoSuchSampleSBException;

	/**
	 * Returns the sample sb where urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param urlTitle the url title
	 * @return the matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByURLTitle(String urlTitle);

	/**
	 * Returns the sample sb where urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByURLTitle(String urlTitle, boolean useFinderCache);

	/**
	 * Removes the sample sb where urlTitle = &#63; from the database.
	 *
	 * @param urlTitle the url title
	 * @return the sample sb that was removed
	 */
	public SampleSB removeByURLTitle(String urlTitle)
		throws NoSuchSampleSBException;

	/**
	 * Returns the number of sample sbs where urlTitle = &#63;.
	 *
	 * @param urlTitle the url title
	 * @return the number of matching sample sbs
	 */
	public int countByURLTitle(String urlTitle);

	/**
	 * Returns all the sample sbs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching sample sbs
	 */
	public java.util.List<SampleSB> findByGroupId(long groupId);

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
	public java.util.List<SampleSB> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<SampleSB> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sample sb in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the first sample sb in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the last sample sb in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the last sample sb in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where groupId = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public SampleSB[] findByGroupId_PrevAndNext(
			long samplesbId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns all the sample sbs that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching sample sbs that the user has permission to view
	 */
	public java.util.List<SampleSB> filterFindByGroupId(long groupId);

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
	public java.util.List<SampleSB> filterFindByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<SampleSB> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set of sample sbs that the user has permission to view where groupId = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public SampleSB[] filterFindByGroupId_PrevAndNext(
			long samplesbId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Removes all the sample sbs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of sample sbs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching sample sbs
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of sample sbs that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching sample sbs that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the sample sbs where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching sample sbs
	 */
	public java.util.List<SampleSB> findByUserIdGroupId(
		long userId, long groupId);

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
	public java.util.List<SampleSB> findByUserIdGroupId(
		long userId, long groupId, int start, int end);

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
	public java.util.List<SampleSB> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sample sb in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findByUserIdGroupId_First(
			long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the first sample sb in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByUserIdGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the last sample sb in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findByUserIdGroupId_Last(
			long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the last sample sb in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByUserIdGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public SampleSB[] findByUserIdGroupId_PrevAndNext(
			long samplesbId, long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns all the sample sbs that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching sample sbs that the user has permission to view
	 */
	public java.util.List<SampleSB> filterFindByUserIdGroupId(
		long userId, long groupId);

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
	public java.util.List<SampleSB> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end);

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
	public java.util.List<SampleSB> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public SampleSB[] filterFindByUserIdGroupId_PrevAndNext(
			long samplesbId, long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Removes all the sample sbs where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 */
	public void removeByUserIdGroupId(long userId, long groupId);

	/**
	 * Returns the number of sample sbs where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching sample sbs
	 */
	public int countByUserIdGroupId(long userId, long groupId);

	/**
	 * Returns the number of sample sbs that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching sample sbs that the user has permission to view
	 */
	public int filterCountByUserIdGroupId(long userId, long groupId);

	/**
	 * Returns all the sample sbs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching sample sbs
	 */
	public java.util.List<SampleSB> findByUserId(long userId);

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
	public java.util.List<SampleSB> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<SampleSB> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sample sb in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the first sample sb in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the last sample sb in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the last sample sb in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where userId = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public SampleSB[] findByUserId_PrevAndNext(
			long samplesbId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Removes all the sample sbs where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of sample sbs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching sample sbs
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the sample sbs where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching sample sbs
	 */
	public java.util.List<SampleSB> findByCompanyId(long companyId);

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
	public java.util.List<SampleSB> findByCompanyId(
		long companyId, int start, int end);

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
	public java.util.List<SampleSB> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sample sb in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findByCompanyId_First(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the first sample sb in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the last sample sb in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findByCompanyId_Last(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the last sample sb in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where companyId = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public SampleSB[] findByCompanyId_PrevAndNext(
			long samplesbId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Removes all the sample sbs where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompanyId(long companyId);

	/**
	 * Returns the number of sample sbs where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching sample sbs
	 */
	public int countByCompanyId(long companyId);

	/**
	 * Returns all the sample sbs where samplesbId = &#63;.
	 *
	 * @param samplesbId the samplesb ID
	 * @return the matching sample sbs
	 */
	public java.util.List<SampleSB> findBySamplesbId(long samplesbId);

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
	public java.util.List<SampleSB> findBySamplesbId(
		long samplesbId, int start, int end);

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
	public java.util.List<SampleSB> findBySamplesbId(
		long samplesbId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findBySamplesbId(
		long samplesbId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sample sb in the ordered set where samplesbId = &#63;.
	 *
	 * @param samplesbId the samplesb ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findBySamplesbId_First(
			long samplesbId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the first sample sb in the ordered set where samplesbId = &#63;.
	 *
	 * @param samplesbId the samplesb ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchBySamplesbId_First(
		long samplesbId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the last sample sb in the ordered set where samplesbId = &#63;.
	 *
	 * @param samplesbId the samplesb ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findBySamplesbId_Last(
			long samplesbId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the last sample sb in the ordered set where samplesbId = &#63;.
	 *
	 * @param samplesbId the samplesb ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchBySamplesbId_Last(
		long samplesbId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Removes all the sample sbs where samplesbId = &#63; from the database.
	 *
	 * @param samplesbId the samplesb ID
	 */
	public void removeBySamplesbId(long samplesbId);

	/**
	 * Returns the number of sample sbs where samplesbId = &#63;.
	 *
	 * @param samplesbId the samplesb ID
	 * @return the number of matching sample sbs
	 */
	public int countBySamplesbId(long samplesbId);

	/**
	 * Returns all the sample sbs where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching sample sbs
	 */
	public java.util.List<SampleSB> findByTitle(String title);

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
	public java.util.List<SampleSB> findByTitle(
		String title, int start, int end);

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
	public java.util.List<SampleSB> findByTitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findByTitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sample sb in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findByTitle_First(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the first sample sb in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByTitle_First(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the last sample sb in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findByTitle_Last(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the last sample sb in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchByTitle_Last(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where title = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public SampleSB[] findByTitle_PrevAndNext(
			long samplesbId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Removes all the sample sbs where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	public void removeByTitle(String title);

	/**
	 * Returns the number of sample sbs where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching sample sbs
	 */
	public int countByTitle(String title);

	/**
	 * Returns all the sample sbs where samplesbBooleanStat = &#63;.
	 *
	 * @param samplesbBooleanStat the samplesb boolean stat
	 * @return the matching sample sbs
	 */
	public java.util.List<SampleSB> findBySamplesbBooleanStat(
		boolean samplesbBooleanStat);

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
	public java.util.List<SampleSB> findBySamplesbBooleanStat(
		boolean samplesbBooleanStat, int start, int end);

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
	public java.util.List<SampleSB> findBySamplesbBooleanStat(
		boolean samplesbBooleanStat, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findBySamplesbBooleanStat(
		boolean samplesbBooleanStat, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sample sb in the ordered set where samplesbBooleanStat = &#63;.
	 *
	 * @param samplesbBooleanStat the samplesb boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findBySamplesbBooleanStat_First(
			boolean samplesbBooleanStat,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the first sample sb in the ordered set where samplesbBooleanStat = &#63;.
	 *
	 * @param samplesbBooleanStat the samplesb boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchBySamplesbBooleanStat_First(
		boolean samplesbBooleanStat,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the last sample sb in the ordered set where samplesbBooleanStat = &#63;.
	 *
	 * @param samplesbBooleanStat the samplesb boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findBySamplesbBooleanStat_Last(
			boolean samplesbBooleanStat,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the last sample sb in the ordered set where samplesbBooleanStat = &#63;.
	 *
	 * @param samplesbBooleanStat the samplesb boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchBySamplesbBooleanStat_Last(
		boolean samplesbBooleanStat,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where samplesbBooleanStat = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param samplesbBooleanStat the samplesb boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public SampleSB[] findBySamplesbBooleanStat_PrevAndNext(
			long samplesbId, boolean samplesbBooleanStat,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Removes all the sample sbs where samplesbBooleanStat = &#63; from the database.
	 *
	 * @param samplesbBooleanStat the samplesb boolean stat
	 */
	public void removeBySamplesbBooleanStat(boolean samplesbBooleanStat);

	/**
	 * Returns the number of sample sbs where samplesbBooleanStat = &#63;.
	 *
	 * @param samplesbBooleanStat the samplesb boolean stat
	 * @return the number of matching sample sbs
	 */
	public int countBySamplesbBooleanStat(boolean samplesbBooleanStat);

	/**
	 * Returns all the sample sbs where samplesbDateTime = &#63;.
	 *
	 * @param samplesbDateTime the samplesb date time
	 * @return the matching sample sbs
	 */
	public java.util.List<SampleSB> findBySamplesbDateTime(
		Date samplesbDateTime);

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
	public java.util.List<SampleSB> findBySamplesbDateTime(
		Date samplesbDateTime, int start, int end);

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
	public java.util.List<SampleSB> findBySamplesbDateTime(
		Date samplesbDateTime, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findBySamplesbDateTime(
		Date samplesbDateTime, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sample sb in the ordered set where samplesbDateTime = &#63;.
	 *
	 * @param samplesbDateTime the samplesb date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findBySamplesbDateTime_First(
			Date samplesbDateTime,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the first sample sb in the ordered set where samplesbDateTime = &#63;.
	 *
	 * @param samplesbDateTime the samplesb date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchBySamplesbDateTime_First(
		Date samplesbDateTime,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the last sample sb in the ordered set where samplesbDateTime = &#63;.
	 *
	 * @param samplesbDateTime the samplesb date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findBySamplesbDateTime_Last(
			Date samplesbDateTime,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the last sample sb in the ordered set where samplesbDateTime = &#63;.
	 *
	 * @param samplesbDateTime the samplesb date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchBySamplesbDateTime_Last(
		Date samplesbDateTime,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where samplesbDateTime = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param samplesbDateTime the samplesb date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public SampleSB[] findBySamplesbDateTime_PrevAndNext(
			long samplesbId, Date samplesbDateTime,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Removes all the sample sbs where samplesbDateTime = &#63; from the database.
	 *
	 * @param samplesbDateTime the samplesb date time
	 */
	public void removeBySamplesbDateTime(Date samplesbDateTime);

	/**
	 * Returns the number of sample sbs where samplesbDateTime = &#63;.
	 *
	 * @param samplesbDateTime the samplesb date time
	 * @return the number of matching sample sbs
	 */
	public int countBySamplesbDateTime(Date samplesbDateTime);

	/**
	 * Returns all the sample sbs where samplesbDocumentLibrary = &#63;.
	 *
	 * @param samplesbDocumentLibrary the samplesb document library
	 * @return the matching sample sbs
	 */
	public java.util.List<SampleSB> findBySamplesbDocumentLibrary(
		String samplesbDocumentLibrary);

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
	public java.util.List<SampleSB> findBySamplesbDocumentLibrary(
		String samplesbDocumentLibrary, int start, int end);

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
	public java.util.List<SampleSB> findBySamplesbDocumentLibrary(
		String samplesbDocumentLibrary, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findBySamplesbDocumentLibrary(
		String samplesbDocumentLibrary, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sample sb in the ordered set where samplesbDocumentLibrary = &#63;.
	 *
	 * @param samplesbDocumentLibrary the samplesb document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findBySamplesbDocumentLibrary_First(
			String samplesbDocumentLibrary,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the first sample sb in the ordered set where samplesbDocumentLibrary = &#63;.
	 *
	 * @param samplesbDocumentLibrary the samplesb document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchBySamplesbDocumentLibrary_First(
		String samplesbDocumentLibrary,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the last sample sb in the ordered set where samplesbDocumentLibrary = &#63;.
	 *
	 * @param samplesbDocumentLibrary the samplesb document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findBySamplesbDocumentLibrary_Last(
			String samplesbDocumentLibrary,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the last sample sb in the ordered set where samplesbDocumentLibrary = &#63;.
	 *
	 * @param samplesbDocumentLibrary the samplesb document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchBySamplesbDocumentLibrary_Last(
		String samplesbDocumentLibrary,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where samplesbDocumentLibrary = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param samplesbDocumentLibrary the samplesb document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public SampleSB[] findBySamplesbDocumentLibrary_PrevAndNext(
			long samplesbId, String samplesbDocumentLibrary,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Removes all the sample sbs where samplesbDocumentLibrary = &#63; from the database.
	 *
	 * @param samplesbDocumentLibrary the samplesb document library
	 */
	public void removeBySamplesbDocumentLibrary(String samplesbDocumentLibrary);

	/**
	 * Returns the number of sample sbs where samplesbDocumentLibrary = &#63;.
	 *
	 * @param samplesbDocumentLibrary the samplesb document library
	 * @return the number of matching sample sbs
	 */
	public int countBySamplesbDocumentLibrary(String samplesbDocumentLibrary);

	/**
	 * Returns all the sample sbs where samplesbDouble = &#63;.
	 *
	 * @param samplesbDouble the samplesb double
	 * @return the matching sample sbs
	 */
	public java.util.List<SampleSB> findBySamplesbDouble(double samplesbDouble);

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
	public java.util.List<SampleSB> findBySamplesbDouble(
		double samplesbDouble, int start, int end);

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
	public java.util.List<SampleSB> findBySamplesbDouble(
		double samplesbDouble, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findBySamplesbDouble(
		double samplesbDouble, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sample sb in the ordered set where samplesbDouble = &#63;.
	 *
	 * @param samplesbDouble the samplesb double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findBySamplesbDouble_First(
			double samplesbDouble,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the first sample sb in the ordered set where samplesbDouble = &#63;.
	 *
	 * @param samplesbDouble the samplesb double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchBySamplesbDouble_First(
		double samplesbDouble,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the last sample sb in the ordered set where samplesbDouble = &#63;.
	 *
	 * @param samplesbDouble the samplesb double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findBySamplesbDouble_Last(
			double samplesbDouble,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the last sample sb in the ordered set where samplesbDouble = &#63;.
	 *
	 * @param samplesbDouble the samplesb double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchBySamplesbDouble_Last(
		double samplesbDouble,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where samplesbDouble = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param samplesbDouble the samplesb double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public SampleSB[] findBySamplesbDouble_PrevAndNext(
			long samplesbId, double samplesbDouble,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Removes all the sample sbs where samplesbDouble = &#63; from the database.
	 *
	 * @param samplesbDouble the samplesb double
	 */
	public void removeBySamplesbDouble(double samplesbDouble);

	/**
	 * Returns the number of sample sbs where samplesbDouble = &#63;.
	 *
	 * @param samplesbDouble the samplesb double
	 * @return the number of matching sample sbs
	 */
	public int countBySamplesbDouble(double samplesbDouble);

	/**
	 * Returns all the sample sbs where samplesbInteger = &#63;.
	 *
	 * @param samplesbInteger the samplesb integer
	 * @return the matching sample sbs
	 */
	public java.util.List<SampleSB> findBySamplesbInteger(int samplesbInteger);

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
	public java.util.List<SampleSB> findBySamplesbInteger(
		int samplesbInteger, int start, int end);

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
	public java.util.List<SampleSB> findBySamplesbInteger(
		int samplesbInteger, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findBySamplesbInteger(
		int samplesbInteger, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sample sb in the ordered set where samplesbInteger = &#63;.
	 *
	 * @param samplesbInteger the samplesb integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findBySamplesbInteger_First(
			int samplesbInteger,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the first sample sb in the ordered set where samplesbInteger = &#63;.
	 *
	 * @param samplesbInteger the samplesb integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchBySamplesbInteger_First(
		int samplesbInteger,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the last sample sb in the ordered set where samplesbInteger = &#63;.
	 *
	 * @param samplesbInteger the samplesb integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findBySamplesbInteger_Last(
			int samplesbInteger,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the last sample sb in the ordered set where samplesbInteger = &#63;.
	 *
	 * @param samplesbInteger the samplesb integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchBySamplesbInteger_Last(
		int samplesbInteger,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where samplesbInteger = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param samplesbInteger the samplesb integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public SampleSB[] findBySamplesbInteger_PrevAndNext(
			long samplesbId, int samplesbInteger,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Removes all the sample sbs where samplesbInteger = &#63; from the database.
	 *
	 * @param samplesbInteger the samplesb integer
	 */
	public void removeBySamplesbInteger(int samplesbInteger);

	/**
	 * Returns the number of sample sbs where samplesbInteger = &#63;.
	 *
	 * @param samplesbInteger the samplesb integer
	 * @return the number of matching sample sbs
	 */
	public int countBySamplesbInteger(int samplesbInteger);

	/**
	 * Returns all the sample sbs where samplesbRichText = &#63;.
	 *
	 * @param samplesbRichText the samplesb rich text
	 * @return the matching sample sbs
	 */
	public java.util.List<SampleSB> findBySamplesbRichText(
		String samplesbRichText);

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
	public java.util.List<SampleSB> findBySamplesbRichText(
		String samplesbRichText, int start, int end);

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
	public java.util.List<SampleSB> findBySamplesbRichText(
		String samplesbRichText, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findBySamplesbRichText(
		String samplesbRichText, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sample sb in the ordered set where samplesbRichText = &#63;.
	 *
	 * @param samplesbRichText the samplesb rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findBySamplesbRichText_First(
			String samplesbRichText,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the first sample sb in the ordered set where samplesbRichText = &#63;.
	 *
	 * @param samplesbRichText the samplesb rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchBySamplesbRichText_First(
		String samplesbRichText,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the last sample sb in the ordered set where samplesbRichText = &#63;.
	 *
	 * @param samplesbRichText the samplesb rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findBySamplesbRichText_Last(
			String samplesbRichText,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the last sample sb in the ordered set where samplesbRichText = &#63;.
	 *
	 * @param samplesbRichText the samplesb rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchBySamplesbRichText_Last(
		String samplesbRichText,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where samplesbRichText = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param samplesbRichText the samplesb rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public SampleSB[] findBySamplesbRichText_PrevAndNext(
			long samplesbId, String samplesbRichText,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Removes all the sample sbs where samplesbRichText = &#63; from the database.
	 *
	 * @param samplesbRichText the samplesb rich text
	 */
	public void removeBySamplesbRichText(String samplesbRichText);

	/**
	 * Returns the number of sample sbs where samplesbRichText = &#63;.
	 *
	 * @param samplesbRichText the samplesb rich text
	 * @return the number of matching sample sbs
	 */
	public int countBySamplesbRichText(String samplesbRichText);

	/**
	 * Returns all the sample sbs where samplesbText = &#63;.
	 *
	 * @param samplesbText the samplesb text
	 * @return the matching sample sbs
	 */
	public java.util.List<SampleSB> findBySamplesbText(String samplesbText);

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
	public java.util.List<SampleSB> findBySamplesbText(
		String samplesbText, int start, int end);

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
	public java.util.List<SampleSB> findBySamplesbText(
		String samplesbText, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findBySamplesbText(
		String samplesbText, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sample sb in the ordered set where samplesbText = &#63;.
	 *
	 * @param samplesbText the samplesb text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findBySamplesbText_First(
			String samplesbText,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the first sample sb in the ordered set where samplesbText = &#63;.
	 *
	 * @param samplesbText the samplesb text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchBySamplesbText_First(
		String samplesbText,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the last sample sb in the ordered set where samplesbText = &#63;.
	 *
	 * @param samplesbText the samplesb text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	public SampleSB findBySamplesbText_Last(
			String samplesbText,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Returns the last sample sb in the ordered set where samplesbText = &#63;.
	 *
	 * @param samplesbText the samplesb text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	public SampleSB fetchBySamplesbText_Last(
		String samplesbText,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

	/**
	 * Returns the sample sbs before and after the current sample sb in the ordered set where samplesbText = &#63;.
	 *
	 * @param samplesbId the primary key of the current sample sb
	 * @param samplesbText the samplesb text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public SampleSB[] findBySamplesbText_PrevAndNext(
			long samplesbId, String samplesbText,
			com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
				orderByComparator)
		throws NoSuchSampleSBException;

	/**
	 * Removes all the sample sbs where samplesbText = &#63; from the database.
	 *
	 * @param samplesbText the samplesb text
	 */
	public void removeBySamplesbText(String samplesbText);

	/**
	 * Returns the number of sample sbs where samplesbText = &#63;.
	 *
	 * @param samplesbText the samplesb text
	 * @return the number of matching sample sbs
	 */
	public int countBySamplesbText(String samplesbText);

	/**
	 * Caches the sample sb in the entity cache if it is enabled.
	 *
	 * @param sampleSB the sample sb
	 */
	public void cacheResult(SampleSB sampleSB);

	/**
	 * Caches the sample sbs in the entity cache if it is enabled.
	 *
	 * @param sampleSBs the sample sbs
	 */
	public void cacheResult(java.util.List<SampleSB> sampleSBs);

	/**
	 * Creates a new sample sb with the primary key. Does not add the sample sb to the database.
	 *
	 * @param samplesbId the primary key for the new sample sb
	 * @return the new sample sb
	 */
	public SampleSB create(long samplesbId);

	/**
	 * Removes the sample sb with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param samplesbId the primary key of the sample sb
	 * @return the sample sb that was removed
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public SampleSB remove(long samplesbId) throws NoSuchSampleSBException;

	public SampleSB updateImpl(SampleSB sampleSB);

	/**
	 * Returns the sample sb with the primary key or throws a <code>NoSuchSampleSBException</code> if it could not be found.
	 *
	 * @param samplesbId the primary key of the sample sb
	 * @return the sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	public SampleSB findByPrimaryKey(long samplesbId)
		throws NoSuchSampleSBException;

	/**
	 * Returns the sample sb with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param samplesbId the primary key of the sample sb
	 * @return the sample sb, or <code>null</code> if a sample sb with the primary key could not be found
	 */
	public SampleSB fetchByPrimaryKey(long samplesbId);

	/**
	 * Returns all the sample sbs.
	 *
	 * @return the sample sbs
	 */
	public java.util.List<SampleSB> findAll();

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
	public java.util.List<SampleSB> findAll(int start, int end);

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
	public java.util.List<SampleSB> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator);

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
	public java.util.List<SampleSB> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleSB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sample sbs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sample sbs.
	 *
	 * @return the number of sample sbs
	 */
	public int countAll();

}