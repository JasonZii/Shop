<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">

	<title>消费管理</title>

	<!-- Bootstrap Core CSS -->
	<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">

	<!-- MetisMenu CSS -->
	<link href="<%=basePath%>css/metisMenu.min.css" rel="stylesheet">

	<!-- DataTables CSS -->
	<link href="<%=basePath%>css/dataTables.bootstrap.css" rel="stylesheet">

	<!-- Custom CSS -->
	<link href="<%=basePath%>css/sb-admin-2.css" rel="stylesheet">

	<!-- Custom Fonts -->
	<link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet"
		  type="text/css">
	<link href="<%=basePath%>css/boot-crm.css" rel="stylesheet"
		  type="text/css">

	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->

	<style>
		#button3{display: none;}
		/*#sell-table{display: none;}*/
	</style>

</head>

<body>

<div id="wrapper" >

	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-static-top" role="navigation"
		 style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.html">消费管理 </a>
		</div>
		<!-- /.navbar-header -->

		<ul class="nav navbar-top-links navbar-right">
			<li class="dropdown"><a class="dropdown-toggle"
									data-toggle="dropdown" href="#"> <i class="fa fa-envelope fa-fw"></i>
				<i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-messages">
					<li><a href="#">
						<div>
							<strong>XXX</strong> <span class="pull-right text-muted">
									<em>昨天</em>
								</span>
						</div>
						<div>。。。。</div>
					</a></li>
					<li class="divider"></li>
					<li><a class="text-center" href="#"> <strong>查看全部消息</strong>
						<i class="fa fa-angle-right"></i>
					</a></li>
				</ul> <!-- /.dropdown-messages --></li>
			<!-- /.dropdown -->
			<li class="dropdown"><a class="dropdown-toggle"
									data-toggle="dropdown" href="#"> <i class="fa fa-tasks fa-fw"></i>
				<i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-tasks">
					<li><a href="#">
						<div>
							<p>
								<strong>任务 1</strong> <span class="pull-right text-muted">完成40%</span>
							</p>
							<div class="progress progress-striped active">
								<div class="progress-bar progress-bar-success"
									 role="progressbar" aria-valuenow="40" aria-valuemin="0"
									 aria-valuemax="100" style="width: 40%">
									<span class="sr-only">完成40%</span>
								</div>
							</div>
						</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
						<div>
							<p>
								<strong>任务 2</strong> <span class="pull-right text-muted">完成20%</span>
							</p>
							<div class="progress progress-striped active">
								<div class="progress-bar progress-bar-info" role="progressbar"
									 aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"
									 style="width: 20%">
									<span class="sr-only">完成20%</span>
								</div>
							</div>
						</div>
					</a></li>
					<li class="divider"></li>
					<li><a class="text-center" href="#"> <strong>查看所有任务</strong>
						<i class="fa fa-angle-right"></i>
					</a></li>
				</ul> <!-- /.dropdown-tasks --></li>
			<!-- /.dropdown -->
			<li class="dropdown"><a class="dropdown-toggle"
									data-toggle="dropdown" href="#"> <i class="fa fa-bell fa-fw"></i>
				<i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-alerts">
					<li><a href="#">
						<div>
							<i class="fa fa-comment fa-fw"></i> 新回复 <span
								class="pull-right text-muted small">4分钟之前</span>
						</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
						<div>
							<i class="fa fa-envelope fa-fw"></i> 新消息 <span
								class="pull-right text-muted small">4分钟之前</span>
						</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
						<div>
							<i class="fa fa-tasks fa-fw"></i> 新任务 <span
								class="pull-right text-muted small">4分钟之前</span>
						</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
						<div>
							<i class="fa fa-upload fa-fw"></i> 服务器重启 <span
								class="pull-right text-muted small">4分钟之前</span>
						</div>
					</a></li>
					<li class="divider"></li>
					<li><a class="text-center" href="#"> <strong>查看所有提醒</strong>
						<i class="fa fa-angle-right"></i>
					</a></li>
				</ul> <!-- /.dropdown-alerts --></li>
			<!-- /.dropdown -->
			<li class="dropdown"><a class="dropdown-toggle"
									data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
				<i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">
					<li><a href="#"><i class="fa fa-user fa-fw"></i> 用户设置</a></li>
					<li><a href="#"><i class="fa fa-gear fa-fw"></i> 系统设置</a></li>
					<li class="divider"></li>
					<li><a href="<%=basePath%>login/test"><i class="fa fa-sign-out fa-fw"></i>
						退出登录</a></li>
				</ul> <!-- /.dropdown-user --></li>
			<!-- /.dropdown -->
		</ul>
		<!-- /.navbar-top-links -->

		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<li class="sidebar-search">
						<div class="input-group custom-search-form">
							<input type="text" class="form-control" placeholder="查询内容..." id="keyword">
							<span class="input-group-btn">
								<button class="btn btn-default" type="button" id="button4">
									<%--<a href="<%=basePath%>/shop/list?keywork="$("#keyword").val()">--%>
									<i class="fa fa-search" style="padding: 3px 0 3px 0;"></i>
									<%--</a>--%>
								</button>
							</span>
						</div> <!-- /input-group -->
					</li>
					<li>
						<a href="<%=basePath%>/shop/list" class="active" id="sell_d">
							<i class="fa fa-edit fa-fw"></i>
							消费信息管理
						</a>
					</li>
					<li>
						<a class="active" id="sell_t" >
							<i class="fa fa-dashboard fa-fw"></i>
							消费图表
						</a>
					</li>
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>

	<div id="page-wrapper" >
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">消费管理</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="panel panel-default">
			<div class="panel-body">
				<form class="form-inline" action="${pageContext.request.contextPath }/shop/list" method="get">
					<div class="form-group">
						<label for="shopName">购买人</label>
						<input type="text" class="form-control" id="shopName" value="${shopName }" name="shopName">
					</div>
					<div class="form-group">
						<label for="shopType">商品类别</label>
						<select	class="form-control" id="shopType" name="shopType">
							<option value="">--请选择--</option>
							<c:forEach items="${typeList}" var="list">
								<option value="${list.dict_id}"<c:if test="${list.dict_id == shopType}"> selected</c:if>>${list.dict_item_name }</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="shopSource">购买方式</label>
						<select	class="form-control" id="shopSource" name="shopSource">
							<option value="">--请选择--</option>
							<c:forEach items="${sellList}" var="list">
								<option value="${list.dict_id}"<c:if test="${list.dict_id == shopSource}"> selected</c:if>>${list.dict_item_name }</option>
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-primary">查询</button>

				</form>
				<button href="#" id="add" class="btn btn-primary" data-toggle="modal" data-target="#customerEditDialog" onclick="editShop(3)">添加消费信息</button>



				<!-- Single button -->
				<div class="btn-group">
					<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						Action <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Separated link</a></li>
					</ul>
				</div>

			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">消费信息列表</div>
					<!-- /.panel-heading -->
					<table class="table table-bordered table-striped">
						<thead>
						<tr>
							<th>ID</th>
							<th>购买人</th>
							<th>商品类别</th>
							<th>商品名称</th>
							<th>商品价格</th>
							<th>购买地址</th>
							<th>联系电话</th>
							<th>详情</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${page.rows}" var="row">
							<tr>
								<td>${row.shop_id}</td>
								<td>${row.shop_name}</td>
								<td>${row.shop_type}</td>
								<td>${row.shop_matter}</td>
								<td>${row.shop_price}</td>
								<td>${row.shop_address}</td>
								<td>${row.sell_phone}</td>
								<td>
									<a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#customerEditDialog" onclick="editShop(${row.shop_id})">详细</a>
									<a href="#" class="btn btn-danger btn-xs" onclick="deleteShop(${row.shop_id})">删除</a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					<div class="col-md-12 text-right">

							<ul class="pagination">

								<!--判断当前页是否是首页-->
								<c:if test="${page.page == 1}">
									<li class="disabled">
											<a href="javascript:void(0)" aria-label="Previous">
											<span aria-hidden="true">&laquo;</span>
										</a>
									</li>

								</c:if>

								<c:if test="${page.page != 1}">
									<li>
										<a href="<%=basePath%>/shop/list?page=${page.page-1}"
										   aria-label="Previous">
											<span aria-hidden="true">&laquo;</span>
										</a>
									</li>
								</c:if>


								<!--显示所有页码-->
								<c:forEach begin="1" end="${page.pageCount}" var="n">
									<!--判断是否是当前页-->
									<c:if test="${page.page == n}">
										<li class="active"><a href="javascript:void(0)">${n}</a></li>
									</c:if>
									<c:if test="${page.page != n}">
										<li><a href="<%=basePath%>/shop/list?page=${n}">${n}</a></li>
									</c:if>

								</c:forEach>

								<!--判断是否是最后一页-->
								<c:if test="${page.page == page.pageCount}">
									<li class="disabled">
										<a href="javascript:void(0)" aria-label="Next">
											<span aria-hidden="true">&raquo;</span>
										</a>
									</li>
								</c:if>

								<c:if test="${page.page != page.pageCount}">
									<li>
										<a href="<%=basePath%>/shop/list?page=${page.page+1}"
										   aria-label="Next">
											<span aria-hidden="true">&raquo;</span>
										</a>
									</li>
								</c:if>

							</ul>
					</div>

					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>
	</div>
	<!-- /#page-wrapper -->


