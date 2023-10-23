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

    public int readRetryNumber() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = readLineWithoutGap();
        validateRetryNumber(userInput);

        return Integer.parseInt(userInput);
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

    private void validateRetryNumber(String userInput) {
        if (!userInput.equals("1") && !userInput.equals("2")) {
            throw new IllegalArgumentException();
        }
    }
}
