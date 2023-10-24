package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class Computer {

  private final int randomNumber;

  public Computer() {
    this.randomNumber = Integer.parseInt(generateRandomNumber());
  }

  public int getRandomNumber() {
    return randomNumber;
  }

  public String generateRandomNumber() {
    Set<Integer> computer = new HashSet<>();
    StringBuilder computerRandom = new StringBuilder();
    while (computer.size() < 3) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (computer.add(randomNumber)) {
        computerRandom.append(randomNumber);
      }
    }
    return computerRandom.toString();
  }

}