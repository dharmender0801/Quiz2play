<%@ page import="java.util.*" %>
    <%@ page language="java" import="org.json.JSONObject" %>
    <%@ page language="java" import="java.net.URLEncoder" %>
    <%@ page language="java" import="java.io.*,java.io.DataOutputStream,java.io.BufferedReader" %>
    <%@ page import="java.io.*,java.util.*,java.net.HttpURLConnection,java.net.URL" %>
    <%
    String ServiceKey = "**************";// Your service id
    String TransactionID;

    if (request.getParameter("clickId") == null) {
        long tmp = new java.util.Date().getTime();
        TransactionID = Long.toString(tmp);
    } else {
        TransactionID = request.getParameter("clickId");
    }

    String APIURL = "https://sg.apiserver.shield.monitoringservice.co/"+ServiceKey+"/"+TransactionID+"/JS";
    String ApiSnippetUrl = "https://uk.api.shield.monitoringservice.co/";

    JSONObject headersObj = new JSONObject();
    Enumeration headers = request.getHeaderNames();
    while (headers.hasMoreElements()) {
        String name = (String) headers.nextElement();
        String value = request.getHeader(name);
        int i = 0;
        headersObj.put(name, value);
    }
    String url = request.getRequestURL().toString();
    String queries = request.getQueryString();
    if(queries != null) {
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
        result += _response.toString();
    }
    if (result != "") {
      JSONObject json = null;
      json = new JSONObject(result);
      in.close();
      String uniqid = json.getString("uniqid");
      source = json.getString("source");
      String loadTime = con.getHeaderField("X-Loaded");
    } else {
        //Failover//
        String uniqueId = TransactionID + "-" + request.getRemoteAddr() + "-" + System.nanoTime();
        //Generate MD//
        String plainText = uniqueId;
        MessageDigest mdAlgorithm = MessageDigest.getInstance("MD5");
        mdAlgorithm.update(plainText.getBytes());
        byte[] digest = mdAlgorithm.digest();
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
            plainText = Integer.toHexString(0xFF & digest[i]);
            if (plainText.length() < 2) {
                plainText = "0" + plainText;
            }
            hexString.append(plainText);
        }
        String uniqid = hexString.toString();
        failoverSource.append("(function(s, o, u, r, k){");
        failoverSource.append("b = s.URL;");
        failoverSource.append("v = (b.substr(b.indexOf(r)).replace(r + "=", "")).toString();");
        failoverSource.append("r = (v.indexOf("&") !== -1) ? v.split("&")[0] : v;");
        failoverSource.append("a = s.createElement(o),");
        failoverSource.append("m = s.getElementsByTagName(o)[0];");
        failoverSource.append("a.async = 1;");
        failoverSource.append("a.setAttribute("crossorigin", "anonymous");");
        failoverSource.append("a.src = u+'script.js?ak='+k+'&lpi='+r+'&lpu='+encodeURIComponent(b)+'&key=" + uniqid + "';");
        failoverSource.append("m.parentNode.insertBefore(a, m);");
        failoverSource.append("})(document, 'script', '" + ApiSnippetUrl + "', 'clickId', '" + ServiceKey + "');");
        source = failoverSource.toString();
    }
    out.flush();

    //uniqid will be used to call Block API with param named uniqid at the endpoint /block
%>
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="referrer" content="unsafe-url">
 
<title>MCP Shield Server Side Kit Loading | Demo</title>
<script type="text/javascript">
        //<![CDATA[
            <%=source%>
	//]]>
</script>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	
	 <button class="btn btn-gradient">
                    <a  href="http://www.social-sms.com/iq/HE/v1.2/oneclick/sub.php?serviceId={}&spId={}&shortcode={}&uniqid=<%=uniqid%>">
					
                        Subscribe
                    </a>
                </button>
</body>
</html>