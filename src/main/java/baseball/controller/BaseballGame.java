package baseball.controller;

import baseball.view.InputView;

public class BaseballGame {
    CompareLogic compareLogic = new CompareLogic();
    GenerateNumber number = new GenerateNumber();
    InputView inputView = new InputView();
    Illegal check = new Illegal();
    private String exitNumber = "1";
    private int strikeCount = 0;


    public void baseballGameStart() {
        //System.out.println(exitGame(exitNumber));
        while (exitGame(exitNumber)) {
            gameStart();
        }
    }

    public void gameStart() {
        number.createRandomNumber();
        while (gameStop(strikeCount)) {
            check.checkIllegal(inputView.CompareInputNumber());
        }
    }

    public boolean exitGame(String num) {
        int exitNumber = check.parseIntNumber(num);
        return compareLogic.checkExitGame(exitNumber);
    }

    public boolean gameStop(int strikeCount) throws IllegalArgumentException {
        return check.gameStopCheckInputNumber(strikeCount);
    }
}
