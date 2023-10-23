package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class NumberBaseball {
    private Status status;
    private Message message;
    private User user;
    private Computer computer;

    public NumberBaseball() {
        this.status = Status.START;
        this.message = Message.START_MESSAGE;
        this.user = new User();
        this.computer = new Computer();
    }

    public void startGame() {
        printMessage();

        setComputerRandomNumber();
        setInputNumberMessage();
        getNumberFromUser();

        compareNumber(computer.getNumber(), user.getNumber());
        setComputerResult(user.getBall(), user.getStrike());
        printComputerResult();
    }

    public void printMessage() {
        System.out.print(message.getMessage());
    }

    public void setInputNumberMessage() {
        this.message = Message.INPUT_NUMBER_MESSAGE;
    }

    public void getNumberFromUser() {
        user.resetNumber();
        printMessage();

        String numberFromUser = Console.readLine();

        if (!user.validateNumber(numberFromUser)) {
            throw new IllegalArgumentException();
        }
    }

    public void setComputerRandomNumber() {
        computer.setRandomNumber();
    }

    public void compareNumber(List<Integer> computerNumber, List<Integer> userNumber) {
        user.resetBallAndStrike();

        for (int i = 0; i < 3; i++) {
            if (computerNumber.get(i) == userNumber.get(i)) {
                user.addStrike();
            }

            if (computerNumber.get((i + 1) % 3) == userNumber.get(i)
                    || computerNumber.get((i + 2) % 3) == userNumber.get(i)) {
                user.addBall();
            }
        }
    }

    public void setComputerResult(int ball, int strike) {
        StringBuilder result = new StringBuilder();

        if (ball != 0) {
            result.append(ball).append(Result.BALL_RESULT.getResult());
        }

        if (strike != 0) {
            result.append(strike).append(Result.STRIKE_RESULT.getResult());
        }

        if (ball == 0 && strike == 0) {
            result.append(Result.NOTHING_RESULT.getResult());
        }

        if (strike == 3) {
            result.append(Result.ALL_STRIKE_RESULT.getResult());
        }

        result.append("\n");

        String computerResult = result.toString();
        computer.setResult(computerResult);
    }

    public void printComputerResult() {
        computer.printResult();
    }
}
