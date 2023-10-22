package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameUtils {
    private static final int RANDOM_NUMBERS = 3;
    public static List<Integer> generateRandomNumber(){
        List<Integer> answer = new ArrayList<>();
        while(answer.size()<RANDOM_NUMBERS){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!answer.contains(randomNumber)){
                answer.add(randomNumber);
            }
        }
        return answer;
    }

}
