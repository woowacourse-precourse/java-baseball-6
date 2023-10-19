package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    public static boolean isGameOver = false;

    private Input input;
    private Judge judge;
    private Output output;

    private final String computerNumber;

    public Game() {
        computerNumber = getComputerNumber();
        input = new Input();
        judge = new Judge(computerNumber);
        output = new Output(judge);
    }

    public static void run() {
        Output.start();
        while (!isGameOver) {
            new Game().start();
        }
    }

    private void start() {

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
