package baseball;

public class Game {
    private final int NUM_COUNT=3;
    private int[] computerAnswer;
    private int strike=0;
    private int ball=0;
    Number number;

    public Game(){
        number=new Number();
    }

    public void reset(){
        this.strike=0;
        this.ball=0;
    }

    public int[] setComputerAnswer(){
        computerAnswer=number.makeComputerAnswer();
        return computerAnswer;
    }

    public void increaseStrike(){
        this.strike++;
    }

    public void increaseBall(){
        this.ball++;
    }

    public int getStrike(){
        return this.strike;
    }

    public int getBall(){
        return this.ball;
    }
}