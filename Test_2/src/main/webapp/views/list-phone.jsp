<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<c:url value="/" var="rootpath" />
<body class="text-center my-3">

	<h1 class="my-3 text-center text-danger">
		<a href="${rootpath}mobile">PNL - Mobile Shop</a>
	</h1>

	<div class="container">
		<div class="row my-3">
			<div class="col-md-6 mx-auto">
				<form>
					<div class="mt-3">
						<input type="text" name="s_name" value="${s_name}"
							class="form-control" placeholder="Search Name ...">
					</div>

					<div class="mt-3">
						<select class="form-select" name="order_by">
							<option value="ASC">Order By</option>
							<option value="ASC" ${order_by == 'ASC' ? 'selected' : ''}>ASC</option>
							<option value="DESC" ${order_by == 'DESC' ? 'selected' : ''}>DESC</option>
						</select>
					</div>

					<button class="btn btn-warning px-2 my-2" type="submit">Search</button>

				</form>

				<a href="${rootpath}add" class="btn btn-success my-3" type="submit">Add
					new phone 🤑</a>
			</div>
		</div>

		<c:if test="${info != null}">
			<div class="alert alert-info alert-dismissible fade show my-3"
				role="alert">
				<strong>${info}</strong>
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>
		</c:if>

		<div class="row">
			<c:forEach items="${listPhone}" var="phone">
				<div class="col-md-4 my-2">
					<div class="card">
						<img src="${phone.image}" class="card-img-top p-3 w-50 m-auto"
							alt="">
						<div class="card-body">
							<h5 class="card-title">
								<a href="${rootpath}detail?id=${phone.id}" class="text-black">${phone.name}</a>
							</h5>
							<p class="card-text">Price: $${phone.price}</p>
							<p class="card-text">Status: ${phone.status ? "In Stock" : "Out of Stock"}</p>
							<p class="card-text">Warranty: ${phone.warranty}</p>
							<p class="card-text">Accessories: ${phone.accessory}</p>

							<a class="btn btn-warning" href="${rootpath}edit?id=${phone.id}"
								class="text-black"> Edit</a>



							<button type="button" class="btn btn-danger"
								data-bs-toggle="modal" data-bs-target="#removeItem">
								Delete</button>

							<div class="modal fade" id="removeItem" tabindex="-1"
								aria-labelledby="exampleModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title text-danger" id="exampleModalLabel">Hey
												there !!!</h5>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Close"></button>
										</div>
										<div class="modal-body">
											<p class="font-monospace fw-bolder fs-4">Are you sure
												remove this item?</p>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-bs-dismiss="modal">Close</button>
											<a class="btn btn-danger"
												href="${rootpath}delete?id=${phone.id}" class="text-black">
												Delete</a>
										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
			</c:forEach>
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