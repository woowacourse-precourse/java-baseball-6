package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CreateGameNumber {
    private final int number = 3;
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
