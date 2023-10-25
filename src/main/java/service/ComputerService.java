package service;

import dto.GuessResultDto;
import global.Constants;
import model.Computer;

import java.util.List;
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
        computer.startGaming();
        computer.setRandomNumber();
    }

    public void endGame() {
        computer.endGaming();
    }

    public Boolean isComputerGaming() {
        return computer.getIsGaming();
    }

    public GuessResultDto guessNumber(String guessingNum) {
        validateGuessingNum(guessingNum);
        return checkGuessResult(guessingNum);
    }

    private void validateGuessingNum(String guessingNum) {
        if (!Pattern.matches(Constants.GUESSING_NUM_REGEXP,guessingNum)) {
            throw new IllegalArgumentException("1~9까지의 세자리 숫자로만 입력할 수 있습니다.");
        }
    }

    private GuessResultDto checkGuessResult(String guessingNum) {
        int ball = 0;
        int strike = 0;
        List<Integer> randomNum = computer.getRandomNumber();

        for (int i=0; i<Constants.RANDOM_NUM_LENGTH; i++) {
            int computer = randomNum.get(i);
            int guessing = guessingNum.charAt(i)-'0';

            if (computer == guessing) {
                strike++;
            }
            if (computer != guessing && randomNum.contains(guessing)) {
                ball++;
            }
        }
        return new GuessResultDto(ball,strike);
    }
}
