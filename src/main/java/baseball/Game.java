package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    public static boolean isGameOver = false;

    private final String computerNumber;

    private Input input;
    private Judge judge;
    private Output output;

    public Game() {
        computerNumber = getComputerNumber();
        input = new Input();
        judge = new Judge(computerNumber);
        output = new Output();
    }

    public static void run() {
        Output.start();
        while (!isGameOver) {
            new Game().start();
        }
    }

    private void start() {
        while (true) {

        }
    }

    private String getComputerNumber() {
        StringBuilder computer = new StringBuilder();
        while (computer.length() < 3) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!computer.toString().contains(randomNumber)) {
                computer.append(randomNumber);
            }
        }
        return computer.toString();
    }
}
