package baseball.model;

import java.util.List;

public class CompareNumber {
    private int strike;
    private int ball;
    public int[] getResult(List<Integer> playerNumber, List<Integer> computerNumber){
        ballCounter(playerNumber, computerNumber);
        StrikeCounter(playerNumber, computerNumber);
        return new int[]{ball, strike};
    }

    public void ballCounter(List<Integer> playerNumber, List<Integer> computerNumber){
        ball = 0;
        for (int i = 0; i<playerNumber.size(); i++){
            if(computerNumber.contains(playerNumber.get(i))){
                ball++;
            }
        }
    }

    public void StrikeCounter(List<Integer> playerNumber, List<Integer> computerNumber){
        strike = 0;
        for (int i = 0; i<playerNumber.size(); i++){
            if (computerNumber.get(i) == playerNumber.get(i)){
                strike++;
            }
        }
        ball = ball - strike;
    }
}
