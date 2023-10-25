package baseball;

import baseball.game.Balls;
import baseball.game.PlayGame;

public class Application {
    private static PlayGame playGame = new PlayGame();
    public static void main(String[] args) {
        while(true){
            if(!playGame.play()) break;
        }
    }
}
