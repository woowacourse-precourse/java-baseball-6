package controller;

import static model.GameMaker.createGameMaker;
import static view.FinishView.gameContinue;
import static view.InputView.getUserNumbersInput;

import model.BallAndStrikeChecker;
import view.ResultView;
import vo.BallAndStrike;

public class BaseballController {

    public static void gameStart() {
        BallAndStrikeChecker ballAndStrikeChecker = new BallAndStrikeChecker(createGameMaker());
        while (ballAndStrikeChecker.gameProgress()) {
            BallAndStrike ballAndStrike = ballAndStrikeChecker.getBallAndStrike(getUserNumbersInput());
            ResultView.ballAndStrikePrint(ballAndStrike);
        }
        if (gameContinue()) {
            gameStart();
        }
    }
}
