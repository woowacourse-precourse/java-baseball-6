package baseball.domain;

import java.util.List;

public class BaseballGame {
    private final List<Integer> computerNumbers;

    private BaseballGame() {
        Computer computer = Computer.createComputer();
        this.computerNumbers = computer.getComputerNumbers();
    }

    public static BaseballGame createGame() {
        return new BaseballGame();
    }

    private int countBall(List<Integer> inputNumbers) {
        int ball = 0;
        for (int i = 0; i < computerNumbers.size(); i++) {
            if (isContainNumber(inputNumbers.get(i), i)) {
                ball++;
            }
        }
        return ball;
    }

    private int countStrike(List<Integer> inputNumbers) {
        int strike = 0;
        for (int i = 0; i < computerNumbers.size(); i++) {
            if (isSamePosition(inputNumbers.get(i), i)) {
                strike++;
            }
        }
        return strike;
    }

    private boolean isSamePosition(int number, int position) {
        return computerNumbers.get(position).equals(number);
    }

    private boolean isContainNumber(int number, int position) {
        return !isSamePosition(number, position) && computerNumbers.contains(number);
    }

    public GameResult play(List<Integer> guess) {
        int strikes = countStrike(guess);
        int balls = countBall(guess);

        return new GameResult(balls, strikes);
    }
}
