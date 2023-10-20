package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedList;
import java.util.List;

public class ComputerPlayer {
    private Numbers numbers;
    private Judgement judgement;

    public ComputerPlayer() {
    }

    public void makeAnswer(int numberOfDigitsInAnswer) {
        List<Integer> pickedNumbers = new LinkedList<>();
        while (pickedNumbers.size() < numberOfDigitsInAnswer) {
            int number = Randoms.pickNumberInRange(1, 9);
            pickedNumbers.add(number);
        }
        this.numbers = new Numbers(numberOfDigitsInAnswer, pickedNumbers);
    }

    public void judgeUserAnswer(Numbers userAnswer) {
        int numOfBall = numbers.calcNumOfBall(userAnswer);
        int numOfStrike = numbers.calcNumOfStrike(userAnswer);
        this.judgement = new Judgement(numOfBall, numOfStrike);
    }

    public boolean isCorrectAnswer(int numberOfDigitsInAnswer) {
        return judgement.isCorrectAnswer(numberOfDigitsInAnswer);
    }

    public void sayJudgement(int numberOfDigitsInAnswer) {
        this.judgement.sayBallAndStrike(numberOfDigitsInAnswer);
    }
}
