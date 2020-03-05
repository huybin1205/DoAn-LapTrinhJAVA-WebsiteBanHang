<%@page import="model.Cart"%>
<%@page import="dao.BillDAO"%>
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
                $(document).ready(function () {
                    $('.bill-item').click(function () {
                        id = $(this).attr('bill-id');
//                        alert(id);
                        window.location.href = '../admin/order-detail.jsp?billID='+id;
                    });

                    $('.btnDelete').click(function () {
                        var id = $(this).attr('bill-id');
                        data = {
                            'billID': id,
                            'command': 'remove'
                        };
                        if (confirm('Are you sure you want to delele this the order?\n' + name)) {
                            $.post('../BillServlet', data, function (data) {
                                if (data === 'success') {
                                    showModal('Notification', id + 'is deleted to list !', 'success');
                                } else {
                                    showModal('Notification', id + 'is deleted to list !', 'error');
                                }
                            });
                        }
                    });

                    async function showModal(title, content, status) {
                        $('#staticModalLabel').html(title);
                        $('#staticModalContent').html(content);
                        if (status === 'success') {
                            $('#imgStatus').attr('src', '../images/available.png')
                        } else {
                            $('#imgStatus').attr('src', '/../images/non-available.png')
                        }
                        $('#staticModal').modal('show');
                        await sleep(1500);
                        window.location.href = window.location;
                    }

                    function sleep(ms) {
                        return new Promise(resolve => setTimeout(resolve, ms));
                    }
                });
            </script>
        </head>

        <body class="animsition">
        <%
            BillDAO billDAO = new BillDAO();

            // Check param page
            int pages = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
            int recordsPerPage = constants.Constants.RECORDS_PER_PAGE;
            int totalRecords = billDAO.getAllBill().size();
            int totalPage = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);
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
                                        <h3 class="title-5 m-b-35">ORDERS MANAMENT</h3>
                                        <div class="table-responsive table-responsive-data2">
                                            <table class="table table-data2">
                                                <thead>
                                                    <tr>
                                                        <th>ID</th>
                                                        <th>Address</th>
                                                        <th>Email</th>
                                                        <th>Phonenumber</th>
                                                        <th>Total price</th>
                                                        <th>NgayDat</th>
                                                        <th></th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <%
                                                    Bill b  = new Bill();
                                                    Cart cart = new Cart();
                                                    for (Bill p : billDAO.getAllBill(pages)) {
//                                                        c = categoryDAO.getCategoryByID(p.getCategoryID());
                                                %>
                                                <tr class="tr-shadow">
                                                    <td class="bill-item" bill-id="<%= p.getBillID()%>">
                                                        <span class="block-email"><%= p.getBillID()%></span>
                                                    </td>
                                                    <td class="bill-item" bill-id="<%= p.getBillID()%>">
                                                        <span class="block-email"><%= p.getBillAddress()%></span>
                                                    </td>
                                                    <td class="bill-item desc" bill-id="<%= p.getBillID()%>"><%= p.getBillEmail()%></td>
                                                    <td class="bill-item" bill-id="<%= p.getBillID()%>"><%= p.getBillPhonenumber()%></td>
                                                    <td class="bill-item" bill-id="<%= p.getBillID()%>">
                                                        <span class="status--process"><%=cart.formatDecimal( p.getBillTotal())%></span>
                                                    </td>
                                                    <td class="bill-item" bill-id="<%= p.getBillID()%>">
                                                        <span class="status--process"><%= p.getBillOrderDate()%></span>
                                                    </td>
                                                    <td>
                                                        <div class="table-data-feature">
                                                            <button class="btnDelete item" bill-id="<%= p.getBillID()%>" title="Delete">
                                                                <i class="zmdi zmdi-delete"></i>
                                                            </button>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr class="spacer"></tr>
                                                <%
                                                    }
                                                %>
                                            </tbody>
                                        </table>
                                        <!-- END DATA TABLE -->
                                    </div>
                                </div>
                            </div>

                            <!-- Pagination -->
                            <%
                                if (totalRecords != 0) {
                            %>
                            <center>
                                <div class="row">
                                    <div class="col-lg-12 col-sm-12 col-md-12">
                                        <nav aria-label="...">
                                            <ul class="pagination pagination-lg">
                                                <%
                                                    for (int i = 0; i < totalPage; i++) {
                                                %>
                                                <li class="page-item 
                                                    <%=pages == (i + 1) ? "disabled" : ""%> 
                                                    ">
                                                    <a class="page-link" href="../admin/products.jsp?page=<%=(i + 1)%>" tabindex="-1"><%=(i + 1)%></a>
                                                </li>
                                                <%
                                                    }
                                                %>
                                            </ul>
                                        </nav>
                                    </div>
                                </div>
                            </center>
                            <%
                                }
                            %>
                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page="layout/modal.jsp"></jsp:include>
            <jsp:include page="layout/script-footer.jsp"></jsp:include>

    </body>

</html>
<!-- end document-->
