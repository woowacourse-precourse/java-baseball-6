package baseball.domain;

import baseball.exception.BaseballErrorMessage;
import baseball.exception.BaseballGameException;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {

    private final List<Integer> numbers;

    private BaseballNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    public static BaseballNumbers randomNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < GameRuleConstant.GAME_NUMBER_SIZE.getNumber()) {
            int number = Randoms.pickNumberInRange(GameRuleConstant.GAME_NUMBER_MIN.getNumber(), GameRuleConstant.GAME_NUMBER_MAX.getNumber());
            if (!randomNumbers.contains(number)) {
                randomNumbers.add(number);
            }
        }
        return new BaseballNumbers(randomNumbers);
    }

    public static BaseballNumbers from(String input) {
        List<Integer> parsed = input.chars()
                .map(c -> c - '0')
                .boxed()
                .toList();
        return new BaseballNumbers(parsed);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != GameRuleConstant.GAME_NUMBER_SIZE.getNumber()) {
            throw new BaseballGameException(BaseballErrorMessage.INVALID_NUMBER_LENGTH);
        }
        if (numbers.stream().anyMatch(n -> n < GameRuleConstant.GAME_NUMBER_MIN.getNumber()|| n > GameRuleConstant.GAME_NUMBER_MAX.getNumber())) {
            throw new BaseballGameException(BaseballErrorMessage.INVALID_NUMBER_RANGE);
        }
        if (numbers.stream().distinct().count() != GameRuleConstant.GAME_NUMBER_SIZE.getNumber()) {
            throw new BaseballGameException(BaseballErrorMessage.DUPLICATED_NUMBER);
        }
    }

    public GameResult judge(BaseballNumbers userNumber) {
        int strike = 0;
        int ball = 0;
        for(int index = 0; index < numbers.size(); index++){
            if(isCurrentDigitStrike(userNumber, index)){
                strike++;
                continue;
            }

            if(isCurrentDigitBall(userNumber, index)){
                ball++;
            }
        }
        return GameResult.from(strike, ball);
    }

    private boolean isCurrentDigitBall(BaseballNumbers userNumber, int index) {
        return numbers.contains(userNumber.numbers.get(index));
    }

    private boolean isCurrentDigitStrike(BaseballNumbers userNumber, int index) {
        return numbers.get(index).equals(userNumber.numbers.get(index));
    }
}