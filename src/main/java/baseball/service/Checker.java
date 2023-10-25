package baseball.service;

import baseball.model.BaseballNumbers;
import baseball.model.Result;

import java.util.Arrays;

public class Checker {
    public Checker() {
    }

    public Result check(String inputNumbersString, BaseballNumbers baseballNumbers) {

        int ball = 0, strike = 0;

        int[] inputNumbers = Arrays.stream(inputNumbersString.split("")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < 3; i++) {
            if (baseballNumbers.checkStrikeNumber(i, inputNumbers[i])) strike ++;
            else if (baseballNumbers.containNumber(inputNumbers[i])) ball ++;
        }

        return new Result(strike, ball);
    }
}