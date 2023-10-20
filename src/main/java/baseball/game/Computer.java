package baseball.game;

import baseball.view.Console;


public class Computer {

    private static String computerNumber;
    private boolean assigned = false;

    public Computer(){

    }

    public void createRandomNumber() {
        if (assigned) {
            return;
        }

        computerNumber = Console.input3DigitRandomNumber();
        assigned = true;
    }

    public String getNumber() {
        return computerNumber;
    }
}
