package baseball;

import exceptions.InvalidNumberException;

public class UserInputHandler {

    private GameRule rule;

    public UserInputHandler(GameRule rule) {
        this.rule = rule;
    }

    public BaseBallNumber createUserGuess(String input) throws IllegalArgumentException {
        BaseBallNumber guess = new BaseBallNumber(rule);
        try {
            guess.setUserInput(input);
        } catch (InvalidNumberException e) {
            throw new IllegalArgumentException();
        }
        return guess;
    }
}
