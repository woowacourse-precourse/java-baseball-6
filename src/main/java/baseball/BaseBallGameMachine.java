package baseball;

import baseball.io.Output;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseBallGameMachine {
    private final Computer computer;
    private final User user;
    private List<Integer> computerNumbers = new ArrayList<>();
    private int ball;
    private int strike;
    private static final int WINNING_COUNT = 3;


    public BaseBallGameMachine(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
    }

    public void playGame() {
        makeComputerNumber();

        int[] result = new int[]{0, 0};

        while (result[1] != WINNING_COUNT) {
            List<Integer> userInput = user.userInput();
            result = calculation(userInput);
            printHint(result);
        }

    }

    public void makeComputerNumber() {
        computer.makeRandomNumbers();
        computerNumbers = computer.getComputerNumbers();
    }

    public int[] calculation(List<Integer> userInput) {
        countBall(userInput);
        countStrike(userInput);

        return new int[]{ball, strike};
    }

    public void countBall(List<Integer> userInput) {
        ball = 0;
        for (int i = 0; i < userInput.size(); i++) {
            if (!Objects.equals(userInput.get(i), computerNumbers.get(i)) && computerNumbers.contains(
                    userInput.get(i))) {
                ball++;
            }
        }

    }

    public void countStrike(List<Integer> userInput) {
        strike = 0;
        for (int i = 0; i < userInput.size(); i++) {
            if (Objects.equals(userInput.get(i), computerNumbers.get(i))) {
                strike++;
            }
        }

    }

    public void printHint(int[] calculation) {
        Output.printHint(calculation);
    }


}
