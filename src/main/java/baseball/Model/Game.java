package baseball.Model;

import baseball.Controller.PlayerController;
import baseball.Controller.RefereeController;
import baseball.View.PlayerTerminalView;
import baseball.View.RefereeTerminalView;

public class Game {
    private PlayerController playerController;
    private RefereeController refereeController;
    private Computer computer;

    public Game() {
        playerController = new PlayerController(new Player(), new PlayerTerminalView());
        refereeController = new RefereeController(new Referee(), new RefereeTerminalView());
        computer = new Computer();
    }

    public PlayerController getPlayerController() {
        return playerController;
    }

    public RefereeController getRefereeController() {
        return refereeController;
    }

    public Computer getComputer() {
        return computer;
    }
}
