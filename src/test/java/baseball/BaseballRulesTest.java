package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static baseball.BaseballRules.*;

class BaseballRulesTest {
    @Test
    public void twoNumbersLengthTest() {
        String str1 = "abc";
        String str2 = "def";
        Assertions.assertEquals(twoNumbersLength(str1, str2), 6);
    }

    @Test
    public void duplicateRemovedCombinedTwoNumbersSizeTest() {
        String str1 = "abcdef";
        String str2 = "apple";
        Assertions.assertEquals(duplicateRemovedCombinedTwoNumbersSize(str1, str2), 8);
    }

    @Test
    public void strikesTest() {
        String str1 = "123";
        String str2 = "321";
        Assertions.assertEquals(strikes(str1, str2), 1);
    }

    @Test
    public void ballsTest() {
        String str1 = "123";
        String str2 = "321";
        Assertions.assertEquals(balls(str1, str2), 2);
    }

    @Test
    public void nothingTest() {
        Assertions.assertEquals(nothing(), "낫싱");
    }

    @Test
    public void outputOfJudgmentTest() {
        String str1 = "123";
        String str2 = "321";
        Assertions.assertEquals(outputOfJudgment(str1, str2).toString(), "2볼 1스트라이크");
    }
}