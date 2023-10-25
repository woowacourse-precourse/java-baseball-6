package baseball.util;

import java.util.HashSet;
import java.util.Set;

public class ValidationCheck {
    // 유효성 검사 : 재시작/종료 확인
    public boolean validateUserCommand(String cmdStr){
        int cmdInt = validateNumber(cmdStr);
        return cmdInt == 1 || cmdInt == 2;
    }

    // 유효성 검사 : 숫자 자리수 확인
    public boolean validateUserNumber(String cmdStr){
        int cmdInt = validateNumber(cmdStr);
        int digit = Integer.toString(cmdInt).length();
        if(digit == 3){
            return validateDuplicate(cmdStr); // 중복 체크
        }
        return false;
    }

    // 유효성 검사 : 숫자 확인
    private int validateNumber(String cmdStr){
        try {
            return Integer.parseInt(cmdStr);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    // 유효성 검사 : 중복 숫자 검사
    private boolean validateDuplicate(String cmdStr){
        Set<Character> uniqueChars = new HashSet<>();
        for(char c : cmdStr.toCharArray()){
            if(!uniqueChars.add(c)){
                return false;
            }
        }
        return true;
    }
}
