package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import static baseball.Utils.*;

public class Computer {
    private int[] numbers;

    public Computer() {
        this.numbers = getRandomComputerNumber();
    }

    public int[] getNumbers() {
        return numbers;
    }

    private int[] getRandomComputerNumber(){
        int[] numbers;

        // 같은 수가 나올 경우 다시 랜덤돌리기
        do {
            numbers = new int[]{
                    Randoms.pickNumberInRange(1, 9),
                    Randoms.pickNumberInRange(1, 9),
                    Randoms.pickNumberInRange(1, 9)
            };
        }
        while (isDuplication(numbers));

        return numbers;
    }
}
