package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberBaseball {
    private Status status;
    private Message message;
    private BufferedReader br;
    private User user;

    public NumberBaseball() {
        this.status = Status.START;
        this.message = Message.START_MESSAGE;
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.user = new User();
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

        String numberFromUser;
        try {
            numberFromUser = br.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        if (!user.validateNumber(numberFromUser)) {
            throw new IllegalArgumentException();
        }
    }
}
