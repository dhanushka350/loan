function logout() {
    var e = {};
    e["name"] = $.session.get("Logged_User");
    e["password"] = "";

    var d = JSON.stringify(e);
    console.log("HO: " + d);
    $.ajax({
        url: '/api/rest/system_user/log_out',
        dataType: 'text',
        contentType: "application/json",
        type: 'POST',
        data: d,
        success: function (data, textStatus, jqXHR) {
            $.session.remove("Logged_User");
            window.location.replace("/");

        },
        error: function (jqXHR, textStatus, errorThrown) {
            noty(
                {
                    text: 'Something went wrong \n contact your administrator for complete your logout process. \n status -' + textStatus,
                    layout: 'topRight',
                    type: 'error'
                }
            );
        },
        beforeSend: function (xhr) {
            noty(
                {
                    text: 'Logging Out..',
                    layout: 'topRight',
                    type: 'info'
                }
            );
        }
    });
}