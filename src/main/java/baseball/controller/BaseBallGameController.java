package baseball.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.service.BaseBallGameService;
import baseball.validation.InputValidator;
import baseball.view.SystemMessage;

public class BaseBallGameController {
    BaseBallGameService baseBallGameService = new BaseBallGameService();
    SystemMessage systemMessage = new SystemMessage();

    InputValidator validator = new InputValidator();

    public void run() {
        baseBallGameService.play();
        askRetry();
    }

    public void askRetry() {

        String userInput = inputRetry();

        if (userInput != null && userInput.equals("1")) {
            run();
        }
    }

    public String inputRetry() {
        try {
            systemMessage.askRetryMessage();
            String userInput = readLine();

            validator.retryValidation(userInput);

            return userInput;

        } catch (IllegalArgumentException e) {
            systemMessage.inputErrorMessage();
            return null;
        }
    }
}
