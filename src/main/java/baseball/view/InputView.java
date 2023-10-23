package baseball.view;

import baseball.global.message.GameMessage;
import baseball.global.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;


public class InputView {
    private final InputValidator inputValidator;
    InputView(){
        this.inputValidator = new InputValidator();
    }

    public int requestBaseballNumberInput(){
        System.out.println(GameMessage.REQUEST_INPUT_MESSAGE);
        String playerInput = Console.readLine();
        inputValidator.validateBaseballNumberInput(playerInput);
        return Integer.parseInt(playerInput);
    }

}
