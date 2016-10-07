<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: twcn
  Date: 10/4/16
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.lang.*" %>
<html>
<head>
    <!--
        1. 为什么需要使用form标签？
          可以更快速开发表单页面，方便表单回显
        2. 通过modelAttribute属性指定绑定的属性，若没有指定该属性，则默认从request域对象中读取command的表单bean,
        如果该属性值也不存在，则发生错误。
        3. pageContext.request.contextPath 绝对路径
    -->
    <form:form action="${pageContext.request.contextPath}/emp" method="POST" modelAttribute="employee">
        <c:if test="${employee.id == null}">
            <!--path属性对应html表单标签的name属性值-->
            LastName: <form:input path="lastName"/>
        </c:if>
        <c:if test="${employee.id != null}">
            <form:hidden path="id"></form:hidden>
            <!--对于 _method 不能使用 form:hidden 标签, 因为 modelAttribute 对应的 bean 中没有 _method 这个属性 -->
            <%--<form:hidden path="_method" value="PUT"/>--%>
            <input type="hidden" name="_method" value="PUT"/>
        </c:if>

        <br>
        Email: <form:input path="email"/>
        <br>
        <%
            Map<String, String> genders = new HashMap();
            genders.put("1", "Male");
            genders.put("0", "Female");
            request.setAttribute("genders", genders);
        %>
        Gender: <br><form:radiobuttons path="gender" items="${genders}" delimiter="<br>"/>
        <br>
        Department: <form:select path="department.id"
                     items="${departments}" itemLabel="departmentName" itemValue="id"/>
        <br>
        <%--
        Birth: <form:input path="birth"></form:input>
        --%>
        <br>
        <input type="submit" value="submit"/>
    </form:form>
</head>
<body>

</body>
</html>
