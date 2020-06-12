$('#regionTable').bootstrapTable({
    contentType : "application/x-www-form-urlencoded; charset=UTF-8 ",

    url: 'selectRegionData',
    queryParams:queryParam,
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
    toolbar:"#region-toolbar",
    responseHandler:responseHandler,//请求数据成功后，渲染表格前的方法
    columns: [{
        field:"state",
        checkbox:"true"
    },{
        field: 'id',
        title: 'ID'
    }, {
        field: 'building',
        title: '楼栋',

    }, {
        field: 'floor',
        title: '楼层'
    }]
});
function queryParam(params){
    console.info(params);
    // this 表示当前的bootStrap-table 的实例
    console.log(this);
    var param = {
        queryName:$("#regionQueryName").val(),
        limit : params.limit, // 数据集合大小
        offset : params.offset, // 页码
        pageIndex : this.pageNumber,
        pageSize : this.pageSize
    };
    console.info(param);
    return param;

}
function responseHandler(res) {  //后台返回的结果
    if(res.code == "666"){
        var userInfo = res.data;
        var NewData = [];
        if (userInfo.length) {
            for (var i = 0; i < userInfo.length; i++) {
                var dataNewObj = {
                    'id': '',
                    "building": '',
                    'floor': '',
                };
                dataNewObj.id = userInfo[i].id;
                dataNewObj.building = userInfo[i].building;
                dataNewObj.floor = userInfo[i].floor;
                NewData.push(dataNewObj);
            }
        }
        return  {
            "total": res.total,
            "rows": NewData
        };
    }
}
function addRegion() {
     var parms = $("#addRegionForm").serializeArray();
     var id = $("#inputRegionID").val();
     var url;
     if (id===""){
         url = "addRegionData";
     }else {
         url = "updateRegionData";
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
             $("#addRegionModal").modal("hide");
             resertForm();
             $("#regionTable").bootstrapTable("refresh");
         },
         timeout:10000,
         error:function (error) {
             alert("服务器请求超时");
         }
     })
}
function resertForm() {
    $("#addRegionForm").find("input[type=text],input[type=hidden]").each(function () {
        $(this).val("");
    })
    
}
function updateRegionData() {
    var rows = $("#regionTable").bootstrapTable("getSelections")
    if(rows.length==0){
        alert("没有选中任何行，请选择");
        return;
    }
    var row = rows[0];
    $("#inputRegionID").val(row.id);
    $("#inputRegionFloor").val(row.floor);
    $("#inputRegionBuilding").val(row.building);
    $("#addRegionModal").modal("show");

}
function selectRegionData() {
    $("#regionTable").bootstrapTable("refresh");
}
function deleteRegionData() {
    var rows = $("#regionTable").bootstrapTable("getSelections")
    if (rows.length == 0) {
        alert("没有选中任何行，请选择");
        return;
    }

    var answer = window.confirm("确定要删除该条数据吗？");
    console.log(answer);
    if (!answer) {
        $("#regionTable").bootstrapTable("refresh");

        return;
    }
    var row = rows[0];
    var id = row.id;
    $.ajax({
        url: "deleteRegionData",
        data: {"id": id},
        method: "post",
        dataType: "json",
        success: function (result) {
            if (result.code == "1") {
                alert(result.message);
                $("#regionTable").bootstrapTable("refresh");
            } else {
                alert(result.message);
            }
            $("#addRegionModal").modal("hide");
            resertForm();
        },
        timeout: 10000,
        error: function (error) {
            alert("服务器请求超时");
        }
    })
}