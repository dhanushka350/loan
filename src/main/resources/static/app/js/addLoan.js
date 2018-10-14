$('#saveLoan').click(function (n) {
    n.preventDefault();
    LOAN.addNewUser();

});


var LOAN = {
    allBorrowers: function () {
        $.ajax({
            url: "/api/rest/borrower/borrowersList",
            dataType: 'json',
            contentType: "application/json",
            type: 'GET',
            success: function (data, textStatus, jqXHR) {
                $('#borrower').append($('<option>', {
                    value: 0,
                    text: "Select Borrower"
                }));
                if (data.length <= 0) {
                    noty(
                        {
                            text: 'Please add some borrowers !\n can not find any borrowers in database.',
                            layout: 'topRight',
                            type: 'error'
                        }
                    );
                }

                for (var i = 0; i < data.length; i++) {
                    $('#borrower').append($('<option>', {
                        value: data[i].uniqueID,
                        text: "#unique " + data[i].uniqueID + " - " + data[i].title + " " + data[i].fname + " " + data[i].lname
                    }));
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                noty(
                    {
                        text: 'Error!\n can not load borrowers \n refresh page and try again.',
                        layout: 'topRight',
                        type: 'error'
                    }
                );
            },
            beforeSend: function (xhr) {

            }
        });
    },
    allLoanTypes: function () {
        $.ajax({
            url: "/api/rest/loan/request/loan/types",
            dataType: 'json',
            contentType: "application/json",
            type: 'GET',
            success: function (data, textStatus, jqXHR) {
                if (data.length <= 0) {
                    noty(
                        {
                            text: 'Please add some loan types !\n can not find any loan types in database.',
                            layout: 'topRight',
                            type: 'error'
                        }
                    );
                }

                for (var i = 0; i < data.length; i++) {
                    $('#loanType').append($('<option>', {
                        value: data[i].id,
                        text: data[i].loan
                    }));
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                noty(
                    {
                        text: 'Error!\n can not load loan type \n refresh page and try again.',
                        layout: 'topRight',
                        type: 'error'
                    }
                );
            },
            beforeSend: function (xhr) {

            }
        });
    },
    GeneratePaymentDates: function () {
        var e = document.getElementById("loanType");
        var sel_loan = e.options[e.selectedIndex].value;
        var duration = $('#duration').val();
        var fullAmount = 0;
        var interest = 0;
        var finalPayment = 0;

        jQuery('#dates div').html('');
        var Note = document.createElement('div');
        Note.innerHTML = '<legend class="text-bold">NOTE : Automatically Generated Payment Dates.<small>You can change this dates and amounts later..</small></legend>';
        document.getElementById('dates').appendChild(Note);

        $.ajax({
            url: "/api/rest/loan/generated/payments/dates?loan=" + sel_loan + "&duration=" + duration,
            dataType: 'json',
            contentType: "application/json",
            type: 'GET',
            success: function (data, textStatus, jqXHR) {

                for (var i = 0; i < data.length; i++) {
                    fullAmount = fullAmount + data[0].withoutInterest;
                    interest = interest + parseInt(data[i].interest);
                    finalPayment = finalPayment + data[i].amount;
                    var div1 = document.createElement('div');
                    div1.innerHTML =
                        '<div class="form-group">\n' +
                        '<label class="control-label col-lg-3"></label>\n' +
                        '<label class="control-label col-lg-1">Date : </label>\n' +
                        '<div class="col-lg-3">\n' +
                        '<input type="text" name="digits" value="' + data[i].date + '"style="text-align: center" class="form-control"\n' +
                        'placeholder="Payment Date" disabled="disabled">\n' +
                        '</div>' +
                        '<label class="control-label col-lg-1">Amount : </label>\n' +
                        '<div class="col-lg-3">\n' +
                        '<input type="text" name="digits" value="' + data[i].amount + '"style="text-align: center" class="form-control"\n' +
                        'placeholder="Payment Date" disabled="disabled">\n' +
                        '</div>\n' +
                        '</div>';
                    document.getElementById('dates').appendChild(div1);
                }

            },
            error: function (jqXHR, textStatus, errorThrown) {
                noty(
                    {
                        text: 'Error!\n can not generate dates automatically. \n try again with refreshing page.',
                        layout: 'topRight',
                        type: 'error'
                    }
                );
            },
            beforeSend: function (xhr) {

            }
        });
    },
    getLoanTypeDetails: function () {
        $("#principleAmount").val("");
        $("#interest").val("");
        $("#duration").val("");
        $("#charge").val("");
        $("#doc_fee").val("");
        $("#insurance_fee").val("");

        var e = document.getElementById("loanType");
        var sel_loan = parseInt(e.options[e.selectedIndex].value);
        if (sel_loan > 0) {
            $.ajax({
                url: "/api/rest/loan//get/loan_type/details?id=" + sel_loan,
                dataType: 'json',
                contentType: "application/json",
                type: 'GET',
                success: function (data, textStatus, jqXHR) {

                    $("#principleAmount").val(data.amount);
                    $("#interest").val(data.interest + " %");
                    $("#duration").val(data.duration);
                    $("#charge").val(data.charge);
                    $("#doc_fee").val(data.documentCharge);
                    $("#insurance_fee").val(data.insuranceCharge);
                    LOAN.GeneratePaymentDates();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    noty(
                        {
                            text: 'Error!\n can not get loan details \n try again with refreshing page.',
                            layout: 'topRight',
                            type: 'error'
                        }
                    );
                },
                beforeSend: function (xhr) {

                }
            });
        }
    },
    addNewUser: function () {

        var y = document.getElementById("borrower");
        var borrower = parseInt(y.options[y.selectedIndex].value);

        var z = document.getElementById("loanType");
        var type = parseInt(z.options[z.selectedIndex].value);

        var e = {};
        e["description"] = $("#desc").val();
        e["borrower"] = borrower;
        e["addedOfficer"] = $.session.get("Logged_User");
        e["type"] = type;

        var d = JSON.stringify(e);

        $.ajax({
            url: '/api/rest/loan/registration',
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
                } else {
                    noty(
                        {
                            text: data.message,
                            layout: 'topRight',
                            type: 'error'
                        }
                    );
                }

            },
            error: function (jqXHR, textStatus, errorThrown) {
                noty(
                    {
                        text: 'Loan registration failed!\n it seems some unexpected error in server.',
                        layout: 'topRight',
                        type: 'error'
                    }
                );
            },
            beforeSend: function (xhr) {

            }
        });
    },
    checkQualifications: function () {
        var e = document.getElementById("borrower");
        var sel_loan = parseInt(e.options[e.selectedIndex].value);
        if (sel_loan > 0) {
            $.ajax({
                url: "/api/rest/loan/check/qualifications?id=" + sel_loan,
                dataType: 'json',
                contentType: "application/json",
                type: 'GET',
                success: function (data, textStatus, jqXHR) {

                    if (data.status === 0) {
                        noty(
                            {
                                text: data.message,
                                layout: 'topCenter',
                                type: 'warning'
                            }
                        );

                        $(".stop").hide();
                        $("#stop_loan_process").show();

                    } else if (data.status === 1) {
                        noty(
                            {
                                text: data.message,
                                layout: 'topCenter',
                                type: 'information'
                            }
                        );
                        $(".stop").show();
                        $("#stop_loan_process").hide();
                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    noty(
                        {
                            text: 'ERROR ! \n Something went terribly wrong.\n Can Not check borrower qualifications. \n Requesting Developers Support.',
                            layout: 'topRight',
                            type: 'error'
                        }
                    );
                },
                beforeSend: function (xhr) {

                }
            });
        }
    },
}
