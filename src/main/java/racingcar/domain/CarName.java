package racingcar.domain;

public record CarName(String value) {
    private static final int NAME_MAX_LENGTH = 4;

    public CarName {
        validateName(value);
    }

    private void validateName(String nameValue) throws IllegalArgumentException {
        if (nameValue.length() > NAME_MAX_LENGTH || nameValue.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름의 길이가 너무 깁니다.");
        }
    }
}
