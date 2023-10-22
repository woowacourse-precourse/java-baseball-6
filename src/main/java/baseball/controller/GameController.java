package baseball.controller;

import baseball.BaseballGame;
import baseball.domain.GameInfo;
import baseball.service.GameService;
import baseball.validation.InputValidation;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.constant.MessageConst.*;
import static baseball.constant.NumberConst.SUCCESS_STRIKE;

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
        StringBuilder sb = new StringBuilder();
        if (ballCount == 0 && strikeCount == 0) {
            sb.append(NOTHING);
        }
        if (ballCount != 0) {
            sb.append(ballCount).append(BALL).append(" ");
        }
        if (strikeCount != 0) {
            sb.append(strikeCount).append(STRIKE);
        }
        if (strikeCount == SUCCESS_STRIKE) {
            sb.append("\n");
            sb.append(SUCCESS_MSG);
        }
        System.out.println(sb);
    }

    public List<Integer> generateRandomDistinctThreeDigit() {
        return gameService.generateRandomDistinctThreeDigit();
    }

    public void countStrikeOrBall(GameInfo gameInfo, String userInput) {
        gameService.countStrikeOrBall(gameInfo, userInput);
    }
}
