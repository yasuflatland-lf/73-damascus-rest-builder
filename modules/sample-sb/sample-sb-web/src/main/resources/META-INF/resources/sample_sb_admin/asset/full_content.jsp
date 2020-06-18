<%--  --%>
<%--  --%>
<%--  --%>

<%@ include file="../init.jsp" %>

<jsp:useBean id="sampleSB" scope="request" type="com.liferay.sb.test.model.SampleSB" />

<portlet:defineObjects />

<%--  --%>
<%= sampleSB.getSamplesbTitleName()
<%--  --%>