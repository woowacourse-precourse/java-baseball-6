package baseball;

import java.util.List;

public class Score {

  public int[] calculateScore(List<Integer> playerNumbers, List<Integer> computerNumbers) {
    int ballCount = 0;
    int strikeCount = 0;
    System.out.println("bc, sc 초기화");
    // 플레이어의 입력과 컴퓨터의 숫자를 비교하여 볼과 스트라이크 개수를 계산
    for (int i = 0; i < computerNumbers.size(); i++) {
      if (computerNumbers.get(i) == playerNumbers.get(i)) {
        strikeCount++;
      }
    }
    for (int i = 0; i < computerNumbers.size(); i++) {
      if (computerNumbers.contains(playerNumbers.get(i))
          && computerNumbers.get(i) != playerNumbers.get(i)) {
        ballCount++;
      }
    }
    return new int[]{ballCount, strikeCount};
  }
}