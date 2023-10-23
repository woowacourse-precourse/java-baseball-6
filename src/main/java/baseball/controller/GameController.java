package baseball.controller;

import baseball.BaseballGame;
import baseball.domain.GameInfo;
import baseball.service.GameService;
import baseball.validation.InputValidation;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.constant.MessageConst.*;

/**
 * 유저의 입출력을 처리하는 컨트롤러
 */
public class GameController {
    private final InputValidation inputValidation = new InputValidation();
    private final GameService gameService = new GameService();

    public String getUserInput() {
        System.out.print(USER_INPUT_MSG);
        String userInput = Console.readLine();
        inputValidation.validateInputNum(userInput);
        return userInput;
    }

    public void controlRestartOrExit() {
        System.out.println(RESTART_EXIT_MSG);
        int input = Integer.parseInt(Console.readLine());
        inputValidation.validateOneOrTwo(input);
        if (input == 1) {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.run();
        }
    }

    public void checkStrikeOrBall(int ballCount, int strikeCount) {
        StringBuilder outputResult = gameService.checkStrikeOrBall(ballCount, strikeCount);
        System.out.println(outputResult);
    }

    public List<Integer> generateRandomDistinctThreeDigit() {
        return gameService.generateRandomDistinctThreeDigit();
    }

    public void countStrikeOrBall(GameInfo gameInfo, String userInput) {
        gameService.countStrikeOrBall(gameInfo, userInput);
    }

    public void startGame() {
        System.out.println(START_GAME_MSG);
    }
}
