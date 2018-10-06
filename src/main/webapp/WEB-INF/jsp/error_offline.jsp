<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Offline</title>

    <!-- Global stylesheets -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700,900" rel="stylesheet"
          type="text/css">
    <link href="/assets/css/icons/icomoon/styles.css" rel="stylesheet" type="text/css">
    <link href="/assets/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="/assets/css/core.css" rel="stylesheet" type="text/css">
    <link href="/assets/css/components.css" rel="stylesheet" type="text/css">
    <link href="/assets/css/colors.css" rel="stylesheet" type="text/css">
    <!-- /global stylesheets -->

    <!-- Core JS files -->
    <script type="text/javascript" src="/assets/js/plugins/loaders/pace.min.js"></script>
    <script type="text/javascript" src="/assets/js/core/libraries/jquery.min.js"></script>
    <script type="text/javascript" src="/assets/js/core/libraries/bootstrap.min.js"></script>
    <script type="text/javascript" src="/assets/js/plugins/loaders/blockui.min.js"></script>
    <!-- /core JS files -->


    <!-- Theme JS files -->
    <script type="text/javascript" src="/assets/js/core/app.js"></script>
    <!-- /theme JS files -->

</head>

<body class="login-container">

<!-- Main navbar -->
<%--<jsp:include page="common/main_top_nav.jsp"/>--%>
<!-- /main navbar -->


<!-- Page container -->
<div class="page-container">

    <!-- Page content -->
    <div class="page-content">

        <!-- Main content -->
        <div class="content-wrapper">

            <!-- Content area -->
            <div class="content">

                <!-- Error title -->
                <div class="text-center content-group">
                    <h1 class="error-title offline-title">Offline</h1>
                    <h5>Sorry, this section is temporary offline</h5>
                    <h4 style="font-weight: bold; color: red">Upgrade Your System For Use This Feature</h4>
                </div>
                <!-- /error title -->


                <!-- Error content -->
                <div class="row">
                    <div class="col-lg-4 col-lg-offset-4 col-sm-6 col-sm-offset-3">
                        <form action="#" class="main-search">
                            <div class="input-group content-group">
                                <input type="text" class="form-control input-lg" placeholder="Search">

                                <div class="input-group-btn">
                                    <button type="submit" class="btn bg-slate-600 btn-icon btn-lg"><i
                                            class="icon-search4"></i></button>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-sm-6">
                                    <a href="/admin_dash" class="btn btn-primary btn-block content-group"><i
                                            class="icon-circle-left2 position-left"></i> Go to dashboard</a>
                                </div>

                                <div class="col-sm-6">
                                    <a href="/admin_dash" class="btn btn-default btn-block content-group"><i
                                            class="icon-menu7 position-left"></i> Advanced search</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /error wrapper -->


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
