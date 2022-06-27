package com.company;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        URL url =new URL("http://dummy.restapiexample.com/create");
        Scanner scanner= new Scanner(System.in);
        String user=scanner.next();
        String jsonFile = String.format("{\"name\": \"%s\", \"salary\":\"123\", \"age\":\"23\" }", user);
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(url.toString()))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonFile))
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
