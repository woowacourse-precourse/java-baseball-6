package baseball.view;

import baseball.game.GameNumbers;
import baseball.utils.Parser;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public GameNumbers readUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLineWithoutGap();
        validateIsDigit(userInput);

        return new GameNumbers(Parser.stringToList(userInput));
    }

    private String readLineWithoutGap() {
        return Console.readLine().trim();
    }

    private void validateIsDigit(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
