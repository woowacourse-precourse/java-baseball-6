package baseball.view;

public class OutputView {
    private static final String BASEBALL_GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String BASEBALL_GAME_THREE_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료.";
    private static final String BASEBALL_GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void println(String T) {
        System.out.println(T);
    }

    public void printBaseballGameStart() {
        println(BASEBALL_GAME_START_MESSAGE);
    }

    public void printThreeStrikeSuccess() {
        println(BASEBALL_GAME_THREE_STRIKE_MESSAGE);
    }

    public void printBaseballGameRestart() {
        println(BASEBALL_GAME_RESTART_MESSAGE);
    }
}