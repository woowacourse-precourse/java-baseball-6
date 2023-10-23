package baseball;

import camp.nextstep.edu.missionutils.Console;

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
}
