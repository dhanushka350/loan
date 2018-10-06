<%--
  Created by IntelliJ IDEA.
  User: Akvasoft
  Date: 05/09/2018
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Loan</title>
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
    <script type="text/javascript" src="assets/js/plugins/forms/selects/bootstrap_multiselect.js"></script>
    <script type="text/javascript" src="assets/js/pages/form_multiselect.js"></script>
    <script type="text/javascript" src="assets/js/plugins/forms/validation/validate.min.js"></script>
    <script type="text/javascript" src="assets/js/plugins/forms/inputs/touchspin.min.js"></script>
    <script type="text/javascript" src="assets/js/plugins/forms/selects/select2.min.js"></script>
    <script type="text/javascript" src="assets/js/plugins/forms/styling/switch.min.js"></script>
    <script type="text/javascript" src="assets/js/plugins/forms/styling/switchery.min.js"></script>
    <script type="text/javascript" src="assets/js/plugins/forms/styling/uniform.min.js"></script>
    <script type="text/javascript" src="assets/js/core/app.js"></script>

    <script type="text/javascript" src="assets/js/pages/form_validation.js"></script>
    <script type="text/javascript" src="assets/js/pages/form_select2.js"></script>
    <script type="text/javascript" src="assets/js/pages/form_inputs.js"></script>


    <!-- /theme JS files -->
</head>
<body onload="LOAN.allBorrowers();LOAN.allLoanTypes();">

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
                        <li class="active">Add Loan</li>
                    </ul>
                </div>
            </div>
            <!-- /page header -->


            <!-- Content area -->
            <div class="content">
                <!-- Registration form -->
                <div class="panel-body">
                    <form class="form-horizontal form-validate-jquery">
                        <fieldset class="content-group">
                            <legend class="text-bold">Add Loan
                                <small class="display-block" style="text-align: right"><a href="/admin_dash">Help</a>
                                </small>
                            </legend>
                            <!-- Basic text input -->
                            <div class="form-group">
                                <label class="control-label col-lg-3">Loan Product</label>
                                <div class="col-lg-9">
                                    <select name="default_select" class="form-control" required="required"
                                            id="loanType" onchange="LOAN.getLoanTypeDetails();">
                                        <option value="0">Select Loan Type</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3">Borrower</label>
                                <div class="col-lg-9">
                                    <div class="form-group">
                                        <select class="select-search" id="borrower">

                                        </select>
                                    </div>
                                </div>
                            </div>
                            <legend class="text-bold">Loan terms (required fields):</legend>
                            <div class="form-group">
                                <label class="control-label col-lg-3"></label>
                                <div class="col-lg-2 form-group">
                                    <small class="display-block text-bold col-lg-12" style="color: red">Principle Amount
                                        :
                                    </small>
                                </div>
                                <div class="col-lg-2 form-group">
                                    <input type="text" id="principleAmount" name="basic" class="form-control col-lg-12"
                                           placeholder="Principal Amount"
                                           style="text-align: center; background-color: transparent;color: black;font-weight: bold;"
                                           disabled="disabled">
                                </div>
                                <div class="col-lg-2 form-group">
                                    <small class="display-block text-bold col-lg-12" style="color: red">Interest :
                                    </small>
                                </div>
                                <div class="col-lg-2 form-group">
                                    <input type="text" id="interest" name="basic" class="form-control col-lg-12"
                                           placeholder="Interest"
                                           style="text-align: center; background-color: transparent;color: black;font-weight: bold;"
                                           disabled="disabled">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3"></label>
                                <div class="col-lg-2 form-group">
                                    <small class="display-block text-bold col-lg-12" style="color: red">Duration
                                        (weeks):
                                    </small>
                                </div>
                                <div class="col-lg-2 form-group">
                                    <input type="text" id="duration" name="basic" class="form-control col-lg-12"
                                           placeholder="Duration"
                                           style="text-align: center; background-color: transparent;color: black;font-weight: bold;"
                                           disabled="disabled">
                                </div>
                                <div class="col-lg-2 form-group">
                                    <small class="display-block text-bold col-lg-12" style="color: red">Weekly Charge :
                                    </small>
                                </div>
                                <div class="col-lg-2 form-group">
                                    <input type="text" id="charge" name="basic" class="form-control col-lg-12"
                                           placeholder="Charge"
                                           style="text-align: center; background-color: transparent;color: black;font-weight: bold;"
                                           disabled="disabled">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3">Disbursed By </label>
                                <div class="col-lg-9">
                                    <select name="default_select" class="form-control" required="required" id="disbursed">
                                        <option value="Cash">Cash</option>
                                        <option value="Cheque">Cheque</option>
                                        <option value="Wire_Transfer">Wire Transfer</option>
                                        <option value="Online_Transfer">Online Transfer</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3">Loan Release Date</label>
                                <div class="col-lg-9">
                                    <input class="form-control" type="date" name="date" id="date">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-lg-3">Repayment Cycle </label>
                                <div class="col-lg-9">
                                    <input type="text" id="repayment_cycle" name="digits"
                                           class="form-control col-lg-12" disabled="disabled"
                                           placeholder="Default selected Weekly Payments"
                                           style="text-align: center;font-weight: bold;color: black;">
                                </div>
                            </div>
                            <div class="form-group" id="dates" style="border-color: red;">

                            </div>
                            <legend class="text-bold">Loan Status :</legend>
                            <div class="form-group">
                                <label class="control-label col-lg-3">Loan Status</label>
                                <div class="col-lg-9">
                                    <select name="default_select" class="form-control" required="required" id="status">
                                        <option value="Processing">Processing</option>
                                        <option value="Open">Open</option>
                                        <option value="Denied">Denied</option>
                                        <option value="NTU">Not Taken Up</option>
                                    </select>
                                </div>
                            </div>
                            <legend class="text-bold">Other (optional) :</legend>
                            <div class="form-group">
                                <label class="control-label col-lg-3">Select Guarantors</label>
                                <div class="col-lg-9">
                                    <select name="default_select" class="form-control" disabled="disabled">
                                        <option value="">Not Allow For This Version</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3">Loan Files (disabled)</label>
                                <div class="col-lg-9">
                                    <input type="file" name="styled_file" class="file-styled" disabled="disabled">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3">Description</label>
                                <div class="col-lg-9">
                                    <textarea type="text" name="basic" class="form-control"
                                              placeholder="Description" id="desc"></textarea>
                                </div>
                            </div>
                        </fieldset>
                        <legend class="text-bold"></legend>
                        <div class="text-right">
                            <button type="reset" class="btn btn-default" id="reset">Reset <i
                                    class="icon-reload-alt position-right"></i></button>
                            <button type="button" class="btn btn-primary" id="saveLoan">Submit <i
                                    class="icon-arrow-right14 position-right"></i></button>
                        </div>
                    </form>
                </div>
                <!-- /registration form -->

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
<script type="text/javascript" src="app/js/addLoan.js"></script>
</body>
</html>
