package baseball.controller;

import baseball.model.BallNumber;
import baseball.model.BaseballNumber;
import baseball.view.GameView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private BaseballNumber computerNumber;
    private BaseballNumber userNumber;
    private GameView gameView = new GameView();

    public void startGame() {
        generateComputerNumber();

        gameView.showGameStart();
        String userNumberReadLine = gameView.getUserNumber();
    }

    private void generateComputerNumber() {
        List<BallNumber> ballNumberList = new ArrayList<>();
        while (ballNumberList.size() < 3) {
            BallNumber ballNumber = new BallNumber(Randoms.pickNumberInRange(1, 9));
            if (!ballNumberList.contains(ballNumber)) {
                ballNumberList.add(ballNumber);
            }
        }

        this.computerNumber = new BaseballNumber(ballNumberList);
    }
}
