package com.leapfrog.sjn.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Grabber {
    public String grab(String link) throws IOException{
        URL url = new URL(link);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line="";
        StringBuilder content = new StringBuilder();
        while((line=reader.readLine())!=null){
            content.append(line).append("\n".trim());
        }
        reader.close();
        return content.toString();
    }
}
