import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import com.example.AppleSearchResult;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main2 {
	public static void main(String[] args) throws UnsupportedEncodingException, MalformedURLException {
		String apiURL = "https://itunes.apple.com/search?term=";
		String requestURL = apiURL + URLEncoder.encode("아이유", "UTF-8");
		URL url = new URL(requestURL);
		
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			int responseCode = conn.getResponseCode();
			//응답코드가 정상일때(HTTP_OK:200)만 진행하고, 그 이외일때는 에러난거니깐 진행 ㄴㄴ
			if (responseCode == HttpURLConnection.HTTP_OK) {
				String respBody = readBody(conn.getInputStream());
				// 보낸 요청에 대한 응답이 body에 담겨있으므로 응답 body 살펴보기
				System.out.println(respBody);
				//이걸로 jsonschema2pojo 돌려서 AppleSearchResult객체 생성하기
				
				ObjectMapper mapper = new ObjectMapper();
				AppleSearchResult apple = mapper.readValue(respBody, AppleSearchResult.class);
				System.out.println(apple.getResultCount());
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
