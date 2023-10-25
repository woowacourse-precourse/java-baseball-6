package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

class NumberFactoryTest {

    @Test
    public void createByComputer() {
        NumberGameConfiguration baseballGameConfiguration = new NumberGameConfiguration
            .Builder()
            .minimumNumberOfRange(1)
            .maximumNumberOfRange(9)
            .numberOfDigits(3)
            .build();

        List<Integer> computerNumbers = NumberFactory.createByComputer(baseballGameConfiguration);

        assertNotNull(computerNumbers);
        assertEquals(3, computerNumbers.size());

        for (int number : computerNumbers) {
            assertTrue(number >= 1 && number <= 9);
        }
    }

    @Test
    public void createByUser() {
        String userInput = "123";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        List<Integer> userNumbers = NumberFactory.createByUser();

        assertNotNull(userNumbers);
        assertEquals(3, userNumbers.size());
        assertTrue(userNumbers.contains(1));
        assertTrue(userNumbers.contains(2));
        assertTrue(userNumbers.contains(3));

        System.setIn(System.in);
    }
}