<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/jquery.min.js"></script>
<script type="text/javascript">
function getAdd()
{
	var n1=document.getElementById("n1").value;
	var n2=document.getElementById("n2").value;
	
	$.ajax({
		
   url : "http://localhost:1000/ASpringServerRestAPI/add.do?n1="+n1+"&n2="+n2+"",
		type : "GET",
		contentType :"application/json",
		dataType : 'json',
		success : function(res){
			
			$('#modi').empty();
			
var h="<tr><td bgcolor='red'>Result</td><td>"+res.sum+"</td></tr>"
				$('#modi').append(h);
			
			
},
		error : function(e)
		{
			console.log(e);
		}
		
	}
	)
	}

</script>
</head>
<body>



<table border="2" bgcolor="cyan">


</tbody>
<tr><td>Enter No1</td><td><input type="text" name="n1" id="n1"></td></tr>
<tr><td>Enter No2</td><td><input type="text" name="n2" id="n2"></td></tr>
<tr><td><input type="button" value="Add" onclick="getAdd();"></td></tr>

<tbody id="modi">

</tbody>
</table>


</body>
</html>