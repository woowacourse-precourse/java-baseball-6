package baseball;

public class BaseballGame {
    public static final int GAME_NUMBER_DIGIT = 3;
    private PlayerNumbers playerNumbers;
    private ComputerNumbers computerNumbers;
    private final StrikeBallCounter strikeBallCounter;
    private final GameRestart gameRestart;

    BaseballGame() {
        this.strikeBallCounter = new StrikeBallCounter();
        this.gameRestart = new GameRestart();
    }

    public void playBaseballGame() {
        Output.printGameStartMessage();
        do {
            playOneBaseballGame();
        } while(gameRestart.wantRestartGame());
    }

    private void playOneBaseballGame() {
        setComputerNumbers();
        do {
            inputPlayerNumbers();
            strikeBallCounter.countStrikeAndBall(playerNumbers, computerNumbers);
        } while(!strikeBallCounter.isGameClear());
    }

    private void setComputerNumbers() {
        this.computerNumbers = new ComputerNumbers();
    }

    private void inputPlayerNumbers() {
        this.playerNumbers = new PlayerNumbers();
    }
}
