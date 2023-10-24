package baseball.machine;

import baseball.machine.count.BallCount;
import baseball.machine.ui.UI;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class NormalBaseballMachine implements BaseballMachine {
    private static final int NUMBER_OF_DIGITS = 3;
    private static final int GAME_QUIT_OPTION = 2;

    private static final String GAME_CONTINUE_OPTION_STRING = "1";
    private static final String GAME_QUIT_OPTION_STRING = "2";

    private static final char CHARACTER_MIN_VALUE = '1';
    private static final char CHARACTER_MAX_VALUE = '9';

    private final int[] randomNumbers;
    private final UI ui;

    public NormalBaseballMachine(UI ui) {
        this.randomNumbers = new int[3];
        this.ui = ui;
    }

    @Override
    public void start() {
        this.ui.startGame();
        this.runUntilUserQuits();
    }

    private void runUntilUserQuits() {
        boolean isGameContinue = true;
        while (isGameContinue) {
            this.initializeRandomNumbers();
            this.generateRandomNumbers();
            this.playUntilWin();
            String userPostGameChoiceString = this.ui.getPostGameAction();
            int postGameOption = this.convertUserChoicePostGame(userPostGameChoiceString);
            if (postGameOption == GAME_QUIT_OPTION) isGameContinue = false;
        }
    }

    private void playUntilWin() {
        boolean isWin = false;
        while (!isWin) {
            String userGuessString = this.ui.getThreeDigitString();
            int[] userGuessNumbers = this.parseUserGuessStringToNumbers(userGuessString);
            BallCount ballCount = this.evaluateUserGuess(userGuessNumbers);

            this.ui.gameResult(ballCount);

            if (ballCount.getStrike() == NUMBER_OF_DIGITS) isWin = true;
        }
        this.ui.winGame();
    }

    private void generateRandomNumbers() {
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

    private void initializeRandomNumbers() {
        randomNumbers[2] = randomNumbers[1] = randomNumbers[0] = 0;
    }

    private int[] parseUserGuessStringToNumbers(String userInput) {
        this.validateUserGuessString(userInput);

        int[] intArray = new int[userInput.length()];
        char[] charArray = userInput.toCharArray();

        for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
            this.validateCharacterRange(charArray[i]);
            intArray[i] = Character.getNumericValue(charArray[i]);
            this.validateNoDuplicates(intArray, i);
            for (int j = 0; j < i; j++) {
                if (intArray[i] == intArray[j]) throw new IllegalArgumentException();
            }
        }
        return intArray;
    }

    private void validateUserGuessString(String userInput) {
        if (userInput == null || userInput.length() != NUMBER_OF_DIGITS) throw new IllegalArgumentException();
    }

    private void validateCharacterRange(char c) {
        if (c < CHARACTER_MIN_VALUE || c > CHARACTER_MAX_VALUE) throw new IllegalArgumentException();
    }

    private void validateNoDuplicates(int[] inputNumbers, int index) {
        for (int j = 0; j < index; j++) {
            if (inputNumbers[index] == inputNumbers[j]) {
                throw new IllegalArgumentException();
            }
        }
    }


    private BallCount evaluateUserGuess(int[] userGuessNumbers) {
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
        this.validateUserChoicePostGame(userInput);
        if (userInput.length() != 1) throw new IllegalArgumentException();
        char[] charArray = userInput.toCharArray();
        if (charArray[0] < '1' || charArray[0] > '2') throw new IllegalArgumentException();
        return Character.getNumericValue(charArray[0]);
    }

    private void validateUserChoicePostGame(String userInput) {
        if (userInput.length() != 1) throw new IllegalArgumentException();
        if (!userInput.equals(GAME_CONTINUE_OPTION_STRING) && !userInput.equals(GAME_QUIT_OPTION_STRING))
            throw new IllegalArgumentException();
    }




}
