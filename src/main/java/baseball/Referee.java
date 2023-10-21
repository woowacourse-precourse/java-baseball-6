package baseball;

public class Referee {
    private TargetNumber targetNumber;
    private Referee() { }

    public static Referee enter() { return new Referee(); }

    public void playBall(int a, int b, int c) {
        targetNumber = TargetNumber.generate(a, b, c);
    }
}
