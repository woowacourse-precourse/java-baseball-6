package baseball.Controller;

import java.util.Arrays;
import java.util.HashSet;

public class Validator {
    public void validatePlayerInput(String playerInput) {
        String[] numbers = playerInput.replace(" ", "").split("");
        if (numbers.length != 3) {
            throw new IllegalArgumentException("3개의 수를 입력해야합니다");
        }
        for (String number : numbers) {
            if (!number.matches("[0-9]+")) {
                throw new IllegalArgumentException("숫자만 입력해야 합니다");
            }
        }
        HashSet<String> set = new HashSet<>(Arrays.asList(numbers));
        if (set.size() != 3) {
            throw new IllegalArgumentException("중복되지 않는 3개의 수를 입력해야합니다");
        }
    }


    public void validateGameEndInput(String endnumber){
        try{
            int n = Integer.parseInt(endnumber);
            if(n!=1 && n!=2)
                throw new IllegalArgumentException("1혹은 2를 입력하세요");
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자가 아닙니다, 1혹은 2를 입력하세요");
        }
    }

}
