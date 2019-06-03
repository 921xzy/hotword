
<%@page import="hotword.dao.ReferenceDaoImpl"%>
<%@page import="hotword.bean.HotWord"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mysql.fabric.xmlrpc.base.Array"%>
<%@page import="java.util.List"%>
<%@page import="hotword.dao.HotWordDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>字符云</title>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <title>Title</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
    <style>
		*{padding:0px;margin:0px;}
        .pop {  display: none;  width: 600px; min-height: 470px;  max-height: 750px;  height:470px;  position: absolute;  top: 0;  left: 0;  bottom: 0;  right: 0;  margin: auto;  padding: 25px;  z-index: 130;  border-radius: 8px;  background-color: #fff;  box-shadow: 0 3px 18px rgba(100, 0, 0, .5);  }
        .pop-top{  height:40px;  width:100%;  border-bottom: 1px #E5E5E5 solid;  }
        .pop-top h2{  float: left;  display:black}
        .pop-top span{  float: right;  cursor: pointer;  font-weight: bold; display:black}
        .pop-foot{  height:50px;  line-height:50px;  width:100%;  border-top: 1px #E5E5E5 solid;  text-align: right;  }
        .pop-cancel, .pop-ok {  padding:8px 15px;  margin:15px 5px;  border: none;  border-radius: 5px;  background-color: #337AB7;  color: #fff;  cursor:pointer;  }
        .pop-cancel {  background-color: #FFF;  border:1px #CECECE solid;  color: #000;  }
        .pop-content{  height: 380px;  }
        .pop-content-left{  float: left;  }
        .pop-content-right{  width:310px;  float: left;  padding-top:20px;  padding-left:20px;  font-size: 16px;  line-height:35px;  }
        .bgPop{  display: none;  position: absolute;  z-index: 129;  left: 0;  top: 0;  width: 100%;  height: 100%;  background: rgba(0,0,0,.2);  }
    </style> 
</head>
<body>


 <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="height:700px;width:900px"></div>
    <!-- ECharts单文件引入 -->
   <%
   	HotWordDaoImpl wordDao = new HotWordDaoImpl();
   List<HotWord> hotwords = new ArrayList();
   hotwords = wordDao.load();
   String name = null;
   %>
  
  <script src="echart/echarts-all.js"></script>
  <script type="text/javascript">
  function createRandomItemStyle() {
	    return {
	        normal: {
	            color: 'rgb(' + [
	                Math.round(Math.random() * 160),
	                Math.round(Math.random() * 160),
	                Math.round(Math.random() * 160)
	            ].join(',') + ')'
	        }
	    };
	}

        // 基于准备好的dom，初始化echarts图表
        var myChart = echarts.init(document.getElementById('main')); 
        var option = {
        	    title: {
        	        text: '近期IT热词',
        	        link: ''
        	    },
        	    tooltip: {
        	        show: true
        	    },
        	    series: [{
        	        name: '热词',
        	        type: 'wordCloud',
        	        size: ['80%', '80%'],
        	        textRotation : [0, 45, 90, -45],
        	        textPadding: 0,
        	        autoSize: {
        	            enable: true,
        	            minSize: 14
        	        },
        	        data: [
        	        	<%
        	        	for(HotWord word : hotwords)
    	            	{
    	            	
    	            	%>
	        	            {
	        	            	
	        	                name: '<%=word.getName()%>',
	        	                value: 500,
	        	                itemStyle: createRandomItemStyle(),
	        	                link: '<%="NewFile.jsp"%>'
	        	                
	        	            },


        	            <%}%>
        	        ]
        	    }]
        	};
               
        // 为echarts对象加载数据 
        myChart.setOption(option); 
        //添加点击事件（单击），还有其他鼠标事件和键盘事件等等
        myChart.on("click", function (param){  
        	  var name=param.name;
        	  
        	 // $("#demo").val(123);
        	  $("#demo").val(name);
        	  $("#demo01").text(name);
        	  
        	  
				
        	  $.ajax({
        		 type:'GET',//用的get的方法
        		 dataType : "JSON",//json的数据格式
        		 url:'AppServlet',//servlet相当于一个小型的服务器，直接去AppServlet执行出动态爬取的项目
        		 data:{
        			 content:name//相当于data的一个属性值，将name赋给content
        		 },
        		 success:function(data){//这个是appservlet执行成功后执行的代码
        			 //alert('成功');
        			 $('.bgPop,.pop').show();
        			 //$('#title').text(name);
        			 $('#jieshi').text(data.explain);
        			 //$('.pop').text(data.explain);
        		 }
        	  });
        	  
        	 
        	//window.location.href="referenceShow.jsp?name="+name;
        });
    </script>
<!--点击按钮-->


<!--遮罩层-->
<div class="bgPop"></div>
<!--弹出框-->
<form method="post" action="referenceShow.jsp">
<div class="pop">
    <div class="pop-top">
        <span class="pop-close">Ｘ</span>
    </div>
    <div class="pop-content">
        <div class="pop-content-left">
            <img src="" alt="" class="teathumb">
        </div>
        <div class="pop-content-right">
        	 <input type="hidden" id="demo" name="explain"   class="pop-ok" value=""/>
            <p style=" font-size:17px; color:#2a5caa" id="demo01" ><b class="lname"></b></p>
        <p style=" font-size:17px; color:#2a5caa">热词解释：<b class="price"></b></p>
        <div >
        <textarea style=" font-size:17px; color:#2a5caa" id="jieshi" rows="14" cols="49"></textarea>
        
        <p ></p>
        </div>
        

        </div>
    </div>
    <div class="pop-foot">
        <input type="button" value="关闭" class="pop-cancel pop-close"/>
        <input type="submit" value="查看引用" class="pop-ok"/>
    </div>
</div>




<script type="text/javascript">
    $(document).ready(function () {
        $('.pop-close').click(function () {
            $('.bgPop,.pop').hide();
        });
        $('.click_pop').click(function () {
            $('.bgPop,.pop').show();
        });
    })

</script>
</form>
</body>
</html>