<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="./resources/img/myicon/bobby_favicon.ico" rel="shortcut icon">
    <title>欢迎访问</title>

    <!-- Bootstrap Core CSS -->
    <link href="./resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="./resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- Theme CSS -->
    <link href="./resources/css/grayscale.min.css" rel="stylesheet">

</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
    <!-- Navigation -->
    <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand page-scroll" href="#page-top">
                    <i class="fa fa-play-circle"></i> <span class="light">首页</span> 
                </a>
            </div>

            <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                <ul class="nav navbar-nav">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#Photo">欢迎</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Intro Header -->
    <header class="intro">
        <div class="intro-body">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                    	<form action="" method="post">
							用户名:<input id="user" type="text" name="username">
							密码:<input id="pwd" type="password" name="password">
							<input id="btn" type="button" value="登录">
						</form>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Photo Section -->
    <section id="Photo" class="container">
    </section>


    <!-- Footer -->
    <footer>
        <div class="container text-center">
            <p>Copyright &copy; Bobby Cat 2017</p>
        </div>
    </footer>

    <!-- jQuery -->
    <script src="./resources/vendor/jquery/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="./resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript, update to  china cdn -->
    <script src="https://cdn.bootcss.com/jquery-easing/1.3/jquery.easing.min.js"></script>
    <!-- Theme JavaScript -->
    <script src="./resources/js/grayscale.min.js"></script>

</body>
<script>
$(function(){
	
	$("#btn").click(function(){
		var param = {
				userename:$("#user").val(),
				password:$("#pwd").val()
		}
		$.ajax({
	        type: "POST",
	        url: "example/welcome",
	        contentType: "application/json;UTF-8",
	        dataType: "json",
	        data: JSON.stringify(param),
	        success: function (response) {
	            console.log(response)
	        }
	    });
	})
})
</script>
</html>
