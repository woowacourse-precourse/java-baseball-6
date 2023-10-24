package baseball.view;

import baseball.domain.BaseballNumber;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
public class InputView {
    public List<BaseballNumber> readNumber() {
        String input = Console.readLine();
        return convertToBaseballNumbers(input);
    }

    private List<BaseballNumber> convertToBaseballNumbers(final String input) {
        return input.chars()
                .mapToObj(Character::getNumericValue)
                .map(BaseballNumber::new)
                .toList();
    }

    public static int readContinue() {
        return Integer.parseInt(Console.readLine());
    }
}
