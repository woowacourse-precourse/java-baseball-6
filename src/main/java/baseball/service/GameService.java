package baseball.service;

import baseball.model.Game;
import baseball.utils.Constant;

public class GameService {

    private InputValidator validator;
    private Game game;

    public GameService() {
        this.validator = new InputValidator();
        this.game = new Game();
    }

    public String validateInput(String userInput) {
        validator.validate(userInput);
        return generateResultMessage(userInput);
    }

    private String generateResultMessage(String userInput) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < userInput.length(); i++) {
            ballCount += game.calculateBall(userInput, i);
            strikeCount += game.calculateStrike(userInput, i);
        }

        return getResultMessage(ballCount, strikeCount);
    }

    private String getResultMessage(int ballCount, int strikeCount) {
        if (strikeCount == Constant.COUNT_ZERO && ballCount == Constant.COUNT_ZERO) {
            return "낫싱";
        }

        StringBuilder resultMessageBuilder = new StringBuilder();

        if (ballCount > Constant.COUNT_ZERO) {
            resultMessageBuilder.append(ballCount).append("볼 ");
        }

        if (strikeCount > Constant.COUNT_ZERO) {
            resultMessageBuilder.append(strikeCount).append("스트라이크");
        }

        return resultMessageBuilder.toString().trim();
    }
}