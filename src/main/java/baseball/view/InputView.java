package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidator inputValidator;
    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.inputValidator =  new InputValidator();
        this.outputView = outputView;
    }

    public String inputExpectedNumber(){
        outputView.printInputExpectedNumberMessage();
        String number = Console.readLine();
        inputValidator.validateNumeric(number);
        return number;
    }

    public int inputRestartMessage(){
        outputView.printRestartMessage();
        String number = Console.readLine();
        inputValidator.validateNumeric(number);
        return Integer.parseInt(number);
    }
}
