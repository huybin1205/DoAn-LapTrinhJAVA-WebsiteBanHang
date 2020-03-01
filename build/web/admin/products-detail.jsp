<%@page import="model.Category"%>
<%@page import="dao.CategoryDAO"%>
<%@page import="dao.ProducerDAO"%>
<%@page import="model.Product"%>
<%@page import="model.Producer"%>
<%@page import="dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Title Page-->
        <title><%= constants.Constants.STORE_NAME%>: ADMIN - Dashboard</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="layout/script-header.jsp"></jsp:include>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
            <script>
                $(document).ready(function () {
                    var command = $('#command').val();
                    if (command === 'insert') {
                        $(":text").val('');
                        $("textarea").val('');
                        $('#imgProduct').attr('src', '../images/smile.png');
                    }

//                    $('#btnBack').click(function () {
//                        window.location.href = '../admin/products.jsp';
//                    });
                });
            </script>
        </head>

        <body class="animsition">
        <%
            ProductDAO productDAO = new ProductDAO();
            ProducerDAO producerDAO = new ProducerDAO();
            CategoryDAO categoryDAO = new CategoryDAO();
            Product p;
            int id = -1;
            String command = "";
            if (request.getParameter("productID") != null) {
                id = Integer.parseInt(request.getParameter("productID"));
                p = productDAO.getProduct(id);
                command = "update";
            } else {
                p = new Product();
                command = "insert";
//                String redirectURL = "../admin/products.jsp";
//                response.sendRedirect(redirectURL);
            }
        %>
        <div class="page-wrapper">
            <!-- MENU SIDEBAR-->
            <jsp:include page="layout/menu-slidebar.jsp"></jsp:include>
                <!-- END MENU SIDEBAR-->


                <!-- PAGE CONTAINER-->
                <div class="page-container2">
                    <!-- HEADER DESKTOP-->
                <jsp:include page="layout/header.jsp"></jsp:include>
                    <!-- END HEADER DESKTOP-->

                    <div class="main-content">
                        <div class="section__content section__content--p30">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <!-- DATA TABLE -->
                                        <!--<h3 class="title-5 m-b-35">PRODUCTS DETAIL</h3>-->
                                        <div class="card">
                                            <div class="card-header">
                                                <strong><%= id == -1 ? constants.Constants.STORE_NAME : p.getProductName()%></strong>
                                        </div>
                                        <div class="card-body card-block">
                                            <form action="${pageContext.request.contextPath}/ProductUploadServlet" method="POST" class="form-horizontal" enctype="multipart/form-data" acceptcharset="UTF-8">
                                                <%
                                                    if (id != -1) {
                                                %>
                                                <div class="row form-group">
                                                    <div class="col col-md-3">
                                                        <label class=" form-control-label">ID</label>
                                                    </div>
                                                    <div class="col-12 col-md-9">
                                                        <label class=" form-control-label"><%= p.getProductID()%></label>
                                                    </div>
                                                </div>
                                                <%}%>
                                                <input type="hidden" id="command" name="command" value="<%= command%>"  />
                                                <input type="hidden" name="productID" value="<%= p.getProductID()%>" />
                                                <div class="row form-group">
                                                    <div class="col col-md-3">
                                                        <label class=" form-control-label">Catagory</label>
                                                    </div>
                                                    <div class="col-12 col-md-9">
                                                        <select name="categoryID" class="form-control" id="sel1">
                                                            <%
                                                                for (Category c : categoryDAO.getListCategory()) {
                                                            %>
                                                            <option <%= p.getCategoryID() == c.getCategoryId() ? "selected" : ""%> value="<%= c.getCategoryId()%>"><%= c.getCategoryName()%></option>
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="row form-group">
                                                    <div class="col col-md-3">
                                                        <label class=" form-control-label">Producers</label>
                                                    </div>
                                                    <div class="col-12 col-md-9">
                                                        <select name="producerID" class="form-control" id="sel1">
                                                            <%
                                                                for (Producer producer : producerDAO.getAllProducer()) {
                                                            %>
                                                            <option <%= p.getProducerID() == producer.getProducerID() ? "selected" : ""%> value="<%= producer.getProducerID()%>"><%= producer.getProducerName()%></option>
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="row form-group">
                                                    <div class="col col-md-3">
                                                        <label class=" form-control-label">Product name:</label>
                                                    </div>
                                                    <div class="col-12 col-md-9">
                                                        <input name="productName" type="text" value="<%= p.getProductName()%>" placeholder="Enter Product Name..." class="form-control">
                                                    </div>
                                                </div>
                                                <div class="row form-group">
                                                    <div class="col col-md-3">
                                                        <label class=" form-control-label">Title</label>
                                                    </div>
                                                    <div class="col-12 col-md-9">
                                                        <input name="productTitle" value="<%= p.getProductTitle()%>" type="text" placeholder="Enter Title..." class="form-control">
                                                    </div>
                                                </div>
                                                <div class="row form-group">
                                                    <div class="col col-md-3">
                                                        <label class=" form-control-label">Description</label>
                                                    </div>
                                                    <div class="col-12 col-md-9">
                                                        <textarea name="productDescription" type="text" placeholder="Enter Description..." class="form-control"><%= p.getProductDescription()%></textarea>
                                                    </div>
                                                </div>
                                                <div class="row form-group">
                                                    <div class="col col-md-3">
                                                        <label class=" form-control-label">Size</label>
                                                    </div>
                                                    <div class="col-12 col-md-9">
                                                        <input name="productSize" value="<%= p.getProductSize()%>" type="text" placeholder="Enter Size..." class="form-control">
                                                    </div>
                                                </div>
                                                <div class="row form-group">
                                                    <div class="col col-md-3">
                                                        <label class=" form-control-label">Color</label>
                                                    </div>
                                                    <div class="col-12 col-md-9">
                                                        <input name="productColor" value="<%= p.getProductColor()%>" type="text" placeholder="Enter Color..." class="form-control">
                                                    </div>
                                                </div>
                                                <div class="row form-group">
                                                    <div class="col col-md-3">
                                                        <label class=" form-control-label">Image</label>
                                                    </div>
                                                    <div class="col-12 col-md-9">
                                                        <img id="imgProduct" width="200" height="200" src="../images/<%= p.getProductImage()%>" alt="<%= p.getProductName()%>"/>
                                                        <input name="productImage" type="file" placeholder="Enter file..." class="form-control">
                                                    </div>
                                                </div>
                                                <div class="row form-group">
                                                    <div class="col col-md-3">
                                                        <label class=" form-control-label">Price</label>
                                                    </div>
                                                    <div class="col-12 col-md-9">
                                                        <input name="productPrice" value="<%= p.getProductPrice()%>" type="number" placeholder="Enter Price..." class="form-control">
                                                    </div>
                                                </div>
                                                <div class="row form-group">
                                                    <div class="col col-md-3">
                                                        <label class=" form-control-label">Stock Quantity</label>
                                                    </div>
                                                    <div class="col-12 col-md-9">
                                                        <input name="productInventoryNumber" value="<%= p.getInventoryNumber()%>" type="number" placeholder="Enter Quantity..." class="form-control">
                                                    </div>
                                                </div>
                                                <div class="card-footer">
                                                    <button type="submit" class="btn btn-primary btn-sm">
                                                        <i class="fa fa-dot-circle-o"></i> <%= command.compareTo("insert") == 0 ? "Insert" : "Update"%>
                                                    </button>
                                                    <a id="btnBack" style="color:white" href="../admin/products.jsp" class="btn btn-danger btn-sm">
                                                        <i class="fa fa-ban"></i> Back
                                                    </a>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="layout/modal.jsp"></jsp:include>
    <jsp:include page="layout/script-footer.jsp"></jsp:include>
</body>

</html>
<!-- end document-->
