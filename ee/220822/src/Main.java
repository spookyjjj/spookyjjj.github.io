import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Main {
	public static void main(String[] args) throws JsonProcessingException {
		// 사람
		// 이름 = 홍길동
		// 나이 = 22
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.createObjectNode();
		
		//노드에 값넣기 : put/set 모두 가능
		node.put("name", "홍길동");
		node.put("age", 22);
		node.put("boolean", true);
		
		ObjectNode node2 = mapper.createObjectNode();
		node2.put("이름", "둘리");
		node2.put("나이", 23);
		
// 		node.put("bf", node2);
		node.set("bf", node2);
		//객체 자체도 node안에 넣을 수 있다~!
		//원래는 put으로 넣었는데 diprecated떠서(업뎃되면 사라질 기능이라고 알려주는거) set으로 넣어줬음
		
		String json = mapper.writeValueAsString(node);
		System.out.println(json);
		//결과 : {"name":"홍길동","age":22,"boolean":true,"bf":{"이름":"둘리","나이":23}}
	}
}
