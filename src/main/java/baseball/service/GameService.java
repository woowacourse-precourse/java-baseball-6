package baseball.service;

import baseball.dto.Result;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    public void init() {

    }

    public List<Integer> createAnswer() {
        List<Integer> answer = new ArrayList<>();

        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    public List<Integer> getInput() {
        return null;
    }


    public Result compare(List<Integer> answer, List<Integer> userInput) {
        return null;
    }

    public boolean isWin(Result result) {
        return false;
    }

    public boolean isGameEnd() {
        return false;
    }

    public void setGameEnd() {

    }
}
