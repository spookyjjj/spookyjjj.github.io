import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main7 {
	private static String getSaraminInfo(String url) throws IOException {
		Document doc = Jsoup.connect(url).timeout(5000).get();
		String info = doc.select("meta[name=description]").first().attr("content");
		//select의 메소드의 반환이 elements로 복수개이기때문에 first()같은걸 써줘야함 찾은게 1개일지라도!
		return info;
	}
	
	public static void main(String[] args) throws IOException {
		String searchURL = "https://www.saramin.co.kr/zf_user/search?searchType=search&searchword=java&company_cd=0%2C1%2C2%2C3%2C4%2C5%2C6%2C7%2C9%2C10&panel_type=&search_optional_item=y&search_done=y&panel_count=y&preview=y";
		String startString = "/zf_user/jobs/relay/view";

		Document doc = Jsoup.connect(searchURL).timeout(5000).get();
		// Documnet는 f12누르면 나오는 소스 html문서를 말함. timeout은 기본 30초라서 5초로 줄임
		Elements links = doc.select("a[href]");
		// 찾을 애를 elements

		Set<String> set = new HashSet<>();
		for (Element e : links) {
			String attr = e.attr("href");
			if (attr.startsWith(startString)) {
				set.add("http://www.saramin.co.kr" + attr);
			}
		}
		System.out.println(set);
		
//		for (String url : set) {
//			System.out.println(getSaraminInfo(url));
//		}
		//애는 하나하나 순차적으로
		set.parallelStream().map(url -> {
			try {
				return getSaraminInfo(url);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return null;
		}).forEach(System.out::println);
		//얘는 한 방에 보내기 -> 훨씬 빨라짐
	}

}
