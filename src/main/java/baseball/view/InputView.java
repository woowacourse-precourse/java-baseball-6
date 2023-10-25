package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final OutputView outputView;
    private final InputValidation inputValidation;

    public InputView() {
        this.inputValidation = new InputValidation();
        this.outputView = new OutputView();
    }

    public String inputNumber() {
        outputView.printInputNumber();
        String inputNumber = Console.readLine();

        inputValidation.checkLengthThree(inputNumber);
        inputValidation.checkStringRegex(inputNumber);

        return inputNumber;
    }

    public String reStart() {
        outputView.printRestart();
        String inputOption = Console.readLine();

        inputValidation.checkLengthOne(inputOption);
        inputValidation.checkOneOrTwoRegex(inputOption);

        return inputOption;
    }
}
