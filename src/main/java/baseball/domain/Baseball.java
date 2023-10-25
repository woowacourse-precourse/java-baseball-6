package baseball.domain;

public class Baseball {
    private String computer;
    private String randomNum;
    private int strike;
    private int ball;

    public Baseball(String computer, String randomNum, int strike, int ball) {
        this.computer = computer;
        this.randomNum = randomNum;
        this.strike = strike;
        this.ball = ball;
    }

    public String getComputer() {
        return this.computer;
    }

    public String getRandomNum() {
        return this.randomNum;
    }

    public int getStrike(){
        return this.strike;
    }

    public int getBall(){
        return this.ball;
    }

    public void setStrike(int strike){
        this.strike = strike;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }
}
