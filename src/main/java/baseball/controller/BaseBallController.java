package baseball.controller;

import baseball.model.Numbers;
import baseball.util.InputValidator;
import baseball.util.PlayerInputParser;
import baseball.util.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseBallController {

    private static final Numbers PLAYER_NUMBERS = new Numbers();
    private static final Numbers ANSWER_NUMBERS = new Numbers();
    private static final OutputView OUTPUT_VIEW = new OutputView();
    private static final InputView INPUT_VIEW = new InputView();
    private static final RandomNumberGenerator RANDOM_NUMBER_GENERATOR = new RandomNumberGenerator();
    private static final InputValidator INPUT_VALIDATOR = new InputValidator();
    private static final PlayerInputParser PLAYER_INPUT_PARSER = new PlayerInputParser();
    private static final String BALL = BaseBallConstants.BALL;
    private static final String STRIKE = BaseBallConstants.STRIKE;
    private static final String NOTHING = BaseBallConstants.NOTHING;
    private static final String CONTINUE_NUMBER = BaseBallConstants.CONTINUE_NUMBER;
    private static final String GAME_TERMINATE_NUMBER = BaseBallConstants.GAME_TERMINATE_NUMBER;
    private int ballCount;
    private int strikeCount;
    private String playerInput;
    private List<Integer> playerNumbers;
    private List<Integer> answerNumbers;

    public void startBaseBallGame() {
        OUTPUT_VIEW.printGameStartMessage();
        initGame();
        runGame();
    }

    private void initGame() {
        this.ballCount = 0;
        this.strikeCount = 0;
        ANSWER_NUMBERS.setNumbers(RANDOM_NUMBER_GENERATOR.GenerateRandomNumber());
        answerNumbers = ANSWER_NUMBERS.getNumbers();
    }

    private void runGame() {
        while (!isGameCleared()) {
            OUTPUT_VIEW.printPlayerNumberInputPrompt();
            playerInput = INPUT_VIEW.enterPlayerInput();
            INPUT_VALIDATOR.isValidNumber(playerInput);
            List<Integer> parsedPlayerInput = PLAYER_INPUT_PARSER.ParsePlayerInput(playerInput);
            PLAYER_NUMBERS.setNumbers(parsedPlayerInput);
            playerNumbers = PLAYER_NUMBERS.getNumbers();

            ballCount = countBall();
            strikeCount = countStrike();
            OUTPUT_VIEW.printBaseBallHint(makeHintMessage());
        }
        OUTPUT_VIEW.printGameClearMessage();
        askRestartGame();
        ChooseGameRepeatOrQuit();
    }

    private void endGame() {
        OUTPUT_VIEW.printGameEndMessage();
    }

    private void restartGame() {
        initGame();
        runGame();
    }

    public int countBall() {
        int result = 0;
        for (int i = 0; i < answerNumbers.size(); i++) {
            if (playerNumbers.contains(answerNumbers.get(i)) && playerNumbers.get(i).equals(answerNumbers.get(i))) {
                result++;
            }
        }
        return result;
    }

    public int countStrike() {
        int result = 0;
        for (int i = 0; i < answerNumbers.size(); i++) {
            if (playerNumbers.get(i).equals(answerNumbers.get(i))) {
                result++;
            }
        }
        return result;
    }

    private boolean isGameCleared() {
        return strikeCount == 3;
    }

    private String makeHintMessage() {
        if (ballCount == 0 && strikeCount == 0) {
            return NOTHING;
        } else if (strikeCount == 0) {
            return ballCount + BALL;
        } else if (ballCount == 0) {
            return strikeCount + STRIKE;
        }
        return ballCount + BALL + " " + strikeCount + STRIKE;
    }

    private void askRestartGame() {
        OUTPUT_VIEW.printContinueGameChoicePrompt();
        playerInput = INPUT_VIEW.enterPlayerInput();
        INPUT_VALIDATOR.isValidContinueGameChoice(playerInput);
    }

    private void ChooseGameRepeatOrQuit() {
        if (playerInput.equals(CONTINUE_NUMBER)) {
            restartGame();
        } else if (playerInput.equals(GAME_TERMINATE_NUMBER)) {
            endGame();
        }
    }
}
