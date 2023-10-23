package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import static model.BaseballData.*;

public class BaseballNumber {
    /**
     * 컴퓨터 숫자 생성
     */
    public static List<Integer> makeBaseballNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < MAX_HIT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
