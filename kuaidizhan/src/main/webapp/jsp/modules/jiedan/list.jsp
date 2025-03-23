<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">


<head>
    <%@ include file="../../static/head.jsp" %>
    <!-- font-awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
</head>
<style>

</style>
<body>
<!-- Pre Loader -->
<div class="loading">
    <div class="spinner">
        <div class="double-bounce1"></div>
        <div class="double-bounce2"></div>
    </div>
</div>
<!--/Pre Loader -->
<div class="wrapper">
    <!-- Page Content -->
    <div id="content">
        <!-- Top Navigation -->
        <%@ include file="../../static/topNav.jsp" %>
        <!-- Menu -->
        <div class="container menu-nav">
            <nav class="navbar navbar-expand-lg lochana-bg text-white">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="ti-menu text-white"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul id="navUl" class="navbar-nav mr-auto">
                    </ul>
                </div>
            </nav>
        </div>
        <!-- /Menu -->
        <!-- Breadcrumb -->
        <!-- Page Title -->
        <div class="container mt-0">
            <div class="row breadcrumb-bar">
                <div class="col-md-6">
                    <h3 class="block-title">快递接单表管理</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">快递接单表管理</li>
                        <li class="breadcrumb-item active">快递接单表列表</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- /Page Title -->

        <!-- /Breadcrumb -->
        <!-- Main Content -->
        <div class="container">

            <div class="row">
                <!-- Widget Item -->
                <div class="col-md-12">
                    <div class="widget-area-2 lochana-box-shadow">
                        <h3 class="widget-title">快递接单表列表</h3>
                        <div class="table-responsive mb-3">
                            <div class="col-sm-12">
                                                                                                                                                                 
                                        <label>
                                            发布时间
                                            <input type="datetime-local" id="initiateTimeStartSearch" style="width: 190px;" class="form-control " placeholder="开始" aria-controls="tableId">
                                        </label>
                                            -
                                        <label>
                                            <input type="datetime-local" id="initiateTimeEndSearch" style="width: 190px;"  class="form-control" placeholder="结束" aria-controls="tableId">
                                        </label>
                                                                                                                                                                 
                                            <label>
                                                快递状态
                                                <select name="jdztTypesSelectSearch" style="width: 100px;" id="jdztTypesSelectSearch" class="form-control form-control-sm"
                                                        aria-controls="tableId">
                                                </select>
                                            </label>
                                 
                                            <label>
                                                快递类型
                                                <select name="kdlxTypesSelectSearch" style="width: 100px;" id="kdlxTypesSelectSearch" class="form-control form-control-sm"
                                                        aria-controls="tableId">
                                                </select>
                                            </label>


                                <button onclick="search()" type="button" class="btn btn-primary">查询</button>
                                <br/>
                                <button type="button" data-target="#exampleModal" data-toggle="modal" class="btn btn-success 寄件">寄件</button>
                                <button onclick="graph()" type="button" class="btn btn-success 报表">报表</button>
                                <button onclick="deleteMore()" type="button" class="btn btn-danger 删除">批量删除</button>
                            </div>
                            <table id="tableId" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th class="no-sort" style="min-width: 35px;">
                                        <div class="custom-control custom-checkbox">
                                            <input class="custom-control-input" type="checkbox" id="select-all"
                                                   onclick="chooseAll()">
                                            <label class="custom-control-label" for="select-all"></label>
                                        </div>
                                    </th>

                                    <th >单号</th>
                                    <th >快递名</th>
                                    <th >发布人</th>
                                    <th >收件人</th>
                                    <th >电话</th>
                                    <th >地址</th>
                                    <th >(取/寄)件码</th>
                                    <th >快递状态</th>
                                    <th >快递类型</th>
                                    <th >发布时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody id="thisTbody">
                                </tbody>
                            </table>
                            <div class="col-md-6 col-sm-3">
                                <div class="dataTables_length" id="tableId_length">

                                    <select name="tableId_length" aria-controls="tableId" id="selectPageSize"
                                            onchange="changePageSize()">
                                        <option value="10">10</option>
                                        <option value="25">25</option>
                                        <option value="50">50</option>
                                        <option value="100">100</option>
                                    </select>
                                    条 每页

                                </div>
                            </div>
                            <nav aria-label="Page navigation example">
                                <ul class="pagination justify-content-end">
                                    <li class="page-item" id="tableId_previous" onclick="pageNumChange('pre')">
                                        <a class="page-link" href="#" tabindex="-1">上一页</a>
                                    </li>

                                    <li class="page-item" id="tableId_next" onclick="pageNumChange('next')">
                                        <a class="page-link" href="#">下一页</a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
                <!-- /Widget Item -->
            </div>
        </div>
        <!-- /Main Content -->

        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">任务发布设置</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-sm-4" style="margin-top: 8px">
                                快递名称：
                            </div>
                            <div class="col-sm-8">
                                <input id="kdname" class="form-control"/>
                            </div>
                            </br>
                            </br>
                            <div class="col-sm-4" style="margin-top: 8px">
                                请选择收件人：
                            </div>
                            <div class="col-sm-8">
                                <select id="yhSelectSearch" class="form-control">
                                </select>
                            </div>
                            </br>
                            </br>
                            <div class="col-sm-4" style="margin-top: 8px">
                                请选择快递大小：
                            </div>
                            <div class="col-sm-8">
                                <select id="kddxSelectSearch" class="form-control">
                                </select>
                            </div>
                        </div>
                        </br>
                        <div class="row" id="div1"></div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                        <button type="button" id="receive" class="btn btn-primary">发布</button>
                    </div>
                </div>
            </div>
        </div>



    </div>
    <!-- /Page Content -->
