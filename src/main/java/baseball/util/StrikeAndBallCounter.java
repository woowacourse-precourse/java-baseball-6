package baseball.util;

import baseball.constant.GameConstant;
import java.util.ArrayList;
import java.util.List;

public class StrikeAndBallCounter {

    public static List<Integer> countStrikeAndBall(List<Integer> playerInput, List<Integer> computerGameNumber) {
        List<Integer> strikeAndBall = new ArrayList<>();
        strikeAndBall.add(getStrike(playerInput, computerGameNumber));
        strikeAndBall.add(getBall(playerInput, computerGameNumber));

        return strikeAndBall;
    }

    private static Integer getStrike(List<Integer> playerInput, List<Integer> computerGameNumber) {
        int strike = 0;
        for (int i = 0; i < GameConstant.GAME_NUMBER_LENGTH; i++) {
            if (playerInput.get(i).equals(computerGameNumber.get(i))) {
                strike++;
            }
        }

        return strike;
    }

    private static Integer getBall(List<Integer> playerInput, List<Integer> computerGameNumber) {
        int ball = 0;
        for (int i = 0; i < GameConstant.GAME_NUMBER_LENGTH; i++) {
            if (computerGameNumber.contains(playerInput.get(i)) && !computerGameNumber.get(i)
                    .equals(playerInput.get(i))) {
                ball++;
            }
        }

        return ball;
    }
}