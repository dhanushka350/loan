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
    <title>View All Loans</title>
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
<body class="sidebar-xs has-detached-left">
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
                        <li class="active">Loans</li>
                        <li class="active">View Loans</li>
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
                        <table class="table datatable-dom-position">
                            <thead>
                            <tr>
                                <th style="font-size: small">Released</th>
                                <th style="font-size: small">Name</th>
                                <th style="font-size: small">Loan#</th>
                                <th style="font-size: small">Principal</th>
                                <th style="font-size: small">Interest%</th>
                                <th style="font-size: small">Due</th>
                                <th style="font-size: small">Paid</th>
                                <th style="font-size: small">Balance</th>
                                <th style="font-size: small">Last Payment</th>
                                <th style="font-size: small">Status</th>
                                <th style="font-size: small">Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr style="height: 5px">
                                <td style="font-size: small">Marth</td>
                                <td style="font-size: small">Marth</td>
                                <td style="font-size: small">Marth</td>
                                <td style="font-size: small">Marth</td>
                                <td style="font-size: small">Marth</td>
                                <td style="font-size: small">Marth</td>
                                <td style="font-size: small">Enright</td>
                                <td style="font-size: small">Traffic Court Referee</td>
                                <td style="font-size: small">22 Jun 1972</td>
                                <td><span class="label label-success">Past Maturity</span></td>
                                <td class="text-center">
                                    <ul class="icons-list">
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                                <i class="icon-menu9"></i>
                                            </a>
                                            <ul class="dropdown-menu dropdown-menu-right">
                                                <li><a href="#"><i class="icon-eye"></i> View</a></li>
                                                <li><a href="#"><i class="icon-pen"></i> Modify</a></li>
                                                <li><a href="#"><i class="icon-database-remove"></i> Remove</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </td>
                            </tr>
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
</body>
</html>
