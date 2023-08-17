<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<script>
	var Msisdn = document.getElementById('msisdn');
</script>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
	integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js">

	<style>
        #border{
            padding-top: 50px;
            padding-bottom: 50px;
            border-radius: 20px;
            border: 3px solid whitesmoke;

        }
        .username{
            margin-top: 20px;
            padding: 2% 15%;
        }
        .password{
            padding: 2% 15%;
        }

        
	</style>
   

</head>

<body>
	<!--banner-section-->
	<form class="form-submit pb-4 pt-2" action="/login/check" method="post">
		<section class="position-relative bg_0 py_5">
			<img
				src="${pageContext.request.contextPath}/images/bckground_000.png"
				class="img-fluid bckground_000 d-block w-100">
			<div class="banner position-absolute">
				<div class="container-fluid">
					<div class="row justify-content-between">
						<div class="col-md-5">

							<img
								src="${pageContext.request.contextPath}/images/quizwheel.png"
								class="img-fluid  d-block" alt="spin_0">
						</div>
						
						<div class="col-md-4 my-auto" id ="border">
							<img src="${pageContext.request.contextPath}/images/logo.png"
								class="img-fluid d-block mx-auto logo_0" alt="logo_0">
                                
                                    
                                    <div class="username">
                                      <input type="text" id="form2Example1" class="form-control" name="email" required placeholder="username"/>
                                      
                                    </div>
                                  
                                  
                                    <div class="password">
                                      <input type="password" id="form2Example2" class="form-control" name="password" required placeholder="password" />
                                     
                                    </div>
                                  
                                   
                                  
                                    <!-- Submit button -->
                                    <button type="submit" class="btn d-block mx-auto btn_0 mt-4">Sign In</button>
                                  
                                  
                                    
                                 


						</div>
						<div class="col-md-3 mt-5">
							<img src="${pageContext.request.contextPath}/images/girl_1.png"
								class="img-fluid d-block girl_0" alt="girl_0">

						</div>
					</div>
<!-- 
					<span class="phra_0">
						<p class="text-center">Quiz2Play service for Burkina is an
							exciting trivia quiz game. Service price (100 FCFA) and user will
							receive a daily message . To Unsubscribe send 0 to 4540</p>
					</span> -->
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