</div>


<div id="sell-table" style="display:none;height:700px;width:700px;left:300px;position:absolute;">

	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">消费图表</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>




	<%--<form class="navbar-form navbar-left" role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>--%>


	<div>
		<span class="label label-default">Default</span>
		<%--<span class="label label-primary">Primary</span>--%>
		<span class="label label-success">日用</span>
		<span class="label label-info">食物</span>
		<span class="label label-warning">电器</span>
		<span class="label label-danger">衣物</span>
	</div>



	<div class="progress">
		<div class="progress-bar progress-bar-success progress-bar-striped"
			 role="progressbar" aria-valuenow="40"
			 aria-valuemin="0" aria-valuemax="100" style="width: 100%" id="pro1">
			<span class="sr-only" id="s1">40% Complete (success)</span>

		</div>
		<p class="text-danger" id="p1" style="color: darkmagenta"></p>
	</div>
	<div class="progress">
		<div class="progress-bar progress-bar-info progress-bar-striped"
			 role="progressbar" aria-valuenow="20"
			 aria-valuemin="0" aria-valuemax="100" style="width: 100%" id="pro2">
			<span class="sr-only" id="s2">40% Complete (success)</span>
			<%--<p class="text-danger" id="p2" style="color: #080808"></p>--%>

		</div>
		<p class="text-danger" id="p2" style="color: darkmagenta"></p>
	</div>
	<div class="progress">
		<div class="progress-bar progress-bar-warning progress-bar-striped"
			 role="progressbar" aria-valuenow="60"
			 aria-valuemin="0" aria-valuemax="100" style="width: 100%" id="pro3">
			<span class="sr-only" id="s3">40% Complete (success)</span>
			<%--<p class="text-danger" id="p3" style="color: #080808"></p>--%>
		</div>
		<p class="text-danger" id="p3" style="color: darkmagenta"></p>
	</div>
	<div class="progress">
		<div class="progress-bar progress-bar-danger progress-bar-striped"
			 role="progressbar" aria-valuenow="80"
			 aria-valuemin="0" aria-valuemax="100" style="width: 100%" id="pro4">
			<span class="sr-only" id="s4">40% Complete (success)</span>
			<%--<p class="text-danger" id="p4" style="color: #080808"></p>--%>
		</div>
		<p class="text-danger" id="p4" style="color: darkmagenta"></p>
	</div>

	<%--		<div class="progress">
                <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 45%">
                    <span class="sr-only">45% Complete</span>234
                </div>

            </div>--%>

	<div class="col-lg-6" style="left: 400px">
		<%--<form class="form-inline" action="${pageContext.request.contextPath }/shop/buyTable" method="get">--%>

		<form class="form-inline" id="buyTable_from" >
			<div class="form-group">
				<label for="beginDate">起始时间</label>
				<input type="text" class="form-control" id="beginDate" name="beginDate">
			</div>
			<div class="form-group">
				<label for="endDate">结束时间</label>
				<input type="text" class="form-control" id="endDate" name="endDate">
			</div>
			<button type="button" class="btn btn-primary" onclick="buyTable()" id="buyTable">展示</button>


		</form>
	</div>

