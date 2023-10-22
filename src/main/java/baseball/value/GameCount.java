package baseball.value;

public class GameCount {
    int strikeCount;
    int ballCount;

    public void initGame(){
        strikeCount = 0;
        ballCount = 0;
    }

    public void strike(){
        strikeCount += 1;
    }

    public int getStrike(){
       return strikeCount;
    }

    public void ball(){
        ballCount += 1;
    }

    public int getBall(){
        return ballCount;
    }
}
