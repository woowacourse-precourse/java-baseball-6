package baseball.controller;

import baseball.domain.GameInfo;
import baseball.service.GameService;
import baseball.view.SystemView;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;



public class Game {

    private GameInfo gameInfo;
    private GameService gameService;
    private SystemView systemView;

    public Game(){
        this.gameService = new GameService();
        this.systemView = new SystemView();
    }

    public void run() {
        start();
        end();
    }
    public void start() {
        this.gameInfo = new GameInfo(gameService.makeComputerNum());
        systemView.showStartMessage();

        while(gameInfo.getStrikeCount() != 3) {
            systemView.showInputMessage();
            gameInfo.setInput(gameService.inputValidateCheck());
            gameService.guessNum(gameInfo);
            systemView.showResult(gameInfo);
        }
    }

    public void end() {
        systemView.showWinMessage();
        systemView.showRestartOrEndMessage();
        gameInfo.setReplay(gameService.flagInputValidateCheck());

        if (gameInfo.isReplay()){
            run();
        }
    }
}
