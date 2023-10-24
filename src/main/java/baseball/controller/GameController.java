package baseball.controller;

import baseball.model.BallCount;
import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.UserComputerCompare;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;
import java.util.Map;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        try {
            outputView.printGameStart();
            Computer computer = Computer.createByNumber(Computer.createRandomNumbers());
            List<Integer> computerNumber = computer.getComputerNumber();
            System.out.println(computerNumber);
            Player player = Player.createNyNumber(inputView.readPlayerNumber());
            System.out.println(player.getPlayerNumber());
            UserComputerCompare referee = UserComputerCompare.judge(computer, player);
            Map<BallCount, Integer> ballCount = referee.getBallCountJudgement();

            System.out.println(ballCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
