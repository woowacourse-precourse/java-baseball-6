package baseball.controller;

import baseball.model.Game;
import baseball.service.GameService;
import baseball.service.HintService;
import baseball.view.EndView;


public class GameController {

    public static void proceedGame(){
        boolean isEnd = false;
        while(!isEnd){
            startGame();
            isEnd = GameService.isEnd();
        }
    }

    public static void startGame(){
        GameService gameService = new GameService();
        Game game = gameService.createGame();

        boolean isCorrect = false;
        while (!isCorrect){
            isCorrect = provideHint(game.getAnswerArray());
        }
    }

    public static boolean provideHint(int[] answerArray){
        HintService hintService = new HintService(answerArray);
        hintService.getInputNumber();
        hintService.printHint();
        return hintService.isCorrect();
    }

}
