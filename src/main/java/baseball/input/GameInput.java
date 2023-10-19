package baseball.input;

public class GameInput {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String REQUEST_MESSAGE = "숫자를 입력해주세요 : ";

    private void printRequestMessage() {
        System.out.print(REQUEST_MESSAGE);
    }

    public void printlnStartMessage() {
        System.out.println(START_MESSAGE);
    }

}
