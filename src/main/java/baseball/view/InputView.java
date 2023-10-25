package baseball.view;

import baseball.domain.SingleDigitNumber;
import baseball.domain.BallNumbers;
import baseball.utils.Validator;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

  public BallNumbers readUserNumber() {
    System.out.print("숫자를 입력해주세요: ");
    String input = Console.readLine();

    String errorMessage = Validator.validateInput(input);
    if (errorMessage != null) {
      throw new IllegalArgumentException(errorMessage);
    }

    return parseInput(input);
  }

  private BallNumbers parseInput(String input) {
    List<SingleDigitNumber> numbers = new ArrayList<>();
    for (char ch : input.toCharArray()) {
      int num = Character.getNumericValue(ch);
      numbers.add(new SingleDigitNumber(num));
    }

    return new BallNumbers(numbers);
  }

  public int readPlayAgainChoice() {
    OutputView.printAskPlayAgain();
    String input = Console.readLine();

    if (!Validator.isValidChoice(input)) {
      throw new IllegalArgumentException("1 또는 2만 입력할 수 있습니다.");
    }

    return Integer.parseInt(input);
  }
}