package baseball.domain.game;

import baseball.util.Err;
import java.util.ArrayList;
import java.util.List;

public sealed class GameNumbers permits Computer, Player {
    public static final int GAME_NUMBERS_COUNT = 3;
    protected final List<GameNumber> gameNumbers;

    protected GameNumbers(List<Integer> numbers) {
        validateNumbers(numbers);
        this.gameNumbers = convertToGameNumbers(numbers);
    }

    private void validateNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != GAME_NUMBERS_COUNT) {
            throw new IllegalArgumentException(Err.INVALID_NUMBERS_SIZE.getMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        int uniqueCount = (int) numbers.stream().distinct().count();
        if (uniqueCount != numbers.size()) {
            throw new IllegalArgumentException(Err.DUPLICATE_NUMBERS.getMessage());
        }
    }

    private List<GameNumber> convertToGameNumbers(List<Integer> numbers) {
        List<GameNumber> gameNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            gameNumbers.add(new GameNumber(number));
        }
        return gameNumbers;
    }

    protected GameNumber getGameNumberAt(int index) {
        return gameNumbers.get(index);
    }

}
