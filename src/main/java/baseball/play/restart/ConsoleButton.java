package baseball.play.restart;

public enum ConsoleButton {
  RESTART("1"),
  QUIT("2");
  private final String button;

  ConsoleButton(String button) {
    this.button = button;
  }

  static ConsoleButton of(String input) {
    if(RESTART.isSame(input)) {
      return RESTART;
    }
    return QUIT;
  }

  public boolean isSame(String input) {
    return button.equals(input);
  }

  public boolean isRestart() {
    return this == RESTART;
  }

  public boolean isQuit() {
    return this == QUIT;
  }
}
