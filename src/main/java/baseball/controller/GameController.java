package baseball.controller;

import baseball.service.BaseBallGameService;
import baseball.service.ComputerNumGenerateService;

import java.util.List;

public class GameController {
    private BaseBallGameService baseBallGameService;
    private ComputerNumGenerateService computerNumGenerateService;

    public GameController(){
        baseBallGameService = new BaseBallGameService();
        computerNumGenerateService = new ComputerNumGenerateService();
    }

    public void gameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
         //끝날 때까지 반복
        while (Boolean.TRUE){
            List<Integer> computerNum = computerNumGenerateService.computerNumberInit();
            baseBallGameService.playOneGame(computerNum);
            if(baseBallGameService.endCheck()) break;
        }
    }

}
