package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    public List<Integer> createRandomNumbers() {
        // 서로 다른 수 3개를 뽑아야 한다.
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size()<3) {  // 3개의 숫자가 담길 때까지
            int number = Randoms.pickNumberInRange(1,9);
            if (!numbers.contains(number)) {    // 만약 존재하지 않는 숫자라면 담는다.
                numbers.add(number);
            }   // 만약 이미 존재하는 숫자라면 담지 않는다.
        }
        return numbers;
    }
}
