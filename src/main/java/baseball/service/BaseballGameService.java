package baseball.service;

import baseball.dto.GameResultDto;
import baseball.dto.NumberDto;
import baseball.dto.StrikeBallResultDto;
import baseball.model.GameRestartOption;
import baseball.model.GameResult;
import baseball.model.GameResult.GameResultData;
import baseball.model.InputNumberValidator;
import baseball.model.RandomNumberGenerator;
import baseball.model.StrikeBallCounter;
import baseball.model.StrikeBallCounter.StrikeBallCounterData;

public class BaseballGameService {
    private final InputNumberValidator validator = new InputNumberValidator();
    private final StrikeBallCounter strikeBallCounter = new StrikeBallCounter();
    private final GameResult gameResult = new GameResult();
    private final GameResultDto gameResultDto = new GameResultDto();
    private final NumberDto numberDto = new NumberDto();
    private final StrikeBallResultDto strikeBallDto = new StrikeBallResultDto();

    public void playGame(String playerInput) {
        String validatedInput = validator.validateAllInput(playerInput);

        numberDto.setValidateInput(validatedInput);
        setStrikeBall();
        setGameResult();
    }

    public void restartGame(String playerRestartInput) {
        String validatedInput = validator.validateRestartInput(playerRestartInput);
        String restart = GameRestartOption.RESTART.getValue();

        numberDto.setValidateInput(validatedInput);
        if (numberDto.getValidateInput().equals(restart)) {
            gameResultDto.setIsRestart(true);
        }
    }

    public void initDto() {
        RandomNumberGenerator computerNumber = new RandomNumberGenerator();
        String generatedNumber = computerNumber.generateRandomNumber();

        gameResultDto.setIsRestart(false);
        gameResultDto.setIsCorrectAnswer(false);
        numberDto.setRandomNumber(generatedNumber);
    }

    private void setStrikeBall() {
        StrikeBallCounterData strikeBallCounterData;
        String userInput = numberDto.getValidateInput();
        String randomNumber = numberDto.getRandomNumber();

        strikeBallCounterData = strikeBallCounter.createStrikeBall(userInput, randomNumber);
        strikeBallDto.setStrike(strikeBallCounterData.getStrike());
        strikeBallDto.setBall(strikeBallCounterData.getBall());
    }

    private void setGameResult() {
        int strike = strikeBallDto.getStrike();
        int ball = strikeBallDto.getBall();
        GameResultData gameResultData = gameResult.result(strike, ball);

        gameResultDto.setGameResultMessage(gameResultData.getGameResultMessage());
        gameResultDto.setIsCorrectAnswer(gameResultData.getIsCorrectAnswered());
    }

    public boolean getIsCorrectAnswer() {
        return gameResultDto.getIsCorrectAnswer();
    }

    public String getResultMessage() {
        return gameResultDto.getGameResultMessage();
    }

    public boolean getIsRestart() {
        return gameResultDto.getIsRestart();
    }
}