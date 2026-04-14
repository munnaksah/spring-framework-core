<%@ page import="com.zepto.product.entity.ProductEntity" %>

<%
    ProductEntity product = (ProductEntity) request.getAttribute("product");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Update Product Status</title>

    <!-- Bootstrap CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f5f7fa;
        }
        .card {
            margin-top: 50px;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }
    </style>
</head>

<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">

            <div class="card p-4">
                <h3 class="text-center mb-4">Update Product Status</h3>

                <form action="updateStatus" method="post">
                    
                    <input type="hidden" name="id" value="<%= product.getId() %>"/>

                    <div class="mb-3">
                        <label class="form-label">Product Name</label>
                        <input type="text" class="form-control" value="<%= product.getName() %>" disabled>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Status</label>
                        <select class="form-select" name="status" id="status" onchange="toggleReason()">
                            <option value="CREATED">CREATED</option>
                            <option value="IN_PROGRESS">IN_PROGRESS</option>
                            <option value="DELIVERED">DELIVERED</option>
                            <option value="REJECTED">REJECTED</option>
                        </select>
                    </div>

                    <!-- Rejection Note -->
                    <div class="mb-3" id="reasonDiv" style="display:none;">
                        <label class="form-label text-danger">Rejection Note</label>
                        <textarea class="form-control" name="reason" rows="4"
                            placeholder="Enter rejection reason..."></textarea>
                    </div>

                    <div class="d-grid">
                        <button type="submit" class="btn btn-primary">
                            Update Status
                        </button>
                    </div>

                </form>
            </div>

        </div>
    </div>
</div>

<script>
    function toggleReason() {
        var status = document.getElementById("status").value;
        var reasonDiv = document.getElementById("reasonDiv");

        if (status === "REJECTED") {
            reasonDiv.style.display = "block";
        } else {
            reasonDiv.style.display = "none";
        }
    }
</script>

</body>
</html>