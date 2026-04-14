<%@ page import="java.util.List"%>
<%@ page import="com.zepto.product.entity.ProductEntity"%>

<!DOCTYPE html>
<html>
<head>
<title>All Products</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f6f8;
	margin: 30px;
}

h2 {
	color: #333;
}

table {
	width: 100%;
	border-collapse: collapse;
	background: white;
	box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
}

th {
	background-color: #007bff;
	color: white;
	padding: 12px;
	text-align: left;
}

td {
	padding: 10px 12px;
	border-bottom: 1px solid #ddd;
	color: #333;
}

tr:hover {
	background-color: #f1f1f1;
}

.status {
	color: green;
	font-weight: bold;
}

.no-data {
	color: red;
	font-weight: bold;
	text-align: center;
}

.btn {
	display: inline-block;
	margin-top: 20px;
	padding: 10px 20px;
	background-color: #007bff;
	color: white;
	text-decoration: none;
	border-radius: 5px;
}
</style>
</head>
<body>

	<h2>📦 All Products</h2>

	<%
	List<ProductEntity> products = (List<ProductEntity>) request.getAttribute("products");

	if (products != null && !products.isEmpty()) {
	%>

	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Product ID</th>
				<th>Status</th>
				<th>Edit Status</th>
			</tr>
		</thead>
		<tbody>

			<%
			for (ProductEntity product : products) {
			%>
			<tr>
				<td><%=product.getId()%></td>

				<td><%=(product.getName() != null) ? product.getName() : "N/A"%>
				</td>

				<td><%=(product.getProductId() != null) ? product.getProductId() : "N/A"%>
				</td>

				<td class="status"><%=(product.getStatus() != null) ? product.getStatus() : "Pending"%>
				</td>

			<td>
        <a href="editProductStatus?id=<%= product.getId() %>" class="btn">Edit</a>
    </td>
			</tr>
			<%
			}
			%>

		</tbody>
	</table>

	<%
	} else {
	%>
	<p class="no-data">❌ No Products Available</p>
	<%
	}
	%>


</body>
</html>