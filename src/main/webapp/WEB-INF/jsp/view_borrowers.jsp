<%--
  Created by IntelliJ IDEA.
  User: Akvasoft
  Date: 05/09/2018
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Borrowers</title>
    <!-- Global stylesheets -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700,900" rel="stylesheet"
          type="text/css">
    <link href="assets/css/icons/icomoon/styles.css" rel="stylesheet" type="text/css">
    <link href="assets/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="assets/css/core.css" rel="stylesheet" type="text/css">
    <link href="assets/css/components.css" rel="stylesheet" type="text/css">
    <link href="assets/css/colors.css" rel="stylesheet" type="text/css">
    <!-- /global stylesheets -->

    <!-- Core JS files -->
    <script type="text/javascript" src="assets/js/plugins/loaders/pace.min.js"></script>
    <script type="text/javascript" src="assets/js/core/libraries/jquery.min.js"></script>
    <script type="text/javascript" src="assets/js/core/libraries/bootstrap.min.js"></script>
    <script type="text/javascript" src="assets/js/plugins/loaders/blockui.min.js"></script>
    <!-- /core JS files -->

    <!-- Theme JS files -->
    <script type="text/javascript" src="assets/js/plugins/tables/datatables/datatables.min.js"></script>
    <script type="text/javascript" src="assets/js/plugins/forms/selects/select2.min.js"></script>

    <script type="text/javascript" src="assets/js/core/app.js"></script>
    <script type="text/javascript" src="assets/js/pages/datatables_advanced.js"></script>
    <%--<!-- /theme JS files -->--%>
</head>
<body onload="BORROWER.allBorrowers();" class="sidebar-xs has-detached-left">
<!-- Main navbar -->
<jsp:include page="common/main_top_nav.jsp"/>
<!-- /main navbar -->

<!-- Page container -->
<div class="page-container">

    <!-- Page content -->
    <div class="page-content">

        <!-- Main sidebar -->
            <jsp:include page="common/left_nav.jsp"/>
        <!-- /main sidebar -->


        <!-- Main content -->
        <div class="content-wrapper">

            <!-- Page header -->
            <div class="page-header page-header-default">
                <div class="breadcrumb-line">
                    <ul class="breadcrumb">
                        <li><a href="/admin_dash"><i class="icon-home2 position-left"></i> Home</a></li>
                        <li class="active">Borrowers</li>
                        <li class="active">View Borrowers</li>
                    </ul>

                    <ul class="breadcrumb-elements">
                        <li><a href="#"><i class="icon-search4 position-left"></i> Advanced Search</a></li>
                    </ul>
                </div>
            </div>
            <!-- /page header -->


            <!-- Content area -->
            <div class="content">

                <!-- Main table -->
                <div class="row">
                    <div class="panel panel-flat">
                        <table class="table datatable-dom-position" id="tbl_borrower">
                            <thead>
                            <tr>
                                <th style="font-size: small">Full Name</th>
                                <th style="font-size: small">Business</th>
                                <th style="font-size: small">Unique#</th>
                                <th style="font-size: small">Mobile</th>
                                <th style="font-size: small">Email</th>
                                <th style="font-size: small">Reg.Date</th>
                                <th style="font-size: small">Reg.By</th>
                            </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>
                    </div>
                    <!-- /DOM positioned -->
                </div>
                <!-- /main table -->


                <!-- Footer -->
                <jsp:include page="common/footer.jsp"/>
                <!-- /footer -->

            </div>
            <!-- /content area -->

        </div>
        <!-- /main content -->

    </div>
    <!-- /page content -->

</div>
<!-- /page container -->
<script type="text/javascript" src="session/jquery.session.js"></script>
<script type='text/javascript' src='noty/jquery.noty.js'></script>
<script type='text/javascript' src='noty/layouts/topCenter.js'></script>
<script type='text/javascript' src='noty/layouts/topLeft.js'></script>
<script type='text/javascript' src='noty/layouts/topRight.js'></script>
<script type='text/javascript' src='noty/themes/default.js'></script>
<script type="text/javascript" src="app/js/Borrower.js"></script>
</body>
</html>
