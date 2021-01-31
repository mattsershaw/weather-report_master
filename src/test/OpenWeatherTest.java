package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OpenWeatherTest {
	public static void main(String[] args) throws Exception {
// OpenWeatherMapは-273.15で表示
    String requestUrl1 = "https://api.openweathermap.org/data/2.5/weather?APPID=89a7312fb00ef0d82db8a982f317573e&units=metric&lang=ja&q=chiba,jp"; // weather 現在の天気 forecast 天気予報
    String requestUrl = "https://api.openweathermap.org/data/2.5/onecall?lat=35.726870&lon=139.926987&exclude=current,minutely,hourly&units=metric&lang=ja&appid=89a7312fb00ef0d82db8a982f317573e";

	URL url = new URL(requestUrl);
    	HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		int responseCode = connection.getResponseCode();

	if(responseCode == HttpURLConnection.HTTP_OK){
		InputStreamReader isr = new InputStreamReader(connection.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		//System.out.println(br.readLine()); //Json形式でデータが取得できるのでJackson等で処理する

		JsonNode jsonResult = null; // 初期化
		ObjectMapper mapper = new ObjectMapper();
		jsonResult = mapper.readTree(br);

		JsonNode jsonResultMain = null;

		System.out.println(jsonResult);

//		System.out.println("登録された場所は" + jsonResult.get("name") + "です。");

		jsonResultMain = jsonResult.get("main");
		System.out.println((double)Math.round((jsonResultMain.get("temp_max").asDouble() -273.15) *10)/10);
		System.out.println((double)Math.round((jsonResultMain.get("temp_min").asDouble() -273.15) *10)/10);

		for (JsonNode n : jsonResult.get("weather")) {
			String a = n.get("main").asText();
		    String b = n.get("description").asText();
		    System.out.println(a + ":" + b);
		}
	}
	}
}
