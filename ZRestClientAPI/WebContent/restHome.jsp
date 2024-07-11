<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/jquery.min.js"></script>
<script type="text/javascript">
function getDetail()
{
	var stCode=document.getElementById("stCode").value;
	$.ajax({
		
   url : "http://localhost:1111/kapil14/distList?stCode="+stCode+"",
		type : "GET",
		contentType :"application/json",
		dataType : 'json',
		success : function(res){
			$('#t').empty();
			
var h="<tr><td>scode</td><td>distict name</td><td>dist code</td></tr>"
				$('#t').append(h);
			
			for(var i=0; i< res.length;i++)
				{
				 
h="<tr><td>"+res[i].stCode+"</td><td>"+res[i].distName+"</td><td>"+res[i].distCode+"</td></tr>"
				$('#t').append(h);
				}
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
<tr><td>State Code</td><td><input type="text" name="stCode" id="stCode" onblur="getDetail()"></td></tr>

<tbody id="t">

</tbody>
</table>


</body>
</html>