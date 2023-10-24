package baseball.service;

public enum GameCommand {

	REPLAY("1"), EXIT("2");

	private static final String GAME_COMMAND_ERROR_MESSAGE = "1(재시작) 또는 2(종료)를 입력해주세요.";

	private final String commandValue;

	GameCommand(final String commandValue) {
		this.commandValue = commandValue;
	}

	public static boolean isReplayCommand(final String replayCommandInput) {
		return replayCommandInput.equals(REPLAY.commandValue);
	}

	public static void validate(final String replayCommandInput) {
		if (!replayCommandInput.equals(REPLAY.commandValue) && !replayCommandInput.equals(EXIT.commandValue)) {
			throw new IllegalArgumentException(GAME_COMMAND_ERROR_MESSAGE);
		}
	}
}
