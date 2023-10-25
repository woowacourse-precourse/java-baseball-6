package baseball.domain;

import java.util.List;

public class CompareNumber {
    private int strike;
    private int ball;
    private final static int FULL_STRIKE = 3;

    public int[] getResult(List<Integer> playerNumber, List<Integer> computerNumber) {
        ballCounter(playerNumber, computerNumber);
        strikeCounter(playerNumber, computerNumber);
        return new int[]{ball, strike};
    }


    public void ballCounter(List<Integer> playerNumber, List<Integer> computerNumber) {
        ball = 0;
        for (int i = 0; i < playerNumber.size(); i++) {
            if (computerNumber.get(i) != playerNumber.get(i) && computerNumber.contains(playerNumber.get(i))) {
                ball++;
            }
        }
    }

    public void strikeCounter(List<Integer> playerNumber, List<Integer> computerNumber) {
        strike = 0;
        for (int i = 0; i < playerNumber.size(); i++) {
            if (computerNumber.get(i) == playerNumber.get(i)) {
                strike++;
            }
        }
    }

    public static boolean successCheck(int[] result) {
        return result[1] == FULL_STRIKE;
    }
}
