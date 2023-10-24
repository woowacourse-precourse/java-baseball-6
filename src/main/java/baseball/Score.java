package baseball;

import java.util.List;

public class Score {

  /**
   플레이어 숫자와 컴퓨터 숫자를 비교하여 볼과 스트라이크 개수를 계산합니다.
   @param playerNumbers 플레이어의 숫자 목록입니다.
   @param computerNumbers 컴퓨터의 숫자 목록입니다.
   @return 볼 개수는 인덱스 0에, 스트라이크 개수는 인덱스 1에 담긴 정수 배열을 반환합니다. */
  public int[] calculateScore(List<Integer> playerNumbers, List<Integer> computerNumbers) {
    int ballCount = 0;
    int strikeCount = 0;
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