package baseball.Controller;

import baseball.Model.BaseballGameModel;
import baseball.View.BaseballGameView;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameController {
    private BaseballGameModel model;
    private BaseballGameView view;

    public BaseballGameController(BaseballGameModel model, BaseballGameView view) {
        this.model = model;
        this.view = view;
    }

    public void playGame() {
        view.printStartMessage();
    
        boolean gameEnded = false;
    
        while (!gameEnded) {
            try {
                int[] guess = getUserInput();
                int[] result = checkGuess(guess);
                view.printResult(formatResult(result));
    
                if (isGameFinished(result)) {
                    view.printRestartOrQuitMessage();
                    int choice = getRestartOrQuitOption();
    
                    if (choice == 1) {
                        model.generateRandomAnswer();
                    } else if (choice == 2) {
                        gameEnded = true;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                view.printRestartOrQuitMessage();
                int choice = getRestartOrQuitOption();
    
                if (choice == 2) {
                    gameEnded = true;
                }
            }
        }
    }
    
    private int[] getUserInput() {
        view.printInputMessage();
        String input = Console.readLine();
        
        if (input.length() != 3) {
            throw new IllegalArgumentException("3개의 숫자를 입력해야 합니다.");
        }
    
        int[] guess = new int[3];
        for (int i = 0; i < 3; i++) {
            guess[i] = input.charAt(i) - '0';
        }
    
        if (guess[0] == guess[1] || guess[0] == guess[2] || guess[1] == guess[2]) {
            throw new IllegalArgumentException("중복되지 않는 숫자 3개를 입력해야 합니다.");
        }
        
        return guess;
    }


    private int[] checkGuess(int[] guess) {
        int[] answer = model.getAnswer();
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (guess[i] == answer[i]) {
                strikes++;
            } else if (contains(answer, guess[i])) {
                balls++;
            }
        }

        return new int[] { strikes, balls };
    }

    private boolean contains(int[] array, int number) {
        for (int item : array) {
            if (item == number) {
                return true;
            }
        }
        return false;
    }

    private String formatResult(int[] result) {
        StringBuilder formattedResult = new StringBuilder();

        if (result[1] > 0) {
            formattedResult.append(result[1]).append("볼");
        }

        if (result[0] > 0 && result[1] > 0) {
            formattedResult.append(" ");
        }

        if (result[0] > 0) {
            formattedResult.append(result[0]).append("스트라이크");
        }

        if (formattedResult.length() == 0) {
            formattedResult.append("낫싱");
        }

        return formattedResult.toString();
    }

    private boolean isGameFinished(int[] result) {
        return result[0] == 3;
    }

    private int getRestartOrQuitOption() {
        return view.getRestartOrQuitOption();
    }
}