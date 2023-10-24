package baseball.exception.state;

public class UtilityClassConstructorException extends IllegalStateException {

	public UtilityClassConstructorException() {
		super("유틸리티 클래스는 인스턴스화할 수 없습니다.");
	}
}
