package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    public static List<Integer> readUserNumbers() {
        String input = Console.readLine();
        return input.chars()
                .mapToObj(Character::getNumericValue)
                .toList();
    }
}
