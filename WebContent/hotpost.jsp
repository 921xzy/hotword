<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>


<!-- Mirrored from www.zi-han.net/theme/hplus/file_manager.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:44 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - 文件管理器</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">

    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content">
        <div class="row">
            <div class="col-sm-3">
                <div class="ibox float-e-margins">
                    <div class="ibox-content">
                        <div class="file-manager">
                            <h5>显示：</h5>
                            <a href="file_manager.html#" class="file-control active">所有</a>
                            <!-- <a href="file_manager.html#" class="file-control">文档</a>
                            <a href="file_manager.html#" class="file-control">视频</a>
                            <a href="file_manager.html#" class="file-control">图片</a> -->
                            <div class="hr-line-dashed"></div>
                            <a href="${pageContext.request.contextPath}/domain"><button  class="btn btn-primary btn-block">下载文档</button></a>
                            <div class="hr-line-dashed"></div>
                            <h5>文件夹</h5>
                            <ul class="folder-list" style="padding: 0">
                                <li><a href="finance.jsp"><i class="fa fa-folder"></i> 财经</a>
                                </li>
                                <li><a href="tech.jsp"><i class="fa fa-folder"></i> 技术</a>
                                </li>
                                <li><a href="tendence.jsp"><i class="fa fa-folder"></i> 趋势</a>
                                </li>
                                <li><a href="hotpost.jsp"><i class="fa fa-folder"></i> 热点</a>
                                </li>
                                <li><a href="bazaar.jsp"><i class="fa fa-folder"></i> 市场</a>
                                </li>
                                <li><a href="viewpoint.jsp"><i class="fa fa-folder"></i> 视点</a>
                                </li>
                            </ul>
                            
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-9 animated fadeInRight">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="file-box">
                            <div class="file">
                               <a href="NewFile.jsp?key=1">
                                    <span class="corner"></span>

                                    <div class="icon">
                                        <i class="fa fa-file"></i>
                                    </div>
                                    <div class="file-name">
                                       		 Python
                                        <br/>
                                        <small>添加时间：2019-1-13</small>
                                    </div>
                                </a>
                            </div>

                        </div>
                        
                        
                        
                        
                        
                        <div class="file-box">
                            <a href="NewFile.jsp?key=3">
                                <div class="file">
                                    <span class="corner"></span>

                                    <div class="icon">
                                        <i class="fa fa-bar-chart-o"></i>
                                    </div>
                                    <div class="file-name">
                                        	物联网
                                        <br/>
                                        <small>添加时间：2019-1-13</small>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="file-box">
                            <div class="file">
                                <a href="NewFile.jsp?key=8">
                                    <span class="corner"></span>

                                    <div class="icon">
                                        <i class="fa fa-file"></i>
                                    </div>
                                    <div class="file-name">
                                    	    5G网络
                                        <br/>
                                        <small>添加时间：2019-1-13</small>
                                    </div>
                                </a>
                            </div>

                        </div>
                        
                        
                        <div class="file-box">
                            <div class="file">
                                <a href="NewFile.jsp?key=5">
                                    <span class="corner"></span>

                                    <div class="icon">
                                        <i class="img-responsive fa fa-film"></i>
                                    </div>
                                    <div class="file-name">
                                        	人工智能
                                        <br/>
                                        <small>添加时间：2019-1-13</small>
                                    </div>
                                </a>
                            </div>
                        </div>
                        <div class="file-box">
                            <div class="file">
                              <a href="NewFile.jsp?key=13">
                                    <span class="corner"></span>

                                    <div class="icon">
                                        <i class="fa fa-file"></i>
                                    </div>
                                    <div class="file-name">
                                    	   云计算
                                        <br/>
                                        <small>添加时间：2019-1-13</small>
                                    </div>
                                </a>
                            </div>

                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <script src="js/content.min.js?v=1.0.0"></script>
    <script>
        $(document).ready(function(){$(".file-box").each(function(){animationHover(this,"pulse")})});
    </script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/file_manager.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:44 GMT -->
</html>
