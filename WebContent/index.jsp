<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Controller</title>
</head>
<body>

	<table border=1 cellspacing=0 cellpadding=0 width="100%">
		<tr>
			
				<td>
					<%@ include file="SearchBox.jsp"%>
				</td>
		</tr>

		<tr>
					<td valign="top"><%@ include file="FacetNavigation.jsp"%></td>
					<td valign="top"><%@ include file="Result.jsp"%></td>

		</tr>
	</table>

</body>
</html>