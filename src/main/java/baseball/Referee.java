package baseball;

public class Referee {
    private TargetNumber targetNumber;
    private Referee() { }

    public static Referee enter() { return new Referee(); }
}
