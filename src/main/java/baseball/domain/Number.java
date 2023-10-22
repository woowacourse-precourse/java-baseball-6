package baseball.domain;

import baseball.utils.message.ErrorMessage;

/**
 * Number 클래스는 숫자 야구 게임에서 사용되는 3자리 정수를 저장한다.
 * 각 숫자는 1~9 범위를 가지며, 이를 벗어날 시 IllegalArgumentException을 발생시킨다.
 * 또한 일치 여부 확인을 위한 equals() 메소드를 오버라이딩한다.
 * 힌드 출력을 위한 로직은 Number 도메인 객체에서 진행해야 할까?
 */
public class Number implements Comparable<Number> {

    private static final Integer MAX_NUMBER_SIZE = 3;

    private final Integer[] numbers;

    public Number(int[] numbers) {
        if(!isValid(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE_NUMBER);
        }

        this.numbers = new Integer[MAX_NUMBER_SIZE];

        for(int indexOfNumbers = 0 ; indexOfNumbers < MAX_NUMBER_SIZE; indexOfNumbers++) {
            this.numbers[indexOfNumbers] = numbers[indexOfNumbers];
        }
    }

    /**
     * 도메인 객체를 검증한다.
     * 3자리가 아니거나, 각 자리수가 1~9 범위를 가지지 않는 검증을 통과하지 못한다면 IllegalArgumentException을 발생시킨다.
     *
     * 처음 구현할 때, 서로 다른 자리수를 검사하지 않아서 이를 추가하였다.
     */
    private static boolean isValid(int[] numbers) {
        if(numbers.length != MAX_NUMBER_SIZE) {
            return false;
        }

        for(int indexOfNumbers = 0 ; indexOfNumbers < MAX_NUMBER_SIZE; indexOfNumbers++) {
            if(numbers[indexOfNumbers] == 0) {
                return false;
            }

            for (int indexOfAnotherNumber = indexOfNumbers + 1; indexOfAnotherNumber < MAX_NUMBER_SIZE; indexOfAnotherNumber++) {
                if(numbers[indexOfNumbers] == numbers[indexOfAnotherNumber]) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     *
     * 두 숫자를 비교하기 위해 compareTo 메소드를 오버라이드한다.
     * 중간에 숫자가 서로 다를경우 대소비교를 위해서 자바에서 사용하는 방식과 동일하게 두 수의 차이를 반환한다.
     * (음수면 앞에것이 더 작다는 의미이며 , 양수라면 앞에것이 더 크다는 의미이다)
     * 만약 3자리수 모두 같은 경우 0을 리턴한다. (같은 경우)
     */
    @Override
    public int compareTo(Number o) {

        for (int indexOfNumbers = 0; indexOfNumbers < MAX_NUMBER_SIZE; indexOfNumbers++) {
            if(!numbers[indexOfNumbers].equals(o.numbers[indexOfNumbers])) {
                return numbers[indexOfNumbers] - o.numbers[indexOfNumbers];
            }
        }

        return 0;
    }

    /**
     * this의 주소값이 o와 같다면 같은 객체를 가리키고 있기 때문에 true이다.
     * 만약 o가 null일 경우 비교 불가능하기 때문에 false이다.
     * Number 클래스가 아니라면 false이다.
     * Number 클래스의 두 숫자를 비교하여 0이 나오면 true, 그렇지 않으면 false이다.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != Number.class) return false;
        Number number = (Number) o;
        int resultOfCompare = number.compareTo(this);

        return resultOfCompare == 0;
    }

}
