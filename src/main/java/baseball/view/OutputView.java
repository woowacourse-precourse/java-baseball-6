package baseball.view;

import baseball.util.constants.BaseballGameConstants;

public class OutputView {

    public static final String PROMPT_GAME_START = "숫자 야구 게임을 시작합니다.";
    public static final String PROMPT_GAME_END = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료"
            .formatted(BaseballGameConstants.NUM_LENGTH);

    public void displayGameStart() {
        System.out.println(PROMPT_GAME_START);
    }

    public void displayGameEnd() {
        System.out.println(PROMPT_GAME_END);
    }

    public void displayHint(String hint) {
        System.out.println(hint);
    }
}
