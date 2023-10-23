package baseball.service;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.BaseBallGame;
import baseball.validation.InputValidator;
import baseball.view.GameMessage;
import baseball.view.SystemMessage;
import java.util.Arrays;

public class BaseBallGameService {

    GameMessage gameMessage = new GameMessage();
    SystemMessage systemMessage = new SystemMessage();
    BaseBallGame baseBallGame = new BaseBallGame();

    InputValidator validator = new InputValidator();

    public void play() throws IllegalArgumentException {
        systemMessage.gameStartMessage();
        baseBallGame.intiGame();

        boolean isAnswer = true;
        while (isAnswer) {
            systemMessage.requestInputData();
            String userInput = readLine();

            validator.gameValidation(userInput);

            computeScore(userInput);

            gameMessage.scoreMessage(baseBallGame.getStrikeCount(), baseBallGame.getBallCount());
            if (baseBallGame.getStrikeCount() == 3) {
                isAnswer = false;
                gameMessage.gameOverMessage();
            }

            baseBallGame.initCount();
        }
    }

    public void computeScore(String userInput) {
        int[] baseballNumbers = baseBallGame.getBaseballNumber();
        String[] inputs = userInput.split("");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (baseballNumbers[i] == Integer.parseInt(inputs[j]) && i == j) {
                    baseBallGame.incStrikeCount();
                }

                if (baseballNumbers[i] == Integer.parseInt(inputs[j]) && i != j) {
                    baseBallGame.incBallCount();
                }
            }
        }
    }
}
