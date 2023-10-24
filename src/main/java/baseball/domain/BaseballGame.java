package baseball.domain;

import java.util.Arrays;

public class BaseballGame {
    private int strike;
    private int ball;
    private int[] numbers;
    private boolean[] haveDigits =new boolean[10];
    public BaseballGame(int[] gameNum){
        //Init haveDigit array
        Arrays.fill(haveDigits,false);
        for (int i : gameNum) {
            haveDigits[i] = true;
        }
        numbers = gameNum;
        initStrikeAndBall();
    }
    public void initStrikeAndBall(){
        strike = 0;
        ball =0;
    }
    public boolean haveDigit(int digit){
        return haveDigits[digit];
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
