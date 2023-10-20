package baseball.controller;

import baseball.model.Computer;
import baseball.model.Judgement;
import baseball.model.NumberGenerator;
import baseball.model.Player;
import baseball.model.Result;
import baseball.view.Input;
import baseball.view.Output;
import java.util.Map;

public class GameController {

    private final Input input = new Input();
    private final Output output = new Output();

    public void play() {
        output.showStartMessage();
        output.showInputMessage();

        String playerNumber = input.readNumber();
        Player player = new Player(playerNumber);

        NumberGenerator numberGenerator = new NumberGenerator();
        Computer computer = new Computer(numberGenerator.createComputerNumbers());

        Judgement judgement = new Judgement();
        Map<Result, Integer> gameResult = judgement.judge(computer, player);
    }
}
