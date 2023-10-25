package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int LEN_NUM = 3;

    private List<Integer> numbers;

    public Computer() {
        numbers = new ArrayList<>();
    }

    // 각 자리 수가 모두 다른 숫자인지 중복 확인하며 세 자리수 생성
    public void generateNumber() {
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }
}