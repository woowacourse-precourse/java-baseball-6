package baseball.constant;

public enum NumberConstants {

    //TODO: 과연 이 아웃카운트의 위치가 여기가 맞을지 고민 해보기
    OUT_COUNT(3),
    NUMBER_SIZE(3),
    MIN_NUMBER(1),
    MAX_NUMBER(9);

    private final Integer value;

    NumberConstants(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
