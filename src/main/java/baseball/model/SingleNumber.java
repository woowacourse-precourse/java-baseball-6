package baseball.model;

import baseball.constant.Number;

public class SingleNumber {

    private final Integer number;

    public SingleNumber(String target) {
        validate(target);
        this.number = Integer.parseInt(target);
    }

    public SingleNumber(Integer target) {
        validate(target);
        this.number = target;
    }

    //TODO: 검증 로직 인터페이스에 맡기기
    private void validate(Object target) {
        if (target instanceof Integer) {
            validateRange((Integer) target);
        }
        if (target instanceof String) {
            validateType((String) target);
        }
    }

    //TODO: 정규식 상수 처리
    private void validateType(String target) {
        if (!target.matches("^[1-9]+")) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(Integer target) {
        if (target < Number.MIN || Number.MAX < target) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return this.number.toString();
    }

    @Override
    public int hashCode() {
        return this.number.hashCode();
    }

    @Override
    public boolean equals(Object target) {
        if (this == target) {
            return true;
        }
        if (!(target instanceof SingleNumber singleNumber)) {
            return false;
        }
        return this.number.equals(singleNumber.number);
    }
}
