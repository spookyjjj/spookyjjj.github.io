import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main5 {
	public static void main(String[] args) {
		String apiURL = "http://httpbin.org/get";
		
		OkHttpClient client = new OkHttpClient();
		Request req = new Request.Builder().url(apiURL).build();
		
		try (Response resp = client.newCall(req).execute()) {
			if (resp.code() == 200) {
				System.out.println(resp.body().string());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
