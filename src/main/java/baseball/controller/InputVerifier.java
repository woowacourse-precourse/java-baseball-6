package baseball.controller;

public interface InputVerifier {
    public abstract void verify(String input) throws IllegalArgumentException;
}
