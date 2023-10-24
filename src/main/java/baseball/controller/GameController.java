package baseball.controller;

import baseball.service.ComputerService;
import baseball.service.UserService;

public class GameController {
    private final UserService userService = new UserService();
    private final ComputerService gameService = new ComputerService(userService);

    //게임시작
    public void startGame(){
        gameService.gameStart();
    }

    //게임숫자 발급
    public void makeNumber(){
        gameService.gameInitialize();
    }

    //게임진행
    public boolean matchNumber(String userNumber){
        boolean isEnd = gameService.gameOn(userNumber);
        if (isEnd) System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        return isEnd;
    }

    //게임중단
    public boolean endGame(int userType){
        boolean isEnd = gameService.gameEnd(userType);
        return isEnd;
    }

}
