package baseball.game.io;

import java.util.Scanner;

import static baseball.constant.GameConstant.INPUT_USER_NUMBER;
import static baseball.constant.GameConstant.INPUT_REPLAY_USER_NUMBER;

public class Input {
    private final Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public String input(){
        System.out.print(INPUT_USER_NUMBER);
        return scanner.nextLine();
    }
    public String replayInput() {
        System.out.println(INPUT_REPLAY_USER_NUMBER);
        return scanner.nextLine();
    }
}
