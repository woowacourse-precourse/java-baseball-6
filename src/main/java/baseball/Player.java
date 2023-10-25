package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Player {

  private String input;

  public Player() {
  }

  public void setInput(String input) {
    this.input = input;
  }

  public boolean isReGame() {
    return input.equals("1");
  }

  private boolean isDuplicate(String input) {
    return input.chars()
        .mapToObj(ch -> (char) ch)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .values()
        .stream()
        .anyMatch(count -> count > 1);
  }

  public boolean userInputNumbers(final int[] flag) {
    String input = Console.readLine();
    setInput(input);
    return validateNumericInput(input, flag);
  }

  public boolean validateNumericInput(String input, final int[] flag) {
    if (input.length() != flag[0]) {
      return false;
    }
    for (Character ch : input.toCharArray()) {
      if (ch < '0' || ch > flag[1] + '0') {
        return false;
      }
    }
    return !isDuplicate(input);
  }

  public boolean checkSwingResult(int correctNumber, int index) {
    return correctNumber == input.charAt(index) - '0';
  }

  public boolean findBallAfterSwing(String numbers, int index) {
    return numbers.contains(String.valueOf(input.charAt(index)));
  }
}
