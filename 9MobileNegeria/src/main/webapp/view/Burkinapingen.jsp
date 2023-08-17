<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<!DOCTYPE html>
	<html>

	<head>
		<script>
			var Msisdn = document.getElementById('msisdn');
		</script>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="http://lp.quiz2play.com/css/bootstrap.min.css">
		<link
			href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
			rel="stylesheet">
		<link rel="stylesheet" href="http://lp.quiz2play.com/css/style.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
			integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
			crossorigin="anonymous" referrerpolicy="no-referrer" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js">


		<style>
			.packtype {
				margin-left: 100px;
				margin-top: 10px;
				padding: 1% 20%;
				border-radius: 8px;
			}
		</style>

	</head>

	<body>
		<!--banner-section-->
		<form class="form-submit pb-4 pt-2" action="https://lpobf.altruistindia.com/burkina/v1/pinPush" method="post">
			<section class="position-relative bg_0 py_5">
				<img src="https://lpobf.altruistindia.com/images/bckground_000.png"
					class="img-fluid bckground_000 d-block w-100">
				<div class="banner position-absolute">
					<div class="container-fluid">
						<div class="row justify-content-between">
							<div class="col-md-5">

								<img src="https://lpobf.altruistindia.com/images/quizwheel.png"
									class="img-fluid  d-block" alt="spin_0">
							</div>
							<input type="hidden" value="${kpId}" name="kpId">
							<input type="hidden" value="${language}" name="language">
							<input type="hidden" value="${productId}" name="productId">
							<input type="hidden" value="${cpId}" name="cpId">
							<input type="hidden" value="${pubId}" name="pubId">

							<div class="col-md-4 my-auto">
								<img src="https://lpobf.altruistindia.com/images/logo.png"
									class="img-fluid d-block mx-auto logo_0" alt="logo_0">
								<!-- <img
								src="https://lpobf.altruistindia.com/images/quote.png"
								class="img-fluid d-block mx-auto txt_0 " alt="text">  -->

								<div class="my-3">
									<p class="txt_color">FACILE A JOUER</p>
									<p class="txt_color">FACILE A GAGNER</p>
								</div>

								<!-- <input type="number" maxlength=15 class="form-control tel_0 d-block mx-auto"
									name="msisdn" placeholder="Enter Your Cell Phone Number" required> -->
								<div class="input-group mb-3 inp_main">
									<span class="input-group-text" id="basic-addon1">+226</span>
									<input type="number" class="form-control tel_input"
										placeholder="Entrez votre numero de telephone"
										aria-label="Entrez votre numero de telephone" aria-describedby="basic-addon1" />
								</div>


								<button type="submit" class="btn d-block mx-auto btn_0 mt-4">Souscrivez</button>
								<p class=" phra_0  d-block mx-auto  py-2">${msg1}</p>
							</div>
							<div class="col-md-3 mt-5">
								<img src="https://lpobf.altruistindia.com/images/girl_1.png"
									class="img-fluid d-block girl_0" alt="girl_0">

							</div>
						</div>

						<span class="phra_0">
							<p class="text-center"> ${msg2}</p>
						</span>
					</div>


				</div>
			</section>
		</form>












		<!--x-banner-section-x-->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
			integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
			crossorigin="anonymous"></script>
		<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	</body>

	</html>