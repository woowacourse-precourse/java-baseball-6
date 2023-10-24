package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Exceptions {

    public void isInvalidNumberRestart(String input){ // 재시작 숫자 1,2 이외입력시 예외처리
        if(input.equals("1") || input.equals("2")){
            return;
        }throw new IllegalArgumentException("유효하지않은 재시작 입력값입니다.");
    }

    public void isInvalidNumberDuplication(String input){ // 중복된 숫자 예외처리
        int first = Integer.parseInt(input.substring(0,1));
        int second = Integer.parseInt(input.substring(1,2));
        int third = Integer.parseInt(input.substring(input.length()-1));

        if(first != second && first != third && second != third){
            return;
        }throw new IllegalArgumentException("각 자리수의 숫자는 중복될 수 없습니다.");
    }

    public void isInvalidNumberLength(String input){ // 숫자 길이는 3자리수만 가능
        if(input.length() == 3) {
            return;
        }throw new IllegalArgumentException("숫자는 3자리수만 입력 가능합니다.");

    }

    public void isInvalidZero(String input){ // 0 입력시 오류처리
        int first = Integer.parseInt(input.substring(0,1));
        int second = Integer.parseInt(input.substring(1,2));
        int third = Integer.parseInt(input.substring(input.length()-1));

        if(first != 0 && second != 0 && third !=0){
            return;
        }throw new IllegalArgumentException("각 자릿수는 1~9만 입력 가능합니다.");
    }

}
