package baseball.controller;

import baseball.model.ControllNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {
    BaseBallGameLogic baseBallGameLogic = new BaseBallGameLogic();
    GenerateNumber ganerateNumber = new GenerateNumber();
    InputView inputView = new InputView();
    Illegal illegal = new Illegal();


    public void baseballGameStart() {
        OutputView.printStart();
        while (exitGame(ControllNumber.getExitNumber())) {
            gameStart();
        }
    }

    public void gameStart() {
        ganerateNumber.createRandomNumber();
        while (gameStop(ControllNumber.getStrikeCount())) {
            illegal.checkIllegal(inputView.CompareInputNumber());
            baseBallGameLogic.checkBaseball();

        }
    }

    public boolean exitGame(String num) {
        int exitNumber = illegal.parseIntNumber(num);
        return baseBallGameLogic.checkExitGame(exitNumber);
    }

    public boolean gameStop(int strikeCount) {
        return baseBallGameLogic.gameStopCheckInputNumber(strikeCount);
    }
}
