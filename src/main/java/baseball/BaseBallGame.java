package baseball;

import baseball.service.ComputerService;
import baseball.service.MessageService;
import baseball.service.UserService;
import java.util.List;

public class BaseBallGame {
    private final ComputerService computerService = new ComputerService();
    private final MessageService messageService = new MessageService();
    private final UserService userService = new UserService();

    public void startGame(){
        List<Integer> computer = computerService.createNumber();
        messageService.printStartMessage();
        messageService.printUserInputNumberMessage();
        userService.inputUserNumber();

    }
}
