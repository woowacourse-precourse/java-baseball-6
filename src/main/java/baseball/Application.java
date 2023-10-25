package baseball;

import baseball.Evaluator;
import baseball.BaseballGame;

public class Application {
//    private static Evaluator evaluator;

//    Application(){
//        evaluator = new Evaluator();
//    }
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
            baseballGame.startGame();
        while ( Evaluator.askForNewGame() )
            baseballGame.runGame();
    }
}
