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
    <title>Add Borrowers</title>
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
    <script type="text/javascript" src="assets/js/plugins/forms/validation/validate.min.js"></script>
    <script type="text/javascript" src="assets/js/plugins/forms/selects/bootstrap_multiselect.js"></script>
    <script type="text/javascript" src="assets/js/plugins/forms/inputs/touchspin.min.js"></script>
    <script type="text/javascript" src="assets/js/plugins/forms/selects/select2.min.js"></script>
    <script type="text/javascript" src="assets/js/plugins/forms/styling/switch.min.js"></script>
    <script type="text/javascript" src="assets/js/plugins/forms/styling/switchery.min.js"></script>
    <script type="text/javascript" src="assets/js/plugins/forms/styling/uniform.min.js"></script>

    <script type="text/javascript" src="assets/js/core/app.js"></script>
    <script type="text/javascript" src="assets/js/pages/form_validation.js"></script>
    <!-- /theme JS files -->
</head>
<body onload="BORROWER.allGroups();">

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
                        <li><a href="index.html"><i class="icon-home2 position-left"></i> Home</a></li>
                        <li class="active">Borrower Registration</li>
                    </ul>

                    <ul class="breadcrumb-elements">
                        <li><a href="#"><i class="icon-comment-discussion position-left"></i> Support</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="icon-gear position-left"></i>
                                Settings
                                <span class="caret"></span>
                            </a>

                            <ul class="dropdown-menu dropdown-menu-right">
                                <li><a href="#"><i class="icon-user-lock"></i> Account security</a></li>
                                <li><a href="#"><i class="icon-statistics"></i> Analytics</a></li>
                                <li><a href="#"><i class="icon-accessibility"></i> Accessibility</a></li>
                                <li class="divider"></li>
                                <li><a href="#"><i class="icon-gear"></i> All settings</a></li>
                            </ul>
                        </li>
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
                            <legend class="text-bold">Create account
                                <small class="display-block">All fields are required</small>
                            </legend>

                            <!-- Basic text input -->
                            <div class="form-group">
                                <label class="control-label col-lg-3">Unique Number <span
                                        class="text-danger">*</span></label>
                                <div class="col-lg-9">
                                    <input type="text" name="basic" class="form-control" required="required"
                                           id="uniqueID"
                                           placeholder="You can enter unique number to identify the borrower such as Social Security Number, License #, Registration Id....">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3">First Name <span
                                        class="text-danger">*</span></label>
                                <div class="col-lg-9">
                                    <input type="text" name="basic" class="form-control" required="required"
                                           placeholder="Enter First Name Only" id="f_name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3">Middle / Last Name <span
                                        class="text-danger">*</span></label>
                                <div class="col-lg-9">
                                    <input type="text" name="basic" class="form-control" required="required"
                                           placeholder="Middle and Last Name" id="l_name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-4">
                                </label>
                                <div class="col-lg-8">
                                    <label class="control-label" style="font-weight: bold;">AND/OR</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3">Business Name</label>
                                <div class="col-lg-9">
                                    <input type="text" name="basic" class="form-control" required="required"
                                           placeholder="Business Name" id="business">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3">Group <span
                                        class="text-danger">*</span></label>
                                <div class="col-lg-9">
                                    <select name="default_select" class="form-control" required="required"
                                            id="borrower_group" onchange="">
                                        <option value="0">Select Borrower Group</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3"></label>
                                <div class="col-lg-9">
                                    <legend class="text-bold"></legend>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3">Gender <span
                                        class="text-danger">*</span></label>
                                <div class="col-lg-9">
                                    <label class="radio-inline">
                                        <input type="radio" name="styled_inline_radio" class="styled"
                                               required="required" id="male">
                                        Male
                                    </label>

                                    <label class="radio-inline">
                                        <input type="radio" name="styled_inline_radio" class="styled" id="female">
                                        Female
                                    </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3">Title <span
                                        class="text-danger">*</span></label>
                                <div class="col-lg-9">
                                    <select name="default_select" class="form-control" required="required" id="title">
                                        <option value="Mr">Mr.</option>
                                        <option value="Mrs">Mrs.</option>
                                        <option value="Miss">Miss.</option>
                                        <option value="Ms">Ms.</option>
                                        <option value="Dr">Dr.</option>
                                        <option value="Prof">Prof.</option>
                                        <option value="Rev">Rev.</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3">Mobile <span
                                        class="text-danger">*</span></label>
                                <div class="col-lg-9">
                                    <input type="text" name="digits" class="form-control" required="required"
                                           id="mobile"
                                           placeholder="Do not put country code, spaces, or characters in mobile otherwise you won't be able to send SMS to this mobile.">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3">Land line Phone </label>
                                <div class="col-lg-9">
                                    <input type="text" name="digits" class="form-control"
                                           placeholder="Landline Phone" id="land_phone">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3">Email </label>
                                <div class="col-lg-9">
                                    <input type="email" name="email" class="form-control" id="email" required="required"
                                           placeholder="Notifications and reminders will send to this email address">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3">Address <span
                                        class="text-danger">*</span></label>
                                <div class="col-lg-9">
                                    <input type="text" name="basic" class="form-control" required="required"
                                           placeholder="Address" id="address">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3">City <span
                                        class="text-danger">*</span></label>
                                <div class="col-lg-9">
                                    <input type="text" name="basic" class="form-control" required="required"
                                           placeholder="City" id="city">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3">Province / State <span
                                        class="text-danger">*</span></label>
                                <div class="col-lg-9">
                                    <input type="text" name="basic" class="form-control" required="required"
                                           placeholder="Province or State" id="provice">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3">Working Status <span
                                        class="text-danger">*</span></label>
                                <div class="col-lg-9">
                                    <select name="default_select" class="form-control" required="required"
                                            id="working_status">
                                        <option value="Employee">Employee</option>
                                        <option value="Owner">Owner</option>
                                        <option value="Student">Student</option>
                                        <option value="Overseas_Worker">Overseas Worker</option>
                                        <option value="Pensioner">Pensioner</option>
                                        <option value="Unemployed">Unemployed</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3">Description </label>
                                <div class="col-lg-9">
                                    <textarea rows="5" cols="5" name="textarea" class="form-control"
                                              placeholder="Description" id="desc"></textarea>
                                </div>
                            </div>
                            <%--<div class="form-group">--%>
                            <%--<label class="control-label col-lg-3">Borrower Files <span--%>
                            <%--class="text-danger">(disabled)</span></label>--%>
                            <%--<div class="col-lg-9" style="cursor: wait">--%>
                            <%--<input type="file" name="styled_file" class="file-styled"--%>
                            <%--id="borrower_files" disabled="disabled" placeholder="inactive">--%>
                            <%--</div>--%>
                            <%--</div>--%>
                            <legend class="text-bold"></legend>
                        </fieldset>
                    </form>
                    <div class="text-right">
                        <button type="reset" class="btn btn-default" id="reset">Reset <i
                                class="icon-reload-alt position-right"></i></button>
                        <button class="btn btn-primary" id="submit_borrower">Submit <i
                                class="icon-arrow-right14 position-right"></i></button>
                    </div>
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
<script type="text/javascript" src="app/js/Borrower.js"></script>
</body>
</html>
