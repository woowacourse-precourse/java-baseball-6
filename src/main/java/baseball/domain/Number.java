package baseball.domain;

import baseball.utils.message.ErrorMessage;

/**
 * Number 클래스는 숫자 야구 게임에서 사용되는 3자리 정수를 저장한다.
 * 각 숫자는 1~9 범위를 가지며, 이를 벗어날 시 IllegalArgumentException을 발생시킨다.
 * 또한 일치 여부 확인을 위한 equals() 메소드를 오버라이딩한다.
 * 힌드 출력을 위한 로직은 Number 도메인 객체에서 진행해야 할까?
 */
public class Number {

    private static final Integer MAX_NUMBER_SIZE = 3;

    private final Integer[] numbers;

    public Number(int[] numbers) {
        /**
         * 도메인 객체 검증을 실시한다
         * 3자리가 아니거나, 각 자리수가 1~9 범위를 가지지 않는 검증을 통과하지 못한다면 IllegalArgumentException을 발생시킨다.
         */
        if(!isValid(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE_NUMBER);
        }

        this.numbers = new Integer[MAX_NUMBER_SIZE];

        for(int indexOfNumbers = 0 ; indexOfNumbers < MAX_NUMBER_SIZE; indexOfNumbers++) {
            this.numbers[indexOfNumbers] = numbers[indexOfNumbers];
        }
    }

    private static boolean isValid(int[] numbers) {
        if(numbers.length != MAX_NUMBER_SIZE) {
            return false;
        }

        for(int indexOfNumbers = 0 ; indexOfNumbers < MAX_NUMBER_SIZE; indexOfNumbers++) {
            if(numbers[indexOfNumbers] == 0) {
                return false;
            }
        }

        return true;
    }

}
