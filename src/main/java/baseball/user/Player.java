package baseball.user;

public class Player {
	private String number;
	private final String VALID_REGEX = "\\d{3}";

	public void pickNumber(String number) {
		if(!number.matches(VALID_REGEX)) {
			throw new IllegalArgumentException();
		}
		this.number = number;
	}

	public String getNumber() {
		return number;
	}
}
