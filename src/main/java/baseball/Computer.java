package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Computer {
  List<Integer> randomNumbers = new ArrayList<>();

  public Computer() {
    generateRandomNumbers();
  }

  public void generateRandomNumbers() {
    while (getRandomNumbers().size() < 3) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!getRandomNumbers().contains(randomNumber)) {
        randomNumbers.add(randomNumber);
      }
    }
  }

  public List<Integer> getRandomNumbers() {
    return randomNumbers;
  }

}
