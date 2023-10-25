package baseball.domain;

import static baseball.global.GameMessage.GAME_START_MESSAGE;

public class BaseballHandler {
    Computer computer = new Computer();

    public BaseballHandler(Computer computer) {
        this.computer = computer;
    }

    private void printStartMessage() {
        System.out.print(GAME_START_MESSAGE.message);
    }

    public void execute() {
        printStartMessage();
        boolean gameEndedFlag;
        do {
            Player player = new Player();
            Umpire umpire = new Umpire(this.computer, player);
            ComparisonResult comparisonResult = new ComparisonResult(umpire.getBallCount(), umpire.getStrikeCount());
            comparisonResult.printResult();
            gameEndedFlag = !comparisonResult.checkGameEnded();
        } while (gameEndedFlag);
    }
}
