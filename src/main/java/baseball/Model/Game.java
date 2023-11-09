package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final int NUMBER_LENGTH = 3;
    private final List<Integer> answerNumbers = new ArrayList<>();
    private final boolean PLAYING = true;
    private final boolean END = false;
    private boolean gameStatus;
    private final String RESTART = "1";
    private final String QUIT = "2";

    public Game() {
        this.setAnswerNumbers();
        this.gameStatus = PLAYING;
    }

    private void setAnswerNumbers() {
        while (this.answerNumbers.size() < this.NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.answerNumbers.contains(randomNumber)) {
                this.answerNumbers.add(randomNumber);
            }
        }
    }

    public String makeGameResult(List<Integer> inputNumbers) {
        GameResult gameResult = new GameResult(this.answerNumbers, inputNumbers);
        applyResult(gameResult.getStrikes());
        return gameResult.resultToString();
    }

    public void applyResult(int strikes) {
        if (strikes == NUMBER_LENGTH) {
            this.gameStatus = END;
        }
    }

    public boolean getGameStatus() {
        return this.gameStatus;
    }

    public boolean isRestart(String input) {
        if (input.equals(RESTART)) {
            return true;
        } else if (input.equals(QUIT)) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}