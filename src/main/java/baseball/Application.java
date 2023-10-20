package baseball;

import java.util.ArrayList;

import baseball.domain.BaseballCode;
import baseball.game.BaseballGames;
import baseball.service.RandomCodeService;
import baseball.service.impl.RandomCodeServiceImpl;

public class Application {
	private static final BaseballGames baseballGames = new BaseballGames();
	private static final RandomCodeService randomCodeService = new RandomCodeServiceImpl();

	public static void main(String[] args) {
		BaseballCode baseballCode = new BaseballCode(new ArrayList<>());
		while (true) {
			BaseballCode baseballCodes = baseballCode.makeNewBaseballCode(randomCodeService.makeRandomCodeList());
			baseballGames.playBaseball(baseballCode.getCodes());
			break;
		}
	}
}