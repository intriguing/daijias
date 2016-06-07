var EditableTable = function () {

    return {
        init: function () {
            function ajax() {
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
                            if (item.sex == 0) {
                                html += "<td>男</td>";
                            } else {
                                html += "<td>女</td>";
                            }
                            html += "<td>" + item.phone + "</td>";
                            html += "<td>" + item.infor + "</td>";
                            html += "<td>" + item.driverrange + "</td>";
                            html += "<td>" + item.drivingYears + "</td>";
                            html += "<td>" + item.status + "</td>";
                            if (item.oauth == 0) {
                                html += "<td><input  type=\"button\" value=\"通过\" onclick='passOauth(" + item.id + ",1)'></td>";
                            } else {
                                html += "<td><input  type=\"button\" value=\"取消通过\" onclick='passOauth(" + item.id + ",0)'></td>";
                            }
                            /* html+="<td> <a href="+item.imageUrl+"class=\"MagicZoom MagicThumb\"><img src="+item.imageUrl+"id=\"main_img\"class=\"main_img\" style=\"width:20px; height:20px;\" /></a></td>";*/
                            html += "<td><a href=" + item.imageUrl + ">show</a></td>";
                            html += "<td><a class=\"edit\" href=\"javascript:;\">Edit</a></td>";
                            html += "<td><a class=\"delete\" href=\"javascript:;\">Delete</a></td>";
                            html += "</tr>";
                        });
                        $("#tbodys").append(html);
                    }
                });
            }

            function restoreRow(nRow) {
                var jqTds = $('>td', nRow);
                $.ajax({
                    type: 'POST',
                    url: "adminater/driverById",
                    data: {"driverId": jqTds[0].innerHTML},
                    success: function (data) {
                        jqTds[1].innerHTML = data.driver.name;
                        if (data.driver.sex == 0) {
                            jqTds[2].innerHTML = "男";
                        } else {
                            jqTds[2].innerHTML = "女";
                        }
                        jqTds[3].innerHTML = data.driver.phone;
                        jqTds[4].innerHTML = data.driver.infor;
                        jqTds[5].innerHTML = data.driver.driverrange;
                        jqTds[6].innerHTML = data.driver.drivingYears;
                        jqTds[7].innerHTML = data.driver.status;
                        jqTds[10].innerHTML = '<a class="edit" href="">Edit</a>';
                        jqTds[11].innerHTML = '<a class="delete" href="">Delete</a>';
                    }
                });
            }

            function editRow(nRow) {
                var jqTds = $('>td', nRow);
                jqTds[1].innerHTML = '<input type="text" class="form-control small" value="' + jqTds[1].innerHTML + '">';
                jqTds[2].innerHTML = '<input type="text" class="form-control small" value="' + jqTds[2].innerHTML + '">';
                jqTds[3].innerHTML = '<input type="text" class="form-control small" value="' + jqTds[3].innerHTML + '">';
                jqTds[4].innerHTML = '<input type="text" class="form-control small" value="' + jqTds[4].innerHTML + '">';
                jqTds[5].innerHTML = '<input type="text" class="form-control small" value="' + jqTds[5].innerHTML + '">';
                jqTds[6].innerHTML = '<input type="text" class="form-control small" value="' + jqTds[6].innerHTML + '">';
                jqTds[7].innerHTML = '<input type="text" class="form-control small" value="' + jqTds[7].innerHTML + '">';
                jqTds[10].innerHTML = '<a class="edit" href="">Save</a>';
                jqTds[11].innerHTML = '<a class="cancel" href="">Cancel</a>';
            }

            function saveRow(nRow) {
                var jqInputs = $('input', nRow);
                var jqTds = $('>td', nRow);
                jqTds[1].innerHTML = jqInputs[0].value;
                jqTds[2].innerHTML = jqInputs[1].value;
                jqTds[3].innerHTML = jqInputs[2].value;
                jqTds[4].innerHTML = jqInputs[3].value;
                jqTds[5].innerHTML = jqInputs[4].value;
                jqTds[6].innerHTML = jqInputs[5].value;
                jqTds[7].innerHTML = jqInputs[6].value;
                jqTds[10].innerHTML = '<a class="edit" href="">Edit</a>';
                jqTds[11].innerHTML = '<a class="delete" href="">Delete</a>';
                var sex;
                if (jqInputs[1].value == '男') {
                    sex = 0;
                } else {
                    sex = 1;
                }

                $.ajax({
                    type: 'POST',
                    url: "adminater/driverUpdate",
                    data: {
                        "driverId": jqTds[0].innerHTML,
                        "name": jqInputs[0].value,
                        "sex": sex,
                        "phone": jqInputs[2].value,
                        "infor": jqInputs[3].value,
                        "driverrange": jqInputs[4].value,
                        "drivingYears": jqInputs[5].value,
                        "status": jqInputs[6].value
                    },
                    success: function (data) {
                        if (data == 'false') {
                            alert("保存失敗");
                        }
                    }
                });

            }

            ajax();

            var nEditing = null;

            $('#editable-sample_new').click(function (e) {
                e.preventDefault();
                var aiNew = oTable.fnAddData(['', '', '', '',
                    '<a class="edit" href="">Edit</a>', '<a class="cancel" data-mode="new" href="">Cancel</a>'
                ]);
                var nRow = oTable.fnGetNodes(aiNew[0]);
                editRow(Row);
                nEditing = nRow;
            });

            $('#editable-sample a.delete').live('click', function (e) {
                e.preventDefault();

                if (confirm("你真的要删除这一行吗?") == false) {
                    return;
                }

                var nRow = $(this).parents('td').siblings().html();
                $.ajax({

                    type: 'POST',
                    url: "adminater/driverDelete",
                    data: {"driverId": nRow}

                });
                alert("删除成功");
            });

            $('#editable-sample a.cancel').live('click', function (e) {
                e.preventDefault();
                if ($(this).attr("data-mode") == "new") {
                    var nRow = $(this).parents('tr')[0];
                    oTable.fnDeleteRow(nRow);
                } else {
                    restoreRow(nEditing);
                    nEditing = null;
                }
            });

            $('#editable-sample a.edit').live('click', function (e) {
                e.preventDefault();

                var nRow = $(this).parents('tr')[0];

                if (nEditing !== null && nEditing != nRow) {
                    restoreRow(nEditing);
                    editRow(nRow);
                    nEditing = nRow;
                } else if (nEditing == nRow && this.innerHTML == "Save") {
                    saveRow(nEditing);
                    nEditing = null;
                } else {
                    editRow(nRow);
                    nEditing = nRow;
                }
            });
            $('#keywordText').keypress(function (event) {
                var keycode = (event.keyCode ? event.keyCode : event.which);
                if (keycode == '13') {
                    if (!isNaN($('#keywordText').val())) {
                        if ($('#keywordText').val() == "") {
                            $.ajax({
                                type: 'POST',
                                url: "adminater/driver",
                                dataType: "json",
                                success: function (data) {
                                    var html;
                                    $("#tbodys").html("");
                                    $.each(data.drivers, function (i, item) {
                                        html += "<tr>";
                                        html += "<td>" + item.id + "</td>";
                                        html += "<td>" + item.name + "</td>";
                                        if (item.sex == 0) {
                                            html += "<td>男</td>";
                                        } else {
                                            html += "<td>女</td>";
                                        }
                                        html += "<td>" + item.phone + "</td>";
                                        html += "<td>" + item.infor + "</td>";
                                        html += "<td>" + item.driverrange + "</td>";
                                        html += "<td>" + item.drivingYears + "</td>";
                                        html += "<td>" + item.status + "</td>";
                                        if (item.oauth == 0) {
                                            html += "<td><input  type=\"button\" value=\"通过\" onclick='passOauth(" + item.id + ",1)'></td>";
                                        } else {
                                            html += "<td><input  type=\"button\" value=\"取消通过\" onclick='passOauth(" + item.id + ",0)'></td>";
                                        }
                                        /* html+="<td> <a href="+item.imageUrl+"class=\"MagicZoom MagicThumb\"><img src="+item.imageUrl+"id=\"main_img\"class=\"main_img\" style=\"width:20px; height:20px;\" /></a></td>";*/
                                        html += "<td><a href=" + item.imageUrl + ">show</a></td>";
                                        html += "<td><a class=\"edit\" href=\"javascript:;\">Edit</a></td>";
                                        html += "<td><a class=\"delete\" href=\"javascript:;\">Delete</a></td>";
                                        html += "</tr>";
                                    });
                                    $("#tbodys").append(html);
                                }
                            });
                        } else {
                            $.ajax({

                                type: 'POST',
                                url: "adminater/driverSearchAll",
                                data: {"keyword": $('#keywordText').val()},
                                success: function (data) {
                                    var html;
                                    $("#tbodys").html("");
                                    $.each(data.drivers, function (i, item) {
                                        html += "<tr>";
                                        html += "<td>" + item.id + "</td>";
                                        html += "<td>" + item.name + "</td>";
                                        if (item.sex == 0) {
                                            html += "<td>男</td>";
                                        } else {
                                            html += "<td>女</td>";
                                        }
                                        html += "<td>" + item.phone + "</td>";
                                        html += "<td>" + item.infor + "</td>";
                                        html += "<td>" + item.driverrange + "</td>";
                                        html += "<td>" + item.drivingYears + "</td>";
                                        html += "<td>" + item.status + "</td>";
                                        if (item.oauth == 0) {
                                            html += "<td><input  type=\"button\" value=\"通过\" onclick='passOauth(" + item.id + ",1)'></td>";
                                        } else {
                                            html += "<td><input  type=\"button\" value=\"取消通过\" onclick='passOauth(" + item.id + ",0)'></td>";
                                        }
                                        /* html+="<td> <a href="+item.imageUrl+"class=\"MagicZoom MagicThumb\"><img src="+item.imageUrl+"id=\"main_img\"class=\"main_img\" style=\"width:20px; height:20px;\" /></a></td>";*/
                                        html += "<td><a href=" + item.imageUrl + ">show</a></td>";
                                        html += "<td><a class=\"edit\" href=\"javascript:;\">Edit</a></td>";
                                        html += "<td><a class=\"delete\" href=\"javascript:;\">Delete</a></td>";
                                        html += "</tr>";
                                    });
                                    $("#tbodys").append(html);
                                }

                            });
                        }
                    } else {
                        $.ajax({

                            type: 'POST',
                            url: "adminater/driverSearchString",
                            data: {"keyword": $('#keywordText').val()},
                            success: function (data) {
                                var html;
                                $("#tbodys").html("");
                                $.each(data.drivers, function (i, item) {
                                    html += "<tr>";
                                    html += "<td>" + item.id + "</td>";
                                    html += "<td>" + item.name + "</td>";
                                    if (item.sex == 0) {
                                        html += "<td>男</td>";
                                    } else {
                                        html += "<td>女</td>";
                                    }
                                    html += "<td>" + item.phone + "</td>";
                                    html += "<td>" + item.infor + "</td>";
                                    html += "<td>" + item.driverrange + "</td>";
                                    html += "<td>" + item.drivingYears + "</td>";
                                    html += "<td>" + item.status + "</td>";
                                    if (item.oauth == 0) {
                                        html += "<td><input  type=\"button\" value=\"通过\" onclick='passOauth(" + item.id + ",1)'></td>";
                                    } else {
                                        html += "<td><input  type=\"button\" value=\"取消通过\" onclick='passOauth(" + item.id + ",0)'></td>";
                                    }
                                    /* html+="<td> <a href="+item.imageUrl+"class=\"MagicZoom MagicThumb\"><img src="+item.imageUrl+"id=\"main_img\"class=\"main_img\" style=\"width:20px; height:20px;\" /></a></td>";*/
                                    html += "<td><a href=" + item.imageUrl + ">show</a></td>";
                                    html += "<td><a class=\"edit\" href=\"javascript:;\">Edit</a></td>";
                                    html += "<td><a class=\"delete\" href=\"javascript:;\">Delete</a></td>";
                                    html += "</tr>";
                                });
                                $("#tbodys").append(html);
                            }

                        });
                    }
                }
            });
        }

    };

}();