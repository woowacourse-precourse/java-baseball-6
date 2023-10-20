package baseball.view;

import static baseball.util.MessageConstants.STARTING_MESSAGE;
import static baseball.util.MessageConstants.USER_INPUT_MESSAGE;

import java.util.Scanner;

public class User {

    private Scanner sc = new Scanner(System.in);

    public void showStartMessage() {
        System.out.println(STARTING_MESSAGE.getContent());
    }

    public int getUserInput() {
        System.out.print(USER_INPUT_MESSAGE.getContent());
        return sc.nextInt();
    }

}
