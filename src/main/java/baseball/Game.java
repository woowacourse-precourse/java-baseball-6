package baseball;

public class Game {

    private Balls computerBalls;
    private GameStatus status;

    public Game(Balls computerBalls) {
        this.computerBalls = computerBalls;
    }

    private void computerBallReset() {
        computerBalls = new Balls();
    }

    private void gameOver(GameResult gameResult) {
        if (!gameResult.isThreeStrike()) {
            return;
        }

        GameIO.gameRestartPrint();
        Command command = Command.findByCommand(GameIO.scanGameCommand());
        if (command.isEnd()) {
            status = GameStatus.END;
            return;
        }
        computerBallReset();
    }

    public void play() {
        status = GameStatus.PLAY;

        GameIO.gameStartPrint();
        while (status.isPlay()) {
            GameIO.gameInputPrint();

            Balls playerBalls = GameIO.scanGameBalls();
            GameResult gameResult = computerBalls.getGameResult(playerBalls);
            GameIO.gameResultPrint(gameResult);

            gameOver(gameResult);
        }
    }
}
