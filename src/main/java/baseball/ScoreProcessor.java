package baseball;

public class ScoreProcessor {
    public Score processScore(Numbers computerNumbers, Numbers playerNumbers) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < computerNumbers.getNumbers().size(); i++) {
            if (computerNumbers.getNumbers().get(i).equals(playerNumbers.getNumbers().get(i))) {
                strikeCount++;
            } else if (computerNumbers.getNumbers().contains(playerNumbers.getNumbers().get(i))) {
                ballCount++;
            }
        }
        return new Score(strikeCount, ballCount);
    }
}
