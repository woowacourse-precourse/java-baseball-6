package baseball.play.start;

public class RestartConfirmationCommand {

  private final int start;
  private final int end;

  private final int limit;

  private RestartConfirmationCommand(int start, int end, int limit) {
    this.start = start;
    this.end = end;
    this.limit = limit;
  }

  public static RestartConfirmationCommand of(int start, int end, int limit) {
    return new RestartConfirmationCommand(start, end, limit);
  }

  public int getStart() {
    return start;
  }

  public int getEnd() {
    return end;
  }

  public int getLimit() {
    return limit;
  }
}
