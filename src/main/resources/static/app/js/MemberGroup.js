$('#submit_borrower').click(function (n) {
    n.preventDefault();
    MEM_GROUP.addNewBorrowerGroup();

});
var MEM_GROUP = {
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
                    $('#group_collector').append($('<option>', {
                        value: data[i],
                        text: data[i]
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
    addNewBorrowerGroup: function () {

        // get values from drop down
        var a = document.getElementById("area");
        var area = a.options[a.selectedIndex].text;

        var b = document.getElementById("borrower_count");
        var borrower_count = b.options[b.selectedIndex].value;

        var c = document.getElementById("group_collector");
        var group_collector = c.options[c.selectedIndex].value;

        var d = document.getElementById("collection_day");
        var collection_day = d.options[d.selectedIndex].value;

        var e = document.getElementById("status");
        var status = e.options[e.selectedIndex].value;

        var e = {};
        e["name"] = $('#uniqueName').val();
        e["area"] = area;
        e["memberCount"] = borrower_count;
        e["collector"] = group_collector;
        e["collectionDay"] = collection_day;
        e["description"] = $("#desc").val();
        e["status"] = status;
        e["regBy"] = $.session.get("Logged_User");

        var data = JSON.stringify(e);
        $.ajax({
            url: '/api/rest/system_user/register_member_groups',
            dataType: 'json',
            contentType: "application/json",
            type: 'POST',
            data: data,
            success: function (data, textStatus, jqXHR) {
                if (data.status === 0) {
                    noty({
                        text: data.message,
                        layout: 'topRight',
                        type: 'success'
                    });

                } else {
                    noty({
                        text: data.message,
                        layout: 'topRight',
                        type: 'warning'
                    });
                }

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
    allGroups: function () {
        $('#tbl_borrower_group tbody tr td').remove(); // remove data

        $.ajax({
            url: "/api/rest/system_user/groupList",
            dataType: 'json',
            contentType: "application/json",
            type: 'GET',
            success: function (data, textStatus, jqXHR) {
                if (data.length <= 0) {
                    $('#tbl_borrower_group').append('<tr>\n\
                               <td colspan=9><p align="center">No records found in your database\n\
                               </p></td>\n\
                               </tr>');
                } else {

                    for (var i = 0; i < data.length; i++) {

                        var day = "";

                        if (data[i].collectionDay === "1") {
                            day = "Monday";
                        } else if (data[i].collectionDay === "2") {
                            day = "Tuesday";
                        } else if (data[i].collectionDay === "3") {
                            day = "Wednesday";
                        } else if (data[i].collectionDay === "4") {
                            day = "Thursday";
                        } else if (data[i].collectionDay === "5") {
                            day = "Friday";
                        } else if (data[i].collectionDay === "6") {
                            day = "Saturday";
                        } else if (data[i].collectionDay === "7") {
                            day = "Sunday";
                        }


                        $('#tbl_borrower_group').append('<tr style="height: 10px">\n\
                                    <td style="font-size: x-small;font-weight: bold;text-align: center">' + data[i].name + '</td>\n\
                                    <td style="font-size: x-small;font-weight: bold;text-align: center">' + data[i].memberCount + '</td>\n\
                                    <td style="font-size: x-small;font-weight: bold;text-align: center">' + day + '</td>\n\
                                    <td style="font-size: x-small;font-weight: bold;text-align: center">' + data[i].regDate + '</td>\n\
                                    <td style="font-size: x-small;font-weight: bold;text-align: center">' + data[i].regBy + '</td>\n\
                                    <td style="font-size: x-small;font-weight: bold;text-align: center">' + data[i].status + '</td>\n\
                                    <td style="font-size: x-small;font-weight: bold;text-align: center"><button class="btn btn-small" style="font-size: x-small;height: 10px;font-weight: bold;">Modify</button></td>\n\
                                    </tr>');

                    }
                }

            },
            error: function (jqXHR, textStatus, errorThrown) {
                noty(
                    {
                        text: 'Error!\n can not load groups \n try again with refreshing page.',
                        layout: 'topRight',
                        type: 'error'
                    }
                );
            },
            beforeSend: function (xhr) {

            },
        });
    },
}
