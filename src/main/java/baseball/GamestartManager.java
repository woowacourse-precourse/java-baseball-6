package baseball;
import camp.nextstep.edu.missionutils.Console;

public class GamestartManager {
	public void startGame() {
		ResultPrinter resultPrinter = new ResultPrinter();
		
		System.out.print("숫자 야구 게임을 시작합니다.\n");
		String selection;
		
		do {
			resultPrinter.printGameResult();
			System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
			selection = Console.readLine();
			if (!selection.equals("1") && !selection.equals("2")) {
				throw new IllegalArgumentException("1또는 2를 입력해주세요.");
			}
		} while (selection.equals("1"));
	}
}
