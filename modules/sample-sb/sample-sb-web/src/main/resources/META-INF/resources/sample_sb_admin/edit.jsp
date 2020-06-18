<%--  --%>
<%--  --%>
<%--  --%>
<%@ include file="./init.jsp" %>

<%
PortletURL portletURL = PortletURLUtil.clone(renderResponse.createRenderURL(), liferayPortletResponse);
boolean fromAsset = ParamUtil.getBoolean(request, "fromAsset", false);
String CMD = ParamUtil.getString(request, Constants.CMD, Constants.UPDATE);
SampleSB sampleSB = (SampleSB)request.getAttribute("sampleSB");
String redirect = ParamUtil.getString(request, "redirect");
portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(redirect);

%>

<liferay-frontend:info-bar
	fixed="<%= true %>"
>
</liferay-frontend:info-bar>

<portlet:actionURL name="/samplesb/crud" var="samplesbEditURL">
	<portlet:param name="<%= Constants.CMD %>" value="<%= CMD %>" />
	<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
</portlet:actionURL>

<div class="container-fluid-1280 entry-body">
	<aui:form action="<%= samplesbEditURL %>" method="post" name="samplesbEdit">
		<aui:model-context bean="<%= sampleSB %>" model="<%= SampleSB.class %>" />
		<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= CMD %>" />
		<aui:input name="fromAsset" type="hidden" value="<%= fromAsset %>" />
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
		<aui:input name="resourcePrimKey" type="hidden" value="<%= sampleSB.getPrimaryKey() %>" />

		<div class="lfr-form-content">
			<aui:fieldset-group markupView="lexicon">
				<aui:fieldset>
					<c:if test="<%= Constants.ADD.equals(CMD) %>">
						<aui:input name="addGuestPermissions" type="hidden" value="true" />
						<aui:input name="addGroupPermissions" type="hidden" value="true" />
					</c:if>

<%--   --%>
						<liferay-ui:error key="duplicated-url-title"
												  message="duplicated-url-title" />
						<aui:input name="samplesbTitleName" label="title" />
						<aui:input name="samplesbSummaryName" label="summary" />
<%--  --%>

					<%
					String requiredLabel = "";
					%>

<%--   --%>

		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="samplesb-title-required"
						  message="samplesb-title-required" />

					<aui:input name="title" disabled="false"
						label='<%=LanguageUtil.get(request, "samplesb-title")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "";
		%>

					<aui:input name="samplesbBooleanStat" disabled="false"
						label='<%=LanguageUtil.get(request, "samplesb-samplesbbooleanstat")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "";
		%>

					<aui:input name="samplesbDateTime" disabled="false"
						label='<%=LanguageUtil.get(request, "samplesb-samplesbdatetime")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "";
		%>

					<aui:input name="samplesbDocumentLibrary" disabled="false"
						 readonly="true" type="text" label='<%=LanguageUtil.get(request,
						"samplesb-samplesbdocumentlibrary") + requiredLabel%>' />
					<%
					String samplesbDocumentLibraryClick = renderResponse.getNamespace() + "dlBrowse('samplesbDocumentLibrary Files select','" +
					renderResponse.getNamespace()+"samplesbDocumentLibrary')";
					%>

					<aui:button onClick="<%=samplesbDocumentLibraryClick%>" value="select" />
		<%
			requiredLabel = "";
		%>

					<aui:input name="samplesbDouble" disabled="false"
						label='<%=LanguageUtil.get(request, "samplesb-samplesbdouble")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "";
		%>

					<aui:input name="samplesbInteger" disabled="false"
						label='<%=LanguageUtil.get(request, "samplesb-samplesbinteger")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "";
		%>

					<aui:field-wrapper
						label="<%=LanguageUtil.get(request,\"samplesb-samplesbrichtext\") + requiredLabel%>">
						<liferay-ui:input-editor name="samplesbRichTextEditor"
												 initMethod="initsamplesbRichTextEditor" />
					</aui:field-wrapper>
					<aui:input disabled="false" name="samplesbRichText" type="hidden" />
		<%
			requiredLabel = "";
		%>

					<aui:input name="samplesbText" disabled="false"
						label='<%=LanguageUtil.get(request, "samplesb-samplesbtext")
						+ requiredLabel%>'
					/>
