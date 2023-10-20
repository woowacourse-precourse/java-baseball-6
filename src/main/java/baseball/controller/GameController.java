package baseball.controller;

import baseball.model.ComputerModel;
import baseball.model.GameModel;
import baseball.model.HumanModel;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private GameModel gameModel;
    private HumanModel humanModel;
    private ComputerModel computerModel;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {
        outputView.displayGameStart();
        gameModel = new GameModel();
        setComputers();
        do {
            setHumans();
        } while (gameModel.isRunning());
    }
    private void setHumans() {
        humanModel = new HumanModel(inputView.inputNumbers());
    }

    private void setComputers() {
        List<Integer> computers = new ArrayList<>();
        while (computers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computers.contains(randomNumber)) {
                computers.add(randomNumber);
            }
        }
        computerModel = new ComputerModel(computers);
    }
}
