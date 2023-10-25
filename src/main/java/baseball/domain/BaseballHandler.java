package baseball.domain;

public class BaseballHandler {

    Computer computer = new Computer();

    public BaseballHandler(Computer computer) {
        this.computer = computer;
    }

    public void execute() {
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