</div>


<!-- 编辑对话框 -->
<div class="modal fade" id="customerEditDialog" tabindex="-1" role="dialog"
	 aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">修改购买信息</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="edit_shop_form">
					<input type="hidden" id="edit_shop_id" name="shop_id"/>
					<div class="form-group">
						<label for="edit_shop_name" class="col-sm-2 control-label">客户人</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="edit_shop_name" placeholder="客户名称" name="shop_name">
						</div>
					</div>
					<div class="form-group">
						<label for="edit_shop_source" style="float:left;padding:7px 15px 0 27px;">购买方式</label>
						<div class="col-sm-10">
							<select	class="form-control" id="edit_shop_source" placeholder="客户来源" name="shop_source">
								<option value="">--请选择--</option>
								<c:forEach items="${sellList}" var="list">
									<option value="${list.dict_id}"
											<c:if test="${list.dict_id == shop_source}">
												selected
											</c:if>>
											${list.dict_item_name}
									</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="edit_shop_type" style="float:left;padding:7px 15px 0 27px;">购买种类</label>
						<div class="col-sm-10">
							<select	class="form-control" id="edit_shop_type"  name="shop_type">
								<option value="">--请选择--</option>
								<c:forEach items="${typeList}" var="list">
									<option value="${list.dict_id}"
											<c:if test="${list.dict_id == shop_type}">
												selected
											</c:if>>
											${list.dict_item_name }
									</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="edit_shop_matter" class="col-sm-2 control-label">购买商品</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="edit_shop_matter" placeholder="联系人" name="dict_item_name">
						</div>
					</div>
					<div class="form-group">
						<label for="edit_shop_price" class="col-sm-2 control-label">价格(元)</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="edit_shop_price" placeholder="联系人" name="shop_price">
						</div>
					</div>
					<div class="form-group">
						<label for="edit_sell_man" class="col-sm-2 control-label">售卖人</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="edit_sell_man" placeholder="固定电话" name="sell_man">
						</div>
					</div>
					<div class="form-group">
						<label for="edit_sell_phone" class="col-sm-2 control-label">移动电话</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="edit_sell_phone" placeholder="移动电话" name="sell_phone">
						</div>
					</div>
					<div class="form-group">
						<label for="edit_shop_address" class="col-sm-2 control-label">购买地址</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="edit_shop_address" placeholder="邮政编码" name="shop_address">
						</div>
					</div>
					<div class="form-group">
						<label for="edit_shop_creattime" class="col-sm-2 control-label">购买时间</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="edit_shop_creattime" placeholder="联系地址" name="shop_createtime">
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button id="button1" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button id="button2" type="button" class="btn btn-primary" onclick="updateShop()">保存</button>
				<button id="button3" type="button" class="btn btn-primary" onclick="addShop()">确定保存</button>
			</div>
		</div>
	</div>
