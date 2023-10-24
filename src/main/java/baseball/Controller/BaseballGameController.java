package baseball.Controller;

import baseball.Model.BaseballGameModel;
import baseball.View.BaseballGameView;

public class BaseballGameController {

    private final static BaseballGameModel model = new BaseballGameModel();
    private final static BaseballGameView view = new BaseballGameView();
    private static final String SINGLE_GAME_END = "3스트라이크";

    private void playSingleGame(){
        view.gameStart();
        model.createRandomNumbers();
        String gameResult;
        do {
            String userInput = view.getUserInput();
            gameResult = model.calculateResult(userInput);
            view.print(gameResult);
        } while (!gameResult.equals(SINGLE_GAME_END));
        view.endPrint();
    }
}
