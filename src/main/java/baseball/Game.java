package baseball;

import baseball.users.*;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    private static final int TERMINATION_INPUT_LENGTH = 1;
    private static final char RESTART = '1', TERMINATE = '2';
    private boolean ended, terminated;
    private User computer, person;
    private int[] result;

    public Game() {
        computer = new Computer();
        person = new Person();
    }

    public void setComputerNumbers() {
        computer.clearInningNumbers();
        computer.setInningNumbers();
    }

    public void inputPersonNumbers() {
        person.clearInningNumbers();
        person.setInningNumbers();
    }

    public void playball() {
        result = person.playsWith(computer);
        if (result[1] == person.sizeOfInningNumbers()) {
            ended = true;
        }
    }

    public int[] getResult() {
        return result;
    }

    public void inputTermination() {
        String input = Console.readLine().strip();
        checkValidation(input);
        if (Integer.parseInt(input) == TERMINATE - '0') {
            terminated = true;
        }
        ended = false;
    }

    private void checkValidation(String input) {
        if (input.length() != TERMINATION_INPUT_LENGTH
                || input.charAt(0) != RESTART && input.charAt(0) != TERMINATE) {
            throw new IllegalArgumentException("Not Valid Termination Input.");
        }
    }

    public boolean isEnded() {
        return ended;
    }

    public boolean isTerminated() {
        return terminated;
    }
}
