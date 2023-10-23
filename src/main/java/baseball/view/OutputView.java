package baseball.view;

import baseball.model.InputNumber;

public class OutputView {
    private static final int NUMBER_OF_DIGITS = 3;
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public String printStart() {
        return GAME_START_MESSAGE;
    }

    public String printHint(String HintMessage) {
        return HintMessage;
    }

    public String printSuccess() {
        return NUMBER_OF_DIGITS + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }
}
