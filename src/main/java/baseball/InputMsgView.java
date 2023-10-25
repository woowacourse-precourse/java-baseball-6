package baseball;

public class InputMsgView {

    private final static String GAME_START_MSG = "숫자 야구 게임을 시작합니다.";
    private final static String GAME_RESTART_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final static String INPUT_NUMBER_MSG = "숫자를 입력해주세요 : ";

    public void printStartMsg() {
        System.out.println(GAME_START_MSG);
    }

    public void printInputNumberMsg() {
        System.out.print(INPUT_NUMBER_MSG);
    }

    public void printRestartMsg() {
        System.out.println(GAME_RESTART_MSG);
    }
}
