<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Content-Type" content="text/html">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Customers</title>
</head>
<body>
	<section>
		<div class="jumbotron"></div>
		<div class="container">
			<h1>Customers</h1>
			<p>All xustomers</p>
		</div>

	</section>
	<section class="container">
		<div class="row">
		<c:forEach var="clip" items="${customers}" >
			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
				<div class="thumbnail">
					<div class="caption">
					<h3>${clip.name}</h3>
					<p>${clip.address}</p>
					<p>Orders num. ${clip.noOfOrdersMade}</p>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>