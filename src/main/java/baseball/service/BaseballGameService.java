package baseball.service;

import baseball.domain.BaseballGame;
import baseball.domain.Computer;

import java.util.List;

public class BaseballGameService {

    List<Integer> computerNumber;
    BaseballGame baseballGame = new BaseballGame();

    public BaseballGameService() {
        computerNumber = createComputerNumber();
        System.out.println(computerNumber);
    }


    public String[] run(String userNumber) {
        String result;

        result = compareTwoNumbers(userNumber);

        String[] results = splitCountResult(result);

        return results;
    }

    public List<Integer> createComputerNumber() {
        Computer computer = new Computer();
        this.computerNumber = computer.randomComputerNumber();
        return computerNumber;
    }

    public String compareTwoNumbers(String userNumber) {

        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < userNumber.length(); i++) {
            if (userNumber.charAt(i) - '0' == computerNumber.get(i)) {
                strikeCount++;
                continue;
            }
            if (computerNumber.contains(userNumber.charAt(i) - '0')) {
                ballCount++;
            }
        }

        String result = ballCount + "," + strikeCount;

        return result;

    }

    public String[] splitCountResult(String result) {

        String[] results = result.split(",");

        return results;

    }



}
