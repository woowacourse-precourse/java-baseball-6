package baseball.Controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.service.CompareNumber;
import baseball.service.ComputerService;
import baseball.service.PlayerService;
import baseball.view.View;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameController {

    private static ComputerService computerService = new ComputerService();
    private static List<Integer> computer = computerService.createComputerList();

    private static PlayerService playerService = new PlayerService();
    private static List<Integer> player;

    private static CompareNumber compareNumber = new CompareNumber();

    public static void gameStart() {
        View.printStart();
        playerInput();
        compareNumber.checkStrike(computer, player);
    }

    public static void playerInput() {
        String input = View.printInput();
        player = playerService.createPlayerList(input);
    }

}
