package baseball.utils;

import baseball.dto.GameResultDto;
import baseball.dto.NumberDto;
import baseball.dto.StrikeBallResultDto;

public class DtoManager {
    private final StrikeBallResultDto strikeBallDto = new StrikeBallResultDto();
    private final GameResultDto gameResultDto = new GameResultDto();
    private final NumberDto numberDto = new NumberDto();

    public void setStrike(int strike) {
        strikeBallDto.setStrike(strike);
    }

    public void setBall(int ball) {
        strikeBallDto.setBall(ball);
    }

    public int getStrike() {
        return strikeBallDto.getStrike();
    }

    public int getBall() {
        return strikeBallDto.getBall();
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

    public void setIsRestart(boolean isRestart) {
        gameResultDto.setIsRestart(isRestart);
    }

    public void setIsCorrectAnswer(boolean isCorrectAnswer) {
        gameResultDto.setIsCorrectAnswer(isCorrectAnswer);
    }

    public void setGameResultMessage(String gameResultMessage) {
        gameResultDto.setGameResultMessage(gameResultMessage);
    }

    public void setValidatedInput(String validatedInput) {
        numberDto.setValidateInput(validatedInput);
    }

    public String getValidatedInput() {
        return numberDto.getValidateInput();
    }

    public void setRandomNumber(String randomNumber) {
        numberDto.setRandomNumber(randomNumber);
    }

    public String getValidateInput() {
        return numberDto.getValidateInput();
    }

    public String getRandomNumber() {
        return numberDto.getRandomNumber();
    }
}
