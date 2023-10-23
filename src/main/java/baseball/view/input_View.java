package baseball.view;
import camp.nextstep.edu.missionutils.Console;
public class input_View { // 사용자 입력 기능
	
	private static final String inputPlayerNumber_str = "숫자를 입력해주세요 : ";
	private static final String Retry_str = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요!";
	
	public static String inputPlayerNumber() {
		System.out.println(inputPlayerNumber_str);
		return Console.readLine();
	}
	
	public static String Retry() {
		System.out.println(Retry_str);
		return Console.readLine();
	}

}
