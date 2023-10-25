package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {

    public List<Integer> getInput(){
        List<Integer> userInput = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");

        String input = Console.readLine();

        if(input.length() != 3){
            throw new IllegalArgumentException("세 자리 숫자를 입력하지 않아 종료됩니다.");
        }

        for (int i=0; i< input.length(); i++) {
            char c = input.charAt(i);
            if(!Character.isDigit(c)){
                throw new IllegalArgumentException("숫자가 아닌 문자가 입력되어 종료됩니다.");
            }
            int number = Character.getNumericValue(c);

            if (number < 1 || number > 9) {
                throw new IllegalArgumentException("1~9 사이의 숫자가 입력되지 않아 종료됩니다.");
            }

            if (userInput.contains(number)) {
                throw new IllegalArgumentException("중복되는 입력값이 있어 종료됩니다.");
            }
            userInput.add(number);
        }
        return userInput;
    }
}
