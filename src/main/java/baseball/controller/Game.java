package baseball.controller;

import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final OutputView outputView = new OutputView();
    private List<Integer> computer;
    private List<Integer> player;

    public Game() {
        computer = new ArrayList<>();
        player = new ArrayList<>();

        outputView.printStartGame();
    }
}
