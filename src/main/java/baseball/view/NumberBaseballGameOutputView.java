package baseball.view;

import java.util.Objects;

public class NumberBaseballGameOutputView {
    static final String START_GAME_MESSAGE = " 게임을 시작합니다.";
    static final String NUMBER_INPUT_REQUEST = "숫자를 입력해주세요.";
    private static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printStartGameMessage(String gameName) {
        System.out.println(gameName + START_GAME_MESSAGE);
    }

    public void printNumberInputRequest() {
        System.out.println(NUMBER_INPUT_REQUEST);
    }

    public void printScoreSummary(String result) {
        System.out.println(result);
    }

    public void printGameOverMessage() {
        System.out.println(GAME_OVER_MESSAGE);
    }

    public void askForGameRestart() {
        System.out.println(GAME_RESTART_MESSAGE);
    }


}
