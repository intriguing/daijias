(function () {
    $.ajax({

        type: 'POST',
        url: "adminater/driver",
        dataType: "json",
        success: function (data) {
            var html;

            $.each(data.drivers, function (i, item) {
                html += "<tr>";
                html += "<td>" + item.id + "</td>";
                html += "<td>" + item.name + "</td>";
                if (item.sex = 0) {
                    html += "<td>男</td>";
                } else {
                    html += "<td>女</td>";
                }
                html += "<td>" + item.phone + "</td>";
                html += "<td>" + item.infor + "</td>";
                html += "<td>" + item.driverrange + "</td>";
                html += "<td>" + item.drivingYears + "</td>";
                if (item.status == 1) {
                    html += "<td><span class=\"label label-success label-mini\">上线</span></td>";
                    html += "<td> <div class=\"progress progress-striped progress-xs\"><div style=\"width:" +20*item.starLeave+"%\" aria-valuemax=\"100\" aria-valuemin=\"0\" aria-valuenow=\"40\" role=\"progressbar\" class=\"progress-bar progress-bar-success\"> <span class=\"sr-only\"> Complete (success)</span> </div> </div></td>";
                } else if (item.status == 2) {
                    html += "<td><span class=\"label label-info label-mini\">离线</span></td>";
                    html += "<td> <div class=\"progress progress-striped progress-xs\"><div style=\"width:" +20*item.starLeave+"%\" aria-valuemax=\"100\" aria-valuemin=\"0\" aria-valuenow=\"40\" role=\"progressbar\" class=\"progress-bar progress-bar-info\"> <span class=\"sr-only\"> Complete (success)</span> </div> </div></td>";
                } else {
                    html += "<td><span class=\"label label-danger label-mini\">忙碌</span></td>";
                    html += "<td> <div class=\"progress progress-striped progress-xs\"><div style=\"width:" +20*item.starLeave+"%\" aria-valuemax=\"100\" aria-valuemin=\"0\" aria-valuenow=\"40\" role=\"progressbar\" class=\"progress-bar progress-bar-warning\"> <span class=\"sr-only\"> Complete (success)</span> </div> </div></td>";
                }
                html += "</tr>";
            });
            $("#tbodyss").append(html);
        }
    });
    $.ajax({

        type: 'POST',
        url: "adminater/user",
        dataType: "json",
        success:function (data) {
            var html;
            $.each(data.usernames, function (i, item) {
            html += "<tr>";
            html += "<td>" + item.id + "</td>";
            html += "<td>" + item.name + "</td>";
            if (item.sex = 0) {
                html += "<td>男</td>";
            } else {
                html += "<td>女</td>";
            }
            html += "<td>" + item.phone + "</td>";
            html += "<td>" + item.infor + "</td>";
            html += "</tr>";
            });
            $("#tbodys2").append(html);
        }});
})(jQuery);