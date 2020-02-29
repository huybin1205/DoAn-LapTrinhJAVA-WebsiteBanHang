<%@page import="model.Cart"%>
<%@page import="dao.CategoryDAO" %>
<%@page import="model.Category" %>
<%
    CategoryDAO categoryDAO = new CategoryDAO();
    
    Cart cart = (Cart) session.getAttribute("cart");
    if(cart == null){
        cart = new Cart();
        session.setAttribute("cart", cart);
    }
%>
<header class="header-v3">
    <!-- Header desktop -->
    <div class="container-menu-desktop trans-03">
        <div class="wrap-menu-desktop">
            <nav class="limiter-menu-desktop p-l-45">

                <!-- Logo desktop -->		
                <a href="index.jsp" class="logo">
                    <img src="images/icon/logo-desktop.png" alt="<%= constants.Constants.STORE_NAME %>">
                </a>

                <!-- Menu desktop -->
                <div class="menu-desktop">
                    <ul class="main-menu">
                        <li>
                            <a href="index.jsp">Home</a>
                        </li>

                        <li>
                            <a href="#">Categories</a>
                            <ul class="sub-menu">
                                <%
                                    for (Category c : categoryDAO.getListCategory()) {
                                %>
                                <li>
                                    <a href="products.jsp?category=<%=c.getCategoryId()%>">
                                        <%=c.getCategoryName()%>
                                    </a>
                                </li>
                                <%
                                    }
                                %>
                            </ul>
                        </li>

                        <li>
                            <a href="about.jsp">About</a>
                        </li>

                        <li>
                            <a href="contact.jsp">Contact</a>
                        </li>
                    </ul>
                </div>	

                <!-- Icon header -->
                <div class="wrap-icon-header flex-w flex-r-m h-full">							
                    <div class="flex-c-m h-full p-r-25 bor6">
                        <div id="btnCart" class="icon-header-item cl0 hov-cl1 trans-04 p-lr-11 icon-header-noti js-show-cart" data-notify="<%= cart.getCountItemCart() %>">
                            <i class="zmdi zmdi-shopping-cart"></i>
                        </div>
                    </div>

                    <div class="flex-c-m h-full p-lr-19">
                        <div class="icon-header-item cl0 hov-cl1 trans-04 p-lr-11 js-show-sidebar">
                            <i class="zmdi zmdi-menu"></i>
                        </div>
                    </div>
                </div>
            </nav>
        </div>	
    </div>

    <!-- Header Mobile -->
    <div class="wrap-header-mobile">
        <!-- Logo moblie -->		
        <div class="logo-mobile">
            <a href="index.jsp"><img src="images/icon/logo-mobile.png" alt="<%= constants.Constants.STORE_NAME %>"></a>
        </div>

        <!-- Icon header -->
        <div class="wrap-icon-header flex-w flex-r-m h-full m-r-15">
            <div class="flex-c-m h-full p-r-5">
                <div id="btnCart" class="icon-header-item cl2 hov-cl1 trans-04 p-lr-11 icon-header-noti js-show-cart" data-notify="<%= cart.getCountItemCart() %>">
                    <i class="zmdi zmdi-shopping-cart"></i>
                </div>
            </div>
        </div>

        <!-- Button show menu -->
        <div class="btn-show-menu-mobile hamburger hamburger--squeeze">
            <span class="hamburger-box">
                <span class="hamburger-inner"></span>
            </span>
        </div>
    </div>


    <!-- Menu Mobile -->
    <div class="menu-mobile">
        <ul class="main-menu-m">
            <li>
                <a href="index.jsp">Home</a>
            </li>
            <li>
                <a href="#">Categories</a>
                <ul class="sub-menu-m">
                    <%
                        for (Category c : categoryDAO.getListCategory()) {
                    %>
                    <li>
                        <a href="products.jsp?category=<%=c.getCategoryId()%>">
                            <%=c.getCategoryName()%>
                        </a>
                    </li>
                    <%
                        }
                    %>
                </ul>
                <span class="arrow-main-menu-m">
                    <i class="fa fa-angle-right" aria-hidden="true"></i>
                </span>
            </li>



            <li>
                <a href="about.jsp">About</a>
            </li>

            <li>
                <a href="contact.jsp">Contact</a>
            </li>
        </ul>
    </div>

    <!-- Modal Search -->
    <div class="modal-search-header flex-c-m trans-04 js-hide-modal-search">
        <button class="flex-c-m btn-hide-modal-search trans-04">
            <i class="zmdi zmdi-close"></i>
        </button>

        <form class="container-search-header">
            <div class="wrap-search-header">
                <input class="plh0" type="text" name="search" placeholder="Search...">

                <button class="flex-c-m trans-04">
                    <i class="zmdi zmdi-search"></i>
                </button>
            </div>
        </form>
    </div>
</header>
