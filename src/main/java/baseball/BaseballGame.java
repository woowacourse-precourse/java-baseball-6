package baseball;

import java.util.List;

public class BaseballGame {

  private final List<Integer> randomNumbers;
  private final CheckAnswer checkAnswer;

  public BaseballGame() {
    this.randomNumbers = GenerateAnswer.generate();
    this.checkAnswer = new CheckAnswer();
  }

  public String playRound(List<Integer> playerInput) {
    return checkAnswer.check(randomNumbers, playerInput);
  }
}
