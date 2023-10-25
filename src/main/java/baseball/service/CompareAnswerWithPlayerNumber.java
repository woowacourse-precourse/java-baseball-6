package baseball.service;

import java.util.List;

public class CompareAnswerWithPlayerNumber {
    private int strike;
    private int ball;


    public void compareStrikeBall(List<Integer> player, List<Integer> computer) {
        clearStrikeBall();
        compareStrike(player, computer);
        compareBall(player, computer);
    }

    public void compareStrike(List<Integer> player, List<Integer> computer) {
        for (int i = 0; i < player.size(); i++) {
            if (player.get(i).equals(computer.get(i))) {
                strike++;
            }
        }
    }

    public void compareBall(List<Integer> player, List<Integer> computer) {
        for (int i = 0; i < player.size(); i++) {
            if (computer.contains(player.get(i)) && computer.get(i) != player.get(i)) {
                ball++;
            }
        }
    }

    public void clearStrikeBall() {
        strike = 0;
        ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
