package baseball.util;

public class NumberUtility {
    private int ball;
    private int strike;

    public int getStrike(){
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public int[] getNumberUtility(String playerNumber, String computerNumber){
        resetCount();
        ballCount(playerNumber,computerNumber);
        strikeCount(playerNumber,computerNumber);
        utilBallStrike();

        return new int[]{ball, strike};
    }

    public void resetCount(){
        ball = 0;
        strike = 0;

    }

    public void ballCount(String playerNumber, String computerNumber){
        for (int i = 0; i < playerNumber.length(); i++) {
            if (computerNumber.contains(Character.toString(playerNumber.charAt(i)))) ball++;
        }
    }
    public void strikeCount(String playerNumber, String computerNumber){
        for (char x: playerNumber.toCharArray()) {
            if (computerNumber.indexOf(x) == playerNumber.indexOf(x)) strike++;
        }
    }

    public void utilBallStrike(){
        ball -= strike;
    }
}
