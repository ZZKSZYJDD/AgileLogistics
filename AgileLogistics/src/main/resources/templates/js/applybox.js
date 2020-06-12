$('#applyTable').bootstrapTable({
    contentType : "application/x-www-form-urlencoded; charset=UTF-8 ",

    url: 'selectApplyData',
    queryParams:queryApplyParam,
    method:"post",
    dataType:"json",
    pagination: true,
    sidePagination: "server", //server表示服务端分页，client客户端分页
    pageNumber:1,                       //初始化加载第一页，默认第一页
    pageSize: 5,                       //每页的记录行数（*）
    pageList: [5, 10, 25],        //可供选择的每页的行数（*）
    uniqueId: "id",
    striped: true,
    singleSelect:true,
    clickToSelect:true,
    showRefresh:true,
    
    showToggle:true,
    toolbar:"#apply-toolbar",
    responseHandler:responseApplyHandler,//请求数据成功后，渲染表格前的方法
    columns: [{
        field:"state",
        checkbox:"true"
    },{
        field: 'id',
        title: '报修ID'
    }, {
        field: 'applyOrderID',
        title: '报修单号',

    }, {
        field: 'building',
        title: '楼栋',

    }, {
        field: 'floor',
        title: '楼层'
    },{
        field: 'name',
        title: '设备名称',

    },{
        field: 'man',
        title: '报修人',

    },{
        field:"address",
        title:"详细地址"
    },{
        field:"url",
        title:"图片"
    },{
        field:"state",
        title:"状态"
    },{
        field:"updateTime",
        title:"更新时间"
    },{
        field:"remarks",
        title:"备注"
    }
    ]
});
function queryApplyParam(params){
    console.info(params);
    // this 表示当前的bootStrap-table 的实例
    console.log(this);
    var param = {
        queryName:$("#equipmentQueryName").val(),
        queryType:$("#equipmentQueryType").val(),
        limit : params.limit, // 数据集合大小
        offset : params.offset, // 页码
        pageIndex : this.pageNumber,
        pageSize : this.pageSize
    };
    console.info(param);
    return param;

}
function responseApplyHandler(res) {  //后台返回的结果
    if(res.code == "666"){
        var userInfo = res.data;
        var NewData = [];
        if (userInfo.length) {
            for (var i = 0; i < userInfo.length; i++) {
                var dataNewObj = {
                    'id': '',
                    "name": '',
                    'type': '',
                    'personLiable':'',
                    'remarks':'',
                    'updateTime':''
                };
                dataNewObj.id = userInfo[i].id;
                dataNewObj.name = userInfo[i].name;
                dataNewObj.type = userInfo[i].type;
                dataNewObj.personLiable = userInfo[i].personLiable;
                dataNewObj.remarks = userInfo[i].remarks;
                dataNewObj.updateTime = userInfo[i].updateTime;
                NewData.push(dataNewObj);
            }
        }
        return  {
            "total": res.total,
            "rows": NewData
        };
    }
}
function addApply() {
     var parms = $("#addEquipmentForm").serializeArray();
     var id = $("#inputEquipmentID").val();
     var url;
     if (id===""){
         url = "addEquipmentData";
     }else {
         url = "updateEquipmentData";
     }
     $.ajax({
         url:url,
         data:parms,
         method: "post",
         dataType: "json",
         success:function (result) {
             if (result.code=="1"){
                 alert(result.message);

             }else {
                 alert(result.message);
             }
             $("#addApplyModal").modal("hide");
             resertApplyForm();
             $("#applyTable").bootstrapTable("refresh");
         },
         timeout:10000,
         error:function (error) {
             alert("服务器请求超时");
         }
     })
}
function resertApplyForm() {
    $("#addApplyForm").find("input[type=text],input[type=hidden]").each(function () {
        $(this).val("");
    })
    
}
function updateApplyData() {
    var rows = $("#applyTable").bootstrapTable("getSelections")
    if(rows.length==0){
        alert("没有选中任何行，请选择");
         return;
    }
    var row = rows[0];
    console.log(row)
    $("#inputEquipmentID").val(row.id);
    $("#inputEquipmentName").val(row.name);
    $("#inputEquipmentType").val(row.type);
    $("#inputEquipmentPersonLiable").val(row.personLiable);
    $("#inputEquipmentRemarks").val(row.remarks);

    $("#addApplyModal").modal("show");
}

function selectApplyData() {
    $("#equipmentTable").bootstrapTable("refresh");
}
function deleteApplyData() {
    var rows = $("#applyTable").bootstrapTable("getSelections")
    if(rows.length==0){
        alert("没有选中任何行，请选择");
        return;
    }
    var answer = window.confirm("确定要删除该条数据吗？");
    console.log(answer);
    if (!answer){
        $("#equipmentTable").bootstrapTable("refresh");

        return;
    }
    var row = rows[0];
    var id = row.id;
    $.ajax({
        url:"deleteApplyData",
        data:{"id":id},
        method: "post",
        dataType: "json",
        success:function (result) {
            if (result.code=="1"){
                alert(result.message);
                $("#applyTable").bootstrapTable("refresh");
            }else {
                alert(result.message);
            }
            $("#addApplyModal").modal("hide");
            resertApplyForm();
        },
        timeout:10000,
        error:function (error) {
            alert("服务器请求超时");
        }
    })
}
