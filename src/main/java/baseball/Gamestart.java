package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

public class Gamestart {
	public void gameStart() {
		CompareNumber CompareEachList = new CompareNumber();
		
		System.out.printf("숫자 야구 게임을 시작합니다.\n");
		String userGameSelect = "1";
		
		do {
			CompareEachList.CompareEachList();
			System.out.printf("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
			userGameSelect = Console.readLine();
			if (!userGameSelect.equals("1") && !userGameSelect.equals("2")) {
				throw new IllegalArgumentException("1또는 2를 입력해주세요.");
			}
		} while (userGameSelect.equals("1"));
	}
}
