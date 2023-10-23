package baseball.view;

import baseball.game.GameNumbers;
import baseball.utils.Parser;
import baseball.utils.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static GameNumbers readUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLineWithoutGap();
        Validator.validateIsDigit(userInput);

        return new GameNumbers(Parser.stringToList(userInput));
    }

    public static int readRetryNumber() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = readLineWithoutGap();
        Validator.validateRetryNumber(userInput);

        return Integer.parseInt(userInput);
    }

    private static String readLineWithoutGap() {
        return Console.readLine().trim();
    }
}
