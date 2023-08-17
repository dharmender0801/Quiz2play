<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ page isELIgnored="false" %>
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
                <style>
                    .quizmsg {
                        margin-top: 200px;
                        width: 800px;
                        height: 50px;
                        display: flex;
                        flex-direction: column;
                        justify-content: center;
                        align-items: center;
                        background-color: rgba(171, 171, 171, 0.591);
                        border-radius: 10px;
                        margin-left: -420px;
                        margin-right: 100px;

                    }

                    .quizmsg h2 {
                        font-size: 15px;
                        display: flex;
                        flex-direction: column;
                        justify-content: center;
                        align-items: center;
                        position: relative;
                        margin-top: 2px;

                    }

                    .success-container,
                    .wrong-container {
                        display: flex;
                        flex-direction: column;
                        align-items: center;
                        justify-content: center;
                    }

                    .sucess {
                        color: rgb(6, 72, 0);

                    }

                    .wrong {
                        color: rgb(255, 0, 0);
                    }

                    .nonedisp {
                        display: none;
                    }

                    .showdisp {
                        display: inline;
                    }


                    @media (max-width:900px) {
                        .quizmsg {
                            position: relative;
                            left: 50px;
                        }
                    }
                </style>
            </head>

            <body class="p-0">
                <!--banner-section-->
                <form class="form-submit pb-4 pt-2" action="/upload" method="post">
                    <section class="position-relative bg_0 py_5">
                        <!-- <img src="images/bckground_004.png" class="img-fluid bckground_000 d-block w-100"> -->
                        <div class="banner">
                            <div class="container-fluid">
                                <div class="row justify-content-between">
                                    <div class="col-md-5">
                                        <img src="${pageContext.request.contextPath}/images/quizwheel.png"
                                            class="img-fluid  d-block" alt="spin_0">
                                    </div>
                                    <input type="hidden" value="${kpId}" name="kpId">
                                    <input type="hidden" value="${cpId}" name="cpId">
                                    <input type="hidden" value="${language}" name="language">
                                    <input type="hidden" value="${packageId}" name="packageId">
                                    <div class="col-md-4 my-auto">
                                        <img src="${pageContext.request.contextPath}/images/logo.png"
                                            class="img-fluid d-block mx-auto logo_0" alt="logo_0">
                                        <img src="${pageContext.request.contextPath}/images/quote.png"
                                            class="img-fluid d-block mx-auto txt_0 " alt="text">
                                        <!-- <input type="number" class="form-control tel_0 d-block mx-auto" name="phone"
                                        placeholder="Enter Your Cell Phone Number"> -->
                                        <select class="form-select tel_0 d-block mx-auto"
                                            aria-label="Default select example" name="opid">
                                            <option selected>Choose Operator</option>
                                            <c:forEach var="listValue" items="${list}">
                                                <option value="${listValue.operatorid}"
                                                    onchange="clickselect(listValue.operatorid)">
                                                    ${listValue.country}</option>
                                            </c:forEach>
                                        </select>
                                        <button type="submit" class="btn d-block mx-auto btn_0 mt-4">Subscribe</button>

                                        <!-- <p class=" phra_0  d-block mx-auto  py-2"></p> -->
                                    </div>
                                    <div class="col-md-3 mt-5">
                                        <img src="${pageContext.request.contextPath}/images/girl_1.png"
                                            class="img-fluid d-block girl_0" alt="girl_0">

                                    </div>
                                </div>


                                <div class="wdt_8 d-flex justify-content-center mt-5">
                                    <a class="d-block" href="#" data-bs-toggle="modal" onclick="fetchdata(1)"
                                        data-bs-target="#exampleModal"><img
                                            src="${pageContext.request.contextPath}/images/0101.gif"
                                            class="img-fluid d-block"></a>
                                    <a class="d-block mx-4" href="#" data-bs-toggle="modal" onclick="fetchdata(2)"
                                        data-bs-target="#exampleModal_1"><img
                                            src="${pageContext.request.contextPath}/images/020202.gif"
                                            class="img-fluid d-block"></a>
                                    <a class="d-block" href="#" data-bs-toggle="modal" onclick="fetchdata(3)"
                                        data-bs-target="#exampleModal_2"><img
                                            src="${pageContext.request.contextPath}/images/0303.gif"
                                            class="img-fluid d-block"></a>
                                </div><br>
                                <span class="phra_0">
                                    <p class="text-center">This service is available to Saudi Telecom Company customers
                                        for 2 riyals for prepaid customers, renewed daily ,
                                        and for 69 riyals for post-paid customers, renewed monthly (including 15%
                                        value-added tax). To cancel the subscription, please send U 103 to 801848
                                        The Tax amount was collected to prepaid customers upon charging
                                    </p><br>
                                    <p class="text-center">This service is available for Mobily customers for 11.5 SAR
                                        renewed weekly (including VAT).
                                        To cancel your subscription, please send U 193 to 600609
                                        The Tax amount was collected to prepaid customers upon charging
                                    </p><br>
                                    <p class="text-center">This service is available for Zain customers for 8.65 SAR
                                        renewed weekly (including VAT).
                                        To cancel your subscription, please send U 193 to 708283
                                        The Tax amount was collected to prepaid customers upon charging
                                    </p>

                                </span>
                            </div>


                        </div>
                    </section>
                </form>





                <!-- Button trigger modal -->
                <!-- <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
    Launch demo modal
  </button> -->

                <!-- Modal -->
                <div id="hide">
                    <div class="modal modal_1 fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                        aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <div class="d-flex align-items-center w-100">
                                        <a class="d-block w-100"><img class="img-fluid d-block w-100"
                                                src="${pageContext.request.contextPath}/images/popup-img1.png"></a>
                                        <a class="d-block w-100 mx-4"><img class="img-fluid d-block w-100"
                                                src="${pageContext.request.contextPath}/images/logo.png"></a>
                                        <a class="d-block w-100"><img class="img-fluid d-block w-100"
                                                src="${pageContext.request.contextPath}/images/popup-img2.png"></a>
                                        <div class="quizmsg" id="quiz">
                                            <div class="success-container">
                                                <h2 class="sucess" id="success">GOOD GOING </h2>
                                                <h2 class="sucess" id="success1">YOU GOT THE ANSWER RIGHT !!</h2>
                                            </div>
                                            <div class="wrong-container">
                                                <h2 class="wrong" id="wrong">OOPS !! WRONG ANSWER</h2>
                                                <h2 class="wrong" id="wrong1">BUT NEVER MIND KEEP GOING !!</h2>
                                            </div>
                                        </div>
                                    </div>
                                    <button type="button" class="btn-close align-self-start m-0 p-0 ms-4"
                                        data-bs-dismiss="modal" aria-label="Close">
                                        <img class="img-fluid d-block"
                                            src="${pageContext.request.contextPath}/images/close.png">
                                    </button>
                                </div>
                                <div class="modal-body" id="qu">
                                    <div class="row">
                                        <div class="col-6 d-flex flex-column">
                                            <h4 class="m-0 text-white text-capitalize text-center" id="qn">1</h4>
                                            <div class="mdl_bx d-flex flex-column h-100 p-3 mt-2">
                                                <h5 class="text-center">World 1/3</h5>
                                                <div class="d-flex flex-column h-100">
                                                    <span class="d-block w-100 text-center my-auto"
                                                        id="question"></span>
                                                    <!-- In which country, Yellowstone
                                            National Park is located? -->
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-6">
                                            <div class="d-flex justify-content-center align-items-center">
                                                <p class="text-capitalize">Select your Answer</p>
                                                <span class="d-block spn_count ms-3" id="time">0.00</span>
                                            </div>
                                            <ul class="nav_8 mt-2">
                                                <li><a href="#!" class="d-block" onclick="checkans(1)" id="ans1"></a>
                                                </li>
                                                <li class="my-2"><a href="#" class="d-block" id="ans2"
                                                        onclick="checkans(2)"></a>
                                                </li>
                                                <li><a href="#" class="d-block" id="ans3" onclick="checkans(3)"></a>
                                                </li>
                                                <li class="mt-2"><a href="#" class="d-block" id="ans4"
                                                        onclick="checkans(4)"></a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer justify-content-center">
                                    <button type="button" class="btn btn-success" data-bs-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-warning">Save changes</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>



                <div class="modal modal_1 fade" id="exampleModal_1" tabindex="-1" aria-labelledby="exampleModalLabel"
                    aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <div class="d-flex align-items-center w-100">
                                    <a class="d-block w-100"><img class="img-fluid d-block w-100"
                                            src="${pageContext.request.contextPath}/images/popup-img1.png"></a>
                                    <a class="d-block w-100 mx-4"><img class="img-fluid d-block w-100"
                                            src="${pageContext.request.contextPath}/images/logo.png"></a>
                                    <a class="d-block w-100"><img class="img-fluid d-block w-100"
                                            src="${pageContext.request.contextPath}/images/popup-img2.png"></a>
                                    <div class="quizmsg" id="quiz1">
                                        <div class="success-container">
                                            <h2 class="sucess" id="success111">GOOD GOING </h2>
                                            <h2 class="sucess" id="success11">YOU GOT THE ANSWER RIGHT !!</h2>
                                        </div>
                                        <div class="wrong-container">
                                            <h2 class="wrong" id="wrong111">OOPS !! WRONG ANSWER</h2>
                                            <h2 class="wrong" id="wrong11">BUT NEVER MIND KEEP GOING !!</h2>
                                        </div>
                                    </div>
                                </div>
                                <button type="button" class="btn-close align-self-start m-0 p-0 ms-4"
                                    data-bs-dismiss="modal" aria-label="Close">
                                    <img class="img-fluid d-block"
                                        src="${pageContext.request.contextPath}/images/close.png">
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-6 d-flex flex-column">
                                        <h4 class="m-0 text-white text-capitalize text-center" id="qn1">Level 9</h4>
                                        <div class="mdl_bx d-flex flex-column h-100 p-3 mt-2">
                                            <h5 class="text-center">Cricket | 2/3</h5>
                                            <div class="d-flex flex-column h-100">
                                                <span class="d-block w-100 text-center my-auto" id="question1"></span>
                                                <!-- In which country, Yellowstone
                                            National Park is located? -->
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="d-flex justify-content-center align-items-center">
                                            <p class="text-capitalize">Select your Answer</p>
                                            <span class="d-block spn_count ms-3" id="time">0.00</span>
                                        </div>
                                        <ul class="nav_8 mt-2">
                                            <li><a href="#!" class="d-block" onclick="checkans(1)" id="ans11"></a></li>
                                            <li class="my-2"><a href="#" class="d-block" id="ans21"
                                                    onclick="checkans(2)"></a>
                                            </li>
                                            <li><a href="#" class="d-block" id="ans31" onclick="checkans(3)"></a></li>
                                            <li class="mt-2"><a href="#" class="d-block" id="ans41"
                                                    onclick="checkans(4)"></a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer justify-content-center">
                                <button type="button" class="btn btn-success" data-bs-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-warning">Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>




                <div class="modal modal_1 fade" id="exampleModal_2" tabindex="-1" aria-labelledby="exampleModalLabel"
                    aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <div class="d-flex align-items-center w-100">
                                    <a class="d-block w-100"><img class="img-fluid d-block w-100"
                                            src="${pageContext.request.contextPath}/images/popup-img1.png"></a>
                                    <a class="d-block w-100 mx-4"><img class="img-fluid d-block w-100"
                                            src="${pageContext.request.contextPath}/images/logo.png"></a>
                                    <a class="d-block w-100"><img class="img-fluid d-block w-100"
                                            src="${pageContext.request.contextPath}/images/popup-img2.png"></a>
                                    <div class="quizmsg" id="quiz2">
                                        <div class="success-container">
                                            <h2 class="sucess" id="success2">GOOD GOING </h2>
                                            <h2 class="sucess" id="success12">YOU GOT THE ANSWER RIGHT !!</h2>
                                        </div>
                                        <div class="wrong-container">
                                            <h2 class="wrong" id="wrong2">OOPS !! WRONG ANSWER</h2>
                                            <h2 class="wrong" id="wrong12">BUT NEVER MIND KEEP GOING !!</h2>
                                        </div>
                                    </div>
                                </div>
                                <button type="button" class="btn-close align-self-start m-0 p-0 ms-4"
                                    data-bs-dismiss="modal" aria-label="Close">
                                    <img class="img-fluid d-block"
                                        src="${pageContext.request.contextPath}/images/close.png">
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-6 d-flex flex-column">
                                        <h4 class="m-0 text-white text-capitalize text-center" id="qn2">Level 9</h4>
                                        <div class="mdl_bx d-flex flex-column h-100 p-3 mt-2">
                                            <h5 class="text-center">Universe | 3/3</h5>
                                            <div class="d-flex flex-column h-100">
                                                <span class="d-block w-100 text-center my-auto" id="question2"></span>
                                                <!-- In which country, Yellowstone
                                            National Park is located? -->
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="d-flex justify-content-center align-items-center">
                                            <p class="text-capitalize">Select your Answer</p>
                                            <span class="d-block spn_count ms-3" id="time">0.00</span>
                                        </div>
                                        <ul class="nav_8 mt-2">
                                            <li><a href="#!" class="d-block" onclick="checkans(1)" id="ans12"></a></li>
                                            <li class="my-2"><a href="#" class="d-block" id="ans22"
                                                    onclick="checkans(2)"></a>
                                            </li>
                                            <li><a href="#" class="d-block" id="ans32" onclick="checkans(3)"></a></li>
                                            <li class="mt-2"><a href="#" class="d-block" id="ans42"
                                                    onclick="checkans(4)"></a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer justify-content-center">
                                <button type="button" class="btn btn-success" data-bs-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-warning">Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!--x-banner-section-x-->
                <!-- jQuery first, then Popper.js, then Bootstrap JS -->



                <script type="text/javascript">
                    var out;
                    function fetchdata(val) {
                        document.getElementById("quiz").style.display = "none";
                        document.getElementById("quiz1").style.display = "none";
                        document.getElementById("quiz2").style.display = "none";
                        if (val == 1) {
                            fetch("http://lp.quiz2play.com/get?id=1&category=1")
                                // fetch("http://lp.quiz2play.com/get?id=1")
                                .then((data) => {
                                    return data.json();
                                })
                                .then((objectData) => {
                                    out = objectData;
                                    document.getElementById("question").innerHTML = out.question;
                                    document.getElementById("ans1").innerHTML = out.ans1;
                                    document.getElementById("ans2").innerHTML = out.ans2;
                                    document.getElementById("ans3").innerHTML = out.ans3;
                                    document.getElementById("ans4").innerHTML = out.ans4;
                                    document.getElementById("qn").innerHTML = out.id;

                                })
                        } else if (val == 2) {
                            fetch("http://lp.quiz2play.com/get?id=6&category=2")
                                // fetch("http://lp.quiz2play.com/get?id=1")
                                .then((data) => {
                                    return data.json();
                                })
                                .then((objectData) => {
                                    out = objectData;
                                    document.getElementById("question1").innerHTML = out.question;
                                    document.getElementById("ans11").innerHTML = out.ans1;
                                    document.getElementById("ans21").innerHTML = out.ans2;
                                    document.getElementById("ans31").innerHTML = out.ans3;
                                    document.getElementById("ans41").innerHTML = out.ans4;
                                    document.getElementById("qn1").innerHTML = out.id;

                                })
                        } else {
                            fetch("http://lp.quiz2play.com/get?id=11&category=3")
                                // fetch("http://lp.quiz2play.com/get?id=1")
                                .then((data) => {
                                    return data.json();
                                })
                                .then((objectData) => {
                                    out = objectData;
                                    document.getElementById("question2").innerHTML = out.question;
                                    document.getElementById("ans12").innerHTML = out.ans1;
                                    document.getElementById("ans22").innerHTML = out.ans2;
                                    document.getElementById("ans32").innerHTML = out.ans3;
                                    document.getElementById("ans42").innerHTML = out.ans4;
                                    document.getElementById("qn2").innerHTML = out.id;

                                })
                        }
                    }





                    function checkans(ansr) {

                        let getans = 'out.ans' + ansr;
                        let checkres = eval(getans) === out.rightans;
                        console.log(checkres);
                        if (checkres) {
                            savelogs(out.id, 1)
                            console.log("This is Right");
                            document.getElementById("quiz").style.display = "inline";
                            document.getElementById("quiz1").style.display = "inline";
                            document.getElementById("quiz2").style.display = "inline";
                            document.getElementById("wrong").style.display = "none";
                            document.getElementById("wrong1").style.display = "none";
                            document.getElementById("success").style.display = "inline";
                            document.getElementById("success1").style.display = "inline";
                            document.getElementById("wrong111").style.display = "none";
                            document.getElementById("wrong11").style.display = "none";
                            document.getElementById("success111").style.display = "inline";
                            document.getElementById("success11").style.display = "inline";
                            document.getElementById("wrong2").style.display = "none";
                            document.getElementById("wrong12").style.display = "none";
                            document.getElementById("success2").style.display = "inline";
                            document.getElementById("success12").style.display = "inline";
                        }
                        else {
                            savelogs(out.id, 2)
                            console.log("This is Wrong Answer !")
                            document.getElementById("quiz").style.display = "inline";
                            document.getElementById("quiz1").style.display = "inline";
                            document.getElementById("quiz2").style.display = "inline";
                            document.getElementById("wrong").style.display = "inline";
                            document.getElementById("wrong1").style.display = "inline";
                            document.getElementById("success").style.display = "none";
                            document.getElementById("success1").style.display = "none";
                            document.getElementById("wrong111").style.display = "inline";
                            document.getElementById("wrong11").style.display = "inline";
                            document.getElementById("success111").style.display = "none";
                            document.getElementById("success11").style.display = "none";
                            document.getElementById("wrong2").style.display = "inline";
                            document.getElementById("wrong12").style.display = "inline";
                            document.getElementById("success2").style.display = "none";
                            document.getElementById("success12").style.display = "none";

                        }
                        console.log(out.id);
                        if (out.id > 5 && out.id < 10) {
                            fetch("http://lp.quiz2play.com/get?id=" + (out.id + 1) + "&category=2")
                                // fetch("http://lp.quiz2play.com/get?id=" + (out.id + 1))
                                .then((data) => {
                                    return data.json();
                                })
                                .then((objectData) => {
                                    out = objectData;
                                    sleepFor(3000);
                                    document.getElementById("quiz1").style.display = "none";
                                    document.getElementById("question1").innerHTML = out.question;
                                    document.getElementById("ans11").innerHTML = out.ans1;
                                    document.getElementById("ans21").innerHTML = out.ans2;
                                    document.getElementById("ans31").innerHTML = out.ans3;
                                    document.getElementById("ans41").innerHTML = out.ans4;
                                    document.getElementById("qn1").innerHTML = out.id;


                                })

                        } else if (out.id > 10) {
                            console.log("This Condition  is true");
                            fetch("http://lp.quiz2play.com/get?id=" + (out.id + 1) + "&category=3")
                                // fetch("http://lp.quiz2play.com/get?id=" + (out.id + 1))
                                .then((data) => {
                                    return data.json();
                                })
                                .then((objectData) => {
                                    out = objectData;
                                    sleepFor(3000);
                                    document.getElementById("quiz2").style.display = "none";
                                    document.getElementById("question2").innerHTML = out.question;
                                    document.getElementById("ans12").innerHTML = out.ans1;
                                    document.getElementById("ans22").innerHTML = out.ans2;
                                    document.getElementById("ans32").innerHTML = out.ans3;
                                    document.getElementById("ans42").innerHTML = out.ans4;
                                    document.getElementById("qn2").innerHTML = out.id;
                                })

                        }
                        else if (out.id < 5) {

                            fetch("http://lp.quiz2play.com/get?id=" + (out.id + 1) + "&category=1")
                                // fetch("http://lp.quiz2play.com/get?id=" + (out.id + 1))
                                .then((data) => {
                                    return data.json();
                                })
                                .then((objectData) => {
                                    out = objectData;
                                    sleepFor(3000);
                                    document.getElementById("quiz").style.display = "none";
                                    document.getElementById("question").innerHTML = out.question;
                                    document.getElementById("ans1").innerHTML = out.ans1;
                                    document.getElementById("ans2").innerHTML = out.ans2;
                                    document.getElementById("ans3").innerHTML = out.ans3;
                                    document.getElementById("ans4").innerHTML = out.ans4;
                                    document.getElementById("qn").innerHTML = out.id;


                                })
                        }
                        else {
                            console.log("This is the last question ");
                        }





                    }

                    function sleepFor(sleepDuration) {
                        var now = new Date().getTime();
                        while (new Date().getTime() < now + sleepDuration) {
                            /* Do nothing */
                        }
                    }


                    function savelogs(id, status) {
                        // fetch("http://lp.quiz2play.com/playedquestion?id=" + id + "&status=" + status + "&kpid=${kpId}")
                        fetch("http://lp.quiz2play.com/playedquestion?id=" + id + "&status=" + status + "&kpid=${kpId}")
                            .then((data) => {

                                return data;
                            })

                    }
                </script>
                <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
                    integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
                    crossorigin="anonymous"></script>
                <script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
                <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
            </body>

            </html>