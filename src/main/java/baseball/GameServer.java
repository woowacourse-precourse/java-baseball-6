package baseball;

final class GameServer {

    private final InputCommander inputCommander = new InputCommander();
    private final OutputCommander outputCommander = new OutputCommander();
    private final Computer computer = new Computer();
    private Result score;

    void run() {
        outputCommander.printGameStart();
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
        outputCommander.printReceivingInput();
        Digits input = Digits.generateFixedDigits(inputCommander.receiveInput());
        score = computer.calculateScore(input);
        outputCommander.printGameScore(score.getResultInKorean());
    }

    private Command askRetry() {
        outputCommander.printGameClear();
        outputCommander.printAskingRetry();
        return Command.getCommand(inputCommander.receiveInput());
    }

    private void endGame() {
        inputCommander.stopReceivingInput();
    }
}
