package baseball.Controller;

import baseball.service.CompareNumber;
import baseball.service.ComputerService;
import baseball.service.PlayerService;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGameController {

    private static ComputerService computerService = new ComputerService();
    private static List<Integer> computer = computerService.createComputerList();

    private static PlayerService playerService = new PlayerService();
    private static List<Integer> player;

    private static CompareNumber compareNumber = new CompareNumber();

    public void gameStart() {
        View.printStart();
        compareResult();
    }

    public static void compareResult() {
        setPlayerInput();
        compareNumber.checkStrike(computer, player);
        if (compareNumber.threeStrikes()) {
            restartGame();
        }
        else {
            compareResult();
        }
    }

    public static void restartGame() {
        View.printRestart();
        String input = Console.readLine();
        int parsedInput = Integer.parseInt(input);
        if (parsedInput == 1) {
            computer = computerService.createComputerList();
            compareResult();
        }
    }

    public static void setPlayerInput() {
        String input = View.printInput();
        player = playerService.createPlayerList(input);
    }

}
