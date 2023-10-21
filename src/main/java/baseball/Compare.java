package baseball;

import baseball.dto.BallAndStrikeData;

import java.util.List;

public class Compare {

    public BallAndStrikeData getBallAndStrikeData(List<Integer> userInput, List<Integer> answer){
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
