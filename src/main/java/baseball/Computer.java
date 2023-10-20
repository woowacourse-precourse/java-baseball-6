package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public List<Integer> makeComputerNumbers(){
        List<Integer> computerNumbers = new ArrayList<>();
        int digit = 3;
        while (computerNumbers.size()< digit){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computerNumbers.contains(randomNumber))
                computerNumbers.add(randomNumber);
        }
        return computerNumbers;
    }
}