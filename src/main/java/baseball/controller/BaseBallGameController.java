package baseball.controller;

import baseball.domain.BaseBallGameService;
import baseball.domain.ComputerRandomNumbers;
import baseball.validator.InputValidate;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class BaseBallGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BaseBallGameService baseBallGameService;
    private final InputValidate inputValidate;

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
        
        String userInput = inputView.getUserInput();
        inputValidate.validateNumeric(userInput);
        inputValidate.validateLength(userInput);
        inputValidate.validateDuplicateNumber(userInput);

        List<Integer> userInputs = userInput.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());

        ComputerRandomNumbers computerRandomNumbers = new ComputerRandomNumbers();

        baseBallGameService.startGame(computerRandomNumbers, userInputs);
    }

}
