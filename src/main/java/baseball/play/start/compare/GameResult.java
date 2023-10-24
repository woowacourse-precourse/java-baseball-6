package baseball.play.start.compare;

public class GameResult<T extends ResumingGame, R extends WinningGame> {

  private final T gameResume;
  private final R winningGame;

  private GameResult(T gameResume, R winningGame) {
    this.gameResume = gameResume;
    this.winningGame = winningGame;
  }

  public static GameResult<ResumingGame,WinningGame> resume(ResumingGame gameResume) {
    return new GameResult(gameResume, null);
  }

  public static GameResult<ResumingGame,WinningGame> win(WinningGame winningGame) {
    return new GameResult(null, winningGame);
  }

  public boolean isWin() {
    return winningGame != null;
  }

  public boolean isResume() {
    return gameResume != null;
  }

  public T getGameResume() {
    return gameResume;
  }

  public R getWinningGame() {
    return winningGame;
  }
}
