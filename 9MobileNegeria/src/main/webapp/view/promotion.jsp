<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<!DOCTYPE html>
	<html>

	<head>
		<script>
			var Msisdn = document.getElementById('msisdn');
		</script>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
		<link
			href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
			rel="stylesheet">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
			integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
			crossorigin="anonymous" referrerpolicy="no-referrer" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js">

		<style>
			.logo {
				margin-top: -52%;
				margin-left: 35%;
			}

			.display-current-set {
				height: 50px;
				width: 350px;
				margin-left: 75%;
				margin-top: 4%;
				background-color: brown;

			}

			.display-current-set p {
				color: aliceblue;
				font-weight: 900;
				font-size: 30px;
			}

			.table {
				color: white;

			}

			.btns {
				height: 100px;
				margin-left: 50px;
				padding-left: 50px;
				display: flex;
				flex-direction: column;
				margin-top: -3%;

			}

			.btns button {
				display: flex;
				flex-direction: column;
				margin-left: 20px;
				margin-top: 30px;
				padding-left: 20px;
				padding-right: 20px;
				border-radius: 8px;

			}

			.btns h3 {
				font-weight: 900;
				font-size: 30px;
				color: aliceblue;
			}

			#loading {
				width: 4rem;
				height: 4rem;
				border: 5px solid #f3f3f3;
				border-top: 6px solid #9c41f2;
				border-radius: 100%;
				margin: auto;
				visibility: hidden;
				animation: spin 1s infinite linear;
			}

			.loading-conatiner {
				margin-bottom: 200px;
				margin-top: 5px;
				
			}

			@keyframes spin {
				form {
					transform: rotate(0deg);
				}

				to {
					transform: rotate(360deg);
				}
			}

			#btn2 {
				margin-left: 40%;
				margin-top: 3%;
			}

			#btn2 p {
				color: aliceblue;
				font-weight: 500;
				font-size: 20px;
			}

			select {
				padding: 10px 80px;
				border-radius: 5px;
			}

			select option {
				font-size: 20px;
				padding: 8px 80px;
			}

			.set-btn {
				margin-left: 40%;
			}

			.set-btn button {
				padding: 10px 80px;
				font-weight: 800;
				font-size: 20px;
				border-radius: 50px;
				background-color: #ff0000;
			}

			.form2 {
				align-items: center;
				justify-content: center;
			}
			.logout{
				margin-top: -42%;
				margin-left: 90%;
			}
		</style>


	</head>

	<body>
		<!--banner-section-->


		<form class="form-submit pb-4 pt-2" action="/set/Promotion" method="post">
			<section class="position-relative">
				<img src="${pageContext.request.contextPath}/images/bckground_000.png"
					class="img-fluid bckground_000 d-block w-100">

				<div class="logo">
					<img src="${pageContext.request.contextPath}/images/logo.png"
						class="img-fluid d-block mx-auto logo_0" alt="logo_0">
				</div>
				<div id="inp">
					<input type="hidden" value="${username}" name="username">

				</div>
				<div class="display-current-set">
					<p>Current Promotion</p>
					<div id="tableinside">
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Country Name</th>
									<th scope="col">Promotion Type</th>
								</tr>
							</thead>
							<tbody id="alldata">

							</tbody>
						</table>
					</div>
				</div>
				<div class="btns">
					<h3>Choose Country</h3>
					<div id="btn">

					</div>

				</div>

				<div id="btn2">

					<p>Choose PackType</p>
					<select name="typepromo" id="btn3">

					</select>
				</div>
				<div class="loading-conatiner">
					<div id="loading"></div>
				</div>
				<div class="set-btn" id="sub-btn">
					<button type="submit" class="btn btn-danger">Set-Promotion</button>
				</div>
				<div class="logout">
					<button type="button" class="btn btn-danger" onclick="logout()">Log out</button>
				</div>
			</section>
		</form>
		<form id="logout" action="/logout" method="post"> 

		</form>
		<script type="text/javascript">
			var out;
			document.getElementById("loading").style.visibility = "visible";
			document.getElementById("btn2").style.visibility = "hidden";
			document.getElementById("sub-btn").style.visibility = "hidden";

			fetch("http://lp.quiz2play.com/active")
				// fetch("http://lp.quiz2play.com/get?id=1")
				.then((data) => {
					return data.json();
				})
				.then((objectData) => {
					out = objectData;
					objectData.map((values) => {

						var eachrow = "<tr>"
							+ "<td>" + values.country + "</td>"
							+ "<td>" + values.packType + "</td>"
							+ "</tr>";
						$('table tbody').append(eachrow);
						var eachbtn;
						eachbtn = '<button type="button" onclick="fetchbyportalid(' + values.portalid + ',' + values.operatorid + ')"  class="btn btn-warning">' + values.country + '</button>';
						$('#btn').append(eachbtn);
						document.getElementById("loading").style.visibility = "hidden";
					});
				});


			function fetchbyportalid(portalid, opid) {
				document.getElementById("loading").style.visibility = "visible";
				console.log(portalid + "  portal    and op   " + opid);
				$('#btn3').empty();
				fetch("http://lp.quiz2play.com/getlistbyportalid?portalid=" + portalid + "&opid=" + opid)
					// fetch("http://lp.quiz2play.com/get?id=1")

					.then((data) => {
						return data.json();
					})
					.then((objectData) => {
						objectData.map((values) => {
							// var inputtype = '<input type="text" value="'+values.packType+'" name="packType">';
							// var inputtype = '<button type="button" class="btn btn-success">' + values.packType + '</button>';
							var inputtype = '<option  value="' + values.packType + '" >' + values.packType + '</option>';
							$('#btn3').append(inputtype);
							var inpset = '<input type="hidden" value="' + portalid + '" name="portalId">';
							$('#inp').append(inpset);
							var inpset2 = '<input type="hidden" value="' + opid + '" name="opId">';
							$('#inp').append(inpset2);
							document.getElementById("btn2").style.visibility = "visible";
							document.getElementById("loading").style.visibility = "hidden";
							document.getElementById("sub-btn").style.visibility = "visible";

						});

					});


			}


			function logout()
			{
				let form = document.getElementById("logout");
            form.submit();
			}




		</script>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
			integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
			crossorigin="anonymous"></script>
		<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

	</body>

	</html>