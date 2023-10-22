package baseball.domain;


import baseball.domain.numberBalls.NumberBalls;

public class Hitter {

    private NumberBalls numberBalls;

    private Hitter() {
    }

    public static Hitter create(NumberBalls numberBalls) {
        Hitter hitter = new Hitter();
        hitter.setNumbers(numberBalls);

        return hitter;
    }

    private void setNumbers(NumberBalls numberBalls) {
        this.numberBalls = numberBalls;
    }


    public Result hit(NumberBalls opponentNumberBalls) {
        return numberBalls.calculateResult(opponentNumberBalls);
    }

}
