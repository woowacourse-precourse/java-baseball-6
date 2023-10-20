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
            compareNumbers();
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

    public void compareNumbers() {
        List<Integer> human = humanModel.getHumans();
        List<Integer> computer = computerModel.getComputers();
        int[] strikeIdx = checkStrike(human, computer);
        checkBall(human, computer, strikeIdx);
        checkNothing();
    }

    private int[] checkStrike(List<Integer> human, List<Integer> computer){
        int[] strikeIdx = new int[3];
        int strike = 0;

        for(int i = 0; i < 3; i++) {
            if(human.get(i).equals(computer.get(i))){
                strike += 1;
                strikeIdx[i] = 1;
            }
        }

        gameModel.setStrike(strike);

        return strikeIdx;
    }

    private void checkBall(List<Integer> human, List<Integer> computer, int[] strikeIdx){
        int ball = 0;
        for(int i = 0; i < 3; i++) {
            if(strikeIdx[i] == 1) continue;
            if(computer.contains(human.get(i))) {
                ball += 1;
            }
        }

        gameModel.setBall(ball);
    }

    private void checkNothing() {
        if(gameModel.getBall() == 0 && gameModel.getStrike() == 0){
            gameModel.setNothing(1);
        }
    }

}
