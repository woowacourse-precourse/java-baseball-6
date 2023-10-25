package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Game {

  private List<Integer> computerNumbers;

  public Game() {
    computerNumbers = generateRandomNumbers(3, 1, 9);
  }

  private List<Integer> generateRandomNumbers(int count, int min, int max) {
    List<Integer> computer = new ArrayList<>();
    while (computer.size() < count) {
      int randomNumber = Randoms.pickNumberInRange(min, max);
      if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
      }
    }
    return computer;
  }


}