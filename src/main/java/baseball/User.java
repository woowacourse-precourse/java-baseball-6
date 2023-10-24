package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {

    /** userInput : 사용자가 숫자를 입력
     *  사용자가 1~9까지의 숫자를 입력
     */
    public List<Integer> userInput() {

        List<Integer> userAnswers = new ArrayList<>();

        String input = Console.readLine();

        for (int i = 0; i < input.length(); i++) {

            int number = Character.getNumericValue(input.charAt(i));

            userAnswers.add(number);

        }

        return userAnswers;
    }
}
