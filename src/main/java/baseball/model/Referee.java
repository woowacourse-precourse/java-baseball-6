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

    public void duplicateNumbers(List<Integer> computerNumber, List<Integer> playerNumber){
        int strikeCount = 0;
        int ballCount = 0;
        for(int i=0; i<3; i++){
            strikeCount += duplicateStrike(computerNumber.get(i), playerNumber.get(i));
            ballCount += duplicateBall(computerNumber.get(i), playerNumber.get(i), playerNumber);
        }
        strike = strikeCount;
        ball = ballCount;
    }

    public int duplicateStrike(int computerNumber, int playerNumber){
        if(computerNumber == playerNumber){
            return 1;
        }
        return 0;
    }

    private int duplicateBall(int computerNumber, int playerNumber, List<Integer> playerNumbers) {
        if(computerNumber != playerNumber && playerNumbers.contains(computerNumber)){
            return 1;
        }
        return 0;
    }
}
