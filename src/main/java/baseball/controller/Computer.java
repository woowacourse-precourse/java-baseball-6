package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerRandomNumbers = new ArrayList<>();

    public List<Integer> getRandomComputerNumber(){
        setTargetNumber();
        return computerRandomNumbers;
    }
    private void setTargetNumber(){
        while(computerRandomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerRandomNumbers.contains(randomNumber)) {
                computerRandomNumbers.add(randomNumber);
            }
        }
    }
}
