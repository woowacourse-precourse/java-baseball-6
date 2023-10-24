package baseball.game;

import baseball.data.BaseballDataCompareResult;
import baseball.data.IBaseballDataBuilder;
import baseball.util.ISystemConsole;
import baseball.data.IBaseballData;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {

    private ISystemConsole systemConsole;
    private IBaseballDataBuilder baseballDataBuilder;
    private IBaseballData computerBaseballData;
    private IMessage gameMessage;

    public Game(ISystemConsole systemConsole, IBaseballDataBuilder baseballDataBuilder,
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
            if (!isValidInput(input)) {
                throw new IllegalArgumentException(this.gameMessage.inputNumberErrorMessage());
            }

            IBaseballData userBaseballData = this.baseballDataBuilder.createUserData(input);
            BaseballDataCompareResult compareResult = this.computerBaseballData.compare(
                    userBaseballData);
            this.checkStrikeBallCount(compareResult);
            if (compareResult.strike == this.computerBaseballData.getSize()) {
                if (checkGameEnd()) {
                    break;
                }
            }
        }
    }

    private boolean isValidInput(String input) {
        String regex = "^(?!.*(.).*\\1)[1-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
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
