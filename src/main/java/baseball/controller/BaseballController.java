package baseball.controller;

import baseball.service.ComputerService;
import baseball.service.PlayerService;
import camp.nextstep.edu.missionutils.Console;

public class BaseballController {
    
    private final ComputerService computerService = new ComputerService();
    private final PlayerService playerService = new PlayerService();

    public void startGame() {
        initGame();
        String playerNumber = getNumberFromPlayer();
    }
    
    private void initGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computerService.initComputer();
    }
    
    private String getNumberFromPlayer() {
    
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();
        
        playerService.validate(number);
    
        return number;
    }
}
