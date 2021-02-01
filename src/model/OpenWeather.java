package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import line.LineNotifyMain;

public class OpenWeather {
    public void main(Account account) throws Exception {

    String requestUrl = "https://api.openweathermap.org/data/2.5/weather?APPID=******&units=metric&lang=ja&q=" + account.getLocation() + ",jp"; // weather 現在の天気 forecast 天気予報

    URL url = new URL(requestUrl);
    	HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		int responseCode = connection.getResponseCode();

	if(responseCode == HttpURLConnection.HTTP_OK){
		InputStreamReader isr = new InputStreamReader(connection.getInputStream());
		BufferedReader br = new BufferedReader(isr);

		JsonNode jsonResult = null;
		ObjectMapper mapper = new ObjectMapper();
		jsonResult = mapper.readTree(br);

		JsonNode jsonResultMain = null;

		jsonResultMain = jsonResult.get("main");

		String cityName;
		String maxTemp;
		String minTemp;
		String desc = "";

		cityName = jsonResult.get("name").asText();
		maxTemp = String.valueOf((double)Math.round(jsonResultMain.get("temp_max").asDouble() *10)/10);
		minTemp = String.valueOf((double)Math.round(jsonResultMain.get("temp_min").asDouble() *10)/10);

		for (JsonNode n : jsonResult.get("weather")) {
		    desc += n.get("description").asText();
		    desc += "、";
		}

		desc = Optional.ofNullable(desc)
			      .filter(s -> s.length() != 0)
			      .map(s -> s.substring(0, s.length() - 1))
			      .orElse(desc);

		LineNotifyMain lnm = new LineNotifyMain();
		lnm.exe(cityName, maxTemp, minTemp, desc, account.getLineToken(), account.getNickname());

		} else {
			System.out.println("OpenWeatherデータの取得失敗");
		}
    }
}
