package view;

public class GameView {
    private static String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public static void printGameStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }

}
