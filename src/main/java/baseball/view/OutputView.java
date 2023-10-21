package baseball.view;

public class OutputView {

    public static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String ENTER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    public void printStartGame() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void printEnterNumber() {
        System.out.println(ENTER_NUMBER_MESSAGE);
    }

    public void printHint(String Hint) {
        System.out.println(Hint);
    }
}
