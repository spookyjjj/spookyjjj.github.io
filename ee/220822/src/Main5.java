import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main5 {
	public static void main(String[] args) {
		String apiURL = "http://httpbin.org/get";
		//OkHttp로 api사용해보기~
		//=============get방식
		OkHttpClient client = new OkHttpClient();
		Request req = new Request.Builder().url(apiURL).build();
		//Request는 Builder()로 설정시작. append로 붙여가면서 설정. 끝나면 build()로 마무리
		
		try (Response resp = client.newCall(req).execute()) {
		//Response는 OkHttpClient에서 콜 객체를 생성해서 실행한 후 받아옴
			if (resp.code() == 200) {
				System.out.println(resp.body().string());
				//이렇게 바로 읽어낼 수 있다~ 너무 편하다~
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
