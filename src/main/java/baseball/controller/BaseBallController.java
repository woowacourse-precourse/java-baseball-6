package baseball.controller;

import baseball.model.Numbers;
import baseball.util.InputValidator;
import baseball.util.PlayerInputParser;
import baseball.util.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseBallController {
    private static final OutputView OUTPUT_VIEW = new OutputView();
    private static final InputView INPUT_VIEW = new InputView();
    private static final RandomNumberGenerator RANDOM_NUMBER_GENERATOR = new RandomNumberGenerator();
    private static final InputValidator INPUT_VALIDATOR = new InputValidator();
    private static final PlayerInputParser PLAYER_INPUT_PARSER = new PlayerInputParser();
    private static final Numbers PLAYER_NUMBERS = new Numbers();
    private static final Numbers ANSWER_NUMBERS = new Numbers();
    private int ballCount;
    private int strikeCount;
    private String playerInput;

    public void runBaseBallGame() {
        OUTPUT_VIEW.printGameStartMessage();
        startGame();
    }

    private void startGame() {
        initGame();
        runGame();
    }

    private void initGame() {
        this.ballCount = 0;
        this.strikeCount = 0;
        ANSWER_NUMBERS.setNumbers(RANDOM_NUMBER_GENERATOR.generateRandomNumber());
    }

    private void runGame() {
        while (!isGameCleared()) {
            OUTPUT_VIEW.printPlayerNumberInputPrompt();
            updatePlayerNumbers();
            updateBallAndStrike();
            OUTPUT_VIEW.printBaseBallHint(makeHintMessage());
        }
        OUTPUT_VIEW.printGameClearMessage();
        askRestartGame();
        chooseGameRepeatOrQuit();
    }

    private void endGame() {
        OUTPUT_VIEW.printGameEndMessage();
    }

    private void updatePlayerNumbers() {
        playerInput = INPUT_VIEW.enterPlayerInput();
        INPUT_VALIDATOR.isValidNumbers(playerInput);
        List<Integer> parsedPlayerInput = PLAYER_INPUT_PARSER.parsePlayerInput(playerInput);
        PLAYER_NUMBERS.setNumbers(parsedPlayerInput);
    }

    private void updateBallAndStrike() {
        ballCount = 0;
        strikeCount = 0;
        for (int answerNumber : ANSWER_NUMBERS.getNumbers()) {
            if (PLAYER_NUMBERS.isValueAtIndexEquals(ANSWER_NUMBERS.getIndexOf(answerNumber), answerNumber)) {
                strikeCount++;
            } else if (PLAYER_NUMBERS.hasValue(answerNumber)) {
                ballCount++;
            }
        }
    }

    private boolean isGameCleared() {
        return strikeCount == BaseBallConstants.BASEBALL_GAME_NUMBER_LENGTH;
    }

    private String makeHintMessage() {
        if (ballCount == 0 && strikeCount == 0) {
            return BaseBallConstants.NOTHING;
        } else if (ballCount > 0 && strikeCount == 0) {
            return ballCount + BaseBallConstants.BALL;
        } else if (ballCount == 0 && strikeCount > 0) {
            return strikeCount + BaseBallConstants.STRIKE;
        }
        return ballCount + BaseBallConstants.BALL + " " + strikeCount + BaseBallConstants.STRIKE;
    }

    private void askRestartGame() {
        OUTPUT_VIEW.printContinueGameChoicePrompt();
        playerInput = INPUT_VIEW.enterPlayerInput();
        INPUT_VALIDATOR.isValidContinueGameChoice(playerInput);
    }

    private void chooseGameRepeatOrQuit() {
        if (playerInput.equals(BaseBallConstants.SIGNAL_CONTINUE)) {
            startGame();
        } else if (playerInput.equals(BaseBallConstants.SIGNAL_TERMINATE)) {
            endGame();
        }
    }
}
