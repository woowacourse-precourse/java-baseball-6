package baseball;

import java.util.List;

public class RandomNumberCreateCommands {
  private final int startNum;
  private final int endNum;

  private final int limit;

  private final List<Integer> randomNums;

  public RandomNumberCreateCommands(int startNum, int endNum, int limit, List<Integer> randomNums) {
    this.startNum = startNum;
    this.endNum = endNum;
    this.limit = limit;
    this.randomNums = randomNums;
  }

  public int getStartNum() {
    return startNum;
  }

  public int getEndNum() {
    return endNum;
  }

  public int getLimit() {
    return limit;
  }

  public List<Integer> getRandomNums() {
    return randomNums;
  }
}
