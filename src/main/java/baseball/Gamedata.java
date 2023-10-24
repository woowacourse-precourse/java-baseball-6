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
    public int countstrike() {
        strike += 1;
        return strike;
    }

    public int countball() {
        ball += 1;
        return ball;
    }
}
