var EditableTable = function () {

    return {

        //main function to initiate the module
        init: function () {
            function ajax() {
                $.ajax({

                    type: 'POST',
                    url: "adminater/driver" ,
                    dataType: "json",
                    success: function (data) {
                        var html;

                        $.each(data.drivers, function(i, item){
                            html+="<tr>";
                            html+="<td>"+item.id+"</td>";
                            html+="<td>"+item.name+"</td>";
                            if(item.sex=0) {
                                html += "<td>男</td>";
                            }else{
                                html += "<td>女</td>";
                            }
                            html+="<td>"+item.phone+"</td>";
                            html+="<td>"+item.infor+"</td>";
                            html+="<td>"+item.driverrange+"</td>";
                            html+="<td>"+item.drivingYears+"</td>";
                            html+="<td>"+item.status+"</td>";
                            if(item.oauth==0){
                                html+="<td><input  type=\"button\" value=\"通过\" onclick='passOauth("+item.id+",1)'></td>";
                            }else {
                                html+="<td><input  type=\"button\" value=\"取消通过\" onclick='passOauth("+item.id+",0)'></td>";
                            }
                           /* html+="<td> <a href="+item.imageUrl+"class=\"MagicZoom MagicThumb\"><img src="+item.imageUrl+"id=\"main_img\"class=\"main_img\" style=\"width:20px; height:20px;\" /></a></td>";*/
                            html+="<td><a href="+item.imageUrl+">证明展示</a></td>"
                            html+="<td><a class=\"delete\" href=\"javascript:;\">Delete</a></td>";
                            html+="</tr>";
                        });
                        $("#tbodys").append(html);
                    }
                });
            }
            function restoreRow(oTable, nRow) {
                ajax();
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);

                for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
                    oTable.fnUpdate(aData[i], nRow, i, false);
                }

                oTable.fnDraw();
            }

            function editRow(oTable, nRow) {
                ajax();
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);
                jqTds[0].innerHTML = '<input type="text" class="form-control small" value="' + aData[0] + '">';
                jqTds[1].innerHTML = '<input type="text" class="form-control small" value="' + aData[1] + '">';
                jqTds[2].innerHTML = '<input type="text" class="form-control small" value="' + aData[2] + '">';
                jqTds[3].innerHTML = '<input type="text" class="form-control small" value="' + aData[3] + '">';
                jqTds[4].innerHTML = '<a class="edit" href="">Save</a>';
                jqTds[5].innerHTML = '<a class="cancel" href="">Cancel</a>';
            }

            function saveRow(oTable, nRow) {
                ajax();
                var jqInputs = $('input', nRow);
                oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
                oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
                oTable.fnUpdate(jqInputs[2].value, nRow, 2, false);
                oTable.fnUpdate(jqInputs[3].value, nRow, 3, false);
                oTable.fnUpdate('<a class="edit" href="">Edit</a>', nRow, 4, false);
                oTable.fnUpdate('<a class="delete" href="">Delete</a>', nRow, 5, false);
                oTable.fnDraw();
            }

            function cancelEditRow(oTable, nRow) {
                ajax();
                var jqInputs = $('input', nRow);
                oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
                oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
                oTable.fnUpdate(jqInputs[2].value, nRow, 2, false);
                oTable.fnUpdate(jqInputs[3].value, nRow, 3, false);
                oTable.fnUpdate('<a class="edit" href="">Edit</a>', nRow, 4, false);
                oTable.fnDraw();
            }
            ajax();
            var nEditing = null;

            $('#editable-sample_new').click(function (e) {
                e.preventDefault();
                var aiNew = oTable.fnAddData(['', '', '', '',
                        '<a class="edit" href="">Edit</a>', '<a class="cancel" data-mode="new" href="">Cancel</a>'
                ]);
                var nRow = oTable.fnGetNodes(aiNew[0]);
                editRow(oTable, nRow);
                nEditing = nRow;
            });

            $('#editable-sample a.delete').live('click', function (e) {
                e.preventDefault();

                if (confirm("Are you sure to delete this row ?") == false) {
                    return;
                }

                var nRow = $(this).parents('td').siblings().html();
                $.ajax({

                    type: 'POST',
                    url: "adminater/driverDelete" ,
                    data:{"driverId":nRow}

                });
                alert("Deleted! Do not forget to do some ajax to sync with backend :)");
            });

            $('#editable-sample a.cancel').live('click', function (e) {
                e.preventDefault();
                if ($(this).attr("data-mode") == "new") {
                    var nRow = $(this).parents('tr')[0];
                    oTable.fnDeleteRow(nRow);
                } else {
                    restoreRow(oTable, nEditing);
                    nEditing = null;
                }
            });

            $('#editable-sample a.edit').live('click', function (e) {
                e.preventDefault();

                /* Get the row as a parent of the link that was clicked on */
                var nRow = $(this).parents('tr')[0];

                if (nEditing !== null && nEditing != nRow) {
                    /* Currently editing - but not this row - restore the old before continuing to edit mode */
                    restoreRow(oTable, nEditing);
                    editRow(oTable, nRow);
                    nEditing = nRow;
                } else if (nEditing == nRow && this.innerHTML == "Save") {
                    /* Editing this row and want to save it */
                    saveRow(oTable, nEditing);
                    nEditing = null;
                    alert("Updated! Do not forget to do some ajax to sync with backend :)");
                } else {
                    /* No edit in progress - let's start one */
                    editRow(oTable, nRow);
                    nEditing = nRow;
                }
            });
        }

    };

}();