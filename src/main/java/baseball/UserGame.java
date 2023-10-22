package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class UserGame {
    public void start(){ // 게임 시작할 때
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public int inputUserNum(){ // User의 숫자 입력
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine(); // 제공된 입력문이 String으로 받아야하는 조건이 있다.
        if(!isExceptionEx(input)){ // 입력문 예외처리
            throw new IllegalArgumentException(); // 예외 던지기
        }
        return Integer.parseInt(input); // ????? 아직 잘 모름
    }
    public boolean isExceptionEx(String input){ // 예외처리
        if(!isNumber(input) || !isInputNumCount(input)){ // 숫자가 아닐때 또는 3자리가 아닐때
            return false; // 거짓 반환
        }
        return true; // 참 반환
    }
    public boolean isNumber(String input){// 숫자만 사용
        String pattern = "^[0-9]*$"; // 숫자 정규식 사용
        return Pattern.matches(pattern, input); // matches 정규표현식을 인자로 받고 동일한 패턴문자열이면 true
    }
    public boolean isInputNumCount(String input) { // 자리수가 틀릴 경우
        if (input.length() != 3) { // input의 길이가 3개가 같지않을때
            return false;
        }
        return true;
    }
}
