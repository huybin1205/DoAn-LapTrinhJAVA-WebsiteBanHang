<%@page import="model.Cart"%>
<%@page import="dao.BillDAO"%>
<%@page import="model.Product"%>
<%@page import="dao.ProductDAO"%>
<%@page import="dao.BillDetailDAO"%>
<%@page import="model.BillDetail"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="model.Bill"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Title Page-->
        <title><%= constants.Constants.STORE_NAME%>: ADMIN - Dashboard</title>
        <jsp:include page="layout/script-header.jsp"></jsp:include>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
            <script>
                $(document).ready(function(){
                    $('.product-item').click(function(){
                        var id = $(this).attr('product-id');
                        window.location.href = '../product-detail.jsp?product='+id;
                    });
                });
            </script>
        </head>

        <body class="animsition">
        <%
            BillDAO billDAO = new BillDAO();
            BillDetailDAO billDetailDAO = new BillDetailDAO();
            ProductDAO productDAO = new ProductDAO();
            Cart cart = new Cart();

            // Check param page
            int billID = request.getParameter("billID") != null ? Integer.parseInt(request.getParameter("billID")) : 1;
            Bill bill = billDAO.getBill(billID);
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
                                        <h3 class="title-5 m-b-35">ORDER: <%= billID%></h3>
                                    <div class="table-responsive table-responsive-data2">
                                        <table class="table table-data2">
                                            <thead>
                                                <tr>
                                                    <th>Address:</th>
                                                    <th>Email:</th>
                                                    <th>Phonenumber</th>
                                                    <th>Order date</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr class="tr-shadow">
                                                    <td>
                                                        <span><b><%= bill.getBillAddress()%></b></span>
                                                    </td>
                                                    <td>
                                                        <span><b><%= bill.getBillEmail()%></b></span>
                                                    </td>
                                                    <td>
                                                        <span><b><%= bill.getBillPhonenumber()%></b></span>
                                                    </td>
                                                    <td>
                                                        <span><b><%= bill.getBillOrderDate()%></b></span>
                                                    </td>
                                                </tr>
                                                <tr class="spacer"></tr>
                                            </tbody>
                                        </table>
                                        <br>
                                        <hr class="style1">
                                        <table class="table table-data2">
                                            <thead>
                                                <tr>
                                                    <th>Product ID</th>
                                                    <th>Images</th>
                                                    <th>Names</th>
                                                    <th>Quantity</th>
                                                    <th>Price</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                    Product p = new Product();
                                                    for (BillDetail b : billDetailDAO.getListBillDetailByID(billID)) {
                                                        p = productDAO.getProduct(b.getProductID());
                                                %>
                                                <tr class="tr-shadow">
                                                    <td class="product-item" product-id="<%= b.getProductID()%>">
                                                        <span><%= b.getProductID()%></span>
                                                    </td>
                                                    <td class="product-item" product-id="<%= p.getProductID()%>">
                                                        <img style="max-width:none;" height="100" width="100" src="../images/<%= p.getProductImage()%>" alt="<%= p.getProductName()%>"/>
                                                    </td>
                                                    <td class="product-item" product-id="<%= b.getProductID()%>">
                                                        <span><%= p.getProductName()%></span>
                                                    </td>
                                                    <td class="product-item" product-id="<%= b.getProductID()%>">
                                                        <span><%= b.getBillQuantity()%></span>
                                                    </td>
                                                    <td class="product-item" product-id="<%= b.getProductID()%>">
                                                        <span><%= cart.formatDecimal(b.getBillPrice())%></span>
                                                    </td>
                                                </tr>
                                                <tr class="spacer"></tr>
                                                <%
                                                    }
                                                %>
                                                <tr class="tr-shadow">
                                                    <td colspan="4">
                                                        <b><h4>Total</h4></b>
                                                    </td>
                                                    <td>
                                                        <b><h4><%= cart.formatDecimal(bill.getBillTotal()) %></h4></b>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                        <!-- END DATA TABLE -->
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
