package baseball.view;

import baseball.global.message.GameMessage;
import baseball.global.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;


public class InputView {
    private final InputValidator inputValidator;
    public InputView(){
        this.inputValidator = new InputValidator();
    }

    public int requestBaseballNumberInput(){
        System.out.println(GameMessage.REQUEST_INPUT_MESSAGE.getMessage());
        String playerInput = Console.readLine();
        inputValidator.validateBaseballNumberInput(playerInput);
        return Integer.parseInt(playerInput);
    }

    public int requestGameCodeInput(){
        System.out.println(GameMessage.GAME_WIN_MESSAGE.getMessage());
        String playerInput = Console.readLine();
        inputValidator.validateGameCodeInput(playerInput);
        return Integer.parseInt(playerInput);
    }
}
