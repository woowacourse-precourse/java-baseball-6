package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnswerTest {

    private Answer answer = new Answer();

    @Test
    void testGenerateAnswer() {
        int[] generatedAnswer = answer.generateAnswer();

        assertNotNull(generatedAnswer);
        assertEquals(3, generatedAnswer.length);
        for (int i = 0; i < 3; i++) {
            System.out.print(generatedAnswer[i]);
        }
    }

    @Test
    void testGenerateAnswerWithRightInput() {
        int[] input = {1, 2, 3};
        int[] generatedAnswer = answer.generateAnswer(123);
        assertNotNull(generatedAnswer);
        assertEquals(3, generatedAnswer.length);
        assertArrayEquals(input, generatedAnswer);
    }

    @Test
    void testCheckValidity() {
        int validNumber = 456;
        assertTrue(answer.check(validNumber));
    }

}
