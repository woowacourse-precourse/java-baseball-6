package baseball.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumberGenerator {
    private static final int DIGIT=3;
    public List<Integer> makeUniqueNumbers(){
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size()< DIGIT){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computerNumbers.contains(randomNumber))
                computerNumbers.add(randomNumber);
        }
        return computerNumbers;
    }
}