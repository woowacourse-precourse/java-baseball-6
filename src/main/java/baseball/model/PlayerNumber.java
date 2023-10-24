package baseball.model;

import java.util.HashSet;
import java.util.Set;

public class PlayerNumber {
    private String playerNum;

    // 예외 처리 생성자
    public PlayerNumber(String playerNum){

        isAllDifferent(playerNum);
        isDigitNumber(playerNum);
        isStringLengthCorrect(playerNum);

        this.playerNum = playerNum;
    }

    // getPlayerNum() 함수 호출 시 playerNum 반환
    public String getPlayerNum(){
        return playerNum;
    }

    // #1. 중복 숫자 예외처리
    public static void isAllDifferent(String value) throws IllegalArgumentException {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < value.length(); i++) {
            set.add(value.charAt(i));
        }
        if (set.size() != value.length()) {
            throw new IllegalArgumentException("중복된 숫자를 입력하셨습니다.");
        }
    }

    // #2. 자연수 값 입력
    public static void isDigitNumber(String value) {
        for(int i = 0; i < value.length(); i++){
            isDigitNumberCharInString(value, i);
        }
    }

    // #2-1. 자연수 판별 및 예외처리
    public static void isDigitNumberCharInString(String value, int index) throws IllegalArgumentException{
        if(!Character.isDigit(value.charAt(index))){
            throw new IllegalArgumentException("자연수 조건에 맞지 않습니다.");
        }
    }

    // #3. 3자리 숫자 예외처리
    public static void isStringLengthCorrect(String value) throws IllegalArgumentException{
        if(value.length() != 3) {
            throw new IllegalArgumentException("3자리 수를 입력해주세요.");
        }
    }
}
