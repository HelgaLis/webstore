<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Content-Type" content="text/html">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron"></div>
		<div class="container">
			<h1>Products</h1>
			<p>All available products</p>
		</div>

	</section>
	<section class="container">
		<div class="row">
			<c:forEach var="clip" items="${products}">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<img src="<c:url value="/img/${clip.productId}.png"></c:url>"alt="image" style="width: 100%" />
						<div class="caption">
							<h3>${clip.name}</h3>
							<p>${clip.description}</p>
							<p>Available units ${clip.unitsInStock}</p>
							<p>
								<a
									href="<spring:url value="/market/product?id=${clip.productId}"/>">
									Details </a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>