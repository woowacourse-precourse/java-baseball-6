package baseball.domain;

public class Referee {

    public void calculateScore(final Answer answer, final PlayerNumbers expectedNumbers) {
        for (int index = 0; index < Answer.SIZE; index++) {
            if (answer.contains(expectedNumbers.getByIndex(index))) {
                if (answer.getByIndex(index).equals(expectedNumbers.getByIndex(index))) {
                    Score.STRIKE.addCount();
                    continue;
                }
                Score.BALL.addCount();
            }
        }
    }
}
