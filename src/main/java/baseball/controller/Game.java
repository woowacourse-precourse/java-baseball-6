package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.PlayerNumber;
import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private static ComputerNumber computerNumber;
    private static PlayerNumber playerNumber;
    private final OutputView outputView = new OutputView();
    private List<Integer> computer;
    private List<Integer> player;

    public Game() {
        computerNumber = new ComputerNumber();
        playerNumber = new PlayerNumber();
        
        computer = new ArrayList<>();
        player = new ArrayList<>();

        outputView.printStartGame();
    }


}
