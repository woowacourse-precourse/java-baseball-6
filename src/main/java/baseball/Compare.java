package baseball;

import baseball.dto.BallAndStrike;

import java.util.List;

public class Compare {

    public BallAndStrike makeBallAndStrikeData(List<Integer> userInput, List<Integer> answer){
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
        BallAndStrike data = new BallAndStrike(ball,strike);
        return data;
    }

}
