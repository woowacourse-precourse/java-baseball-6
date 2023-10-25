package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

  private static final int MAX_NUMBER = 9;
  private static final int MIN_NUMBER = 1;
  private static final int NUMBER_LENGTH = 3;

  /**
   * 컴퓨터의 랜덤 숫자를 생성하는 메소드.
   *
   * @return 생성된 숫자를 담은 리스트
   */
  public List<Integer> generateNumbers() {
    List<Integer> numbers = new ArrayList<>();
    while (numbers.size() < NUMBER_LENGTH) {
      // 1부터 9 사이의 랜덤한 숫자 생성
      int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

      // 생성된 숫자가 computer 리스트에 이미 존재하지 않는 경우에만 추가
      if (!numbers.contains(randomNumber)) {
        numbers.add(randomNumber);
      }
    }
    return numbers;
  }
}