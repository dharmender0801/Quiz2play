<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
            rel="stylesheet">
        <link rel="stylesheet" href="/css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
            integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
            crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>

    <body class="p-0">
        <!--banner-section-->
        <form action="/9mobile/redirect", method="get">
            <section class="position-relative flex-column bg_1 p-3" id="nigeria_banner">
                <!-- <img src="images/bckground_000-01.png" class="img-fluid bckground_000 d-block w-100"> -->
                <!-- <div class="banner"> -->
                <div class="d-flex align-items-center" style="position: relative; z-index:9;">
                    <div class="m-0 p-0 banner text-white text-center w-100 mx-auto" style="font-size: 17px;">Beat the
                        clock
                        in 30 seconds & answer the multiple choice text based question for top score!
                    </div>
                    <img src="${pageContext.request.contextPath}/images1/download (1).png"
                        class="img-fluid d-block mx-auto logo_0 nine_logo my-auto ms-3" alt="logo_0"
                        style="width:105px; flex:0 0 auto;">
                </div>
                <input type="hidden" value="${kpId}" name="kpId">
                <input type="hidden" value="${language}" name="language">
                <input type="hidden" value="${productId}" name="productId">
                <input type="hidden" value="${cpId}" name="cpId">
                <input type="hidden" value="${cpId}" name="cpId">
                <input type="hidden" value="${pubId}" name="pubId">
                <input type="hidden" value="${transactionId}" name="transactionId">
                <div class="container-fluid mt-5 mb-auto" style="position: relative; z-index:9;">
                    <!-- <div class="container-fluid"> -->

                    <div class="row justify-content-between">
                        <div class="col-md-5 col-7 order-md-0 order-1 my-auto">
                            <img src="${pageContext.request.contextPath}/images1/10666.png" class="img-fluid  d-block"
                                alt="spin_0">
                        </div>
                        <div class="col-md-4 my-auto">
                            <img src="${pageContext.request.contextPath}/images1/logo.png"
                                class="img-fluid d-block mx-auto logo_0" alt="logo_0">

                            <img src="${pageContext.request.contextPath}/images1/quote.png"
                                class="img-fluid d-block mx-auto txt_0 " alt="text">
                            <!-- <input type="number" class="form-control tel_0 d-block mx-auto" name="phone" placeholder="Enter Your Cell Phone Number"> -->

                            <button type="submit" class="btn d-block mx-auto btn_0">Subscribe</button>
                            <p class=" phra_0  d-block mx-auto my-2">${msg1}</p>
                            <p class="text-white text-center m-0 p-0">${msg2}</p>
                        </div>
                        <div class="col-md-3 col-5 mt-auto order-2">
                            <img src="${pageContext.request.contextPath}/images1/8357600.png"
                                class="img-fluid d-block girl_0" alt="girl_0">

                        </div>
                    </div>
                    <!-- <footer class="row justify-content-center"> -->
                    <!-- <div class="col-md-5 col-6 d-md-block d-none order-md-0 order-1 my-auto">
  </div> -->
                    <!-- <div class="col-md-4"> -->
                    <p class="phra_0 email_para text-end d-block mx-auto mt-2"><b style="font-size: 18px;">Support
                            email:</b> Nextgen@altruistindia.com</p>

                    <!-- </div> -->
                    <!-- <div class="col-md-3 col-6 d-md-block d-none mt-auto order-2">
</div> -->
                    <!-- </footer> -->


                    <!-- <span class="phra_0">
                    <p class="text-center">Quiz2Play service for Zain Iraq is an exciting trivia quiz game. Service
                        price (240 IQD) and user will receive a daily message . To Unsubscribe send 0 to 4540 </p>
                </span> -->
                    <!-- <div class="wdt_8 d-flex justify-content-center mt-5">
                    <a class="d-block" href="#" data-bs-toggle="modal" data-bs-target="#exampleModal"><img src="images/0101.gif" class="img-fluid d-block"></a>
                    <a class="d-block mx-4" href="#" data-bs-toggle="modal" data-bs-target="#exampleModal_1"><img src="images/020202.gif" class="img-fluid d-block"></a>
                    <a class="d-block" href="#" data-bs-toggle="modal" data-bs-target="#exampleModal_2"><img src="images/0303.gif" class="img-fluid d-block"></a>
                </div> -->
                    <!-- </div> -->


                </div>
                <div id="overlay_div"></div>
                <!-- </div> -->
            </section>

        </form>




        <!-- Button trigger modal -->
        <!-- <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
    Launch demo modal
  </button> -->











        <!--x-banner-section-x-->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>

    </html>