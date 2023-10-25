package baseball.game;

import baseball.data.BaseballDataCompareResult;
import baseball.data.IBaseballDataBuilder;
import baseball.util.ISystemConsole;
import baseball.data.IBaseballData;

public class Game<T> {

    private final ISystemConsole systemConsole;
    private final IBaseballDataBuilder<T> baseballDataBuilder;
    private IBaseballData<T> computerBaseballData;
    private final IMessage gameMessage;

    public Game(ISystemConsole systemConsole, IBaseballDataBuilder<T> baseballDataBuilder,
            IMessage gameMessage) {
        this.systemConsole = systemConsole;
        this.baseballDataBuilder = baseballDataBuilder;
        this.gameMessage = gameMessage;
    }


    public void run() {
        this.systemConsole.println(this.gameMessage.greetingMessage());
        this.computerBaseballData = this.baseballDataBuilder.createComputerData();

        while (true) {
            this.systemConsole.open();
            this.systemConsole.print(this.gameMessage.requestNumberMessage());
            String input = this.systemConsole.scan();
            IBaseballData<T> userBaseballData = this.baseballDataBuilder.createUserData(input);
            BaseballDataCompareResult compareResult = this.computerBaseballData.compare(
                    userBaseballData);
            this.checkStrikeBallCount(compareResult);
            if (this.checkGameOver(compareResult, computerBaseballData)) {
                if (this.checkGameContinue()) {
                    continue;
                }
                break;
            }
        }
    }

    private void checkStrikeBallCount(BaseballDataCompareResult compareResult) {
        StringBuilder printString = new StringBuilder();
        if (compareResult.ball > 0) {
            printString.append(compareResult.ball + this.gameMessage.ballCountMessage());
        }
        if (compareResult.strike > 0) {
            printString.append(
                    compareResult.strike + this.gameMessage.strikeCountMessage());
        }
        if (compareResult.strike == 0 && compareResult.ball == 0) {
            printString.append(this.gameMessage.nothingMessage());
        }
        this.systemConsole.println(printString.toString());
    }

    private boolean checkGameOver(BaseballDataCompareResult compareResult,
            IBaseballData<T> computerBaseballData) {
        return compareResult.strike == computerBaseballData.getSize();
    }

    private boolean checkGameEnd() {
        this.systemConsole.println(
                this.computerBaseballData.getSize()
                        + this.gameMessage.gameOverMessage());
        this.systemConsole.println(this.gameMessage.retryMessage());
        int inputNumber = this.systemConsole.scanInt();
        if (inputNumber == 1) {
            this.computerBaseballData = this.baseballDataBuilder.createComputerData();
            return false;
        } else if (inputNumber == 2) {
            this.systemConsole.close();
            return true;
        }
        throw new IllegalArgumentException(this.gameMessage.retryErrorMessage());

    }
}
