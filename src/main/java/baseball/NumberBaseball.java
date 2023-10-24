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
        printStartMessage();

        setComputerRandomNumber();
        while (playGameByStatus()) {
            printInputNumberMessage();
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

    private void printStartMessage() {
        this.message = Message.START_MESSAGE;
        System.out.print(message.getMessage());
    }

    private void printInputNumberMessage() {
        this.message = Message.INPUT_NUMBER_MESSAGE;
        System.out.print(message.getMessage());
    }

    private void printAskStatusMessage() {
        this.message = Message.ASK_STATUS_MESSAGE;
        System.out.print(message.getMessage());
    }

    private void getStatusFromUser() {
        printAskStatusMessage();

        String statusNumberFromUser = Console.readLine();
        if (!validateStatusNumber(statusNumberFromUser)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean validateStatusNumber(String statusNumber) {
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

    private void getNumberFromUser() {
        user.resetNumber();

        String numberFromUser = Console.readLine();

        if (!user.validateNumber(numberFromUser)) {
            throw new IllegalArgumentException();
        }
    }

    private void setComputerRandomNumber() {
        computer.setRandomNumber();
    }

    private void compareNumber(List<Integer> computerNumber, List<Integer> userNumber) {
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

    private void setComputerResult(int ball, int strike) {
        StringBuilder result = new StringBuilder();

        if (ball == 0 && strike == 0) {
            result.append(Result.NOTHING_RESULT.getResult());
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

        String computerResult = result.toString();
        computer.setResult(computerResult);
    }

    private void printComputerResult() {
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

    private boolean playGameByStatus() {
        return status != Status.EXIT;
    }
}
