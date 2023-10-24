package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Player {
    public static final int ANSWER_INPUT_MAX = 3;
    public static final int MODE_INPUT_MAX = 1;

    public String getAnswerInput(){
        String input = Console.readLine();
        validateInput(input, ANSWER_INPUT_MAX);
        return input;
    }

    public String getModeInput(){
        String input = Console.readLine();
        validateInput(input, MODE_INPUT_MAX);
        return input;
    }

    public void validateInput(String input, int limitLegnth){
        // null 체크
        validNull(input);
        // 숫자형식
        validateNumber(input);
        // 자릿수
        validateLength(input,limitLegnth);
        // 유효 숫자(1~9)
        validateIsDigit(input);
        // 서로 다른 수
        validDifferentNumber(input);
    }

    public void validNull(String input){
        if(input == null || input.equals("")){
            throw new IllegalArgumentException("입력되지 않았습니다.");
        }
    }

    public void validateNumber(String input){
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 아닙니다.");
        }
    }

    public void validateLength(String input, int limitLegnth){
        if (input.length() != limitLegnth) {
            throw new IllegalArgumentException(limitLegnth + "자리의 수를 입력해야 합니다.");
        }
    }

    public void validateIsDigit(String input){
        // 1~9 인지 검증
        boolean result = input.chars()
                .allMatch(ch -> Character.isDigit(ch) && ch != '0');
        if(!result){
            throw new IllegalArgumentException("유효 숫자가 아닙니다.");
        }
    }

    public void validDifferentNumber(String input){
        ArrayList<Integer> nums = new ArrayList<>();
        // 서로 다른 숫자 인지 검증
        input.chars().forEach( x ->{
            if(nums.contains(x))
                throw new IllegalArgumentException("서로 다른 숫자여야 합니다.");
            nums.add(x);
        });

    }
}
