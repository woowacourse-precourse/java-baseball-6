package baseball.games.numberbaseball.util;

import baseball.GamePrinter;

public class BaseballPrinter implements GamePrinter {
    private static final String STARTING_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String ENDING_MESSAGE = "숫자 야구 게임을 종료합니다.";
    private static final String NUMBER_INPUT_PROMPT = "숫자를 입력해주세요 : ";

    @Override
    public void printStartingMessage() {
        System.out.println(STARTING_MESSAGE);
    }

    @Override
    public void printEndingMessage() {
        System.out.println(ENDING_MESSAGE);
    }

    public void printRequestingNumberMessage() {
        System.out.print(NUMBER_INPUT_PROMPT);
    }
}
