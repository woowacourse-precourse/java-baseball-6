package baseball.view;

import java.util.Objects;

public class NumberBaseballGameOutputView {
    static final String START_GAME_MESSAGE = " 게임을 시작합니다.";
    static final String NUMBER_INPUT_REQUEST = "숫자를 입력해주세요.";

    void printStartGameMessage(String gameName) {
        System.out.println(gameName + START_GAME_MESSAGE);
    }

    void printNumberInputRequest() {
        System.out.println(NUMBER_INPUT_REQUEST);
    }

    void printScoreSummary(String result) {
        System.out.println(result);
    }


}
