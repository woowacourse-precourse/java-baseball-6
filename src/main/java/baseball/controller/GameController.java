package baseball.controller;

import baseball.constant.Number;
import baseball.service.ComputerService;
import baseball.service.UserService;

import java.util.List;

import static baseball.constant.Number.FAIL;
import static baseball.constant.Number.RESTART;

public class GameController {
    private final UserService userService = new UserService();
    private final ComputerService computerService = new ComputerService();

    public GameController() {
        computerService.printInit();
    }

    public void baseBallGame() {
        int retryNumber = RESTART;
        List<Integer> computerNumbers = computerService.generateComputerNumbers();

        while (retryNumber == RESTART) {

            playRound(computerNumbers);

            retryNumber = userService.readRetryNumber();
            if (retryNumber == RESTART) {
                computerNumbers = computerService.generateComputerNumbers();
            }
        }
    }

    private void playRound(List<Integer> computerNumbers){
        boolean result = FAIL;
        while(result == FAIL){
            List<Integer> userNumbers = userService.readUserNumber();
            result = computerService.getResult(computerNumbers, userNumbers);
        }
    }

}
