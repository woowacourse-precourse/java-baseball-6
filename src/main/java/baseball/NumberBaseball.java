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
}
