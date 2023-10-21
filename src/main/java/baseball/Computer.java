package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int ANSWER_DIGIT = 3;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    private static List<Integer> answer;

    public Computer(){
    }

    public List<Integer> makeRandomAnswer(){
        answer = new ArrayList<>();

        while(answer.size() < ANSWER_DIGIT){
            int randomNum = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);

            if(!answer.contains(randomNum)){
                answer.add(randomNum);
            }
        }

        return answer;
    }
}
