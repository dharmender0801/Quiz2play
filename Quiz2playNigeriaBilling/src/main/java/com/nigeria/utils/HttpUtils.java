package com.nigeria.utils;

import java.io.IOException;
import java.util.Base64;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtils {
	public static String sendRequest(String url) throws IOException {
		String username = "altruistte_616_live";
		String password = "xundefinky";
		String credentials = username + ":" + password;
		String base64Credentials = Base64.getEncoder().encodeToString(credentials.getBytes());
		System.out.println(base64Credentials);
		OkHttpClient client = new OkHttpClient().newBuilder().build();
		MediaType mediaType = MediaType.parse("application/json");
//		@SuppressWarnings("deprecation")
		RequestBody pinGenbody = RequestBody.create(mediaType, "");
		Request pinGenRequest = new Request.Builder().url(url).method("POST", pinGenbody)
				.addHeader("Content-Type", "application/json").addHeader("Authorization", "Basic " + base64Credentials)
				.build();

		Response pinVerifyresponse = client.newCall(pinGenRequest).execute();
		String responseData = pinVerifyresponse.body().string();
		return responseData;
	}

	public static String sendGETRequest(String url) throws IOException {
		OkHttpClient client = new OkHttpClient().newBuilder().build();
		Request pinGenRequest = new Request.Builder().url(url).method("GET", null)
				.addHeader("Content-Type", "application/json").build();
		Response pinVerifyresponse = client.newCall(pinGenRequest).execute();
		String responseData = pinVerifyresponse.body().string();
		return responseData;
	}

	public static String sendRequestPost(String url) throws IOException {
		OkHttpClient client = new OkHttpClient().newBuilder().build();
		MediaType mediaType = MediaType.parse("application/json");
//		@SuppressWarnings("deprecation")
		RequestBody pinGenbody = RequestBody.create(mediaType, "");
		Request pinGenRequest = new Request.Builder().url(url).method("POST", pinGenbody)
				.addHeader("Content-Type", "application/json").build();

		Response pinVerifyresponse = client.newCall(pinGenRequest).execute();
		String responseData = pinVerifyresponse.body().string();
		return responseData;
	}

}
