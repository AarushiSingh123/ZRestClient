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
	var adhar=document.getElementById("adhar").value;
	$.ajax({
		
   url : "http://localhost:1000/ASpringServerRestAPI/data.do?adhar="+adhar+"",
		type : "GET",
		contentType :"application/json",
		dataType : 'json',
		success : function(res){
			$('#modi').empty();
			
var h="<tr><td>Adhar</td><td>Name</td><td>Age</td><td>Add</td><td>Pass</td></tr>"
				$('#modi').append(h);
			
			for(var i=0; i< res.length;i++)
				{
				 
h="<tr><td>"+res[i].adhar+"</td><td>"+res[i].name+"</td><td>"+res[i].age+"</td><td>"+res[i].add+"</td><td>"+res[i].pass+"</td></tr>"
				$('#modi').append(h);
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
<tbody id="modi">

</tbody>
<tr><td>Adhar</td><td><input type="text" name="adhar" id="adhar" onblur="getDetail()"></td></tr>

<tbody id="modi">

</tbody>
</table>


</body>
</html>