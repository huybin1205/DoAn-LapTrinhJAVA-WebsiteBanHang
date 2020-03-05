<%@page import="model.Producer"%>
<%@page import="dao.ProducerDAO"%>
<%@page import="model.Category"%>
<%@page import="dao.CategoryDAO"%>
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
                    }
                });
            </script>
        </head>

        <body class="animsition">
        <%
            ProducerDAO producerDAO = new ProducerDAO();
            Producer p;
            int id = -1;
            String command = "";
            if (request.getParameter("producerID") != null) {
                id = Integer.parseInt(request.getParameter("producerID"));
                p = producerDAO.getProducer(id);
                command = "update";
            } else {
                p = new Producer();
                command = "insert";
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
                                                <strong><%= id == -1 ? constants.Constants.STORE_NAME : p.getProducerName()%></strong>
                                        </div>
                                        <div class="card-body card-block">
                                            <form action="${pageContext.request.contextPath}/ProducerServlet" method="POST" class="form-horizontal" acceptcharset="UTF-8">
                                                <%
                                                    if (id != -1) {
                                                %>
                                                <div class="row form-group">
                                                    <div class="col col-md-3">
                                                        <label class=" form-control-label">ID</label>
                                                    </div>
                                                    <div class="col-12 col-md-9">
                                                        <label class=" form-control-label"><%= p.getProducerID()%></label>
                                                    </div>
                                                </div>
                                                <%}%>
                                                <input type="hidden" id="command" name="command" value="<%= command%>"  />
                                                <input type="hidden" name="producerID" value="<%= p.getProducerID()%>" />
                                                <div class="row form-group">
                                                    <div class="col col-md-3">
                                                        <label class=" form-control-label">Producer name:</label>
                                                    </div>
                                                    <div class="col-12 col-md-9">
                                                        <input name="producerName" type="text" value="<%= p.getProducerName()%>" placeholder="Enter Producer Name..." class="form-control">
                                                    </div>
                                                </div>
                                                <div class="row form-group">
                                                    <div class="col col-md-3">
                                                        <label class=" form-control-label">Producer Address:</label>
                                                    </div>
                                                    <div class="col-12 col-md-9">
                                                        <input name="producerAddress" type="text" value="<%= p.getProducerAddress()%>" placeholder="Enter Producer Address..." class="form-control">
                                                    </div>
                                                </div>
                                                <div class="row form-group">
                                                    <div class="col col-md-3">
                                                        <label class=" form-control-label">Producer phonenumber:</label>
                                                    </div>
                                                    <div class="col-12 col-md-9">
                                                        <input name="producerPhonenumber" type="text" value="<%= p.getProducerPhonenumber()%>" placeholder="Enter Producer Phonenumber..." class="form-control">
                                                    </div>
                                                </div>
                                                <div class="card-footer">
                                                    <button type="submit" class="btn btn-primary btn-sm">
                                                        <i class="fa fa-dot-circle-o"></i> <%= command.compareTo("insert") == 0 ? "Insert" : "Update"%>
                                                    </button>
                                                    <a id="btnBack" style="color:white" href="../admin/producers.jsp" class="btn btn-danger btn-sm">
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
