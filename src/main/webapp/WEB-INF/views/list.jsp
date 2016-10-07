<%--
  Created by IntelliJ IDEA.
  User: twcn
  Date: 10/4/16
  Time: 11:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <!--
       SpringMVC处理静态请求：
       1. 为什么会有这样的问题：
          优雅的REST风格的资源URL不希望带.html 或 .do等后缀
          若将DispatcherServlet请求映射配置为/,
          则SpringMVC将捕获WEB容器的所有请求，包括静态资源，
          SpringMVC会将他们当成一个普通的请求处理，因找不到对应的处理器导致错误。
       2. 解决：
          在SpringMVC的配置文件中配置mvc:default-servlet-handler
    -->
    <script type="text/javascript" src="../../resources/scripts/jquery-1.9.1.min.js"></script>
    <!-- js不起作用 待解决！！！！！！！！！！！！-->
    <script type="text/javascript">
        $(".delete").click(function () {
            alert("hello");
            var href = $(this).attr("href");
            $("form").attr("action", href).submit();
            return false;
        })
    </script>
</head>

<body>

    <form action="" method="post">
        <input type="hidden" name="_method" value="DELETE"/>
    </form>

    <c:if test="${empty requestScope.employees}">
         没有任何员工信息。
    </c:if>
    <c:if test="${!empty requestScope.employees}">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <th>ID</th>
                <th>LastName</th>
                <th>Email</th>
                <th>Gender</th>
                <th>Department</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <c:forEach items="${requestScope.employees}" var="emp">
                <tr>
                    <td>${emp.id}</td>
                    <td>${emp.lastName}</td>
                    <td>${emp.email}</td>
                    <td>${emp.gender == 0 ? 'Femail' : 'Mail'}</td>
                    <td>${emp.department.departmentName}</td>
                    <td><a href="emp/${emp.id}">Edit</a></td>
                    <td><a class="delete" href="emp/${emp.id}">Delete</a></td><!--一般的超链接为get请求，filter只能将post请求转为delete,所以这里需要借助js-->
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <br><br>

    <a href="emp">Add new employee</a>

</body>
</html>
