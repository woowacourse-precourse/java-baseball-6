package baseball.domain;

public class Point {
    private final int strike;
    private final int ball;

    public Point(int strike,int ball){
        this.strike=strike;
        this.ball=ball;
    }

    public boolean equals(Point point){
        return equalsStrike(point.strike) && equalsBall(point.ball);
    }

    public boolean equalsStrike(int strike){
        return this.strike==strike;
    }

    public boolean equalsBall(int ball){
        return this.ball==ball;
    }
}
