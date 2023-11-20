package baseball.Service;

import baseball.Domain.Compare;
import baseball.Domain.ConvertNumber;
import baseball.Domain.CreateResultData;
import baseball.View.InputView;
import baseball.View.OutputView;

public class BaseballGameRule {
    public void run() {
        while(true) {
            saveUserNumbers(enterNumbers());
            compareNumbers();
            resultView();
            if(distinguishResult()){
                return;
            }
        }
    }

    private int enterNumbers() {
        InputView inputView = new InputView();
        ConvertNumber convertNumber = new ConvertNumber();
        return convertNumber.convertNumber(inputView.enterNumbers());
    }

    private void saveUserNumbers(int enterNumbers) {
        ConvertNumber convertNumber = new ConvertNumber();
        convertNumber.userNumbers(enterNumbers);
    }

    private void compareNumbers() {
        Compare compare = new Compare();
        compare.compareNumbers();
    }

    private void resultView() {
        OutputView outputView = new OutputView();
        outputView.resultView(gameResult());

    }

    private String gameResult() {
        CreateResultData createResultDate = new CreateResultData();
        return createResultDate.createResultDate();
    }

    private boolean distinguishResult() {
        CreateResultData createResultDate = new CreateResultData();
        return createResultDate.distinguishResult();
    }
}
