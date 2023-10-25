package baseball;

import baseball.GameModel;
import baseball.GameView;
import baseball.Result;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private GameModel model;
    private GameView view;

    public GameController() {
        model = new GameModel();
        view = new GameView();
    }

    public void run() {
        while (true) {
            view.displayMessage("숫자 야구 게임을 시작합니다.");
            playGame();

            view.displayRestartOrExit();
            String choice = view.getUserInput();
            if ("2".equals(choice)) { break; }
            model = new GameModel();
        }
    }

    private void playGame() {
        while (true) {
            String userInput = view.getUserInput();
            if (!isValidInput(userInput)) {
                view.displayMessage("올바른 입력이 아닙니다. 1에서 9까지 서로 다른 3자리 수를 입력하세요.");
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

            List<Integer> userGuess = parseUserInput(userInput);
            Result result = model.checkGuess(userGuess);
            view.displayResult(result);

            if (model.isGameWon(result)) {
                view.displayGameWon();
                break;
            }
        }
    }

    private boolean isValidInput(String input) {
        return input.matches("^[1-9]{3}$") && isDistinct(input);
    }

    private boolean isDistinct(String input) {
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<Integer> parseUserInput(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }
        return numbers;
    }

    private void handleRestartOrExit() {
        view.displayRestartOrExit();
        String choice = view.getUserInput();
        if ("2".equals(choice)) {
            System.exit(0);
        }
    }
}
