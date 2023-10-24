package baseball.domain;

import baseball.utils.message.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Number 클래스는 숫자 야구 게임에서 사용되는 3자리 정수를 저장한다.
 * 각 숫자는 1~9 범위를 가지며, 이를 벗어날 시 IllegalArgumentException을 발생시킨다.
 * 또한 일치 여부 확인을 위한 equals() 메소드를 오버라이딩한다.
 * 힌드 출력을 위한 로직은 Number 도메인 객체에서 진행해야 할까?
 */
public class Number implements Comparable<Number> {

    private static final Integer MAX_NUMBER_SIZE = 3;

    /**
     * Number는 DIGIT으로 구성되도록 만드는게 좋다고 생각된다.
     *
     */
    private final List<Digit> numbers;

    public Number(List<Integer> numbers) {
        if(!isValidLength(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_LENGTH);
        }

        this.numbers = new ArrayList<>();

        for (Integer number : numbers) {
            Digit digit = new Digit(number);

            if(this.numbers.contains(digit)) {
                throw new IllegalArgumentException(ErrorMessage.NOT_UNIQUE_NUMBER);
            }

            this.numbers.add(digit);
        }
    }

    /**
     * 도메인 객체를 검증한다.
     * 3자리가 아니거나, 각 자리수가 1~9 범위를 가지지 않는 검증을 통과하지 못한다면 IllegalArgumentException을 발생시킨다.
     *
     * 처음 구현할 때, 서로 다른 자리수를 검사하지 않아서 이를 추가하였다. -> 생성자로 이동
     */
    private static boolean isValidLength(List<Integer> numbers) {
        return numbers.size() == MAX_NUMBER_SIZE;
    }

    /**
     *
     * 사용자 입력 int, string의 숫자를 Number 객채로 변경하는 메소드
     * Integer, String 처럼 parse 메소드를 이용한 정적 팩토리 메소드를 사용
     */

    public static Number parseNumber(Integer number) {
        List<Integer> numbers = new ArrayList<>();

        while (number != 0) {
            numbers.add(number % 10);
            number /= 10;
        }
        Collections.reverse(numbers);
        return new Number(numbers);
    }


    /**
     * 힌트 정보를 얻기 위해 Number에서 digit이 포홤되었는지 확인함
     * 만약 포함하고 있고, 위치까지 동일하다면 strike
     * 포함만 한다면 ball이다.
     */
    public boolean contains(Digit digit) {
        return numbers.contains(digit);
    }

    public Hint getHint(Number number) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int indexOfNumber = 0; indexOfNumber < MAX_NUMBER_SIZE; indexOfNumber++) {
            Digit digit = numbers.get(indexOfNumber);
            if(number.contains(digit)) {
                Digit anotherNumber = number.numbers.get(indexOfNumber);

                if(digit.equals(anotherNumber)) {
                    strikeCount++;
                    continue;
                }

                ballCount++;
            }
        }

        return new Hint(ballCount,strikeCount);
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
            Digit thisDigit = numbers.get(indexOfNumbers);
            Digit compareDigit = o.numbers.get(indexOfNumbers);

            if(!thisDigit.equals(compareDigit)) {
                return thisDigit.compareTo(compareDigit);
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
