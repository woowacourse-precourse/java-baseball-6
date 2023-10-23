package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {


  /**
   * 사용자에게 서로 다른 숫자 3개를 입력
   * 문자, 서로 같은 숫자 경우 IllegalArgumentException
   */

  public List<Integer> getInput(String input) throws IllegalArgumentException {
    String[] inputSplit = input.split("");

    if (inputSplit.length != 3) {
      throw new IllegalArgumentException();
    }

    List<Integer> inputNumbers = new ArrayList<>();
    for (String s : inputSplit) {
      inputNumbers.add(Integer.parseInt(s));
    }

    checkDuplicationNumber(inputNumbers);
    return inputNumbers;
  }

  private void checkDuplicationNumber(List<Integer> inputNumbers) {
    Set<Integer> inputNumbersSet = new HashSet<>(inputNumbers);
    if (inputNumbersSet.size() != 3) {
      throw new IllegalArgumentException();
    }
  }

  /**
   * 사용자에게 재시작 여부를 1(재시작), 2(종료)
   * 1, 2 이외의 숫자를 입력한 경우 IllegalArgumentException
   */
  public boolean getRestart(int input) throws IllegalArgumentException {
    if (input == 1) {
      return true;
    } else if (input == 2) {
      return false;
    } else {
      throw new IllegalArgumentException();
    }
  }

}
