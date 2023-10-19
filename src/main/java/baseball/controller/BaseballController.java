package baseball.controller;

import baseball.service.ComputerService;
public class BaseballController {
    
    private final ComputerService computerService = new ComputerService();

    public void startGame() {
        initGame();
    }
    
    private void initGame() {
        printStartGame();
        computerService.initComputer();
    }
    
    private void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
