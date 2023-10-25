package baseball.service;

import baseball.model.GameRestartOption;
import baseball.model.GameResult;
import baseball.model.GameResult.GameResultData;
import baseball.model.InputNumberValidator;
import baseball.model.RandomNumberGenerator;
import baseball.model.StrikeBallCounter;
import baseball.model.StrikeBallCounter.StrikeBallCounterData;
import baseball.utils.DtoManager;

public class BaseballGameService {
    private final InputNumberValidator validator = InputNumberValidator.getInstance();
    private final StrikeBallCounter strikeBallCounter = new StrikeBallCounter();
    private final GameResult gameResult = new GameResult();
    private final DtoManager dtoManager;

    public BaseballGameService(DtoManager dtoManager) {
        this.dtoManager = dtoManager;
    }

    public void playGame(String playerInput) {
        String validatedInput = validator.validateAllInput(playerInput);

        dtoManager.setValidatedInput(validatedInput);
        setStrikeBall();
        setGameResult();
    }

    public void restartGame(String playerRestartInput) {
        String validatedInput = validator.validateRestartInput(playerRestartInput);
        String restart = GameRestartOption.RESTART.getValue();

        dtoManager.setValidatedInput(validatedInput);
        if (dtoManager.getValidatedInput().equals(restart)) {
            dtoManager.setIsRestart(true);
        }
    }

    public void initDto() {
        RandomNumberGenerator computerNumber = new RandomNumberGenerator();
        String generatedNumber = computerNumber.generateRandomNumber();

        dtoManager.setIsRestart(false);
        dtoManager.setIsCorrectAnswer(false);
        dtoManager.setRandomNumber(generatedNumber);
    }

    private void setStrikeBall() {
        StrikeBallCounterData strikeBallCounterData;

        String userInput = dtoManager.getValidateInput();
        String randomNumber = dtoManager.getRandomNumber();
        strikeBallCounterData = strikeBallCounter.createStrikeBall(userInput, randomNumber);

        dtoManager.setStrike(strikeBallCounterData.getStrike());
        dtoManager.setBall(strikeBallCounterData.getBall());
    }

    private void setGameResult() {
        int strike = dtoManager.getStrike();
        int ball = dtoManager.getBall();
        GameResultData gameResultData = gameResult.result(strike, ball);

        dtoManager.setGameResultMessage(gameResultData.getGameResultMessage());
        dtoManager.setIsCorrectAnswer(gameResultData.getIsCorrectAnswered());
    }
}