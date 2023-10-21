package baseball.controller;

import baseball.application.NumberService;
import baseball.domain.Player;
import baseball.util.NumberUtil;
import baseball.view.ViewService;

public class GameController {

    private final NumberService numberService;
    private final ViewService viewService;

    public GameController(NumberService numberService, ViewService viewService) {
        this.numberService = numberService;
        this.viewService = viewService;
    }

    private Player prepareComputer() {
        Player computer = new Player();
        computer.setPlayer(numberService.getRandomNumber());
        return computer;
    }

    private Player preparePlayer() {
        Player player = new Player();

        viewService.printReadMessage();
        String number = viewService.readNumber();
        NumberUtil.validate(number);
        player.setPlayer(NumberUtil.converStringToList(number));

        return player;
    }
}
