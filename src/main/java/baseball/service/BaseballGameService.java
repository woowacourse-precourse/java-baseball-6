package baseball.service;

import baseball.domain.BaseballGame;

import java.util.List;

public class BaseballGameService {

    List<Integer> computerNumber;
    BaseballGame baseballGame = new BaseballGame();

    public BaseballGameService() {
        computerNumber = baseballGame.createComputerNumber();
        System.out.println(computerNumber);
    }


    public String[] run(String userNumber) {
        String result;

        result = baseballGame.compareTwoNumbers(userNumber);

        String[] results = baseballGame.splitCountResult(result);

        return results;
    }


}
