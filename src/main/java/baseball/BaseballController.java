package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballController {
    private BaseballGame model;
    private BaseballView view;

    public BaseballController(BaseballGame model, BaseballView view) {
        this.model = model;
        this.view = view;
    }

    public void playGame() {
        view.displayGameStartMessage();

        while (!model.isGameOver()) {
            view.displayInputPrompt();
            int[] userGuess = getUserInput();

            try {
                String result = model.guess(userGuess);
                view.displayResult(result);

                if (result.equals("3스트라이크")) {
                    view.displayGameEndMessage();
                    view.displayGameRestartMessage();
                    int choice = getUserChoice();
                    if (choice == 1) {
                        model.resetGame();
                    } else {
                        break;
                    }
                }
            } catch (IllegalArgumentException e) {
                view.displayErrorMessage(e.getMessage());
                break;  // 애플리케이션 종료
            }
        }
    }

    private int[] getUserInput() {
        int[] userNumbers = new int[3];
        boolean validInput = false;

        while (!validInput) {
            String input = view.getUserInput();

            if (input.length() != 3) {
                throw new IllegalArgumentException("서로 다른 3자리의 수를 입력하세요.");
            }

            validInput = true;
            for (int i = 0; i < 3; i++) {
                userNumbers[i] = Character.getNumericValue(input.charAt(i));
                if (userNumbers[i] < 1 || userNumbers[i] > 9) {
                    throw new IllegalArgumentException("1에서 9 사이의 숫자를 입력하세요.");
                }
            }
        }

        return userNumbers;
    }

    private int getUserChoice() {
        int choice;
        while (true) {
            String input = view.getUserInput();
            try {
                choice = Integer.parseInt(input);
                if (choice != 1 && choice != 2) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                view.displayErrorMessage("1 또는 2를 입력하세요.");
            }
        }
        return choice;
    }
}
