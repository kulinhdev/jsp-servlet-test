<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit page</title>
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

				<form action="update" method="post">
					<input type="hidden" value="${phone.id}" name="p_id">
					<div class="mb-3">
						<label for="" class="form-label">Name: </label> <input type="text"
							name="p_name" value="${phone.name}" class="form-control"
							placeholder="Name">
					</div>

					<div class="mb-3">
						<label for="" class="form-label">Price: </label> <input
							type="number" value="${phone.price}" name="p_price"
							class="form-control" placeholder="Price">
					</div>

					<div class="mb-3">
						<label for="" class="form-label">Status: </label>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="p_status"
								id="1" ${phone.status ? 'checked' : ''}> <label
								class="form-check-label" for="1"> In Stock </label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="p_status"
								id="2" ${phone.status ? '' : 'checked'}> <label
								class="form-check-label" for="2"> Out of stock </label>
						</div>
					</div>

					<div class="mb-3">
						<label for="" class="form-label">Image: </label> <input
							type="text" value="${phone.image}" name="p_image"
							class="form-control" placeholder="Image Url">
					</div>

					<div class="mb-3">
						<label for="" class="form-label">Warranty: </label> <input
							type="text" value="${phone.warranty}" name="p_warranty"
							class="form-control" placeholder="Warranty">
					</div>

					<div class="mb-3">
						<label for="" class="form-label">Accessories: </label> <input
							type="text" value="${phone.accessory}" name="p_accessory"
							class="form-control" placeholder="Accessories">
					</div>

					<button class="btn btn-warning" type="submit">Update</button>

					<!-- Button trigger modal -->
					<

					<!-- Modal -->
					

				</form>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
		integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
		integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
		crossorigin="anonymous"></script>
</body>
</html>