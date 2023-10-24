package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Computer {

    private final int digits;

    public Computer(int digitNumber) {
        this.digits = digitNumber;
    }

    /**
     * 다음을 만족하는 임의의 수를 생성한다.
     *
     * <p>1. 임의의 수는 서로 다른 수이다.<br>
     * 2. 임의의 수의 각 자리수는 0이 아닌 자연수이다.
     *
     * @return 생성된 임의의 수
     */
    public int generateRandomNumbers() {
        if (digits < 1 || digits > 8) {
            throw new IllegalArgumentException();
        }
        ArrayList<Integer> selectedNumbers = new ArrayList<>();

        while (selectedNumbers.size() < digits) {
            int n = Randoms.pickNumberInRange(1, 9);

            if (!selectedNumbers.contains(n)) {
                selectedNumbers.add(n);
            }
        }

        return selectedNumbers.stream()
                .mapToInt(Integer::intValue)
                .reduce(0, (a, b) -> a * 10 + b);
    }
}
