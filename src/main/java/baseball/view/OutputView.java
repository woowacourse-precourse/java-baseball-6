package baseball.view;

public class OutputView {
    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printStartGame() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void printEndGame() {
        System.out.println(END_GAME_MESSAGE);
    }

    public void printHint(String hint) {
        System.out.println(hint);
    }
}
