package baseball.controller;

import baseball.domain.AnswerNumbers;
import baseball.domain.PlayerInput;
import baseball.domain.PlayerNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseBallController {
    private int ballCount;
    private int strikeCount;

    private List<Integer> playerNumbers;
    private List<Integer> answerNumbers;
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final OutputView OUTPUT_VIEW = new OutputView();
    private static final InputView INPUT_VIEW = new InputView();
    private static final InputValidator INPUT_VALIDATOR = new InputValidator();

    private static final PlayerInput PLAYER_INPUT = new PlayerInput();
    private static final PlayerNumbers PLAYER_NUMBERS = new PlayerNumbers();
    private static final AnswerNumbers ANSWER_NUMBERS = new AnswerNumbers();
    private static final RandomNumberGenerator RANDOM_NUMBER_GENERATOR = new RandomNumberGenerator();
    private static final PlayerInputParser PLAYER_INPUT_PARSER = new PlayerInputParser();

    private void initGame() {
        this.ballCount = 0;
        this.strikeCount = 0;
        ANSWER_NUMBERS.setAnswerNumbers(RANDOM_NUMBER_GENERATOR.GenerateRandomNumber());
        answerNumbers = ANSWER_NUMBERS.getAnswerNumbers();
    }

    public void startBaseBallGame() {
        OUTPUT_VIEW.printGameStartMessage();
        initGame();
        runGame();
    }

    public int countBall() {
        int result = 0;
        for (int i = 0; i < answerNumbers.size(); i++) {
            if (playerNumbers.contains(answerNumbers.get(i)) && playerNumbers.get(i) != answerNumbers.get(i)) {
                result++;
            }
        }
        return result;
    }

    public int countStrike() {
        int result = 0;
        for (int i = 0; i < answerNumbers.size(); i++) {
            if (playerNumbers.get(i) == answerNumbers.get(i)) {
                result++;
            }
        }
        return result;
    }

    private boolean isGameCleared() {
        return answerNumbers.equals(playerNumbers);
    }

    private void runGame() {
        while (!isGameCleared()) {
            OUTPUT_VIEW.printPlayerNumberInputPrompt();
            PLAYER_INPUT.setPlayerInput(INPUT_VIEW.enterPlayerInput());
            INPUT_VALIDATOR.isValidNumber(PLAYER_INPUT.getPlayerInput());
            PLAYER_NUMBERS.setPlayerNumbers(PLAYER_INPUT_PARSER.ParsePlayerInput(PLAYER_INPUT.getPlayerInput()));
            playerNumbers = PLAYER_NUMBERS.getPlayerNumbers();

            ballCount = countBall();
            strikeCount = countStrike();
            OUTPUT_VIEW.printBaseBallHint(makeHintMessage());
        }
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
    
}
