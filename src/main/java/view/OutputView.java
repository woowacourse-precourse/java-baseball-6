package view;

public class OutputView {
    static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    static String INPUT_THREE_DIGITS_MESSAGE = "숫자를 입력해주세요 : ";

    public static void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printInputThreeDigits() {
        System.out.print(INPUT_THREE_DIGITS_MESSAGE);
    }
}
