package line;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.stream.Collectors;

public class LineNotifyMain {
    public void exe(String cityName, String maxTemp, String minTemp, String desc, String yourToken, String nickname) {
        String thisToken = yourToken;
        String msg = "\n\n" + nickname + "様\n\nただいまの" + cityName + "の天気は" + desc + "、\n最高気温は" + maxTemp + "°、最低気温は" + minTemp + "°です。今日も良い1日を!(^^)";

        HttpURLConnection connection = null;
        try {
            URL url = new URL("https://notify-api.line.me/api/notify");
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.addRequestProperty("Authorization", "Bearer " + thisToken);
            try (OutputStream os = connection.getOutputStream();
                 PrintWriter writer = new PrintWriter(os)) {
                writer.append("message=").append(URLEncoder.encode(msg, "UTF-8")).flush();
                try (InputStream is = connection.getInputStream();
                     BufferedReader r = new BufferedReader(new InputStreamReader(is))) {
                    String res = r.lines().collect(Collectors.joining());
                    if (!res.contains("\"message\":\"ok\"")) {
                        System.out.println(res);
                        System.out.println("Failure..");
                    }
                }
            }
        } catch (Exception ignore) {
        } finally {
            if (connection != null) {
                connection.disconnect();
            }

        //lineNotify.notify("\n今日の天気はテストです"); // ここにDBから値をとってきてトークン
        //lineNotify.notify("Hope you got this message"); // 天気を追加
        // リストを作ってそこにデータベースの中身を格納
        // for文でまわす
        // 送信テストです。<>エリアの今日の天気は<>、最高気温は<>度、最低気温は<>度です。今日も良い1日を！

        }





    }
}