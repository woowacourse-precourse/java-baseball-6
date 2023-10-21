package baseball.view;

public class OutputView {
    private static final String GameStartMessage = "숫자 야구 게임을 시작합니다.";
    private static final String GameEndMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printGameStart() {
        System.out.println(GameStartMessage);
    }

    public void printGameEnd() {
        System.out.println(GameEndMessage);
    }
}
