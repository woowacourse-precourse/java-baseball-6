package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.domain.Computer;
import baseball.service.BaseballGameService;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;
import java.util.StringTokenizer;

public class BaseballGameController {

    private BaseballGameService baseballGameService;


    private Boolean RestartFlag = true;

    public BaseballGameController() {
        OutputView.printGameInitMessage();
    }

    public void gameStart() {
        String userNumber;
        this.baseballGameService = new BaseballGameService();

        do {
            InputView.printInputNumberMessage();

            userNumber = InputView.readUserNumberInput();


            validateUserNumber(userNumber);
            String[] results = baseballGameService.run(userNumber);
            new OutputView(results);

            if (results[1].equals("3")) {
                OutputView.printAnswerMessage();
                OutputView.printRestartGameMessage();

                String input = InputView.readRestartNumberInput();
                validateRestartNumber(input);

                if (input.equals("1")) {
                    baseballGameService = new BaseballGameService();
                }
                if (input.equals("2")) {
                    RestartFlag = false;
                }
            }

        } while (RestartFlag);

    }

    public void validateUserNumber(String userNumber) {
        if (userNumber.length() != 3) throw new IllegalArgumentException();

        for (int i = 0; i < userNumber.length(); i++) {
            if (userNumber.charAt(i) - '0' < 1 || userNumber.charAt(i) - '0' > 9) {
                throw new IllegalArgumentException();
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (userNumber.charAt(i) == userNumber.charAt(j)) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    public void validateRestartNumber(String input) {
        if (!input.equals("1") && !input.equals("2")) throw new IllegalArgumentException();

    }


}
