package baseball.entity;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
public class User {
    private List<Integer> userNumber = new ArrayList<>();

    public List<Integer> inputNumber(){
        String input = Console.readLine();

        validateInput(input, userNumber);

        return userNumber;
    }

    public void validateInput(String input, List<Integer> userNumber) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        char[] charArr = input.toCharArray();

        for (char c: charArr) {
            if (Character.isDigit(c)) {
                int number = Character.getNumericValue(c);
                if (number >= 0 && !userNumber.contains(number)) {
                    userNumber.add(number);
                } else { //1 - 9 사이의 수가 아니거나 중복 입력 시
                    throw new IllegalArgumentException();
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

}
