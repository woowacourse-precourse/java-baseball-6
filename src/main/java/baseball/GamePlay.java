package baseball;

import java.util.List;

// 게임을 플레이하는 기능
public class GamePlay {

	static void playGame() {

		List<Integer> computerNumber = ComputerNumberCreator.createComputerNumber();

		UserNumberMaker userNumberMaker = new UserNumberMaker();

		int strikeNumber = 0;
		int ballNumber;

		while (strikeNumber != computerNumber.size()) {
			String[] inputUserNumber = userNumberMaker.inputUserNumber();
			userNumberMaker.checkInputOnlyNum(inputUserNumber);
			userNumberMaker.checkInputSize(inputUserNumber);

			List<Integer> userNumber = userNumberMaker.toListUserNumber(inputUserNumber);
			userNumberMaker.checkDuplicationUserNum(userNumber);
			userNumberMaker.checkRangeUserNum(userNumber);

			ballNumber = CountDecision.countBall(computerNumber, userNumber);
			strikeNumber = CountDecision.countStrike(computerNumber, userNumber);

			printStrike(ballNumber, strikeNumber);
		}
	}

	static void printStrike(int ballNumber, int StrikeNumber) {

		if (ballNumber == 0) {
			System.out.println("낫싱");
		} else if (StrikeNumber == 0) {
			System.out.println(ballNumber + "볼");
		} else if (StrikeNumber == ballNumber) {
			System.out.println(StrikeNumber + "스트라이크");
		} else if (StrikeNumber < ballNumber) {
			System.out.println((ballNumber - StrikeNumber) + "볼 " + StrikeNumber + "스트라이크");
		}

	}
}
