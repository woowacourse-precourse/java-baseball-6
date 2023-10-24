package baseball.view;

import java.util.List;

public class OutputView {
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String THREE_STRIKE_PRINT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String AFTER_GAME_PRINT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String STRIKE = "스트라이크";

    public void printNotThreeStrikeResult(String notStrikeHint) {
        System.out.println(notStrikeHint);
    }

    public void printThreeStrikeResult(int strikeCount) {
        System.out.println(strikeCount + STRIKE);
        System.out.println(THREE_STRIKE_PRINT);
        System.out.println(AFTER_GAME_PRINT);
    }

    public void printCreateController() {
        System.out.println(GAME_START);
    }
}
