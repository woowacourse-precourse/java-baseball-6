package baseball.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class ValidationCheckUtils {

    //사용자 입력값 체크 작업 - 숫자만 입력 받았는지 여부 확인
    public boolean validateNumericFormat(String inputNumbers){
        try{
            Integer.parseInt(inputNumbers);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    //사용자 입력값 체크 작업 - 3자리 여부 확인
    public boolean validateUserNumber(String inputNumbers){
        if (inputNumbers.length() > 3){
            return false;
        }
        return true;
    }

    //사용자 입력값 체크 작업 - 1~9 범위 확인
    public boolean validateValidValue(String inputNumbers){

        for(char c :inputNumbers.toCharArray()){
            int num = (int)c - '0';
            if (num == 0){
                return false;
            }
        }
        return true;
    }


    // 사용자 입력값 체크 작업 - 중복
    public boolean validateDuplicate(String inputNumbers){
        Set<Character> checkSet = new HashSet<>();

        for(char c :inputNumbers.toCharArray()){
            if (checkSet.contains(c)){
                return false;
            }
            checkSet.add(c);
        }
        return true;
    }

    public int validateReplayCheck(String st){
        if (st.equals("1")){
            return 1;
        }
        return 2;
    }

}
