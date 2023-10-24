package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.dto.response.GameResultResponse;
import baseball.service.ComputerService;
import baseball.service.GameService;
import baseball.service.UserService;
import baseball.view.InputView;
import baseball.view.OutputView;

import static baseball.common.config.GameConfig.NUMBER_SIZE;

public class GameController {
    private final ComputerService computerService;
    private final GameService gameService;
    private final UserService userService;

    public GameController(final ComputerService computerService,
                          final GameService gameService,
                          final UserService userService) {
        this.computerService = computerService;
        this.gameService = gameService;
        this.userService = userService;
    }
    private void playOneGame() {
        OutputView.printStartMessage();
        final Computer computer = computerService.createComputerNumber();
        while (true) {
            final User user = userService.createUserNumber(InputView.requestUserNumber());
            final GameResultResponse gameResultResponse = gameService.getResult(computer, user);
            OutputView.printResult(gameResultResponse);

            if (allSolved(gameResultResponse)) {
                break;
            }
        }
        OutputView.printGameOverMessage();
    }

    private boolean allSolved(final GameResultResponse gameResultResponse) {
        return gameResultResponse.getStrikeCount() == NUMBER_SIZE;
    }
}
