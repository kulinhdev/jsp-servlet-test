<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<c:url value="/" var="rootpath" />
<body class="my-3">

	<h1 class="my-3 text-center text-danger">
		<a href="${rootpath}mobile">PNL - Mobile Shop</a>
	</h1>

	<div class="container">
		<div class="row">
			<div class="col-md-6">

				<c:if test="${info != null}">
					<div class="alert alert-info alert-dismissible fade show my-3"
						role="alert">
						<strong>${info}</strong>
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
				</c:if>

				<form action="create" method="post">
					<div class="mb-3">
						<label for="" class="form-label">Name: </label> <input type="text"
							name="p_name" class="form-control" placeholder="Name">
					</div>

					<div class="mb-3">
						<label for="" class="form-label">Price: </label> <input
							type="number" name="p_price" class="form-control"
							placeholder="Price">
					</div>

					<div class="mb-3">
						<label for="" class="form-label">Status: </label>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="p_status"
								id="1" checked> <label class="form-check-label" for="1">
								In Stock </label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="p_status"
								id="2"> <label class="form-check-label" for="2">
								Out of stock </label>
						</div>
					</div>

					<div class="mb-3">
						<label for="" class="form-label">Image: </label> <input
							type="text" name="p_image" class="form-control"
							placeholder="Image Url">
					</div>

					<div class="mb-3">
						<label for="" class="form-label">Warranty: </label> <input
							type="text" name="p_warranty" class="form-control"
							placeholder="Warranty">
					</div>

					<div class="mb-3">
						<label for="" class="form-label">Accessories: </label> <input
							type="text" name="p_accessory" class="form-control"
							placeholder="Accessories">
					</div>

					<button class="btn btn-success" type="submit">Create</button>

				</form>
			</div>
		</div>
	</div>
</body>
</html>