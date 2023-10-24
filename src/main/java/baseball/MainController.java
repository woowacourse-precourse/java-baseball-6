package baseball;

import java.util.List;

public class MainController {

    private final InputController inputController;
    private final Referee referee = new Referee();
    private final OutputView outputView = new OutputView();

    public MainController(InputController inputController) {
        this.inputController = inputController;
    }

    public void play() {
        referee.initComputer();

        GameResult gameResult;
        do {
            List<Integer> numbers = inputController.getPlayerNumbers();
            gameResult = new GameResult();

            for (int index = 0; index < 3; index++) {
                Judgement judgement = referee.judge(new Player(numbers), index);
                gameResult.updateScore(judgement);
            }
            outputView.printResult(gameResult);
        } while (!gameResult.isThreeStrike());
        outputView.printGameFinish();
    }
}