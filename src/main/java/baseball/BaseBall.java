package baseball;

import java.util.List;
import java.util.ArrayList;
import baseball.computer.Score;
import camp.nextstep.edu.missionutils.*;
import baseball.computer.Util;

public class BaseBall {
	void run() {
		Score score = new Score();

		List<Integer> computer = new ArrayList<>();
		while (computer.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}

		String ComputerNum = "";
		for (int i = 0; i < 3; i++) {
			ComputerNum += computer.get(i);
		}

		while (score.StrikeNum != 3) {
			System.out.print("숫자를 입력해주세요 : ");
			String UserNum = Console.readLine();

			/*
			 * if (UserNum.length() != 3) { throw new
			 * IllegalArgumentException("프로그램을 종료합니다.111"); }
			 */

			 Util.checkUserNum(UserNum); 
			score.checkReset();
			score.checkStrike(ComputerNum, UserNum);
			score.tellNow();
		}
		ask();
	}

	static void ask() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String choice = Console.readLine();
		Util.checkChoiceNum(choice);
		if (choice.equals("1")) {
			BaseBall newbaseball = new BaseBall();
			newbaseball.run();
		}
	}
}
