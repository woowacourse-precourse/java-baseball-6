package baseball.domain;

import static baseball.global.GameMessage.GAME_START_MESSAGE;
import static baseball.global.GameMessage.INPUT_NUMBER_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Player {

    private final List<Integer> numbers;

    public Player() {
        this.numbers = input();
    }

    private List<Integer> input() {
        System.out.print(GAME_START_MESSAGE.message);
        System.out.print(INPUT_NUMBER_MESSAGE.message);
        String input = Console.readLine().trim();
        validateNumberFormat(input);
        validateNoDuplicate(input);
        String[] inputNumbers = input.split("");

        return Arrays.stream(inputNumbers)
                .map(Integer::valueOf)
                .toList();
    }

    private void validateNumberFormat(String input) {
        // 입력 값이 1~9 사이 3자리 숫자가 아닐 경우 판명
        if (!input.matches("^[1-9]{3}$")) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNoDuplicate(String input) {
        // HashSet이 중복된 값을 허용하지 않는다는 것을 이용하여 입력 값 중 같은 숫자가 있을 경우 판명
        HashSet<Character> inputNumbers = new HashSet<>();
        for (char c : input.toCharArray()) {
            inputNumbers.add(c);
        }
        if (inputNumbers.size() != input.length()) {
            throw new IllegalArgumentException();
        }
    }
}
