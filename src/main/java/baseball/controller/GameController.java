package baseball.controller;

import baseball.service.BaseballGame;
import baseball.util.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private final BaseballGame baseballGame;

    public GameController(final BaseballGame baseballGame){
        this.baseballGame = baseballGame;
    }

    public void play(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        do{ 
            baseballGame.start();
        } while(isContinue());
    }

    private boolean isContinue(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String mod = Console.readLine();
        InputValidator.validateGameModeInput(mod);
        
        return mod.equals("1");
    }
}
