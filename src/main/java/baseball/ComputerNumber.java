package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class ComputerNumber {
    private final Map<Integer, Integer> value;

    public ComputerNumber() {
        this.value = new HashMap<>();
    }

    public Map<Integer, Integer> getValue() {
        return value;
    }
    
    /**
     * 컴퓨터 랜덤 수 생성 기능
     */
    public void createComputerNumber() {
        int i = 1;
        while (getValue().size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!value.containsValue(randomNumber)) {
                value.put(i, randomNumber);
                i++;
            }
        }
    }

}
