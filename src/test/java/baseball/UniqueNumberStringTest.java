package baseball;

import baseball.game.MatchResult;
import baseball.game.RuleSet;
import baseball.game.UniqueNumberString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UniqueNumberStringTest {
    @Test
    void match_Test() {
        // given
        String[][] cases = {{"123", "321"}, {"123", "123"}, {"123", "231"}, {"123", "456"}};
        int[][] answers = {{2, 1}, {0, 3}, {3, 0}, {0, 0}};

        for (int i = 0; i < cases.length; i++) {
            // when
            UniqueNumberString numberString1 = UniqueNumberString.create(cases[i][0], RuleSet.BASIC);
            UniqueNumberString numberString2 = UniqueNumberString.create(cases[i][1], RuleSet.BASIC);

            MatchResult result = UniqueNumberString.match(numberString1, numberString2);

            // then
            assertEquals(result.getBall(), answers[i][0],
                    "case " + cases[i][0] + ", " + cases[i][1] + "에서 ball 불일치");
            assertEquals(result.getStrike(), answers[i][1],
                    "case " + cases[i][0] + ", " + cases[i][1] + "에서 strike 불일치");
        }
    }

    @Test
    void create_Test() {
        // given
        String[] cases = {"123", "456", "789", "112", "121", "211", "111", "", "1", "11", "1111", "cow", "24L"};
        boolean[] answers = {true, true, true, false, false, false, false, false, false, false, false, false, false};

        for (int i = 0; i < cases.length; i++) {
            // when
            String value = cases[i];

            // then
            if (answers[i]) {
                assertDoesNotThrow(() -> UniqueNumberString.create(value, RuleSet.BASIC),
                        "올바른 값을 생성하지 못했습니다. : " + cases[i]);
            } else {
                assertThrows(IllegalArgumentException.class,
                        () -> UniqueNumberString.create(value, RuleSet.BASIC),
                        "옳지 않은 값이 생성되었습니다. : " + cases[i]);
            }
        }
    }

    @Test
    void CompareResult_toString_Test() {
        // given
        String[][] cases = {{"123", "321"}, {"123", "123"}, {"123", "231"}, {"123", "456"}};
        String[] answers = {"2볼 1스트라이크", "3스트라이크", "3볼", "낫싱"};

        for (int i = 0; i < cases.length; i++) {
            // when
            UniqueNumberString numberString1 = UniqueNumberString.create(cases[i][0], RuleSet.BASIC);
            UniqueNumberString numberString2 = UniqueNumberString.create(cases[i][1], RuleSet.BASIC);

            MatchResult result = UniqueNumberString.match(numberString1, numberString2);

            // then
            assertEquals(result.toString(), answers[i]);
        }
    }

    @Test
    void createRandom_Test() {
        // given
        int equalCount = 0;
        int equalLimit = 5;

        // when
        for (int i = 0; i < 100; i++) {
            UniqueNumberString numberString1 = UniqueNumberString.createRandom(RuleSet.BASIC);
            UniqueNumberString numberString2 = UniqueNumberString.createRandom(RuleSet.BASIC);

            if (numberString1.equals(numberString2)) {
                equalCount++;
            }
        }

        // then
        assertTrue(equalCount < equalLimit);
    }

    @Test
    void equals_Test() {
        // given
        UniqueNumberString ns1 = UniqueNumberString.create("123", RuleSet.BASIC);
        UniqueNumberString ns2 = UniqueNumberString.create("123", RuleSet.BASIC);
        UniqueNumberString ns3 = UniqueNumberString.create("124", RuleSet.BASIC);

        // when
        boolean expectTrue = ns1.equals(ns2);
        boolean expectFalse = ns1.equals(ns3);

        // then
        assertTrue(expectTrue);
        assertFalse(expectFalse);
    }
}
