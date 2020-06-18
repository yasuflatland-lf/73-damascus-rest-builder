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

package com.liferay.sb.test.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.sb.test.exception.NoSuchSampleSBException;
import com.liferay.sb.test.model.SampleSB;
import com.liferay.sb.test.model.impl.SampleSBImpl;
import com.liferay.sb.test.model.impl.SampleSBModelImpl;
import com.liferay.sb.test.service.persistence.SampleSBPersistence;
import com.liferay.sb.test.service.persistence.impl.constants.SampleSBPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the sample sb service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author "yasuflatland"
 * @generated
 */
@Component(service = SampleSBPersistence.class)
public class SampleSBPersistenceImpl
	extends BasePersistenceImpl<SampleSB> implements SampleSBPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SampleSBUtil</code> to access the sample sb persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SampleSBImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the sample sbs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sample sbs
	 */
	@Override
	public List<SampleSB> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleSB> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<SampleSB> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if (!uuid.equals(sampleSB.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first sample sb in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findByUuid_First(
			String uuid, OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByUuid_First(uuid, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the first sample sb in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchByUuid_First(
		String uuid, OrderByComparator<SampleSB> orderByComparator) {

		List<SampleSB> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sample sb in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findByUuid_Last(
			String uuid, OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByUuid_Last(uuid, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the last sample sb in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchByUuid_Last(
		String uuid, OrderByComparator<SampleSB> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SampleSB> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB[] findByUuid_PrevAndNext(
			long samplesbId, String uuid,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		uuid = Objects.toString(uuid, "");

		SampleSB sampleSB = findByPrimaryKey(samplesbId);

		Session session = null;

		try {
			session = openSession();

			SampleSB[] array = new SampleSBImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, sampleSB, uuid, orderByComparator, true);

			array[1] = sampleSB;

			array[2] = getByUuid_PrevAndNext(
				session, sampleSB, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleSB getByUuid_PrevAndNext(
		Session session, SampleSB sampleSB, String uuid,
		OrderByComparator<SampleSB> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SAMPLESB_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sampleSB)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleSB> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sample sbs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SampleSB sampleSB :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(sampleSB);
		}
	}

	/**
	 * Returns the number of sample sbs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"sampleSB.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(sampleSB.uuid IS NULL OR sampleSB.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the sample sb where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSampleSBException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findByUUID_G(String uuid, long groupId)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByUUID_G(uuid, groupId);

		if (sampleSB == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSampleSBException(sb.toString());
		}

		return sampleSB;
	}

	/**
	 * Returns the sample sb where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the sample sb where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof SampleSB) {
			SampleSB sampleSB = (SampleSB)result;

			if (!Objects.equals(uuid, sampleSB.getUuid()) ||
				(groupId != sampleSB.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<SampleSB> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					SampleSB sampleSB = list.get(0);

					result = sampleSB;

					cacheResult(sampleSB);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByUUID_G, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (SampleSB)result;
		}
	}

	/**
	 * Removes the sample sb where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the sample sb that was removed
	 */
	@Override
	public SampleSB removeByUUID_G(String uuid, long groupId)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = findByUUID_G(uuid, groupId);

		return remove(sampleSB);
	}

	/**
	 * Returns the number of sample sbs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"sampleSB.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(sampleSB.uuid IS NULL OR sampleSB.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"sampleSB.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the sample sbs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching sample sbs
	 */
	@Override
	public List<SampleSB> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleSB> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<SampleSB> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if (!uuid.equals(sampleSB.getUuid()) ||
						(companyId != sampleSB.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SampleSB findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the first sample sb in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SampleSB> orderByComparator) {

		List<SampleSB> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the last sample sb in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SampleSB> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SampleSB> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB[] findByUuid_C_PrevAndNext(
			long samplesbId, String uuid, long companyId,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		uuid = Objects.toString(uuid, "");

		SampleSB sampleSB = findByPrimaryKey(samplesbId);

		Session session = null;

		try {
			session = openSession();

			SampleSB[] array = new SampleSBImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, sampleSB, uuid, companyId, orderByComparator, true);

			array[1] = sampleSB;

			array[2] = getByUuid_C_PrevAndNext(
				session, sampleSB, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleSB getByUuid_C_PrevAndNext(
		Session session, SampleSB sampleSB, String uuid, long companyId,
		OrderByComparator<SampleSB> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SAMPLESB_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sampleSB)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleSB> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sample sbs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (SampleSB sampleSB :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(sampleSB);
		}
	}

	/**
	 * Returns the number of sample sbs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"sampleSB.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(sampleSB.uuid IS NULL OR sampleSB.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"sampleSB.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByC_S;
	private FinderPath _finderPathWithoutPaginationFindByC_S;
	private FinderPath _finderPathCountByC_S;
	private FinderPath _finderPathWithPaginationCountByC_S;

	/**
	 * Returns all the sample sbs where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching sample sbs
	 */
	@Override
	public List<SampleSB> findByC_S(long companyId, int status) {
		return findByC_S(
			companyId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleSB> findByC_S(
		long companyId, int status, int start, int end) {

		return findByC_S(companyId, status, start, end, null);
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
	@Override
	public List<SampleSB> findByC_S(
		long companyId, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findByC_S(
			companyId, status, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findByC_S(
		long companyId, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_S;
				finderArgs = new Object[] {companyId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_S;
			finderArgs = new Object[] {
				companyId, status, start, end, orderByComparator
			};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if ((companyId != sampleSB.getCompanyId()) ||
						(status != sampleSB.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_C_S_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(status);

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SampleSB findByC_S_First(
			long companyId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByC_S_First(
			companyId, status, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the first sample sb in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchByC_S_First(
		long companyId, int status,
		OrderByComparator<SampleSB> orderByComparator) {

		List<SampleSB> list = findByC_S(
			companyId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB findByC_S_Last(
			long companyId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByC_S_Last(
			companyId, status, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the last sample sb in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchByC_S_Last(
		long companyId, int status,
		OrderByComparator<SampleSB> orderByComparator) {

		int count = countByC_S(companyId, status);

		if (count == 0) {
			return null;
		}

		List<SampleSB> list = findByC_S(
			companyId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB[] findByC_S_PrevAndNext(
			long samplesbId, long companyId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = findByPrimaryKey(samplesbId);

		Session session = null;

		try {
			session = openSession();

			SampleSB[] array = new SampleSBImpl[3];

			array[0] = getByC_S_PrevAndNext(
				session, sampleSB, companyId, status, orderByComparator, true);

			array[1] = sampleSB;

			array[2] = getByC_S_PrevAndNext(
				session, sampleSB, companyId, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleSB getByC_S_PrevAndNext(
		Session session, SampleSB sampleSB, long companyId, int status,
		OrderByComparator<SampleSB> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SAMPLESB_WHERE);

		sb.append(_FINDER_COLUMN_C_S_COMPANYID_2);

		sb.append(_FINDER_COLUMN_C_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sampleSB)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleSB> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	@Override
	public List<SampleSB> findByC_S(long companyId, int[] statuses) {
		return findByC_S(
			companyId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleSB> findByC_S(
		long companyId, int[] statuses, int start, int end) {

		return findByC_S(companyId, statuses, start, end, null);
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
	@Override
	public List<SampleSB> findByC_S(
		long companyId, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findByC_S(
			companyId, statuses, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findByC_S(
		long companyId, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		if (statuses.length == 1) {
			return findByC_S(
				companyId, statuses[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {
					companyId, StringUtil.merge(statuses)
				};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				companyId, StringUtil.merge(statuses), start, end,
				orderByComparator
			};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				_finderPathWithPaginationFindByC_S, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if ((companyId != sampleSB.getCompanyId()) ||
						!ArrayUtil.contains(statuses, sampleSB.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_C_S_COMPANYID_2);

			if (statuses.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_C_S_STATUS_7);

				sb.append(StringUtil.merge(statuses));

				sb.append(")");

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByC_S, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathWithPaginationFindByC_S, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the sample sbs where companyId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 */
	@Override
	public void removeByC_S(long companyId, int status) {
		for (SampleSB sampleSB :
				findByC_S(
					companyId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(sampleSB);
		}
	}

	/**
	 * Returns the number of sample sbs where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countByC_S(long companyId, int status) {
		FinderPath finderPath = _finderPathCountByC_S;

		Object[] finderArgs = new Object[] {companyId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_C_S_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of sample sbs where companyId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param statuses the statuses
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countByC_S(long companyId, int[] statuses) {
		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		Object[] finderArgs = new Object[] {
			companyId, StringUtil.merge(statuses)
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByC_S, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_C_S_COMPANYID_2);

			if (statuses.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_C_S_STATUS_7);

				sb.append(StringUtil.merge(statuses));

				sb.append(")");

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByC_S, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathWithPaginationCountByC_S, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_S_COMPANYID_2 =
		"sampleSB.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_S_STATUS_2 =
		"sampleSB.status = ?";

	private static final String _FINDER_COLUMN_C_S_STATUS_7 =
		"sampleSB.status IN (";

	private FinderPath _finderPathWithPaginationFindByG_S;
	private FinderPath _finderPathWithoutPaginationFindByG_S;
	private FinderPath _finderPathCountByG_S;
	private FinderPath _finderPathWithPaginationCountByG_S;

	/**
	 * Returns all the sample sbs where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching sample sbs
	 */
	@Override
	public List<SampleSB> findByG_S(long groupId, int status) {
		return findByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleSB> findByG_S(
		long groupId, int status, int start, int end) {

		return findByG_S(groupId, status, start, end, null);
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
	@Override
	public List<SampleSB> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findByG_S(groupId, status, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_S;
				finderArgs = new Object[] {groupId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_S;
			finderArgs = new Object[] {
				groupId, status, start, end, orderByComparator
			};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if ((groupId != sampleSB.getGroupId()) ||
						(status != sampleSB.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SampleSB findByG_S_First(
			long groupId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByG_S_First(
			groupId, status, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the first sample sb in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<SampleSB> orderByComparator) {

		List<SampleSB> list = findByG_S(
			groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB findByG_S_Last(
			long groupId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByG_S_Last(groupId, status, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the last sample sb in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<SampleSB> orderByComparator) {

		int count = countByG_S(groupId, status);

		if (count == 0) {
			return null;
		}

		List<SampleSB> list = findByG_S(
			groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB[] findByG_S_PrevAndNext(
			long samplesbId, long groupId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = findByPrimaryKey(samplesbId);

		Session session = null;

		try {
			session = openSession();

			SampleSB[] array = new SampleSBImpl[3];

			array[0] = getByG_S_PrevAndNext(
				session, sampleSB, groupId, status, orderByComparator, true);

			array[1] = sampleSB;

			array[2] = getByG_S_PrevAndNext(
				session, sampleSB, groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleSB getByG_S_PrevAndNext(
		Session session, SampleSB sampleSB, long groupId, int status,
		OrderByComparator<SampleSB> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SAMPLESB_WHERE);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sampleSB)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleSB> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the sample sbs that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching sample sbs that the user has permission to view
	 */
	@Override
	public List<SampleSB> filterFindByG_S(long groupId, int status) {
		return filterFindByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleSB> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return filterFindByG_S(groupId, status, start, end, null);
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
	@Override
	public List<SampleSB> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S(groupId, status, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SampleSB.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, SampleSBImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, SampleSBImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(status);

			return (List<SampleSB>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public SampleSB[] filterFindByG_S_PrevAndNext(
			long samplesbId, long groupId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_PrevAndNext(
				samplesbId, groupId, status, orderByComparator);
		}

		SampleSB sampleSB = findByPrimaryKey(samplesbId);

		Session session = null;

		try {
			session = openSession();

			SampleSB[] array = new SampleSBImpl[3];

			array[0] = filterGetByG_S_PrevAndNext(
				session, sampleSB, groupId, status, orderByComparator, true);

			array[1] = sampleSB;

			array[2] = filterGetByG_S_PrevAndNext(
				session, sampleSB, groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleSB filterGetByG_S_PrevAndNext(
		Session session, SampleSB sampleSB, long groupId, int status,
		OrderByComparator<SampleSB> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SampleSB.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, SampleSBImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, SampleSBImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sampleSB)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleSB> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the sample sbs that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the matching sample sbs that the user has permission to view
	 */
	@Override
	public List<SampleSB> filterFindByG_S(long groupId, int[] statuses) {
		return filterFindByG_S(
			groupId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleSB> filterFindByG_S(
		long groupId, int[] statuses, int start, int end) {

		return filterFindByG_S(groupId, statuses, start, end, null);
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
	@Override
	public List<SampleSB> filterFindByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S(groupId, statuses, start, end, orderByComparator);
		}

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		StringBundler sb = new StringBundler();

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		if (statuses.length > 0) {
			sb.append("(");

			sb.append(_FINDER_COLUMN_G_S_STATUS_7);

			sb.append(StringUtil.merge(statuses));

			sb.append(")");

			sb.append(")");
		}

		sb.setStringAt(
			removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SampleSB.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, SampleSBImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, SampleSBImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			return (List<SampleSB>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public List<SampleSB> findByG_S(long groupId, int[] statuses) {
		return findByG_S(
			groupId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleSB> findByG_S(
		long groupId, int[] statuses, int start, int end) {

		return findByG_S(groupId, statuses, start, end, null);
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
	@Override
	public List<SampleSB> findByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findByG_S(
			groupId, statuses, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findByG_S(
		long groupId, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		if (statuses.length == 1) {
			return findByG_S(
				groupId, statuses[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {groupId, StringUtil.merge(statuses)};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				groupId, StringUtil.merge(statuses), start, end,
				orderByComparator
			};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				_finderPathWithPaginationFindByG_S, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if ((groupId != sampleSB.getGroupId()) ||
						!ArrayUtil.contains(statuses, sampleSB.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			if (statuses.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_G_S_STATUS_7);

				sb.append(StringUtil.merge(statuses));

				sb.append(")");

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByG_S, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathWithPaginationFindByG_S, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the sample sbs where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeByG_S(long groupId, int status) {
		for (SampleSB sampleSB :
				findByG_S(
					groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(sampleSB);
		}
	}

	/**
	 * Returns the number of sample sbs where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countByG_S(long groupId, int status) {
		FinderPath finderPath = _finderPathCountByG_S;

		Object[] finderArgs = new Object[] {groupId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of sample sbs where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countByG_S(long groupId, int[] statuses) {
		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		Object[] finderArgs = new Object[] {
			groupId, StringUtil.merge(statuses)
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByG_S, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			if (statuses.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_G_S_STATUS_7);

				sb.append(StringUtil.merge(statuses));

				sb.append(")");

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByG_S, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathWithPaginationCountByG_S, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of sample sbs that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching sample sbs that the user has permission to view
	 */
	@Override
	public int filterCountByG_S(long groupId, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S(groupId, status);
		}

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_SAMPLESB_WHERE);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SampleSB.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(status);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of sample sbs that the user has permission to view where groupId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param statuses the statuses
	 * @return the number of matching sample sbs that the user has permission to view
	 */
	@Override
	public int filterCountByG_S(long groupId, int[] statuses) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S(groupId, statuses);
		}

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		StringBundler sb = new StringBundler();

		sb.append(_FILTER_SQL_COUNT_SAMPLESB_WHERE);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		if (statuses.length > 0) {
			sb.append("(");

			sb.append(_FINDER_COLUMN_G_S_STATUS_7);

			sb.append(StringUtil.merge(statuses));

			sb.append(")");

			sb.append(")");
		}

		sb.setStringAt(
			removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SampleSB.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 =
		"sampleSB.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_STATUS_2 =
		"sampleSB.status = ?";

	private static final String _FINDER_COLUMN_G_S_STATUS_7 =
		"sampleSB.status IN (";

	private FinderPath _finderPathWithPaginationFindByC_U_S;
	private FinderPath _finderPathWithoutPaginationFindByC_U_S;
	private FinderPath _finderPathCountByC_U_S;
	private FinderPath _finderPathWithPaginationCountByC_U_S;

	/**
	 * Returns all the sample sbs where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching sample sbs
	 */
	@Override
	public List<SampleSB> findByC_U_S(long companyId, long userId, int status) {
		return findByC_U_S(
			companyId, userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<SampleSB> findByC_U_S(
		long companyId, long userId, int status, int start, int end) {

		return findByC_U_S(companyId, userId, status, start, end, null);
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
	@Override
	public List<SampleSB> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findByC_U_S(
			companyId, userId, status, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_U_S;
				finderArgs = new Object[] {companyId, userId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_U_S;
			finderArgs = new Object[] {
				companyId, userId, status, start, end, orderByComparator
			};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if ((companyId != sampleSB.getCompanyId()) ||
						(userId != sampleSB.getUserId()) ||
						(status != sampleSB.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_C_U_S_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_C_U_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(userId);

				queryPos.add(status);

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SampleSB findByC_U_S_First(
			long companyId, long userId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByC_U_S_First(
			companyId, userId, status, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
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
	@Override
	public SampleSB fetchByC_U_S_First(
		long companyId, long userId, int status,
		OrderByComparator<SampleSB> orderByComparator) {

		List<SampleSB> list = findByC_U_S(
			companyId, userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB findByC_U_S_Last(
			long companyId, long userId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByC_U_S_Last(
			companyId, userId, status, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
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
	@Override
	public SampleSB fetchByC_U_S_Last(
		long companyId, long userId, int status,
		OrderByComparator<SampleSB> orderByComparator) {

		int count = countByC_U_S(companyId, userId, status);

		if (count == 0) {
			return null;
		}

		List<SampleSB> list = findByC_U_S(
			companyId, userId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB[] findByC_U_S_PrevAndNext(
			long samplesbId, long companyId, long userId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = findByPrimaryKey(samplesbId);

		Session session = null;

		try {
			session = openSession();

			SampleSB[] array = new SampleSBImpl[3];

			array[0] = getByC_U_S_PrevAndNext(
				session, sampleSB, companyId, userId, status, orderByComparator,
				true);

			array[1] = sampleSB;

			array[2] = getByC_U_S_PrevAndNext(
				session, sampleSB, companyId, userId, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleSB getByC_U_S_PrevAndNext(
		Session session, SampleSB sampleSB, long companyId, long userId,
		int status, OrderByComparator<SampleSB> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_SAMPLESB_WHERE);

		sb.append(_FINDER_COLUMN_C_U_S_COMPANYID_2);

		sb.append(_FINDER_COLUMN_C_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_C_U_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		queryPos.add(userId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sampleSB)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleSB> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	@Override
	public List<SampleSB> findByC_U_S(
		long companyId, long userId, int[] statuses) {

		return findByC_U_S(
			companyId, userId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<SampleSB> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end) {

		return findByC_U_S(companyId, userId, statuses, start, end, null);
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
	@Override
	public List<SampleSB> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findByC_U_S(
			companyId, userId, statuses, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findByC_U_S(
		long companyId, long userId, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		if (statuses.length == 1) {
			return findByC_U_S(
				companyId, userId, statuses[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {
					companyId, userId, StringUtil.merge(statuses)
				};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				companyId, userId, StringUtil.merge(statuses), start, end,
				orderByComparator
			};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				_finderPathWithPaginationFindByC_U_S, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if ((companyId != sampleSB.getCompanyId()) ||
						(userId != sampleSB.getUserId()) ||
						!ArrayUtil.contains(statuses, sampleSB.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_C_U_S_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_U_S_USERID_2);

			if (statuses.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_C_U_S_STATUS_7);

				sb.append(StringUtil.merge(statuses));

				sb.append(")");

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(userId);

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByC_U_S, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathWithPaginationFindByC_U_S, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the sample sbs where companyId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 */
	@Override
	public void removeByC_U_S(long companyId, long userId, int status) {
		for (SampleSB sampleSB :
				findByC_U_S(
					companyId, userId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(sampleSB);
		}
	}

	/**
	 * Returns the number of sample sbs where companyId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countByC_U_S(long companyId, long userId, int status) {
		FinderPath finderPath = _finderPathCountByC_U_S;

		Object[] finderArgs = new Object[] {companyId, userId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_C_U_S_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_C_U_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(userId);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of sample sbs where companyId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countByC_U_S(long companyId, long userId, int[] statuses) {
		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		Object[] finderArgs = new Object[] {
			companyId, userId, StringUtil.merge(statuses)
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByC_U_S, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_C_U_S_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_U_S_USERID_2);

			if (statuses.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_C_U_S_STATUS_7);

				sb.append(StringUtil.merge(statuses));

				sb.append(")");

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByC_U_S, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathWithPaginationCountByC_U_S, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_U_S_COMPANYID_2 =
		"sampleSB.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_U_S_USERID_2 =
		"sampleSB.userId = ? AND ";

	private static final String _FINDER_COLUMN_C_U_S_STATUS_2 =
		"sampleSB.status = ?";

	private static final String _FINDER_COLUMN_C_U_S_STATUS_7 =
		"sampleSB.status IN (";

	private FinderPath _finderPathWithPaginationFindByG_U_S;
	private FinderPath _finderPathWithoutPaginationFindByG_U_S;
	private FinderPath _finderPathCountByG_U_S;
	private FinderPath _finderPathWithPaginationCountByG_U_S;

	/**
	 * Returns all the sample sbs where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching sample sbs
	 */
	@Override
	public List<SampleSB> findByG_U_S(long groupId, long userId, int status) {
		return findByG_U_S(
			groupId, userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<SampleSB> findByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return findByG_U_S(groupId, userId, status, start, end, null);
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
	@Override
	public List<SampleSB> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findByG_U_S(
			groupId, userId, status, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_U_S;
				finderArgs = new Object[] {groupId, userId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_U_S;
			finderArgs = new Object[] {
				groupId, userId, status, start, end, orderByComparator
			};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if ((groupId != sampleSB.getGroupId()) ||
						(userId != sampleSB.getUserId()) ||
						(status != sampleSB.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				queryPos.add(status);

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SampleSB findByG_U_S_First(
			long groupId, long userId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByG_U_S_First(
			groupId, userId, status, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
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
	@Override
	public SampleSB fetchByG_U_S_First(
		long groupId, long userId, int status,
		OrderByComparator<SampleSB> orderByComparator) {

		List<SampleSB> list = findByG_U_S(
			groupId, userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB findByG_U_S_Last(
			long groupId, long userId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByG_U_S_Last(
			groupId, userId, status, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
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
	@Override
	public SampleSB fetchByG_U_S_Last(
		long groupId, long userId, int status,
		OrderByComparator<SampleSB> orderByComparator) {

		int count = countByG_U_S(groupId, userId, status);

		if (count == 0) {
			return null;
		}

		List<SampleSB> list = findByG_U_S(
			groupId, userId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB[] findByG_U_S_PrevAndNext(
			long samplesbId, long groupId, long userId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = findByPrimaryKey(samplesbId);

		Session session = null;

		try {
			session = openSession();

			SampleSB[] array = new SampleSBImpl[3];

			array[0] = getByG_U_S_PrevAndNext(
				session, sampleSB, groupId, userId, status, orderByComparator,
				true);

			array[1] = sampleSB;

			array[2] = getByG_U_S_PrevAndNext(
				session, sampleSB, groupId, userId, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleSB getByG_U_S_PrevAndNext(
		Session session, SampleSB sampleSB, long groupId, long userId,
		int status, OrderByComparator<SampleSB> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_SAMPLESB_WHERE);

		sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(userId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sampleSB)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleSB> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the sample sbs that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching sample sbs that the user has permission to view
	 */
	@Override
	public List<SampleSB> filterFindByG_U_S(
		long groupId, long userId, int status) {

		return filterFindByG_U_S(
			groupId, userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<SampleSB> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return filterFindByG_U_S(groupId, userId, status, start, end, null);
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
	@Override
	public List<SampleSB> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_U_S(
				groupId, userId, status, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SampleSB.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, SampleSBImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, SampleSBImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(userId);

			queryPos.add(status);

			return (List<SampleSB>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public SampleSB[] filterFindByG_U_S_PrevAndNext(
			long samplesbId, long groupId, long userId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_U_S_PrevAndNext(
				samplesbId, groupId, userId, status, orderByComparator);
		}

		SampleSB sampleSB = findByPrimaryKey(samplesbId);

		Session session = null;

		try {
			session = openSession();

			SampleSB[] array = new SampleSBImpl[3];

			array[0] = filterGetByG_U_S_PrevAndNext(
				session, sampleSB, groupId, userId, status, orderByComparator,
				true);

			array[1] = sampleSB;

			array[2] = filterGetByG_U_S_PrevAndNext(
				session, sampleSB, groupId, userId, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleSB filterGetByG_U_S_PrevAndNext(
		Session session, SampleSB sampleSB, long groupId, long userId,
		int status, OrderByComparator<SampleSB> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SampleSB.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, SampleSBImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, SampleSBImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(userId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sampleSB)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleSB> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the sample sbs that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the matching sample sbs that the user has permission to view
	 */
	@Override
	public List<SampleSB> filterFindByG_U_S(
		long groupId, long userId, int[] statuses) {

		return filterFindByG_U_S(
			groupId, userId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<SampleSB> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end) {

		return filterFindByG_U_S(groupId, userId, statuses, start, end, null);
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
	@Override
	public List<SampleSB> filterFindByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_U_S(
				groupId, userId, statuses, start, end, orderByComparator);
		}

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		StringBundler sb = new StringBundler();

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

		if (statuses.length > 0) {
			sb.append("(");

			sb.append(_FINDER_COLUMN_G_U_S_STATUS_7);

			sb.append(StringUtil.merge(statuses));

			sb.append(")");

			sb.append(")");
		}

		sb.setStringAt(
			removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SampleSB.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, SampleSBImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, SampleSBImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(userId);

			return (List<SampleSB>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public List<SampleSB> findByG_U_S(
		long groupId, long userId, int[] statuses) {

		return findByG_U_S(
			groupId, userId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<SampleSB> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end) {

		return findByG_U_S(groupId, userId, statuses, start, end, null);
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
	@Override
	public List<SampleSB> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findByG_U_S(
			groupId, userId, statuses, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findByG_U_S(
		long groupId, long userId, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		if (statuses.length == 1) {
			return findByG_U_S(
				groupId, userId, statuses[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {
					groupId, userId, StringUtil.merge(statuses)
				};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				groupId, userId, StringUtil.merge(statuses), start, end,
				orderByComparator
			};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				_finderPathWithPaginationFindByG_U_S, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if ((groupId != sampleSB.getGroupId()) ||
						(userId != sampleSB.getUserId()) ||
						!ArrayUtil.contains(statuses, sampleSB.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

			if (statuses.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_G_U_S_STATUS_7);

				sb.append(StringUtil.merge(statuses));

				sb.append(")");

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByG_U_S, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathWithPaginationFindByG_U_S, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the sample sbs where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	@Override
	public void removeByG_U_S(long groupId, long userId, int status) {
		for (SampleSB sampleSB :
				findByG_U_S(
					groupId, userId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(sampleSB);
		}
	}

	/**
	 * Returns the number of sample sbs where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countByG_U_S(long groupId, long userId, int status) {
		FinderPath finderPath = _finderPathCountByG_U_S;

		Object[] finderArgs = new Object[] {groupId, userId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of sample sbs where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countByG_U_S(long groupId, long userId, int[] statuses) {
		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		Object[] finderArgs = new Object[] {
			groupId, userId, StringUtil.merge(statuses)
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByG_U_S, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

			if (statuses.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_G_U_S_STATUS_7);

				sb.append(StringUtil.merge(statuses));

				sb.append(")");

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByG_U_S, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathWithPaginationCountByG_U_S, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of sample sbs that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching sample sbs that the user has permission to view
	 */
	@Override
	public int filterCountByG_U_S(long groupId, long userId, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_U_S(groupId, userId, status);
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_FILTER_SQL_COUNT_SAMPLESB_WHERE);

		sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SampleSB.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(userId);

			queryPos.add(status);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of sample sbs that the user has permission to view where groupId = &#63; and userId = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching sample sbs that the user has permission to view
	 */
	@Override
	public int filterCountByG_U_S(long groupId, long userId, int[] statuses) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_U_S(groupId, userId, statuses);
		}

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		StringBundler sb = new StringBundler();

		sb.append(_FILTER_SQL_COUNT_SAMPLESB_WHERE);

		sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

		if (statuses.length > 0) {
			sb.append("(");

			sb.append(_FINDER_COLUMN_G_U_S_STATUS_7);

			sb.append(StringUtil.merge(statuses));

			sb.append(")");

			sb.append(")");
		}

		sb.setStringAt(
			removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SampleSB.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(userId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_U_S_GROUPID_2 =
		"sampleSB.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_U_S_USERID_2 =
		"sampleSB.userId = ? AND ";

	private static final String _FINDER_COLUMN_G_U_S_STATUS_2 =
		"sampleSB.status = ?";

	private static final String _FINDER_COLUMN_G_U_S_STATUS_7 =
		"sampleSB.status IN (";

	private FinderPath _finderPathWithPaginationFindByU_S;
	private FinderPath _finderPathWithoutPaginationFindByU_S;
	private FinderPath _finderPathCountByU_S;
	private FinderPath _finderPathWithPaginationCountByU_S;

	/**
	 * Returns all the sample sbs where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching sample sbs
	 */
	@Override
	public List<SampleSB> findByU_S(long userId, int status) {
		return findByU_S(
			userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleSB> findByU_S(
		long userId, int status, int start, int end) {

		return findByU_S(userId, status, start, end, null);
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
	@Override
	public List<SampleSB> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findByU_S(userId, status, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByU_S;
				finderArgs = new Object[] {userId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByU_S;
			finderArgs = new Object[] {
				userId, status, start, end, orderByComparator
			};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if ((userId != sampleSB.getUserId()) ||
						(status != sampleSB.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_U_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(status);

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SampleSB findByU_S_First(
			long userId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByU_S_First(userId, status, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the first sample sb in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchByU_S_First(
		long userId, int status,
		OrderByComparator<SampleSB> orderByComparator) {

		List<SampleSB> list = findByU_S(
			userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB findByU_S_Last(
			long userId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByU_S_Last(userId, status, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the last sample sb in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchByU_S_Last(
		long userId, int status,
		OrderByComparator<SampleSB> orderByComparator) {

		int count = countByU_S(userId, status);

		if (count == 0) {
			return null;
		}

		List<SampleSB> list = findByU_S(
			userId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB[] findByU_S_PrevAndNext(
			long samplesbId, long userId, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = findByPrimaryKey(samplesbId);

		Session session = null;

		try {
			session = openSession();

			SampleSB[] array = new SampleSBImpl[3];

			array[0] = getByU_S_PrevAndNext(
				session, sampleSB, userId, status, orderByComparator, true);

			array[1] = sampleSB;

			array[2] = getByU_S_PrevAndNext(
				session, sampleSB, userId, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleSB getByU_S_PrevAndNext(
		Session session, SampleSB sampleSB, long userId, int status,
		OrderByComparator<SampleSB> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SAMPLESB_WHERE);

		sb.append(_FINDER_COLUMN_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_U_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sampleSB)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleSB> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	@Override
	public List<SampleSB> findByU_S(long userId, int[] statuses) {
		return findByU_S(
			userId, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleSB> findByU_S(
		long userId, int[] statuses, int start, int end) {

		return findByU_S(userId, statuses, start, end, null);
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
	@Override
	public List<SampleSB> findByU_S(
		long userId, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findByU_S(userId, statuses, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findByU_S(
		long userId, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		if (statuses.length == 1) {
			return findByU_S(
				userId, statuses[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {userId, StringUtil.merge(statuses)};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				userId, StringUtil.merge(statuses), start, end,
				orderByComparator
			};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				_finderPathWithPaginationFindByU_S, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if ((userId != sampleSB.getUserId()) ||
						!ArrayUtil.contains(statuses, sampleSB.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_U_S_USERID_2);

			if (statuses.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_U_S_STATUS_7);

				sb.append(StringUtil.merge(statuses));

				sb.append(")");

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByU_S, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathWithPaginationFindByU_S, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the sample sbs where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	@Override
	public void removeByU_S(long userId, int status) {
		for (SampleSB sampleSB :
				findByU_S(
					userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(sampleSB);
		}
	}

	/**
	 * Returns the number of sample sbs where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countByU_S(long userId, int status) {
		FinderPath finderPath = _finderPathCountByU_S;

		Object[] finderArgs = new Object[] {userId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_U_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of sample sbs where userId = &#63; and status = any &#63;.
	 *
	 * @param userId the user ID
	 * @param statuses the statuses
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countByU_S(long userId, int[] statuses) {
		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		Object[] finderArgs = new Object[] {userId, StringUtil.merge(statuses)};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByU_S, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_U_S_USERID_2);

			if (statuses.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_U_S_STATUS_7);

				sb.append(StringUtil.merge(statuses));

				sb.append(")");

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByU_S, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathWithPaginationCountByU_S, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_U_S_USERID_2 =
		"sampleSB.userId = ? AND ";

	private static final String _FINDER_COLUMN_U_S_STATUS_2 =
		"sampleSB.status = ?";

	private static final String _FINDER_COLUMN_U_S_STATUS_7 =
		"sampleSB.status IN (";

	private FinderPath _finderPathWithPaginationFindByG_UT_ST;
	private FinderPath _finderPathWithoutPaginationFindByG_UT_ST;
	private FinderPath _finderPathCountByG_UT_ST;
	private FinderPath _finderPathWithPaginationCountByG_UT_ST;

	/**
	 * Returns all the sample sbs where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching sample sbs
	 */
	@Override
	public List<SampleSB> findByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return findByG_UT_ST(
			groupId, urlTitle, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<SampleSB> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end) {

		return findByG_UT_ST(groupId, urlTitle, status, start, end, null);
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
	@Override
	public List<SampleSB> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findByG_UT_ST(
			groupId, urlTitle, status, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		urlTitle = Objects.toString(urlTitle, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_UT_ST;
				finderArgs = new Object[] {groupId, urlTitle, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_UT_ST;
			finderArgs = new Object[] {
				groupId, urlTitle, status, start, end, orderByComparator
			};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if ((groupId != sampleSB.getGroupId()) ||
						!urlTitle.equals(sampleSB.getUrlTitle()) ||
						(status != sampleSB.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

			boolean bindUrlTitle = false;

			if (urlTitle.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
			}

			sb.append(_FINDER_COLUMN_G_UT_ST_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindUrlTitle) {
					queryPos.add(urlTitle);
				}

				queryPos.add(status);

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SampleSB findByG_UT_ST_First(
			long groupId, String urlTitle, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByG_UT_ST_First(
			groupId, urlTitle, status, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", urlTitle=");
		sb.append(urlTitle);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
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
	@Override
	public SampleSB fetchByG_UT_ST_First(
		long groupId, String urlTitle, int status,
		OrderByComparator<SampleSB> orderByComparator) {

		List<SampleSB> list = findByG_UT_ST(
			groupId, urlTitle, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB findByG_UT_ST_Last(
			long groupId, String urlTitle, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByG_UT_ST_Last(
			groupId, urlTitle, status, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", urlTitle=");
		sb.append(urlTitle);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
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
	@Override
	public SampleSB fetchByG_UT_ST_Last(
		long groupId, String urlTitle, int status,
		OrderByComparator<SampleSB> orderByComparator) {

		int count = countByG_UT_ST(groupId, urlTitle, status);

		if (count == 0) {
			return null;
		}

		List<SampleSB> list = findByG_UT_ST(
			groupId, urlTitle, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB[] findByG_UT_ST_PrevAndNext(
			long samplesbId, long groupId, String urlTitle, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		urlTitle = Objects.toString(urlTitle, "");

		SampleSB sampleSB = findByPrimaryKey(samplesbId);

		Session session = null;

		try {
			session = openSession();

			SampleSB[] array = new SampleSBImpl[3];

			array[0] = getByG_UT_ST_PrevAndNext(
				session, sampleSB, groupId, urlTitle, status, orderByComparator,
				true);

			array[1] = sampleSB;

			array[2] = getByG_UT_ST_PrevAndNext(
				session, sampleSB, groupId, urlTitle, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleSB getByG_UT_ST_PrevAndNext(
		Session session, SampleSB sampleSB, long groupId, String urlTitle,
		int status, OrderByComparator<SampleSB> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_SAMPLESB_WHERE);

		sb.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

		boolean bindUrlTitle = false;

		if (urlTitle.isEmpty()) {
			sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
		}
		else {
			bindUrlTitle = true;

			sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
		}

		sb.append(_FINDER_COLUMN_G_UT_ST_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (bindUrlTitle) {
			queryPos.add(urlTitle);
		}

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sampleSB)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleSB> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the sample sbs that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the matching sample sbs that the user has permission to view
	 */
	@Override
	public List<SampleSB> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status) {

		return filterFindByG_UT_ST(
			groupId, urlTitle, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<SampleSB> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end) {

		return filterFindByG_UT_ST(groupId, urlTitle, status, start, end, null);
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
	@Override
	public List<SampleSB> filterFindByG_UT_ST(
		long groupId, String urlTitle, int status, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_UT_ST(
				groupId, urlTitle, status, start, end, orderByComparator);
		}

		urlTitle = Objects.toString(urlTitle, "");

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

		boolean bindUrlTitle = false;

		if (urlTitle.isEmpty()) {
			sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
		}
		else {
			bindUrlTitle = true;

			sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
		}

		sb.append(_FINDER_COLUMN_G_UT_ST_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SampleSB.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, SampleSBImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, SampleSBImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			if (bindUrlTitle) {
				queryPos.add(urlTitle);
			}

			queryPos.add(status);

			return (List<SampleSB>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public SampleSB[] filterFindByG_UT_ST_PrevAndNext(
			long samplesbId, long groupId, String urlTitle, int status,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_UT_ST_PrevAndNext(
				samplesbId, groupId, urlTitle, status, orderByComparator);
		}

		urlTitle = Objects.toString(urlTitle, "");

		SampleSB sampleSB = findByPrimaryKey(samplesbId);

		Session session = null;

		try {
			session = openSession();

			SampleSB[] array = new SampleSBImpl[3];

			array[0] = filterGetByG_UT_ST_PrevAndNext(
				session, sampleSB, groupId, urlTitle, status, orderByComparator,
				true);

			array[1] = sampleSB;

			array[2] = filterGetByG_UT_ST_PrevAndNext(
				session, sampleSB, groupId, urlTitle, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleSB filterGetByG_UT_ST_PrevAndNext(
		Session session, SampleSB sampleSB, long groupId, String urlTitle,
		int status, OrderByComparator<SampleSB> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

		boolean bindUrlTitle = false;

		if (urlTitle.isEmpty()) {
			sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
		}
		else {
			bindUrlTitle = true;

			sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
		}

		sb.append(_FINDER_COLUMN_G_UT_ST_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SampleSB.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, SampleSBImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, SampleSBImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (bindUrlTitle) {
			queryPos.add(urlTitle);
		}

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sampleSB)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleSB> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the sample sbs that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the matching sample sbs that the user has permission to view
	 */
	@Override
	public List<SampleSB> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return filterFindByG_UT_ST(
			groupId, urlTitle, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<SampleSB> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end) {

		return filterFindByG_UT_ST(
			groupId, urlTitle, statuses, start, end, null);
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
	@Override
	public List<SampleSB> filterFindByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_UT_ST(
				groupId, urlTitle, statuses, start, end, orderByComparator);
		}

		urlTitle = Objects.toString(urlTitle, "");

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		StringBundler sb = new StringBundler();

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

		boolean bindUrlTitle = false;

		if (urlTitle.isEmpty()) {
			sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
		}
		else {
			bindUrlTitle = true;

			sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
		}

		if (statuses.length > 0) {
			sb.append("(");

			sb.append(_FINDER_COLUMN_G_UT_ST_STATUS_7);

			sb.append(StringUtil.merge(statuses));

			sb.append(")");

			sb.append(")");
		}

		sb.setStringAt(
			removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SampleSB.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, SampleSBImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, SampleSBImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			if (bindUrlTitle) {
				queryPos.add(urlTitle);
			}

			return (List<SampleSB>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public List<SampleSB> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		return findByG_UT_ST(
			groupId, urlTitle, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<SampleSB> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end) {

		return findByG_UT_ST(groupId, urlTitle, statuses, start, end, null);
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
	@Override
	public List<SampleSB> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findByG_UT_ST(
			groupId, urlTitle, statuses, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findByG_UT_ST(
		long groupId, String urlTitle, int[] statuses, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		urlTitle = Objects.toString(urlTitle, "");

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		if (statuses.length == 1) {
			return findByG_UT_ST(
				groupId, urlTitle, statuses[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {
					groupId, urlTitle, StringUtil.merge(statuses)
				};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				groupId, urlTitle, StringUtil.merge(statuses), start, end,
				orderByComparator
			};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				_finderPathWithPaginationFindByG_UT_ST, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if ((groupId != sampleSB.getGroupId()) ||
						!urlTitle.equals(sampleSB.getUrlTitle()) ||
						!ArrayUtil.contains(statuses, sampleSB.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

			boolean bindUrlTitle = false;

			if (urlTitle.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
			}

			if (statuses.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_G_UT_ST_STATUS_7);

				sb.append(StringUtil.merge(statuses));

				sb.append(")");

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindUrlTitle) {
					queryPos.add(urlTitle);
				}

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByG_UT_ST, finderArgs,
						list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathWithPaginationFindByG_UT_ST, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the sample sbs where groupId = &#63; and urlTitle = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 */
	@Override
	public void removeByG_UT_ST(long groupId, String urlTitle, int status) {
		for (SampleSB sampleSB :
				findByG_UT_ST(
					groupId, urlTitle, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(sampleSB);
		}
	}

	/**
	 * Returns the number of sample sbs where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countByG_UT_ST(long groupId, String urlTitle, int status) {
		urlTitle = Objects.toString(urlTitle, "");

		FinderPath finderPath = _finderPathCountByG_UT_ST;

		Object[] finderArgs = new Object[] {groupId, urlTitle, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

			boolean bindUrlTitle = false;

			if (urlTitle.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
			}

			sb.append(_FINDER_COLUMN_G_UT_ST_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindUrlTitle) {
					queryPos.add(urlTitle);
				}

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of sample sbs where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countByG_UT_ST(long groupId, String urlTitle, int[] statuses) {
		urlTitle = Objects.toString(urlTitle, "");

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		Object[] finderArgs = new Object[] {
			groupId, urlTitle, StringUtil.merge(statuses)
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByG_UT_ST, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

			boolean bindUrlTitle = false;

			if (urlTitle.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
			}

			if (statuses.length > 0) {
				sb.append("(");

				sb.append(_FINDER_COLUMN_G_UT_ST_STATUS_7);

				sb.append(StringUtil.merge(statuses));

				sb.append(")");

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindUrlTitle) {
					queryPos.add(urlTitle);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByG_UT_ST, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathWithPaginationCountByG_UT_ST, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of sample sbs that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param status the status
	 * @return the number of matching sample sbs that the user has permission to view
	 */
	@Override
	public int filterCountByG_UT_ST(long groupId, String urlTitle, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_UT_ST(groupId, urlTitle, status);
		}

		urlTitle = Objects.toString(urlTitle, "");

		StringBundler sb = new StringBundler(4);

		sb.append(_FILTER_SQL_COUNT_SAMPLESB_WHERE);

		sb.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

		boolean bindUrlTitle = false;

		if (urlTitle.isEmpty()) {
			sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
		}
		else {
			bindUrlTitle = true;

			sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
		}

		sb.append(_FINDER_COLUMN_G_UT_ST_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SampleSB.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			if (bindUrlTitle) {
				queryPos.add(urlTitle);
			}

			queryPos.add(status);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of sample sbs that the user has permission to view where groupId = &#63; and urlTitle = &#63; and status = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param statuses the statuses
	 * @return the number of matching sample sbs that the user has permission to view
	 */
	@Override
	public int filterCountByG_UT_ST(
		long groupId, String urlTitle, int[] statuses) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_UT_ST(groupId, urlTitle, statuses);
		}

		urlTitle = Objects.toString(urlTitle, "");

		if (statuses == null) {
			statuses = new int[0];
		}
		else if (statuses.length > 1) {
			statuses = ArrayUtil.sortedUnique(statuses);
		}

		StringBundler sb = new StringBundler();

		sb.append(_FILTER_SQL_COUNT_SAMPLESB_WHERE);

		sb.append(_FINDER_COLUMN_G_UT_ST_GROUPID_2);

		boolean bindUrlTitle = false;

		if (urlTitle.isEmpty()) {
			sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_3);
		}
		else {
			bindUrlTitle = true;

			sb.append(_FINDER_COLUMN_G_UT_ST_URLTITLE_2);
		}

		if (statuses.length > 0) {
			sb.append("(");

			sb.append(_FINDER_COLUMN_G_UT_ST_STATUS_7);

			sb.append(StringUtil.merge(statuses));

			sb.append(")");

			sb.append(")");
		}

		sb.setStringAt(
			removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SampleSB.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			if (bindUrlTitle) {
				queryPos.add(urlTitle);
			}

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_UT_ST_GROUPID_2 =
		"sampleSB.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_UT_ST_URLTITLE_2 =
		"sampleSB.urlTitle = ? AND ";

	private static final String _FINDER_COLUMN_G_UT_ST_URLTITLE_3 =
		"(sampleSB.urlTitle IS NULL OR sampleSB.urlTitle = '') AND ";

	private static final String _FINDER_COLUMN_G_UT_ST_STATUS_2 =
		"sampleSB.status = ?";

	private static final String _FINDER_COLUMN_G_UT_ST_STATUS_7 =
		"sampleSB.status IN (";

	private FinderPath _finderPathFetchByG_UT;
	private FinderPath _finderPathCountByG_UT;

	/**
	 * Returns the sample sb where groupId = &#63; and urlTitle = &#63; or throws a <code>NoSuchSampleSBException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findByG_UT(long groupId, String urlTitle)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByG_UT(groupId, urlTitle);

		if (sampleSB == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("groupId=");
			sb.append(groupId);

			sb.append(", urlTitle=");
			sb.append(urlTitle);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSampleSBException(sb.toString());
		}

		return sampleSB;
	}

	/**
	 * Returns the sample sb where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchByG_UT(long groupId, String urlTitle) {
		return fetchByG_UT(groupId, urlTitle, true);
	}

	/**
	 * Returns the sample sb where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchByG_UT(
		long groupId, String urlTitle, boolean useFinderCache) {

		urlTitle = Objects.toString(urlTitle, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupId, urlTitle};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByG_UT, finderArgs, this);
		}

		if (result instanceof SampleSB) {
			SampleSB sampleSB = (SampleSB)result;

			if ((groupId != sampleSB.getGroupId()) ||
				!Objects.equals(urlTitle, sampleSB.getUrlTitle())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_G_UT_GROUPID_2);

			boolean bindUrlTitle = false;

			if (urlTitle.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_UT_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				sb.append(_FINDER_COLUMN_G_UT_URLTITLE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindUrlTitle) {
					queryPos.add(urlTitle);
				}

				List<SampleSB> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByG_UT, finderArgs, list);
					}
				}
				else {
					SampleSB sampleSB = list.get(0);

					result = sampleSB;

					cacheResult(sampleSB);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByG_UT, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (SampleSB)result;
		}
	}

	/**
	 * Removes the sample sb where groupId = &#63; and urlTitle = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the sample sb that was removed
	 */
	@Override
	public SampleSB removeByG_UT(long groupId, String urlTitle)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = findByG_UT(groupId, urlTitle);

		return remove(sampleSB);
	}

	/**
	 * Returns the number of sample sbs where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countByG_UT(long groupId, String urlTitle) {
		urlTitle = Objects.toString(urlTitle, "");

		FinderPath finderPath = _finderPathCountByG_UT;

		Object[] finderArgs = new Object[] {groupId, urlTitle};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_G_UT_GROUPID_2);

			boolean bindUrlTitle = false;

			if (urlTitle.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_UT_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				sb.append(_FINDER_COLUMN_G_UT_URLTITLE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindUrlTitle) {
					queryPos.add(urlTitle);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_UT_GROUPID_2 =
		"sampleSB.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_UT_URLTITLE_2 =
		"sampleSB.urlTitle = ?";

	private static final String _FINDER_COLUMN_G_UT_URLTITLE_3 =
		"(sampleSB.urlTitle IS NULL OR sampleSB.urlTitle = '')";

	private FinderPath _finderPathFetchByURLTitle;
	private FinderPath _finderPathCountByURLTitle;

	/**
	 * Returns the sample sb where urlTitle = &#63; or throws a <code>NoSuchSampleSBException</code> if it could not be found.
	 *
	 * @param urlTitle the url title
	 * @return the matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findByURLTitle(String urlTitle)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByURLTitle(urlTitle);

		if (sampleSB == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("urlTitle=");
			sb.append(urlTitle);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSampleSBException(sb.toString());
		}

		return sampleSB;
	}

	/**
	 * Returns the sample sb where urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param urlTitle the url title
	 * @return the matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchByURLTitle(String urlTitle) {
		return fetchByURLTitle(urlTitle, true);
	}

	/**
	 * Returns the sample sb where urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param urlTitle the url title
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchByURLTitle(String urlTitle, boolean useFinderCache) {
		urlTitle = Objects.toString(urlTitle, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {urlTitle};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByURLTitle, finderArgs, this);
		}

		if (result instanceof SampleSB) {
			SampleSB sampleSB = (SampleSB)result;

			if (!Objects.equals(urlTitle, sampleSB.getUrlTitle())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			boolean bindUrlTitle = false;

			if (urlTitle.isEmpty()) {
				sb.append(_FINDER_COLUMN_URLTITLE_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				sb.append(_FINDER_COLUMN_URLTITLE_URLTITLE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUrlTitle) {
					queryPos.add(urlTitle);
				}

				List<SampleSB> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByURLTitle, finderArgs, list);
					}
				}
				else {
					SampleSB sampleSB = list.get(0);

					result = sampleSB;

					cacheResult(sampleSB);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByURLTitle, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (SampleSB)result;
		}
	}

	/**
	 * Removes the sample sb where urlTitle = &#63; from the database.
	 *
	 * @param urlTitle the url title
	 * @return the sample sb that was removed
	 */
	@Override
	public SampleSB removeByURLTitle(String urlTitle)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = findByURLTitle(urlTitle);

		return remove(sampleSB);
	}

	/**
	 * Returns the number of sample sbs where urlTitle = &#63;.
	 *
	 * @param urlTitle the url title
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countByURLTitle(String urlTitle) {
		urlTitle = Objects.toString(urlTitle, "");

		FinderPath finderPath = _finderPathCountByURLTitle;

		Object[] finderArgs = new Object[] {urlTitle};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			boolean bindUrlTitle = false;

			if (urlTitle.isEmpty()) {
				sb.append(_FINDER_COLUMN_URLTITLE_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				sb.append(_FINDER_COLUMN_URLTITLE_URLTITLE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUrlTitle) {
					queryPos.add(urlTitle);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_URLTITLE_URLTITLE_2 =
		"sampleSB.urlTitle = ?";

	private static final String _FINDER_COLUMN_URLTITLE_URLTITLE_3 =
		"(sampleSB.urlTitle IS NULL OR sampleSB.urlTitle = '')";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the sample sbs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching sample sbs
	 */
	@Override
	public List<SampleSB> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleSB> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<SampleSB> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if (groupId != sampleSB.getGroupId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first sample sb in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findByGroupId_First(
			long groupId, OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByGroupId_First(groupId, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the first sample sb in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchByGroupId_First(
		long groupId, OrderByComparator<SampleSB> orderByComparator) {

		List<SampleSB> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sample sb in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findByGroupId_Last(
			long groupId, OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByGroupId_Last(groupId, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the last sample sb in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchByGroupId_Last(
		long groupId, OrderByComparator<SampleSB> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<SampleSB> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB[] findByGroupId_PrevAndNext(
			long samplesbId, long groupId,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = findByPrimaryKey(samplesbId);

		Session session = null;

		try {
			session = openSession();

			SampleSB[] array = new SampleSBImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, sampleSB, groupId, orderByComparator, true);

			array[1] = sampleSB;

			array[2] = getByGroupId_PrevAndNext(
				session, sampleSB, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleSB getByGroupId_PrevAndNext(
		Session session, SampleSB sampleSB, long groupId,
		OrderByComparator<SampleSB> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SAMPLESB_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sampleSB)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleSB> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the sample sbs that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching sample sbs that the user has permission to view
	 */
	@Override
	public List<SampleSB> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleSB> filterFindByGroupId(
		long groupId, int start, int end) {

		return filterFindByGroupId(groupId, start, end, null);
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
	@Override
	public List<SampleSB> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				3 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SampleSB.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, SampleSBImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, SampleSBImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			return (List<SampleSB>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public SampleSB[] filterFindByGroupId_PrevAndNext(
			long samplesbId, long groupId,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(
				samplesbId, groupId, orderByComparator);
		}

		SampleSB sampleSB = findByPrimaryKey(samplesbId);

		Session session = null;

		try {
			session = openSession();

			SampleSB[] array = new SampleSBImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(
				session, sampleSB, groupId, orderByComparator, true);

			array[1] = sampleSB;

			array[2] = filterGetByGroupId_PrevAndNext(
				session, sampleSB, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleSB filterGetByGroupId_PrevAndNext(
		Session session, SampleSB sampleSB, long groupId,
		OrderByComparator<SampleSB> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SampleSB.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, SampleSBImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, SampleSBImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sampleSB)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleSB> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sample sbs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (SampleSB sampleSB :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(sampleSB);
		}
	}

	/**
	 * Returns the number of sample sbs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of sample sbs that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching sample sbs that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler sb = new StringBundler(2);

		sb.append(_FILTER_SQL_COUNT_SAMPLESB_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SampleSB.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"sampleSB.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUserIdGroupId;
	private FinderPath _finderPathWithoutPaginationFindByUserIdGroupId;
	private FinderPath _finderPathCountByUserIdGroupId;

	/**
	 * Returns all the sample sbs where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching sample sbs
	 */
	@Override
	public List<SampleSB> findByUserIdGroupId(long userId, long groupId) {
		return findByUserIdGroupId(
			userId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleSB> findByUserIdGroupId(
		long userId, long groupId, int start, int end) {

		return findByUserIdGroupId(userId, groupId, start, end, null);
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
	@Override
	public List<SampleSB> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findByUserIdGroupId(
			userId, groupId, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserIdGroupId;
				finderArgs = new Object[] {userId, groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserIdGroupId;
			finderArgs = new Object[] {
				userId, groupId, start, end, orderByComparator
			};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if ((userId != sampleSB.getUserId()) ||
						(groupId != sampleSB.getGroupId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

			sb.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(groupId);

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SampleSB findByUserIdGroupId_First(
			long userId, long groupId,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByUserIdGroupId_First(
			userId, groupId, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the first sample sb in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchByUserIdGroupId_First(
		long userId, long groupId,
		OrderByComparator<SampleSB> orderByComparator) {

		List<SampleSB> list = findByUserIdGroupId(
			userId, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB findByUserIdGroupId_Last(
			long userId, long groupId,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByUserIdGroupId_Last(
			userId, groupId, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the last sample sb in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchByUserIdGroupId_Last(
		long userId, long groupId,
		OrderByComparator<SampleSB> orderByComparator) {

		int count = countByUserIdGroupId(userId, groupId);

		if (count == 0) {
			return null;
		}

		List<SampleSB> list = findByUserIdGroupId(
			userId, groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB[] findByUserIdGroupId_PrevAndNext(
			long samplesbId, long userId, long groupId,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = findByPrimaryKey(samplesbId);

		Session session = null;

		try {
			session = openSession();

			SampleSB[] array = new SampleSBImpl[3];

			array[0] = getByUserIdGroupId_PrevAndNext(
				session, sampleSB, userId, groupId, orderByComparator, true);

			array[1] = sampleSB;

			array[2] = getByUserIdGroupId_PrevAndNext(
				session, sampleSB, userId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleSB getByUserIdGroupId_PrevAndNext(
		Session session, SampleSB sampleSB, long userId, long groupId,
		OrderByComparator<SampleSB> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SAMPLESB_WHERE);

		sb.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		sb.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sampleSB)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleSB> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the sample sbs that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching sample sbs that the user has permission to view
	 */
	@Override
	public List<SampleSB> filterFindByUserIdGroupId(long userId, long groupId) {
		return filterFindByUserIdGroupId(
			userId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleSB> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end) {

		return filterFindByUserIdGroupId(userId, groupId, start, end, null);
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
	@Override
	public List<SampleSB> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByUserIdGroupId(
				userId, groupId, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		sb.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SampleSB.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, SampleSBImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, SampleSBImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(userId);

			queryPos.add(groupId);

			return (List<SampleSB>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public SampleSB[] filterFindByUserIdGroupId_PrevAndNext(
			long samplesbId, long userId, long groupId,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByUserIdGroupId_PrevAndNext(
				samplesbId, userId, groupId, orderByComparator);
		}

		SampleSB sampleSB = findByPrimaryKey(samplesbId);

		Session session = null;

		try {
			session = openSession();

			SampleSB[] array = new SampleSBImpl[3];

			array[0] = filterGetByUserIdGroupId_PrevAndNext(
				session, sampleSB, userId, groupId, orderByComparator, true);

			array[1] = sampleSB;

			array[2] = filterGetByUserIdGroupId_PrevAndNext(
				session, sampleSB, userId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleSB filterGetByUserIdGroupId_PrevAndNext(
		Session session, SampleSB sampleSB, long userId, long groupId,
		OrderByComparator<SampleSB> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		sb.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SampleSB.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, SampleSBImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, SampleSBImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(userId);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sampleSB)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleSB> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sample sbs where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 */
	@Override
	public void removeByUserIdGroupId(long userId, long groupId) {
		for (SampleSB sampleSB :
				findByUserIdGroupId(
					userId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(sampleSB);
		}
	}

	/**
	 * Returns the number of sample sbs where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countByUserIdGroupId(long userId, long groupId) {
		FinderPath finderPath = _finderPathCountByUserIdGroupId;

		Object[] finderArgs = new Object[] {userId, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

			sb.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of sample sbs that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching sample sbs that the user has permission to view
	 */
	@Override
	public int filterCountByUserIdGroupId(long userId, long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByUserIdGroupId(userId, groupId);
		}

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_SAMPLESB_WHERE);

		sb.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		sb.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), SampleSB.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(userId);

			queryPos.add(groupId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_USERIDGROUPID_USERID_2 =
		"sampleSB.userId = ? AND ";

	private static final String _FINDER_COLUMN_USERIDGROUPID_GROUPID_2 =
		"sampleSB.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the sample sbs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching sample sbs
	 */
	@Override
	public List<SampleSB> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleSB> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<SampleSB> findByUserId(
		long userId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findByUserId(
		long userId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if (userId != sampleSB.getUserId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first sample sb in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findByUserId_First(
			long userId, OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByUserId_First(userId, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the first sample sb in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchByUserId_First(
		long userId, OrderByComparator<SampleSB> orderByComparator) {

		List<SampleSB> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sample sb in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findByUserId_Last(
			long userId, OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByUserId_Last(userId, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the last sample sb in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchByUserId_Last(
		long userId, OrderByComparator<SampleSB> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<SampleSB> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB[] findByUserId_PrevAndNext(
			long samplesbId, long userId,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = findByPrimaryKey(samplesbId);

		Session session = null;

		try {
			session = openSession();

			SampleSB[] array = new SampleSBImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, sampleSB, userId, orderByComparator, true);

			array[1] = sampleSB;

			array[2] = getByUserId_PrevAndNext(
				session, sampleSB, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleSB getByUserId_PrevAndNext(
		Session session, SampleSB sampleSB, long userId,
		OrderByComparator<SampleSB> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SAMPLESB_WHERE);

		sb.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sampleSB)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleSB> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sample sbs where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (SampleSB sampleSB :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(sampleSB);
		}
	}

	/**
	 * Returns the number of sample sbs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"sampleSB.userId = ?";

	private FinderPath _finderPathWithPaginationFindByCompanyId;
	private FinderPath _finderPathWithoutPaginationFindByCompanyId;
	private FinderPath _finderPathCountByCompanyId;

	/**
	 * Returns all the sample sbs where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching sample sbs
	 */
	@Override
	public List<SampleSB> findByCompanyId(long companyId) {
		return findByCompanyId(
			companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleSB> findByCompanyId(long companyId, int start, int end) {
		return findByCompanyId(companyId, start, end, null);
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
	@Override
	public List<SampleSB> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findByCompanyId(companyId, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCompanyId;
				finderArgs = new Object[] {companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCompanyId;
			finderArgs = new Object[] {
				companyId, start, end, orderByComparator
			};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if (companyId != sampleSB.getCompanyId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first sample sb in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findByCompanyId_First(
			long companyId, OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByCompanyId_First(
			companyId, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the first sample sb in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchByCompanyId_First(
		long companyId, OrderByComparator<SampleSB> orderByComparator) {

		List<SampleSB> list = findByCompanyId(
			companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sample sb in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findByCompanyId_Last(
			long companyId, OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByCompanyId_Last(companyId, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the last sample sb in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchByCompanyId_Last(
		long companyId, OrderByComparator<SampleSB> orderByComparator) {

		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<SampleSB> list = findByCompanyId(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB[] findByCompanyId_PrevAndNext(
			long samplesbId, long companyId,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = findByPrimaryKey(samplesbId);

		Session session = null;

		try {
			session = openSession();

			SampleSB[] array = new SampleSBImpl[3];

			array[0] = getByCompanyId_PrevAndNext(
				session, sampleSB, companyId, orderByComparator, true);

			array[1] = sampleSB;

			array[2] = getByCompanyId_PrevAndNext(
				session, sampleSB, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleSB getByCompanyId_PrevAndNext(
		Session session, SampleSB sampleSB, long companyId,
		OrderByComparator<SampleSB> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SAMPLESB_WHERE);

		sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sampleSB)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleSB> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sample sbs where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompanyId(long companyId) {
		for (SampleSB sampleSB :
				findByCompanyId(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(sampleSB);
		}
	}

	/**
	 * Returns the number of sample sbs where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countByCompanyId(long companyId) {
		FinderPath finderPath = _finderPathCountByCompanyId;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 =
		"sampleSB.companyId = ?";

	private FinderPath _finderPathWithPaginationFindBySamplesbId;
	private FinderPath _finderPathWithoutPaginationFindBySamplesbId;
	private FinderPath _finderPathCountBySamplesbId;

	/**
	 * Returns all the sample sbs where samplesbId = &#63;.
	 *
	 * @param samplesbId the samplesb ID
	 * @return the matching sample sbs
	 */
	@Override
	public List<SampleSB> findBySamplesbId(long samplesbId) {
		return findBySamplesbId(
			samplesbId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleSB> findBySamplesbId(
		long samplesbId, int start, int end) {

		return findBySamplesbId(samplesbId, start, end, null);
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
	@Override
	public List<SampleSB> findBySamplesbId(
		long samplesbId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findBySamplesbId(
			samplesbId, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findBySamplesbId(
		long samplesbId, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySamplesbId;
				finderArgs = new Object[] {samplesbId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySamplesbId;
			finderArgs = new Object[] {
				samplesbId, start, end, orderByComparator
			};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if (samplesbId != sampleSB.getSamplesbId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_SAMPLESBID_SAMPLESBID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(samplesbId);

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbId = &#63;.
	 *
	 * @param samplesbId the samplesb ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findBySamplesbId_First(
			long samplesbId, OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchBySamplesbId_First(
			samplesbId, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("samplesbId=");
		sb.append(samplesbId);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbId = &#63;.
	 *
	 * @param samplesbId the samplesb ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchBySamplesbId_First(
		long samplesbId, OrderByComparator<SampleSB> orderByComparator) {

		List<SampleSB> list = findBySamplesbId(
			samplesbId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbId = &#63;.
	 *
	 * @param samplesbId the samplesb ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findBySamplesbId_Last(
			long samplesbId, OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchBySamplesbId_Last(
			samplesbId, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("samplesbId=");
		sb.append(samplesbId);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbId = &#63;.
	 *
	 * @param samplesbId the samplesb ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchBySamplesbId_Last(
		long samplesbId, OrderByComparator<SampleSB> orderByComparator) {

		int count = countBySamplesbId(samplesbId);

		if (count == 0) {
			return null;
		}

		List<SampleSB> list = findBySamplesbId(
			samplesbId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the sample sbs where samplesbId = &#63; from the database.
	 *
	 * @param samplesbId the samplesb ID
	 */
	@Override
	public void removeBySamplesbId(long samplesbId) {
		for (SampleSB sampleSB :
				findBySamplesbId(
					samplesbId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(sampleSB);
		}
	}

	/**
	 * Returns the number of sample sbs where samplesbId = &#63;.
	 *
	 * @param samplesbId the samplesb ID
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countBySamplesbId(long samplesbId) {
		FinderPath finderPath = _finderPathCountBySamplesbId;

		Object[] finderArgs = new Object[] {samplesbId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_SAMPLESBID_SAMPLESBID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(samplesbId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SAMPLESBID_SAMPLESBID_2 =
		"sampleSB.samplesbId = ?";

	private FinderPath _finderPathWithPaginationFindByTitle;
	private FinderPath _finderPathWithoutPaginationFindByTitle;
	private FinderPath _finderPathCountByTitle;

	/**
	 * Returns all the sample sbs where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching sample sbs
	 */
	@Override
	public List<SampleSB> findByTitle(String title) {
		return findByTitle(title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleSB> findByTitle(String title, int start, int end) {
		return findByTitle(title, start, end, null);
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
	@Override
	public List<SampleSB> findByTitle(
		String title, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findByTitle(title, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findByTitle(
		String title, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		title = Objects.toString(title, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTitle;
				finderArgs = new Object[] {title};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTitle;
			finderArgs = new Object[] {title, start, end, orderByComparator};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if (!title.equals(sampleSB.getTitle())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			boolean bindTitle = false;

			if (title.isEmpty()) {
				sb.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				bindTitle = true;

				sb.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTitle) {
					queryPos.add(title);
				}

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first sample sb in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findByTitle_First(
			String title, OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByTitle_First(title, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("title=");
		sb.append(title);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the first sample sb in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchByTitle_First(
		String title, OrderByComparator<SampleSB> orderByComparator) {

		List<SampleSB> list = findByTitle(title, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sample sb in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findByTitle_Last(
			String title, OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByTitle_Last(title, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("title=");
		sb.append(title);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the last sample sb in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchByTitle_Last(
		String title, OrderByComparator<SampleSB> orderByComparator) {

		int count = countByTitle(title);

		if (count == 0) {
			return null;
		}

		List<SampleSB> list = findByTitle(
			title, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB[] findByTitle_PrevAndNext(
			long samplesbId, String title,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		title = Objects.toString(title, "");

		SampleSB sampleSB = findByPrimaryKey(samplesbId);

		Session session = null;

		try {
			session = openSession();

			SampleSB[] array = new SampleSBImpl[3];

			array[0] = getByTitle_PrevAndNext(
				session, sampleSB, title, orderByComparator, true);

			array[1] = sampleSB;

			array[2] = getByTitle_PrevAndNext(
				session, sampleSB, title, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleSB getByTitle_PrevAndNext(
		Session session, SampleSB sampleSB, String title,
		OrderByComparator<SampleSB> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SAMPLESB_WHERE);

		boolean bindTitle = false;

		if (title.isEmpty()) {
			sb.append(_FINDER_COLUMN_TITLE_TITLE_3);
		}
		else {
			bindTitle = true;

			sb.append(_FINDER_COLUMN_TITLE_TITLE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindTitle) {
			queryPos.add(title);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sampleSB)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleSB> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sample sbs where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	@Override
	public void removeByTitle(String title) {
		for (SampleSB sampleSB :
				findByTitle(
					title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(sampleSB);
		}
	}

	/**
	 * Returns the number of sample sbs where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countByTitle(String title) {
		title = Objects.toString(title, "");

		FinderPath finderPath = _finderPathCountByTitle;

		Object[] finderArgs = new Object[] {title};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			boolean bindTitle = false;

			if (title.isEmpty()) {
				sb.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				bindTitle = true;

				sb.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTitle) {
					queryPos.add(title);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TITLE_TITLE_2 =
		"sampleSB.title = ?";

	private static final String _FINDER_COLUMN_TITLE_TITLE_3 =
		"(sampleSB.title IS NULL OR sampleSB.title = '')";

	private FinderPath _finderPathWithPaginationFindBySamplesbBooleanStat;
	private FinderPath _finderPathWithoutPaginationFindBySamplesbBooleanStat;
	private FinderPath _finderPathCountBySamplesbBooleanStat;

	/**
	 * Returns all the sample sbs where samplesbBooleanStat = &#63;.
	 *
	 * @param samplesbBooleanStat the samplesb boolean stat
	 * @return the matching sample sbs
	 */
	@Override
	public List<SampleSB> findBySamplesbBooleanStat(
		boolean samplesbBooleanStat) {

		return findBySamplesbBooleanStat(
			samplesbBooleanStat, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleSB> findBySamplesbBooleanStat(
		boolean samplesbBooleanStat, int start, int end) {

		return findBySamplesbBooleanStat(samplesbBooleanStat, start, end, null);
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
	@Override
	public List<SampleSB> findBySamplesbBooleanStat(
		boolean samplesbBooleanStat, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findBySamplesbBooleanStat(
			samplesbBooleanStat, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findBySamplesbBooleanStat(
		boolean samplesbBooleanStat, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBySamplesbBooleanStat;
				finderArgs = new Object[] {samplesbBooleanStat};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySamplesbBooleanStat;
			finderArgs = new Object[] {
				samplesbBooleanStat, start, end, orderByComparator
			};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if (samplesbBooleanStat !=
							sampleSB.isSamplesbBooleanStat()) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_SAMPLESBBOOLEANSTAT_SAMPLESBBOOLEANSTAT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(samplesbBooleanStat);

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbBooleanStat = &#63;.
	 *
	 * @param samplesbBooleanStat the samplesb boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findBySamplesbBooleanStat_First(
			boolean samplesbBooleanStat,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchBySamplesbBooleanStat_First(
			samplesbBooleanStat, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("samplesbBooleanStat=");
		sb.append(samplesbBooleanStat);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbBooleanStat = &#63;.
	 *
	 * @param samplesbBooleanStat the samplesb boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchBySamplesbBooleanStat_First(
		boolean samplesbBooleanStat,
		OrderByComparator<SampleSB> orderByComparator) {

		List<SampleSB> list = findBySamplesbBooleanStat(
			samplesbBooleanStat, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbBooleanStat = &#63;.
	 *
	 * @param samplesbBooleanStat the samplesb boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findBySamplesbBooleanStat_Last(
			boolean samplesbBooleanStat,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchBySamplesbBooleanStat_Last(
			samplesbBooleanStat, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("samplesbBooleanStat=");
		sb.append(samplesbBooleanStat);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbBooleanStat = &#63;.
	 *
	 * @param samplesbBooleanStat the samplesb boolean stat
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchBySamplesbBooleanStat_Last(
		boolean samplesbBooleanStat,
		OrderByComparator<SampleSB> orderByComparator) {

		int count = countBySamplesbBooleanStat(samplesbBooleanStat);

		if (count == 0) {
			return null;
		}

		List<SampleSB> list = findBySamplesbBooleanStat(
			samplesbBooleanStat, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB[] findBySamplesbBooleanStat_PrevAndNext(
			long samplesbId, boolean samplesbBooleanStat,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = findByPrimaryKey(samplesbId);

		Session session = null;

		try {
			session = openSession();

			SampleSB[] array = new SampleSBImpl[3];

			array[0] = getBySamplesbBooleanStat_PrevAndNext(
				session, sampleSB, samplesbBooleanStat, orderByComparator,
				true);

			array[1] = sampleSB;

			array[2] = getBySamplesbBooleanStat_PrevAndNext(
				session, sampleSB, samplesbBooleanStat, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleSB getBySamplesbBooleanStat_PrevAndNext(
		Session session, SampleSB sampleSB, boolean samplesbBooleanStat,
		OrderByComparator<SampleSB> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SAMPLESB_WHERE);

		sb.append(_FINDER_COLUMN_SAMPLESBBOOLEANSTAT_SAMPLESBBOOLEANSTAT_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(samplesbBooleanStat);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sampleSB)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleSB> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sample sbs where samplesbBooleanStat = &#63; from the database.
	 *
	 * @param samplesbBooleanStat the samplesb boolean stat
	 */
	@Override
	public void removeBySamplesbBooleanStat(boolean samplesbBooleanStat) {
		for (SampleSB sampleSB :
				findBySamplesbBooleanStat(
					samplesbBooleanStat, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(sampleSB);
		}
	}

	/**
	 * Returns the number of sample sbs where samplesbBooleanStat = &#63;.
	 *
	 * @param samplesbBooleanStat the samplesb boolean stat
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countBySamplesbBooleanStat(boolean samplesbBooleanStat) {
		FinderPath finderPath = _finderPathCountBySamplesbBooleanStat;

		Object[] finderArgs = new Object[] {samplesbBooleanStat};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_SAMPLESBBOOLEANSTAT_SAMPLESBBOOLEANSTAT_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(samplesbBooleanStat);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_SAMPLESBBOOLEANSTAT_SAMPLESBBOOLEANSTAT_2 =
			"sampleSB.samplesbBooleanStat = ?";

	private FinderPath _finderPathWithPaginationFindBySamplesbDateTime;
	private FinderPath _finderPathWithoutPaginationFindBySamplesbDateTime;
	private FinderPath _finderPathCountBySamplesbDateTime;

	/**
	 * Returns all the sample sbs where samplesbDateTime = &#63;.
	 *
	 * @param samplesbDateTime the samplesb date time
	 * @return the matching sample sbs
	 */
	@Override
	public List<SampleSB> findBySamplesbDateTime(Date samplesbDateTime) {
		return findBySamplesbDateTime(
			samplesbDateTime, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleSB> findBySamplesbDateTime(
		Date samplesbDateTime, int start, int end) {

		return findBySamplesbDateTime(samplesbDateTime, start, end, null);
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
	@Override
	public List<SampleSB> findBySamplesbDateTime(
		Date samplesbDateTime, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findBySamplesbDateTime(
			samplesbDateTime, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findBySamplesbDateTime(
		Date samplesbDateTime, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySamplesbDateTime;
				finderArgs = new Object[] {_getTime(samplesbDateTime)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySamplesbDateTime;
			finderArgs = new Object[] {
				_getTime(samplesbDateTime), start, end, orderByComparator
			};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if (!Objects.equals(
							samplesbDateTime, sampleSB.getSamplesbDateTime())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			boolean bindSamplesbDateTime = false;

			if (samplesbDateTime == null) {
				sb.append(_FINDER_COLUMN_SAMPLESBDATETIME_SAMPLESBDATETIME_1);
			}
			else {
				bindSamplesbDateTime = true;

				sb.append(_FINDER_COLUMN_SAMPLESBDATETIME_SAMPLESBDATETIME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSamplesbDateTime) {
					queryPos.add(new Timestamp(samplesbDateTime.getTime()));
				}

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbDateTime = &#63;.
	 *
	 * @param samplesbDateTime the samplesb date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findBySamplesbDateTime_First(
			Date samplesbDateTime,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchBySamplesbDateTime_First(
			samplesbDateTime, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("samplesbDateTime=");
		sb.append(samplesbDateTime);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbDateTime = &#63;.
	 *
	 * @param samplesbDateTime the samplesb date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchBySamplesbDateTime_First(
		Date samplesbDateTime, OrderByComparator<SampleSB> orderByComparator) {

		List<SampleSB> list = findBySamplesbDateTime(
			samplesbDateTime, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbDateTime = &#63;.
	 *
	 * @param samplesbDateTime the samplesb date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findBySamplesbDateTime_Last(
			Date samplesbDateTime,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchBySamplesbDateTime_Last(
			samplesbDateTime, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("samplesbDateTime=");
		sb.append(samplesbDateTime);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbDateTime = &#63;.
	 *
	 * @param samplesbDateTime the samplesb date time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchBySamplesbDateTime_Last(
		Date samplesbDateTime, OrderByComparator<SampleSB> orderByComparator) {

		int count = countBySamplesbDateTime(samplesbDateTime);

		if (count == 0) {
			return null;
		}

		List<SampleSB> list = findBySamplesbDateTime(
			samplesbDateTime, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB[] findBySamplesbDateTime_PrevAndNext(
			long samplesbId, Date samplesbDateTime,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = findByPrimaryKey(samplesbId);

		Session session = null;

		try {
			session = openSession();

			SampleSB[] array = new SampleSBImpl[3];

			array[0] = getBySamplesbDateTime_PrevAndNext(
				session, sampleSB, samplesbDateTime, orderByComparator, true);

			array[1] = sampleSB;

			array[2] = getBySamplesbDateTime_PrevAndNext(
				session, sampleSB, samplesbDateTime, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleSB getBySamplesbDateTime_PrevAndNext(
		Session session, SampleSB sampleSB, Date samplesbDateTime,
		OrderByComparator<SampleSB> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SAMPLESB_WHERE);

		boolean bindSamplesbDateTime = false;

		if (samplesbDateTime == null) {
			sb.append(_FINDER_COLUMN_SAMPLESBDATETIME_SAMPLESBDATETIME_1);
		}
		else {
			bindSamplesbDateTime = true;

			sb.append(_FINDER_COLUMN_SAMPLESBDATETIME_SAMPLESBDATETIME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindSamplesbDateTime) {
			queryPos.add(new Timestamp(samplesbDateTime.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sampleSB)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleSB> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sample sbs where samplesbDateTime = &#63; from the database.
	 *
	 * @param samplesbDateTime the samplesb date time
	 */
	@Override
	public void removeBySamplesbDateTime(Date samplesbDateTime) {
		for (SampleSB sampleSB :
				findBySamplesbDateTime(
					samplesbDateTime, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(sampleSB);
		}
	}

	/**
	 * Returns the number of sample sbs where samplesbDateTime = &#63;.
	 *
	 * @param samplesbDateTime the samplesb date time
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countBySamplesbDateTime(Date samplesbDateTime) {
		FinderPath finderPath = _finderPathCountBySamplesbDateTime;

		Object[] finderArgs = new Object[] {_getTime(samplesbDateTime)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			boolean bindSamplesbDateTime = false;

			if (samplesbDateTime == null) {
				sb.append(_FINDER_COLUMN_SAMPLESBDATETIME_SAMPLESBDATETIME_1);
			}
			else {
				bindSamplesbDateTime = true;

				sb.append(_FINDER_COLUMN_SAMPLESBDATETIME_SAMPLESBDATETIME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSamplesbDateTime) {
					queryPos.add(new Timestamp(samplesbDateTime.getTime()));
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_SAMPLESBDATETIME_SAMPLESBDATETIME_1 =
			"sampleSB.samplesbDateTime IS NULL";

	private static final String
		_FINDER_COLUMN_SAMPLESBDATETIME_SAMPLESBDATETIME_2 =
			"sampleSB.samplesbDateTime = ?";

	private FinderPath _finderPathWithPaginationFindBySamplesbDocumentLibrary;
	private FinderPath
		_finderPathWithoutPaginationFindBySamplesbDocumentLibrary;
	private FinderPath _finderPathCountBySamplesbDocumentLibrary;

	/**
	 * Returns all the sample sbs where samplesbDocumentLibrary = &#63;.
	 *
	 * @param samplesbDocumentLibrary the samplesb document library
	 * @return the matching sample sbs
	 */
	@Override
	public List<SampleSB> findBySamplesbDocumentLibrary(
		String samplesbDocumentLibrary) {

		return findBySamplesbDocumentLibrary(
			samplesbDocumentLibrary, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<SampleSB> findBySamplesbDocumentLibrary(
		String samplesbDocumentLibrary, int start, int end) {

		return findBySamplesbDocumentLibrary(
			samplesbDocumentLibrary, start, end, null);
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
	@Override
	public List<SampleSB> findBySamplesbDocumentLibrary(
		String samplesbDocumentLibrary, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findBySamplesbDocumentLibrary(
			samplesbDocumentLibrary, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findBySamplesbDocumentLibrary(
		String samplesbDocumentLibrary, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		samplesbDocumentLibrary = Objects.toString(samplesbDocumentLibrary, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBySamplesbDocumentLibrary;
				finderArgs = new Object[] {samplesbDocumentLibrary};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySamplesbDocumentLibrary;
			finderArgs = new Object[] {
				samplesbDocumentLibrary, start, end, orderByComparator
			};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if (!samplesbDocumentLibrary.equals(
							sampleSB.getSamplesbDocumentLibrary())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			boolean bindSamplesbDocumentLibrary = false;

			if (samplesbDocumentLibrary.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_SAMPLESBDOCUMENTLIBRARY_SAMPLESBDOCUMENTLIBRARY_3);
			}
			else {
				bindSamplesbDocumentLibrary = true;

				sb.append(
					_FINDER_COLUMN_SAMPLESBDOCUMENTLIBRARY_SAMPLESBDOCUMENTLIBRARY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSamplesbDocumentLibrary) {
					queryPos.add(samplesbDocumentLibrary);
				}

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbDocumentLibrary = &#63;.
	 *
	 * @param samplesbDocumentLibrary the samplesb document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findBySamplesbDocumentLibrary_First(
			String samplesbDocumentLibrary,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchBySamplesbDocumentLibrary_First(
			samplesbDocumentLibrary, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("samplesbDocumentLibrary=");
		sb.append(samplesbDocumentLibrary);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbDocumentLibrary = &#63;.
	 *
	 * @param samplesbDocumentLibrary the samplesb document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchBySamplesbDocumentLibrary_First(
		String samplesbDocumentLibrary,
		OrderByComparator<SampleSB> orderByComparator) {

		List<SampleSB> list = findBySamplesbDocumentLibrary(
			samplesbDocumentLibrary, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbDocumentLibrary = &#63;.
	 *
	 * @param samplesbDocumentLibrary the samplesb document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findBySamplesbDocumentLibrary_Last(
			String samplesbDocumentLibrary,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchBySamplesbDocumentLibrary_Last(
			samplesbDocumentLibrary, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("samplesbDocumentLibrary=");
		sb.append(samplesbDocumentLibrary);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbDocumentLibrary = &#63;.
	 *
	 * @param samplesbDocumentLibrary the samplesb document library
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchBySamplesbDocumentLibrary_Last(
		String samplesbDocumentLibrary,
		OrderByComparator<SampleSB> orderByComparator) {

		int count = countBySamplesbDocumentLibrary(samplesbDocumentLibrary);

		if (count == 0) {
			return null;
		}

		List<SampleSB> list = findBySamplesbDocumentLibrary(
			samplesbDocumentLibrary, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB[] findBySamplesbDocumentLibrary_PrevAndNext(
			long samplesbId, String samplesbDocumentLibrary,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		samplesbDocumentLibrary = Objects.toString(samplesbDocumentLibrary, "");

		SampleSB sampleSB = findByPrimaryKey(samplesbId);

		Session session = null;

		try {
			session = openSession();

			SampleSB[] array = new SampleSBImpl[3];

			array[0] = getBySamplesbDocumentLibrary_PrevAndNext(
				session, sampleSB, samplesbDocumentLibrary, orderByComparator,
				true);

			array[1] = sampleSB;

			array[2] = getBySamplesbDocumentLibrary_PrevAndNext(
				session, sampleSB, samplesbDocumentLibrary, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleSB getBySamplesbDocumentLibrary_PrevAndNext(
		Session session, SampleSB sampleSB, String samplesbDocumentLibrary,
		OrderByComparator<SampleSB> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SAMPLESB_WHERE);

		boolean bindSamplesbDocumentLibrary = false;

		if (samplesbDocumentLibrary.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_SAMPLESBDOCUMENTLIBRARY_SAMPLESBDOCUMENTLIBRARY_3);
		}
		else {
			bindSamplesbDocumentLibrary = true;

			sb.append(
				_FINDER_COLUMN_SAMPLESBDOCUMENTLIBRARY_SAMPLESBDOCUMENTLIBRARY_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindSamplesbDocumentLibrary) {
			queryPos.add(samplesbDocumentLibrary);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sampleSB)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleSB> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sample sbs where samplesbDocumentLibrary = &#63; from the database.
	 *
	 * @param samplesbDocumentLibrary the samplesb document library
	 */
	@Override
	public void removeBySamplesbDocumentLibrary(
		String samplesbDocumentLibrary) {

		for (SampleSB sampleSB :
				findBySamplesbDocumentLibrary(
					samplesbDocumentLibrary, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(sampleSB);
		}
	}

	/**
	 * Returns the number of sample sbs where samplesbDocumentLibrary = &#63;.
	 *
	 * @param samplesbDocumentLibrary the samplesb document library
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countBySamplesbDocumentLibrary(String samplesbDocumentLibrary) {
		samplesbDocumentLibrary = Objects.toString(samplesbDocumentLibrary, "");

		FinderPath finderPath = _finderPathCountBySamplesbDocumentLibrary;

		Object[] finderArgs = new Object[] {samplesbDocumentLibrary};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			boolean bindSamplesbDocumentLibrary = false;

			if (samplesbDocumentLibrary.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_SAMPLESBDOCUMENTLIBRARY_SAMPLESBDOCUMENTLIBRARY_3);
			}
			else {
				bindSamplesbDocumentLibrary = true;

				sb.append(
					_FINDER_COLUMN_SAMPLESBDOCUMENTLIBRARY_SAMPLESBDOCUMENTLIBRARY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSamplesbDocumentLibrary) {
					queryPos.add(samplesbDocumentLibrary);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_SAMPLESBDOCUMENTLIBRARY_SAMPLESBDOCUMENTLIBRARY_2 =
			"sampleSB.samplesbDocumentLibrary = ?";

	private static final String
		_FINDER_COLUMN_SAMPLESBDOCUMENTLIBRARY_SAMPLESBDOCUMENTLIBRARY_3 =
			"(sampleSB.samplesbDocumentLibrary IS NULL OR sampleSB.samplesbDocumentLibrary = '')";

	private FinderPath _finderPathWithPaginationFindBySamplesbDouble;
	private FinderPath _finderPathWithoutPaginationFindBySamplesbDouble;
	private FinderPath _finderPathCountBySamplesbDouble;

	/**
	 * Returns all the sample sbs where samplesbDouble = &#63;.
	 *
	 * @param samplesbDouble the samplesb double
	 * @return the matching sample sbs
	 */
	@Override
	public List<SampleSB> findBySamplesbDouble(double samplesbDouble) {
		return findBySamplesbDouble(
			samplesbDouble, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleSB> findBySamplesbDouble(
		double samplesbDouble, int start, int end) {

		return findBySamplesbDouble(samplesbDouble, start, end, null);
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
	@Override
	public List<SampleSB> findBySamplesbDouble(
		double samplesbDouble, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findBySamplesbDouble(
			samplesbDouble, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findBySamplesbDouble(
		double samplesbDouble, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySamplesbDouble;
				finderArgs = new Object[] {samplesbDouble};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySamplesbDouble;
			finderArgs = new Object[] {
				samplesbDouble, start, end, orderByComparator
			};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if (samplesbDouble != sampleSB.getSamplesbDouble()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_SAMPLESBDOUBLE_SAMPLESBDOUBLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(samplesbDouble);

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbDouble = &#63;.
	 *
	 * @param samplesbDouble the samplesb double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findBySamplesbDouble_First(
			double samplesbDouble,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchBySamplesbDouble_First(
			samplesbDouble, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("samplesbDouble=");
		sb.append(samplesbDouble);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbDouble = &#63;.
	 *
	 * @param samplesbDouble the samplesb double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchBySamplesbDouble_First(
		double samplesbDouble, OrderByComparator<SampleSB> orderByComparator) {

		List<SampleSB> list = findBySamplesbDouble(
			samplesbDouble, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbDouble = &#63;.
	 *
	 * @param samplesbDouble the samplesb double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findBySamplesbDouble_Last(
			double samplesbDouble,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchBySamplesbDouble_Last(
			samplesbDouble, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("samplesbDouble=");
		sb.append(samplesbDouble);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbDouble = &#63;.
	 *
	 * @param samplesbDouble the samplesb double
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchBySamplesbDouble_Last(
		double samplesbDouble, OrderByComparator<SampleSB> orderByComparator) {

		int count = countBySamplesbDouble(samplesbDouble);

		if (count == 0) {
			return null;
		}

		List<SampleSB> list = findBySamplesbDouble(
			samplesbDouble, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB[] findBySamplesbDouble_PrevAndNext(
			long samplesbId, double samplesbDouble,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = findByPrimaryKey(samplesbId);

		Session session = null;

		try {
			session = openSession();

			SampleSB[] array = new SampleSBImpl[3];

			array[0] = getBySamplesbDouble_PrevAndNext(
				session, sampleSB, samplesbDouble, orderByComparator, true);

			array[1] = sampleSB;

			array[2] = getBySamplesbDouble_PrevAndNext(
				session, sampleSB, samplesbDouble, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleSB getBySamplesbDouble_PrevAndNext(
		Session session, SampleSB sampleSB, double samplesbDouble,
		OrderByComparator<SampleSB> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SAMPLESB_WHERE);

		sb.append(_FINDER_COLUMN_SAMPLESBDOUBLE_SAMPLESBDOUBLE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(samplesbDouble);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sampleSB)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleSB> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sample sbs where samplesbDouble = &#63; from the database.
	 *
	 * @param samplesbDouble the samplesb double
	 */
	@Override
	public void removeBySamplesbDouble(double samplesbDouble) {
		for (SampleSB sampleSB :
				findBySamplesbDouble(
					samplesbDouble, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(sampleSB);
		}
	}

	/**
	 * Returns the number of sample sbs where samplesbDouble = &#63;.
	 *
	 * @param samplesbDouble the samplesb double
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countBySamplesbDouble(double samplesbDouble) {
		FinderPath finderPath = _finderPathCountBySamplesbDouble;

		Object[] finderArgs = new Object[] {samplesbDouble};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_SAMPLESBDOUBLE_SAMPLESBDOUBLE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(samplesbDouble);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SAMPLESBDOUBLE_SAMPLESBDOUBLE_2 =
		"sampleSB.samplesbDouble = ?";

	private FinderPath _finderPathWithPaginationFindBySamplesbInteger;
	private FinderPath _finderPathWithoutPaginationFindBySamplesbInteger;
	private FinderPath _finderPathCountBySamplesbInteger;

	/**
	 * Returns all the sample sbs where samplesbInteger = &#63;.
	 *
	 * @param samplesbInteger the samplesb integer
	 * @return the matching sample sbs
	 */
	@Override
	public List<SampleSB> findBySamplesbInteger(int samplesbInteger) {
		return findBySamplesbInteger(
			samplesbInteger, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleSB> findBySamplesbInteger(
		int samplesbInteger, int start, int end) {

		return findBySamplesbInteger(samplesbInteger, start, end, null);
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
	@Override
	public List<SampleSB> findBySamplesbInteger(
		int samplesbInteger, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findBySamplesbInteger(
			samplesbInteger, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findBySamplesbInteger(
		int samplesbInteger, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySamplesbInteger;
				finderArgs = new Object[] {samplesbInteger};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySamplesbInteger;
			finderArgs = new Object[] {
				samplesbInteger, start, end, orderByComparator
			};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if (samplesbInteger != sampleSB.getSamplesbInteger()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_SAMPLESBINTEGER_SAMPLESBINTEGER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(samplesbInteger);

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbInteger = &#63;.
	 *
	 * @param samplesbInteger the samplesb integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findBySamplesbInteger_First(
			int samplesbInteger, OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchBySamplesbInteger_First(
			samplesbInteger, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("samplesbInteger=");
		sb.append(samplesbInteger);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbInteger = &#63;.
	 *
	 * @param samplesbInteger the samplesb integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchBySamplesbInteger_First(
		int samplesbInteger, OrderByComparator<SampleSB> orderByComparator) {

		List<SampleSB> list = findBySamplesbInteger(
			samplesbInteger, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbInteger = &#63;.
	 *
	 * @param samplesbInteger the samplesb integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findBySamplesbInteger_Last(
			int samplesbInteger, OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchBySamplesbInteger_Last(
			samplesbInteger, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("samplesbInteger=");
		sb.append(samplesbInteger);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbInteger = &#63;.
	 *
	 * @param samplesbInteger the samplesb integer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchBySamplesbInteger_Last(
		int samplesbInteger, OrderByComparator<SampleSB> orderByComparator) {

		int count = countBySamplesbInteger(samplesbInteger);

		if (count == 0) {
			return null;
		}

		List<SampleSB> list = findBySamplesbInteger(
			samplesbInteger, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB[] findBySamplesbInteger_PrevAndNext(
			long samplesbId, int samplesbInteger,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = findByPrimaryKey(samplesbId);

		Session session = null;

		try {
			session = openSession();

			SampleSB[] array = new SampleSBImpl[3];

			array[0] = getBySamplesbInteger_PrevAndNext(
				session, sampleSB, samplesbInteger, orderByComparator, true);

			array[1] = sampleSB;

			array[2] = getBySamplesbInteger_PrevAndNext(
				session, sampleSB, samplesbInteger, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleSB getBySamplesbInteger_PrevAndNext(
		Session session, SampleSB sampleSB, int samplesbInteger,
		OrderByComparator<SampleSB> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SAMPLESB_WHERE);

		sb.append(_FINDER_COLUMN_SAMPLESBINTEGER_SAMPLESBINTEGER_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(samplesbInteger);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sampleSB)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleSB> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sample sbs where samplesbInteger = &#63; from the database.
	 *
	 * @param samplesbInteger the samplesb integer
	 */
	@Override
	public void removeBySamplesbInteger(int samplesbInteger) {
		for (SampleSB sampleSB :
				findBySamplesbInteger(
					samplesbInteger, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(sampleSB);
		}
	}

	/**
	 * Returns the number of sample sbs where samplesbInteger = &#63;.
	 *
	 * @param samplesbInteger the samplesb integer
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countBySamplesbInteger(int samplesbInteger) {
		FinderPath finderPath = _finderPathCountBySamplesbInteger;

		Object[] finderArgs = new Object[] {samplesbInteger};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			sb.append(_FINDER_COLUMN_SAMPLESBINTEGER_SAMPLESBINTEGER_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(samplesbInteger);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_SAMPLESBINTEGER_SAMPLESBINTEGER_2 =
			"sampleSB.samplesbInteger = ?";

	private FinderPath _finderPathWithPaginationFindBySamplesbRichText;
	private FinderPath _finderPathWithoutPaginationFindBySamplesbRichText;
	private FinderPath _finderPathCountBySamplesbRichText;

	/**
	 * Returns all the sample sbs where samplesbRichText = &#63;.
	 *
	 * @param samplesbRichText the samplesb rich text
	 * @return the matching sample sbs
	 */
	@Override
	public List<SampleSB> findBySamplesbRichText(String samplesbRichText) {
		return findBySamplesbRichText(
			samplesbRichText, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleSB> findBySamplesbRichText(
		String samplesbRichText, int start, int end) {

		return findBySamplesbRichText(samplesbRichText, start, end, null);
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
	@Override
	public List<SampleSB> findBySamplesbRichText(
		String samplesbRichText, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findBySamplesbRichText(
			samplesbRichText, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findBySamplesbRichText(
		String samplesbRichText, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		samplesbRichText = Objects.toString(samplesbRichText, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySamplesbRichText;
				finderArgs = new Object[] {samplesbRichText};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySamplesbRichText;
			finderArgs = new Object[] {
				samplesbRichText, start, end, orderByComparator
			};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if (!samplesbRichText.equals(
							sampleSB.getSamplesbRichText())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			boolean bindSamplesbRichText = false;

			if (samplesbRichText.isEmpty()) {
				sb.append(_FINDER_COLUMN_SAMPLESBRICHTEXT_SAMPLESBRICHTEXT_3);
			}
			else {
				bindSamplesbRichText = true;

				sb.append(_FINDER_COLUMN_SAMPLESBRICHTEXT_SAMPLESBRICHTEXT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSamplesbRichText) {
					queryPos.add(samplesbRichText);
				}

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbRichText = &#63;.
	 *
	 * @param samplesbRichText the samplesb rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findBySamplesbRichText_First(
			String samplesbRichText,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchBySamplesbRichText_First(
			samplesbRichText, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("samplesbRichText=");
		sb.append(samplesbRichText);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbRichText = &#63;.
	 *
	 * @param samplesbRichText the samplesb rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchBySamplesbRichText_First(
		String samplesbRichText,
		OrderByComparator<SampleSB> orderByComparator) {

		List<SampleSB> list = findBySamplesbRichText(
			samplesbRichText, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbRichText = &#63;.
	 *
	 * @param samplesbRichText the samplesb rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findBySamplesbRichText_Last(
			String samplesbRichText,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchBySamplesbRichText_Last(
			samplesbRichText, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("samplesbRichText=");
		sb.append(samplesbRichText);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbRichText = &#63;.
	 *
	 * @param samplesbRichText the samplesb rich text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchBySamplesbRichText_Last(
		String samplesbRichText,
		OrderByComparator<SampleSB> orderByComparator) {

		int count = countBySamplesbRichText(samplesbRichText);

		if (count == 0) {
			return null;
		}

		List<SampleSB> list = findBySamplesbRichText(
			samplesbRichText, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB[] findBySamplesbRichText_PrevAndNext(
			long samplesbId, String samplesbRichText,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		samplesbRichText = Objects.toString(samplesbRichText, "");

		SampleSB sampleSB = findByPrimaryKey(samplesbId);

		Session session = null;

		try {
			session = openSession();

			SampleSB[] array = new SampleSBImpl[3];

			array[0] = getBySamplesbRichText_PrevAndNext(
				session, sampleSB, samplesbRichText, orderByComparator, true);

			array[1] = sampleSB;

			array[2] = getBySamplesbRichText_PrevAndNext(
				session, sampleSB, samplesbRichText, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleSB getBySamplesbRichText_PrevAndNext(
		Session session, SampleSB sampleSB, String samplesbRichText,
		OrderByComparator<SampleSB> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SAMPLESB_WHERE);

		boolean bindSamplesbRichText = false;

		if (samplesbRichText.isEmpty()) {
			sb.append(_FINDER_COLUMN_SAMPLESBRICHTEXT_SAMPLESBRICHTEXT_3);
		}
		else {
			bindSamplesbRichText = true;

			sb.append(_FINDER_COLUMN_SAMPLESBRICHTEXT_SAMPLESBRICHTEXT_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindSamplesbRichText) {
			queryPos.add(samplesbRichText);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sampleSB)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleSB> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sample sbs where samplesbRichText = &#63; from the database.
	 *
	 * @param samplesbRichText the samplesb rich text
	 */
	@Override
	public void removeBySamplesbRichText(String samplesbRichText) {
		for (SampleSB sampleSB :
				findBySamplesbRichText(
					samplesbRichText, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(sampleSB);
		}
	}

	/**
	 * Returns the number of sample sbs where samplesbRichText = &#63;.
	 *
	 * @param samplesbRichText the samplesb rich text
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countBySamplesbRichText(String samplesbRichText) {
		samplesbRichText = Objects.toString(samplesbRichText, "");

		FinderPath finderPath = _finderPathCountBySamplesbRichText;

		Object[] finderArgs = new Object[] {samplesbRichText};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			boolean bindSamplesbRichText = false;

			if (samplesbRichText.isEmpty()) {
				sb.append(_FINDER_COLUMN_SAMPLESBRICHTEXT_SAMPLESBRICHTEXT_3);
			}
			else {
				bindSamplesbRichText = true;

				sb.append(_FINDER_COLUMN_SAMPLESBRICHTEXT_SAMPLESBRICHTEXT_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSamplesbRichText) {
					queryPos.add(samplesbRichText);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_SAMPLESBRICHTEXT_SAMPLESBRICHTEXT_2 =
			"sampleSB.samplesbRichText = ?";

	private static final String
		_FINDER_COLUMN_SAMPLESBRICHTEXT_SAMPLESBRICHTEXT_3 =
			"(sampleSB.samplesbRichText IS NULL OR sampleSB.samplesbRichText = '')";

	private FinderPath _finderPathWithPaginationFindBySamplesbText;
	private FinderPath _finderPathWithoutPaginationFindBySamplesbText;
	private FinderPath _finderPathCountBySamplesbText;

	/**
	 * Returns all the sample sbs where samplesbText = &#63;.
	 *
	 * @param samplesbText the samplesb text
	 * @return the matching sample sbs
	 */
	@Override
	public List<SampleSB> findBySamplesbText(String samplesbText) {
		return findBySamplesbText(
			samplesbText, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleSB> findBySamplesbText(
		String samplesbText, int start, int end) {

		return findBySamplesbText(samplesbText, start, end, null);
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
	@Override
	public List<SampleSB> findBySamplesbText(
		String samplesbText, int start, int end,
		OrderByComparator<SampleSB> orderByComparator) {

		return findBySamplesbText(
			samplesbText, start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findBySamplesbText(
		String samplesbText, int start, int end,
		OrderByComparator<SampleSB> orderByComparator, boolean useFinderCache) {

		samplesbText = Objects.toString(samplesbText, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySamplesbText;
				finderArgs = new Object[] {samplesbText};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySamplesbText;
			finderArgs = new Object[] {
				samplesbText, start, end, orderByComparator
			};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SampleSB sampleSB : list) {
					if (!samplesbText.equals(sampleSB.getSamplesbText())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SAMPLESB_WHERE);

			boolean bindSamplesbText = false;

			if (samplesbText.isEmpty()) {
				sb.append(_FINDER_COLUMN_SAMPLESBTEXT_SAMPLESBTEXT_3);
			}
			else {
				bindSamplesbText = true;

				sb.append(_FINDER_COLUMN_SAMPLESBTEXT_SAMPLESBTEXT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSamplesbText) {
					queryPos.add(samplesbText);
				}

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbText = &#63;.
	 *
	 * @param samplesbText the samplesb text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findBySamplesbText_First(
			String samplesbText, OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchBySamplesbText_First(
			samplesbText, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("samplesbText=");
		sb.append(samplesbText);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the first sample sb in the ordered set where samplesbText = &#63;.
	 *
	 * @param samplesbText the samplesb text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchBySamplesbText_First(
		String samplesbText, OrderByComparator<SampleSB> orderByComparator) {

		List<SampleSB> list = findBySamplesbText(
			samplesbText, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbText = &#63;.
	 *
	 * @param samplesbText the samplesb text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb
	 * @throws NoSuchSampleSBException if a matching sample sb could not be found
	 */
	@Override
	public SampleSB findBySamplesbText_Last(
			String samplesbText, OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchBySamplesbText_Last(
			samplesbText, orderByComparator);

		if (sampleSB != null) {
			return sampleSB;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("samplesbText=");
		sb.append(samplesbText);

		sb.append("}");

		throw new NoSuchSampleSBException(sb.toString());
	}

	/**
	 * Returns the last sample sb in the ordered set where samplesbText = &#63;.
	 *
	 * @param samplesbText the samplesb text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample sb, or <code>null</code> if a matching sample sb could not be found
	 */
	@Override
	public SampleSB fetchBySamplesbText_Last(
		String samplesbText, OrderByComparator<SampleSB> orderByComparator) {

		int count = countBySamplesbText(samplesbText);

		if (count == 0) {
			return null;
		}

		List<SampleSB> list = findBySamplesbText(
			samplesbText, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SampleSB[] findBySamplesbText_PrevAndNext(
			long samplesbId, String samplesbText,
			OrderByComparator<SampleSB> orderByComparator)
		throws NoSuchSampleSBException {

		samplesbText = Objects.toString(samplesbText, "");

		SampleSB sampleSB = findByPrimaryKey(samplesbId);

		Session session = null;

		try {
			session = openSession();

			SampleSB[] array = new SampleSBImpl[3];

			array[0] = getBySamplesbText_PrevAndNext(
				session, sampleSB, samplesbText, orderByComparator, true);

			array[1] = sampleSB;

			array[2] = getBySamplesbText_PrevAndNext(
				session, sampleSB, samplesbText, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleSB getBySamplesbText_PrevAndNext(
		Session session, SampleSB sampleSB, String samplesbText,
		OrderByComparator<SampleSB> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SAMPLESB_WHERE);

		boolean bindSamplesbText = false;

		if (samplesbText.isEmpty()) {
			sb.append(_FINDER_COLUMN_SAMPLESBTEXT_SAMPLESBTEXT_3);
		}
		else {
			bindSamplesbText = true;

			sb.append(_FINDER_COLUMN_SAMPLESBTEXT_SAMPLESBTEXT_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SampleSBModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindSamplesbText) {
			queryPos.add(samplesbText);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(sampleSB)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SampleSB> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sample sbs where samplesbText = &#63; from the database.
	 *
	 * @param samplesbText the samplesb text
	 */
	@Override
	public void removeBySamplesbText(String samplesbText) {
		for (SampleSB sampleSB :
				findBySamplesbText(
					samplesbText, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(sampleSB);
		}
	}

	/**
	 * Returns the number of sample sbs where samplesbText = &#63;.
	 *
	 * @param samplesbText the samplesb text
	 * @return the number of matching sample sbs
	 */
	@Override
	public int countBySamplesbText(String samplesbText) {
		samplesbText = Objects.toString(samplesbText, "");

		FinderPath finderPath = _finderPathCountBySamplesbText;

		Object[] finderArgs = new Object[] {samplesbText};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SAMPLESB_WHERE);

			boolean bindSamplesbText = false;

			if (samplesbText.isEmpty()) {
				sb.append(_FINDER_COLUMN_SAMPLESBTEXT_SAMPLESBTEXT_3);
			}
			else {
				bindSamplesbText = true;

				sb.append(_FINDER_COLUMN_SAMPLESBTEXT_SAMPLESBTEXT_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSamplesbText) {
					queryPos.add(samplesbText);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SAMPLESBTEXT_SAMPLESBTEXT_2 =
		"sampleSB.samplesbText = ?";

	private static final String _FINDER_COLUMN_SAMPLESBTEXT_SAMPLESBTEXT_3 =
		"(sampleSB.samplesbText IS NULL OR sampleSB.samplesbText = '')";

	public SampleSBPersistenceImpl() {
		setModelClass(SampleSB.class);

		setModelImplClass(SampleSBImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the sample sb in the entity cache if it is enabled.
	 *
	 * @param sampleSB the sample sb
	 */
	@Override
	public void cacheResult(SampleSB sampleSB) {
		entityCache.putResult(
			entityCacheEnabled, SampleSBImpl.class, sampleSB.getPrimaryKey(),
			sampleSB);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {sampleSB.getUuid(), sampleSB.getGroupId()}, sampleSB);

		finderCache.putResult(
			_finderPathFetchByG_UT,
			new Object[] {sampleSB.getGroupId(), sampleSB.getUrlTitle()},
			sampleSB);

		finderCache.putResult(
			_finderPathFetchByURLTitle, new Object[] {sampleSB.getUrlTitle()},
			sampleSB);

		sampleSB.resetOriginalValues();
	}

	/**
	 * Caches the sample sbs in the entity cache if it is enabled.
	 *
	 * @param sampleSBs the sample sbs
	 */
	@Override
	public void cacheResult(List<SampleSB> sampleSBs) {
		for (SampleSB sampleSB : sampleSBs) {
			if (entityCache.getResult(
					entityCacheEnabled, SampleSBImpl.class,
					sampleSB.getPrimaryKey()) == null) {

				cacheResult(sampleSB);
			}
			else {
				sampleSB.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sample sbs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SampleSBImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sample sb.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SampleSB sampleSB) {
		entityCache.removeResult(
			entityCacheEnabled, SampleSBImpl.class, sampleSB.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((SampleSBModelImpl)sampleSB, true);
	}

	@Override
	public void clearCache(List<SampleSB> sampleSBs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SampleSB sampleSB : sampleSBs) {
			entityCache.removeResult(
				entityCacheEnabled, SampleSBImpl.class,
				sampleSB.getPrimaryKey());

			clearUniqueFindersCache((SampleSBModelImpl)sampleSB, true);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, SampleSBImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SampleSBModelImpl sampleSBModelImpl) {

		Object[] args = new Object[] {
			sampleSBModelImpl.getUuid(), sampleSBModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, sampleSBModelImpl, false);

		args = new Object[] {
			sampleSBModelImpl.getGroupId(), sampleSBModelImpl.getUrlTitle()
		};

		finderCache.putResult(
			_finderPathCountByG_UT, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByG_UT, args, sampleSBModelImpl, false);

		args = new Object[] {sampleSBModelImpl.getUrlTitle()};

		finderCache.putResult(
			_finderPathCountByURLTitle, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByURLTitle, args, sampleSBModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		SampleSBModelImpl sampleSBModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				sampleSBModelImpl.getUuid(), sampleSBModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((sampleSBModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				sampleSBModelImpl.getOriginalUuid(),
				sampleSBModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				sampleSBModelImpl.getGroupId(), sampleSBModelImpl.getUrlTitle()
			};

			finderCache.removeResult(_finderPathCountByG_UT, args);
			finderCache.removeResult(_finderPathFetchByG_UT, args);
		}

		if ((sampleSBModelImpl.getColumnBitmask() &
			 _finderPathFetchByG_UT.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				sampleSBModelImpl.getOriginalGroupId(),
				sampleSBModelImpl.getOriginalUrlTitle()
			};

			finderCache.removeResult(_finderPathCountByG_UT, args);
			finderCache.removeResult(_finderPathFetchByG_UT, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {sampleSBModelImpl.getUrlTitle()};

			finderCache.removeResult(_finderPathCountByURLTitle, args);
			finderCache.removeResult(_finderPathFetchByURLTitle, args);
		}

		if ((sampleSBModelImpl.getColumnBitmask() &
			 _finderPathFetchByURLTitle.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				sampleSBModelImpl.getOriginalUrlTitle()
			};

			finderCache.removeResult(_finderPathCountByURLTitle, args);
			finderCache.removeResult(_finderPathFetchByURLTitle, args);
		}
	}

	/**
	 * Creates a new sample sb with the primary key. Does not add the sample sb to the database.
	 *
	 * @param samplesbId the primary key for the new sample sb
	 * @return the new sample sb
	 */
	@Override
	public SampleSB create(long samplesbId) {
		SampleSB sampleSB = new SampleSBImpl();

		sampleSB.setNew(true);
		sampleSB.setPrimaryKey(samplesbId);

		String uuid = PortalUUIDUtil.generate();

		sampleSB.setUuid(uuid);

		sampleSB.setCompanyId(CompanyThreadLocal.getCompanyId());

		return sampleSB;
	}

	/**
	 * Removes the sample sb with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param samplesbId the primary key of the sample sb
	 * @return the sample sb that was removed
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	@Override
	public SampleSB remove(long samplesbId) throws NoSuchSampleSBException {
		return remove((Serializable)samplesbId);
	}

	/**
	 * Removes the sample sb with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sample sb
	 * @return the sample sb that was removed
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	@Override
	public SampleSB remove(Serializable primaryKey)
		throws NoSuchSampleSBException {

		Session session = null;

		try {
			session = openSession();

			SampleSB sampleSB = (SampleSB)session.get(
				SampleSBImpl.class, primaryKey);

			if (sampleSB == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSampleSBException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(sampleSB);
		}
		catch (NoSuchSampleSBException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SampleSB removeImpl(SampleSB sampleSB) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sampleSB)) {
				sampleSB = (SampleSB)session.get(
					SampleSBImpl.class, sampleSB.getPrimaryKeyObj());
			}

			if (sampleSB != null) {
				session.delete(sampleSB);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (sampleSB != null) {
			clearCache(sampleSB);
		}

		return sampleSB;
	}

	@Override
	public SampleSB updateImpl(SampleSB sampleSB) {
		boolean isNew = sampleSB.isNew();

		if (!(sampleSB instanceof SampleSBModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(sampleSB.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(sampleSB);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in sampleSB proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SampleSB implementation " +
					sampleSB.getClass());
		}

		SampleSBModelImpl sampleSBModelImpl = (SampleSBModelImpl)sampleSB;

		if (Validator.isNull(sampleSB.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			sampleSB.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (sampleSB.getCreateDate() == null)) {
			if (serviceContext == null) {
				sampleSB.setCreateDate(now);
			}
			else {
				sampleSB.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!sampleSBModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				sampleSB.setModifiedDate(now);
			}
			else {
				sampleSB.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (sampleSB.isNew()) {
				session.save(sampleSB);

				sampleSB.setNew(false);
			}
			else {
				sampleSB = (SampleSB)session.merge(sampleSB);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {sampleSBModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				sampleSBModelImpl.getUuid(), sampleSBModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {
				sampleSBModelImpl.getCompanyId(), sampleSBModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByC_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByC_S, args);

			args = new Object[] {
				sampleSBModelImpl.getGroupId(), sampleSBModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByG_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_S, args);

			args = new Object[] {
				sampleSBModelImpl.getCompanyId(), sampleSBModelImpl.getUserId(),
				sampleSBModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByC_U_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByC_U_S, args);

			args = new Object[] {
				sampleSBModelImpl.getGroupId(), sampleSBModelImpl.getUserId(),
				sampleSBModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByG_U_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_U_S, args);

			args = new Object[] {
				sampleSBModelImpl.getUserId(), sampleSBModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByU_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByU_S, args);

			args = new Object[] {
				sampleSBModelImpl.getGroupId(), sampleSBModelImpl.getUrlTitle(),
				sampleSBModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByG_UT_ST, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_UT_ST, args);

			args = new Object[] {sampleSBModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {
				sampleSBModelImpl.getUserId(), sampleSBModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUserIdGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUserIdGroupId, args);

			args = new Object[] {sampleSBModelImpl.getUserId()};

			finderCache.removeResult(_finderPathCountByUserId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUserId, args);

			args = new Object[] {sampleSBModelImpl.getCompanyId()};

			finderCache.removeResult(_finderPathCountByCompanyId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCompanyId, args);

			args = new Object[] {sampleSBModelImpl.getSamplesbId()};

			finderCache.removeResult(_finderPathCountBySamplesbId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBySamplesbId, args);

			args = new Object[] {sampleSBModelImpl.getTitle()};

			finderCache.removeResult(_finderPathCountByTitle, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTitle, args);

			args = new Object[] {sampleSBModelImpl.isSamplesbBooleanStat()};

			finderCache.removeResult(
				_finderPathCountBySamplesbBooleanStat, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBySamplesbBooleanStat, args);

			args = new Object[] {sampleSBModelImpl.getSamplesbDateTime()};

			finderCache.removeResult(_finderPathCountBySamplesbDateTime, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBySamplesbDateTime, args);

			args = new Object[] {
				sampleSBModelImpl.getSamplesbDocumentLibrary()
			};

			finderCache.removeResult(
				_finderPathCountBySamplesbDocumentLibrary, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBySamplesbDocumentLibrary,
				args);

			args = new Object[] {sampleSBModelImpl.getSamplesbDouble()};

			finderCache.removeResult(_finderPathCountBySamplesbDouble, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBySamplesbDouble, args);

			args = new Object[] {sampleSBModelImpl.getSamplesbInteger()};

			finderCache.removeResult(_finderPathCountBySamplesbInteger, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBySamplesbInteger, args);

			args = new Object[] {sampleSBModelImpl.getSamplesbRichText()};

			finderCache.removeResult(_finderPathCountBySamplesbRichText, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBySamplesbRichText, args);

			args = new Object[] {sampleSBModelImpl.getSamplesbText()};

			finderCache.removeResult(_finderPathCountBySamplesbText, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBySamplesbText, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((sampleSBModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					sampleSBModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {sampleSBModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((sampleSBModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					sampleSBModelImpl.getOriginalUuid(),
					sampleSBModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					sampleSBModelImpl.getUuid(),
					sampleSBModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((sampleSBModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByC_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					sampleSBModelImpl.getOriginalCompanyId(),
					sampleSBModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByC_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByC_S, args);

				args = new Object[] {
					sampleSBModelImpl.getCompanyId(),
					sampleSBModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByC_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByC_S, args);
			}

			if ((sampleSBModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					sampleSBModelImpl.getOriginalGroupId(),
					sampleSBModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByG_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_S, args);

				args = new Object[] {
					sampleSBModelImpl.getGroupId(),
					sampleSBModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByG_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_S, args);
			}

			if ((sampleSBModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByC_U_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					sampleSBModelImpl.getOriginalCompanyId(),
					sampleSBModelImpl.getOriginalUserId(),
					sampleSBModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByC_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByC_U_S, args);

				args = new Object[] {
					sampleSBModelImpl.getCompanyId(),
					sampleSBModelImpl.getUserId(), sampleSBModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByC_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByC_U_S, args);
			}

			if ((sampleSBModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_U_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					sampleSBModelImpl.getOriginalGroupId(),
					sampleSBModelImpl.getOriginalUserId(),
					sampleSBModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByG_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_U_S, args);

				args = new Object[] {
					sampleSBModelImpl.getGroupId(),
					sampleSBModelImpl.getUserId(), sampleSBModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByG_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_U_S, args);
			}

			if ((sampleSBModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByU_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					sampleSBModelImpl.getOriginalUserId(),
					sampleSBModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByU_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByU_S, args);

				args = new Object[] {
					sampleSBModelImpl.getUserId(), sampleSBModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByU_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByU_S, args);
			}

			if ((sampleSBModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_UT_ST.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					sampleSBModelImpl.getOriginalGroupId(),
					sampleSBModelImpl.getOriginalUrlTitle(),
					sampleSBModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByG_UT_ST, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_UT_ST, args);

				args = new Object[] {
					sampleSBModelImpl.getGroupId(),
					sampleSBModelImpl.getUrlTitle(),
					sampleSBModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByG_UT_ST, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_UT_ST, args);
			}

			if ((sampleSBModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					sampleSBModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {sampleSBModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((sampleSBModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUserIdGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					sampleSBModelImpl.getOriginalUserId(),
					sampleSBModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByUserIdGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserIdGroupId, args);

				args = new Object[] {
					sampleSBModelImpl.getUserId(),
					sampleSBModelImpl.getGroupId()
				};

				finderCache.removeResult(_finderPathCountByUserIdGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserIdGroupId, args);
			}

			if ((sampleSBModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUserId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					sampleSBModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);

				args = new Object[] {sampleSBModelImpl.getUserId()};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);
			}

			if ((sampleSBModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCompanyId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					sampleSBModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByCompanyId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompanyId, args);

				args = new Object[] {sampleSBModelImpl.getCompanyId()};

				finderCache.removeResult(_finderPathCountByCompanyId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompanyId, args);
			}

			if ((sampleSBModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBySamplesbId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					sampleSBModelImpl.getOriginalSamplesbId()
				};

				finderCache.removeResult(_finderPathCountBySamplesbId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySamplesbId, args);

				args = new Object[] {sampleSBModelImpl.getSamplesbId()};

				finderCache.removeResult(_finderPathCountBySamplesbId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySamplesbId, args);
			}

			if ((sampleSBModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTitle.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					sampleSBModelImpl.getOriginalTitle()
				};

				finderCache.removeResult(_finderPathCountByTitle, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTitle, args);

				args = new Object[] {sampleSBModelImpl.getTitle()};

				finderCache.removeResult(_finderPathCountByTitle, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTitle, args);
			}

			if ((sampleSBModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBySamplesbBooleanStat.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					sampleSBModelImpl.getOriginalSamplesbBooleanStat()
				};

				finderCache.removeResult(
					_finderPathCountBySamplesbBooleanStat, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySamplesbBooleanStat,
					args);

				args = new Object[] {sampleSBModelImpl.isSamplesbBooleanStat()};

				finderCache.removeResult(
					_finderPathCountBySamplesbBooleanStat, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySamplesbBooleanStat,
					args);
			}

			if ((sampleSBModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBySamplesbDateTime.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					sampleSBModelImpl.getOriginalSamplesbDateTime()
				};

				finderCache.removeResult(
					_finderPathCountBySamplesbDateTime, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySamplesbDateTime, args);

				args = new Object[] {sampleSBModelImpl.getSamplesbDateTime()};

				finderCache.removeResult(
					_finderPathCountBySamplesbDateTime, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySamplesbDateTime, args);
			}

			if ((sampleSBModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBySamplesbDocumentLibrary.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					sampleSBModelImpl.getOriginalSamplesbDocumentLibrary()
				};

				finderCache.removeResult(
					_finderPathCountBySamplesbDocumentLibrary, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySamplesbDocumentLibrary,
					args);

				args = new Object[] {
					sampleSBModelImpl.getSamplesbDocumentLibrary()
				};

				finderCache.removeResult(
					_finderPathCountBySamplesbDocumentLibrary, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySamplesbDocumentLibrary,
					args);
			}

			if ((sampleSBModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBySamplesbDouble.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					sampleSBModelImpl.getOriginalSamplesbDouble()
				};

				finderCache.removeResult(
					_finderPathCountBySamplesbDouble, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySamplesbDouble, args);

				args = new Object[] {sampleSBModelImpl.getSamplesbDouble()};

				finderCache.removeResult(
					_finderPathCountBySamplesbDouble, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySamplesbDouble, args);
			}

			if ((sampleSBModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBySamplesbInteger.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					sampleSBModelImpl.getOriginalSamplesbInteger()
				};

				finderCache.removeResult(
					_finderPathCountBySamplesbInteger, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySamplesbInteger, args);

				args = new Object[] {sampleSBModelImpl.getSamplesbInteger()};

				finderCache.removeResult(
					_finderPathCountBySamplesbInteger, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySamplesbInteger, args);
			}

			if ((sampleSBModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBySamplesbRichText.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					sampleSBModelImpl.getOriginalSamplesbRichText()
				};

				finderCache.removeResult(
					_finderPathCountBySamplesbRichText, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySamplesbRichText, args);

				args = new Object[] {sampleSBModelImpl.getSamplesbRichText()};

				finderCache.removeResult(
					_finderPathCountBySamplesbRichText, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySamplesbRichText, args);
			}

			if ((sampleSBModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBySamplesbText.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					sampleSBModelImpl.getOriginalSamplesbText()
				};

				finderCache.removeResult(_finderPathCountBySamplesbText, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySamplesbText, args);

				args = new Object[] {sampleSBModelImpl.getSamplesbText()};

				finderCache.removeResult(_finderPathCountBySamplesbText, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySamplesbText, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, SampleSBImpl.class, sampleSB.getPrimaryKey(),
			sampleSB, false);

		clearUniqueFindersCache(sampleSBModelImpl, false);
		cacheUniqueFindersCache(sampleSBModelImpl);

		sampleSB.resetOriginalValues();

		return sampleSB;
	}

	/**
	 * Returns the sample sb with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sample sb
	 * @return the sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	@Override
	public SampleSB findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSampleSBException {

		SampleSB sampleSB = fetchByPrimaryKey(primaryKey);

		if (sampleSB == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSampleSBException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return sampleSB;
	}

	/**
	 * Returns the sample sb with the primary key or throws a <code>NoSuchSampleSBException</code> if it could not be found.
	 *
	 * @param samplesbId the primary key of the sample sb
	 * @return the sample sb
	 * @throws NoSuchSampleSBException if a sample sb with the primary key could not be found
	 */
	@Override
	public SampleSB findByPrimaryKey(long samplesbId)
		throws NoSuchSampleSBException {

		return findByPrimaryKey((Serializable)samplesbId);
	}

	/**
	 * Returns the sample sb with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param samplesbId the primary key of the sample sb
	 * @return the sample sb, or <code>null</code> if a sample sb with the primary key could not be found
	 */
	@Override
	public SampleSB fetchByPrimaryKey(long samplesbId) {
		return fetchByPrimaryKey((Serializable)samplesbId);
	}

	/**
	 * Returns all the sample sbs.
	 *
	 * @return the sample sbs
	 */
	@Override
	public List<SampleSB> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SampleSB> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<SampleSB> findAll(
		int start, int end, OrderByComparator<SampleSB> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<SampleSB> findAll(
		int start, int end, OrderByComparator<SampleSB> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<SampleSB> list = null;

		if (useFinderCache) {
			list = (List<SampleSB>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SAMPLESB);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SAMPLESB;

				sql = sql.concat(SampleSBModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SampleSB>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the sample sbs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SampleSB sampleSB : findAll()) {
			remove(sampleSB);
		}
	}

	/**
	 * Returns the number of sample sbs.
	 *
	 * @return the number of sample sbs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SAMPLESB);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "samplesbId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SAMPLESB;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SampleSBModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sample sb persistence.
	 */
	@Activate
	public void activate() {
		SampleSBModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		SampleSBModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			SampleSBModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			SampleSBModelImpl.UUID_COLUMN_BITMASK |
			SampleSBModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			SampleSBModelImpl.UUID_COLUMN_BITMASK |
			SampleSBModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByC_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByC_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			SampleSBModelImpl.COMPANYID_COLUMN_BITMASK |
			SampleSBModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByC_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_S",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationCountByC_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_S",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			SampleSBModelImpl.GROUPID_COLUMN_BITMASK |
			SampleSBModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationCountByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByC_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByC_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			SampleSBModelImpl.COMPANYID_COLUMN_BITMASK |
			SampleSBModelImpl.USERID_COLUMN_BITMASK |
			SampleSBModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByC_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationCountByC_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationFindByG_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			SampleSBModelImpl.GROUPID_COLUMN_BITMASK |
			SampleSBModelImpl.USERID_COLUMN_BITMASK |
			SampleSBModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByG_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationCountByG_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByG_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationFindByU_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByU_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			SampleSBModelImpl.USERID_COLUMN_BITMASK |
			SampleSBModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByU_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_S",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationCountByU_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByU_S",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByG_UT_ST = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_UT_ST",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_UT_ST = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_UT_ST",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			},
			SampleSBModelImpl.GROUPID_COLUMN_BITMASK |
			SampleSBModelImpl.URLTITLE_COLUMN_BITMASK |
			SampleSBModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByG_UT_ST = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_UT_ST",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationCountByG_UT_ST = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByG_UT_ST",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			});

		_finderPathFetchByG_UT = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_UT",
			new String[] {Long.class.getName(), String.class.getName()},
			SampleSBModelImpl.GROUPID_COLUMN_BITMASK |
			SampleSBModelImpl.URLTITLE_COLUMN_BITMASK);

		_finderPathCountByG_UT = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_UT",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathFetchByURLTitle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByURLTitle",
			new String[] {String.class.getName()},
			SampleSBModelImpl.URLTITLE_COLUMN_BITMASK);

		_finderPathCountByURLTitle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByURLTitle",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			SampleSBModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByUserIdGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIdGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUserIdGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserIdGroupId",
			new String[] {Long.class.getName(), Long.class.getName()},
			SampleSBModelImpl.USERID_COLUMN_BITMASK |
			SampleSBModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUserIdGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserIdGroupId",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()},
			SampleSBModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCompanyId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCompanyId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] {Long.class.getName()},
			SampleSBModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByCompanyId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindBySamplesbId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySamplesbId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBySamplesbId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySamplesbId",
			new String[] {Long.class.getName()},
			SampleSBModelImpl.SAMPLESBID_COLUMN_BITMASK);

		_finderPathCountBySamplesbId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySamplesbId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByTitle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTitle",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTitle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTitle",
			new String[] {String.class.getName()},
			SampleSBModelImpl.TITLE_COLUMN_BITMASK);

		_finderPathCountByTitle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTitle",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindBySamplesbBooleanStat = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySamplesbBooleanStat",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBySamplesbBooleanStat = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySamplesbBooleanStat", new String[] {Boolean.class.getName()},
			SampleSBModelImpl.SAMPLESBBOOLEANSTAT_COLUMN_BITMASK);

		_finderPathCountBySamplesbBooleanStat = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySamplesbBooleanStat",
			new String[] {Boolean.class.getName()});

		_finderPathWithPaginationFindBySamplesbDateTime = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySamplesbDateTime",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBySamplesbDateTime = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySamplesbDateTime",
			new String[] {Date.class.getName()},
			SampleSBModelImpl.SAMPLESBDATETIME_COLUMN_BITMASK);

		_finderPathCountBySamplesbDateTime = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySamplesbDateTime", new String[] {Date.class.getName()});

		_finderPathWithPaginationFindBySamplesbDocumentLibrary = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBySamplesbDocumentLibrary",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBySamplesbDocumentLibrary =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBySamplesbDocumentLibrary",
				new String[] {String.class.getName()},
				SampleSBModelImpl.SAMPLESBDOCUMENTLIBRARY_COLUMN_BITMASK);

		_finderPathCountBySamplesbDocumentLibrary = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySamplesbDocumentLibrary",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindBySamplesbDouble = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySamplesbDouble",
			new String[] {
				Double.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBySamplesbDouble = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySamplesbDouble",
			new String[] {Double.class.getName()},
			SampleSBModelImpl.SAMPLESBDOUBLE_COLUMN_BITMASK);

		_finderPathCountBySamplesbDouble = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySamplesbDouble",
			new String[] {Double.class.getName()});

		_finderPathWithPaginationFindBySamplesbInteger = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySamplesbInteger",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBySamplesbInteger = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySamplesbInteger",
			new String[] {Integer.class.getName()},
			SampleSBModelImpl.SAMPLESBINTEGER_COLUMN_BITMASK);

		_finderPathCountBySamplesbInteger = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySamplesbInteger",
			new String[] {Integer.class.getName()});

		_finderPathWithPaginationFindBySamplesbRichText = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySamplesbRichText",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBySamplesbRichText = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySamplesbRichText",
			new String[] {String.class.getName()},
			SampleSBModelImpl.SAMPLESBRICHTEXT_COLUMN_BITMASK);

		_finderPathCountBySamplesbRichText = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySamplesbRichText", new String[] {String.class.getName()});

		_finderPathWithPaginationFindBySamplesbText = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySamplesbText",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBySamplesbText = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SampleSBImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySamplesbText",
			new String[] {String.class.getName()},
			SampleSBModelImpl.SAMPLESBTEXT_COLUMN_BITMASK);

		_finderPathCountBySamplesbText = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySamplesbText",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(SampleSBImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = SampleSBPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.liferay.sb.test.model.SampleSB"),
			true);
	}

	@Override
	@Reference(
		target = SampleSBPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = SampleSBPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_SAMPLESB =
		"SELECT sampleSB FROM SampleSB sampleSB";

	private static final String _SQL_SELECT_SAMPLESB_WHERE =
		"SELECT sampleSB FROM SampleSB sampleSB WHERE ";

	private static final String _SQL_COUNT_SAMPLESB =
		"SELECT COUNT(sampleSB) FROM SampleSB sampleSB";

	private static final String _SQL_COUNT_SAMPLESB_WHERE =
		"SELECT COUNT(sampleSB) FROM SampleSB sampleSB WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"sampleSB.samplesbId";

	private static final String _FILTER_SQL_SELECT_SAMPLESB_WHERE =
		"SELECT DISTINCT {sampleSB.*} FROM SampleSB_SampleSB sampleSB WHERE ";

	private static final String
		_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {SampleSB_SampleSB.*} FROM (SELECT DISTINCT sampleSB.samplesbId FROM SampleSB_SampleSB sampleSB WHERE ";

	private static final String
		_FILTER_SQL_SELECT_SAMPLESB_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN SampleSB_SampleSB ON TEMP_TABLE.samplesbId = SampleSB_SampleSB.samplesbId";

	private static final String _FILTER_SQL_COUNT_SAMPLESB_WHERE =
		"SELECT COUNT(DISTINCT sampleSB.samplesbId) AS COUNT_VALUE FROM SampleSB_SampleSB sampleSB WHERE ";

	private static final String _FILTER_ENTITY_ALIAS = "sampleSB";

	private static final String _FILTER_ENTITY_TABLE = "SampleSB_SampleSB";

	private static final String _ORDER_BY_ENTITY_ALIAS = "sampleSB.";

	private static final String _ORDER_BY_ENTITY_TABLE = "SampleSB_SampleSB.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SampleSB exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SampleSB exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SampleSBPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(SampleSBPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}