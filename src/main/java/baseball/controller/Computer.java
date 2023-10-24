package baseball.controller;

import baseball.model.Numbers;
import baseball.model.Score;
import baseball.view.ComputerViewer;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 9;
    private final static int MAX_NUMBER_SIZE = 3;
    private final static ComputerViewer viewer = new ComputerViewer();

    private final Numbers computerNumbers;

    public Computer() {
        this.computerNumbers = new Numbers(makeAnswerNumbers());
    }

    @Override
    public String toString() {
        return computerNumbers.toString();
    }

    private List<Integer> makeAnswerNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < MAX_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            addRandomNumbers(randomNumbers,randomNumber);
        }

        return randomNumbers;
    }

    private void addRandomNumbers(List<Integer> randomNumbers, int randomNumber) {
        if (!randomNumbers.contains(randomNumber)) {
            randomNumbers.add(randomNumber);
        }
    }

    public boolean isWin(Score score) {
        if (score.getStrike() == 3) {
            viewer.showGameWin();
            return false;
        }
        return true;
    }

    public Score compare(List<Integer> user) {
        Calculator calculator = new Calculator();
        Score score = calculator.getScore(this.computerNumbers.getNumbers(),user);
        viewer.showScore(score);
        return score;
    }

}
