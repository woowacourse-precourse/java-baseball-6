package baseball.view;

import baseball.domain.BaseballResult;

public class OutputView {
    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String RESTART_OR_EXIT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String NOTHING = "낫싱";
    private static final String BALL = "%d볼";
    private static final String STRIKE = "%d스트라이크";

    public void print(String text) {
        System.out.print(text);
    }

    public void println(String text) {
        System.out.println(text);
    }

    public void printStartMessage() {
        println(START_GAME);
    }

    public void printInputNumberMessage() {
        print(INPUT_NUMBER);
    }

    public void printRestartOrExitMessage() {
        println(RESTART_OR_EXIT);
    }

    public void printBallStrikeResultMessage(BaseballResult baseballResult) {
        println(baseballResult.toString());
    }


}
