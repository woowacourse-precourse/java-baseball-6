package baseball.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {
    private final static int MAX_NUMBER_SIZE = 3;


    private List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Numbers(String stringNumbers) {
//        checkValid(numbers);
        this.numbers = Arrays.stream(stringNumbers.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "numbers=" + numbers +
                '}';
    }
}

// 임시 보관
//public class Numbers {
//    private final static int MAX_NUMBER_SIZE = 3;
//
//    private List<Number> numbers;
//
//    public Numbers(List<Number> numbers) {
////        checkValid(numbers);
//        this.numbers = numbers;
//    }
//
//    public Numbers(String stringNumbers) {
//        List<Number> numbers = stringNumbers.chars()
//                        .mapToObj(Character::getNumericValue)
//                        .map(Number::new)
//                        .toList();
////        checkValid(numbers);
//        this.numbers = numbers;
//    }
//
//    public List<Number> getNumbers() {
//        return numbers;
//    }
//
//    public void setNumbers(List<Number> numbers) {
//        this.numbers = numbers;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder result = new StringBuilder("Numbers{numbers=");
//
//        for (Number number : numbers) {
//            result.append(number.getNumber());
//        }
//
//        result.append('}');
//        return result.toString();
//    }

//    private void checkValid(List<Number> numbers) {
//        if(!isValidLength(numbers)) {
//            throw new IllegalStateException("입력 숫자는 세 자리입니다.");
//        }
//        if(!isDuplicateValid(numbers)) {
//            throw new IllegalStateException("중복되지 않은 숫자를 입력하세요.");
//        }
//    }
//
//    private boolean isValidLength(List<Number> numbers) {
//        return numbers.size() == MAX_NUMBER_SIZE;
//    }
//
//    private boolean isDuplicateValid(List<Number> numbers) {
//        Set<Integer> uniqueNumbers = new HashSet<>();
//        for (Number number : numbers)
//            if (!uniqueNumbers.add(number.getNumber())) return false;
//
//        return true;
//    }
//
//}
