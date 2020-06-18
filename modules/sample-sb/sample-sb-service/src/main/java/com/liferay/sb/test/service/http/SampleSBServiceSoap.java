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

package com.liferay.sb.test.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.sb.test.service.SampleSBServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>SampleSBServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.sb.test.model.SampleSBSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.sb.test.model.SampleSB</code>, that is translated to a
 * <code>com.liferay.sb.test.model.SampleSBSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author "yasuflatland"
 * @see SampleSBServiceHttp
 * @generated
 */
public class SampleSBServiceSoap {

	/**
	 * Add Entry
	 *
	 * @param orgEntry       SampleSB model
	 * @param serviceContext ServiceContext
	 * @exception PortalException
	 * @exception SampleSBValidateException
	 * @return created SampleSB model.
	 */
	public static com.liferay.sb.test.model.SampleSBSoap addEntry(
			com.liferay.sb.test.model.SampleSBSoap orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.sb.test.model.SampleSB returnValue =
				SampleSBServiceUtil.addEntry(
					com.liferay.sb.test.model.impl.SampleSBModelImpl.toModel(
						orgEntry),
					serviceContext);

			return com.liferay.sb.test.model.SampleSBSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Delete Entry
	 *
	 * @param primaryKey
	 * @return SampleSB
	 * @throws PortalException
	 */
	public static void deleteEntry(long primaryKey) throws RemoteException {
		try {
			SampleSBServiceUtil.deleteEntry(primaryKey);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return ServiceContext serviceContext
	 * @throws PrincipalException
	 * @throws PortletException
	 */
	public static com.liferay.sb.test.model.SampleSBSoap getNewObject(
			long primaryKey,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.sb.test.model.SampleSB returnValue =
				SampleSBServiceUtil.getNewObject(primaryKey, serviceContext);

			return com.liferay.sb.test.model.SampleSBSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Returns the samplesb with the primary key.
	 *
	 * @param samplesbId the primary key of the sample sb
	 * @return the samplesb
	 * @throws PortalException if a samplesb with the primary key could not be found
	 */
	public static com.liferay.sb.test.model.SampleSBSoap getSampleSB(
			long primaryKey)
		throws RemoteException {

		try {
			com.liferay.sb.test.model.SampleSB returnValue =
				SampleSBServiceUtil.getSampleSB(primaryKey);

			return com.liferay.sb.test.model.SampleSBSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Returns the samplesb
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	public static com.liferay.sb.test.model.SampleSBSoap getSampleSB(
			long groupId, String urlTitle)
		throws RemoteException {

		try {
			com.liferay.sb.test.model.SampleSB returnValue =
				SampleSBServiceUtil.getSampleSB(groupId, urlTitle);

			return com.liferay.sb.test.model.SampleSBSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Move an entry to the trush can
	 *
	 * @param userId
	 * @param entryId
	 * @return SampleSB
	 * @throws PortalException
	 */
	public static com.liferay.sb.test.model.SampleSBSoap moveEntryToTrash(
			long entryId)
		throws RemoteException {

		try {
			com.liferay.sb.test.model.SampleSB returnValue =
				SampleSBServiceUtil.moveEntryToTrash(entryId);

			return com.liferay.sb.test.model.SampleSBSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Edit Entry
	 *
	 * @param orgEntry       SampleSB model
	 * @param serviceContext ServiceContext
	 * @exception PortalException
	 * @exception SampleSBValidateException
	 * @return updated SampleSB model.
	 */
	public static com.liferay.sb.test.model.SampleSBSoap updateEntry(
			com.liferay.sb.test.model.SampleSBSoap orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.sb.test.model.SampleSB returnValue =
				SampleSBServiceUtil.updateEntry(
					com.liferay.sb.test.model.impl.SampleSBModelImpl.toModel(
						orgEntry),
					serviceContext);

			return com.liferay.sb.test.model.SampleSBSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SampleSBServiceSoap.class);

}