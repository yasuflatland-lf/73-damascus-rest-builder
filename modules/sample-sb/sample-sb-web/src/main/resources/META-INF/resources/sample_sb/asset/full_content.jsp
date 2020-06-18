<%--  --%>
<%--  --%>
<%--  --%>
<%@ include file="/sample_sb/init.jsp" %>

<jsp:useBean id="sampleSB" scope="request" type="com.liferay.sb.test.model.SampleSB" />

<%--  --%>
<%= sampleSB.getSamplesbTitleName()
<%--  --%>