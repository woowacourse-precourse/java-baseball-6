package baseball.domain;

import java.util.List;

public class BaseballGame {
    public GameResult compareNumList(List<String> playerNum, List<String> computerNumber) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < computerNumber.size(); i++) {
            String tempComNum = computerNumber.get(i);
            String tempUserNum = playerNum.get(i);
            if (tempComNum.equals(tempUserNum)) {
                strike++;
            }
            if (!tempComNum.equals(tempUserNum) && computerNumber.contains(tempUserNum)) {
                ball++;
            }
        }
        return new GameResult(ball, strike);
    }
}
