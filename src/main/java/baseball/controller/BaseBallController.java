package baseball.controller;

import baseball.dto.BaseBallResult;
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
        boolean isContinue = true;
        while (isContinue) {
            List<Integer> computerNumber = baseBallService.getComputerNumber();
            BaseBallResult result = new BaseBallResult(0, 0, false);
            while (result.getStrikeCnt() != 3) {
                OutputView.printInputMessage();
                // 그냥 엔터 유효성 검사필요
                String userInputString = Console.readLine();
                List<Integer> userNumber = baseBallService.getUserNumber(userInputString);
                result = baseBallService.compareNumber(computerNumber, userNumber);
                OutputView.printResultMessage(result);
            }

            while (true) {
                OutputView.printContinue();
                String userInputContinue = Console.readLine();
                try {
                    int parseInt = Integer.parseInt(userInputContinue);
                    if (parseInt == 1) {
                        isContinue = true;
                        break;
                    } else if (parseInt == 2) {
                        isContinue = false;
                        break;
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
}
