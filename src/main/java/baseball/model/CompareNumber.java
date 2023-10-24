package baseball.model;

import java.util.ArrayList;

// hash를 사용하는 자료구조로 변경
public class CompareNumber {

    private int strike;
    private int ball;

    public CompareNumber(String playerNumber, ArrayList<String> computerNumber){
        strike = 0; ball = 0;
        CountBall(playerNumber, computerNumber);
        CountStrike(playerNumber, computerNumber);
        ExceptBallInStrike();
    }

    private void ExceptBallInStrike() {
        ball = ball - strike;
    }

    public void CountBall(String p, ArrayList<String> c){
        // 다른자리에 숫자가 있는경우 +1
        for(String num : c){
            if(p.contains(num)) ball++;
        }
    }

    public void CountStrike(String p, ArrayList<String> c){
        for(String num : c){
            if(p.indexOf(num) == c.indexOf(num)) strike++;
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
