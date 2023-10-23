package baseball.model;

import java.util.List;

public class Referee {
    private Integer strike;
    private Integer ball;

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }

    public void compareNumbers(List<Integer> computerNumber, List<Integer> playerNumber){
        int strikeCount = 0;
        int ballCount = 0;
        for(int i=0; i<3; i++){
            strikeCount += confirmStrike(computerNumber.get(i), playerNumber.get(i));
            ballCount += confirmBall(computerNumber.get(i), playerNumber.get(i), playerNumber);
        }
        strike = strikeCount;
        ball = ballCount;
    }

    public int confirmStrike(int computerNumber, int playerNumber){
        return computerNumber == playerNumber ? 1 : 0;
    }

    public int confirmBall(int computerNumber, int playerNumber, List<Integer> playerNumbers) {
        if(computerNumber != playerNumber && playerNumbers.contains(computerNumber)){
            return 1;
        }
        return 0;
    }
}
