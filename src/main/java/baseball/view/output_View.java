package baseball.view;

public class output_View {// 출력 기능
	private static final String Start_str = "숫자 야구 게임을 시작합니다.";
	private static final String Ball_str = "볼";
	private static final String Ball_Strike_str = "볼 ";
	private static final String Strike_str = "스트라이크";
	private static final String Nothing_str = "낫싱";

	public static void Start_Message() {
		System.out.println(Start_str);
	}

	public static void Ball_Message() {
		System.out.println(Ball_str);
	}

	public static void Ball_StrikeMessage() {
		System.out.print(Ball_Strike_str);
	}

	public static void Strike_Message() {
		System.out.println(Strike_str);
	}

	public static void Nothing_Message() {
		System.out.println(Nothing_str);
	}
	
	public static void Score(int score) {
		System.out.print(score);
	}

}
