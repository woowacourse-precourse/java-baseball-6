package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Integer> input;
    private List<Integer> answer;

    public String judgeGame(int num){
        int strike = 0;
        int ball = 0;

        String result="NULL";
        return result;
    }

    public void createAnswer() {
        answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

}
