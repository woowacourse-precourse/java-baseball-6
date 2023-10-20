package baseball.view;

public class OutputView {

    private static final String BASEBALL_GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUTTING_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";

    public static void printBaseballGameStartMessage() {
        System.out.println(BASEBALL_GAME_START_MESSAGE);
    }

    public static void printMessageToInputNumbers() {
        System.out.print(INPUTTING_NUMBERS_MESSAGE);
    }
}
