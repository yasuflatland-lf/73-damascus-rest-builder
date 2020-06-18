// 
//  //
/**
*  Copyright (C) 2020 Yasuyuki Takeo All rights reserved.
*
*  This program is free software: you can redistribute it and/or modify
*  it under the terms of the GNU Lesser General Public License as published by
*  the Free Software Foundation, either version 3 of the License, or
*  (at your option) any later version.
*
*  This program is distributed in the hope that it will be useful,
*  but WITHOUT ANY WARRANTY; without even the implied warranty of
*  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
*  GNU Lesser General Public License for more details.
*/
//  //
package com.liferay.sb.test.web.portlet.action;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchContainerResults;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.sb.test.constants.SampleSBPortletKeys;
import com.liferay.sb.test.model.SampleSB;
import com.liferay.sb.test.web.util.SampleSBViewHelper;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.LinkedList;
import java.util.List;

import javax.portlet.PortletPreferences;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Export Resource Command
 *
 * @author Softbless
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SampleSBPortletKeys.SAMPLESB,
		"javax.portlet.name=" + SampleSBPortletKeys.SAMPLESB_ADMIN,
		"mvc.command.name=/samplesb/export"
	},
	service = MVCResourceCommand.class
)
public class SampleSBExportMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD, "");
		
//  //
		if (!cmd.equals(Constants.EXPORT)) {
			return false;
		}

		SampleSBConfiguration sampleSBConfiguration =
			(SampleSBConfiguration)resourceRequest.getAttribute(
				SampleSBConfiguration.class.getName());

		PortletPreferences portletPreferences =
			resourceRequest.getPreferences();

		String dateFormatVal = HtmlUtil.escape(
			portletPreferences.getValue(
				"dateFormat",
				Validator.isNull(sampleSBConfiguration) ? "yyyy/MM/dd" :
				sampleSBConfiguration.dateFormat()));

		SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatVal);

		String keywords = ParamUtil.getString(
			resourceRequest, DisplayTerms.KEYWORDS);
		String orderByCol = ParamUtil.getString(
			resourceRequest, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM,
			"samplesbId");
		String orderByType = ParamUtil.getString(
			resourceRequest, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM,
			"asc");

		String filename = Constants.EXPORT;

		SearchContainerResults<SampleSB> searchContainerResults = null;

		try {
			if (Validator.isNull(keywords)) {
				searchContainerResults = _sampleSBViewHelper.getListFromDB(
					resourceRequest, -1, -1, orderByCol, orderByType,
					new int[] {WorkflowConstants.STATUS_APPROVED});
			}
			else {
				searchContainerResults = _sampleSBViewHelper.getListFromIndex(
					resourceRequest, -1, -1, WorkflowConstants.STATUS_APPROVED);
			}
		}
		catch (ParseException | SearchException e) {
			e.printStackTrace();
		}

		try (Workbook workbook = new HSSFWorkbook()) {
			Sheet sheet = workbook.createSheet("data");

			List<String> headers = new LinkedList<>();

            headers.add("SamplesbId");
            headers.add("Title");
            headers.add("SamplesbBooleanStat");
            headers.add("SamplesbDateTime");
            headers.add("SamplesbDocumentLibrary");
            headers.add("SamplesbDouble");
            headers.add("SamplesbInteger");
            headers.add("SamplesbRichText");
            headers.add("SamplesbText");

			// Header

			Row headerRow = sheet.createRow(0);

			for (int i = 0; i < headers.size(); i++) {
				Cell cell = headerRow.createCell(i);

				cell.setCellValue(headers.get(i));
			}

			if (Validator.isNotNull(searchContainerResults) &&
				(searchContainerResults.getTotal() > 0)) {

				List<SampleSB> datas = searchContainerResults.getResults();

				for (int i = 0; i < searchContainerResults.getTotal(); i++) {
					Row row = sheet.createRow(i + 1);

					for (int j = 0; j < headers.size(); j++) {
						Cell cell = row.createCell(j);
						switch (j) {
			            case 0:
								cell.setCellValue(datas.get(i).getSamplesbId());

								break;
			            case 1:
								cell.setCellValue(datas.get(i).getTitle());

								break;
			            case 2:
								cell.setCellValue(datas.get(i).getSamplesbBooleanStat());

								break;
			            case 3:
								cell.setCellValue(dateFormat.format(datas.get(i).getSamplesbDateTime()));

								break;
			            case 4:
								cell.setCellValue(datas.get(i).getSamplesbDocumentLibrary());

								break;
			            case 5:
								cell.setCellValue(datas.get(i).getSamplesbDouble());

								break;
			            case 6:
								cell.setCellValue(datas.get(i).getSamplesbInteger());

								break;
			            case 7:
								cell.setCellValue(datas.get(i).getSamplesbRichText());

								break;
			            case 8:
								cell.setCellValue(datas.get(i).getSamplesbText());

								break;
							default:

								break;
						}
					}
				}
			}

			resourceResponse.setContentType(
				ContentTypes.APPLICATION_VND_MS_EXCEL);
			resourceResponse.setProperty(
				"Content-Disposition",
				"attachment; filename=\"" + filename + ".xls\"");
			workbook.write(resourceResponse.getPortletOutputStream());

			return true;
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
// //
		
		return false;
	}

	@Reference(unbind = "-")
	public void setViewHelper(SampleSBViewHelper sampleSBViewHelper) {
		_sampleSBViewHelper = sampleSBViewHelper;
	}

	private SampleSBViewHelper _sampleSBViewHelper;

}