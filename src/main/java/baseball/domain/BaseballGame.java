package baseball.domain;

public class BaseballGame {
    private int strike;
    private int ball;
    private int[] numbers;

    public BaseballGame(int[] gameNum){
        numbers = gameNum;
        initStrikeAndBall();
    }
    public void initStrikeAndBall(){
        strike = 0;
        ball =0;
    }
    public void increaseStrike(){
        this.strike += 1;

    }
    public void increaseBall(){
        this.ball +=1 ;
    }

    public int getStrike(){
        return strike;
    }
    public int getBall(){
        return ball;
    }

    public int[] getNumbers(){
        return numbers;
    }
}
