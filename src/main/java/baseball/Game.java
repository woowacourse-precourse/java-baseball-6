package baseball;

public class Game {
    public void startGame(){
        Output.startCommand();
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.play();
    }
}
