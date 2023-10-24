package baseball.play.restart;

public class ValidatedCommandButton {

  private final ConsoleButton button;

  private ValidatedCommandButton(ConsoleButton button) {
    this.button = button;
  }

  public static ValidatedCommandButton of(String input) {
    if (ConsoleButton.RESTART.isSame(input) && ConsoleButton.QUIT.isSame(input)) {
      throw new IllegalArgumentException();
    }
    return new ValidatedCommandButton(ConsoleButton.of(input));
  }

  public boolean isRestart() {
    return button.isRestart();
  }

  public boolean isQuit() {
    return button.isQuit();
  }
}