</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="<%=basePath%>js/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<%=basePath%>js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="<%=basePath%>js/metisMenu.min.js"></script>

<!-- DataTables JavaScript -->
<script src="<%=basePath%>js/jquery.dataTables.min.js"></script>
<script src="<%=basePath%>js/dataTables.bootstrap.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="<%=basePath%>js/sb-admin-2.js"></script>

<script type="text/javascript">
    function editShop(id) {
        $.ajax({
            type:"get",
            url:"<%=basePath%>shop/edit2",
            data:{"id":id},
            success:function(data) {
                $("#edit_shop_id").val(data.shop_id);
                $("#edit_shop_name").val(data.shop_name);
                $("#edit_shop_source").val(data.shop_source);
                $("#edit_shop_type").val(data.shop_type);
                $("#edit_shop_matter").val(data.dict_item_name);
                $("#edit_shop_price").val(data.shop_price);
                $("#edit_sell_man").val(data.sell_man);
                $("#edit_sell_phone").val(data.sell_phone);
                $("#edit_shop_address").val(data.shop_address);
                $("#edit_shop_creattime").val(data.shop_createtime);
            }
        });
    }

    window.onload = function () {
			document.getElementById("add").onclick = function () {
		    document.getElementById("button1").style.display = "none";
		    document.getElementById("button2").style.display = "none";
		    document.getElementById("button3").style.display = "block";
		}
    }

