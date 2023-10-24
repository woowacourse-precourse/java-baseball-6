package baseball.controller;
public class GameFlowController {
    private GameController gameController;
    public GameFlowController(){
        gameController = new GameController();
    }
    public void startGame() {
        gameController.startGame();
        boolean playAgain = gameController.ynReStart();
        if(playAgain){
            gameController = new GameController();
            this.startGame();
        }
    }

}
