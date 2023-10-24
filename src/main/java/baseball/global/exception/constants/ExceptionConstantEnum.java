package baseball.global.exception.constants;

import baseball.global.util.enums.NumberRangeEnum;

public enum ExceptionConstantEnum {
	NUMBER_LENGTH_BELOW_MINIMUM_LENGTH(String.format("입력하신 숫자의 길이가 %d자리보다 짧습니다. %d자리로 입력해주세요.", NumberRangeEnum.NUMBER_LENGTH.getValue(), NumberRangeEnum.NUMBER_LENGTH.getValue())),


	NUMBER_LENGTH_EXCEED_MAXIMUM_LENGTH(String.format("입력하신 숫자의 길이가 %d자리보다 짧습니다. %d자리로 입력해주세요.", NumberRangeEnum.NUMBER_LENGTH.getValue(), NumberRangeEnum.NUMBER_LENGTH.getValue())),
	NUMBER_NOT_DIGIT("입력하신 숫자의 형식을 확인해주세요."),
	DUPLICATE_NUMBER_IN_INPUT("입력하신 숫자 중 중복되는 수가 있습니다. 서로 다른 숫자를 입력해주세요."),
	NUMBER_NOT_START_OR_QUIT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

	private final String message;

	ExceptionConstantEnum(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
