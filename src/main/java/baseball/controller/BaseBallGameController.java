package baseball.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.service.BaseBallGameService;
import baseball.validation.InputValidator;
import baseball.view.SystemMessage;

public class BaseBallGameController {
    BaseBallGameService baseBallGameService = new BaseBallGameService();
    SystemMessage systemMessage = new SystemMessage();

    InputValidator validator = new InputValidator();

    //게임 실행
    public void run() throws IllegalArgumentException{
        baseBallGameService.play();
        askRetry();
    }

    //재시작 요청
    public void askRetry() {

        String userInput = inputRetry();

        if (userInput != null && userInput.equals("1")) {
            run();
        }
    }

    //재시작 입력
    public String inputRetry() throws IllegalArgumentException {
        systemMessage.askRetryMessage();
        String userInput = readLine();

        validator.retryValidation(userInput);

        return userInput;
    }
}
