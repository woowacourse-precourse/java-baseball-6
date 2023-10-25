package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameNumberGenerator {
    private final int NUMBER = 3;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;

    /**
     * 컴퓨터가 각각 다른 3자리 숫자를 랜덤으로 생성해주는 기능
     * 숫자 3개를 생성한 후 List로 리턴
     */
    public List<Integer> createNum(){
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
