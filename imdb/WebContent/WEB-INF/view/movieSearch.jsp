<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie Search</title>
</head>
<body>
	<h3>Search Movie By Title</h3>
	<form method="get" action="searchByTitle">
		<table>
			<tr>
				<td>Enter Title</td>
				<td><input type="text" name="title"></td>
				<td><input type="submit" value="Search"></td>
			</tr>

		</table>
	</form>
	<hr>
	<h3>Search Movie By Year</h3>
	<form method="get" action="searchByYear">
		<table>
			<tr>
				<td>Enter Year</td>
				<td><input type="text" name="year"></td>
				<td><input type="submit" value="Search"></td>
			</tr>

		</table>
	</form>
	<hr>
	<h3>Search Movie By Director Name</h3>
	<form method="get" action="searchByDirector">
		<table>
			<tr>
				<td>Enter Name</td>
				<td><input type="text" name="director"></td>
				<td><input type="submit" value="Search"></td>
			</tr>

		</table>
	</form>
	<hr>
	<h3>Search Movie By Actor Name</h3>
	<form method="get" action="searchActor">
		<table>
			<tr>
				<td>Enter Name</td>
				<td><input type="text" name="actor"></td>
				<td><input type="submit" value="Search"></td>
			</tr>

		</table>
	</form>
	<hr>

	<h3>Search Movie By Genere</h3>
	<form method="get" action="searchByGenre">
		<table>
			<tr>
				<td>Enter Genere</td>
				<td><input type="text" name="gener"></td>
				<td><input type="submit" value="Search"></td>
			</tr>

		</table>
	</form>
	<hr>
	<h3>Search Movie By Rating</h3>
	<form method="get" action="searchByRating">
		<table>
			<tr>
				<td>Enter Rating</td>
				<td><input type="text" name="rating"></td>
				<td><input type="submit" value="Search"></td>
			</tr>

		</table>
	</form>
	<hr>
</body>
</html>