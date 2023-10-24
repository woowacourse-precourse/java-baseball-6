package baseball.play.start.create;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class GameCreateContext {

  public static InputCommands inputCommand(RandomNumberCreateCommands createCommands) {
    return InputCommands.of(createRandomNumbs(createCommands));
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
