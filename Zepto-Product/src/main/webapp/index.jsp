<!DOCTYPE html>
<html>
<head>
    <title>Zepto Product Reseller</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
        }

        .container {
            width: 400px;
            margin: 50px auto;
            padding: 25px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            color: #333;
        }

        label {
            font-weight: bold;
            display: block;
            margin-top: 10px;
        }

        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-top: 20px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #218838;
        }
    </style>
</head>

<body>

    <div class="container">
        <h2>Zepto Product Reseller</h2>

        <form action="uploadProduct" method="post">

            <label>Product Name</label>
            <input type="text" name="productName" required>

            <label>Product Quantity</label>
            <input type="text" name="qty" required>

            <label>Product Description</label>
            <input type="text" name="description" required>

            <label>Product Price</label>
            <input type="text" name="price" required>

            <label>Sold By</label>
            <input type="text" name="soldBy" required>

            <input type="submit" value="Upload Product">

        </form>
        
        <a href = "allProducts">
        <button type="button"> show all details</button>
        
        </a>
        
    </div>

</body>
</html>