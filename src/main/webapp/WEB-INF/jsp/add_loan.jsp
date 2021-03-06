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
<body onload="LOAN.allBorrowers();LOAN.allLoanTypes();" class="sidebar-xs has-detached-left">

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
                                <small style="text-align: center; color: red;display: none"
                                       id="stop_loan_process">
                                    <legend class="text-bold">sorry</legend>
                                    PLEASE NOTE :- This borrower has unfinished loan. We can not process this request
                                    until he/she
                                    finish
                                    payments of ongoing loan.
                                </small>
                                <small class="display-block" style="text-align: right"><a href="/borrower_details">Borrower Details and Loan History</a>
                                </small>
                            </legend>
                            <!-- Basic text input -->
                            <div class="form-group">
                                <label class="control-label col-lg-3">Borrower</label>
                                <div class="col-lg-9">
                                    <div class="form-group">
                                        <select class="select-search" id="borrower"
                                                onchange="LOAN.checkQualifications();">

                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3">Loan Product</label>
                                <div class="col-lg-9">
                                    <select name="default_select" class="form-control" required="required"
                                            id="loanType" onchange="LOAN.getLoanTypeDetails();">
                                        <option value="0">Select Loan Type</option>
                                    </select>
                                </div>
                            </div>
                            <legend class="text-bold stop">Loan terms :</legend>
                            <div class="form-group stop">
                                <label class="control-label col-lg-2">
                                    <small class="display-block text-bold col-lg-12" style="color: red">Principle Amount
                                    </small>
                                </label>
                                <div class="col-lg-2 form-group stop">
                                    <input type="text" id="principleAmount" name="basic" class="form-control col-lg-12"
                                           placeholder="Principal Amount"
                                           style="text-align: center; background-color: transparent;color: black;font-weight: bold;
                                           background-color: transparent; border: none;"
                                           disabled="disabled">
                                </div>
                                <label class="control-label col-lg-2 stop">
                                    <small class="display-block text-bold col-lg-12" style="color: red">Interest
                                    </small>
                                </label>
                                <div class="col-lg-2 form-group stop">
                                    <input type="text" id="interest" name="basic" class="form-control col-lg-12"
                                           placeholder="Interest"
                                           style="text-align: center; background-color: transparent;color: black;font-weight: bold;
                                                background-color: transparent; border: none;"
                                           disabled="disabled">
                                </div>
                                <label class="control-label col-lg-2 stop">
                                    <small class="display-block text-bold col-lg-12" style="color: red">Duration
                                        (weeks)
                                    </small>
                                </label>
                                <div class="col-lg-2 form-group stop">
                                    <input type="text" id="duration" name="basic" class="form-control col-lg-12"
                                           placeholder="Duration"
                                           style="text-align: center; background-color: transparent;color: black;font-weight: bold;
                                           background-color: transparent; border: none;"
                                           disabled="disabled">
                                </div>
                            </div>

                            <div class="form-group stop">
                                <label class="control-label col-lg-2">
                                    <small class="display-block text-bold col-lg-12" style="color: red">Weekly Charge
                                    </small>
                                </label>
                                <div class="col-lg-2 form-group">
                                    <input type="text" id="charge" name="basic" class="form-control col-lg-12"
                                           placeholder="Weekly Charge"
                                           style="text-align: center; background-color: transparent;color: black;font-weight: bold;
                                           background-color: transparent; border: none;"
                                           disabled="disabled">
                                </div>
                                <label class="control-label col-lg-2">
                                    <small class="display-block text-bold col-lg-12" style="color: red">Document Fee
                                    </small>
                                </label>
                                <div class="col-lg-2 form-group">
                                    <input type="text" id="doc_fee" name="basic" class="form-control col-lg-12"
                                           placeholder="Document Fee"
                                           style="text-align: center; background-color: transparent;color: black;font-weight: bold;
                                                background-color: transparent; border: none;"
                                           disabled="disabled">
                                </div>
                                <label class="control-label col-lg-2">
                                    <small class="display-block text-bold col-lg-12" style="color: red">Insurance Fee
                                    </small>
                                </label>
                                <div class="col-lg-2 form-group">
                                    <input type="text" id="insurance_fee" name="basic" class="form-control col-lg-12"
                                           placeholder="Insurance Fee"
                                           style="text-align: center; background-color: transparent;color: black;font-weight: bold;
                                           background-color: transparent; border: none;"
                                           disabled="disabled">
                                </div>
                            </div>
                            <div class="form-group stop">
                                <div class="col-lg-12">
                                    <textarea type="text" name="basic" class="form-control"
                                              placeholder="Description" id="desc"></textarea>
                                </div>
                            </div>
                        </fieldset>
                        <legend class="text-bold"></legend>
                        <div class="text-right stop">
                            <button type="reset" class="btn btn-default" id="reset">Reset <i
                                    class="icon-reload-alt position-right"></i></button>
                            <button type="button" class="btn btn-primary" id="saveLoan">Send for approval <i
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
