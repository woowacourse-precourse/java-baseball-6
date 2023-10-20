package baseball.validator;

import java.util.List;

public class InputValidator {


    // 입력이 특정 길이 인지 검사
    private boolean isEqualLengthLimit(String input, int limit){
        return input.length()==limit;
    }

    // 입력이 숫자가 아닌 값이 포함되는지 검사
    private boolean isContainOnlyDigit(String input){

        char[] array = input.toCharArray();
        for (char c : array) {
            if(!Character.isDigit(c))
                return false;
            if(c=='0')
                return false;

        }
        return true;
    }


    //입력 값이 특정 길이 값이 아니거나 숫자로만 이루어지지 않은 경우 검사
    public void validateInput(String input, int limit) {
        if (!isEqualLengthLimit(input, limit)) {
            throw new IllegalArgumentException("입력값의 길이는 "+limit+"이어야 합니다.");
        }
        if (!isContainOnlyDigit(input)) {
            throw new IllegalArgumentException("입력 값은 1~9 사이의 값이어야 합니다.");
        }
    }

    //입력 값이 1이거나 2인지 검사
    private void validateExitInput(String input) {
       if(!(input.equals("1")||input.equals("2"))){
           throw new IllegalArgumentException("입력 값은 1또는 2어야 합니다.");
       }
    }

    // 종료 시점에 입력 값이 1 또는 2인지 검사
    public void validateExitInput(String input, int limit){
        validateInput(input,limit);
        validateExitInput(input);
    }
    //입력에 중복된 값이 입력되었는지 검사
    public void validateInputDuplicate(List<Integer> input) {
        boolean hasDuplicate = input.stream().distinct().count() < input.size();

        if (hasDuplicate) {
            throw new IllegalArgumentException("입력 값은 서로 다른 1~9 사이의 값이어야 합니다.");
        }
    }


}
