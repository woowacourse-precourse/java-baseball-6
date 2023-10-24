package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ComputerBalls {

  /**
   * Returns randomly generated 3-digit number.
   *
   * @return the String type of randomly generated numbers
   */
  public static String getComputerBalls() {
    Set<Integer> computer = new HashSet<>();
    while (computer.size() < 3) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      computer.add(randomNumber);
    }
    return computer.stream()
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}
