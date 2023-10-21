package controller;

import Util.ComputerNumberGenerator;
import java.util.ArrayList;
import java.util.List;
import view.BaseballGameView;

public class BaseballGameController {
    private BaseballGameView baseballGameView = new BaseballGameView();

    public void doBaseballGame() {
        List<Integer> computer = ComputerNumberGenerator.generate();

        List<Integer> userNumbers = new ArrayList<>();

        while (!computer.equals(userNumbers)) {
            userNumbers = baseballGameView.getUserNumberList();
        }
    }
}
