package baseball;

import java.util.List;

public class PlayGame {
    public int checkStrike(List<Integer> computerNumberList, List<Integer> playerNumberList) {
        int strike = 0;
        for(int i=0; i<3; i++) {
            if(computerNumberList.get(i).equals(playerNumberList.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public int checkBall(List<Integer> computerNumberList, List<Integer> playerNumberList) {
        int ball = 0;
        for(int i=0; i<3; i++) {
            if(computerNumberList.contains(playerNumberList.get(i)) && !computerNumberList.get(i).equals(playerNumberList.get(i))) {
                ball++;
            }
        }
        return ball;
    }
}
