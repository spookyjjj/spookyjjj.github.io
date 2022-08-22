import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main4 {
	public static void main(String[] args) throws MalformedURLException {
		String apiURL = "http://httpbin.org/post";
		URL url = new URL(apiURL);
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			//body에 담아 보내는게 이거다! 라고 헤더에 설정
			conn.setRequestProperty("Accept", "application/json");
			//요청에 대한 응답도 이걸로 해줬으면 좋겠다고 헤더에 설정
			conn.setDoOutput(true); //body에 무언가 출력하고자 할 때 ture값을 주면 됨
			
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(new Person("홍길동", 22));
			
			byte[] body = json.getBytes();
			
			conn.getOutputStream().write(body, 0, body.length);
			
			if (conn.getResponseCode() == 200) {
				System.out.println(readBody(conn.getInputStream()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}
	
	private static String readBody(InputStream inputStream) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		StringBuilder sb = new StringBuilder();

		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}
}
