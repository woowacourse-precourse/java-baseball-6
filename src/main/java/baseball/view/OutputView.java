package baseball.view;


public class OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private OutputView() {
    }

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printResult(String result) {
        System.out.println(result);
    }

    public static void printEndMessage() {
        System.out.println(END_MESSAGE);
    }

}
