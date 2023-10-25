package baseball;

import java.util.Arrays;

public enum Option {
	REPLY(1), END(2);

	private final int number;

	Option(int number) {
		this.number = number;
	}

	public static void validate(int number) {
		Arrays.stream(Option.values())
				.filter(option -> option.number == number)
				.findAny()
				.orElseThrow(()-> new IllegalArgumentException("존재하지 않는 옵션 번호입니다."));
	}

	public static boolean isEnd(int number){
		validate(number);

		return Option.END.number == number;
	}
}

