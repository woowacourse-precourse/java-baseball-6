package model;

import static model.BaseballData.MAX_HIT;
import static model.BaseballData.MAX_NUMBER;
import static model.BaseballData.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

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
