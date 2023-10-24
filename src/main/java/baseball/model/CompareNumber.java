package baseball.model;

import java.util.ArrayList;
import java.util.HashMap;

public class CompareNumber {

    private int strike;
    private int ball;

    private final HashMap<Integer, String> computerNumberMap = new HashMap<>();
    private final HashMap<Integer, String> playerNumberMap = new HashMap<>();


    public CompareNumber(String playerNumber, ArrayList<String> computerNumber){
        strike = 0; ball = 0;

        for(int i = 0; i < computerNumber.size(); i++) {
            computerNumberMap.put(i, computerNumber.get(i));
            playerNumberMap.put(i, playerNumber.substring(i, i+1));
        }

        CountBall(playerNumberMap, computerNumberMap);
        CountStrike(playerNumberMap, computerNumberMap);
        ExceptBallInStrike();
    }

    private void ExceptBallInStrike() {
        ball = ball - strike;
    }

    private void CountBall(HashMap<Integer, String> playerNumberMap, HashMap<Integer, String> computerNumberMap){
        // 다른자리에 숫자가 있는경우 +1
        for(int i = 0; i < computerNumberMap.size(); i++){
            if(playerNumberMap.containsValue(computerNumberMap.get(i))) ball++;
        }
    }

    private void CountStrike(HashMap<Integer, String> playerNumberMap, HashMap<Integer, String> computerNumberMap){
        for(int i = 0; i < computerNumberMap.size(); i++){
            if(playerNumberMap.get(i).equals(computerNumberMap.get(i))) strike++;
        }
    }

    public boolean IsThreeStrike(int strike){
        if(strike == 3) return true;
        else {
            return false;
        }
    }

    public int getStrike(){
        return strike;
    }

    public int getBall() {
        return ball;
    }

}
