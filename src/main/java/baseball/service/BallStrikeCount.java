package baseball.service;

public class BallStrikeCount {
    private int ball;
    private int strike;

    public void resetCount(){
        ball = 0;
        strike = 0;
    }

    public void ballCount(String userNum, String createNum){
        for (int i = 0; i < userNum.length(); i++) {
            if (createNum.contains(Character.toString(userNum.charAt(i)))) {
                ball ++;
            }
        }
    }

    public void strikeCount(String userNum, String createNum){
        for (char userNumChar : userNum.toCharArray()) {
            if (createNum.indexOf(userNumChar) == userNum.indexOf(userNumChar)) {
                strike ++;
            }
        }
    }

    public void excludeDuplicate(){
        ball = ball - strike;
    }

    public int[] compareResult(String userNum, String createNum) {
        resetCount();
        ballCount(userNum, createNum);
        strikeCount(userNum, createNum);
        excludeDuplicate();

        return new int[]{ball, strike};
    }

    public boolean thirdStrike() {
        if (strike == 3) {
            return true;
        }
        return false;
    }
}