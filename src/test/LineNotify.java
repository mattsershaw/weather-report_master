package test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Objects;
import java.util.stream.Collectors;

public class LineNotify {
	public static void main(String[] args) {
        String thisToken = "3c6I3hlbHFmE9xB99BZmHRTH1XQqO6lopzAJ0Lb2ZSE";
        LineNotify lineNotify = new LineNotify(thisToken);
        lineNotify.notify("\n今日の天気はテストです"); // ここにDBから値をとってきてトークン
        lineNotify.notify("Hope you got this message"); // 天気を追加
        // リストを作ってそこにデータベースの中身を格納
        // for文でまわす
        // 送信テストです。<>エリアの今日の天気は<>、最高気温は<>度、最低気温は<>度です。今日も良い1日を！

    }

    private final String token;

    public LineNotify(String token) {
        this.token = token;
    }



	public void notify(String message) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL("https://notify-api.line.me/api/notify");
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.addRequestProperty("Authorization", "Bearer " + token);
            try (OutputStream os = connection.getOutputStream();
                 PrintWriter writer = new PrintWriter(os)) {
                writer.append("message=").append(URLEncoder.encode(message, "UTF-8")).flush();
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
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineNotify that = (LineNotify) o;
        return Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }

    @Override
    public String toString() {
        return "LineNotify{" +
                "token='" + token + '\'' +
                '}';
    }
}