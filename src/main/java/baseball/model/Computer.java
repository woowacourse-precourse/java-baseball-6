package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> randomNumbers;

    /**
     * 입력한 크기에 맞추어 랜덤 숫자 배열을 생성한다.
     *
     * @param size
     */
    public Computer(int size) {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        this.randomNumbers = randomNumbers;
    }

    /**
     * @return 컴퓨터의 랜덤 숫자를 반환한다.
     */
    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }
}
