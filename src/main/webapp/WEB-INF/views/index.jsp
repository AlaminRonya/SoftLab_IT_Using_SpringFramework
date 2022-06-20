<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/15/2022
  Time: 10:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
        <link href='https://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css'>

    </head>
    <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand 'Oswald', sans-serif !important text-capitalize font-weight-bold" href="#">
                Rejection is free learning
                <%--                <img th:src="@{/images/logo.png}"  src="../static/images/logo.png" width="auto" height="40" class="d-inline-block align-top" alt=""/>--%>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto"></ul>
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="${pageContext.request.contextPath}/" >Home</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link"  href="${pageContext.request.contextPath}/user/add">Add User</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link"  href="${pageContext.request.contextPath}/courses/insert">Add Course</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link"  href="${pageContext.request.contextPath}/language/insert">Add Language</a>
                    </li>
                </ul>

            </div>
        </div>
    </nav>
    <div class="container-fluid">
        <div class="container" style="margin-top: 30px">
            <div class="row">
                <div class="col">
                    <c:forEach var="userDto" items="${usersDto}">
                        <div class="card" style="margin-top: 20px">
                            <div class="row no-gutters">
                                <div class="col-sm-5 d-flex justify-content-center">
                                    <img class="" height="150px" width="150px" src="<c:url value="/image-manual-response/${userDto.getImagePath()}"/>" alt="${userDto.getImagePath()}">
                                </div>
                                <div class="col-sm-7 d-flex justify-content-center">
                                    <div class="card-body">
                                        <h5 class="card-title">${userDto.getName()}</h5>
                                        <h4>Email: <span>${userDto.getEmail()}</span></h4>
                                        <h4>Course Name: <span>${userDto.getCourse()}</span></h4>
                                        <h4>Skills: <span>${userDto.getFavLanguages()}</span></h4>
                                        <p>Gender: ${userDto.getGender()}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>
        </div>
    </div>


    </body>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>


</html>
