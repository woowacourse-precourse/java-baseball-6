package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void initialize() {
        validator = new Validator();
    }

    @Test
    void inputOfInvalidLength() {
        String[] testCases = {
                "1",
                "23",
                "4567",
                ""
        };

        failTest(testCases);
    }

    private void failTest(String[] testCases) {
        for (String testCase : testCases) {
            assertThrows(IllegalArgumentException.class, () -> validator.validate(testCase));
        }
    }

    @Test
    void inputZero() {
        String[] testCases = {
                "012",
                "014",
                "205",
                "960",
                "001",
                "010",
                "300",
                "000"
        };

        failTest(testCases);
    }

    @Test
    void inputNonNumbers() {
        String[] testCases = {
                "a12",
                "9f5",
                "16t",
                "af2",
                " 955",
                "312 ",
                "9tt",
                "!@*",
                "89^",
                "96&"
        };

        failTest(testCases);
    }

    @Test
    void includeDuplicatesOfNumbers() {
        String[] testCases = {
                "112",
                "466",
                "555"
        };

        failTest(testCases);
    }

    @Test
    void successCases() {
        String[] testCases = {
                "123",
                "456",
                "987",
                "127",
                "698",
                "596"
        };

        for (String testCase : testCases) {
            assertDoesNotThrow(() -> validator.validate(testCase));
        }
    }
}
