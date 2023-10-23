package baseball.controller;

import baseball.model.BallNumber;
import baseball.model.BaseballNumber;
import baseball.model.Result;
import baseball.view.GameView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameController {
    private BaseballNumber computerNumber;
    private BaseballNumber userNumber;
    private GameView gameView = new GameView();

    public void startGame() {
        generateComputerNumber();

        gameView.showGameStart();
        while (true) {
            String userNumberReadLine = gameView.getUserNumber();
            initUserNumber(userNumberReadLine);

            Result result = computerNumber.compare(userNumber);

            gameView.showGameResult(result);

            if (result.isEnd()) {
                gameView.showEnd();
                break;
            }
        }

        restart();
    }

    private void restart() {
        String restart = gameView.inputGameRestart();
        if ("1".equals(restart)) {
            startGame();
        }
    }

    private void initUserNumber(String userNumberReadLine) {
        List<BallNumber> ballNumberList = convertInputToBallNumberList(userNumberReadLine);

        validDuplicate(ballNumberList);

        userNumber = new BaseballNumber(ballNumberList);
    }

    private void validDuplicate(List<BallNumber> ballNumberList) {
        Set<BallNumber> ballNumberSet = new HashSet<>(ballNumberList);
        if (ballNumberSet.size() != ballNumberList.size()) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
    }

    private List<BallNumber> convertInputToBallNumberList(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }

        char[] inputChar = input.toCharArray();
        List<BallNumber> ballNumberList = new ArrayList<>();
        for (char c : inputChar) {
            ballNumberList.add(new BallNumber(Character.getNumericValue(c)));
        }
        return ballNumberList;
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
