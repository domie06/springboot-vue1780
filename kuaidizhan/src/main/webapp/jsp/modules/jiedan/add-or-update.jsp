<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <%@ include file="../../static/head.jsp" %>
    <link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-select.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
    </script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<style>
    .error {
        color: red;
    }
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
                    <h3 class="block-title">编辑快递接单表</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">快递接单表管理</li>
                        <li class="breadcrumb-item active">编辑快递接单表</li>
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
                        <h3 class="widget-title">快递接单表信息</h3>
                        <form id="addOrUpdateForm">
                            <div class="form-row">
                            <!-- 级联表的字段 -->
                            <!-- 当前表的字段 -->
                                    <input id="updateId" name="id" type="hidden">
                                <input id="daiqukuaidiId" name="daiqukuaidiId" type="hidden">
                                <input id="jdyonghuId" name="jdyonghuId" type="hidden">
                                    <div class="form-group col-md-6">
                                        <label>收件人名称</label>
                                        <input id="addresseename" name="addresseename" class="form-control"
                                               placeholder="收件人名称">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>电话</label>
                                        <input id="jdphone" name="jdphone" class="form-control"
                                               placeholder="电话">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>地址</label>
                                        <input id="jdaddressee" name="jdaddressee" class="form-control"
                                               placeholder="地址">
                                    </div>
                                <div class="form-group col-md-12 mb-3">
                                    <button id="submitBtn" type="button" class="btn btn-primary btn-lg">提交</button>
                                    <button id="exitBtn" type="button" class="btn btn-primary btn-lg">返回</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /Widget Item -->
            </div>
        </div>
        <!-- /Main Content -->
    </div>
    <!-- /Page Content -->
</div>
<!-- Back to Top -->
<a id="back-to-top" href="#" class="back-to-top">
    <span class="ti-angle-up"></span>
</a>
<!-- /Back to Top -->
<%@ include file="../../static/foot.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/messages_zh.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/card.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js">
</script><script type="text/javascript" charset="utf-8"
                 src="${pageContext.request.contextPath}/resources/js/bootstrap-select.js"></script>
