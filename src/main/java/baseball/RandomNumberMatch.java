package baseball;

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

        if (strikes > 0 || balls > 0) {
            System.out.println(ballsAndStrikesFormatted(strikes, balls));
        } else {
            System.out.println("낫싱");
        }

        if (strikes == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    private String ballsAndStrikesFormatted(int strikes, int balls) {
        StringBuilder sb = new StringBuilder();
        if (balls > 0) {
            sb.append(balls).append("볼 ");
        }
        if (strikes > 0) {
            sb.append(strikes).append("스트라이크");
        }
        return sb.toString().trim();
    }

    private boolean isNumberMatched() {
        return numberMatched;
    }
}
