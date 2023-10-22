package baseball;

import static baseball.BaseballGameConstants.*;

import java.util.List;

public class RandomNumberMatch {

    boolean numberMatched;

    private RandomNumberMatch(List<Integer> uniqueRandomNumber, List<Integer> answer) {
        this.numberMatched = checkAndPrintNumberMatchResult(uniqueRandomNumber, answer);
    }

    public static boolean isNumberMatched(List<Integer> uniqueRandomNumber, List<Integer> answer) {
        return new RandomNumberMatch(uniqueRandomNumber, answer).isNumberMatched();
    }

    private boolean checkAndPrintNumberMatchResult(List<Integer> randomNumber, List<Integer> answer) {
        int strikes = 0;
        int balls = 0;
        int size = randomNumber.size();

        for (int i = 0; i < size; i++) {
            if (randomNumber.get(i).equals(answer.get(i))) {
                strikes++;
            } else if (answer.contains(randomNumber.get(i))) {
                balls++;
            }
        }

        String resultMessage = getResultMessage(strikes, balls);
        System.out.println(resultMessage);
        printGameFinishMessageIfAllMatched(strikes);

        return strikes == ALL_MATCHED;
    }

    private void printGameFinishMessageIfAllMatched(int strikes) {
        if (strikes == ALL_MATCHED) {
            System.out.println(GAME_FINISHED_MESSAGE);
        }
    }

    private String getResultMessage(int strikes, int balls) {
        if (strikes > 0 || balls > 0) {
            return ballsAndStrikesFormatted(strikes, balls);
        } else {
            return NOTHING;
        }
    }

    private String ballsAndStrikesFormatted(int strikes, int balls) {
        StringBuilder sb = new StringBuilder();
        if (balls > 0) {
            sb.append(balls).append(BALL).append(" ");
        }
        if (strikes > 0) {
            sb.append(strikes).append(STRIKE);
        }
        return sb.toString().trim();
    }

    private boolean isNumberMatched() {
        return numberMatched;
    }
}
