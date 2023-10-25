package baseball.model;

import baseball.service.ValidatorFactory;
import baseball.validation.Validator;

import java.util.Arrays;
import java.util.List;

public class GameNumbers {

    private final List<SingleNumber> gameNumber;

    public GameNumbers(String value) {
        List<SingleNumber> gameNumber = Arrays.stream(value.split(""))
                .map(SingleNumber::new)
                .toList();
        validate(gameNumber);
        this.gameNumber = gameNumber;
    }

    private void validate(List<SingleNumber> target) {
        Validator validator = ValidatorFactory.getValidator(target.getClass());
        validator.validate(target);
    }

    public static GameNumbers of(String value) {
        return new GameNumbers(value);
    }

    public int size() {
        return gameNumber.size();
    }

    public SingleNumber get(int index) {
        return gameNumber.get(index);
    }

    public boolean contains(Object target) {
        return gameNumber.contains((SingleNumber) target);
    }

    @Override
    public boolean equals(Object target) {
        if (this == target) {
            return true;
        }
        if (!(target instanceof GameNumbers number)) {
            return false;
        }
        return gameNumber.equals(number.gameNumber);
    }

    @Override
    public String toString() {
        return gameNumber.toString();
    }
}
