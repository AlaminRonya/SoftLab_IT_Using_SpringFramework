<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/16/2022
  Time: 12:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
    </head>
    <body>
        <div class="container-fluid">
        <%--    <div class="row">--%>
        <%--        <div class="col-md-9">--%>
        <%--            &lt;%&ndash;@elvariable id="userDto" type=""&ndash;%&gt;--%>
        <%--            <form:form action="${pageContext.request.contextPath}/user/add" method="POST" modelAttribute="userDto" enctype="multipart/form-data">--%>
        <%--                <div class="form-group">--%>
        <%--                    <label for="name">Name</label>--%>
        <%--                    <form:input type="text" cssClass="form-control" id="name" placeholder="Name" path="name"/>--%>
        <%--                </div>--%>
        <%--                <br>--%>
        <%--                <input type="file" name="image" accept="image/*"/>--%>
        <%--                <button type="submit" class="btn btn-primary">Create</button>--%>
        <%--            </form:form>--%>
        <%--        </div>--%>
        <%--    </div>--%>

            <div class="container">
                <div class="col-sm-6">
                    <h3 style="margin-top: 10px">User Registration</h3>
                    <p>Please fill out this to register</p>
                    <%--@elvariable id="userDto" type=""--%>
                    <form:form action="${pageContext.request.contextPath}/user/add" method="POST" modelAttribute="userDto" enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="name">Name</label>
                            <form:input type="text" name="name" id="name" path="name"  placeholder="Your Name" class="form-control form-control-lg"/>
                        </div>

                        <div class="form-group">
                            <label for="email">Email address</label>
                            <form:input type="email" class="form-control form-control-lg" path="email" minlength="6" placeholder="Email" name="email" id="email"
                                   aria-describedby="emailHelp"/>
                            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <form:input type="password" class="form-control form-control-lg" path="password" placeholder="Password" name="password"
                                   id="password"/>
                        </div>
                        <div class="form-group">
                            <label>Favourite Languages :</label>
                            <c:forEach var="language" items="${languages}">
                                <br/><form:checkbox path="favLanguages" value="${language.getName()}" /> ${language.getName()}
                            </c:forEach>
                        </div>

                        <div class="form-group">
                            <form:label path="gender">Gender </form:label>
                            <form:radiobutton path="gender" value="Male"/>Male
                            <form:radiobutton path="gender" value="Female"/>Female
                        </div>
                        <div class="form-group">
                            <form:select cssClass="dropdown" path="course">
                                <form:option selected="true" value="Select Course" disabled="true"/>
                                <form:options items="${allCourses}"/>
                            </form:select>
                        </div>

<%--                        <br/>--%>
<%--                        <br/>--%>

                        <div class="form-group">
                            <label>Image Upload</label>
                            <input type="file" name="image" accept="image/*"/>
                        </div>
                        <button type="submit" class="btn btn-primary">Create</button>
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
