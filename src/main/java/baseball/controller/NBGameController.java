package baseball.controller;

import baseball.model.Computer;
import baseball.model.BaseballCount;
import baseball.model.convertor.NumberTypeConvertor;
import baseball.model.validator.NumberValidation;
import baseball.model.validator.RestartNumberValidation;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;
import java.util.Map;

public class NBGameController {

    private InputView in;
    private OutputView out;
    private NumberValidation numberValidation;
    private RestartNumberValidation restartNumberValidation;
    private NumberTypeConvertor numberTypeConvertor;

    private static final int RESTART_GAME = 1;
    private static final int END_GAME = 2;

    public NBGameController() {
        in = new InputView();
        out = new OutputView();
        numberValidation = new NumberValidation();
        numberTypeConvertor = new NumberTypeConvertor();
        restartNumberValidation = new RestartNumberValidation();
    }

    public void run() {
        out.displayStartMessage();
        int restart = RESTART_GAME;
        while (restart == RESTART_GAME) {
            Computer computer = Computer.generateRandomNumber();

            startGame(computer);

            out.displayEndMessage();

            restart = Integer.parseInt(in.inputRestartNumber());
            restartNumberValidation.validateNumber(restart);
        }
    }

    private void startGame(Computer computer) {
        int strike = 0;
        while (is3Strike(strike)) {
            String user = in.inputBaseballNumber();

            numberValidation.validateNumber(user);

            List<Integer> userIntList = numberTypeConvertor.toListInteger(user);

            BaseballCount baseballCount = new BaseballCount();
            List<Integer> comIntList = computer.getComputerNumber();
            Map<String, Integer> pitched = baseballCount.pitch(userIntList, comIntList);

            out.displayResult(pitched.get("strike"), pitched.get("ball"));

            strike = pitched.get("strike");
        }
    }

    private boolean is3Strike(int strike) {
        return strike != 3;
    }
}
