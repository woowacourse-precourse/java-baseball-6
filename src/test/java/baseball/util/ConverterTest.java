package baseball.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class ConverterTest {

    @Test
    void seperateTest () throws Exception {
        //given
        String input = "897";
        Converter converter = new Converter(input);

        //when
        List<Integer> seperatedNumbers = converter.getSeperatedNumbers();

        //then
        for (Integer seperatedNumber : seperatedNumbers) {
            System.out.println(seperatedNumber);
        }
        assertEquals(3, seperatedNumbers.size());
    }

}
