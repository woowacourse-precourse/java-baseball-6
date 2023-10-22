package baseball;

final class GameServer {

    private final Computer computer = new Computer();
    private Result score;

    void run() {
        Output.printGameStart();
        while (true) {
            playGame();
            if (score.isThreeStrike()) {
                if(!askRetry().retry) break;
                computer.prepareGameRetry();
            }
        }
        endGame();
    }

    private void playGame() {
        Output.printReceivingInput();
        Digits input = Digits.generateFixedDigits(Input.receiveInput());
        score = computer.calculateScore(input);
        Output.printGameScore(score.getResultInKorean());
    }

    private Command askRetry() {
        Output.printGameClear();
        Output.printAskingRetry();
        return Command.getCommand(Input.receiveInput());
    }

    private void endGame() {
        Input.stopReceivingInput();
    }
}
