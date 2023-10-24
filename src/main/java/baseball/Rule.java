package baseball;

import java.util.List;

public class Rule {
    private int strike = 0;
    private int ball = 0;

    public void checkPlayerGuess(List<Integer> computer, List<Integer> player){
        resetCounts();
        for(int i = 0; i < 3; i++){
            int computerNum = computer.get(i);
            int playerNum = player.get(i);

            if(isStrike(computerNum, playerNum)){
                strike++;
                continue;
            }

            if(isBall(computer, playerNum)){
                ball++;
            }
        }
    }

    private void resetCounts(){
        strike = 0;
        ball = 0;
    }

    private boolean isStrike(int computerNum, int playerNum){
        return computerNum == playerNum;
    }

    private boolean isBall(List<Integer> computer, int playerNum) {
        return computer.contains(playerNum);
    }

    public int getBall(){
        return this.ball;
    }

    public int getStrike(){
        return this.strike;
    }
}
