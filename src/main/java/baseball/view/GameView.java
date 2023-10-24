package baseball.view;

public class GameView {
    private final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String SUCCESS_AND_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printSuccessAndEndMessage() {
        System.out.println(SUCCESS_AND_END_MESSAGE);
    }

    public void printGameResult(String result) {
        System.out.println(result);
    }
}
