package baseball.service;

import baseball.view.InputView;
import java.util.List;

public class BaseballService {
    private final InputView inputView = new InputView();
    private final ValidationService validationService = new ValidationService();

    public void baseballGameStart(List<Integer> integerList) {
        boolean isDifferent = true;
        while (isDifferent) {
            String input = inputView.getInput();
            validationService.isValidNumber(input);
        }
    }


}
