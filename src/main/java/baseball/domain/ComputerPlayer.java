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
        int numOfBall = 0;
        int numOfStrike = 0;
        for (int i = 0; i < userAnswer.len(); i++) {
            int numberOfComputerNumbers = numbers.getByIndex(i); // 5
            int indexOfUserAnswer = userAnswer.getIndexByNumber(numberOfComputerNumbers);
            if (indexOfUserAnswer != -1) {
                if (indexOfUserAnswer == i) {
                    numOfStrike += 1;
                } else {
                    numOfBall += 1;
                }
            }
        }
        this.judgement = new Judgement(numOfBall, numOfStrike);
    }

    public boolean isThreeStrike() {
        return judgement.isThreeStrike();
    }

    public boolean isNothing() {
        return judgement.isNothing();
    }

    public void sayBallAndStrike() {
        this.judgement.sayBallAndStrike();
    }

    public void sayThreeStrike() {
        System.out.println("3스트라이크");
    }

    public void sayNothing() {
        System.out.println("낫싱");
    }
}
