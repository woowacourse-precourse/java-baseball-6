package baseball.Controller;

import baseball.model.Restart;
import baseball.service.CompareNumber;
import baseball.service.ComputerService;
import baseball.service.PlayerService;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.message.Message.RESTART;

public class BaseballGameController {

    private static ComputerService computerService = new ComputerService();
    private static List<Integer> computer = computerService.createComputerList();

    private static PlayerService playerService = new PlayerService();
    private static List<Integer> player;

    private static CompareNumber compareNumber = new CompareNumber();

    private static Restart restart;

    private static final int RESTART_GAME = 1;
    public void gameStart() {
        View.printStart();
        compareResult();
    }

    public static void compareResult() {
        setPlayerInput();
        compareNumber.checkBallAndStrike(computer, player);
        if (compareNumber.threeStrikes()) {
            restartGame();
            return;
        }
        compareResult();
    }

    public static void restartGame() {
        String input = View.printRestart();
        restart = new Restart(input);
        int parsedInput = Integer.parseInt(input);
        if (parsedInput == RESTART) {
            computer = computerService.createComputerList();
            compareResult();
        }
    }

    public static void setPlayerInput() {
        String input = View.printInput();
        player = playerService.createPlayerList(input);
    }

}
