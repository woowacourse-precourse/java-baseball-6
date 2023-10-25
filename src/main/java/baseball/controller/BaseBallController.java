package baseball.controller;

import baseball.common.StringToInteger;
import baseball.dto.BaseBallResult;
import baseball.model.ContinueOrExit;
import baseball.service.BaseBallService;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseBallController {

    private static final BaseBallController instance = new BaseBallController();

    public static BaseBallController getInstance() {
        return instance;
    }

    private BaseBallController() {
    }

    private BaseBallService baseBallService = BaseBallService.getInstance();

    public void run() {
        int continueOrExit = 1;
        while (continueOrExit == 1) {
            List<Integer> computerNumber = baseBallService.getComputerNumber();
            BaseBallResult result = new BaseBallResult(0, 0, false);
            while (result.getStrikeCnt() != 3) {
                OutputView.printInputMessage();
                String userInputString = Console.readLine();
                List<Integer> userNumber = baseBallService.getUserNumber(userInputString);
                result = baseBallService.compareNumber(computerNumber, userNumber);
                OutputView.printResultMessage(result);
            }

            OutputView.printContinue();
            String userInputContinue = Console.readLine();
            int convertedUserInput = StringToInteger.convert(userInputContinue);
            ContinueOrExit afterValidate = new ContinueOrExit(convertedUserInput);
            continueOrExit = convertedUserInput;
        }
    }
}
