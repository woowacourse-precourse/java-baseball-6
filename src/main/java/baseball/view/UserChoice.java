package baseball.view;

import baseball.vo.Baseball;
import camp.nextstep.edu.missionutils.Console;

/*
 * 	유저가 할 행동 
 */
public class UserChoice {
	private Baseball b;
	/*
	 * 3자리 숫자 입력
	 */
	public static String usersNumbering() {
		System.out.print("\n숫자를 입력해주세요 : ");
		return Console.readLine();
	
	}
	
	/*
	 * 게임 재시작 종료
	 */
	public static String gameStartEnd() {
		System.out.println("게임을 시작하려면 1, 종료하려면 2를 입력하세요.");
		return Console.readLine();
	}
}
