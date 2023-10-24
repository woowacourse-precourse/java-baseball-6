package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class RandomNum {
    private final List<Integer> computerNumbers = new ArrayList<>();

    RandomNum() {
        while (computerNumbers.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9); // 1~9 랜덤 수 출력
            if (!computerNumbers.contains(randomNumber)) { // 서로 다른 수
                computerNumbers.add(randomNumber);
            }
        }
        System.out.println(computerNumbers);
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}