//    $(document).ready(function () {

	$(function () {


        $("#sell_t").click(function(){
            $("#page-wrapper").fadeOut();

            /*$("#sell-table").animate({
                left:'400px',
                height:'700px',
                width:'700px'
            });*/

            $("#sell-table").fadeIn(3000)

        });


    });

    $("#buyTable").click(function(){
        $.ajax({
            type :"get",
            async :true, //同步请求
            url : "<%=basePath%>shop/buyTable",
            data : {"beginDate":$("#beginDate").val(),"endDate":$("#endDate").val()},
//            timeout:1000,
            success:function(data){
                //alert(data);
//                $("#pro1").css('width',"px");//要刷新的div

//                $("#sell-table").fadeIn(3000)

//                $("#pro1").width((data.commodity/data.totalSpend)*100);//要刷新的div
				if(data.totalSpend == null){
                    $("#pro1").width(0);//要刷新的div
                    $("#p1").text("0%" + "金额(元)：0");//要刷新的div

                    $("#pro2").width(0);//要刷新的div
                    $("#p2").text("0%" + "金额(元)：0");//要刷新的div

                    $("#pro3").width(0);//要刷新的div
                    $("#p3").text("0%" + "金额(元)：0");//要刷新的div

                    $("#pro4").width(0);//要刷新的div
                    $("#p4").text("0%" + "金额(元)：0");//要刷新的div


				}
                else {
				    if(data.commodity == null){
                        $("#pro1").width(0);//要刷新的div
                        $("#p1").text("0%" + "金额(元)：0");//要刷新的div
					}
                    $("#pro1").width((data.commodity / data.totalSpend) * 700);//要刷新的div
                    $("#p1").text(Math.ceil((data.commodity / data.totalSpend) * 100) + "%"  + "金额(元)：" + data.commodity);//要刷新的div

                    if(data.commodity == null){
                        $("#pro2").width(0);//要刷新的div
                        $("#p2").text("0%" + "金额(元)：0");//要刷新的div
                    }
                    $("#pro2").width((data.electron / data.totalSpend) * 700);//要刷新的div
                    $("#p2").text(Math.ceil((data.electron / data.totalSpend) * 100) + "%"  + "金额(元)：" + data.electron);//要刷新的div

                    if(data.commodity == null){
                        $("#pro3").width(0);//要刷新的div
                        $("#p3").text("0%" + "金额(元)：0");//要刷新的div
                    }
                    $("#pro3").width((data.food / data.totalSpend) * 700);//要刷新的div
                    $("#p3").text(Math.ceil((data.food / data.totalSpend) * 100) + "%" + "金额(元)：" + data.food);//要刷新的div

                    if(data.commodity == null){
                        $("#pro4").width(0);//要刷新的div
                        $("#p4").text("0%" + "金额(元)：0");//要刷新的div
                    }
                    $("#pro4").width((data.clothes / data.totalSpend) * 700);//要刷新的div
                    $("#p4").text(Math.ceil((data.clothes / data.totalSpend) * 100) + "%" + "金额(元)：" + data.clothes);//要刷新的div

                }
            },
            error:function() {
                // alert("失败，请稍后再试！");
            }
        });
    });

    $("#button4").click(function () {

        window.location.href="<%=basePath%>shop/list?keyword="+$("#keyword").val();
    });


    function addShop() {
		$.post("<%=basePath%>shop/add",$("#edit_shop_form").serialize(),function(data){
            alert("消费信息添加成功！");
            window.location.reload();
        });
    }

    function updateShop() {
        $.post("<%=basePath%>shop/update",$("#edit_shop_form").serialize(),function(data){
            alert("消费信息更新成功！");
            window.location.reload();
        });
    }

    function deleteShop(id) {
        if(confirm('确实要删除该记录吗?')) {
            $.post("<%=basePath%>shop/delete",{"id":id},function(data){
                alert("消费信息删除成功！");
                window.location.reload();
            });
        }
    }

</script>

</body>

</html>
