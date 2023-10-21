package util;

import java.util.HashSet;
import java.util.Set;

public class Validate {
    // 사용자입력값 유효성검사
    public static void validate_InputDataCheck(String input) {
    	Set<Character> set = new HashSet<>();
    	for(int i=0;i<input.length();i++) {
    		set.add(input.charAt(i));
    	}
        if (input.length() != 3 || !input.matches("\\d{3}")) {
            throw new IllegalArgumentException("세자리 숫자만 입력해주세요!");
        }else if(set.size() != input.length()) {
        	throw new IllegalArgumentException("중복된 숫자를 입력했습니다!");
        }
    }

    // 게임시작유무 유효성검사 (1과2 이외의 값을 입력했을떄)
    public static void isGameStartValid(int input) {
        if (input != 1 && input != 2) {
            throw new IllegalArgumentException("1과 2만 입력해주세요!");
        }
    }
}
