package baseball;

import java.util.List;

import static baseball.Input.NUMBER_LENGTH;

public class Judge {

    private final String computer;
    private String guess;

    private int ball = 0;
    private int strike = 0;

    public Judge(final String computer) {
        this.computer = computer;
    }

    public List<Integer> of(String guess) {
        this.guess = guess;
        count();
        return List.of(ball, strike);
    }


    private void count() {
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            addIfBall(i);
            addIfStrike(i);
        }
    }

    private void addIfBall(int i) {
        for (int j = 0; j < NUMBER_LENGTH; j++) {
            if (isBall(i, j)) {
                ball++;
            }
        }
    }

    private void addIfStrike(int i) {
        if (isStrike(i)) {
            strike++;
        }
    }

    private boolean isBall(int i, int j) {
        return i != j && computer.charAt(i) == guess.charAt(j);
    }

    private boolean isStrike(int i) {
        return computer.charAt(i) == guess.charAt(i);
    }
}
