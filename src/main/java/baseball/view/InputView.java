package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final OutputView outputView;

    public InputView() {
        this.outputView = new OutputView();
    }

    public String inputNumber() {
        String inputNumber = Console.readLine();
        outputView.printInputNumber();

        Validation.checkLengthThree(inputNumber);
        Validation.checkStringRegex(inputNumber);

        return inputNumber;
    }

    public String reStart() {
        String inputOption = Console.readLine();
        outputView.printRestart();

        Validation.checkLengthOne(inputOption);
        Validation.checkStringRegex(inputOption);

        return inputOption;
    }
}
