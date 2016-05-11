
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Director Form</title>

</head>
<body>
<c:if test="${empty director.name}">
		<h1>Add Director</h1>
	</c:if>
	<c:if test="${not empty director.name}">
		<h1>Update Director</h1>
	</c:if>
	
	<c:if test="${empty director.name}">
		<spring:url value="add" var="actionUrl" />
	</c:if>
	<c:if test="${not empty director.name}">
		<spring:url value="../edit/${ director.id}" var="actionUrl" />
	</c:if>
	<form:form method="post" modelAttribute="directorForm" action="${actionUrl}">
	
		
		<table>
			
						<tr>
							<td><label>Name</label></td>
							<td><form:input path="name" type="text" /></td>
						</tr>
						
					

			
			<tr>
				<td>
					<button type="submit">Submit</button>
				</td>
			</tr>
		</table>
	</form:form>

</body>
</html>