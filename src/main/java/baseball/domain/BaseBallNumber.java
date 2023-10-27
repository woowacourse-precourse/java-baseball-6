package domain;

import lombok.Getter;

@Getter
public class BaseBallNumber {
    public static final int MIN_NUM=1;
    public static final int MAX_NUM=9;

    private Integer value;

    private BaseBallNumber(Integer value){
        this.value=value;
    }

    public static BaseBallNumber of(Integer value){
        validate(value);
        return new BaseBallNumber(value);
    }

    private static void validate(Integer number){
        if(number<MIN_NUM || number>MAX_NUM){
            throw new IllegalArgumentException("잘못된 숫자입니다.");
        }
    }

    @Override
    public boolean equals(Object object){
        BaseBallNumber otherBaseBallNumber=(BaseBallNumber) object;
        return this.value.equals(otherBaseBallNumber.value);
    }
}