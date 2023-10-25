package baseball.domain;

class Printer {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    Printer() {
    }

    void printStartMessage() {
        System.out.println(START_MESSAGE);
    }
}
