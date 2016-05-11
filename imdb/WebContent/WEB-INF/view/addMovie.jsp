<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie Form</title>
</head>
<body>
	<c:if test="${empty movie.title}">
		<h1>Add Movie</h1>
	</c:if>
	<c:if test="${not empty movie.title}">
		<h1>Update Movie</h1>
	</c:if>

	<c:if test="${empty movie.title}">
		<spring:url value="add" var="actionUrl" />
	</c:if>
	<c:if test="${not empty movie.title}">
		<spring:url value="update/${movie.id }" var="actionUrl" />
	</c:if>
	<form:form method="post" modelAttribute="movieForm"
		action="${actionUrl}">
		<table>
			<tr>
				<td>Title</td>
				<td><form:input path="title" type="text" /></td>
				<td><form:errors path="title" /></td>
			</tr>
			<tr>
				<td>Year</td>
				<td><form:input path="year" type="text" /></td>
				<td><form:errors path="year" /></td>
			</tr>
			<tr>
				<td>Summary</td>
				<td><form:textarea path="summary" rows="5" cols="30" /></td>
				<td><form:errors path="summary" /></td>
			</tr>

			<tr>
				<td>Genre</td>
				<td><form:select path="genere">
						<form:option value="">Select Movie Genere:</form:option>
						<c:forEach items="${genere}" var="genere">
							<form:option value="${genere}">${genere}</form:option>
						</c:forEach>
					</form:select></td>
				<td><form:errors path="genere" /></td>
			</tr>

			<tr>
				<td>Genre</td>
				<td><form:input path="gener" type="text" /></td>
				<td>Rating</td>
				<td><form:input path="rating" type="text" /></td>
			</tr>

		</table>
		<table>
			<h3>Directors</h3>
				<c:choose>
					<c:when test="${empty movie.director}">
						<c:forEach items="movie.director" var="director"
							varStatus="status">
							<td><label>Name</label></td>
							<td><form:input path="director[0].name" type="text" /></td>

						</c:forEach>
					</c:when>

					<c:otherwise>
						<c:forEach items="movie.director" var="director"
							varStatus="status">
							<td><label>Name</label></td>
							<td><form:input path="director[0].name" type="text" /></td>
						</c:forEach>
					</c:otherwise>
				</c:choose>

		</table>
		<h3>Actors</h3>
		<table>
			<c:choose>
				<c:when test="${empty movie.director}">
					<c:forEach items="movie.actor" var="actor" varStatus="status">
						<tr>
							<td><label>Name</label></td>
							<td><form:input path="actor[0].name" type="text" /></td>
						</tr>
						<tr>
							<td><label>Date Of Birth</label></td>
							<td><form:input path="actor[0].dateOfBirth" type="text" /></td>
						</tr>
						<tr>
							<td><label>Birth Place</label></td>
							<td><form:input path="actor[0].placeOfBirth" type="text" /></td>
						</tr>
						<tr>
							<td><label>About</label></td>
							<td><form:input path="actor[0].biography" type="text" /></td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<c:forEach items="movie.actor" var="actor" varStatus="status">
						<tr>

							<td><label>Name</label></td>
							<td><form:input path="actor[0].name" type="text" /></td>
						</tr>
						<tr>
							<td><label>Date Of Birth</label></td>
							<td><form:input path="actor[0].dateOfBirth" type="text" /></td>
						</tr>
						<tr>
							<td><label>Birth Place</label></td>
							<td><form:input path="actor[0].placeOfBirth" type="text" /></td>
						</tr>
						<tr>
							<td><label>About</label></td>
							<td><form:input path="actor[0].biography" type="text" /></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<tr>
				<td>
					<button type="submit">Submit</button>
				</td>
			</tr>
		</table>
	</form:form>

</body>
</html>