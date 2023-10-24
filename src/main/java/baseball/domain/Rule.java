package baseball.domain;

public class Rule {
    int ballCount;
    int strikeCount;
    int[] computerInput;

    public void initParam(){
        ballCount=0;
        strikeCount=0;
    }

    public Rule(int[] random){
        computerInput=random;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int[] getComputerInput() {
        return computerInput;
    }

    public void countBall(){
        ballCount++;
    }

    public void countStrike(){
        strikeCount++;
    }
}
