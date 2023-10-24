package baseball.play.start.create;

public class InputCommands {
  private final String randomNums;

  private InputCommands(String randomNums) {
    this.randomNums = randomNums;
  }

  public static InputCommands of(String randomNums) {
    return new InputCommands(randomNums);
  }

  public String getRandomNums() {
    return randomNums;
  }
}
