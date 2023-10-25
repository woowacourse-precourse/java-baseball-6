package baseball.controller;

import java.util.regex.Pattern;

import static baseball.utility.Constants.VALID_NUMBER_PATTERN;

public class InputException { //인스턴스 생성을 막아 메모리를 효율적으로 사용하고, 전역적으로 사용하기 위해 static 메소드 사용
    private InputException(){} //생성자 생성 못하도록 private 접근지정자 사용

    public static void judgeValidNumberInput(String input){
        if(!judgeVaildNumber(input)){
            throw new IllegalArgumentException();
        }
    }

    private static boolean judgeVaildNumber(String input){ //정규표현식을 사용하여 3자리의 적합한 숫자로 이루어진 문자열인지 확인한다.
        boolean isValidNumber = Pattern.matches(VALID_NUMBER_PATTERN,input);
        return isValidNumber;
    }
}
