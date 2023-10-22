package baseball.model;

public class Comparer {
    private int ballCount;
    private int strikeCount;

    public int[] calculateStrikeOrBallOrNothing(String computerNum, String playerNum){
        resetCount();
        checkBall(computerNum, playerNum);
        checkStrike(computerNum, playerNum);
        strikeExceptBall();

        return new int[] {ballCount, strikeCount};
    }
    public void resetCount(){
        this.strikeCount = 0;
        this.ballCount  = 0;
    }

    public void checkBall(String computerNum, String playerNum){
        for (int i=0; i<playerNum.length(); i++){
            if (computerNum.contains("" + playerNum.charAt(i))){
                ballCount++;
            }
        }
    }
    public void checkStrike(String computerNum, String playerNum){
        for (char num : playerNum.toCharArray()){
            if (computerNum.indexOf(num) == playerNum.indexOf(num)){
                strikeCount++;
            }
        }
    }
    public void strikeExceptBall(){
        ballCount = ballCount - strikeCount;
    }
}
