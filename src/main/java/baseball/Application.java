package baseball;

public class Application {
	public static void main(String[] args) {
		System.out.println("숫자 야구 게임을 시작합니다.");
		try {
			BaseballUtil.comparingNumber();
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("잘못된 입력값입니다. 애플리케이션을 종료합니다.");
		}
		return;
	}
}
