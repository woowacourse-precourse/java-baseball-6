package baseball.gameLogic;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.models.Constants.*;

public class RandomNumberGenerator {
    public List<Integer> generateRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < ANSWER_LENGTH){
            int randomNumber = Randoms.pickNumberInRange(USER_ANSWER_LOWER_LIMIT, USER_ANSWER_UPPER_LIMIT);
            if (!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
