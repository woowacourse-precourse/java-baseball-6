package baseball;

public class Result {

    private final int strikes;
    private final int balls;

    public Result(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean isGameWon() {
        return strikes == Number.MAX_DIGITS;
    }

    public void display() {
        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
            return;
        }
        if (balls > 0) {
            System.out.print(balls + "볼 ");
        }
        if (strikes > 0) {
            System.out.print(strikes + "스트라이크");
        }
        System.out.println();
    }
}








