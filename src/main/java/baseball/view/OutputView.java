package baseball.view;

import java.util.List;

public class OutputView {
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    public void printNotThreeStrikeResult(String notStrikeHint) {
        System.out.println(notStrikeHint);
    }

    public void printCreateController() {
        System.out.println(GAME_START);
    }
}
