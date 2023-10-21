package baseball.model;

import java.util.List;

public class Referee {

    private Integer strike;
    private Integer ball;

    public void duplicateNumbers(List<Integer> computerNumber, List<Integer> playerNumber){
        int strikeCount = 0;
        int ballCount = 0;
        for(int i=0; i<3; i++){
            strikeCount += duplicateStrike(computerNumber.get(i), playerNumber.get(i));
            ballCount += duplicateBall(computerNumber.get(i), playerNumber.get(i), playerNumber);
        }
    }
}
