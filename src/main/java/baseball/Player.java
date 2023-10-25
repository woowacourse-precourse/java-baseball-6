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
                throw new IllegalArgumentException("올바르지 않은 숫자입니다. 1부터 9사이의 서로 다른 숫자 3개를 입력해주세요.");
            }

            userInputNumbers.add(number);
        }

        if (userInputNumbers.size() != 3) {
            throw new IllegalArgumentException("3개의 숫자를 입력해주세요.");
        }

        return new Player(userInputNumbers);
    }
}
