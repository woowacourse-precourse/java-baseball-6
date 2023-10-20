package baseball.controller;

import baseball.model.BaseballGame;
import baseball.view.GameView;
import java.util.List;
import java.util.ArrayList;

public class GameController {
    private BaseballGame game;
    private GameView view;

    public GameController(BaseballGame game, GameView view) {
        this.game = game;
        this.view = view;
    }

    public void startGame() {
        view.displayGameEndMessage(false);

        while (true) {
            String userInput = view.getUserInput();
            if (!isValidInput(userInput) || userInput.isEmpty()) {
                throw new IllegalArgumentException();
            }

            List<Integer> userNumbers = convertInputToNumbers(userInput);
            String result = game.playRound(userNumbers);
            view.displayResult(result);

            if (result.equals("3스트라이크")) {
                view.displayGameEndMessage(true);
                break;
            }
        }
    }
    private static boolean isValidInput(String input) {
        if (input.length() != 3) {
            return false;
        }

        for (char c : input.toCharArray()) {
            if (c < '1' || c > '9') {
                return false;
            }
        }

        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }
    private static List<Integer> convertInputToNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            numbers.add(Integer.parseInt(String.valueOf(c)));
        }
        return numbers;
    }
}