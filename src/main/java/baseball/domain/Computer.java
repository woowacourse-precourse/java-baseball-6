package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {
    private final static int START_RANGE_GENERATE_NUM = 1;
    private final static int END_RANGE_GENERATE_NUM = 9;
    private final static int COUNT = 3;
    private List<Integer> computerNumber = new ArrayList<>();

    public Computer() {
        makeComputerNumber();
    }

    private void makeComputerNumber(){
        while(computerNumber.size() < COUNT){
            int randomNumber = Randoms.pickNumberInRange(START_RANGE_GENERATE_NUM,END_RANGE_GENERATE_NUM);
            if(!computerNumber.contains(randomNumber)){
                computerNumber.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

}
