package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
  public List<Integer> generateNumbers() {
    List<Integer> numbers = new ArrayList<>();
    while (numbers.size() < 3) {
      // 1부터 9 사이의 랜덤한 숫자 생성
      int randomNumber = Randoms.pickNumberInRange(1, 9);

      // 생성된 숫자가 computer 리스트에 이미 존재하지 않는 경우에만 추가
      if (!numbers.contains(randomNumber)) {
        numbers.add(randomNumber);
      }
    }
//    System.out.println("Computer Class에서 생성된 컴퓨터 숫자 : " + numbers);
    // 1부터 9까지 서로 다른 임의의 숫자 3개를 생성하여 numbers 리스트에 추가
    return numbers;
  }
}

