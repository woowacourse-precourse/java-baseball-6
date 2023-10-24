package baseball.service;

import baseball.dto.GameResultDto;
import baseball.dto.NumberDto;
import baseball.dto.StrikeBallResultDto;
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
        numberDto.setValidateInput(validator.validateAllInput(playerInput));
        setStrikeBall();
        setGameResult();
    }

    public void restartGame(String playerRestartInput) {
        numberDto.setValidateInput(validator.validateRestartInput(playerRestartInput));
        if (numberDto.getValidateInput().equals("1")) {
            gameResultDto.setIsRestart(true);
        }
    }

    public void initDto() {
        RandomNumberGenerator computerNumber = new RandomNumberGenerator();
        gameResultDto.setIsRestart(false);
        gameResultDto.setIsCorrectAnswer(false);
        numberDto.setRandomNumber(computerNumber.generateRandomNumber());
    }

    private void setStrikeBall() {
        StrikeBallCounterData strikeBallCounterData = strikeBallCounter.createStrikeBall(numberDto.getValidateInput(),
                numberDto.getRandomNumber());
        strikeBallDto.setStrike(strikeBallCounterData.strike());
        strikeBallDto.setBall(strikeBallCounterData.ball());
    }

    private void setGameResult() {
        GameResultData gameResultData = gameResult.result(strikeBallDto.getStrike(), strikeBallDto.getBall());
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
