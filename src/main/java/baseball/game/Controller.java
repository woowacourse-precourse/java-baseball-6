package baseball.game;

import baseball.game.model.Computer;
import baseball.game.model.Result;

public class GameController {
    private GameService gameService;
    private GameView gameView;
    private Computer computer;

    public void start(){
        gameView.printStartMessage();
        do{
            computer = gameService.createRandomNum();
            playGame();
            gameView.printEnd();
        } while(gameService.isRestart(gameView.askRestart()));
    }
    public void playGame(){
        if(pitchBalls().isThreeStrike()){
            return;
        }
        pitchBalls();
    }

    public Result pitchBalls(){
        Result result = getPitchResult(gameView.inputNumber());
        gameView.printResult(result);
        return result;
    }

    public Result getPitchResult(int userNumber){
        Result result = gameService.countStrikeAndBall(computer,userNumber);
        return result;
    }

    public GameController(GameService gameService, GameView gameView) {
        this.gameService = gameService;
        this.gameView = gameView;
    }
}
