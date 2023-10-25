package service;

import global.Constants;
import model.Computer;

import java.util.regex.Pattern;

public class ComputerService {

    private static ComputerService instance = new ComputerService();
    private static Computer computer = Computer.getInstance();

    private ComputerService() { }

    public static ComputerService getInstance() {
        if (instance == null) {
            instance = new ComputerService();
        }
        return instance;
    }

    public void startGame() {
        computer.setRandomNumber();
    }

    public void guessNumber(String guessingNum) {
        validateGuessingNum(guessingNum);
        // TODO: check answer
    }

    private void validateGuessingNum(String guessingNum) {
        if (!Pattern.matches(Constants.GUESSING_NUM_REGEXP,guessingNum)) {
            throw new IllegalArgumentException("1~9까지의 세자리 숫자로만 입력할 수 있습니다.");
        }
    }
}
