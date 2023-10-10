package com.hemlata.app.Controller;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class ApiCalls {

	//API Call to get leagues of the different games
	public String word(String word) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://wordsapiv1.p.rapidapi.com/words/" + word))
				.header("x-rapidapi-key", "4e96ca0c82msh7acc5424070fda1p1c7d82jsn9ec25a33485e")
				.header("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		return response.body();
	}

	public String synd(String word) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://wordsapiv1.p.rapidapi.com/words/" + word + "/synonyms"))
				.header("X-RapidAPI-Key", "f2957c448emshc90b7fc67841ee4p1e6fcajsn20785e389420")
				.header("X-RapidAPI-Host", "wordsapiv1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		return response.body();
	}

	public String ants(String word) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://wordsapiv1.p.rapidapi.com/words/" + word + "/antonyms"))
				.header("X-RapidAPI-Key", "f2957c448emshc90b7fc67841ee4p1e6fcajsn20785e389420")
				.header("X-RapidAPI-Host", "wordsapiv1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		return response.body();
	}

	public String defs(String word) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://wordsapiv1.p.rapidapi.com/words/" + word + "/definitions"))
				.header("x-rapidapi-key", "f2957c448emshc90b7fc67841ee4p1e6fcajsn20785e389420")
				.header("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		return response.body();
	}

	public String egs(String word) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://wordsapiv1.p.rapidapi.com/words/" + word + "/examples"))
				.header("x-rapidapi-key", "f2957c448emshc90b7fc67841ee4p1e6fcajsn20785e389420")
				.header("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		return response.body();
	}

	public String rhs(String word) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://wordsapiv1.p.rapidapi.com/words/" + word + "/rhymes"))
				.header("x-rapidapi-key", "f2957c448emshc90b7fc67841ee4p1e6fcajsn20785e389420")
				.header("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		return response.body();
	}

}