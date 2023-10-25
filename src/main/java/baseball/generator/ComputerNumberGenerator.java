package baseball.generator;

import baseball.constant.GameConstant;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumberGenerator {
    public List<Integer> makeUniqueNumbers(){
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size()< GameConstant.GAME_DIGIT.getValue()){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computerNumbers.contains(randomNumber))
                computerNumbers.add(randomNumber);
        }
        return computerNumbers;
    }
}