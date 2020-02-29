<%@page import="model.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Product" %>
<%@page import="dao.ProductDAO" %>
<html>
    <head>
        <title><%= constants.Constants.STORE_NAME %>: HOME</title>
        <jsp:include page="layout/script-header.jsp"></jsp:include>
        </head>
        <body class="animsition">
        <%
            ProductDAO productDAO = new ProductDAO();
            
            Cart cart = (Cart) session.getAttribute("cart");
            if(cart == null){
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
            <!-- Slider -->
        <jsp:include page="layout/slider.jsp"></jsp:include>
            <!-- Banner -->
        <jsp:include page="layout/banner.jsp"></jsp:include>
            <!-- Product New -->
            <section class="bg0 p-t-23 p-b-130">
                <div class="container">
                    <div class="p-b-10">
                        <h3 class="ltext-103 cl5">
                            Product New
                        </h3>
                    </div>

                    <div class="row isotope-grid">
                    <%
                        for (Product p : productDAO.getNewProduct(constants.Constants.QUANTITY_PRODUCT_NEW)) {
                    %>
                    <div class="col-sm-6 col-md-3 col-lg-3 p-b-35 isotope-item">
                        <!-- Block2 -->
                        <div class="block2">
                            <div class="block2-pic hov-img0 label-new" data-label="New">
                                <img src="images/<%= p.getProductImage()%>" alt="<%=p.getProductName()%>">

                                <a href="#" class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1">
                                    Quick View
                                </a>
                            </div>

                            <div class="block2-txt flex-w flex-t p-t-14">
                                <div class="block2-txt-child1 flex-col-l ">
                                    <a href="product-detail.jsp?product=<%=p.getProductID()%>" class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
                                        <%=p.getProductName()%>
                                    </a>

                                    <span class="stext-105 cl3">
                                        <%= cart.formatDecimal(p.getProductPrice())%>
                                    </span>
                                </div>

                                <div class="block2-txt-child2 flex-r p-t-3">
                                    <a href="#" class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
                                        <img class="icon-heart1 dis-block trans-04" src="images/icons/icon-heart-01.png" alt="ICON">
                                        <img class="icon-heart2 dis-block trans-04 ab-t-l" src="images/icons/icon-heart-02.png" alt="ICON">
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>
        </section>
        <!--Best Sale Product-->
        <section class="bg0 p-t-23 p-b-130">
            <div class="container">
                <div class="p-b-10">
                    <h3 class="ltext-103 cl5">
                        Best Sale
                    </h3>
                </div>

                <div class="row isotope-grid">
                    <%
                        for (Product p : productDAO.getBestSaleProduct(constants.Constants.QUANTITY_BEST_SALE_PRODUCT)) {
                    %>
                    <div class="col-sm-6 col-md-3 col-lg-3 p-b-35 isotope-item">
                        <!-- Block2 -->
                        <div class="block2">
                            <div class="block2-pic hov-img0">
                                <img src="images/<%= p.getProductImage()%>" alt="<%=p.getProductName()%>">

                                <a href="#" class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1">
                                    Quick View
                                </a>
                            </div>

                            <div class="block2-txt flex-w flex-t p-t-14">
                                <div class="block2-txt-child1 flex-col-l ">
                                    <a href="product-detail.jsp?product=<%=p.getProductID()%>" class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
                                        <%=p.getProductName()%>
                                    </a>

                                    <span class="stext-105 cl3">
                                        <%= cart.formatDecimal(p.getProductPrice())%>
                                    </span>
                                </div>

                                <div class="block2-txt-child2 flex-r p-t-3">
                                    <a href="#" class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
                                        <img class="icon-heart1 dis-block trans-04" src="images/icons/icon-heart-01.png" alt="ICON">
                                        <img class="icon-heart2 dis-block trans-04 ab-t-l" src="images/icons/icon-heart-02.png" alt="ICON">
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>
                        <jsp:include page="layout/banner-footer.jsp"></jsp:include>

        </section>
        <jsp:include page="layout/footer.jsp"></jsp:include>
    </body>
</html>