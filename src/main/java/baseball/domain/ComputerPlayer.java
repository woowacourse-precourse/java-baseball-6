package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerPlayer {
    private Numbers numbers;
    private Judgement judgement;

    public ComputerPlayer() {
    }

    public void makeAnswer(int numberOfDigitsInAnswer) {
        Numbers numbers = new Numbers(numberOfDigitsInAnswer);
        while (!numbers.isComplete()) {
            int number = Randoms.pickNumberInRange(1, 9);
            numbers.appendNumber(number);
        }
        this.numbers = numbers;
    }

    public void judgeUserAnswer(Numbers userAnswer) {
        int numOfBall = numbers.calcNumOfBall(userAnswer);
        int numOfStrike = numbers.calcNumOfStrike(userAnswer);
        this.judgement = new Judgement(numOfBall, numOfStrike);
    }

    public boolean isCorrectAnswer() {
        return judgement.isCorrectAnswer(numbers.getNumberOfDigitsInAnswer());
    }

    public void sayJudgement() {
        this.judgement.sayBallAndStrike(numbers.getNumberOfDigitsInAnswer());
    }
}
