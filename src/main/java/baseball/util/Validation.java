package baseball.util;

import java.util.HashSet;
import java.util.Set;

import static baseball.util.ConstMessages.ERROR_MESSAGE;

public class Validation {
    public static void validateInput(String numberStr){
        if(!verifyInputNumbers(numberStr)){
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }


//    사용자가 컴퓨터의 수를 맞추기 위해 입력한 값에 대한 검증
    private static boolean verifyInputNumbers(String numberStr){
        return isThreeDigits(numberStr) && isNumbers(numberStr) && isDuplicate(numberStr);
    }

    //    사용자가 입력한 값이 3자리 수인지 검증
    private static boolean isThreeDigits(String numberStr){
        return numberStr.length() == 3;
    }

    //    입력한 값이 숫자인지 검증
    private static boolean isNumbers(String numberStr){
        return numberStr.matches("^[1-9]+$");
    }

    //    중복된 값이 있는지 검증
    private static boolean isDuplicate(String numberStr){
        int length = numberStr.length();
        Set<Character> characterSet = new HashSet<>();

        for(int i = 0; i<numberStr.length(); i++){
            characterSet.add(numberStr.charAt(i));
        }
        return characterSet.size() == length;
    }

//  게임 재시작에 대한 입력값 검증
    public static void verifyRestartInput(int number){
        if((number != 1) && (number !=2)){
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }



}
