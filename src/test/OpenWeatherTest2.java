package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OpenWeatherTest2 {
    public static void main(String[] ahgs) throws Exception {
// OpenWeatherMapは-273.15で表示
//    	ExcuteServlet es = new ExcuteServlet();

    String requestUrl = "https://api.openweathermap.org/data/2.5/weather?APPID=89a7312fb00ef0d82db8a982f317573e&units=metric&lang=ja&q=Chiba,jp"; // weather 現在の天気 forecast 天気予報

    URL url = new URL(requestUrl);
    	HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		int responseCode = connection.getResponseCode();

	if(responseCode == HttpURLConnection.HTTP_OK){
		InputStreamReader isr = new InputStreamReader(connection.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		// System.out.println(br.readLine()); //Json形式でデータが取得できるのでJackson等で処理する

		JsonNode jsonResult = null; // 初期化
		ObjectMapper mapper = new ObjectMapper();
		jsonResult = mapper.readTree(br);

		JsonNode jsonResultMain = null;
		JsonNode jsonResultWeather = null;
//		ObjectMapper mapper = new ObjectMapper();


//		System.out.println(jsonResult);
//		System.out.println("登録された場所は" + jsonResult.get("name") + "です。"); !!!!!!!!!!!!!
		// System.out.println(jsonResult.get("main")); // 取り方が分からない

		jsonResultMain = jsonResult.get("main");
		jsonResultWeather = jsonResult.get("weather");

		String maxTemp;
		String minTemp;
		String desc = "";

//		String a = jsonResult.get("weather").get("description").asText();
		maxTemp = "最高気温" + (double)Math.round(jsonResultMain.get("temp_max").asDouble() *10)/10;
		minTemp = "最低気温" + (double)Math.round(jsonResultMain.get("temp_min").asDouble() *10)/10;

//		System.out.println(jsonResultWeather.get(2));

//		ArrayNode arrayNode = (ArrayNode) jsonResult.get("weather");
//		System.out.println(arrayNode);
//		String aaaString = arrayNode.get("description").asText();
//		System.out.println(aaaString);

		for (JsonNode n : jsonResult.get("weather")) {
		    desc += n.get("description").asText();
		    desc += "、";
		}

		desc = Optional.ofNullable(desc)
			      .filter(s -> s.length() != 0)
			      .map(s -> s.substring(0, s.length() - 1))
			      .orElse(desc);


//		desc = "晴れ"; // 一時的に

		System.out.println(maxTemp);
		System.out.println(minTemp);
		System.out.println(desc);

//		jsonResultMain = jsonResult.get("");
//		System.out.println((jsonResultWeather[0].get("temp_min")));
//		System.out.println(jsonResultWeather.get("description"));
//		String nameString = br.get("name").asText();
//		System.out.println(nameString);

		// ここで取ったデータをjavabeansに入れて、それをlineの文章に入れれば可能
		// 戻り値をjavabeans?



//		var arrays= jsonResult.get("weather");
//		List<String> lists = StreamSupport.stream(arrays.spliterator(), false)
//		    .map(
//		      e -> {
//		        return e.asText(); // Stringに変換
//		    })
//		    .collect(Collectors.toList());
//		System.out.println(lists);


	} else {
		System.out.println("取得失敗");
	}

//	ObjectMapper mapper = new ObjectMapper();
//
//	try {
//		JsonNode node = mapper.readTree(br));
//
//		String name = node.get("name").asText();
//		int number = node.get("number").asInt();
//		String department = node.get("department").asText();
//
//		System.out.println(name);
//		System.out.println(number);
//		System.out.println(department);
//
//	} catch (JsonProcessingException e) {
//		e.printStackTrace();
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
    }
}
