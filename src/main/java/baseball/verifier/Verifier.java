package baseball.verifier;

public interface Verifier {

    public abstract void check(String input) throws IllegalArgumentException;
}
