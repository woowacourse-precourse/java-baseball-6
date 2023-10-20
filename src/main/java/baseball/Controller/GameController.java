package baseball.Controller;

import baseball.Model.Game;
import baseball.View.GameTerminalView;

public class GameController {
    private Game game;
    private GameTerminalView gameView;

    public GameController() {
        this.game = new Game();
        this.gameView = new GameTerminalView();
    }

    public void start() {
        gameView.display("숫자 야구 게임을 시작합니다.");
        while(true) {
            while(!game.getRefereeController().judge(game.getPlayerController().query(), game.getComputer())){}
            gameView.display("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            
            
            if(game.getPlayerController().answer().equals("2"))
                return;
        }
    }
}
