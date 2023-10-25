package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<Integer> numbers;

    private Player(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Player fromUserInput() {
        List<Integer> userInputNumbers = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");

        String[] userInput = Console.readLine().split("");
        for (String input : userInput) {
            int number = Integer.parseInt(input);

            if (userInputNumbers.contains(number) || number < 1 || number > 9) {
                throw new IllegalArgumentException();
            }

            userInputNumbers.add(number);
        }

        if (userInputNumbers.size() != 3) {
            throw new IllegalArgumentException();
        }

        return new Player(userInputNumbers);
    }

    public List<Integer> getPlayerNumbers() {
        return numbers;
    }
}
