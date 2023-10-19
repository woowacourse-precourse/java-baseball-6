package baseball;

import baseball.service.ComputerService;
import baseball.service.MessageService;
import baseball.service.UserService;
import baseball.validation.NumberValidation;
import java.util.List;

public class BaseBallGame {
    private final ComputerService computerService = new ComputerService();
    private final MessageService messageService = new MessageService();
    private final UserService userService = new UserService();
    private final NumberValidation validation = new NumberValidation();

    public void startGame() {
        List<Integer> computer = computerService.createNumber();
        messageService.printStartMessage();
        messageService.printUserInputNumberMessage();
        String inputNumber =  userService.inputUserNumber();
        validation.validateInputNumber(inputNumber);

    }
}
