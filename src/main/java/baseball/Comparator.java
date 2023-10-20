package baseball;

import java.util.List;

public class Comparator {

    private int ballCount;
    private int strikeCount;
    private boolean[] isStrike;

    private void init(int digit) {
        this.ballCount = 0;
        this.strikeCount = 0;
        this.isStrike = new boolean[digit];
    }

    public boolean compare(List<Integer> generatedNumbers, List<Integer> guessedNumbers) {
        int digit = generatedNumbers.size();
        init(digit);

        // check strike position
        for (int i = 0; i < digit; i++) {
            if (generatedNumbers.get(i) == guessedNumbers.get(i)) {
                strikeCount++;
                isStrike[i] = true;
            }
        }

        for (int i = 0; i < digit; i++) {
            for (int j = 0; j < digit; j++) {
                if (isStrike[i] || isStrike[j]) continue;
                if (generatedNumbers.get(i) == guessedNumbers.get(j)) ballCount++;
            }
        }

        StringBuilder result = new StringBuilder();
        if (ballCount != 0) result.append(ballCount).append("볼 ");
        if (strikeCount != 0) result.append(strikeCount).append("스트라이크");
        if (strikeCount == 0 && ballCount == 0) result.append("낫싱");

        System.out.println(result.toString());

        return strikeCount == 3;
    }
}
