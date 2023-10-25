package baseball.validation;

public class GameRestartNumberValidator {
	private static final String BASEBALL_GAME_START_NUMBER_STRING = "1";
	private static final String BASEBALL_GAME_END_NUMBER_STRING = "2";

	public void checkRestartNumberValidity(String answer) {
		if (!(answer.equals(BASEBALL_GAME_START_NUMBER_STRING) || answer.equals(BASEBALL_GAME_END_NUMBER_STRING))) {
			throw new IllegalArgumentException();
		}
	}
}
