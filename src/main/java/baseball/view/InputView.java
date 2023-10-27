package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.validator.InputValidator;

public class InputView {

    private static final String START_NEW_GAME_NUMBER = "1";
    private static final String END_GAME_NUMBER = "2";

    public String inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = readLine().trim();

        InputValidator.validateInputLength(input);
        InputValidator.validateInputNumber(input);

        return input;
    }

    public String inputStartNewGame() {
        System.out.println("게임을 새로 시작하려면 " + START_NEW_GAME_NUMBER + ", 종료하려면 " + END_GAME_NUMBER + "를 입력하세요.");
        String input = readLine().trim();

        InputValidator.validateInputNumber(input);

        return input;
    }


}
