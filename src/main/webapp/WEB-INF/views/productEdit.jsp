<%--
  Created by IntelliJ IDEA.
  User: khiem
  Date: 24/01/2024
  Time: 3:50 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_navTop.jsp"></jsp:include>

    <section class="container">
        <h3>Edit Product</h3>
        <p style="color: red;">${errorString}</p>
        <c:if test="${empty product}">
            <a href="/productList">Quay lại</a>
        </c:if>
        <c:if test="${not empty product}">
            <form method="post" action="${pageContext.request.contextPath}/productEdit">
                <table class="table table-bordered">
                    <tr>
                        <td>Code</td>
                        <td><input type="text" name="code" value="${product.code}" readonly/></td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" name="name" value="${product.name}" /></td>
                    </tr>
                    <tr>
                        <td>Price</td>
                        <td><input type="text" name="price" value="${product.price}" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Ghi lại" class="btn btn-success" />
                            <a href="productList" class="btn btn-danger">Quay lại</a>
                        </td>
                    </tr>
                </table>
            </form>
        </c:if>
    </section>
    <jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
