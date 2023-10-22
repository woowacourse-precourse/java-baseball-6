package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> computerNumbers = new ArrayList<>();

    public Computer() { // 랜덤숫자 3개 부여
        while(computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }
    public int strikeCheck(List<Integer> userInput) {
        int count = 0;
        for(int i = 0; i < 3; i++) {
            if(computerNumbers.get(i).equals(userInput.get(i))) {
                count++;
            }
        }
        return count;
    }
    public int ballCheck(List<Integer> userInput) {
        int count = 0;
        for(int i = 0; i < 3; i++) {
            if(computerNumbers.contains(userInput.get(i))) {
                count++;
            }
        }
        return count;
    }
}