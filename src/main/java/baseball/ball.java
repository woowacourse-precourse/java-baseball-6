package baseball;

public class ball {
	private final Integer number;

	public ball(int number) {
		validateBaseballNumber(number);
		this.number = number;
	}

	public ball(char ch) {
		this(Integer.parseInt(String.valueOf(ch)));
	}

	private void validateBaseballNumber(int number) {
		if (number < 1 || 9 < number) {
			throw new IllegalArgumentException("공의 숫자는 1~9의 자연수만 가능합니다.");
		}
	}

	@Override
	public boolean equals(Object obj) {
		ball ball = (ball) obj;
		return this.number.equals(ball.number);
	}

	@Override
	public int hashCode() {
		if (number == null) {
			return 0;
		}
		return number.hashCode();
	}

	@Override
	public String toString() {
		return this.number.toString();
	}
}
