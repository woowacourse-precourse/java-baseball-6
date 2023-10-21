package baseball;

import static baseball.Constants.*;

import java.util.ArrayList;

public class GameProcessor {


    public int[] getCompareTwoAnswerResult(ArrayList<Integer> playerAnswer,
            ArrayList<Integer> computerAnswer) {
        int[] result = new int[2];
        int playerOrder = 0;
        for (Integer playerValue : playerAnswer) {
            int computerOrder = 0;
            for (Integer computerValue : computerAnswer) {
                if (playerValue == computerValue && playerOrder == computerOrder) {
                    result[STRIKE_NUMBER]++;
                }
                if (playerValue == computerValue && playerOrder != computerOrder) {
                    result[BALL_NUMBER]++;
                }
                computerOrder++;
            }
            playerOrder++;
        }

        return result;
    }

    public void printScore(Score score) {
        if (score.getBall() > 0 && score.getStrike() > 0) {
            System.out.println(score.getBall() + "볼 " + score.getStrike() + "스트라이크");
        }
        if (score.getBall() > 0 && score.getStrike() == 0) {
            System.out.println(score.getBall() + "볼");
        }
        if (score.getBall() == 0 && score.getStrike() > 0) {
            System.out.println(score.getStrike() + "스트라이크");
        }
        if (score.getBall() == 0 && score.getStrike() == 0) {
            System.out.println("낫싱");
        }
    }


}
