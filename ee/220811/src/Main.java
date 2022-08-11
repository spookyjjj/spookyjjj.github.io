import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		String line = "This is a book.";
		Pattern p = Pattern.compile("is");
		Matcher m = p.matcher(line);
		
		System.out.println(m.lookingAt()); //시작 일치할 때 true
		
		boolean find = m.find();
		if(find) {
			System.out.println(m.start());
			System.out.println(m.end());
		}
		
		find = m.find();
		if(find) {
			System.out.println(m.start());
			System.out.println(m.end());
		}
		
		find = m.find();
		if(!find) {
			System.out.println("없음");
		}
	}
}
