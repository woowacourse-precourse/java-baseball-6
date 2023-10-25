// UserInput.java
package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    public List<Integer> getUserInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        return parseUserInput(userInput);
    }

    private List<Integer> parseUserInput(String userInput) {
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            char charDigit = userInput.charAt(i);
            int digit = Character.getNumericValue(charDigit);
            userNumbers.add(digit);
        }

        if (userNumbers.size() != 3) {
            throw new IllegalArgumentException("게임종료");
        }
        return userNumbers;
    }
}
