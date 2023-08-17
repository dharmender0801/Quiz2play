<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<script>
	var Pin=document.getElementById('pin');	
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
</head>

<body>
    <!--banner-section-->
    <form class="form-submit pb-4 pt-2" action="/burkina/v1/pinverify/" method="post">
    <section class="position-relative bg_0 py_5">
        <img src="${pageContext.request.contextPath}/images/bckground_000.png" class="img-fluid bckground_000 d-block w-100">
        <div class="banner position-absolute">
            <div class="container-fluid">
                <div class="row justify-content-between">
                    <div class="col-md-5">
                        <img src="${pageContext.request.contextPath}/images/quizwheel.png" class="img-fluid  d-block" alt="spin_0">
                    </div>
                    <input type="hidden" value="${msisdn}" name="msisdn">
                    <input type="hidden" value="${kpId}" name="kpId">
                    <input type="hidden" value="${productId}" name="productId">
					<input type="hidden" value="${language}" name="language">
                    <input type="hidden" value="${transactionId}" name="transactionId">
                    <input type="hidden" value="${challengeId}" name="challengeId">
                    
                    
                    
                    <div class="col-md-4 my-auto">
                        <img src="${pageContext.request.contextPath}/images/logo.png" class="img-fluid d-block mx-auto logo_0" alt="logo_0">
                        <img src="${pageContext.request.contextPath}/images/quote.png" class="img-fluid d-block mx-auto txt_0 " alt="text">
                        <input type="number"  maxlength=4 class="form-control tel_0 d-block mx-auto" name="pin" placeholder="Enter Your Pin to Subscribe">

                        <button type="submit" class="btn d-block mx-auto btn_0 mt-4">Confirm</button>
                        <p class=" phra_0  d-block mx-auto  py-2">${msg1} </p>
                    </div>
                    <div class="col-md-3 mt-5">
                        <img src="${pageContext.request.contextPath}/images/girl_1.png" class="img-fluid d-block girl_0" alt="girl_0">

                    </div>
                </div>

                <span class="phra_0">
                    <p class="text-center">Quiz2Play service for ${country} is an
                        exciting trivia quiz game. ${msg2} . ${unsubcode} </p>
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