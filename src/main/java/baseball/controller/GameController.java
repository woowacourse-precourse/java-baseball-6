package baseball.controller;

import baseball.model.BallAndStrike;
import baseball.service.GameService;
import baseball.view.InputView;

public class GameController {

    int ARRAY_DEFAULT_SIZE = 3;
    GameService service = new GameService();
    int rand[] = new int[ARRAY_DEFAULT_SIZE];

    public void start() {
        rand = service.makeRandomNumbers(rand);
        boolean finish = false;
        while(!finish){
            int input[] = service.hasNumbersToArray(InputView.setNumber());
            BallAndStrike ball = service.matchNumbers(input, rand);
            if(service.hasThreeStrike(ball)){
                finish = true;
            }
        }

        if(service.hasNewGame(InputView.setRetryNumber())){
            GameController game = new GameController();
            game.start();
        }
    }
}
