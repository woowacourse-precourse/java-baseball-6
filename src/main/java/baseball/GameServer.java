package baseball;

final class GameServer {

    private final Computer computer = new Computer();
    private Result score;

    void run() {
        Output.printGameStart();
        while (true) {
            playGame();
            if (isGameClear()) {
                if(endGame()) break;
                retry();
            }
        }
        closeGame();
    }

    private void playGame() {
        Output.printReceivingInput();
        Digits input = Digits.generateFixedDigits(Input.receiveInput());
        score = computer.calculateScore(input);
        Output.printGameScore(score.getResultInKorean());
    }

    private boolean isGameClear() {
        return score.isThreeStrike();
    }

    private void retry() {
        computer.prepareGameRetry();
    }

    private boolean endGame() {
        Output.printGameClear();
        Output.printAskingRetry();
        return !Command.getCommand(Input.receiveInput()).retry;
    }

    private void closeGame() {
        Input.stopReceivingInput();
    }
}
