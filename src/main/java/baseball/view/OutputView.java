package baseball.view;

import baseball.domain.GameResult;
import baseball.util.StringUtil;

public class OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private final StringUtil stringUtil;

    public OutputView(StringUtil stringUtil) {
        this.stringUtil = stringUtil;
    }

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printRoundResult(GameResult gameResult) {
        String result = stringUtil.makeResultMessage(gameResult);
        System.out.println(result);
    }

    public void printSuccess() {
        System.out.println(SUCCESS_MESSAGE);
    }
}
