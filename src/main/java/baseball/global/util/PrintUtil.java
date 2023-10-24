package baseball.global.util;

import baseball.domain.model.Game;
import baseball.global.util.enums.GameMessageEnum;
import baseball.global.util.enums.GameResultEnum;
import baseball.global.util.enums.StrikeBallCntEnum;

public class PrintUtil {

	private PrintUtil() {

	}

	public static String makeResultMessage(int ballCnt, int strikeCnt) {
		if (strikeCnt == StrikeBallCntEnum.ALL_STRIKE.getValue()) {
			return makeResultMessageWithCount(strikeCnt, GameResultEnum.STRIKE);
		}
		if (strikeCnt > StrikeBallCntEnum.NO_STRIKE.getValue()) {
			if (ballCnt == StrikeBallCntEnum.NO_BALL.getValue()) {
				return makeResultMessageWithCount(strikeCnt, GameResultEnum.STRIKE);
			} else {
				return makeResultMessageWithCount(ballCnt, GameResultEnum.BALL)
						+ " "
						+ makeResultMessageWithCount(strikeCnt, GameResultEnum.STRIKE);
			}
		}
		if (ballCnt > StrikeBallCntEnum.NO_BALL.getValue()) {
			if (strikeCnt == StrikeBallCntEnum.NO_STRIKE.getValue()) {
				return makeResultMessageWithCount(ballCnt, GameResultEnum.BALL);
			}
		}
		return GameResultEnum.NOTHING.getValue();
	}

	public static String makeResultMessageWithCount(int cnt, GameResultEnum gameResultEnum) {
		return cnt + gameResultEnum.getValue();
	}

	public static void printGameStartMessage() {
		println(GameMessageEnum.GAME_START.getMessage());
	}

	public static void printUserEnterNumberMessage() {
		print(GameMessageEnum.ENTER_USER_EXPECTED_NUMBER.getMessage());
	}

	public static void printStrikeAndBallCnt(Game game) {
		int ballCnt = game.getBallCnt();
		int strikeCnt = game.getStrikeCnt();

		println(makeResultMessage(ballCnt, strikeCnt));
	}

	public static void printRestartOrQuitMessage() {
		println(GameMessageEnum.RESTART_OR_QUIT.getMessage());
	}

	public static void printGameClearMessage() {
		println(GameMessageEnum.GAME_CLEAR.getMessage());
	}

	public static void print(String message) {
		System.out.print(message);
	}

	public static void println(String message) {
		System.out.println(message);
	}
}
