<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>add Product</title>
</head>
<body>
	<section>
	<div class="jumbotron"></div>
	<div class="container">
		<h1>Customers</h1>
		<p>Add product</p>
	</div>

	</section>
	<section class="container"> <form:form method="POST"
		modelAttribute="newProduct" class="form-horizontal"
		enctype="multipart/form-data">
		<fieldset>
			<legend>Add new product</legend>
			<div class="form-group">
				<!-- <label class="control-label col-lg-2 col-lg-2" for="productId">Product id</label> -->
				<label class="control-label col-lg-2 col-lg-2" for="productId"><spring:message
						code="addProduct.form.productId.label" /></label>
				<div class="col-lg-10">
					<form:input id="productId" path="productId" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="name">Name</label>
				<div class="col-lg-10">
					<form:input id="name" path="name" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="unitPrice">Price</label>
				<div class="col-lg-10">
					<form:input id="unitPrice" path="unitPrice" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="manufacturer">Brand</label>
				<div class="col-lg-10">
					<form:input id="manufacturer" path="manufacturer" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="category">Category</label>
				<div class="col-lg-10">
					<form:input id="category" path="category" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="unitsInStock">In
					stock</label>
				<div class="col-lg-10">
					<form:input id="unitsInStock" path="productId" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="unitsInOrder">In
					order</label>
				<div class="col-lg-10">
					<form:input id="unitsInOrder" path="unitsInOrder" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="description">Description</label>
				<div class="col-lg-10">
					<form:textarea id="description" path="description" rows="2" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="condition">Condition</label>
				<div class="col-lg-10">
					<form:radiobutton path="condition" value="New" />
					New
					<form:radiobutton path="condition" value="Old" />
					Old
					<form:radiobutton path="condition" value="Refurbished" />
					Refurbished
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2" for="productImage"> <spring:message
						code="addProduct.form.productImage.label" />
				</label>
				<div class="col-lg-10">
					<form:input id="productImage" path="productImage" type="file"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2" for="productManual"> <spring:message
						code="addProduct.form.productManual.label" />
				</label>
				<div class="col-lg-10">
					<form:input id="productImage" path="productManual" type="file"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="discontinued">Discontinued</label>
				<div class="col-lg-10">
					<form:checkbox id="discontinued" path="discontinued" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary"
						value="Add" />
				</div>
			</div>
		</fieldset>
	</form:form> </section>
</body>
</html>