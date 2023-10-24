package baseball.model;

// 채점 기능
public class UserNumberGrader {
    private int ball;
    private int strike;

    public int[] grader(String userNumber, String answer) {
        resetCount();
        countBall(userNumber, answer);
        countStrike(userNumber, answer);
        mediateBallcount();

        return new int[]{ball, strike};
    }

    public void countBall(String userNumber, String answer) {
        for (char num : userNumber.toCharArray()) {
            if (answer.contains(String.valueOf(num))) {
                ball++;
            }
        }
    }

    public void countStrike(String userNumber, String answer) {
        for (int i = 0; i < userNumber.length(); i++) {
            if (userNumber.charAt(i) == answer.charAt(i)) {
                strike++;
            }
        }
    }

    public void mediateBallcount() {
        ball = ball - strike;
    }

    public void resetCount() {
        ball = 0;
        strike = 0;
    }
}
