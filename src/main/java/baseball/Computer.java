package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class Computer {
    private static final int ANSWER_DIGIT = 3;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    private static Map<Integer, Integer> answer;

    public Computer(){
    }

    public Map<Integer, Integer> makeRandomAnswer(){
        answer = new HashMap<>();
        int order = 0;

        while(answer.size() < ANSWER_DIGIT){
            int randomNum = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);

            if(!answer.containsKey(randomNum)){
                answer.put(randomNum, order);
                order++;
            }
        }

        return answer;
    }
}
