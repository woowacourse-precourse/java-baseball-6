package baseball.service;

import baseball.model.Computer;
import baseball.model.Judgement;
import baseball.model.NumberGenerator;
import baseball.model.Player;

public class GameService {

    private final NumberGenerator numberGenerator = new NumberGenerator();

    private Player player;
    private Computer computer;
    private Judgement judgement;

    public void init() {
        computer = new Computer(numberGenerator.createComputerNumbers());
        judgement = new Judgement();
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
