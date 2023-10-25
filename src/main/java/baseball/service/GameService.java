package baseball.service;

import baseball.domain.BallNumbers;
import baseball.domain.Result;
import baseball.domain.SingleDigitNumber;
import baseball.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class GameService {

  private final RandomNumberGenerator randomNumberGenerator;
  private BallNumbers computerNumber;

  public GameService() {
    this.randomNumberGenerator = new RandomNumberGenerator();
  }

  public void generateComputerNumber() {
    List<SingleDigitNumber> numbers = new ArrayList<>();
    List<Integer> randomNumbers = randomNumberGenerator.generateUniqueNumbers();
    for (int number : randomNumbers) {
      numbers.add(new SingleDigitNumber(number));
    }

    this.computerNumber = new BallNumbers(numbers);
  }

  public Result compare(BallNumbers userNumber) {
    int balls = 0;
    int strikes = 0;

    for (int i = 0; i < 3; i++) {
      SingleDigitNumber currentNumber = userNumber.getNumberAt(i);
      if (computerNumber.getNumberAt(i).equals(currentNumber)) {
        strikes++;
      } else if (isBall(currentNumber)) {
        balls++;
      }
    }

    return new Result(balls, strikes);
  }

  private boolean isBall(SingleDigitNumber number) {
    for (int i = 0; i < 3; i++) {
      if (computerNumber.getNumberAt(i).equals(number)) {
        return true;
      }
    }
    return false;
  }

  public boolean isGameWon(Result result) {
    return result.isGameWon();
  }
}
