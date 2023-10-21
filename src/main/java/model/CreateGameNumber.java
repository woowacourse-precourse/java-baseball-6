package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CreateGameNumber {
    private final int number = 3;

    /**
     * 컴퓨터가 각각 다른 3자리 숫자를 랜덤으로 생성해주는 기능
     * 숫자 3개를 생성한 후 List로 리턴
     */
    public List<Integer> createNum(){
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < number) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
