package baseball.service;

import baseball.domain.BaseballGame;

import java.util.List;

public class BaseballGameService {


    public String [] run(String userNumber){
        String result;

        BaseballGame baseballGame = new BaseballGame();
        List<Integer> computerNumber =  baseballGame.createComputerNumber();

        result = baseballGame.compareTwoNumbers(userNumber,computerNumber);

        String [] results = baseballGame.splitCountResult(result);

        return results;
    }







}
