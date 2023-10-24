package baseball.model;

//import view.input_View;

public class Retry {
	private static final String Error_str = "잘못된 값을 입력하셨습니다.";
	private String retryNumber;

	public String getRetryNumber() {
		return retryNumber;
	}

	public Retry(String retryNumber) {
		isRetryNumber(retryNumber);
		this.retryNumber = retryNumber;
	}
	// 1,2인지 체크 함수
	public static void isRetryNumber(String retryNumber){
		if (!retryNumber.equals("1") && !retryNumber.equals("2")) {
			throw new IllegalArgumentException(Error_str);
		}
	}
}
