package com.Study_6.lab6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class myOperOnURL {
    public boolean read(String URL) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .GET() // GET is default
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        }catch( Exception e){
            System.out.print("I catch exeption for you, no need to say thank you ");
            e.printStackTrace();
        }
        return false;
    }
    public void readLab(String URLadd) {
        BufferedReader reader;
        String s = "";
            try {
                reader = new BufferedReader(new InputStreamReader((new URL(URLadd)).openStream() ));
                s=reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println( "\n" + s );

    }
}
