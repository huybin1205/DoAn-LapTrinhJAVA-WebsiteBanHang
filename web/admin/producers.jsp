<%@page import="model.Producer"%>
<%@page import="dao.ProducerDAO"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Title Page-->
        <title><%= constants.Constants.STORE_NAME%>: ADMIN - Dashboard</title>
        <jsp:include page="layout/script-header.jsp"></jsp:include>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
            <script>
                $(document).ready(function () {
                    $('.producer-item').click(function () {
                        id = $(this).attr('producer-id');
                        window.location.href = '../admin/producer-detail.jsp?producerID=' + id;
                    });

                    $('.btnDelete').click(function () {
//                        alert('a');
                        var id = $(this).attr('producer-id');
                        var name = $(this).attr('producer-name');
                        data = {
                            'producerID': id,
                            'command': 'remove'
                        };
                        if (confirm('Are you sure you want to delele this product?\n' + name)) {
                            $.post('../ProducerServlet', data, function (data) {
                                if (data === 'success') {
                                    showModal('Notification', name + 'is deleted to list !', 'success');
                                } else {
                                    showModal('Notification', name + 'is deleted to list !', 'error');
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

                    $('#btnAddItem').click(function () {
                        window.location.href = '../admin/producer-detail.jsp';
                    });
                });
            </script>
        </head>

        <body class="animsition">
        <%
            ProducerDAO producerDAO = new ProducerDAO();
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
                                        <h3 class="title-5 m-b-35">PRODUCER MANAMENT</h3>
                                        <div class="table-data__tool">
                                            <div class="table-data__tool-left">
                                                <div class="rs-select2--light rs-select2--md">
                                                    <select class="js-select2" name="property">
                                                        <option selected="selected">All Properties</option>
                                                        <option value="">Option 1</option>
                                                        <option value="">Option 2</option>
                                                    </select>
                                                    <div class="dropDownSelect2"></div>
                                                </div>
                                                <div class="rs-select2--light rs-select2--sm">
                                                    <select class="js-select2" name="time">
                                                        <option selected="selected">Today</option>
                                                        <option value="">3 Days</option>
                                                        <option value="">1 Week</option>
                                                    </select>
                                                    <div class="dropDownSelect2"></div>
                                                </div>
                                                <button class="au-btn-filter">
                                                    <i class="zmdi zmdi-filter-list"></i>filters</button>
                                            </div>
                                            <div class="table-data__tool-right">
                                                <button id="btnAddItem" class="au-btn au-btn-icon au-btn--green au-btn--small">
                                                    <i class="zmdi zmdi-plus"></i>add item</button>
                                                <div class="rs-select2--dark rs-select2--sm rs-select2--dark2">
                                                    <select class="js-select2" name="type">
                                                        <option selected="selected">Export</option>
                                                        <option value="">Option 1</option>
                                                        <option value="">Option 2</option>
                                                    </select>
                                                    <div class="dropDownSelect2"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="table-responsive table-responsive-data2">
                                            <table class="table table-data2">
                                                <thead>
                                                    <tr>
                                                        <th>Image</th>
                                                        <th>Name</th>
                                                        <th>Category</th>
                                                        <!--<th>Producer</th>-->
                                                        <th>Price</th>
                                                        <th>Description</th>
                                                        <th></th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <%
                                                    for (Producer p : producerDAO.getAllProducer()) {
                                                %>
                                                <tr class="tr-shadow">
                                                    <td class="producer-item" producer-id="<%= p.getProducerID()%>">
                                                        <span><%= p.getProducerName()%></span>
                                                    </td>
                                                    <td class="producer-item" producer-id="<%= p.getProducerID()%>">
                                                        <span><%= p.getProducerName()%></span>
                                                    </td>
                                                    <td class="producer-item" producer-id="<%= p.getProducerID()%>">
                                                        <span><%= p.getProducerAddress()%></span>
                                                    </td>
                                                    <td class="producer-item" producer-id="<%= p.getProducerID()%>">
                                                        <span><%= p.getProducerPhonenumber()%></span>
                                                    </td>
                                                    <td>
                                                        <div class="table-data-feature">
                                                            <button class="item" title="Edit">
                                                                <i class="zmdi zmdi-edit"></i>
                                                            </button>
                                                            <button class="item" producer-name="<%= p.getProducerName()%>" producer-id="<%= p.getProducerID()%>" title="Delete">
                                                                <i class="btnDelete zmdi zmdi-delete" producer-name="<%= p.getProducerName()%>" producer-id="<%= p.getProducerID()%>"></i>
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
                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page="layout/modal.jsp"></jsp:include>
            <jsp:include page="layout/script-footer.jsp"></jsp:include>

    </body>

</html>
<!-- end document-->
