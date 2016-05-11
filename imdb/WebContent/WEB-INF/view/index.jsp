<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie Review</title>
</head>
<body>
	<h1>Welcome to IMDB Movie review</h1>
	<h1>${message}</h1>
	<h4>Movies</h4>

	<p>
		<a href="movie/add">Add Movie</a> <a href="movie/search">Search
			Movie</a>
	</p>
	<table border="1">
		<thead>
			<tr>
				<td>Title</td>
				<td>Year</td>
				<td>Action</td>
			</tr>
		</thead>
		<c:forEach items="${movies}" var="movie">

			<tr>
				<td>${movie.title}</td>
				<td>${movie.year}</td>
				<td><a href="movie/edit/${movie.id}">Edit</a> <a
					href="movie/delete/${movie.id} ">Delete</a></td>

			</tr>
		</c:forEach>
	</table>

	<hr>
	<h3>Artists</h3>
	<table border="1">
		<thead>
			<tr>
				<td>Name</td>
				<td>Date of Birth</td>
				<td>Place of Birth</td>
				<td>Biography</td>
				<td>Action</td>
			</tr>
			<c:forEach items="${actors}" var="actor">

				<tr>
					<td>${actor.name}</td>
					<td>${actor.dateOfBirth}</td>
					<td>${actor.placeOfBirth}</td>
					<td>${actor.biography}</td>
					<td><a href="actor/edit/${actor.actor_Id}">Edit</a> <a
						href="actor/delete/${actor.actor_Id} ">Delete</a></td>

				</tr>
			</c:forEach>

		</thead>
	</table>
	<hr>
	<h3>Directors</h3>
	<table border="1">
		<thead>
			<tr>
				<td>Name</td>

				<td>Action</td>
			</tr>
			<c:forEach items="${directors}" var="director">

				<tr>
					<td>${director.name}</td>

					<td><a href="director/edit/${director.directorId}">Edit</a> <a
						href="director/delete/${director.directorId} ">Delete</a></td>

				</tr>
			</c:forEach>

		</thead>
</body>
</html>