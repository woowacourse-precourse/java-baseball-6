package gameUser;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> computerNum;

    public Computer() {
        this.computerNum = pickNumbers();
    }

    public List<Integer> pickNumbers() {
        List<Integer> arr = new ArrayList<>();
        while (arr.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!arr.contains(randomNumber)) {
                arr.add(randomNumber);
            }
        }
        return arr;
    }

    public List<Integer> getComputerNum() {
        return computerNum;
    }

}
