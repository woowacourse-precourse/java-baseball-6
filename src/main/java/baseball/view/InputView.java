package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RETRY_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String NOT_NUMBER_MESSAGE = "숫자 입력이 필요합니다.";

    public static int inputNumber() {
        System.out.print(NUMBER_INPUT_MESSAGE);
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
    }

    public static int inputRetryGame() {
        System.out.println(RETRY_GAME_MESSAGE);
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
    }
}
