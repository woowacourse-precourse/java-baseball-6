package baseball.service;

import baseball.model.Computer;
import baseball.model.Judgement;
import baseball.model.NumberGenerator;
import baseball.model.Player;

public class GameService {

    private final NumberGenerator numberGenerator = new NumberGenerator();
    private final Judgement judgement = new Judgement();

    private Computer computer;
    private Player player;

    public void init() {
        computer = new Computer(numberGenerator.createComputerNumbers());
    }

    public boolean isGameOver() {
        return judgement.isAllStrike();
    }

    public void makePlayer(String inputNumber) {
        player = new Player(inputNumber);
    }

    public void judge() {
        judgement.judge(computer, player);
    }

    public Judgement getJudgement() {
        return judgement;
    }
}
