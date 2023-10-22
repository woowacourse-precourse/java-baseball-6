package baseball.view;

public class OutputView {
    private static final String BASEBALL_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String BASEBALL_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RETRY_CHECK_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void readStartMessage() {
        System.out.println(BASEBALL_START_MESSAGE);
    }

    public void readEndMessage() {
        System.out.println(BASEBALL_END_MESSAGE);
    }

    public void readCountsMessage(String message) {
        System.out.println(message);
    }

    public void readRetryCheckMessage() {
        System.out.println(RETRY_CHECK_MESSAGE);
    }
}
