package baseball.view;

public class OutputView {

    public static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String ENTER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String END_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RESTART_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printStartGame() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void printEnterNumber() {
        System.out.println(ENTER_NUMBER_MESSAGE);
    }

    public void printHint(String Hint) {
        System.out.println(Hint);
    }

    public void printEndGame() {
        System.out.println(END_GAME_MESSAGE);
    }

    public void printAskRestartGame() {
        System.out.println(RESTART_GAME_MESSAGE);
    }
}
