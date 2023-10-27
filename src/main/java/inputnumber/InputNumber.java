package inputnumber;

import java.util.HashSet;
import java.util.Set;

public class InputNumber {


    public void NumberCheck(String input) {

        isLengthCorrect(input);
        isDigit(input);
        isNotDifferent(input);
    }

    public void isLengthCorrect(String input) throws IllegalArgumentException{
        if (input.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(입력값 3자리)");
        }
    }

    public void isDigit(String input) throws IllegalArgumentException{
        for(int i =0; i< input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(0~9 사이의 자연수)");
            }
        }
    }

    public void isNotDifferent(String input) throws IllegalArgumentException{
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
        }
        if (set.size() != input.length()) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(중복된 숫자)");
        }
    }
}
