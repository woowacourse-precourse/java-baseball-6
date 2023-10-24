package baseball;

public class Judgement {
    private int ballCount = 0;
    private int strikeCount = 0;

    public Judgement(Numbers userNumbers, Numbers computerNumbers) {
        calculateCount(userNumbers, computerNumbers);
    }

    public void printResult() {
        OutputView.printCountText(ballCount, strikeCount);
    }

    public boolean isOut() {
        return (strikeCount == 3);
    }

    private void calculateCount(Numbers userNumbers, Numbers computerNumbers) {
        for (int userIndex = 0; userIndex < 3; userIndex++) {
            countStrike(userNumbers, computerNumbers, userIndex);
            countBallOneByOne(userNumbers, computerNumbers, userIndex);
        }
    }

    private void countStrike(Numbers userNumbers, Numbers computerNumbers, int index) {
        Number userNumber = userNumbers.getNumberByIndex(index);
        Number computerNumber = computerNumbers.getNumberByIndex(index);
        if (userNumber.equals(computerNumber)) strikeCount++;
    }

    private void countBallOneByOne(Numbers userNumbers, Numbers computerNumbers, int userIndex) {
        for (int computerIndex = 0; computerIndex < 3; computerIndex++) {
            if (userIndex == computerIndex) continue;
            countBall(userNumbers.getNumberByIndex(userIndex), computerNumbers.getNumberByIndex(computerIndex));
        }
    }

    private void countBall(Number userNumber, Number computerNumber) {
        if (userNumber.equals(computerNumber)) {
            ballCount++;
        }
    }
}
