<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="./resources/img/myicon/bobby_favicon.ico" rel="shortcut icon">
    <title>欢迎访问</title>
    <!-- Bootstrap Core CSS 国内CDN-->
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.css" rel="stylesheet">
    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.js"></script>
    <!-- Bootstrap Core JavaScript 国内CDN -->
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.js"></script>
</head>
<body>
	<div class="container">
        <div class="tabbable">
	        <ul class="nav nav-tabs">
	            <li class="active"><a href="#tab1" id="li_tab1" data-toggle="tab">今天</a></li>
	            <li><a href="#tab2" data-toggle="tab">明天</a></li>
	            <li><a href="#tab3"  id="li_tab3"data-toggle="tab">后天</a></li>
	        </ul>
	        <div class="tab-content">
       			<div class="tab-pane active" id="tab1">
       				<div>
       					<div class="row">
       						<div class="col-md-4"><span><h1>12<sup>℃</sup></h1></span></div>
       					</div>
       					<div class="row">
       						<div class="col-md-5"><span style>最低-3<sup>℃</sup></span></div>
       						<div class="col-md-2">~</div>
       						<div class="col-md-5"><span>最高25<sup>℃</sup></span></div>
        				</div>
        				<div class="row">
        					<div class="col-md-5"><span class="">南风3级</span></div>
        					<div class="col-md-2"><span class="">15Km/h</span></div>
        				</div>
       					<!-- 生活建议信息，先不做 -->
       					<div class="row">
       						<div class="col-md-12">生活建议</div>
       					</div>
					    <div class="row">
					    	<div class="col-md-2"><span class=""><img src="./resources/img/cy.png"></i>穿衣</span></div>
					    	<div class="col-md-2"><span class=""><img src="./resources/img/uv.png"></i>紫外线强度</span></div>
					    	<div class="col-md-2"><span class=""><img src="./resources/img/xc.png"></i>洗车</span></div>
					    	<div class="col-md-2"><span class=""><img src="./resources/img/kq.png"></i>空气污染扩散</span></div>
					    	<div class="col-md-2"><span class=""><img src="./resources/img/gm.png"></i>感冒</span></div>
					    	<div class="col-md-2"><span class=""><img src="./resources/img/yd.png"></i>运动</span></div>
					    </div>
       				</div>
       			</div>
       			<div class="tab-pane" id="tab2">
       				<div>
       					<div class="row">
       						<div class="col-md-4"><span><h1>12<sup>℃</sup></h1></span></div>
       					</div>
       					<div class="row">
       						<div class="col-md-5"><span style>最低-3<sup>℃</sup></span></div>
       						<div class="col-md-2">~</div>
       						<div class="col-md-5"><span>最高25<sup>℃</sup></span></div>
        				</div>
        				<div class="row">
        					<div class="col-md-5"><span class="">南风3级</span></div>
        					<div class="col-md-2"><span class="">15Km/h</span></div>
        				</div>
       					<!-- 生活建议信息，先不做 -->
       					<div class="row">
       						<div class="col-md-12">生活建议</div>
       					</div>
					    <div class="row">
					    	<div class="col-md-2"><span class="">穿衣</span></div>
					    	<div class="col-md-2"><span class="">紫外线强度</span></div>
					    	<div class="col-md-2"><span class="">洗车</span></div>
					    	<div class="col-md-2"><span class="">旅游</span></div>
					    	<div class="col-md-2"><span class="">感冒</span></div>
					    	<div class="col-md-2"><span class="">运动</span></div>
					    </div>
       				</div>
       			</div>
       			<div class="tab-pane" id="tab3">
       				<div>
       					<div class="row">
       						<div class="col-md-4"><span><h1>12<sup>℃</sup></h1></span></div>
       					</div>
       					<div class="row">
       						<div class="col-md-5"><span style>最低-3<sup>℃</sup></span></div>
       						<div class="col-md-2">~</div>
       						<div class="col-md-5"><span>最高25<sup>℃</sup></span></div>
        				</div>
        				<div class="row">
        					<div class="col-md-5"><span class="">南风3级</span></div>
        					<div class="col-md-2"><span class="">15Km/h</span></div>
        				</div>
       					<!-- 生活建议信息，先不做 -->
       					<div class="row">
       						<div class="col-md-12">生活建议</div>
       					</div>
					    <div class="row">
					    	<div class="col-md-2"><span class="">穿衣</span></div>
					    	<div class="col-md-2"><span class="">紫外线强度</span></div>
					    	<div class="col-md-2"><span class="">洗车</span></div>
					    	<div class="col-md-2"><span class="">旅游</span></div>
					    	<div class="col-md-2"><span class="">感冒</span></div>
					    	<div class="col-md-2"><span class="">运动</span></div>
					    </div>
       				</div>
       			</div>
       		</div>
	    </div>
    </div>
    <!-- Footer -->
    <div style="position:absolute;bottom:1%;left:40%;">
        <p>Copyright &copy; Bobby Cat 2017</p>
	</div>
</body>
</html>
