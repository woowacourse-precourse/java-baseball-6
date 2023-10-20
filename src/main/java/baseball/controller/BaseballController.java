package baseball.controller;

import static baseball.domain.Computer.BASEBALL_NUMBERS_SIZE;

import baseball.service.ComputerService;
import baseball.service.MessageService;
import baseball.service.PlayerService;
import camp.nextstep.edu.missionutils.Console;

public class BaseballController {
    
    private final ComputerService computerService = new ComputerService();
    private final PlayerService playerService = new PlayerService();
    private final MessageService messageService = new MessageService();
    
    public void startGame() {
        // TODO: 게임 재시작 및 종료
        initGame();
        playGame();
    }
    
    private void initGame() {
        messageService.startGame();
    }
    
    private void playGame() {
        String computer = getComputerNumber();
        
        int balls, strikes = 0;
        
        while (strikes != BASEBALL_NUMBERS_SIZE) {
            String player = getPlayerNumber();
            
            balls = computerService.countBalls(computer, player);
            strikes = computerService.countStrikes(computer, player);
            
            messageService.printGameResult(balls, strikes);
        }
    
        messageService.announceThreeStrikes();
    }
    
    private String getPlayerNumber() {
        messageService.inputPlayerNumber();
        String number = Console.readLine();
        
        playerService.validate(number);
        
        return number;
    }
    
    private String getComputerNumber() {
        return computerService.initComputer();
    }
}
