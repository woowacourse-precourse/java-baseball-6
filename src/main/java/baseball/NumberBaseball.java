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
        while (status != Status.EXIT) {
            setInputNumberMessage();
            getNumberFromUser();

            compareNumber(computer.getNumber(), user.getNumber());
            setComputerResult(user.getBall(), user.getStrike());
            printComputerResult();

            if (finishGame()) {
                getStatusFromUser();

                setRandomNumberByStatus();
            }
        }

    }

    public void printMessage() {
        System.out.print(message.getMessage());
    }

    public void setInputNumberMessage() {
        this.message = Message.INPUT_NUMBER_MESSAGE;
    }

    public void setAskStatusMessage() {
        this.message = Message.ASK_STATUS_MESSAGE;
    }

    public void getStatusFromUser() {
        setAskStatusMessage();
        printMessage();

        String statusNumberFromUser = Console.readLine();
        if (!validateStatusNumber(statusNumberFromUser)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean validateStatusNumber(String statusNumber) {
        if (statusNumber.length() != 1) {
            throw new IllegalArgumentException();
        }

        int convertStatusNumber;
        try {
            convertStatusNumber = Integer.parseInt(statusNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        if (convertStatusNumber == Status.RETRY.getStatusNumber()) {
            setStatus(Status.RETRY);
            return true;
        }

        if (convertStatusNumber == Status.EXIT.getStatusNumber()) {
            setStatus(Status.EXIT);
            return true;
        }

        return false;
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

        if (ball == 0 && strike == 0) {
            result.append(Result.NOTHING_RESULT.getResult()).append("\n");
            String computerResult = result.toString();
            computer.setResult(computerResult);
            return;
        }

        if (ball != 0) {
            result.append(ball).append(Result.BALL_RESULT.getResult());
        }

        if (ball != 0 && strike != 0) {
            result.append(" ").append(strike).append(Result.STRIKE_RESULT.getResult());
        }

        if (ball == 0 && strike != 0) {
            result.append(strike).append(Result.STRIKE_RESULT.getResult());
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

    private boolean finishGame() {
        return user.getStrike() == 3;
    }

    private void setStatus(Status status) {
        this.status = status;
    }

    private void setRandomNumberByStatus() {
        if (status == Status.RETRY) {
            setComputerRandomNumber();
        }
    }
}
