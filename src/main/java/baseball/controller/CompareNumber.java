package baseball.controller;
public class CompareNumber {
    private int ball;
    private int strike;

    public int getStrike(){
        return strike;
    }

    public int[] getCompareNumberResult(String playerNum, String computerNum){
        resetCount();
        ballCount(playerNum, computerNum);
        strikeCount(playerNum, computerNum);
        strikeExceptBall();

        return new int[]{ball, strike};
    }

    public void resetCount(){
        ball = 0;
        strike = 0;
    }

    public void ballCount(String playerNum, String computerNum){
        for(int i = 0; i < playerNum.length(); i++){
            if(computerNum.contains(Character.toString(playerNum.charAt(i)))) ball++;
        }
    }

    public void strikeCount(String playerNum, String computerNum){
        for (char player : playerNum.toCharArray()){
            if(computerNum.indexOf(player) == playerNum.indexOf(player)) strike++;
        }
    }

    public void strikeExceptBall(){
        ball -= strike;
    }
}
