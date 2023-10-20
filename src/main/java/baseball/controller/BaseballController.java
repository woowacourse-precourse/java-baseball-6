package baseball.controller;

import baseball.service.ComputerService;
import baseball.service.MessageService;
import baseball.service.PlayerService;
import camp.nextstep.edu.missionutils.Console;

public class BaseballController {
    
    private static final int RESTART_OPTION = 1;
    private static final int TURN_OFF_OPTION = 2;
    public static final int BASEBALL_NUMBERS_SIZE = 3;
    
    private final ComputerService computerService;
    private final PlayerService playerService;
    private final MessageService messageService;
    
    public BaseballController() {
        this.computerService = new ComputerService();
        this.playerService = new PlayerService();
        this.messageService = new MessageService();
    }
    
    public void startGame() {
        boolean continueGame = true;
        
        while (continueGame) {
            initGame();
            playGame();
            continueGame = askToContinue();
        }
    }
    
    private boolean askToContinue() {
        String number = Console.readLine();
        
        playerService.validateOption(number);
        
        return selectOption(number);
    }
    
    private boolean selectOption(String number) {
        switch (Integer.parseInt(number)) {
            case RESTART_OPTION -> {
                return true;
            }
            case TURN_OFF_OPTION -> {
                return false;
            }
            default -> throw new IllegalArgumentException("잘못된 선택입니다.");
        }
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
