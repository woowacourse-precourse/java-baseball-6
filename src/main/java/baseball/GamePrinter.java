package baseball;

public interface GamePrinter {
    String STARTING_MESSAGE = "숫자 야구 게임을 시작합니다.";
    String ENDING_MESSAGE = "숫자 야구 게임을 종료합니다.";

    static void printStartingMessage() {
        System.out.println(STARTING_MESSAGE);
    }

    static void printEndingMessage() {
        System.out.println(ENDING_MESSAGE);
    }
}
