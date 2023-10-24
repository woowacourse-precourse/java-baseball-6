package baseball.play.restart;

public class CommandConsoleResult <R, Q>{
  private final R restart;
  private final Q quit;

  private CommandConsoleResult(R restart, Q quit) {
    this.restart = restart;
    this.quit = quit;
  }

  public static <R, Q> CommandConsoleResult<R, Q> restart(R restart) {
    return new CommandConsoleResult<>(restart, null);
  }

  public static <R, Q> CommandConsoleResult<R, Q> quit(Q quit) {
    return new CommandConsoleResult<>(null, quit);
  }

  public boolean isRestart() {
    return restart != null;
  }

  public boolean isQuit() {
    return quit != null;
  }

  public R getRestart() {
    return restart;
  }

  public Q getQuit() {
    return quit;
  }
}
