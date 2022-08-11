import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main3 {
	public static void main(String[] args) {
		String line1 = "lowercase";
		String line2 = "UPPERCASE";
		String line3 = "1q2w3e";
		
		//[a-z] [A-Z]를 구분함
		//Pattern p = Pattern.compile("[a-z]{9}");
		//Matcher m = p.matcher(line1);
		//System.out.println(m.matches()); //소문자가 딱 아홉자여야 ture
		//Pattern p = Pattern.compile("[A-Z]{9}");
		//Matcher m = p.matcher(line2);
		//System.out.println(m.matches()); //대문자가 딱 아홉자여야 ture
		
		//두개의 범위도 표현 가능
		//Pattern p = Pattern.compile("[0-9a-z]{6}");
		//Matcher m = p.matcher(line3);
		//System.out.println(m.matches());
		
		//아이디는 영소문자와 숫자로 이루어져야하고 최소 6자, 최대 10자임(영문자로 시작해야 합니다.)
		boolean b = false; 
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("아이디를 입력하세요");
			String id = scan.nextLine();
			Pattern p = Pattern.compile("[a-z][0-9a-z]{5,9}");
			Matcher m = p.matcher(id);
			if (m.matches()) {
				System.out.println("올바른 입력입니다");
				System.out.println(id);
				b = false;
			} else {
				System.out.println("올바르지 않은 입력값입니다");
				b = true;
			}
		} while (b);
		
		//올바른 전화번호 (010-####-####)
		do {
			System.out.println("전화번호를 입력하세요");
			String phone = scan.nextLine();
			Pattern p = Pattern.compile("010-[0-9]{4}-[0-9]{4}");
			Matcher m = p.matcher(phone);
			if (m.matches()) {
				System.out.println("올바른 입력입니다");
				System.out.println(phone);
				b = false;
			} else {
				System.out.println("올바르지 않은 입력값입니다");
				b = true;
			}
		} while (b);
	}
}
