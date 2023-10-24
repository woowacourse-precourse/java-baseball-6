package baseball.play.restart;

public class CommandButtonResult<R, Q>{
  private final R restart;
  private final Q quit;

  private CommandButtonResult(R restart, Q quit) {
    this.restart = restart;
    this.quit = quit;
  }

  public static <R, Q> CommandButtonResult<R, Q> restart(R restart) {
    return new CommandButtonResult<>(restart, null);
  }

  public static <R, Q> CommandButtonResult<R, Q> quit(Q quit) {
    return new CommandButtonResult<>(null, quit);
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
