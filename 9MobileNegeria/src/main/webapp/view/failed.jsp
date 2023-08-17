<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
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
    <!--image_section-->
    <section class="image_1 position-relative py_5">
        <img src="${pageContext.request.contextPath}/images/bckground_000.png" class="img-fluid bckground_000 d-block w-100">
        <!--content_section-->
        <section class="content_1 text-center position-absolute">
            <div class="container-fluid">
                <img src="${pageContext.request.contextPath}/images/logo.png" class="img-fluid d-block logo mx-auto">
                <div class="row d_flex justify-content-between mt-4">
                    <div class="col-4 my-auto col_1 mx-auto mt_5">
                        <img src="${pageContext.request.contextPath}/images/quizwheel.png" class="img-fluid d-block">
                    </div>
                    <div class="col-md-6 my-auto p_a col_2">
                        <!-- <img src="images/logo.png" class="img-fluid d-block mx-auto"> -->
                        <p>You are not subscribed to the service. To Subscribe send 1 to 4540</p>
                        <a href="#" class="img-fluid d-inline-block ancr mt-4"><i class="far fa-times-circle d-block"></i></a>
                    </div>
                    <!-- <div class="col-12 mt-5 text-center">
                        <p>Quiz2Play service for Zain Iraq is an exciting trivia quiz game. Service price (240 IQD) and user will receive a daily message . To Unsubscribe send 0 to 4540</p>
                    </div> -->
                </div>
            </div>
        </section>
        <p class="p_pos position-absolute text-center mt_4">Quiz2Play service for Zain Iraq is an exciting trivia quiz game. Service price (240 IQD) and user will receive a daily message . To Unsubscribe send 0 to 4540</p>
        <!--x-content_section-x-->
    </section>
    <!--x-image_section-x-->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>

</html>