package baseball;

import baseball.ui.UI;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;



public class BaseballMachine {
    private final int[] randomNumbers;
    private final UI ui;

    public BaseballMachine(UI ui) {
        this.randomNumbers = new int[3];
        this.ui = ui;
    }

    public void start() {
        this.ui.startGame();
        boolean isGameContinue = true;

        while (isGameContinue) {
            this.generateRandomNumbers();

            boolean isWin = true;
            while (isWin) {
                String userGuessString = this.ui.getThreeDigitString();
                int[] userGuessNumbers = this.parseUserGuessStringToNumbers(userGuessString);
                BallCount ballCount = this.evaluateUserGuess(userGuessNumbers);

                // TODO: Test 이후 삭제
                System.out.println(Arrays.toString(randomNumbers));
                this.ui.gameResult(ballCount);

                if (ballCount.getStrike() == 3) isWin = false;

            }
            this.ui.winGame();
            String userPostGameChoiceString = this.ui.getPostGameAction();
            int postGameOption = this.convertUserChoicePostGame(userPostGameChoiceString);
            if (postGameOption == 2) isGameContinue = false;
        }
    }

    private void generateRandomNumbers() {
        randomNumbers[2] = randomNumbers[1] = randomNumbers[0] = 0;
        for (int i = 0; i < randomNumbers.length; i++) {
            int temp;
            boolean isDuplicate;

            do {
                isDuplicate = false;
                temp = pickNumberInRange(1, 9);

                for (int j = 0; j < i; j++) {
                    if (randomNumbers[j] == temp) {
                        isDuplicate = true;
                        break;
                    }
                }
            } while (isDuplicate);

            randomNumbers[i] = temp;
        }
    }

    private int[] parseUserGuessStringToNumbers(String userInput) {

        int[] intArray = new int[userInput.length()];
        char[] charArray = userInput.toCharArray();

        if (charArray.length != 3) throw new IllegalArgumentException();
        for (int i = 0; i < 3; i++) {
            if (charArray[i] < '1' || charArray[i] > '9') throw new IllegalArgumentException();
            intArray[i] = Character.getNumericValue(charArray[i]);
            for (int j = 0; j < i; j++) {
                if (intArray[i] == intArray[j]) throw new IllegalArgumentException();
            }
        }
        return intArray;
    }

    private BallCount evaluateUserGuess(int[] userGuessNumbers) {
        // 변경
        BallCount ballCount = new BallCount();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (userGuessNumbers[i] == randomNumbers[j]) {
                    if (i == j) {
                        ballCount.addStrike();
                    } else {
                        ballCount.addBall();
                    }
                }
            }
        }
        return ballCount;
    }

    private int convertUserChoicePostGame(String userInput) {
        if (userInput.length() != 1) throw new IllegalArgumentException();
        char[] charArray = userInput.toCharArray();
        if (charArray[0] < '1' || charArray[0] > '2') throw new IllegalArgumentException();
        return Character.getNumericValue(charArray[0]);
    }
}
