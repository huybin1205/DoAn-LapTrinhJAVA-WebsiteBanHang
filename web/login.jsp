<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><%= constants.Constants.STORE_NAME %>: Login</title>
        <jsp:include page="layout/script-header.jsp"></jsp:include>
        </head>
        <body class="animsition">

            <!--Header-->
        <jsp:include page="layout/header.jsp"></jsp:include>

            <!-- Sidebar -->
        <jsp:include page="layout/slidebar.jsp"></jsp:include>


            <!-- Cart -->
        <jsp:include page="layout/cart.jsp"></jsp:include>

            <!--Banner--> 
            <section class="bg-img1 txt-center p-lr-15 p-tb-92" style="background-image: url('images/bg-01.jpg');">
                <h2 class="ltext-105 cl0 txt-center">
                    Login
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
                                    Login
                                </h5>
                                <p class="stext-107 cl6 p-b-40">
                                    New to VSS Store ? <a href="register.jsp">Sign Up</a>
                                </p>
                            <%if (session.getAttribute("error") != null) {%>
                            <div class="alert alert-danger" role="alert">
                                <%=session.getAttribute("error")%>
                            </div>
                            <%}%>
                            <form action="UsersServlet" method="POST">
                                <table class="table table-responsive" >
                                    <tr>
                                        <td colspan="2">
                                            <div class="bor19 m-b-20">
                                                <input required="" class="stext-111 cl2 plh3 size-116 p-lr-18" type="text" name="username" placeholder="Username *">
                                            </div>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td colspan="2">
                                            <div class="bor19 m-b-20">
                                                <input required="" class="stext-111 cl2 plh3 size-116 p-lr-18" type="password" name="password" placeholder="Password *">
                                            </div>
                                        </td>
                                    </tr>
                                    <td>
                                    <center>
                                        <input type="hidden" value="login" name="command" >
                                        <button class="flex-c-m stext-101 cl0 size-125 bg3 bor2 hov-btn3 p-lr-15 trans-04">
                                            Login
                                        </button>
                                    </center>
                                    </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                    <center>
                                        <p class="stext-107 cl6 p-b-40">
                                            <a href="#">
                                                Forgot password ?
                                            </a>
                                        </p>
                                    </center>
                                    </td>
                                    </tr>
                                </table>
                            </form>  
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </center>

    <jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>

