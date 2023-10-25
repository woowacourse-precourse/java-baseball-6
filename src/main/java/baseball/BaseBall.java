package baseball;

public class BaseBall {
	private final String number;
	private static final int NUMBER_LENGTH = 3;

	public BaseBall(final String number) {
		// 입력값의 길이가 3이 아닌 경우 예외 발생
		if (number.length() != NUMBER_LENGTH)
			throw new IllegalArgumentException("올바르지 않는 숫자의 길이입니다. " + NUMBER_LENGTH);

		// 입력값의 각 자리 숫자가 1에서 9 사이의 값이 아닌 경우 예외 발생
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			char digit = number.charAt(i);
			if (digit < '1' || digit > '9')
				throw new IllegalArgumentException("올바르지 않는 숫자입니다. 숫자: " + number);
		}
		this.number = number;
	}

	/**
	 * 입력된 숫자와 비교하여 볼의 개수를 계산합니다.
	 *
	 * @author ybchar
	 * @param inputBaseBall 비교할 숫자
	 * @return 볼의 개수
	 */
	public int countBalls(final BaseBall inputBaseBall) {
		int balls = 0;
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			for (int j = 0; j < NUMBER_LENGTH; j++) {
				// 같은 수가 다른 자리에 있으면 볼
				if (i != j && this.number.charAt(i) == inputBaseBall.number.charAt(j)) {
					balls += 1;
				}
			}
		}
		return balls;
	}

	/**
	 * 입력된 숫자와 비교하여 스트라이크의 개수를 계산합니다.
	 *
	 * @author ybchar
	 * @param inputBaseBall 비교할 숫자
	 * @return 스트라이크의 개수
	 */
	public int countStrikes(final BaseBall inputBaseBall) {
		int strikes = 0;
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			// 같은 수가 같은 자리에 있으면 스트라이크
			if (this.number.charAt(i) == inputBaseBall.number.charAt(i))
				strikes += 1;
		}
		return strikes;
	}

	/**
	 * 입력된 숫자와 비교하여 낫싱인지 판단합니다.
	 *
	 * @author ybchar
	 * @param inputBaseBall 비교할 숫자
	 * @return 낫싱 여부
	 */
	public boolean isNothing(final BaseBall inputBaseBall) {
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			for (int j = 0; j < NUMBER_LENGTH; j++) {
				// 같은 수가 하나라도 있는 경우 낫싱이 아니다.
				if (this.number.charAt(i) == inputBaseBall.number.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
}
