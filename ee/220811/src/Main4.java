import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main4 {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("\\w+");
		//.compile("") 안에는 자바표현만 들어가야한다
		//\w : [A-z0-9]
		//\d : [0-9]
		//+ : 1이거나 이상
		//? : 0이거나 1
		//* : 0이거나 이상

		String line = "(abc, 123) | (de, 6) | (qwer, 15)";
		Pattern p2 = Pattern.compile("\\(([a-zA-Z]+), ([0-9]+)\\)");
		//Pattern p2 = Pattern.compile("\\((\\w+, \\d+)\\)");
		//괄호도 \(라고 표현해줘야 일반 문자로의 (임을 인식
		//괄호()로 묶으면 그룹으로 인식되서 group()메소드 사용가능 <-문자가 아닌 명령으로서의 (
		//단, (a, b)로 묶었는지, ((a),(b))로 묶었는지에 따라서
		//전자는 group(1)만 되고 후자는 group(1),(2)로 나뉘어짐
		Matcher m = p2.matcher(line);
		
		while (m.find()) {
			System.out.println(m.group(1));
			System.out.println(m.group(2));
		}
	}
}
