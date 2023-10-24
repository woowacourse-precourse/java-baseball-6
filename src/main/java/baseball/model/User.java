package baseball.model;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> gameNumber;
    private String restartNumber;

    public User() {
    }

    public List<Integer> inputGameNumber() {
        InputView.inputGameNum();
        String inputGameNum = Console.readLine();
        String[] splitNum = inputGameNum.split("");
        gameNumber = new ArrayList<>();

        for(String num : splitNum) {
            gameNumber.add(Integer.parseInt(num));
        }

        checkGameNumDigit();
        checkGameNumRange();
        checkGameNumDuplicate();

        return gameNumber;
    }

    public String inputRestartNumber() {
        InputView.inputRestartNum();
        this.restartNumber = Console.readLine();
        checkRestartNumDigit();
        checkRestartNumRange();
        return restartNumber;
    }

    private void checkGameNumDigit() {
        if(gameNumber.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void checkGameNumRange() {
        for(int num : gameNumber) {
            if(num < 1 || num > 9) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkGameNumDuplicate() {
        for(int i = 1; i < 3; i++) {
            if(gameNumber.get(i) == gameNumber.get(i-1)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkRestartNumDigit() {
        if(restartNumber.length() != 1) {
            throw new IllegalArgumentException();
        }
    }

    private void checkRestartNumRange() {
        if(!(restartNumber.equals("1") || restartNumber.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }
}
