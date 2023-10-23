package baseball;

public class GameScore {
    private int strike;
    private int ball;
    public GameScore() {
    }
    public void updateScore(String computerNumber, String userNumber) {
        int strike = 0;
        int ball = 0;
        this.strike = 0;
        this.ball = 0;

        if(computerNumber.equals(userNumber))
            this.strike = 3;
        else {
            char[] computer = computerNumber.toCharArray();
            char[] user = userNumber.toCharArray();

            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if(computer[i] == user[j]) {
                        if(i == j) strike++;
                        else ball++;
                    }
                }
            }
            this.strike = strike;
            this.ball = ball;
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
