package baseball.controller;

public interface GameController {
    boolean isStillWrong();

    void start();

    void checkAnswer(String validUserAnswer);
}
