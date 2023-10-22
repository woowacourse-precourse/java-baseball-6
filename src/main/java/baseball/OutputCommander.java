package baseball;

final class OutputCommander {

    void printGameStart() {
        System.out.println(OutputMessage.START.message);
    }

    void printReceivingInput() {
        System.out.print(OutputMessage.INPUT_NUMBER.message);
    }

    void printGameScore(String score) {
        System.out.println(score);
    }

    void printGameClear() {
        System.out.println(OutputMessage.GAME_CLEAR.message);
    }

    void printAskingRetry() {
        System.out.println(OutputMessage.RETRY_OR_END.message);
    }

}
