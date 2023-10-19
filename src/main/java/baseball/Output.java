package baseball;

public class Output {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public void showStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void showInputMessage() {
        System.out.print(NUMBER_INPUT_MESSAGE);
    }
}
