package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AnnouncerTest {

    private static Announcer announcer = new Announcer();

    @Test
    public void 점수_출력_메시지_리졸버_테스트() {
        String str = announcer.resolveScoreToString(new Score(1, 1));
        String expected = "1볼 1스트라이크";
        assertEquals(str, expected);
        str = announcer.resolveScoreToString(new Score(0, 1));
        expected = "1스트라이크";
        assertEquals(str, expected);
        str = announcer.resolveScoreToString(new Score(0, 0));
        expected = "낫싱";
        assertEquals(str, expected);
        str = announcer.resolveScoreToString(new Score(2, 0));
        expected = "2볼";
        assertEquals(str, expected);

    }

}