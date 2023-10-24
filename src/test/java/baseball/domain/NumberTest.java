package baseball.domain;

import baseball.utils.message.ErrorMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class NumberTest {

    @Test
    public void Number_객체_생성() throws Exception {
        List<Integer> numbers = List.of(1,2,3);
        Number number = new Number(numbers);
    }

    @Test
    public void Number_out_of_range() throws Exception {
        List<Integer> outOfRangeNumbers = List.of(0,1,2);

        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Number number = new Number(outOfRangeNumbers);
        });

        Assertions.assertEquals(ErrorMessage.INVALID_RANGE_NUMBER, illegalArgumentException.getMessage());
    }

    @Test
    public void Number_invalid_length() throws Exception {
        List<Integer> invalidLengthNumbers = List.of(1,2);

        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Number number = new Number(invalidLengthNumbers);
        });

        Assertions.assertEquals(ErrorMessage.INVALID_NUMBER_LENGTH, illegalArgumentException.getMessage());
    }

    @Test
    public void Number_not_unique() throws Exception {
        List<Integer> notUniqueNumbers = List.of(2,2,3);

        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Number number = new Number(notUniqueNumbers);
        });

        Assertions.assertEquals(ErrorMessage.NOT_UNIQUE_NUMBER, illegalArgumentException.getMessage());
    }

    @Test
    public void compareTo() throws Exception {
        List<Integer> aInput = List.of(1, 2, 3);
        List<Integer> bInput = List.of(2, 3, 4);
        Number a = new Number(aInput);
        Number b = new Number(bInput);

        Assertions.assertTrue(a.compareTo(b) < 0);
        Assertions.assertTrue(b.compareTo(a) > 0);
    }

    @Test
    public void equals() throws Exception {
        List<Integer> numbers = List.of(4, 5, 7);
        Number number = new Number(numbers); Number o = new Number(numbers);

        Assertions.assertEquals(number, o);
    }

    @Test
    public void parseNumber() throws Exception {
        int value = 123;
        Number number = Number.parseNumber(value);
        Number x = new Number(List.of(1,2,3));

        Assertions.assertEquals(number, x);

        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Number.parseNumber(102);
        });

        Assertions.assertEquals(e.getMessage(),ErrorMessage.INVALID_RANGE_NUMBER);
    }

    @Test
    public void contains() throws Exception {
        Number number = Number.parseNumber(123);

        boolean contains = number.contains(new Digit(1));
        Assertions.assertTrue(contains);
        contains = number.contains(new Digit(5));
        Assertions.assertFalse(contains);
    }

}