<%--  --%>
<%--  --%>
<%--  --%>
<%@ include file="./init.jsp" %>

<%
String iconChecked = "checked";
String iconUnchecked = "unchecked";
SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatVal);
SimpleDateFormat dateTimeFormat = new SimpleDateFormat(datetimeFormatVal);


SampleSBDisplayContext sampleSBDisplayContext = (SampleSBDisplayContext)request.getAttribute(SampleSBWebKeys.SAMPLESB_DISPLAY_CONTEXT);

String displayStyle = sampleSBDisplayContext.getDisplayStyle();
SearchContainer entriesSearchContainer = sampleSBDisplayContext.getSearchContainer();

PortletURL portletURL = entriesSearchContainer.getIteratorURL();

SampleSBManagementToolbarDisplayContext sampleSBManagementToolbarDisplayContext = new SampleSBManagementToolbarDisplayContext(liferayPortletRequest, liferayPortletResponse, request, entriesSearchContainer, trashHelper, displayStyle);
%>

<clay:management-toolbar
	actionDropdownItems="<%= sampleSBManagementToolbarDisplayContext.getActionDropdownItems() %>"
	clearResultsURL="<%= sampleSBManagementToolbarDisplayContext.getSearchActionURL() %>"
	componentId="sampleSBManagementToolbar"
	creationMenu="<%= sampleSBManagementToolbarDisplayContext.getCreationMenu() %>"
	disabled="<%= sampleSBManagementToolbarDisplayContext.isDisabled() %>"
	filterDropdownItems="<%= sampleSBManagementToolbarDisplayContext.getFilterDropdownItems() %>"
	itemsTotal="<%= sampleSBManagementToolbarDisplayContext.getItemsTotal() %>"
	searchActionURL="<%= sampleSBManagementToolbarDisplayContext.getSearchActionURL() %>"
	searchContainerId="sampleSB"
	searchFormName="fm"
	showSearch="true"
	sortingOrder="<%= sampleSBManagementToolbarDisplayContext.getOrderByType() %>"
	sortingURL="<%= sampleSBManagementToolbarDisplayContext.getSortingURL() %>"
/>

<portlet:actionURL name="/samplesb/crud" var="restoreTrashEntriesURL">
	<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.RESTORE %>" />
</portlet:actionURL>

<liferay-trash:undo
	portletURL="<%= restoreTrashEntriesURL %>"
/>

<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form action="<%= portletURL.toString() %>" method="get" name="fm">
		<aui:input name="<%= Constants.CMD %>" type="hidden" />
		<aui:input name="redirect" type="hidden" value="<%= portletURL.toString() %>" />
		<aui:input name="deleteEntryIds" type="hidden" />
		<aui:input name="selectAll" type="hidden" value="<%= false %>" />

		<liferay-ui:search-container
			emptyResultsMessage="no-record-was-found"
			id="sampleSB"
			rowChecker="<%= new EmptyOnClickRowChecker(renderResponse) %>"
			searchContainer="<%= entriesSearchContainer %>"
		>
			<liferay-ui:search-container-row
				className="com.liferay.sb.test.model.SampleSB"
				escapedModel="<%= true %>"
				keyProperty="samplesbId"
				modelVar="sampleSB"
			>
<%--  --%>
				<liferay-ui:search-container-column-text
					align="left"
					name="SamplesbId"
					orderable="true"
					orderableProperty="samplesbId"
					property="samplesbId"
				/>

				<liferay-ui:search-container-column-text
					align="left"
					name="Title"
					orderable="true"
					orderableProperty="title"
					property="title"
				/>

				<liferay-ui:search-container-column-text
					align="left"
					name="SamplesbBooleanStat"
					orderable="true"
					orderableProperty="samplesbBooleanStat"
					property="samplesbBooleanStat"
				/>

				<liferay-ui:search-container-column-text
					name="SamplesbDateTime"
					value="<%= dateFormat.format(sampleSB.getSamplesbDateTime()) %>"
					orderable="true"
					orderableProperty="samplesbDateTime"
					align="left"
				/>

				<liferay-ui:search-container-column-text
					align="left"
					name="SamplesbDocumentLibrary"
					orderable="true"
					orderableProperty="samplesbDocumentLibrary"
					property="samplesbDocumentLibrary"
				/>

				<liferay-ui:search-container-column-text
					align="left"
					name="SamplesbDouble"
					orderable="true"
					orderableProperty="samplesbDouble"
					property="samplesbDouble"
				/>

				<liferay-ui:search-container-column-text
					align="left"
					name="SamplesbInteger"
					orderable="true"
					orderableProperty="samplesbInteger"
					property="samplesbInteger"
				/>


				<liferay-ui:search-container-column-text name="SamplesbRichText"
														 align="center">
					<%
					String samplesbRichTextIcon = iconUnchecked;
					String samplesbRichText = sampleSB.getSamplesbRichText();
					if (!samplesbRichText.equals("")) {
						samplesbRichTextIcon= iconChecked;
					}
					%>
					<liferay-ui:icon image="<%= samplesbRichTextIcon %>" />
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text name="SamplesbText"
														 align="center">
					<%
					String samplesbTextIcon = iconUnchecked;
					String samplesbText = sampleSB.getSamplesbText();
					if (!samplesbText.equals("")) {
						samplesbTextIcon= iconChecked;
					}
					%>
					<liferay-ui:icon image="<%= samplesbTextIcon %>" />
				</liferay-ui:search-container-column-text>
<%--  --%>
				<liferay-ui:search-container-column-jsp
					align="right"
					path="/sample_sb/edit_actions.jsp"
				/>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator displayStyle="list" markupView="lexicon" />
		</liferay-ui:search-container>
	</aui:form>
</div>

<aui:script>
	function <portlet:namespace />deleteEntries() {
		if (<%=trashHelper.isTrashEnabled(scopeGroupId) %> || confirm('<%=UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-delete-the-selected-entries") %>')) {
			var form = AUI.$(document.<portlet:namespace />fm);

			form.attr('method', 'post');
			form.fm('<%=Constants.CMD%>').val('<%=trashHelper.isTrashEnabled(scopeGroupId) ? Constants.MOVE_TO_TRASH : Constants.DELETE%>');
			form.fm('deleteEntryIds').val(Liferay.Util.listCheckedExcept(form, '<portlet:namespace />allRowIds'));

			submitForm(form, '<portlet:actionURL name="/samplesb/crud" />');
		}
	}
</aui:script>
