package baseball.domain;

import baseball.utils.message.ErrorMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    public void Number_객체_생성() throws Exception {
        int[] numbers = new int[]{1,2,3};
        Number number = new Number(numbers);
    }

    @Test
    public void Number_out_of_range() throws Exception {
        int[] outOfRangeNumbers = new int[]{0,1,2};
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Number number = new Number(outOfRangeNumbers);
        });

        Assertions.assertEquals(ErrorMessage.INVALID_RANGE_NUMBER, illegalArgumentException.getMessage());

    }

    @Test
    public void compareTo() throws Exception {
        Number a = new Number(new int[]{1,2,3});
        Number b= new Number(new int[]{2,3,4});
        Assertions.assertTrue(a.compareTo(b) < 0);
        Assertions.assertTrue(b.compareTo(a) > 0);
    }

    @Test
    public void equals() throws Exception {
        int[] numbers = {4, 5, 7};
        Number number = new Number(numbers); Number o = new Number(numbers);

        Assertions.assertEquals(number, o);
    }

}