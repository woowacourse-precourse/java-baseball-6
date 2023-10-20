package baseball;

public class BaseballController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Player player;

    public BaseballController(Player player) {
        this.outputView = new OutputView();
        this.inputView = new InputView(outputView);
        this.player = player;
    }

    public void run(){
        outputView.printStartBaseBallGameMessage();

        while (true){
            CheckBallAndStrike checkBallAndStrike = new CheckBallAndStrike();
            while (checkBallAndStrike.isThreeStrike()){
                String expectedNumber = inputView.inputExpectedNumber();
                player.changeExpectedNumbers(expectedNumber);
                checkBallAndStrike.updateBallAndStrike(player);
                outputView.printStatusBallAndStrike(checkBallAndStrike.statusBallAndStrike());
            }
            outputView.printClearBaseBallGame();
            int restartMessage = inputView.inputRestartMessage();
            if (BaseballRole.isGameExit(restartMessage)) break;
        }
    }

}
