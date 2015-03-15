<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>edit</title>
</head>

<body>
<div id=container align="justify">
<!-- ------------------------main edit form----------------------------- -->

<form action="/editprimary" >
<div id=image align="left">
<img height="100px" width="100px" alt="" src="gfghf" /> 
</div>
<div id=content1>
<label>First Name</label><label>${pro1.firstname}</label><br>
<label>Last Name</label><label>${pro1.lastname}</label><br>
<label>Date Of Birth</label><input type="text" id=dobfld value='${emp1.dob}'><br>
<label>Passport</label><input type="text" id=passportfld value='${emp1.passport}'><br>
</div>
<div id=content2>
<label>Summary</label><textarea rows="5" cols="" id=summaryfld >${emp1.summary}</textarea><br>
<br>
<br>
<input type="submit" value="save"/>
<br>
</form>
<!-- -----------------end of form--------------------- -->
<label>Skills</label><br>

<%-- <c:forEach> --%>
<!-- <!-- <input type="checkbox" value=""  name="skills"><br> --> -->
<%-- </c:forEach> --%>


 --%>
<label>Education</label>
<center>
<table border="2" cellpadding="2" cellspacing="2" align="center">
<tr align="center">
<th >Degree</th><th>University</th><th>Year</th>
</tr>

 <c:forEach items="${edu}" var="eachedu" >
 <tr align="center">
<c:forTokens items="${eachedu.degree}" delims="," var="edu1">

<td><c:out value="${edu1}"></c:out></td>

</c:forTokens>
<td><a  href="editedu?columnid=${eachedu.columnid}">Edit</a> &nbsp <a href="deleteedu?columnid=${eachedu.columnid}">Delete</a></td>

</tr>
</c:forEach>

<!-- -------Education form start----------------------------- -->
</table><br>
<form action="addedu" >
<input type="text" value="${degree}"  name=Degreefld>
<input type="text" value="${board}" name=Boardfld>
<input type="text" value="${year}" name=Yearfld>
<input type="hidden" value="${columncount}" name=columncountfld>
<input type="hidden" value="${columnid}" name=columnidfld>
<input type="submit"  id=submitedu>
</form>

<!-- -------Education form end----------------------------- -->


<%-- 
<label>Experience</label>
<table border="2"cellpadding="2" cellspacing="2" align="center">
<tr align="center">
<th>Organization</th><th>Designation</th><th>Start Date</th><th>End Date</th>
</tr>
<c:forTokens items="${emp1.experience}" delims="*" var="item">

<tr align="center">
<c:forTokens items="${item}" delims="," var="exp">
<td><c:out value="${exp}"></c:out></td>
</c:forTokens>
<td><a href="">Edit</a>&nbsp
<a href="">Delete</a></td>
</tr>

</c:forTokens>

</table>
</center><br>



<!-- -------Experiance form start----------------------------- -->
<form action="editexp">
<input type="text" id=orgfld>
<input type="text" id=desgfld>
<input type="text" id=strtfld>
<input type="text" id=endfld>
<input type="submit" id=submitexp>
</form>
<!-- -------Experiance form end----------------------------- -->
</div> --%>

</div>

</body>
</html>