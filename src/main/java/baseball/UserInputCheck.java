package baseball;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 사용자 입력 유효성 확인 및 Exception 처리
 */
public class UserInputCheck {
    String errorMessage=""; // 에러 메시지
    
    /**
     * 숫자 입력 유효성 확인
     */
    public boolean validNumbers(String input){
        if (!checkString(input)){
            throw new IllegalArgumentException(errorMessage);
        } else if (!checkLength(input) || !checkRange(input) || !checkDuplicate(input)){
            throw new IllegalArgumentException(errorMessage);
        }
        return true;
    }

    /**
     * 게임 재시작 or 종료 입력 유효성 확인
     */
    public boolean validRestart(String input){
        if (!checkString(input)){
            throw new IllegalArgumentException(errorMessage);
        } else if (!checkEndOption(input)) {
            throw new IllegalArgumentException(errorMessage);
        }
        return true;
    }

    // 문자 입력 확인
    public boolean checkString(String input){
        for (int i=0; i<input.length(); i++){
            if (!Character.isDigit(input.charAt(i))){
                errorMessage = Constant.NOT_NUMBER_ERROR_MESSAGE;
                return false;
            }
        }
        return true;
    }

    // 숫자 길이 확인
    public boolean checkLength(String input){
        if (input.length()!= Constant.GENERATE_NUM_SIZE){
            errorMessage = String.format(Constant.NOT_LENGTH_ERROR_MESSAGE, Constant.GENERATE_NUM_SIZE);
            return false;
        }
        return true;
    }

    // 숫자 범위 확인
    public boolean checkRange(String input){
        for (int i=0; i<input.length(); i++){
            int number = Integer.parseInt(String.valueOf(input.charAt(i)));
            if (number<Constant.GENERATE_MIN_VALUE || number>Constant.GENERATE_MAX_VALUE){
                errorMessage = String.format(Constant.OUT_OF_RANGE_ERROR_MESSAGE,
                        Constant.GENERATE_MIN_VALUE, Constant.GENERATE_MAX_VALUE);
                return false;
            }
        }
        return true;
    }

    // 숫자 중복 확인
    public boolean checkDuplicate(String input){
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(input.split("")));
        if (hashSet.size()!= Constant.GENERATE_NUM_SIZE){
            errorMessage = Constant.DUPLICATE_NUMBER_ERROR_MESSAGE;
            return false;
        }
        return true;
    }

    // 유효한 재시작 or 종료 옵션 확인
    public boolean checkEndOption(String input){
        int option = Integer.parseInt(input);
        if (option!=Constant.RESTART_OPTION && option!=Constant.END_OPTION){
            errorMessage = Constant.NOT_OPTION_NUMBER_ERROR_MESSAGE;
            return false;
        }
        return true;
    }
}
