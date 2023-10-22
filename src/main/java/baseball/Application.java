package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        boolean progress = true;
        Computer computer = new Computer();
        while (progress) {
            computer.gameStartPhrase();
            List<Integer> computerNums = computer.generateNumber();
        }

    }
}
