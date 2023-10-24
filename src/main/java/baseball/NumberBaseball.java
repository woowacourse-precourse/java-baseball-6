package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class NumberBaseball {
    private Status status;
    private User user;
    private Computer computer;

    public NumberBaseball() {
        this.status = Status.START;
        this.user = new User();
        this.computer = new Computer();
    }

    public void startGame() {
        printMessage(Message.START_MESSAGE);

        setComputerRandomNumber();
        while (playGameByStatus()) {
            printMessage(Message.INPUT_NUMBER_MESSAGE);
            getNumberFromUser();

            compareNumber(computer.getNumber(), user.getNumber());
            computer.createResult(user.getBall(), user.getStrike());
            computer.printResult();

            if (user.finishGame()) {
                getStatusFromUser();
                setRandomNumberByStatus();
            }
        }
    }

    private void printMessage(Message message) {
        System.out.print(message.getMessage());
    }

    private void getStatusFromUser() {
        printMessage(Message.ASK_STATUS_MESSAGE);

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