$('#submit_borrower').click(function (n) {
    n.preventDefault();
    BORROWER.addNewBorrower();

});
$('#uniqueID').keyup(function (n) {
    n.preventDefault();
    BORROWER.BorrowersIDCheck();

});

function load_js() {
    var head = document.getElementsByTagName('head')[0];
    var script = document.createElement('script');
    script.src = 'assets/js/plugins/tables/datatables/datatables.min.js';
    head.appendChild(script);
}

var BORROWER = {
    addNewBorrower: function () {
        var gender;
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1; //January is 0!
        var yyyy = today.getFullYear();

        if (dd < 10) {
            dd = '0' + dd
        }

        if (mm < 10) {
            mm = '0' + mm
        }

        today = mm + '/' + dd + '/' + yyyy;

        if ($('#male').is(':checked')) {
            gender = "Male";
        }
        if ($('#female').is(':checked')) {
            gender = "Female";
        }

        var a = document.getElementById("title");
        var title = a.options[a.selectedIndex].text;

        var b = document.getElementById("working_status");
        var working_status = b.options[b.selectedIndex].text;

        var e = {};
        e["uniqueID"] = $('#uniqueID').val();
        e["fname"] = $('#f_name').val();
        e["lname"] = $('#l_name').val();
        e["business"] = $("#business").val();
        e["gender"] = gender;
        e["title"] = title;
        e["mobile"] = $("#mobile").val();
        e["landphone"] = $("#land_phone").val();
        e["email"] = $("#email").val();
        e["regdate"] = today;
        e["address"] = $("#address").val();
        e["city"] = $("#city").val();
        e["province"] = $("#provice").val();
        e["workstatus"] = working_status;
        e["description"] = $("#desc").val();
        e["files"] = $("#borrower_files").val();
        e["registeredby"] = $.session.get("Logged_User");
        ;
        var d = JSON.stringify(e);
        $.ajax({
            url: '/api/rest/borrower/registration',
            dataType: 'json',
            contentType: "application/json",
            type: 'POST',
            data: d,
            success: function (data, textStatus, jqXHR) {
                if (data.status === 1) {
                    noty({
                        text: data.message,
                        layout: 'topRight',
                        type: 'success'
                    });
                    $('#uniqueID').val("");
                    $('#f_name').val("");
                    $('#l_name').val("");
                    $("#business").val("");
                    $("#mobile").val("");
                    $("#land_phone").val("");
                    $("#email").val("");
                    $("#address").val("");
                    $("#city").val("");
                    $("#provice").val("");
                    $("#desc").val("");
                } else {
                    noty({
                        text: data.message,
                        layout: 'topRight',
                        type: 'warning'
                    });
                }
                location.reload(true);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                noty(
                    {
                        text: 'Borrower registration failed!\n it seems some unexpected error in server.',
                        layout: 'topRight',
                        type: 'error'
                    }
                );
            },
            beforeSend: function (xhr) {
                noty({
                    text: "sending request",
                    layout: 'topRight',
                    type: 'info'
                });
            }
        });
    },
    allBorrowers: function () {

        $('#tbl_borrower tbody tr td').remove();
        $.ajax({
            url: "/api/rest/borrower/borrowersList",
            dataType: 'json',
            contentType: "application/json",
            type: 'GET',
            success: function (data, textStatus, jqXHR) {
                if (data.length <= 0) {
                    $('#tbl_borrower').append('<tr>\n\
                               <td colspan=9><p align="center">No records found in your database\n\
                               </p></td>\n\
                               </tr>');
                } else {
                    for (var i = 0; i < data.length; i++) {

                        $('#tbl_borrower').append('<tr style="height: 10px">\n\
                                    <td style="font-size: x-small;font-weight: bold;text-align: center">' + data[i].fname + " " + data[i].lname + '</td>\n\
                                    <td style="font-size: x-small;font-weight: bold;text-align: center">' + data[i].business + '</td>\n\
                                    <td style="font-size: x-small;font-weight: bold;text-align: center">' + data[i].uniqueID + '</td>\n\
                                    <td style="font-size: x-small;font-weight: bold;text-align: center">' + data[i].mobile + '</td>\n\
                                    <td style="font-size: x-small;font-weight: bold;text-align: center">' + data[i].email + '</td>\n\
                                    <td style="font-size: x-small;font-weight: bold;text-align: center">' + data[i].regdate + '</td>\n\
                                    <td style="font-size: x-small;font-weight: bold;text-align: center">' + data[i].registeredby + '</td>\n\
                                    <td class="text-center"><ul class="icons-list"><li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-menu9"></i></a><ul class="dropdown-menu dropdown-menu-right"><li><a href="#"><i class="icon-eye"></i> View</a></li><li><a href="#"><i class="icon-pen"></i> Modify</a></li><li><a href="#"><i class="icon-database-remove"></i> Remove</a></li></ul></li></ul></td>\n\
                                    </tr>');

                    }
                }

            },
            error: function (jqXHR, textStatus, errorThrown) {
                noty(
                    {
                        text: 'Error!\n can not load borrowers \n try again with refreshing page.',
                        layout: 'topRight',
                        type: 'error'
                    }
                );
            },
            beforeSend: function (xhr) {

            },

        });
    },
    BorrowersIDCheck: function () {
        var id = $('#uniqueID').val();
        $.ajax({
            url: "/api/rest/borrower/check_id",
            dataType: 'json',
            contentType: "application/json",
            type: 'GET',
            data: "id=" + id,
            success: function (data, textStatus, jqXHR) {
                $('#f_name').val(data.fname);
                $('#l_name').val(data.lname);
                $("#business").val(data.business);
                $("#mobile").val(data.mobile);
                $("#land_phone").val(data.landphone);
                $("#email").val(data.email);
                $("#address").val(data.address);
                $("#city").val(data.city);
                $("#provice").val(data.province);
                $("#desc").val(data.description);
                noty(
                    {
                        text: 'This unique ID is already in use for another borrower.',
                        layout: 'topRight',
                        type: 'information'
                    }
                );
                noty(
                    {
                        text: "Existing borrower's details are loaded",
                        layout: 'topRight',
                        type: 'info'
                    }
                );
            }

        })
        ;
    },
    allStaff: function () {
        $.ajax({
            url: "/api/rest/system_user/staffList",
            dataType: 'json',
            contentType: "application/json",
            type: 'GET',
            success: function (data, textStatus, jqXHR) {
                if (data.length <= 0) {
                    noty(
                        {
                            text: 'Please add some users !\n can not find any users in database.',
                            layout: 'topRight',
                            type: 'error'
                        }
                    );
                }
                for (var i = 0; i < data.length; i++) {
                    $('#role').append($('<option>', {
                        value: data[i].id,
                        text: data[i].role
                    }));
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                noty(
                    {
                        text: 'Error!\n can not load use roles \n refresh page and try again.',
                        layout: 'topRight',
                        type: 'error'
                    }
                );
            },
            beforeSend: function (xhr) {

            }
        });
    },
    allGroups: function () {
        $.ajax({
            url: "/api/rest/system_user/groupList",
            dataType: 'json',
            contentType: "application/json",
            type: 'GET',
            success: function (data, textStatus, jqXHR) {
                if (data.length <= 0) {
                    noty(
                        {
                            text: 'Please add some group !\n can not find any group in database.',
                            layout: 'topRight',
                            type: 'error'
                        }
                    );
                }
                for (var i = 0; i < data.length; i++) {
                    $('#borrower_group').append($('<option>', {
                        value: data[i].mgid,
                        text: data[i].name
                    }));
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                noty(
                    {
                        text: 'Error!\n can not load use roles \n refresh page and try again.',
                        layout: 'topRight',
                        type: 'error'
                    }
                );
            },
            beforeSend: function (xhr) {

            }
        });
    },
}