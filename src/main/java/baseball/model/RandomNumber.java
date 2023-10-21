package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    private static final int START_NUMBER=1;
    private static final int END_NUMBER=9;
    private static final int COMPUTER_COUNT=3;
    private static List<Integer> computerRandomNumber;

    public RandomNumber() {
        ComputerRandomNumber();
    }


    private void ComputerRandomNumber() {
        computerRandomNumber = new ArrayList<>();
        while(computerRandomNumber.size()<COMPUTER_COUNT){
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER,END_NUMBER);
            if(!computerRandomNumber.contains(randomNumber)){
                computerRandomNumber.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerRandomNumber() {
        return computerRandomNumber;
    }
}
