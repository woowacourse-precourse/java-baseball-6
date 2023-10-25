package baseball.view;

import baseball.game.GameNumbers;
import baseball.utils.GameMessage;
import baseball.utils.Parser;
import baseball.utils.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static GameNumbers readUserNumbers() {
        System.out.print(GameMessage.REQUEST_USER_NUMBER_MESSAGE);
        String userInput = readLineWithoutGap();
        Validator.validateIsDigit(userInput);

        return new GameNumbers(Parser.stringToList(userInput));
    }

    public static int readRetryNumber() {
        System.out.println(GameMessage.REQUEST_USER_RETRY_MESSAGE);
        String userInput = readLineWithoutGap();
        Validator.validateRetryNumber(userInput);

        return Integer.parseInt(userInput);
    }

    private static String readLineWithoutGap() {
        return Console.readLine().trim();
    }
}
