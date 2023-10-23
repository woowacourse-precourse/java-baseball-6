package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class GameManager {

    private List<Integer> gameAnswer;

    public void initGameAnswer() {
        gameAnswer = new ArrayList<>();
        
        while (gameAnswer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!gameAnswer.contains(randomNumber)) {
                gameAnswer.add(randomNumber);
            }
        }
    }

    public char[] generateHint(List<Integer> userInput) {
        char[] hintArr = new char[4];

        if(isNothing(userInput)) {
            hintArr[0] = 'N';
        }else {
            hintArr[0] = 'P';

            for (int idx = 0; idx < 3; idx++) {
                hintArr[idx+1] = isStrikeOrBall(userInput.get(idx), idx);
            }
        }

        return hintArr;
    }

    public char isStrikeOrBall(Integer userInput, int idx) {
        if(gameAnswer.contains(userInput)) {
            if(gameAnswer.get(idx) == userInput) {
                return 'S';
            }
            return 'B';
        }
        return 'X';
    }

    public boolean isNothing(List<Integer> userInput) {
        int len = userInput.size();
        boolean flag = true;

        for(int idx=0; idx < len; idx++) {
            if(gameAnswer.contains(userInput.get(idx))) {
                flag = false;
                break;
            }
        }

        return flag;
    }

    public boolean isAnswer(List<Integer> userInput) {
        int len = userInput.size();
        boolean flag = true;

        for(int idx=0; idx < len; idx++) {
            if(gameAnswer.get(idx) != userInput.get(idx)) {
                flag = false;
                break;
            }
        }

        return flag;
    }

    public boolean isReStart(String userInput) {
        return (userInput.equals("1")) ? true : false;
    }
}
