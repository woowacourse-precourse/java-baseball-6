package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public List<Integer> inputNumbers() {
        List<Integer> playerNumbers = new ArrayList<>();
        String input = Console.readLine();

        if (input.length() != 3) {
            throw new IllegalArgumentException("세 자리 숫자를 입력해주세요.");
        }

        for (char c : input.toCharArray()) {
            int number = Character.getNumericValue(c);
            if (number < 1 || number > 9 || playerNumbers.contains(number)) {
                throw new IllegalArgumentException("1에서 9까지 서로 다른 숫자를 입력해주세요.");
            }
            playerNumbers.add(number);
        }
        return playerNumbers;
    }
}
