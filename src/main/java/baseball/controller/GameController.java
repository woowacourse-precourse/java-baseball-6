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
    private final int VALUE_RANGE = 3;
    private GameModel gameModel;
    private HumanModel humanModel;
    private ComputerModel computerModel;

    public void startGame() {
        OutputView.displayGameStart();
        gameModel = new GameModel();
        setComputers();
        do {
            setHumans();
            compareNumbers();
            OutputView.displayScoreboard(humanModel);
            if (humanModel.getStrike() == 3) {
                changeGameState();
            }
        } while (gameModel.isRunning());
    }

    private void setHumans() {
        humanModel = new HumanModel(InputView.inputNumbers());
    }

    private void setComputers() {
        List<Integer> computers = new ArrayList<>();
        while (computers.size() < VALUE_RANGE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computers.contains(randomNumber)) {
                computers.add(randomNumber);
            }
        }
        computerModel = new ComputerModel(computers);
    }

    private void compareNumbers() {
        List<Integer> human = humanModel.getHumans();
        List<Integer> computer = computerModel.getComputers();
        int[] strikeIdx = checkStrike(human, computer);
        checkBall(human, computer, strikeIdx);
        checkNothing();
    }

    private int[] checkStrike(List<Integer> human, List<Integer> computer) {
        int[] strikeIdx = new int[VALUE_RANGE];
        int strike = 0;

        for (int i = 0; i < VALUE_RANGE; i++) {
            if (human.get(i).equals(computer.get(i))) {
                strike += 1;
                strikeIdx[i] = 1;
            }
        }

        humanModel.setStrike(strike);

        return strikeIdx;
    }

    private void checkBall(List<Integer> human, List<Integer> computer, int[] strikeIdx) {
        int ball = 0;
        for (int i = 0; i < VALUE_RANGE; i++) {
            if (strikeIdx[i] == 1) {
                continue;
            }
            if (computer.contains(human.get(i))) {
                ball += 1;
            }
        }

        humanModel.setBall(ball);
    }

    private void checkNothing() {
        if (humanModel.getBall() == 0 && humanModel.getStrike() == 0) {
            humanModel.setNothing(1);
        }
    }

    private void changeGameState() {
        OutputView.displayGameExit();
        int input = InputView.inputNumber();
        if (input == 1) {
            setComputers();
        }
        if (input == 2) {
            gameModel.setRunning(false);
        }
    }
}
