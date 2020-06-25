
<%@page import="model.CartItem"%>
<%@page import="model.Cart"%>
<%
    Cart cart = (Cart) session.getAttribute("cart");
    if (cart == null) {
        cart = new Cart();
        session.setAttribute("cart", cart);
    }
%>
<div class="wrap-header-cart js-panel-cart">
    <div class="s-full js-hide-cart"></div>

    <div class="header-cart flex-col-l p-l-65 p-r-25">
        <div class="header-cart-title flex-w flex-sb-m p-b-8">
            <span class="mtext-103 cl2">
                Your Cart
            </span>

            <div class="fs-35 lh-10 cl2 p-lr-5 pointer hov-cl1 trans-04 js-hide-cart">
                <i class="zmdi zmdi-close"></i>
            </div>
        </div>

        <div class="header-cart-content flex-w js-pscroll">
            <ul class="header-cart-wrapitem w-full">
                <%
                    for (CartItem item : cart.getCart()) {
                %>
                <li class="header-cart-item flex-w flex-t m-b-12">
                    <div id="btnRemoveItemCart" class="header-cart-item-img" product-name="<%= item.getProduct().getProductName()%>" product-id="<%= item.getProduct().getProductID()%>">
                        <img src="images/<%= item.getProduct().getProductImage()%>" alt="<%= item.getProduct().getProductName()%>">
                    </div>

                    <div class="header-cart-item-txt p-t-8">
                        <a href="product-detail.jsp?product=<%= item.getProduct().getProductID()%>" class="header-cart-item-name m-b-18 hov-cl1 trans-04">
                            <%= item.getProduct().getProductName()%>
                        </a>

                        <span class="header-cart-item-info">
                            <%= item.getQuantity()%> x <%= cart.formatDecimal(item.getProduct().getProductPrice())%>
                        </span>
                    </div>
                </li>
                <%
                    }
                %>
            </ul>

            <div class="w-full">
                <div class="header-cart-total w-full p-tb-40">
                    Total: <%= cart.formatDecimal(cart.getTotalCart())%>
                </div>

                <div class="header-cart-buttons flex-w w-full">
                    <center>
                        <a href="shopping-cart.jsp" class="flex-c-m stext-101 cl0 size-107 bg3 bor2 hov-btn3 p-lr-15 trans-04 m-r-8 m-b-10">
                            View Cart
                        </a>
                    </center>

                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $('#btnRemoveItemCart').click(async function () {
        var id = $(this).attr('product-id');
        callAjax('CartServlet', 'remove', id, '1');
        var name = $(this).attr('product-name');
        swal(name, "have been successfully removed", "success");
        await sleep(1500);
        window.location.href = window.location;
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
</script>