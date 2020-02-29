<%@page import="model.CartItem"%>
<%@page import="model.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= constants.Constants.STORE_NAME%>: Shopping Cart</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

        <jsp:include page="layout/script-header.jsp"></jsp:include>
            <script>
                $(document).ready(function () {
                    $('.btnChange').click(function () {
                        var id = $(this).attr('product-id');
                        var product = 'product-' + id;
                        var quantity = $("[" + product + "]").val();
                        callAjax('CartServlet', 'update', id, quantity);
                    });

                    $('#btnUpdate').click(async function () {
                        swal('Cart', "have been successfully updated", "success");
                        await sleep(1500);
                        window.location.href = window.location;
                    });

                    $('.btnDelete').click(async function () {
                        var id = $(this).attr('product-id');
                        callAjax('CartServlet', 'remove', id, '1');
                        var name = $(this).attr('product-name');
                        swal(name, "have been successfully removed", "success");
                        await sleep(1500);
                        window.location.href = window.location;
                    });

                    $('#btnCheckout').click(function () {
                        var address = $('#txtAddress').val();
                        var email = $('#txtEmail').val();
                        var phonenumber = $('#txtPhonenumber').val();
                        if (address && email && phonenumber) {
                            var data = {
                                'command': 'insert',
                                'address': address,
                                'email': email,
                                'phonenumber': phonenumber
                            };
                            $.post('BillServlet', data, function (respone) {
                                if (respone === 'success') {
                                    window.location.href = 'order-status.jsp?status='+ <%= constants.Constants.STATUS_SUCCESS %> ;
                                } else {
                                    swal('SYSTEM', '<%= constants.Constants.NOTIFICATION_ERROR %>', "error");
//                                    window.location.href = 'order-status.jsp?status='+ <%= constants.Constants.STATUS_FAIL %> ;
                                }
                            });
                        }
                    });

                    function callAjax(url, command, productID, quantity) {
                        $.post('CartServlet', {'command': command, 'quantity': quantity, 'productID': productID}, function (data) {
                            if (data === 'success') {
                                console.log(data);
                            } else {
                                swal('Cart', "An error occurred", "error");
                            }
                        });
                    }

                    function sleep(ms) {
                        return new Promise(resolve => setTimeout(resolve, ms));
                    }
                });

            </script>
        </head>
        <body class="animsition">
        <%
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
        %>
        <!--Header-->
        <jsp:include page="layout/header.jsp"></jsp:include>

            <!-- Sidebar -->
        <jsp:include page="layout/slidebar.jsp"></jsp:include>

            <!-- Cart -->
        <jsp:include page="layout/cart.jsp"></jsp:include>
            <!--Banner--> 
            <section class="bg-img1 txt-center p-lr-15 p-tb-92" style="background-image: url('images/bg-01.jpg');">
                <h2 class="ltext-105 cl0 txt-center">
                    CHECKOUT
                </h2>
            </section>
            <!-- Shoping Cart -->
            <div class="bg0 p-t-75 p-b-85">
                <!-- breadcrumb -->

                <div class="container">
                    <div>
                        <div class="bread-crumb flex-w p-l-25 p-r-15 p-t-30 p-lr-0-lg">
                            <a href="index.html" class="stext-109 cl8 hov-cl1 trans-04">
                                Home
                                <i class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
                            </a>

                            <span class="stext-109 cl4">
                                Shoping Cart
                            </span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-10 col-xl-7 m-lr-auto m-b-50">
                            <div class="m-l-25 m-r--38 m-lr-0-xl">
                                <div class="wrap-table-shopping-cart">
                                    <table class="table-shopping-cart">
                                        <tr class="table_head">
                                            <th class="column-1">Product</th>
                                            <th class="column-2"></th>
                                            <th class="column-3">Price</th>
                                            <th class="column-4">Quantity</th>
                                            <th class="column-5">Total</th>
                                        </tr>

                                    <%
                                        if (cart.getCountItemCart()
                                                == 0) {
                                    %>
                                    <tr class="table_row">
                                        <td colspan="4" class="column-2">
                                    <center><span>Không có sản phẩm trong giỏ hàng</span></center>
                                    </td>
                                    </tr>
                                    <%
                                        }
                                    %>

                                    <%
                                        for (CartItem item
                                                : cart.getCart()) {
                                    %>
                                    <tr class="table_row">
                                        <td class="column-1">
                                            <div product-id="<%= item.getProduct().getProductID()%>" product-name="<%= item.getProduct().getProductName()%>" class="btnDelete how-itemcart1">
                                                <img src="images/<%= item.getProduct().getProductImage()%>" alt="<%= item.getProduct().getProductName()%>">
                                            </div>
                                        </td>
                                        <td class="column-2"><%= item.getProduct().getProductName()%></td>
                                        <td class="column-3"><%= cart.formatDecimal(item.getProduct().getProductPrice())%></td>
                                        <td class="column-4">
                                            <div class="wrap-num-product flex-w m-l-auto m-r-0">
                                                <div product-id="<%= item.getProduct().getProductID()%>" class="btnChange btn-num-product-down cl8 hov-btn3 trans-04 flex-c-m">
                                                    <i class="fs-16 zmdi zmdi-minus"></i>
                                                </div>

                                                <input product-<%= item.getProduct().getProductID()%> class="mtext-104 cl3 txt-center num-product" min="1" max="10" type="number" name="num-product1" value="<%= item.getQuantity()%>">

                                                <div product-id="<%= item.getProduct().getProductID()%>" class="btnChange btn-num-product-up cl8 hov-btn3 trans-04 flex-c-m">
                                                    <i class=" fs-16 zmdi zmdi-plus"></i>
                                                </div>
                                            </div>
                                        </td>
                                        <td class="column-5"><%= cart.formatDecimal(item.getProduct().getProductPrice() * item.getQuantity())%></td>
                                    </tr>
                                    <%
                                        }
                                    %>

                                </table>
                            </div>

                            <div class="flex-w flex-sb-m bor15 p-t-18 p-b-15 p-lr-40 p-lr-15-sm">
                                <div class="flex-w flex-m m-r-20 m-tb-5">
                                    <input class="stext-104 cl2 plh4 size-117 bor13 p-lr-20 m-r-10 m-tb-5" type="text" name="coupon" placeholder="Coupon Code">

                                    <div class="flex-c-m stext-101 cl2 size-118 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer m-tb-5">
                                        Apply coupon
                                    </div>
                                </div>

                                <div id="btnUpdate" class="flex-c-m stext-101 cl2 size-119 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer m-tb-10">
                                    Update Cart
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-10 col-lg-7 col-xl-5 m-lr-auto m-b-50">
                        <div class="bor10 p-lr-40 p-t-30 p-b-40 m-l-63 m-r-40 m-lr-0-xl p-lr-15-sm">
                            <h4 class="mtext-109 cl2 p-b-30">
                                Cart Totals
                            </h4>

                            <div class="flex-w flex-t bor12 p-b-13">
                                <div class="size-208">
                                    <span class="stext-110 cl2">
                                        Subtotal:
                                    </span>
                                </div>

                                <div class="size-209">
                                    <span class="mtext-110 cl2">
                                        <%= cart.formatDecimal(cart.getTotalCart())%>
                                    </span>
                                </div>
                            </div>

                            <div class="flex-w flex-t bor12 p-t-15 p-b-30">
                                <div class="size-208 w-full-ssm">
                                    <span class="stext-110 cl2">
                                        Shipping:
                                    </span>
                                </div>

                                <div class="size-209 p-r-18 p-r-0-sm w-full-ssm">
                                    <p class="stext-111 cl6 p-t-2">
                                        There are no shipping methods available. Please double check your address, or contact us if you need any help.
                                    </p>

                                    <div class="p-t-15">
                                        <span class="stext-112 cl8">
                                            Calculate Shipping
                                        </span>

                                        <div class="rs1-select2 rs2-select2 bor8 bg0 m-b-12 m-t-9">
                                            <input required id="txtAddress" class="stext-111 cl8 plh3 size-111 p-lr-15" type="text" name="address" placeholder="Address">
                                        </div>

                                        <div class="bor8 bg0 m-b-12">
                                            <input required id="txtPhonenumber" class="stext-111 cl8 plh3 size-111 p-lr-15" type="text" name="phonenumber" placeholder="Phonenumber">
                                        </div>

                                        <div class="bor8 bg0 m-b-22">
                                            <input required id="txtEmail" class="stext-111 cl8 plh3 size-111 p-lr-15" type="text" name="email" placeholder="Email">
                                        </div>

                                    </div>
                                </div>
                            </div>

                            <div class="flex-w flex-t p-t-27 p-b-33">
                                <div class="size-208">
                                    <span class="mtext-101 cl2">
                                        Total:
                                    </span>
                                </div>

                                <div class="size-209 p-t-1">
                                    <span class="mtext-110 cl2">
                                        <%= cart.formatDecimal((float) cart.getTotalCart())%>
                                    </span>
                                </div>
                            </div>

                            <button id="btnCheckout" class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer">
                                Proceed to Checkout
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="layout/footer.jsp"></jsp:include>
    </body>
</html>
