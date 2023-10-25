package baseball.domain.result;

public record Result(Integer ball, Integer strike) {

    private static final int NUMBER_OF_GAME_CLEAR_STRIKES = 3;

    public boolean isGameClear() {
        return strike.equals(NUMBER_OF_GAME_CLEAR_STRIKES);
    }
}
