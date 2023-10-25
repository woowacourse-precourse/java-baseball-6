package baseball.game;

import baseball.ui.GameUI;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberBaseballGame {
    private static final int STRIKE_NUMBER = 3;
    private List<Integer> secretNumber;

    private final GameUI gameUI;

    public NumberBaseballGame(GameUI gameUI) {
        this.gameUI = gameUI;
        generateSecretNumber();
    }

    private void generateSecretNumber() {
        secretNumber = new ArrayList<>();
        while (secretNumber.size() < STRIKE_NUMBER) {
            int digit = Randoms.pickNumberInRange(1, 9);
            if (!secretNumber.contains(digit)) {
                secretNumber.add(digit);
            }
        }
    }

    public void playGame() {
        gameUI.displayMessage("숫자 야구 게임을 시작합니다.");
        boolean gameOver = false;
        while (!gameOver) {
            String userGuess = gameUI.getUserGuess();
            int[] result = checkGuess(userGuess);
            gameUI.displayResult(result);
            if (result[0] == STRIKE_NUMBER) {
                gameUI.displayMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                int choice = gameUI.askForRestart();
                if (choice == 2) {
                    gameOver = true;
                } else {
                    restartGame();
                }
            }
        }
        gameUI.displayMessage("게임이 종료되었습니다.");
    }

    private void restartGame() {
        generateSecretNumber();
    }


    private int[] checkGuess(String guess) {
        int[] result = {0, 0}; // [스트라이크, 볼]
        List<Integer> guessDigits = new ArrayList<>();
        for (char c : guess.toCharArray()) {
            guessDigits.add(Character.getNumericValue(c));
        }
        for (int i = 0; i < STRIKE_NUMBER; i++) {
            if (secretNumber.get(i).equals(guessDigits.get(i))) {
                result[0]++; // 스트라이크
            } else if (secretNumber.contains(guessDigits.get(i))) {
                result[1]++; // 볼
            }
        }
        return result;
    }

}
