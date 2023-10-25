package baseball.controller;

import baseball.model.Computer;
import baseball.view.View;

import java.util.HashSet;
import java.util.Set;

import static baseball.constants.Constants.*;

public class Controller {

    private final static Computer computer = new Computer();
    private final static View view = new View();

    public void start() {
        view.printStart();
        do {
            computer.prepareGame();
            playGame();
        } while (isEnd());
        view.closeConsole();
    }

    private void playGame() {
        String result = "";
        while (!result.contains(CORRECT_COMMENT)) {
            String input = view.inputNumber();
            validateInput(input);
            result = computer.getResult(input);
            view.printResult(result);
        }
    }

    private void validateInput(String input) {
        if (!input.matches(MATCH) || input.length() != COUNT) {
            throw new IllegalArgumentException("input is invalid");
        }

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
        }
        if (set.size() != input.length()) {
            throw new IllegalArgumentException("numbers cannot be duplicated");
        }

    }

    private Boolean isEnd() {
        String end = view.inputEnd();
        validateEndInput(end);
        return end.equals(RESTART);
    }

    private static void validateEndInput(String end) {
        if (!end.equals(FIN) && !end.equals(RESTART)) {
            throw new IllegalArgumentException("Input is incorrect");
        }
    }
}
