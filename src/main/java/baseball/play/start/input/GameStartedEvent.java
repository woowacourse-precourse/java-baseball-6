package baseball.play.start.input;

public class GameStartedEvent {
  private final ValidatedInputNum inputNum;
  private final String randomNums;

  private GameStartedEvent(ValidatedInputNum inputNum, String randomNums) {
    this.inputNum = inputNum;
    this.randomNums = randomNums;
  }

  public static GameStartedEvent of(ValidatedInputNum inputNum, String randomNums) {
    return new GameStartedEvent(inputNum, randomNums);
  }

  public ValidatedInputNum getInputNum() {
    return inputNum;
  }

  public String getRandomNums() {
    return randomNums;
  }
}
