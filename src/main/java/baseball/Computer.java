package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * 객체 생성시 랜덤숫자 3개를 부여하고, 유저 입력 숫자3개를 받아 스트라이크, 볼 개수를 판정하여 반환
 */
public class Computer {
    private final List<Integer> computerNumbers = new ArrayList<>();

    public Computer() { // 랜덤숫자 3개 부여
        int numLengthLimit = 3;
        while (computerNumbers.size() < numLengthLimit) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    public int strikeCheck(List<Integer> userInput) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumbers.get(i).equals(userInput.get(i))) {
                count++;
            }
        }
        return count;
    }

    public int ballCheck(List<Integer> userInput) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumbers.contains(userInput.get(i))) {
                count++;
            }
        }
        return count;
    }
}