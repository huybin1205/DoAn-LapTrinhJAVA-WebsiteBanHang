<%-- 
    Document   : order-status
    Created on : Feb 28, 2020, 12:24:59 PM
    Author     : HuyBin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <jsp:include page="layout/script-header.jsp"></jsp:include>
        </head>
        <body class="animsition">
        <%
            String status = request.getParameter("status");
            String classAlert = "";
            String notification = "";
            if (status != null) {
                int temp = Integer.parseInt(status);
                classAlert = temp == constants.Constants.STATUS_SUCCESS ? "alert-success" : "alert-danger";
                notification = temp == constants.Constants.STATUS_SUCCESS ? constants.Constants.NOTIFICATION_SUCCESS_ORDER : constants.Constants.NOTIFICATION_FAIL_ORDER;
            } else {
                classAlert = "alert-warning";
                notification = constants.Constants.NOTIFICATION_ERROR;
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
                    ORDER
                </h2>
            </section>

            <!--Register-->
        <center>
            <div class="container">
                <div class="row" style="width:483px">
                    <div class="col-md-12 col-lg-12 p-b-80">
                        <div class="p-r-45 p-r-0-lg">
                            <div class="p-t-40">
                                <h5 class="mtext-113 cl2 p-b-12">
                                    <div class="alert <%= classAlert %>" role="alert">
                                        <%= notification %>
                                    </div>
                                </h5>
                                <p class="stext-107 cl6 p-b-40">
                                    Go to back <a href="index.jsp">HOME</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </center>

    <jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>
