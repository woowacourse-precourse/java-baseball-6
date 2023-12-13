package baseball.view;

import baseball.view.console.ConsoleWriter;

public class OutputView {
    private static final String BALL = "%d볼";
    private static final String STRIKE = "%d스트라이크";
    private static final String BOTH = "%s %s";
    private static final String NOTHING = "낫싱";

    public void start() {
        ConsoleWriter.printlnMessage("숫자 야구 게임을 시작합니다.");
    }

}
