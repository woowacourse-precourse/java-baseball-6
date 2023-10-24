package baseball;

public class Gamedata {

    int strike;
    int ball;

    public void refreshcount() {
        strike = 0;
        ball = 0;
    }

    public int returnstrike() {
        return strike;
    }

    public int returnball() {
        return ball;
    }
    public void countstrike() {
        strike += 1;
    }

    public void countball() {
        ball += 1;
    }
}
