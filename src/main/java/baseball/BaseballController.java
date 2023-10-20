package baseball;

public class BaseballController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Player player;

    public BaseballController(Player player) {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.player = player;
    }

    public void run(){
        outputView.printStartBaseBallGameMessage();
        CheckBallAndStrike checkBallAndStrike = new CheckBallAndStrike();
        while (checkBallAndStrike.isThreeStrike()){
            inputView.inputExpectedNumber(player);
            checkBallAndStrike.updateBallAndStrike(player);
            outputView.printStatusBallAndStrike(checkBallAndStrike.statusBallAndStrike());
        }
        outputView.printClearBaseBallGame();
    }

}
