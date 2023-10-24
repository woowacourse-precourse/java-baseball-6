package baseball.play.restart;

public class ValidatedCommandConsole {

  private final String input;

  private ValidatedCommandConsole(String input) {
    this.input = input;
  }

  public static ValidatedCommandConsole of(String input) {
    if (!input.equals("1") && !input.equals("2")) {
      throw new IllegalArgumentException();
    }
    return new ValidatedCommandConsole(input);
  }

  public boolean isRestart() {
    return input.equals("1");
  }

  public boolean isQuit() {
    return input.equals("2");
  }
}