<%--  --%>

					<%
					if (sampleSB.getPrimaryKey() != 0) {
					%>

						<liferay-ui:ratings
							className="<%= SampleSB.class.getName() %>"
							classPK="<%= sampleSB.getPrimaryKey() %>"
							type="stars"
						/>

					<%
					}
					%>

					<aui:fieldset-group markupView="lexicon">
						<aui:fieldset collapsed="<%= true %>" collapsible="<%= true %>" label="categorization">
							<aui:input name="categories" type="assetCategories" />

							<aui:input name="tags" type="assetTags" />
						</aui:fieldset>
					</aui:fieldset-group>

					<%
					if (sampleSB.getPrimaryKey() != 0 && false == fromAsset) {
					%>

						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset collapsed="<%= true %>" collapsible="<%= true %>" label="related-assets">
								<liferay-asset:input-asset-links
									className="<%= SampleSB.class.getName() %>"
									classPK="<%= sampleSB.getPrimaryKey() %>"
								/>
							</aui:fieldset>
						</aui:fieldset-group>

					<%
					}
					%>

					<aui:button-row>

						<%
						String publishButtonLabel = "submit";
						%>

						<%
						if (WorkflowDefinitionLinkLocalServiceUtil
							.hasWorkflowDefinitionLink(themeDisplay.getCompanyId(), scopeGroupId, SampleSB.class.getName())) {

								publishButtonLabel = "submit-for-publication";
						}
						%>

						<aui:button
							cssClass="btn-lg"
							onClick='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveEditors();" %>'
							primary="<%= false %>"
							type="submit"
							value="<%= publishButtonLabel %>"
						/>

						<%
						if (!fromAsset) {
						%>

							&nbsp;&nbsp;&minus; <liferay-ui:message key="or" /> &minus;
							<aui:button onClick="<%= redirect %>" type="cancel" />

						<%
						}
						%>

					</aui:button-row>

				</aui:fieldset>
			</aui:fieldset-group>
		</div> <!-- lfr-form-content -->
	</aui:form>

	<%
	if (sampleSB.getPrimaryKey() != 0 && false == fromAsset) {
	%>

		<liferay-ui:panel-container
			extended="<%= false %>"
			id="sampleSBCommentsPanelContainer"
			persistState="<%= true %>"
		>
			<liferay-ui:panel
				collapsible="<%= true %>"
				extended="<%= true %>"
				id="sampleSBCommentsPanel"
				persistState="<%= true %>"
				title='<%= LanguageUtil.get(request, "comments") %>'
			>
				<portlet:actionURL name="invokeTaglibDiscussion" var="discussionURL" />

				<liferay-comment:discussion
					className="<%= SampleSB.class.getName() %>"
					classPK="<%= sampleSB.getPrimaryKey() %>"
					formName="fm2"
					ratingsEnabled="<%= true %>"
					redirect="<%= currentURL %>"
					userId="<%= sampleSB.getUserId() %>"
				/>
			</liferay-ui:panel>
		</liferay-ui:panel-container>

	<%
	}
	%>

</div>

<%--   --%>
<aui:script>
	function <portlet:namespace />initsamplesbRichTextEditor() {
		return '<%=UnicodeFormatter.toString(sampleSB.getSamplesbRichText())%>';
	}
</aui:script>
<%--  --%>

<aui:script>
	function <portlet:namespace />saveEditors() {
<%--   --%>
		document.<portlet:namespace />samplesbEdit.<portlet:namespace />samplesbRichText.value =
		window.<portlet:namespace />samplesbRichTextEditor.getHTML();
<%--  --%>
		submitForm(document.<portlet:namespace />samplesbEdit);
	}
</aui:script>

<%--   --%>
<%
SampleSBItemSelectorHelper sampleSBItemSelectorHelper = (SampleSBItemSelectorHelper)request
	.getAttribute(SampleSBWebKeys.SAMPLESB_ITEM_SELECTOR_HELPER);
RequestBackedPortletURLFactory requestBackedPortletURLFactory = RequestBackedPortletURLFactoryUtil
	.create(liferayPortletRequest);
String selectItemName = liferayPortletResponse.getNamespace()
		+ "selectItem";
%>

<aui:script>
	function <portlet:namespace />dlBrowse (title, inputField) {
		var itemSrc = $('#'+inputField);
		AUI().use(
			'liferay-item-selector-dialog',
			function(A) {
				var itemSelectorDialog = new A.LiferayItemSelectorDialog(
					{
						eventName: '<%= selectItemName %>',
						on: {
							selectedItemChange: function(event) {
								var selectedItem = event.newVal;

								if (selectedItem) {
									var itemValue = JSON.parse(
										selectedItem.value
									);
									itemSrc.val(itemValue.url);
								}
							}
						},
						title: title,
						url: '<%= sampleSBItemSelectorHelper.getItemSelectorURL(
						requestBackedPortletURLFactory, themeDisplay, selectItemName) %>'
					}
				);
				itemSelectorDialog.open();
			}
		);
	}
</aui:script>
<%--  --%>
