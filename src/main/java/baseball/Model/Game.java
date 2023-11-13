package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Integer> answerNumbers = new ArrayList<>();
    private boolean GameStatus;
    private final boolean Playing = true;
    private final boolean End = false;
    private final String RESTART = "1";
    private final String QUIT = "2";
    public Game(){
        this.setAnswerNumbers();
        this.GameStatus = Playing;
    }

    public void setAnswerNumbers(){
        while (this.answerNumbers.size() < 3) {
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

    public void applyResult(int strike) {
        if (strike == 3) {
            this.GameStatus = End;
        }
    }

    public boolean gamestatus() {
        return this.GameStatus;
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


    public List<Integer> stringToIntList(String String) { //입력값을 List로 변경
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < String.length(); i++) {
            char digitChar = String.charAt(i);
            int digitInt = Character.getNumericValue(digitChar);
            intList.add(digitInt);
        }
        return intList;
    }
}
