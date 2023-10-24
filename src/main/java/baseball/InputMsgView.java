package baseball;

public class InputMsgView {

    private final static String GAME_START_MSG = "숫자 야구 게임을 시작합니다.";
    private final static String INPUT_NUMBER_MSG = "숫자를 입력해주세요 : ";

    public void printStartMsg() {
        System.out.println(GAME_START_MSG);
    }

    public void printInputNumberMsg() {
        System.out.println(INPUT_NUMBER_MSG);
    }
}
