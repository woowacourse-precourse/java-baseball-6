package baseball.service;

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
        do {
            gameStart();
        }
        while (exitGame(ControllNumber.getExitNumber()));
    }

    public void gameStart() {
        ganerateNumber.createRandomNumber();
        do {
            illegal.checkIllegal(inputView.CompareInputNumber());
            baseBallGameLogic.checkBaseball();
        }
        while (gameStop(ControllNumber.getStrikeCount()));
    }

    public boolean exitGame(String number) {
        int exitNumber = illegal.illegalDigitNumber(number);
        return baseBallGameLogic.checkExitGame(exitNumber);
    }

    public boolean gameStop(int strikeCount) {
        return baseBallGameLogic.gameStopCheckInputNumber(strikeCount);
    }
}
