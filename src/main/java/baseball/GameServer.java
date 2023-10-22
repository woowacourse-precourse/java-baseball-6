package baseball;

final class GameServer {

    private final Input input = new Input();
    private final Output output = new Output();
    private final Computer computer = new Computer();
    private Result score;

    void run() {
        output.printGameStart();
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
        output.printReceivingInput();
        Digits input = Digits.generateFixedDigits(this.input.receiveInput());
        score = computer.calculateScore(input);
        output.printGameScore(score.getResultInKorean());
    }

    private Command askRetry() {
        output.printGameClear();
        output.printAskingRetry();
        return Command.getCommand(input.receiveInput());
    }

    private void endGame() {
        input.stopReceivingInput();
    }
}
