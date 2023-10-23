package baseball.controller;

import baseball.service.BaseballGameService;
import baseball.service.GameServce;

/**
 * 여러 게임 서비스를 실행할 수 있는 게임 컨트롤러
 *
 */
public class GameController {

    //야구게임 서비스 연결
    GameServce gameService = new BaseballGameService();


    // 야구게임 실행 메소드
    public void baseballGame(){
        while(!gameService.GameEnd()){
            gameService.GameMaker();
            gameService.GameProgressor();
        }
    }

}
