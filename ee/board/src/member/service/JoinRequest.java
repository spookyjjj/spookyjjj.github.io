package member.service;

import java.util.Date;
import java.util.Map;

public class JoinRequest {
	//요청데이터를 보관하는 필드
	private String id;
	private String name;
	private String password;
	private String confirmPassword;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	//password와 confirmPassword값이 같은지 확인 -> 유효성검사
	public boolean isPasswordEqualToConfirm() {
		return password != null && password.contentEquals(confirmPassword);
	}
	//유효성 검사 ->  에러 정보 담긴 맵 체크
	public void validate(Map<String, Boolean> errors) {
		//id필드값이 올바르지 않으면 errors맵에 <"id", true>로 추가해 두는 과정 by checkEmpty메소드
		checkEmpty(errors, id, "id");
		checkEmpty(errors, name, "name");
		checkEmpty(errors, password, "password");
		checkEmpty(errors, confirmPassword, "confirmPassword");
		if (!errors.containsKey("confirmPassword")) {
			if (!isPasswordEqualToConfirm()) {
				errors.put("notMatch", Boolean.TRUE); //암호와 확인값의 불일치 -> notMatch 에러키 추가
			}
		}
		
	}
	//value값(필드값)이 없는 경우, errors맵에 <"fieldName", true>로 집어넣음
	private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		if (value == null || value.isEmpty()) {
			errors.put(fieldName, Boolean.TRUE);
		}
	}
}
