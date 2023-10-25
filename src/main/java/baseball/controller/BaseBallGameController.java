package baseball.controller;

import static baseball.enums.Constant.GAME_RESTART_COMMAND;

import baseball.domain.BaseBallGameService;
import baseball.domain.ComputerRandomNumbers;
import baseball.utils.Utils;
import baseball.validator.InputValidate;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseBallGameController {

    private static final String CORRECT_RESULT = "3스트라이크";

    private final InputView inputView;
    private final OutputView outputView;
    private final BaseBallGameService baseBallGameService;
    private final InputValidate inputValidate;
    private ComputerRandomNumbers computerRandomNumbers;

    public BaseBallGameController(
            InputView inputView,
            OutputView outputView,
            BaseBallGameService baseBallGameService,
            InputValidate inputValidate
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.baseBallGameService = baseBallGameService;
        this.inputValidate = inputValidate;
    }

    public void run() {
        outputView.printStartMessage();
        boolean shouldStartGame = true;

        while (shouldStartGame) {
            startGame();

            outputView.printFinishMessage();
            outputView.printRestartOrEndMessage();

            String userGameCommand = inputView.getUserInput();
            inputValidate.validateGameCommand(userGameCommand);
            int numericValue = Character.getNumericValue(userGameCommand.charAt(0));
            if (numericValue == GAME_RESTART_COMMAND.getConstant()) {
                shouldStartGame = true;
            }
        }
    }

    private void startGame() {
        computerRandomNumbers = new ComputerRandomNumbers();

        while (true) {
            outputView.printInputNumberMessage();

            String userInput = inputView.getUserInput();
            validateInput(userInput);
            List<Integer> userInputs = Utils.stringToIntList(userInput);

            String result = baseBallGameService.startGame(computerRandomNumbers, userInputs);
            outputView.printResult(result);
            if (result.equals(CORRECT_RESULT)) {
                return;
            }
        }
    }

    // 게임 진행시 사용자의 숫자 모음 입력을 검증
    private void validateInput(String userInput) {
        inputValidate.validateNumeric(userInput);
        inputValidate.validateLength(userInput);
        inputValidate.validateDuplicateNumber(userInput);
    }

}
