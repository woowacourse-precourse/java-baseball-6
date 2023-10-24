package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Score {

  /**
   * 플레이어의 숫자와 컴퓨터의 숫자를 비교하여 볼과 스트라이크의 개수를 계산하는 메소드.
   *
   * @param playerNumbers   플레이어가 선택한 숫자를 담은 리스트
   * @param computerNumbers 컴퓨터가 생성한 숫자를 담은 리스트
   * @return 볼과 스트라이크의 개수를 담은 int 배열. 배열의 첫 번째 요소는 볼의 개수, 두 번째 요소는 스트라이크의 개수
   * <p>
   * 볼의 개수는 플레이어가 선택한 숫자 중 컴퓨터의 숫자와 일치하지만 위치가 다른 숫자의 개수이다. 스트라이크의 개수는 플레이어가 선택한 숫자 중 컴퓨터의 숫자와 숫자와
   * 위치가 모두 일치하는 숫자의 개수이다.
   */
  public int[] calculateScore(List<Integer> playerNumbers, List<Integer> computerNumbers) {
    int ballCount = 0;
    int strikeCount = 0;

    Set<Integer> computerNumberSet = new HashSet<>(computerNumbers);

    for (int i = 0; i < computerNumbers.size(); i++) {
      if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
        strikeCount++;
      } else if (computerNumberSet.contains(playerNumbers.get(i))) {
        ballCount++;
      }
    }

    return new int[]{ballCount, strikeCount};
  }
}
