package baseball.view;

import baseball.view.constant.ResultType;

public class OutputView {

    private static final String startMessage = "숫자 야구 게임을 시작합니다.";
    private static final String endMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void displayStartMessage() {
        System.out.println(startMessage);
    }

    public void displayEndMessage() {
        System.out.println(endMessage);
    }

    public void displayResult(int strike, int ball) {
        String resultMessage = ResultType.getResultMessage(strike, ball);
        System.out.println(resultMessage);
    }
}
