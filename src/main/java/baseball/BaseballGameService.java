package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballGameService {

	private static final Integer NUMBER_SIZE = 3;

	public void playBaseballGame() {
		System.out.println("숫자 야구 게임을 시작합니다.");
		CreateNumber createNumber = new CreateNumber();
		List<Integer> computerNumber =
				createNumber.createComputerNumber(NUMBER_SIZE);
		CheckNumber checkNumber = new CheckNumber();
		int isRightNumber = checkNumber.isNumberRight(computerNumber);

		while (isRightNumber == 1) {
			System.out.print("숫자를 입력해주세요 : ");
			List<Integer> userNumber = createNumber.createUserNumber();
			int userNumberIsRight = checkNumber.isNumberRight(userNumber);

			isRightNumber = isRightNumber * userNumberIsRight;
			if (isRightNumber == -1) {
				break;
			}

			BaseballGameResult baseballGameResult = new BaseballGameResult();
			int[] gameScore = baseballGameResult
					.countScore(computerNumber, userNumber);
			isRightNumber = baseballGameResult
							.baseballGameResult(isRightNumber, gameScore);

			if (isRightNumber == 0) {
				System.out.println("게임을 새로 시작하려면 1, " +
						"종료하려면 2를 입력하세요");
				String select = Console.readLine();
				int selectResult = checkNumber.selectRestartOrExit(select);
				if (selectResult == -1) {
					isRightNumber = -1;
				} else if (selectResult == 1) {
					playBaseballGame();
				} else {
					System.out.println("게임 종료");
				}
			}
		}
	}
}