<script>
    <%@ include file="../../utils/menu.jsp"%>
    <%@ include file="../../static/setMenu.js"%>
    <%@ include file="../../utils/baseUrl.jsp"%>

    var tableName = "jiedan";
    var pageType = "add-or-update";
    var updateId = "";
    var crossTableId = -1;
    var crossTableName = '';
    var ruleForm = {};
    var crossRuleForm = {};


    // 下拉框数组
        <!-- 当前表的下拉框数组 -->
    var jdztTypesOptions = [];
    var kdlxTypesOptions = [];
        <!-- 级联表的下拉框数组 -->

    var ruleForm = {};


    // 文件上传
    function upload() {

        <!-- 当前表的文件上传 -->

    }

    // 表单提交
    function submit() {
        if (validform() == true && compare() == true) {
            let data = {};
            getContent();
           if($("#daiqukuaidiId") !=null){
               var daiqukuaidiId = $("#daiqukuaidiId").val();
               if(daiqukuaidiId == null || daiqukuaidiId =='' || daiqukuaidiId == 'null'){
                   alert("快递名称不能为空");
                   return;
               }
           }
           if($("#jdyonghuId") !=null){
               var jdyonghuId = $("#jdyonghuId").val();
               if(jdyonghuId == null || jdyonghuId =='' || jdyonghuId == 'null'){
                   alert("发布人不能为空");
                   return;
               }
           }
            let value = $('#addOrUpdateForm').serializeArray();
            $.each(value, function (index, item) {
                data[item.name] = item.value;
            });
            let json = JSON.stringify(data);
            var urlParam;
            var successMes = '';
            if (updateId != null && updateId != "null" && updateId != '') {
                urlParam = 'update';
                successMes = '修改成功';
            } else {
                urlParam = 'save';
                successMes = '添加成功';
            }
            httpJson("jiedan/" + urlParam, "POST", data, (res) => {
                if(res.code == 0)
                {
                    window.sessionStorage.removeItem('addjiedan');
                    window.sessionStorage.removeItem('updateId');
                    let flag = true;
                    if (flag) {
                        alert(successMes);
                    }
                    if (window.sessionStorage.getItem('onlyme') != null && window.sessionStorage.getItem('onlyme') == "true") {
                        window.sessionStorage.removeItem('onlyme');
                        window.sessionStorage.setItem("reload","reload");
                        window.parent.location.href = "${pageContext.request.contextPath}/index.jsp";
                    } else {
                        window.location.href = "list.jsp";
                    }
                }
            });
        } else {
            alert("表单未填完整或有错误");
        }
    }

    // 查询列表
        <!-- 查询当前表的所有列表 -->
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
        <!-- 查询级联表的所有列表 -->



    // 初始化下拉框
    <!-- 初始化当前表的下拉框 -->
        function initializationJdzttypesSelect(){
            var jdztTypesSelect = document.getElementById('jdztTypesSelect');
            if(jdztTypesSelect != null && jdztTypesOptions != null  && jdztTypesOptions.length > 0 ){
                for (var i = 0; i < jdztTypesOptions.length; i++) {
                    jdztTypesSelect.add(new Option(jdztTypesOptions[i].indexName,jdztTypesOptions[i].codeIndex));
                }
            }
        }
        function initializationKdlxtypesSelect(){
            var kdlxTypesSelect = document.getElementById('kdlxTypesSelect');
            if(kdlxTypesSelect != null && kdlxTypesOptions != null  && kdlxTypesOptions.length > 0 ){
                for (var i = 0; i < kdlxTypesOptions.length; i++) {
                    kdlxTypesSelect.add(new Option(kdlxTypesOptions[i].indexName,kdlxTypesOptions[i].codeIndex));
                }
            }
        }

    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->


    // 下拉框选项回显
    function setSelectOption() {

        <!-- 当前表的下拉框回显 -->

        var jdztTypesSelect = document.getElementById("jdztTypesSelect");
        if(jdztTypesSelect != null && jdztTypesOptions != null  && jdztTypesOptions.length > 0 ) {
            for (var i = 0; i < jdztTypesOptions.length; i++) {
                if (jdztTypesOptions[i].codeIndex == ruleForm.jdztTypes) {//下拉框value对比,如果一致就赋值汉字
                        jdztTypesSelect.options[i].selected = true;
                }
            }
        }

        var kdlxTypesSelect = document.getElementById("kdlxTypesSelect");
        if(kdlxTypesSelect != null && kdlxTypesOptions != null  && kdlxTypesOptions.length > 0 ) {
            for (var i = 0; i < kdlxTypesOptions.length; i++) {
                if (kdlxTypesOptions[i].codeIndex == ruleForm.kdlxTypes) {//下拉框value对比,如果一致就赋值汉字
                        kdlxTypesSelect.options[i].selected = true;
                }
            }
        }
        <!--  级联表的下拉框回显  -->
    }


    // 填充富文本框
    function setContent() {

        <!-- 当前表的填充富文本框 -->
    }
    // 获取富文本框内容
    function getContent() {

        <!-- 获取当前表的富文本框内容 -->
    }
    //数字检查
        <!-- 当前表的数字检查 -->

    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.sessionStorage.removeItem('addjiedan');
        window.location.href = "list.jsp";
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                odd: "required",
                daiqukuaidiId: "required",
                jdyonghuId: "required",
                initiateTime: "required",
                addresseename: "required",
                jdphone: "required",
                jdaddressee: "required",
                jdtakecode: "required",
                jdztTypes: "required",
                kdlxTypes: "required",
            },
            messages: {
                odd: "单号不能为空",
                daiqukuaidiId: "快递名称不能为空",
                jdyonghuId: "发布人不能为空",
                initiateTime: "发布时间不能为空",
                addresseename: "收件人名称不能为空",
                jdphone: "电话不能为空",
                jdaddressee: "地址不能为空",
                jdtakecode: "(取/寄)件码不能为空",
                jdztTypes: "快递状态不能为空",
                kdlxTypes: "快递类型不能为空",
            }
        }).form();
    }

    // 获取当前详情
    function getDetails() {
        var addjiedan = window.sessionStorage.getItem("addjiedan");
        if (addjiedan != null && addjiedan != "" && addjiedan != "null") {
            window.sessionStorage.removeItem('addjiedan');
            //注册表单验证
            $(validform());
            $('#submitBtn').text('新增');

        } else {
            $('#submitBtn').text('修改');
            var userId = window.sessionStorage.getItem('userId');
            updateId = userId;//先赋值登录用户id
            var uId  = window.sessionStorage.getItem('updateId');//获取修改传过来的id
            if (uId != null && uId != "" && uId != "null") {
                //如果修改id不为空就赋值修改id
                updateId = uId;
            }
            window.sessionStorage.removeItem('updateId');
            http("jiedan/info/" + updateId, "GET", {}, (res) => {
                if(res.code == 0)
                {
                    ruleForm = res.data
                    // 是/否下拉框回显
                    setSelectOption();
                    // 设置图片src
                    showImg();
                    // 数据填充
                    dataBind();
                    // 富文本框回显
                    setContent();
                    //注册表单验证
                    $(validform());
                }

            });
        }
    }

    // 清除可能会重复渲染的selection
    function clear(className) {
        var elements = document.getElementsByClassName(className);
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }

    function dateTimePick() {

    }


    function dataBind() {


    <!--  级联表的数据回显  -->


    <!--  当前表的数据回显  -->
        $("#updateId").val(ruleForm.id);
        $("#odd").val(ruleForm.odd);
        $("#daiqukuaidiId").val(ruleForm.daiqukuaidiId);
        $("#jdyonghuId").val(ruleForm.jdyonghuId);
        $("#initiateTime-input").val(ruleForm.initiateTime);
        $("#addresseename").val(ruleForm.addresseename);
        $("#jdphone").val(ruleForm.jdphone);
        $("#jdaddressee").val(ruleForm.jdaddressee);
        $("#jdtakecode").val(ruleForm.jdtakecode);

    }
    <!--  级联表的数据回显  -->

    //图片显示
    function showImg() {
        <!--  当前表的图片  -->

        <!--  级联表的图片  -->
    }


    <!--  级联表的图片  -->


    $(document).ready(function () {
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        //设置导航栏菜单
        setMenu();
        $('#exitBtn').on('click', function (e) {
            e.preventDefault();
            exit();
        });
        //初始化时间插件
        dateTimePick();
        //查询所有下拉框
            <!--  当前表的下拉框  -->
            jdztTypesSelect();
            kdlxTypesSelect();
            <!-- 查询级联表的下拉框(用id做option,用名字及其他参数做名字级联修改) -->



        // 初始化下拉框
            <!--  初始化当前表的下拉框  -->
            initializationJdzttypesSelect();
            initializationKdlxtypesSelect();
            <!--  初始化级联表的下拉框  -->

        $(".selectpicker" ).selectpicker('refresh');
        getDetails();
        //初始化上传按钮
        upload();
    <%@ include file="../../static/myInfo.js"%>
                $('#submitBtn').on('click', function (e) {
                    e.preventDefault();
                    //console.log("点击了...提交按钮");
                    submit();
                });
        readonly();
    });

    function readonly() {
        if (window.sessionStorage.getItem('role') != '管理员') {
            $('#jifen').attr('readonly', 'readonly');
            //$('#money').attr('readonly', 'readonly');
        }
    }

    //比较大小
    function compare() {
        var largerVal = null;
        var smallerVal = null;
        if (largerVal != null && smallerVal != null) {
            if (largerVal <= smallerVal) {
                alert(smallerName + '不能大于等于' + largerName);
                return false;
            }
        }
        return true;
    }


    // 用户登出
    <%@ include file="../../static/logout.jsp"%>
</script>
</body>

</html>