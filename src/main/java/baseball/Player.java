package baseball;

public class Player {

    private Computer computer;

    public Player() {}

    public void start() {
        play();
        playAgain();
    }

    private void reset() {
        computer = new Computer();
    }

    private void play() {
        reset();
        while (!computer.isFinish()) {
            String input = readBallInput();
            computer.compareInput(input);
        }
    }

    private void playAgain() {
        String option = readOptionInput();
        if (option.equals("1")) {
            start();
        }
    }

    private String readBallInput() {
        return Input.readNumbers();
    }

    private String readOptionInput() {
        return Input.readOption();
    }
}
