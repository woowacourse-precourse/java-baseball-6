package baseball.domain;

import baseball.utill.Converter;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {



    public void run() {
        OutputView.printStartMessage();
        startNewGame();
    }
    private void startNewGame() {
        List<Integer> computerNumbers = generateComputerNumber();
        System.out.println(computerNumbers.toString());
        boolean continueSign = true;
        while(continueSign){
            List<String> inputString = InputView.readPlayerNumber();
            List<Integer> inputInteger = Converter.convertToNumericList(inputString);
            Result result = new Result(computerNumbers,inputInteger);
            OutputView.printResult(result.resultToString());
            continueSign = isContinue(result);
        }
        OutputView.printEndMessage();
    }
    private List<Integer> generateComputerNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    private boolean isContinue(Result result){
        return result.getStrikeCount() != 3;
    }
}
