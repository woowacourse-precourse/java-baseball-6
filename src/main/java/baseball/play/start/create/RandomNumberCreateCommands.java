package baseball.play.start.create;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberCreateCommands {
  private final int startNum;
  private final int endNum;

  private final int limit;

  private final List<Integer> randomNums = new ArrayList<>();

  private RandomNumberCreateCommands(int startNum, int endNum, int limit) {
    this.startNum = startNum;
    this.endNum = endNum;
    this.limit = limit;
  }

  public static RandomNumberCreateCommands of(int startNum, int endNum, int limit) {
    return new RandomNumberCreateCommands(startNum, endNum, limit);
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
