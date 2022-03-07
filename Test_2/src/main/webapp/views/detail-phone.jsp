<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail page</title>
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

	<div class="container text-center">
		<div class="row">
			<div class="col-md-6 my-2 mx-auto">
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
							class="text-black">Edit</a> <a class="btn btn-danger"
							onclick="return confirm ('Are you sure remove this phone?')"
							href="${rootpath}delete?id=${phone.id}" class="text-black">Delete</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>