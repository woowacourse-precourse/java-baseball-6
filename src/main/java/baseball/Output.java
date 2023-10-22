package baseball;

final class Output {

    private Output() {
    }

    static void printGameStart() {
        System.out.println(OutputMessage.START.message);
    }

    static void printReceivingInput() {
        System.out.print(OutputMessage.INPUT_NUMBER.message);
    }

    static void printGameScore(final String score) {
        System.out.println(score);
    }

    static void printGameClear() {
        System.out.println(OutputMessage.GAME_CLEAR.message);
    }

    static void printAskingRetry() {
        System.out.println(OutputMessage.RETRY_OR_END.message);
    }

}
