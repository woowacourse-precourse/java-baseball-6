package baseball.service;

import baseball.model.Command;
import baseball.model.Computer;
import baseball.model.Judgement;
import baseball.model.NumberGenerator;
import baseball.model.Player;

public class GameService {

    private final NumberGenerator numberGenerator = new NumberGenerator();

    private Computer computer;
    private Judgement judgement;

    public void init() {
        computer = new Computer(numberGenerator.createComputerNumbers());
        judgement = new Judgement();
    }

    public void playGame(String number) {
        Player player = new Player(number);
        judgement.judge(computer, player);
    }

    public boolean isGameOver() {
        return judgement.isAllStrike();
    }

    public Judgement getJudgement() {
        return judgement;
    }

    public boolean restartsGame(String number) {
        return Command.find(number).equals(Command.RESTART);
    }
}
