package baseball.play.start.input;

public class ValidatedInputNum {

  private final String input;

  private ValidatedInputNum(String input) {
    this.input = input;
  }

  public static ValidatedInputNum of(String input) {
    if (input.length() != 3 || !input.matches("[1-9]+") || input.chars().distinct().count() != 3) {
      throw new IllegalArgumentException();
    }

    return new ValidatedInputNum(input);
  }

  public String getInput() {
    return input;
  }
}
