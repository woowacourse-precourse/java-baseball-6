package baseball.player;

import baseball.data.BaseballNumbers;
import baseball.data.GameResult;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer implements Player{
    private BaseballNumbers baseBallNumbers;

    public Computer() {
        List<Integer> numbers = initBaseBallNumbers();
        baseBallNumbers = generateBallNumber(numbers);
    }

    @Override
    public BaseballNumbers generateBallNumber(List<Integer> numbers) throws IllegalArgumentException{
        return new BaseballNumbers(numbers);
    }

    @Override
    public BaseballNumbers ask() {
        return baseBallNumbers;
    }

    @Override
    public GameResult reply(BaseballNumbers otherbaseBallNumbers) {
        return baseBallNumbers.getResult(otherbaseBallNumbers);
    }

    private List<Integer> initBaseBallNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            numbers.add(getUniqueRandomNumber(numbers));
        }
        return numbers;
    }

    private int getUniqueRandomNumber(List<Integer> numbers) {
        int randomNumber;
        do {
            randomNumber = Randoms.pickNumberInRange(1, 9);
        } while (numbers.contains(randomNumber));

        return randomNumber;
    }
}
