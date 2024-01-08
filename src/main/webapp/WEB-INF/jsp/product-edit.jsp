<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Spring MVC Hibernate - CRUD</title>
<style type="text/css">
body {
	font-family: Arial;
	font-size: 10px;
	margin: 30px;
}

.userTable, .userTable td {
	border-collapse: collapse;
	border: 1px solid #0000FF;
	margin: 2px;
	padding: 2px 2px 2px 10px;
	font-size: 14px;
}

.userTable th {
	font-weight: bold;
	font-size: 14px;
	background-color: #5C82FF;
	color: white;
}

.userLabel {
	font-family: Arial;
	font-size: 14px;
	font-weight: bold;
}

a, a:AFTER {
	color: blue;
}
</style>
</head>
<body>

	<h2>Product Edit</h2>
	<p style="color: green; font-weight: bold;">
		<a href="<c:url value='/products' />"> Add New Product</a>
	</p>
	<c:url var="action" value="/product/${product.itemCode}"></c:url>
	<form:form method="post" action="${action}" modelAttribute="product">
		<table>
			<tr>
				<td><form:label path="itemCode" cssClass="userLabel">
						<spring:message code="label.ItemCode" />
					</form:label></td>

				<td>
	            <form:input path="itemCode" readonly="true" size="8"  disabled="true" />
	           	<form:input path="itemCode" type="hidden"/>
				</td>
			</tr>
			<tr>
				<td><form:label path="price" cssClass="userLabel">
						<spring:message code="label.Price" />
					</form:label></td>

				<td><form:input path="price" /></td>
			</tr>

			<tr>
				<td><form:label path="description" cssClass="userLabel">
						<spring:message code="label.Description" />
					</form:label></td>

				<td><form:input path="description" /></td>
			</tr>

			<tr>
				<td><form:label path="type" cssClass="userLabel">
						<spring:message code="label.Type" />
					</form:label></td>

				<td><form:input path="type" /></td>
			</tr>

			<tr>
				<td><form:label path="tax" cssClass="userLabel">
						<spring:message code="label.Taxable" />
					</form:label></td>

				<td><form:radiobutton path="tax" value="0"/> Yes <form:radiobutton path="tax" value="-1"/> No</td>
				
			</tr>

			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message code="label.Edit"/>" /></td>
			</tr>

		</table>
	</form:form>

</body>
</html>