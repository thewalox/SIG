<%-- Prevencion del cache --%>
<%
    response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server
    response.setHeader("Cache-Control", "no-store");
%>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Resources/bootstrap/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Resources/css/login.css"/>

<script language="javascript" src="${pageContext.request.contextPath}/Resources/js/funciones.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/Resources/js/jquery.min.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/Resources/bootstrap/js/bootstrap.min.js"></script>

