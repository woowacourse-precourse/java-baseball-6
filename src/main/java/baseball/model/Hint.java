package baseball.model;

public class Hint {
    private int ball;
    private int strike;

    public int[] getHint(String userNubmer, String answerNumber){
        resetCount();
        ballCount(userNubmer, answerNumber);
        strikeCount(userNubmer, answerNumber);
        strikeExecptBall();

        return new int[]{ball, strike};
    }

    public void resetCount(){
        ball = 0;
        strike = 0;
    }

    public void ballCount(String userNumber, String answerNumber) {
        for(int i=0; i<userNumber.length(); i++){
            if(answerNumber.contains(Character.toString(userNumber.charAt(i)))) {
                ball ++;
            }
        }
    }

    public void strikeCount(String userNumber, String answerNumber) {
        for(char userNum : userNumber.toCharArray()) {
            if(answerNumber.indexOf(userNum) == userNumber.indexOf(userNum)) {
                strike ++;
            }
        }
    }

    public void strikeExecptBall() {
        ball = ball-strike;
    }

    public int getStrike() {
        return strike;
    }
}
