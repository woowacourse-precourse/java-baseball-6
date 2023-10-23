package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameCreateContext {

  public static InputCommands inputCommand() {
    RandomNumberCreateCommands createCommands = createRandomNumberCommand();
    return new InputCommands(createRandomNumbs(createCommands));
  }

  private static RandomNumberCreateCommands createRandomNumberCommand() {
    return new RandomNumberCreateCommands(1, 9, 3, new ArrayList<>());
  }

  private static String createRandomNumbs(RandomNumberCreateCommands createCommands) {
    List<Integer> randomNums = createCommands.getRandomNums();
    while (randomNums.size() < createCommands.getLimit()) {
      int randomNumber = Randoms.pickNumberInRange(createCommands.getStartNum(), createCommands.getEndNum());
      if (!randomNums.contains(randomNumber)) {
        randomNums.add(randomNumber);
      }
    }
    return randomNums.stream().map(String::valueOf).collect(Collectors.joining());
  }
}
