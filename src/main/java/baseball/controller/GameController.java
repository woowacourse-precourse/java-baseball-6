package baseball.controller;

import baseball.constant.Number;
import baseball.service.ComputerService;
import baseball.service.UserService;

import java.util.List;

public class GameController {
    private final UserService userService = new UserService();
    private final ComputerService computerService = new ComputerService();

    //게임시작
    public GameController() {
        computerService.printStart();
    }

    public void baseBallGame() {
        int retryNumber = Number.RESTART;
        List<Integer> computerNumbers = computerService.generateComputerNumbers();

        while (retryNumber == Number.RESTART) {

            playRound(computerNumbers);

            retryNumber = userService.readRetryNumber();
            if (retryNumber == Number.RESTART) {
                computerNumbers = computerService.generateComputerNumbers();

            }
        }
    }

    private void playRound(List<Integer> computerNumbers){
        boolean gameResult = false;
        while(!gameResult){
            List<Integer> userNumbers = userService.readUserNumber();
            gameResult = computerService.printResult(computerNumbers, userNumbers);
        }

    }

}
