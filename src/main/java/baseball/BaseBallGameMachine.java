package baseball;

import baseball.io.Output;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseBallGameMachine {
    private final Computer computer;
    private final User user;
    boolean flag = true;
    private List<Integer> computerNumbers = new ArrayList<>();

    public BaseBallGameMachine(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
    }

    public void playGame() {
        computer.makeRandomNumbers();
        computerNumbers = computer.getComputerNumbers();

        while (true) {
            List<Integer> userInput = user.userInput();
            int[] result = calculation(userInput);
            printHint(result);

            if (result[1] == 3) {
                break;
            }
        }

    }

    public int[] calculation(List<Integer> userInput) {
        int ball = countBall(userInput);
        int strike = countStrike(userInput);

        if (strike == 3) {
            flag = false;
        }

        return new int[]{ball, strike};
    }

    public int countBall(List<Integer> userInput) {
        int ball = 0;
        for (int i = 0; i < userInput.size(); i++) {
            if (!Objects.equals(userInput.get(i), computerNumbers.get(i)) && computerNumbers.contains(
                    userInput.get(i))) {
                ball++;
            }
        }

        return ball;
    }

    public int countStrike(List<Integer> userInput) {
        int strike = 0;
        for (int i = 0; i < userInput.size(); i++) {
            if (Objects.equals(userInput.get(i), computerNumbers.get(i))) {
                strike++;
            }
        }

        return strike;
    }

    public void printHint(int[] calculation) {
        Output.printHint(calculation);
    }


}
