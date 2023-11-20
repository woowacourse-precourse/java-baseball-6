package baseball.View;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class OutputView {
    private static final String CLOSING_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void resultView(String result) {
        System.out.println(result);
    }

    public String closingGame() {
        System.out.println(CLOSING_GAME);
        System.out.println(RE_GAME);
        return readLine();
    }
}
