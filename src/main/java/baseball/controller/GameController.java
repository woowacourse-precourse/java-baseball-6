package baseball.controller;

import baseball.service.ComputerService;
import baseball.service.JudgeService;
import baseball.service.UserService;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameController {
    private ComputerService computerService;
    private UserService userService;
    private JudgeService judgeService;

    public GameController(ComputerService computerService, UserService userService, JudgeService judgeService) {
        this.computerService = computerService;
        this.userService = userService;
        this.judgeService = judgeService;
    }

    public void playGame() {
        List<Integer> computerNumber = computerService.generateRandom();
        boolean threeStrike = false;

        while (!threeStrike) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> userNumber = userService.generateInput();
            judgeService.judgeResult(computerNumber, userNumber);
            judgeService.printResult();

            threeStrike = judgeService.checkThree();
            statusReset();
        }
    }

    private void statusReset() {
        judgeService.resetResult();
        userService.resetInput();
    }

    public boolean checkRestartOrQuit() {
        String s = Console.readLine();
        switch (s) {
            case "1":
                randomReset();
                return false;
            case "2":
                return true;
            default:
                throw new IllegalArgumentException("Invalid input");
        }
    }

    private void randomReset() {
        computerService.resetRandom();
    }
}
