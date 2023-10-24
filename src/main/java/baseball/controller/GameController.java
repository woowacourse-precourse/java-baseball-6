package baseball.controller;

import java.util.Map;

public interface GameController {
    boolean isStillWrong();

    void start();

    Map<String, Integer> checkAnswer(String validUserAnswer);
}
