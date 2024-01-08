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
<script type="text/javascript">
    function deleteProduct(itemCode){
        if(confirm('Do you want to delete this Product ?')){
            var url = 'delete-product/'+itemCode;
            window.location.href = url;
        }
    }
    </script>
</head>
<body>

	<h2>SpringMVC-Hibernate CRUD Application</h2>
	<p style="color: green; font-weight: bold;">
		<a href="<c:url value='/products' />"> Add New Product</a>
	</p>
	<c:url var="action" value="/product/add"></c:url>
	<form:form method="post" action="${action}" modelAttribute="product">
		<table>

			<c:choose>
				<c:when test="${not empty product.itemCode}">
					<tr>
						<td><form:label path="itemCode" cssClass="userLabel">
								<spring:message code="label.ItemCode" />
							</form:label></td>
	
						<td><form:input path="itemCode" readonly="true" size="10"
								disabled="true" /> <form:hidden path="itemCode" /></td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td><form:label path="itemCode" cssClass="userLabel">
								<spring:message code="label.ItemCode" />
							</form:label></td>
		
						<td><form:input path="itemCode" /></td>
					</tr>
				</c:otherwise>
			</c:choose>

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
					value="<spring:message code="label.Add"/>" /></td>
			</tr>

		</table>
	</form:form>

	<h3>List of Products</h3>

	<c:if test="${not empty productList}">
		<table class="userTable">
			<tr>
				<th width="160">Item Code</th>
				<th width="60">Price</th>
				<th width="80">Description</th>
				<th width="60">Type</th>
				<th width="60">Tax</th>
				<th width="100">Action</th>
			</tr>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td><a href="<c:url value='/product/${product.itemCode}' />">${product.itemCode}</a>
					</td>
					<td>${product.price}</td>
					<td>${product.description}
					</td>
					<td>${product.type}</td>
					<c:choose>
						<c:when test="${product.tax == 0}">
							<td>Yes</td>		
						</c:when>
						<c:otherwise>
							<td>No</td>
						</c:otherwise>
					</c:choose>
					<td><a href="<c:url value='/product/${product.itemCode}' />"> <spring:message
								code="label.Show" /> >
					</a> <a href="#" onclick="javascript:deleteProduct(${product.itemCode})"> <spring:message
								code="label.Delete" /> >
					</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>