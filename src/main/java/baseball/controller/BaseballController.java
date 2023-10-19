package baseball.controller;

import baseball.service.ComputerService;
import baseball.service.MessageService;
import baseball.service.PlayerService;
import camp.nextstep.edu.missionutils.Console;

public class BaseballController {
    
    private final ComputerService computerService = new ComputerService();
    private final PlayerService playerService = new PlayerService();
    private final MessageService messageService = new MessageService();

    public void startGame() {
        initGame();
        String playerNumber = getNumberFromPlayer();
    }
    
    private void initGame() {
        messageService.startGame();
        computerService.initComputer();
    }
    
    private String getNumberFromPlayer() {
    
        messageService.inputPlayerNumber();
        String number = Console.readLine();
        
        playerService.validate(number);
    
        return number;
    }
}
