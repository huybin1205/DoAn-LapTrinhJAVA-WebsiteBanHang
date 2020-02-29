<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><%= constants.Constants.STORE_NAME%>: Register</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <jsp:include page="layout/script-header.jsp"></jsp:include>
            <script type="text/javascript">
                $(document).ready(function () {
                    var smile = '<img width=50 height=50 src="images/smile.png" />';
                    $('#status').html(smile);
                    var x_timer;
                    $("#username").keyup(function (e) {
                        clearTimeout(x_timer);
                        var user_name = $(this).val();
                        x_timer = setTimeout(function () {
                            check_username_ajax(user_name);
                        }, 1000);
                    });
                    function check_username_ajax(username) {
                        $("#status").html('<img width=50 height=50 src="images/loader.gif" />');
                        $.post('CheckAccountServlet', {'username': username}, function (data) {
                            var html = '<img width=50 height=50 src="images/' + data + '" />'
                            $("#status").html(html);
                        });
                    }
                });
            </script>
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
                    Register
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
                                    Register
                                </h5>
                                <p class="stext-107 cl6 p-b-40">
                                    Required fields are marked *
                                </p>
                            <%if (session.getAttribute("error") != null) {%>
                            <div class="alert alert-danger" role="alert">
                                <%=session.getAttribute("error")%>
                            </div>
                            <%}%>
                            <form action="UsersServlet" method="POST">
                                <table class="table table-bordered table-responsive" >
                                    <tr>
                                        <td>
                                            <div class="bor19 m-b-20">
                                                <input required class="stext-111 cl2 plh3 size-116 p-lr-18" id="username" type="text" name="username" placeholder="Username *">
                                            </div>
                                        </td>
                                        <td>
                                    <center>
                                        <span>Status</span>
                                        <p id="status"></p>
                                    </center>
                                    </td>
                                    </tr>

                                    <tr>
                                        <td colspan="2">
                                            <div class="bor19 m-b-20">
                                                <input required class="stext-111 cl2 plh3 size-116 p-lr-18" type="password" name="password" placeholder="Password *">
                                            </div>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td colspan="2">
                                            <div class="bor19 m-b-20">
                                                <input required class="stext-111 cl2 plh3 size-116 p-lr-18" type="password" name="repassword" placeholder="Repassword *">
                                            </div>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <div class="bor19 m-b-20">
                                                <input required class="stext-111 cl2 plh3 size-116 p-lr-18" type="text" name="name" placeholder="Name *">
                                            </div>
                                        </td>
                                        <td>
                                            <div class="bor19 m-b-30">
                                                <input required class="stext-111 cl2 plh3 size-116 p-lr-18" type="date" name="dateofbirth">
                                            </div>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <div class="bor19 m-b-20">
                                                <input required class="stext-111 cl2 plh3 size-116 p-lr-18" type="text" name="email" placeholder="Email *">
                                            </div>
                                        </td>
                                        <td>
                                            <div class="bor19 m-b-30">
                                                <input required class="stext-111 cl2 plh3 size-116 p-lr-18" type="text" name="phonenumber" placeholder="Phonenumber">
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <div class="bor19 m-b-20">
                                                <input required class="stext-111 cl2 plh3 size-124 p-lr-18 p-tb-15" name="address" placeholder="Address">
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                                <input type="hidden" value="register" name="command" >
                                <button type="submit" class="flex-c-m stext-101 cl0 size-125 bg3 bor2 hov-btn3 p-lr-15 trans-04">
                                    Register
                                </button>
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
