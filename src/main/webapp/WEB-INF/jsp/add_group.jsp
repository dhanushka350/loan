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
    <title>Add Borrower Groups</title>
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
<body onload="MEM_GROUP.allStaff();">

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
                        <li><a href="view_borrowers">Borrowers</a></li>
                        <li><a href="borrower_group">Groups</a></li>
                        <li class="active">Group Registration</li>
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
                            <legend class="text-bold">Create group
                                <small class="display-block">All fields are required</small>
                            </legend>

                            <!-- Basic text input -->
                            <div class="form-group">
                                <label class="control-label col-lg-3">Unique Name <span
                                        class="text-danger">*</span></label>
                                <div class="col-lg-9">
                                    <input type="text" name="basic" class="form-control" required="required"
                                           id="uniqueName"
                                           placeholder="unique name for identify group">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3">Area <span
                                        class="text-danger">*</span></label>
                                <div class="col-lg-9">
                                    <select name="default_select" class="form-control" required="required"
                                            id="area" onchange="">
                                        <option value="0">Select Located Area</option>
                                        <option value="Matara">Matara</option>
                                        <option value="Walgama">Walgama</option>
                                        <option value="Paburana">Paburana</option>
                                        <option value="Polhena">Polhena</option>
                                        <option value="Kamburugamuwa">Kamburugamuwa</option>
                                        <option value="Akurassa">Akurassa</option>
                                        <option value="Hakmana">Hakmana</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3">Maximum Members Count<span
                                        class="text-danger">*</span></label>
                                <div class="col-lg-9">
                                    <select name="default_select" class="form-control" required="required"
                                            id="borrower_count" onchange="">
                                        <option value="0">Select Members Count</option>
                                        <option value="3">3 - Members</option>
                                        <option value="5">5 - Members</option>
                                        <option value="7">7 - Members</option>
                                        <option value="10">10 - Members</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3">Collector <span
                                        class="text-danger">*</span></label>
                                <div class="col-lg-9">
                                    <select name="default_select" class="form-control" required="required"
                                            id="group_collector" onchange="">
                                        <option value="0">Select Collector</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3">Collection Day <span
                                        class="text-danger">*</span></label>
                                <div class="col-lg-9">
                                    <select name="default_select" class="form-control" required="required"
                                            id="collection_day" onchange="">
                                        <option value="1">Monday</option>
                                        <option value="2">Tuesday</option>
                                        <option value="3">Wednesday</option>
                                        <option value="4">Thursday</option>
                                        <option value="5">Friday</option>
                                        <option value="6">Saturday</option>
                                        <option value="7">Sunday</option>
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
                            <legend class="text-bold" style="color: red">Please double check above details before
                                registration
                            </legend>
                        </fieldset>
                    </form>
                    <div class="text-right">
                        <button class="btn btn-primary" id="submit_borrower">Register <i
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
<script type="text/javascript" src='app/js/MemberGroup.js'></script>
</body>
</html>
