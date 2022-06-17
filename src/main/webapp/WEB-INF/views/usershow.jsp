<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/16/2022
  Time: 12:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">

</head>
<body >
<div class="container-fluid">
    <h1>${msg}</h1>
    <img src="<c:url value="/image-manual-response/${filename}"/>" alt="img" width="300" height="auto"/>
    <img src="<spring:url value='/image-manual-response/${filename}'/>" alt="img" width="300" height="auto"/>


    <%--    <img width="100" height="100" src="/getStudentPhoto/<c:out value='${filename}'/>"/>--%>
<%--    <img src="<spring:url value='/resources/images/${filename}'/>" height="100px" width="100px" style="object-fit: cover"/>--%>

<%--    Attachment Path: <img src="data:image/png;base64,${filename}" height="100px" width="100px" style="object-fit: cover"/> <br>--%>



    <%--    <img src="<c:url value="/resources/images/${filename}"/>" alt="Girl in a jacket" width="500" height="600">--%>
<%--    <img src="<c:url value="/resources/images/${filename}"/>" width="150" height="150" title="Testing"/>--%>

</div>

</body>
</html>
