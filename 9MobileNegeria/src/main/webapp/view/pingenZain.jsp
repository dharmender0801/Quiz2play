<%@ page import="java.util.*, java.io.*, java.net.*, org.json.JSONObject, java.security.MessageDigest" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    String ServiceKey = "IF6bi4kBRtN47XQgdXDn";
    String TransactionID;
    if (request.getParameter("clickId") == null) {
        long tmp = new java.util.Date().getTime();
        TransactionID = Long.toString(tmp);
    } else {
        TransactionID = request.getParameter("clickId");
    }

    String APIURL = "https://sg.apiserver.shield.monitoringservice.co/" + ServiceKey + "/" + TransactionID + "/JS";
    String ApiSnippetUrl = "https://uk.api.shield.monitoringservice.co/";

    JSONObject headersObj = new JSONObject();
    Enumeration<String> headers = request.getHeaderNames();
    while (headers.hasMoreElements()) {
        String name = headers.nextElement();
        String value = request.getHeader(name);
        headersObj.put(name, value);
    }

    String url = request.getRequestURL().toString();
    String queries = request.getQueryString();
    if (queries != null) {
        url = url + "?" + queries;
    }

    StringBuilder urlBuilder = new StringBuilder();
    urlBuilder.append("?lpu=" + URLEncoder.encode(url, "UTF-8") + "&timeStamp=" + System.nanoTime() + "&user_ip=" + request.getRemoteAddr() + "&head=" + URLEncoder.encode(headersObj.toString()));

    URL obj = new URL(APIURL + urlBuilder.toString());
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.setRequestMethod("GET");

    //add request header
    con.setRequestProperty("User-Agent", request.getHeader("User-Agent"));
    int responseCode = con.getResponseCode();

    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

    String result = "";
    String _response = "";
    while ((_response = in.readLine()) != null) {
        result += _response;
    }
    in.close();

    String uniqid = "";
    String source = "";

    if (result != null && !result.isEmpty()) {
        JSONObject json = new JSONObject(result);
        uniqid = json.getString("uniqid");
        source = json.getString("source");
        String loadTime = con.getHeaderField("X-Loaded");
    } else {
        // Failover
        String uniqueId = TransactionID + "-" + request.getRemoteAddr() + "-" + System.nanoTime();
        // Generate MD5
        String plainText = uniqueId;
        MessageDigest mdAlgorithm = MessageDigest.getInstance("MD5");
        mdAlgorithm.update(plainText.getBytes());
        byte[] digest = mdAlgorithm.digest();
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            plainText = Integer.toHexString(0xFF & digest[i]);
            if (plainText.length() < 2) {
                plainText = "0" + plainText;
            }
            hexString.append(plainText);
        }
        uniqid = hexString.toString();

        // Failover source code
        StringBuilder failoverSource = new StringBuilder();
        failoverSource.append("(function(s, o, u, r, k){");
        failoverSource.append("b = s.URL;");
        failoverSource.append("v = (b.substr(b.indexOf(r)).replace(r + \"=\", \"\")).toString();");
        failoverSource.append("r = (v.indexOf(\"&\") !== -1) ? v.split(\"&\")[0] : v;");
        failoverSource.append("a = s.createElement(o),");
        failoverSource.append("m = s.getElementsByTagName(o)[0];");
        failoverSource.append("a.async = 1;");
        failoverSource.append("a.setAttribute(\"crossorigin\", \"anonymous\");");
        failoverSource.append("a.src = u + 'script.js?ak=' + k + '&lpi=' + r + '&lpu=' + encodeURIComponent(b) + '&key=" + uniqid + "';");
        failoverSource.append("m.parentNode.insertBefore(a, m);");
        failoverSource.append("})(document, 'script', '" + ApiSnippetUrl + "', 'clickId', '" + ServiceKey + "');");
        source = failoverSource.toString();
    }
%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="referrer" content="unsafe-url">
<script type="text/javascript">
    //<![CDATA[
    <%= source %>
//]]>
</script>
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
</head>

<body>
    <!--banner-section-->
    <form class="form-submit pb-4 pt-2" action="/api/he/<%= uniqid %>/" id="myForm"  method="post">
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
                        <input type="text" hidden value="${kpId}" name="kpId"> 
                        <!-- <input
                            type="hidden" value="${response}" name="response"> -->

                        <div class="col-md-4 my-auto">
                            <img src="${pageContext.request.contextPath}/images/logo.png"
                                class="img-fluid d-block mx-auto logo_0" alt="logo_0"> 
                                <!-- <img
                                src="${pageContext.request.contextPath}/images/quote_ar.png"
                                class="img-fluid d-block mx-auto txt_0 " alt="text"> -->

                            <!-- <div class="d-flex">
                                <span class="d-block"
                                    style="background: #e7d4d4; padding: 15px 13px; border-radius: 10px 0 0 10px;">+964</span><input
                                    oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"
                                    accept="^\d{10}$" type="text" maxlength="10"
                                    class="form-control tel_0 d-block mx-auto" name="msisdn"
                                    placeholder="الرجاء ادخال رقم الهاتف "
                                    style="width: 100%; margin: 0; border-radius: 0 10px 10px 0;">
                            </div> -->

                            <p class="text-center" style="color: red; font-size: 27px;"><placeholder></p>
                            <button type="submit" class="btn d-block mx-auto btn_0 mt-4">
                                <!-- <a href="http://www.social-sms.com/iq/HE/v1.2/oneclick/sub.php?serviceId={}&spId={}&shortcode={}&uniqid=<%=uniqid%>">  </a>
                                 -->
                                 اشترك
                                
                              


                            </button>
                            <p class="text-center phra_0 mt-4" style="direction: rtl">اهلا
                                بك بخدمة quiz2play، لإلغاء الاشتراك أرسل 0 مجانا الى رقم الخدمة
                                4540. علما ان سعر الرسالة المستلمة للصفحة الواحدة هو 240 دينار
                                عراقي</p>

                        </div>
                        <div class="col-md-3 mt-5">
                            <img src="${pageContext.request.contextPath}/images/girl_1.png"
                                class="img-fluid d-block girl_0" alt="girl_0">

                        </div>
                    </div>

                    <!--  <span class="phra_0"> 
                        <p class="text-center" style="direction:rtl">اهلا بك بخدمة quiz2play، لإلغاء الاشتراك أرسل 0 مجانا الى رقم الخدمة 4540. علما ان سعر الرسالة المستلمة للصفحة الواحدة هو 240 دينار عراقي </p>
                    </span>  -->
                </div>


            </div>
        </section>
    </form>
    <script>
        // Handle form submission and redirection
        document.getElementById("myForm").addEventListener("submit", function (event) {
          event.preventDefault(); 
          const formData = new FormData(event.target);
          fetch(event.target.action, {
            method: 'POST',
            body: formData
            
          })
          .then(response => response.json()) 
          .then(data => {
            const redirectUrl = "http://www.social-sms.com/iq/HE/v1.2/oneclick/sub.php?serviceId=${serviceId}&spId=${spId}&shortcode=${shortcode}&uniqid=<%=uniqid%>";
            window.location.href = redirectUrl;
          })
          .catch(error => {
            console.error('Error:', error);
          });
        });
      </script>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>

</html>
