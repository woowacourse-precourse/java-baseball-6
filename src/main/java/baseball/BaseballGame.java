package baseball;

import static baseball.User.NEW_GAME;

import java.util.List;
import java.util.stream.Collectors;

public class BaseballGame {

    private Computer computer;
    private User user;
    private Result result;

    public BaseballGame() {
        this(new Computer(), new User(), new Result());
    }

    private BaseballGame(Computer computer, User user, Result result) {
        this.computer = computer;
        this.user = user;
        this.result = result;
    }

    public void start() {
        List<Integer> computerRandomNumbers = computer.createNumber();
        String stringComputerNumber = computerNumberToString(computerRandomNumbers);

        while (true) {
            List<Integer> userInputNumbers = user.inputNumber();
            String stringUserNumber = Integer.toString(userInputNumbers.get(0));

            int[] ballAndStrike = calculateBallAndStrike(stringComputerNumber, stringUserNumber);

            int ball = ballAndStrike[0];
            int strike = ballAndStrike[1];

            result.printBallAndStrike(ball, strike);
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private String computerNumberToString(List<Integer> computerRandomNumbers) {
        return computerRandomNumbers.stream()
                .map(computerNumbers -> computerNumbers.toString())
                .collect(Collectors.joining());
    }

    private int[] calculateBallAndStrike(String stringComputerNumber, String stringUserNumber) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < stringComputerNumber.length(); i++) {
            if (isStrike(stringComputerNumber, stringUserNumber, i)) {
                strike++;
            } else if (isBall(stringComputerNumber, stringUserNumber, i)) {
                ball++;
            }
        }
        return new int[]{ball, strike};
    }

    private boolean isStrike(String computerNumber, String userNumber, int index) {
        return computerNumber.charAt(index) == userNumber.charAt(index);
    }

    private boolean isBall(String computerNumber, String userNumber, int index) {
        return computerNumber.contains("" + userNumber.charAt(index));
    }

    public boolean isNewGame() {
        if (NEW_GAME.equals(user.inputStartingNewGameOrNot())) {
            return true;
        }
        return false;
    }
}
