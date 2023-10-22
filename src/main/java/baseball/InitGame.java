package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InitGame {
    public List<Integer> playerNum() {
        System.out.println("숫자를 입력해주세요: ");

        String input = Console.readLine();
        validateInput(input);
        return parseInput(input);
    }

    // IllegalArgumentException
    private void validateInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("Not a three-digit number");
        }
    }

    private List<Integer> parseInput(String input) {
        List<Integer> playerNum = new ArrayList<>();
        for (char digit : input.toCharArray()) {
            playerNum.add(Character.getNumericValue(digit));
        }
        return playerNum;
    }
}
