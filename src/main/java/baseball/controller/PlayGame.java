package baseball.controller;

import baseball.model.GenerateRandomNum;
import baseball.model.PlayerNumber;
import baseball.model.ReplayGame;
import baseball.utils.NumberCompare;
import baseball.utils.Validator;
import baseball.view.RequestMessage;
import baseball.view.SystemMessage;

public class PlayGame {
    private GenerateRandomNum generateRandomNum;
    private final Validator validator;
    private static PlayerNumber player;

    public PlayGame() {
        validator = new Validator();
    }

    private void getNumber() {
        player = new PlayerNumber(RequestMessage.requestNumber());
        player.getPlayerNumber();
    }

    public void startGame() {
        SystemMessage.printGameStart();
        do {
            generateRandomNum = new GenerateRandomNum();
            playOneGame();
        } while (isReplay());
    }

    public int[] numberCompare() {
        return validator.getNumberCompare(player.getPlayerNumber(), generateRandomNum.getComputerNumber());
    }

    public void playOneGame() {
        do {
            getNumber();
            SystemMessage.pintResult(numberCompare());
        } while (!isGmaeset());
    }

    public boolean isGmaeset() {
        if (validator.idCorrect()) {
            SystemMessage.printGameSetMessage();
            return true;
        }
        return false;
    }

    public boolean isReplay() {
        ReplayGame replayGame = new ReplayGame(RequestMessage.requestPlay());
        if (replayGame.getReplayNumber().equals("1")) {
            return true;
        }
        return false;
    }
}
