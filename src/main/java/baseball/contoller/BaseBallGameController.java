package baseball.contoller;


import baseball.domain.Computer;
import baseball.domain.Result;
import baseball.domain.User;
import baseball.utill.Converter;
import baseball.utill.ExceptionMessage;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseBallGameController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final Converter converter = new Converter();


    public void run() {
        outputView.printStartMessage();
        boolean endSign = true;
        while (endSign) {
            startNewGame();
            endSign = isEnd(inputView.readEndSign());
        }

    }

    private void startNewGame() {
        Computer computer = new Computer();
        computer.generateComputerNumber();
        boolean continueSign = true;
        while (continueSign) {
            List<String> inputString = inputView.readPlayerNumber();
            List<Integer> inputInteger = converter.convertToNumericList(inputString);
            User user = new User(inputInteger);
            Result result = new Result(computer, user);
            outputView.printResult(result.resultToString());
            continueSign = result.isContinue();
        }
        outputView.printEndMessage();
    }

    private boolean isEnd(int sign) {
        if (sign == 1) {
            return true;
        }
        if (sign == 2) {
            return false;
        }
        throw new IllegalArgumentException(ExceptionMessage.INVALID_GAME_COMMAND.getMessage());
    }
}
