import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main2 {
	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		//객체->json문자열
		Person hong = new Person("홍길동", 22);
		String json = mapper.writeValueAsString(hong); 
		//ObjectMapper의 .writeValueAsString()안에 객체를 넣으면, 
		//!!!알아서!!! 그 객체의 기본생성자와 getter setter를 이용해 json형태로 출력한다~
		System.out.println(json); //-> {"name":"홍길동","age":22}
		
		//json문자열->객체
		String jsonString = "{\"name\":\"둘리\",\"age\":23}";
//		String jsonString = "{\"name\":\"둘리\",\"age\":23,\"gender\":\"female\"}";
		//없는 필드값 json으로 주어지면 -> Unrecognized field "gender" (class test.Person)에러
		Person dooli = mapper.readValue(jsonString, Person.class);
		//마찬가지로 json형태의 문자열도 ObjectMapper의 .readValue()에 어떤객체인지와 함께 넘겨주면
		//!!!알아서!!! 그 객체 형태로 바꿔주기 때문에 해당 객체에 정의된 메소드들도 사용가능 (getter setter등등)
		System.out.println(dooli.getName()); //-> 둘리
		System.out.println(dooli.getAge()); //-> 23
		
		//json문자열->객체 과정에서 json의 key를 필드로 가지는 객체(class)쉽게 만드는 방법이 있다!
		//pojo사이트~ json서식으로 넣으면 class로 반환 : https://www.jsonschema2pojo.org/
	}
}
