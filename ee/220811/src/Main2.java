import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {
	public static void main(String[] args) {
		String line = "43124 He233ll5o. 39 Wor347ld! 5";
//		Pattern p = Pattern.compile("[0-9]");
		//대괄호 안에는 범위를 설정 할 수 있다!!
//		Pattern p = Pattern.compile("[0-9]{2}");
		//중괄호 안에는 덩어리 표현이 들어간다 -> 해상 숫자 크기만큼
		Pattern p = Pattern.compile("[0-9]{2,3}");
		//중괄호에는 덩어리 범위도 정하기 가능 -> 최소길이 최대길이
		Matcher m = p.matcher(line);
		
		m.find();
		System.out.println(m.start());
		System.out.println(m.end());
		m.find();
		System.out.println(m.start());
		System.out.println(m.end());
		m.find();
		System.out.println(m.start());
		System.out.println(m.end());
		m.find();
		System.out.println(m.start());
		System.out.println(m.end());
		
	}
}
