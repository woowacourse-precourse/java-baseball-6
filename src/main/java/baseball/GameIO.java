package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameIO {
    private static final String RESTART_INFO_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
            + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String START_INFO_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String NOT_THREE_DIGIT_MESSAGE = "3자리 숫자만 입력가능합니다.";
    private static final String NOT_NUMBER_MESSAGE = "숫자가 아닙니다.";
    private static final char NUMBER_ZERO_ASCII_CODE = '0';
    private static final int GAME_INPUT_LENGTH = 3;
    private static final String VALUE_REGEXP = "[1-9]+";
    private static final String COMMAND_REGEXP = "[1-2]+";
    private static final String NOT_COMMAND_FORMAT_MESSAGE = "1또는 2만 입력 가능합니다.";

    static void gameResultPrint(GameResult result) {
        System.out.println(result);
    }

    static void gameRestartPrint() {
        System.out.println(RESTART_INFO_MESSAGE);
    }

    static void gameStartPrint() {
        System.out.println(START_INFO_MESSAGE);
    }

    static void gameInputPrint() {
        System.out.print(NUMBER_INPUT_MESSAGE);
    }

    static Balls scanGameBalls() {
        String ballsStr = Console.readLine();
        validationInput(ballsStr);

        return new Balls(
                new Ball(ballsStr.charAt(0) - NUMBER_ZERO_ASCII_CODE)
                , new Ball(ballsStr.charAt(1) - NUMBER_ZERO_ASCII_CODE)
                , new Ball(ballsStr.charAt(2) - NUMBER_ZERO_ASCII_CODE));
    }

    private static void validationInput(String input) {
        if (input.length() != GAME_INPUT_LENGTH) {
            throw new IllegalArgumentException(NOT_THREE_DIGIT_MESSAGE);
        }
        if (!input.matches(VALUE_REGEXP)) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
    }

    public static String scanGameCommand() {
        String command = Console.readLine();
        validationCommand(command);
        return command;
    }

    private static void validationCommand(String command) {
        if (!command.matches(COMMAND_REGEXP)) {
            throw new IllegalArgumentException(NOT_COMMAND_FORMAT_MESSAGE);
        }
    }

}
