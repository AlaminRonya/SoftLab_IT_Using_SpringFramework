<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/18/2022
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Courses</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-9">
            <%--@elvariable id="coursesDTO" type=""--%>
            <form:form action="${pageContext.request.contextPath}/courses/insert" method="post" modelAttribute="coursesDTO" >
                <div class="form-group">
                    <label for="name">Name</label>
                    <form:input type="text" cssClass="form-control" id="name" placeholder="Course Name" path="courseName"/>
                </div>
                <button type="submit" class="btn btn-primary">Create</button>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
