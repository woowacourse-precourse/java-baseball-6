package baseball.games.numberbaseball.util;

import baseball.GamePrinter;

public class BaseballPrinter implements GamePrinter {
    private static final String STARTING_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String ENDING_MESSAGE = "숫자 야구 게임을 종료합니다.";
    private static final String NUMBER_INPUT_PROMPT = "숫자를 입력해주세요 : ";
    private static final String CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다. 게임 종료";
    private static final String OPTION_INPUT_PROMPT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    @Override
    public void printStartingMessage() {
        System.out.println(STARTING_MESSAGE);
    }

    @Override
    public void printEndingMessage() {
        System.out.println(ENDING_MESSAGE);
    }

    public static void printRequestingNumberMessage() {
        System.out.print(NUMBER_INPUT_PROMPT);
    }

    public static void printCorrectMessage() {
        System.out.println(CORRECT_MESSAGE);
    }

    public static void printOptionInputMessage() {
        System.out.println(OPTION_INPUT_PROMPT);
    }
}
