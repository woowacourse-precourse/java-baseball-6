package baseball.contoller;


import baseball.model.Result;
import baseball.utill.Converter;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
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
        List<Integer> computerNumbers = generateComputerNumber();
        boolean continueSign = true;
        while (continueSign) {
            List<String> inputString = inputView.readPlayerNumber();
            List<Integer> inputInteger = converter.convertToNumericList(inputString);
            Result result = new Result();
            result.calculateResult(computerNumbers,inputInteger);
            outputView.printResult(result.resultToString());
            continueSign = result.isContinue();
        }
        outputView.printEndMessage();
    }

    private List<Integer> generateComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private boolean isEnd(int sign) {
        if(sign == 1){
            return true;
        }
        if(sign == 2){
            return false;
        }
        throw new IllegalArgumentException();
    }
}
