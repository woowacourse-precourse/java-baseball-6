package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    private Computer computer;

    public Player() {
        computer = new Computer();
    }

    public void start() {
        play();
        playAgain();
    }

    private void reset() {
        computer = new Computer();
    }

    private void play() {
        while (true) {
            String input = readBallInput();
            if (computer.compareInput(input)) {
                break;
            }
        }
    }

    private void playAgain() {
        System.out.println(Constants.RESTART_OR_FINISH_MESSAGE);
        String option = readOptionInput();
        if (option.equals("1")) {
            reset();
            start();
        }
    }

    private String readBallInput() {
        System.out.println(Constants.INPUT_MESSAGE);
        return Console.readLine();
    }

    private String readOptionInput() {
        return Console.readLine();
    }
}
