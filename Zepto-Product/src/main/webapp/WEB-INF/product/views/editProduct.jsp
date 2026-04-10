<%@ page import="com.zepto.product.entity.ProductEntity" %>

<%
    ProductEntity product = (ProductEntity) request.getAttribute("product");
%>


<h2>Update Product Status</h2>

<form action="updateStatus" method="post">
    
    <input type="hidden" name="id" value="<%= product.getId() %>"/>

    <p>Product Name: <%= product.getName() %></p>

    <label>Status:</label>
    <select name="status">
        <option value="CREATED">CREATED</option>
        <option value="IN_PROGRESS">IN_PROGRESS</option>
        <option value="DELIVERED">DELIVERED</option>
    </select>

    <br><br>
    <button type="submit">Update</button>
</form>