</div>
<!-- Back to Top -->
<a id="back-to-top" href="#" class="back-to-top">
    <span class="ti-angle-up"></span>
</a>
<!-- /Back to Top -->
<%@ include file="../../static/foot.jsp" %>
<script language="javascript" type="text/javascript"
        src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js"></script>

<script>
    <%@ include file="../../utils/menu.jsp"%>
            <%@ include file="../../static/setMenu.js"%>
            <%@ include file="../../utils/baseUrl.jsp"%>
            <%@ include file="../../static/getRoleButtons.js"%>
            <%@ include file="../../static/crossBtnControl.js"%>
    var tableName = "jiedan";
    var pageType = "list";
    var searchForm = {key: ""};
    var pageIndex = 1;
    var pageSize = 10;
    var totalPage = 0;
    var dataList = [];
    var sortColumn = '';
    var sortOrder = '';
    var ids = [];
    var checkAll = false;


    var jdztTypesOptions = [];
    var kdlxTypesOptions = [];
    var yonghuOptions = [];
    var kddxOptions = [];

    function init() {
        // 满足条件渲染提醒接口
    }

    // 改变每页记录条数
    function changePageSize() {
        var selection = document.getElementById('selectPageSize');
        var index = selection.selectedIndex;
        pageSize = selection.options[index].value;
        getDataList();
    }



    // 查询
    function search() {
        searchForm = {key: ""};

        <!-- 级联表的级联字典表 -->
    <!-- 本表的查询条件 -->
                     
        var initiateTimeStartSearch = $('#initiateTimeStartSearch');
        if( initiateTimeStartSearch != null){
            if (initiateTimeStartSearch.val() != null && initiateTimeStartSearch.val() != '') {
                searchForm.initiateTimeStart = $('#initiateTimeStartSearch').val();
            }
        }
        var initiateTimeEndSearch = $('#initiateTimeEndSearch');
        if( initiateTimeEndSearch != null){
            if (initiateTimeEndSearch.val() != null && initiateTimeEndSearch.val() != '') {
                searchForm.initiateTimeEnd = $('#initiateTimeEndSearch').val();
            }
        }
                     
            //快递状态
        var jdztTypesSelectSearchInput = document.getElementById("jdztTypesSelectSearch");
        if(jdztTypesSelectSearchInput != null){
            var jdztTypesIndex = jdztTypesSelectSearchInput.selectedIndex;
            if( jdztTypesIndex  != 0){
                searchForm.jdztTypes= document.getElementById("jdztTypesSelectSearch").options[jdztTypesIndex].value;
            }
        }
     
            //快递类型
        var kdlxTypesSelectSearchInput = document.getElementById("kdlxTypesSelectSearch");
        if(kdlxTypesSelectSearchInput != null){
            var kdlxTypesIndex = kdlxTypesSelectSearchInput.selectedIndex;
            if( kdlxTypesIndex  != 0){
                searchForm.kdlxTypes= document.getElementById("kdlxTypesSelectSearch").options[kdlxTypesIndex].value;
            }
        }
        getDataList();
    }

    // 获取数据列表
    function getDataList() {
        http("jiedan/page", "GET", {
            page: pageIndex,
            limit: pageSize,
            sort: sortColumn,
            order: sortOrder,
            //本表的
            initiateTimeStart: searchForm.initiateTimeStart,
            initiateTimeEnd: searchForm.initiateTimeEnd,
            jdztTypes: searchForm.jdztTypes,
            kdlxTypes: searchForm.kdlxTypes,

            //级联表的

    }, (res) => {
            if(res.code == 0)
            {
                clear();
                $("#thisTbody").html("");
                dataList = res.data.list;
                totalPage = res.data.totalPage;
                //var tbody = document.getElementById('tbMain');
                for (var i = 0; i < dataList.length; i++) { //遍历一下表格数据  
                    var trow = setDataRow(dataList[i], i); //定义一个方法,返回tr数据 
                    $('#thisTbody').append(trow);
                }
                pagination(); //渲染翻页组件
                getRoleButtons();// 权限按钮控制
            }
        })
        ;
    }

    // 渲染表格数据
    function setDataRow(item, number) {
        //创建行 
        var row = document.createElement('tr');
        row.setAttribute('class', 'useOnce');
        //创建勾选框
        var checkbox = document.createElement('td');
        var checkboxDiv = document.createElement('div');
        checkboxDiv.setAttribute("class", "custom-control custom-checkbox");
        var checkboxInput = document.createElement('input');
        checkboxInput.setAttribute("class", "custom-control-input");
        checkboxInput.setAttribute("type", "checkbox");
        checkboxInput.setAttribute('name', 'chk');
        checkboxInput.setAttribute('value', item.id);
        checkboxInput.setAttribute("id", number);
        checkboxDiv.appendChild(checkboxInput);
        var checkboxLabel = document.createElement('label');
        checkboxLabel.setAttribute("class", "custom-control-label");
        checkboxLabel.setAttribute("for", number);
        checkboxDiv.appendChild(checkboxLabel);
        checkbox.appendChild(checkboxDiv);
        row.appendChild(checkbox)



        //单号
        var oddCell = document.createElement('td');
        oddCell.innerHTML = item.odd;
        row.appendChild(oddCell);


        //快递名称
        var daiqukuaidimcCell = document.createElement('td');
        daiqukuaidimcCell.innerHTML = item.daiqukuaidimc;
        row.appendChild(daiqukuaidimcCell);


        //发布人
        var daiqukuaidimcCell = document.createElement('td');
        daiqukuaidimcCell.innerHTML = item.fbrname;
        row.appendChild(daiqukuaidimcCell);



        //收件人名称
        var addresseenameCell = document.createElement('td');
        addresseenameCell.innerHTML = item.addresseename;
        row.appendChild(addresseenameCell);


        //电话
        var jdphoneCell = document.createElement('td');
        jdphoneCell.innerHTML = item.jdphone;
        row.appendChild(jdphoneCell);


        //地址
        var jdaddresseeCell = document.createElement('td');
        jdaddresseeCell.innerHTML = item.jdaddressee;
        row.appendChild(jdaddresseeCell);


        //(取/寄)件码
        var jdtakecodeCell = document.createElement('td');
        jdtakecodeCell.innerHTML = item.jdtakecode;
        row.appendChild(jdtakecodeCell);


        //快递状态
        var jdztTypesCell = document.createElement('td');
        jdztTypesCell.innerHTML = item.jdztValue;
        row.appendChild(jdztTypesCell);


        //快递类型
        var kdlxTypesCell = document.createElement('td');
        kdlxTypesCell.innerHTML = item.kdlxValue;
        row.appendChild(kdlxTypesCell);

        //发布时间
        var initiateTimeCell = document.createElement('td');
        initiateTimeCell.innerHTML = item.initiateTime;
        row.appendChild(initiateTimeCell);



        //每行按钮
        var btnGroup = document.createElement('td');

        //修改按钮
        var editBtn = document.createElement('button');
        var editAttr = 'edit(' + item.id + ')';
        editBtn.setAttribute("type", "button");
        editBtn.setAttribute("class", "btn btn-warning btn-sm 修改");
        editBtn.setAttribute("onclick", editAttr);
        editBtn.innerHTML = "修改"
        btnGroup.appendChild(editBtn)
        //删除按钮
        var deleteBtn = document.createElement('button');
        var deleteAttr = 'remove(' + item.id + ')';
        deleteBtn.setAttribute("type", "button");
        deleteBtn.setAttribute("class", "btn btn-danger btn-sm 删除");
        deleteBtn.setAttribute("onclick", deleteAttr);
        deleteBtn.innerHTML = "删除"
        btnGroup.appendChild(deleteBtn)

        if(item.jdztValue == "未接"){
            //详情按钮
            var detailBtn = document.createElement('button');
            var detailAttr = "receiving(" + item.id + ')';
            detailBtn.setAttribute("type", "button");
            detailBtn.setAttribute("class", "btn btn-info btn-sm 接单");
            detailBtn.setAttribute("onclick", detailAttr);
            detailBtn.innerHTML = "接单"
            btnGroup.appendChild(detailBtn)
        }


        row.appendChild(btnGroup)
        return row;
    }


    // 翻页
    function pageNumChange(val) {
        if (val == 'pre') {
            pageIndex--;
        } else if (val == 'next') {
            pageIndex++;
        } else {
            pageIndex = val;
        }
        getDataList();
    }

    // 下载
    function download(url) {
        window.open(url);
    }

    // 渲染翻页组件
    function pagination() {
        var beginIndex = pageIndex;
        var endIndex = pageIndex;
        var point = 4;
        //计算页码
        for (var i = 0; i < 3; i++) {
            if (endIndex == totalPage) {
                break;
            }
            endIndex++;
            point--;
        }
        for (var i = 0; i < 3; i++) {
            if (beginIndex == 1) {
                break;
            }
            beginIndex--;
            point--;
        }
        if (point > 0) {
            while (point > 0) {
                if (endIndex == totalPage) {
                    break;
                }
                endIndex++;
                point--;
            }
            while (point > 0) {
                if (beginIndex == 1) {
                    break;
                }
                beginIndex--;
                point--
            }
        }
        // 是否显示 前一页 按钮
        if (pageIndex > 1) {
            $('#tableId_previous').show();
        } else {
            $('#tableId_previous').hide();
        }
        // 渲染页码按钮
        for (var i = beginIndex; i <= endIndex; i++) {
            var pageNum = document.createElement('li');
            pageNum.setAttribute('onclick', "pageNumChange(" + i + ")");
            if (pageIndex == i) {
                pageNum.setAttribute('class', 'paginate_button page-item active useOnce');
            } else {
                pageNum.setAttribute('class', 'paginate_button page-item useOnce');
            }
            var pageHref = document.createElement('a');
            pageHref.setAttribute('class', 'page-link');
            pageHref.setAttribute('href', '#');
            pageHref.setAttribute('aria-controls', 'tableId');
            pageHref.setAttribute('data-dt-idx', i);
            pageHref.setAttribute('tabindex', 0);
            pageHref.innerHTML = i;
            pageNum.appendChild(pageHref);
            $('#tableId_next').before(pageNum);
        }
        // 是否显示 下一页 按钮
        if (pageIndex < totalPage) {
            $('#tableId_next').show();
            $('#tableId_next a').attr('data-dt-idx', endIndex + 1);
        } else {
            $('#tableId_next').hide();
        }
        var pageNumInfo = "当前第 " + pageIndex + " 页，共 " + totalPage + " 页";
        $('#tableId_info').html(pageNumInfo);
    }

    // 跳转到指定页
    function toThatPage() {
        //var index = document.getElementById('pageIndexInput').value;
        if (index < 0 || index > totalPage) {
            alert('请输入正确的页码');
        } else {
            pageNumChange(index);
        }
    }

    // 全选/全不选
    function chooseAll() {
        checkAll = !checkAll;
        var boxs = document.getElementsByName("chk");
        for (var i = 0; i < boxs.length; i++) {
            boxs[i].checked = checkAll;
        }
    }

    // 批量删除
    function deleteMore() {
        ids = []
        var boxs = document.getElementsByName("chk");
        for (var i = 0; i < boxs.length; i++) {
            if (boxs[i].checked) {
                ids.push(boxs[i].value)
            }
        }
        if (ids.length == 0) {
            alert('请勾选要删除的记录');
        } else {
            remove(ids);
        }
    }
    // 删除
    function remove(id) {
        var mymessage = confirm("真的要删除吗？");
        if (mymessage == true) {
            var paramArray = [];
            if (id == ids) {
                paramArray = id;
            } else {
                paramArray.push(id);
            }
            httpJson("jiedan/delete", "POST", paramArray, (res) => {
                if(res.code == 0
        )
            {
                getDataList();
                alert('删除成功');
            }
        })
            ;
        }
        else {
            alert("已取消操作");
        }
    }
    // 删除
    function receiving(id) {
        var mymessage = confirm("真的要接单吗？");
        if (mymessage == true) {
                paramArray = id;
            httpJson("jiedan/receiving", "POST", paramArray, (res) => {
                if(res.code == 0
        )
            {
                getDataList();
                alert('接单成功');
            }
        })
            ;
        }
        else {
            alert("已取消操作");
        }
    }
    // 删除
    function ship(yh,name,dx) {
        var mymessage = confirm("真的要寄件吗？");
        if (mymessage == true) {
            httpJson("jiedan/ship?name="+name+"&yh="+yh+"&dx="+dx, "get", null, (res) => {
                if(res.code == 0
        )
            {
                getDataList();
                alert('寄件请求发送成功');
                $('#exampleModal').modal('hide')
                $("#yhSelectSearch").attr("value",null);
                $("#kdname").attr("value",null);
            }
        })
            ;
        }
        else {
            alert("已取消操作");
        }
    }

    // 用户登出
    <%@ include file="../../static/logout.jsp"%>

    //修改
    function edit(id) {
        window.sessionStorage.setItem('updateId', id)
        window.location.href = "add-or-update.jsp"
    }

    //清除会重复渲染的节点
    function clear() {
        var elements = document.getElementsByClassName('useOnce');
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }

    //添加
    function add() {
        window.sessionStorage.setItem("addjiedan", "addjiedan");
        window.location.href = "add-or-update.jsp"
    }

    //报表
    function graph() {
        window.location.href = "graph.jsp"
    }

    // 查看详情
    function detail(id) {
        window.sessionStorage.setItem("updateId", id);
        window.location.href = "info.jsp";
    }

    //填充级联表搜索下拉框

    //填充本表搜索下拉框
                     
                     
        function jdztTypesSelectSearch() {
            var jdztTypesSelectSearch = document.getElementById('jdztTypesSelectSearch');
            if(jdztTypesSelectSearch != null) {
                jdztTypesSelectSearch.add(new Option('-请选择-',''));
                if (jdztTypesOptions != null && jdztTypesOptions.length > 0){
                    for (var i = 0; i < jdztTypesOptions.length; i++) {
                            jdztTypesSelectSearch.add(new Option(jdztTypesOptions[i].indexName,jdztTypesOptions[i].codeIndex));
                    }
                }
            }
        }
     
        function kdlxTypesSelectSearch() {
            var kdlxTypesSelectSearch = document.getElementById('kdlxTypesSelectSearch');
            if(kdlxTypesSelectSearch != null) {
                kdlxTypesSelectSearch.add(new Option('-请选择-',''));
                if (kdlxTypesOptions != null && kdlxTypesOptions.length > 0){
                    for (var i = 0; i < kdlxTypesOptions.length; i++) {
                            kdlxTypesSelectSearch.add(new Option(kdlxTypesOptions[i].indexName,kdlxTypesOptions[i].codeIndex));
                    }
                }
            }
        }
        function yonghuSelectSearch() {
            var yhSelectSearch = document.getElementById('yhSelectSearch');
            if(yhSelectSearch != null) {
                yhSelectSearch.add(new Option('-请选择-',''));
                if (yonghuOptions != null && yonghuOptions.length > 0){
                    for (var i = 0; i < yonghuOptions.length; i++) {
                        yhSelectSearch.add(new Option(yonghuOptions[i].name,yonghuOptions[i].id));
                    }
                }
            }
        }
        function kddxSelectSearch() {
            var kddxSelectSearch = document.getElementById('kddxSelectSearch');
            if(kddxSelectSearch != null) {
                kddxSelectSearch.add(new Option('-请选择-',''));
                if (kddxOptions != null && kddxOptions.length > 0){
                    for (var i = 0; i < kddxOptions.length; i++) {
                        kddxSelectSearch.add(new Option(kddxOptions[i].indexName,kddxOptions[i].codeIndex));
                    }
                }
            }
        }

    //查询级联表搜索条件所有列表

    //查询当前表搜索条件所有列表
        function jdztTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=jdzt_types", "GET", {}, (res) => {
                if(res.code == 0){
                    jdztTypesOptions = res.data.list;
                }
            });
        }
        function kdlxTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=kdlx_types", "GET", {}, (res) => {
                if(res.code == 0){
                    kdlxTypesOptions = res.data.list;
                }
            });
        }
        function yonghuSelect() {
            //填充下拉框选项
            http("yonghu/page?page=1&limit=100", "GET", {}, (res) => {
                if(res.code == 0){
                    yonghuOptions = res.data.list;
                }
            });
        }
        function kddxSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=kddx_types", "GET", {}, (res) => {
                if(res.code == 0){
                 kddxOptions = res.data.list;
                }
            });
        }


    $(document).ready(function () {
        $('#receive').on('click', function (e) {
            e.preventDefault();
            var yh = $("#yhSelectSearch").val();
            var dx = $("#kddxSelectSearch").val();
            var name = $("#kdname").val();
            ship(yh,name,dx);
        });

        //激活翻页按钮
        $('#tableId_previous').attr('class', 'paginate_button page-item previous')
        $('#tableId_next').attr('class', 'paginate_button page-item next')
        //隐藏原生搜索框
        $('#tableId_filter').hide()
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        setMenu();
        init();

        //查询级联表的搜索下拉框

        //查询当前表的搜索下拉框
        jdztTypesSelect();
        kdlxTypesSelect();
        yonghuSelect();
        kddxSelect();

        getDataList();

        //级联表的下拉框赋值

        //当前表的下拉框赋值
                                                             
                                                             
            jdztTypesSelectSearch();

        kddxSelectSearch();

            yonghuSelectSearch();
             
            kdlxTypesSelectSearch();

    <%@ include file="../../static/myInfo.js"%>
    });
</script>
</body>

</html>