<!DOCTYPE html>
<html>
<head>
<title>Blinkit Seller Panel</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap"
	rel="stylesheet">

<style>
body {
	font-family: 'Poppins', sans-serif;
	background: linear-gradient(to right, #00c853, #b2ff59);
	margin: 0;
	padding: 0;
}

.container {
	width: 420px;
	margin: 60px auto;
	padding: 30px;
	background: #fff;
	border-radius: 12px;
	box-shadow: 0 8px 20px rgba(0, 0, 0, 0.15);
}

h2 {
	text-align: center;
	color: #00c853;
	margin-bottom: 20px;
}

label {
	font-weight: 500;
	margin-top: 12px;
	display: block;
}

input[type="text"] {
	width: 100%;
	padding: 10px;
	margin-top: 5px;
	border-radius: 6px;
	border: 1px solid #ccc;
	transition: 0.3s;
}

input[type="text"]:focus {
	border-color: #00c853;
	outline: none;
	box-shadow: 0 0 5px rgba(0, 200, 83, 0.3);
}

textarea {
	width: 100%;
	padding: 10px;
	border-radius: 6px;
	border: 1px solid #ccc;
	margin-top: 5px;
}

.btn {
	width: 100%;
	padding: 12px;
	margin-top: 20px;
	background-color: #00c853;
	color: white;
	border: none;
	border-radius: 6px;
	font-size: 16px;
	cursor: pointer;
	transition: 0.3s;
}

.btn:hover {
	background-color: #00b248;
}

.secondary-btn {
	width: 100%;
	padding: 10px;
	margin-top: 10px;
	background-color: #f1f1f1;
	border: none;
	border-radius: 6px;
	cursor: pointer;
}

.secondary-btn:hover {
	background-color: #ddd;
}
</style>
</head>

<body>

	<div class="container">

		<h2>Blinkit Seller Panel</h2>

		<form action="uploadProduct" method="post">

			<label>Product Name</label> <input type="text" name="productName"
				placeholder="Enter product name" required>
				
		 <label>Quantity</label>
		<input type="text" name="qty" placeholder="Enter quantity" required>

			<label>Description</label>
			<textarea name="description" rows="3"
				placeholder="Enter product description" required></textarea>

			<label>Price </label>
			 <input type="text" name="price"placeholder="Enter price" required>
			 
			  <label>Sold By</label>
			   <input type="text" name="soldBy" placeholder="Seller name" required>

			<input type="submit" value="Upload Product" class="btn">

		</form>

		<a href="allProducts">
			<button class="secondary-btn">View All Products</button>
		</a>

	</div>

</body>
</html>