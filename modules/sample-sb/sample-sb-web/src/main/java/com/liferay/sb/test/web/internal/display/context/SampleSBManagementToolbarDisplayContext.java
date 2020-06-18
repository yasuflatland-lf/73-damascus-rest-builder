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
package com.liferay.sb.test.web.internal.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItem;
import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.sb.test.web.internal.security.permission.resource.SampleSBPermission;
import com.liferay.trash.TrashHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.portlet.ActionRequest;
import javax.portlet.PortletURL;
import javax.portlet.ResourceURL;

import javax.servlet.http.HttpServletRequest;

/**
 * SampleSB Management Toolbar Display Context
 *
 * @author yasuflatland
 */
public class SampleSBManagementToolbarDisplayContext
	extends SearchContainerManagementToolbarDisplayContext {

	public SampleSBManagementToolbarDisplayContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		HttpServletRequest httpServletRequest,
		SearchContainer<?> searchContainer, TrashHelper trashHelper,
		String displayStyle) {

		super(
			liferayPortletRequest, liferayPortletResponse, httpServletRequest,
			searchContainer);

		_trashHelper = trashHelper;
		_displayStyle = displayStyle;

		_themeDisplay = (ThemeDisplay)httpServletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
	}

	/**
	 * Order Dropdown items
	 *
	 * @return
	 */
	public List<DropdownItem> _getOrderByDropdownItems() {
		return new DropdownItemList() {
			{
//  //
		add(
			dropdownItem -> {
				dropdownItem.setActive(
					Objects.equals(getOrderByCol(), "title"));
				dropdownItem.setHref(
					_getCurrentSortingURL(), "orderByCol", "title");
				dropdownItem.setLabel(
					LanguageUtil.get(request, "title"));
			});
		add(
			dropdownItem -> {
				dropdownItem.setActive(
					Objects.equals(getOrderByCol(), "samplesbBooleanStat"));
				dropdownItem.setHref(
					_getCurrentSortingURL(), "orderByCol", "samplesbBooleanStat");
				dropdownItem.setLabel(
					LanguageUtil.get(request, "samplesbBooleanStat"));
			});
		add(
			dropdownItem -> {
				dropdownItem.setActive(
					Objects.equals(getOrderByCol(), "samplesbDateTime"));
				dropdownItem.setHref(
					_getCurrentSortingURL(), "orderByCol", "samplesbDateTime");
				dropdownItem.setLabel(
					LanguageUtil.get(request, "samplesbDateTime"));
			});
		add(
			dropdownItem -> {
				dropdownItem.setActive(
					Objects.equals(getOrderByCol(), "samplesbDocumentLibrary"));
				dropdownItem.setHref(
					_getCurrentSortingURL(), "orderByCol", "samplesbDocumentLibrary");
				dropdownItem.setLabel(
					LanguageUtil.get(request, "samplesbDocumentLibrary"));
			});
		add(
			dropdownItem -> {
				dropdownItem.setActive(
					Objects.equals(getOrderByCol(), "samplesbDouble"));
				dropdownItem.setHref(
					_getCurrentSortingURL(), "orderByCol", "samplesbDouble");
				dropdownItem.setLabel(
					LanguageUtil.get(request, "samplesbDouble"));
			});
		add(
			dropdownItem -> {
				dropdownItem.setActive(
					Objects.equals(getOrderByCol(), "samplesbInteger"));
				dropdownItem.setHref(
					_getCurrentSortingURL(), "orderByCol", "samplesbInteger");
				dropdownItem.setLabel(
					LanguageUtil.get(request, "samplesbInteger"));
			});
		add(
			dropdownItem -> {
				dropdownItem.setActive(
					Objects.equals(getOrderByCol(), "samplesbRichText"));
				dropdownItem.setHref(
					_getCurrentSortingURL(), "orderByCol", "samplesbRichText");
				dropdownItem.setLabel(
					LanguageUtil.get(request, "samplesbRichText"));
			});
		add(
			dropdownItem -> {
				dropdownItem.setActive(
					Objects.equals(getOrderByCol(), "samplesbText"));
				dropdownItem.setHref(
					_getCurrentSortingURL(), "orderByCol", "samplesbText");
				dropdownItem.setLabel(
					LanguageUtil.get(request, "samplesbText"));
			});
//  //				
			}
		};
	}

	/**
	 * Action Items
	 */
	@Override
	public List<DropdownItem> getActionDropdownItems() {
		return new DropdownItemList() {
			{

				// Delete action

				add(
					dropdownItem -> {
						dropdownItem.putData("action", "deleteEntries");
						dropdownItem.setHref(
							"javascript:" +
								liferayPortletResponse.getNamespace() +
									"deleteEntries();");

						boolean trashEnabled = _trashHelper.isTrashEnabled(
							_themeDisplay.getScopeGroupId());

						dropdownItem.setIcon(
							trashEnabled ? "trash" : "times-circle");

						String label = "delete";

						if (trashEnabled) {
							label = "move-to-recycle-bin";
						}

						dropdownItem.setLabel(LanguageUtil.get(request, label));

						dropdownItem.setQuickAction(true);
					});
//  //
				// Export Action

				add(
					dropdownItem -> {
						dropdownItem.setHref(_getExportResourceURL());

						dropdownItem.setIcon("download");

						dropdownItem.setLabel(
							LanguageUtil.get(request, "download"));

						dropdownItem.setQuickAction(true);
					});
//  //				
			}
		};
	}

	@Override
	public String getClearResultsURL() {
		return getSearchActionURL();
	}

	public Map<String, Object> getComponentContext() throws PortalException {
		Map<String, Object> context = new HashMap<>();

		String cmd = Constants.DELETE;

		if (_trashHelper.isTrashEnabled(_themeDisplay.getScopeGroup())) {
			cmd = Constants.MOVE_TO_TRASH;
		}

		context.put(Constants.CMD, cmd);

		PortletURL deleteEntriesURL = liferayPortletResponse.createActionURL();

		deleteEntriesURL.setParameter(
			ActionRequest.ACTION_NAME, "/samplesb/crud");

		context.put("deleteEntryIds", deleteEntriesURL.toString());

		context.put(
			"trashEnabled",
			_trashHelper.isTrashEnabled(_themeDisplay.getScopeGroupId()));

		return context;
	}

	@Override
	public CreationMenu getCreationMenu() {
		if (!SampleSBPermission.contains(
				_themeDisplay.getPermissionChecker(),
				_themeDisplay.getScopeGroupId(), ActionKeys.ADD_ENTRY)) {

			return null;
		}

		return new CreationMenu() {
			{
				addDropdownItem(
					dropdownItem -> {
						dropdownItem.setHref(
							liferayPortletResponse.createRenderURL(),
							Constants.CMD, Constants.ADD,
							"mvcRenderCommandName", "/samplesb/crud",
							"redirect", currentURLObj.toString());
						dropdownItem.setLabel(
							LanguageUtil.get(request, "add-samplesb"));
					});
			}
		};
	}

	/**
	 * Returns the filter menu options.
	 *
	 * @return menu options list
	 */
	@Override
	public List<DropdownItem> getFilterDropdownItems() {
		return new DropdownItemList() {
			{
				addGroup(
					dropdownGroupItem -> {
						dropdownGroupItem.setDropdownItems(
							_getOrderByDropdownItems());
						dropdownGroupItem.setLabel(
							LanguageUtil.get(request, "order-by"));
					});
			}
		};
	}

	public String getOrderByType() {
		return searchContainer.getOrderByType();
	}

	@Override
	public String getSearchActionURL() {
		PortletURL searchURL = liferayPortletResponse.createRenderURL();

		searchURL.setParameter("mvcRenderCommandName", "/samplesb/view");

		String navigation = ParamUtil.getString(
			request, "navigation", "entries");

		searchURL.setParameter("navigation", navigation);

		searchURL.setParameter("orderByCol", getOrderByCol());
		searchURL.setParameter("orderByType", getOrderByType());

		return searchURL.toString();
	}

	@Override
	public String getSortingURL() {
		PortletURL sortingURL = _getCurrentSortingURL();

		sortingURL.setParameter(
			"orderByType",
			Objects.equals(getOrderByType(), "asc") ? "desc" : "asc");

		return sortingURL.toString();
	}

	@Override
	public List<ViewTypeItem> getViewTypeItems() {
		return null;

		// TODO : Configure if you need to switch view type

		//		return new ViewTypeItemList(getPortletURL(), getDisplayStyle()) {

		//			{
		//				if (ArrayUtil.contains(getDisplayViews(), "icon")) {
		//					addCardViewTypeItem();
		//				}
		//
		//				if (ArrayUtil.contains(getDisplayViews(), "descriptive")) {
		//					addListViewTypeItem();
		//				}
		//
		//				if (ArrayUtil.contains(getDisplayViews(), "list")) {
		//					addTableViewTypeItem();
		//				}
		//			}
		//		};

	}

	/**
	 * Export Resource URL
	 *
	 * @return Export resource URL
	 */
	protected String _getExportResourceURL() {
		String keywords = ParamUtil.getString(request, DisplayTerms.KEYWORDS);

		ResourceURL exportResourceURL =
			liferayPortletResponse.createResourceURL(
				_themeDisplay.getPortletDisplay(
				).getId());

		exportResourceURL.setParameter(Constants.CMD, Constants.EXPORT);
		exportResourceURL.setParameter(DisplayTerms.KEYWORDS, keywords);
		exportResourceURL.setResourceID("/samplesb/export");
		exportResourceURL.setParameter(
			SearchContainer.DEFAULT_ORDER_BY_COL_PARAM,
			searchContainer.getOrderByCol());
		exportResourceURL.setParameter(
			SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM,
			searchContainer.getOrderByType());

		return exportResourceURL.toString();
	}

	/**
	 * Search Sort URL
	 *
	 * @return Search filter URL string
	 */
	private PortletURL _getCurrentSortingURL() {
		String keywords = ParamUtil.getString(request, DisplayTerms.KEYWORDS);
		int cur = ParamUtil.getInteger(
			request, SearchContainer.DEFAULT_CUR_PARAM);
		int delta = ParamUtil.getInteger(
			request, SearchContainer.DEFAULT_DELTA_PARAM);
		String orderByCol = ParamUtil.getString(
			request, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM, "samplesbId");
		String orderByType = ParamUtil.getString(
			request, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM, "asc");

		PortletURL navigationPortletURL =
			liferayPortletResponse.createRenderURL();

		navigationPortletURL.setParameter(
			SearchContainer.DEFAULT_CUR_PARAM, String.valueOf(cur));
		navigationPortletURL.setParameter(
			"mvcRenderCommandName", "/samplesb/view");
		navigationPortletURL.setParameter(
			SearchContainer.DEFAULT_ORDER_BY_COL_PARAM, orderByCol);
		navigationPortletURL.setParameter(
			SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM, orderByType);

		if (Validator.isNotNull(keywords)) {
			navigationPortletURL.setParameter(DisplayTerms.KEYWORDS, keywords);
		}

		return navigationPortletURL;
	}

	private final String _displayStyle;
	private final ThemeDisplay _themeDisplay;
	private final TrashHelper _trashHelper;

}