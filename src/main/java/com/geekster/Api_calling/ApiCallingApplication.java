package com.geekster.Api_calling;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiCallingApplication {

	public static void main(String[] args) throws Exception {
		URL getUrl=new URL("https://api.chucknorris.io/jokes/random");
		HttpURLConnection connection=(HttpURLConnection) getUrl.openConnection();
		connection.setRequestMethod("GET");
		int responseCode = connection.getResponseCode();
		if(responseCode==200){
			BufferedReader in=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder jsonResponseData=new StringBuilder();
			String readLine=null;
			while((readLine=in.readLine())!=null){
				jsonResponseData.append(readLine);
			}
			in.close();
			System.out.println(jsonResponseData.toString());
		}else{
			System.out.println("This is not valid URL"+" "+responseCode);
		}

	}
}
