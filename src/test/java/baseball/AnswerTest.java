package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnswerTest {

    private Answer answer = new Answer();

    @Test
    void assertGenerateAnswerTest() {
        int[] generatedAnswer = answer.generateAnswer();

        assertNotNull(generatedAnswer);
        assertEquals(3, generatedAnswer.length);
        for (int i = 0; i < 3; i++) {
            System.out.print(generatedAnswer[i]);
        }
    }

    @Test
    void assertGenerateAnswerWithRightInputTest() {
        int[] input = {1, 2, 3};
        int[] generatedAnswer = answer.generateAnswer(123);
        assertNotNull(generatedAnswer);
        assertEquals(3, generatedAnswer.length);
        assertArrayEquals(input, generatedAnswer);
    }

    @Test
    void assertGenerateAnswerWithWrongInputTest() {
        assertThrows(IllegalArgumentException.class, () -> answer.generateAnswer(1234));
        assertThrows(IllegalArgumentException.class, () -> answer.generateAnswer(9999999));
        assertThrows(IllegalArgumentException.class, () -> answer.generateAnswer(0));
        assertThrows(IllegalArgumentException.class, () -> answer.generateAnswer(200));
        assertThrows(IllegalArgumentException.class, () -> answer.generateAnswer(1234));
    }


    @Test
    void assertCheckValidityTest() {
        int validNumber = 456;
        assertTrue(answer.check(validNumber));
    }


}
