package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidator inputValidator = new InputValidator();
    private final OutputView outputView = new OutputView();

    public void inputExpectedNumber(Player player){
        outputView.printInputExpectedNumberMessage();
        String number = Console.readLine();
        inputValidator.validateNumeric(number);
        player.changeExpectedNumbers(number);
    }

    public int inputRestartMessage(){
        outputView.printRestartMessage();
        String number = Console.readLine();
        inputValidator.validateNumeric(number);
        return Integer.parseInt(number);
    }
}
