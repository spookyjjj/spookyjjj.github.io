import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Main {
	public static void main(String[] args) throws JsonProcessingException {
		//jackson에서는 ObjectMapper로 모든걸 시작!
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
		//{"name":"홍길동","age":22,"boolean":true,"bf":{"이름":"둘리","나이":23}}
		//어디서는 key값이 'name'이고 어디서는 '이름'이면 데이터활용이 어려움 -> 일정한규칙대로 만들기(객체로 )
	}
}
