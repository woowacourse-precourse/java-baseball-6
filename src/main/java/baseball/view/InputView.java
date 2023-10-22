package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final OutputView outputView;

    public InputView() {
        this.outputView = new OutputView();
    }

    public String inputNumber() {
        outputView.printInputNumber();
        String inputNumber = Console.readLine();

        Validation.checkLengthThree(inputNumber);
        Validation.checkStringRegex(inputNumber);

        return inputNumber;
    }

    public String reStart() {
        outputView.printRestart();
        String inputOption = Console.readLine();

        Validation.checkLengthOne(inputOption);
        Validation.checkStringRegex(inputOption);

        return inputOption;
    }
}
