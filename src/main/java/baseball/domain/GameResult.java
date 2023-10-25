package baseball.domain;

import java.util.List;

public class GameResult {

    private int ball = 0;
    private int strike = 0;


    public GameResult(Computer computer, Player player) {
        List<Integer> computerNumbers = computer.getComputerNumbers();
        List<Integer> playerNumbers = player.getPlayerNumbers();

        for(int i = 0 ; i < 3 ; i++){
            if(isNowNumStrike(computerNumbers.get(i), playerNumbers.get(i))){
                strike++;
            }
            else if(isNowNumBall(computerNumbers, playerNumbers.get(i))){
                ball++;
            }
        }
    }

    private static boolean isNowNumStrike(Integer computerNumberNow, Integer playerNumberNow) {
        return computerNumberNow == playerNumberNow;
    }

    private static boolean isNowNumBall(List<Integer> computerNumbers, Integer playerNumberNow) {
        return computerNumbers.contains(playerNumberNow);
    }

    public boolean isRight() {
        return strike == 3;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
