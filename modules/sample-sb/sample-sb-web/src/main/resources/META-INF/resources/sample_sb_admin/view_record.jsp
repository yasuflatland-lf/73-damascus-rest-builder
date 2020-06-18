<%--  --%>
<%--  --%>
<%--  --%>
<%@ include file="./init.jsp" %>

<%
SampleSB sampleSB = (SampleSB)request.getAttribute("sampleSB");
String redirect = ParamUtil.getString(request, "redirect");
boolean fromAsset = ParamUtil.getBoolean(request, "fromAsset", false);
portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(redirect);

%>

<div class="container-fluid-1280 entry-body">
	<div class="lfr-form-content">
		<aui:fieldset-group markupView="lexicon">
			<aui:fieldset>
				<aui:fieldset>
<%--  --%>

			        <div class="form-group">
			            <h3><liferay-ui:message key="asset-title" /></h3>
			            <p class="form-control"><%=sampleSB.getSamplesbTitleName()%></p>
			        </div>
			        <div class="form-group">
			            <h3><liferay-ui:message key="asset-title" /></h3>
			            <p class="form-control"><%=sampleSB.getSamplesbSummaryName()%></p>
			        </div>

			    	<div class="form-group">
			            <h3><liferay-ui:message key="samplesb-samplesbId" /></h3>
						<p class="form-control"><%=sampleSB.getSamplesbId()%></p>
					</div>
			    	<div class="form-group">
			            <h3><liferay-ui:message key="samplesb-title" /></h3>
						<p class="form-control"><%=sampleSB.getTitle()%></p>
					</div>
			    	<div class="form-group">
			            <h3><liferay-ui:message key="samplesb-samplesbBooleanStat" /></h3>
						<p class="form-control"><%=sampleSB.getSamplesbBooleanStat()%></p>
					</div>
			    	<div class="form-group">
			            <h3><liferay-ui:message key="samplesb-samplesbDateTime" /></h3>
						<p class="form-control"><%=sampleSB.getSamplesbDateTime()%></p>
					</div>
			    	<div class="form-group">
			            <h3><liferay-ui:message key="samplesb-samplesbDocumentLibrary" /></h3>
						<p class="form-control"><%=sampleSB.getSamplesbDocumentLibrary()%></p>
					</div>
			    	<div class="form-group">
			            <h3><liferay-ui:message key="samplesb-samplesbDouble" /></h3>
						<p class="form-control"><%=sampleSB.getSamplesbDouble()%></p>
					</div>
			    	<div class="form-group">
			            <h3><liferay-ui:message key="samplesb-samplesbInteger" /></h3>
						<p class="form-control"><%=sampleSB.getSamplesbInteger()%></p>
					</div>
			    	<div class="form-group">
			            <h3><liferay-ui:message key="samplesb-samplesbRichText" /></h3>
						<p class="form-control"><%=sampleSB.getSamplesbRichText()%></p>
					</div>
			    	<div class="form-group">
			            <h3><liferay-ui:message key="samplesb-samplesbText" /></h3>
						<p class="form-control"><%=sampleSB.getSamplesbText()%></p>
					</div>
<%--  --%>
					
				</aui:fieldset>
			</aui:fieldset>
		</aui:fieldset-group>
	</div>
</div>