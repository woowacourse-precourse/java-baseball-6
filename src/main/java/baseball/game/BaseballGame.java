package baseball.game;

import static baseball.console.Input.chooseRestart;
import static baseball.console.Input.getNumbers;
import static baseball.console.Output.showResult;
import static baseball.console.Output.startGame;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BaseballGame {

    private GameStatus gameStatus;
    private Numbers answer, userData;
    private boolean isKeppPlaying;


    public BaseballGame() {
        gameStatus = new GameStatus();
        answer = new Numbers();
        userData = new Numbers();
        isKeppPlaying = true;
    }

    public void start() {
        while (isKeppPlaying) {
            startGame();
            clearGame();
            playGame();
            setRestartFlag(chooseRestart());
        }
    }

    private void playGame() {
        while (!gameStatus.isGameOver()) {
            gameStatus.clearGameStatus();
            userData.makeNumbersFromString(getNumbers());
            gameStatus.calcScore(answer.toDto(), userData.toDto());
            showResult(gameStatus);
        }
    }

    private void clearGame() {
        gameStatus.clearGameStatus();
        answer.makeRandomNumbers();
        isKeppPlaying = true;
        userData = new Numbers();
    }

    private void setRestartFlag(String userInput) {
        int restartNum = Integer.parseInt(userInput);
        if (restartNum == 2) {
            isKeppPlaying = false;
        }
    }

}
