package baseball.controller;

import baseball.model.Computer;
import baseball.view.View;

import java.util.HashSet;
import java.util.Set;

public class Controller {

    private final static Computer computer = new Computer();
    private final static View view = new View();
    private final static String FIN = "1";

    public void start() {
        String end;
        view.printStart();
        do {
            computer.prepareGame();
            playGame();
            end = view.inputEnd();
        } while (end.equals(FIN));
        view.closeConsole();
    }

    private void playGame() {
        String result = "";
        while (!result.contains("게임 종료")) {
            String input = view.inputNumber();
            validateInput(input);
            result = computer.getResult(input);
            view.printResult(result);
        }
    }

    private void validateInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("numbers cannot be empty");
        }

        if (3 != input.length() || !input.matches("^[1-9]{3}$")) {
            throw new IllegalArgumentException("Only " + 3 + " numbers required");
        }

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
        }
        if (set.size() != input.length()) {
            throw new IllegalArgumentException("numbers cannot be duplicated");
        }

    }
}
