package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerNumbers = new ArrayList<>();

    public Computer() { // 랜덤숫자 3개 부여
        while(computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }
    public List<Integer> getComputerNumbers() { // get, list반환
        return this.computerNumbers;
    }
}
