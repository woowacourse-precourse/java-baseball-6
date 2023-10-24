package baseball.view;

import baseball.model.BaseballGameCountsMessage;

public class GameView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임종료";

    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printGameWinMessage() {
        System.out.println(GAME_WIN_MESSAGE);
    }

    public static void printBaseballGameCountsMessage(BaseballGameCountsMessage baseballGameCountsMessage) {
        baseballGameCountsMessage.printMessage();
    }
}
