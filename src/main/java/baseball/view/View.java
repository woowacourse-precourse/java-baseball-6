package baseball.view;

import baseball.domain.PlayerNumbers;
import baseball.util.Console;

public class View {

    private static final String MESSAGE_INPUT_NUMBERS = "숫자를 입력해주세요 : ";

    public static PlayerNumbers inputPlayerNumbers() {
        System.out.print(MESSAGE_INPUT_NUMBERS);
        String numbers = Console.readLine();
        return new PlayerNumbers(numbers);
    }
}
