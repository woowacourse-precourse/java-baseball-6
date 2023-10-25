package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int LEN_NUM = 3;
    private int strikeCnt = 0;
    private int ballCnt = 0;
    private boolean isNothing = false;

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
    // 같은 수가 같은 자리에 있으면 "스트라이크"
    // 같은 수가 다른 자리에 있으면 "볼"
    public void count(List<Integer> userNumber) {
        for (int i = 0; i < userNumber.size(); i++) {
            Integer digit = userNumber.get(i);
            Integer target = numbers.get(i);

            if (digit == target) {
                this.strikeCnt += 1;
                continue;
            }

            if (numbers.contains(digit)) {
                this.ballCnt += 1;
            }
        }
    }
}