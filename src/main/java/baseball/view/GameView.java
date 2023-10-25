package baseball.view;

import baseball.model.BaseballGameCountsMessage;

public class GameView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임종료";

    // 게임 시작 메시지 출력
    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    // 게임 승리 메시지 출력
    public static void printGameWinMessage() {
        System.out.println(GAME_WIN_MESSAGE);
    }

    // 카운트 메시지 출력 함수
    public static void printBaseballGameCountsMessage(BaseballGameCountsMessage baseballGameCountsMessage) {
        baseballGameCountsMessage.printMessage();
    }
}
