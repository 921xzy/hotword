<%@page import="hotword.bean.HotWord"%>
<%@page import="hotword.dao.HotWordDaoImpl"%>
<%@page import="hotword.bean.Reference"%>
<%@page import="java.util.List"%>
<%@page import="hotword.dao.ReferenceDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>


<!-- Mirrored from www.zi-han.net/theme/hplus/mailbox.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:18:21 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - 收件箱</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content" >
        <div class="row">
            <!-- <div class="col-sm-3">
                <div class="ibox float-e-margins">
                    <div class="ibox-content mailbox-content">
                        <div class="file-manager">
                            <a class="btn btn-block btn-primary compose-mail" href="mail_compose.html">写信</a>
                          
             
             

                            
                            
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div> -->
            <div class="col-sm-9 animated fadeInRight">
                <div class="mail-box-header">

                    <form method="get" action="http://www.zi-han.net/theme/hplus/index.html" class="pull-right mail-search">
                        <div class="input-group">
                            <!-- <input type="text" class="form-control input-sm" name="search" placeholder="搜索邮件标题，正文等"> -->
                            <div class="input-group-btn">
                               <!--  <button type="submit" class="btn btn-sm btn-primary">
                                    搜索
                                </button> -->
                            </div>
                        </div>
                    </form>
                    <h2>
                   热词标题展示
                </h2>
                    <div class="mail-tools tooltip-demo m-t-md">
                        <div class="btn-group pull-right">
                            <button class="btn btn-white btn-sm"><i class="fa fa-arrow-left"></i>
                            </button>
                            <button class="btn btn-white btn-sm"><i class="fa fa-arrow-right"></i>
                            </button>

                        </div>
                        <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="left" title=""><i class="fa fa-refresh"></i> 刷新</button>
                        <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="标为已读"><i class="fa fa-eye"></i>
                        </button>
                        <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="标为重要"><i class="fa fa-exclamation"></i>
                        </button>
                        <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="标为垃圾邮件"><i class="fa fa-trash-o"></i>
                        </button>

                    </div>
                </div>
                <div class="mail-box">

                    <table class="table table-hover table-mail">
                        <tbody>
                        <%
                        request.setCharacterEncoding("utf-8");
                        int id=Integer.parseInt(request.getParameter("key"));
                    	//System.out.print(key);
                    	String explain = null;
						HotWordDaoImpl hotWordDaoImpl=new HotWordDaoImpl();
						List<HotWord> hot=hotWordDaoImpl.loadspell(id);
						for(HotWord hot1: hot)
						{
							explain=hot1.getName();
						}
	
 	System.out.print(explain);
	ReferenceDaoImpl resDao = new ReferenceDaoImpl();
	List<Reference> refs = resDao.getURL(explain);
	int i = 1;  
	for(Reference ref : refs) { 
%>
	<%-- <span><%=i++ %>.&nbsp;&nbsp;</span> --%>
	<%-- <a href="<%=ref.getLinkHref() %>" target="_blank"><%=ref.getTitle() %></a> --%>
	<%-- <p>&nbsp;&nbsp;&nbsp;&nbsp;导读：<%=ref.getIntroduce() %></p> --%>
	
		

                            <tr class="unread">
                                <!-- <td class="check-mail">
                                    <input type="checkbox" class="i-checks">
                                </td> -->
                                <td class="mail-ontact"><span><%=i++ %>.&nbsp;&nbsp;</span>
                                </td>
                                <td>
                                <a href="<%=ref.getLinkHref() %>" target="_blank"><%=ref.getTitle() %></a>
                                </td>
                                <td class=""><i class="fa fa-paperclip"></i>
                                </td>
                                <td class="text-right mail-date"></td>
                            </tr>
                            
                         	<% 

							}
							%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <script src="js/content.min.js?v=1.0.0"></script>
    <script src="js/plugins/iCheck/icheck.min.js"></script>
    <script>
        $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
    </script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/mailbox.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:18:22 GMT -->
</html>
