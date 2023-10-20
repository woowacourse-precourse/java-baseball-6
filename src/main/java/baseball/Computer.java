package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public List<Integer> makeNewNumber(){
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    public BallAndStrikeData compareUserInputAndAnswer(List<Integer> userInput, List<Integer> answer){
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < userInput.size(); i++) {
            if (userInput.get(i).equals(answer.get(i))) {
                strike++;
            }
            else if (answer.contains(userInput.get(i))) {
                ball++;
            }
        }
        BallAndStrikeData data = new BallAndStrikeData(ball,strike);
        return data;
    }


}
