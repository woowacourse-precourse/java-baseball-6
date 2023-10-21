package baseball.console;

public class ConsoleOutput {

	private static final String welcomeMessage = "숫자 야구 게임을 시작합니다.";
	private static final String inputMessage = "숫자를 입력해주세요 : ";
	private static final String endMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String resumeMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	private ConsoleOutput() {
	}

	public static void println(String message) {
		System.out.println(message);
	}

	public static void printInputMessage() {
		System.out.print(inputMessage);
	}

	public static void printGameStart() {
		System.out.println(welcomeMessage);
	}

	public static void printFinishMessage() {
		println(endMessage);
	}

	public static void printResumeMessage() {
		println(resumeMessage);
	}

}
