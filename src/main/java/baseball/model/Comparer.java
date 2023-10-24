package baseball.model;

public class Comparer {
    private int ballCount;
    private int strikeCount;
    public Comparer(String computerNumber, String playerNumber){
        this.ballCount = calculateBallOrStrikeOrNothing(computerNumber, playerNumber)[0];
        this.strikeCount = calculateBallOrStrikeOrNothing(computerNumber, playerNumber)[1];
    }
    public int getBallCount(){
        return this.ballCount;
    }
    public int getStrikeCount(){
        return this.strikeCount;
    }

    public int[] calculateBallOrStrikeOrNothing(String computerNumber, String playerNumber){
        resetCount();
        checkBall(computerNumber, playerNumber);
        checkStrike(computerNumber, playerNumber);
        isBallExpectStrike();

        return new int[] {ballCount, strikeCount};
    }
    public void resetCount(){
        this.strikeCount = 0;
        this.ballCount  = 0;
    }

    public void checkBall(String computerNumber, String playerNumber){
        for (int i=0; i<playerNumber.length(); i++){
            if (computerNumber.contains("" + playerNumber.charAt(i))){
                ballCount++;
            }
        }
    }
    public void checkStrike(String computerNumber, String playerNumber){
        for (char num : playerNumber.toCharArray()){
            if (computerNumber.indexOf(num) == playerNumber.indexOf(num)){
                strikeCount++;
            }
        }
    }
    public void isBallExpectStrike(){
        ballCount = ballCount - strikeCount;
    }
}
