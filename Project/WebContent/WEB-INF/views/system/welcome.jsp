<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>欢迎页面</title>
</head>
<body>
<div align="center">
 <h1 style="margin-top:100px">
 	欢迎${admin.username}登陆！
 </h1>
 
 <p style="font-size: 25px">SSM</p>
 <div title="欢迎使用" style="padding:20px;overflow:hidden;font-size: 15px " >
<%-- 	<p style="font-size: 50px; line-height: 60px; height: 60px;">${systemInfo.schoolName}</p> --%>
  	<p>开发人员：BOBO</p>
  	<p>开发周期：（2020.10 --- 2020.11）</p>
  	
  	<hr />
  	<h2>系统环境</h2>
  	<p>系统环境：Windows</p>
	<p>开发工具：Eclipse</p>
	<p>Java版本：JDK 12</p>
	<p>服务器：tomcat 9.0</p>
	<p>数据库：MySQL 8.0.22</p>
	<p>系统采用技术： Spring+SpringMvc+Mybaiys+EasyUI+jQuery+Ajax+面向接口编程</p>
</div>

</div>
</body>
</html>