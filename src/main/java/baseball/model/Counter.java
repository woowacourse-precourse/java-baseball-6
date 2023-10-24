package baseball.model;

/*
 * Counter
 * 각 play 마다 strike의 갯수와 ball의 갯수를 저장하기 위함
 */
public class Counter {
    private int strikeCount = 0;
    private int ballCount = 0;

    public void init() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }
    
    public int getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }
}
