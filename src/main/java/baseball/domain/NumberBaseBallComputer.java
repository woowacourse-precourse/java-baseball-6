package baseball.domain;

import baseball.controller.dto.Result;

public class NumberBaseBallComputer extends Computer {

    public NumberBaseBallComputer(Rule rule) {
        super(rule);
    }

    @Override
    public Result calculateResult(User user) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int index = 0; index < numbers.size(); index++) {
            int number = numbers.get(index);
            if (user.isStrike(number, index)) {
                strikeCount++;
            }
            if (user.isBall(number, index)) {
                ballCount++;
            }
        }

        return new Result(strikeCount, ballCount);
    }

}
