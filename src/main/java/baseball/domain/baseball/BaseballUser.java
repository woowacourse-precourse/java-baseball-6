package baseball.domain.baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static baseball.domain.baseball.BaseballValidator.validateInput;

public class BaseballUser {

    private BaseballPick number;

    public void pickNumber() {
        String input = Console.readLine();
        validateInput(input);
        List<Integer> numberPick = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();
        number = new BaseballPick(numberPick);
    }

    public BaseballPick getNumber() {
        return number;
    }

}
