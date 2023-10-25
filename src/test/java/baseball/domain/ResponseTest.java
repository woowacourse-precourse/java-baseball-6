package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ResponseTest {

    private final int NUMBER_BALLS = 3;

    @Test
    void 게임_볼_개수_규칙만큼_스트라이크_이면_정답을_알림() {
        // given
        int strikeCount = NUMBER_BALLS;
        int ballCount = 0;

        List<Integer> countList = new ArrayList<>(Arrays.asList(strikeCount, ballCount));

        // when
        Response response = new Response(countList, NUMBER_BALLS);

        // then
        assertEquals(false, response.isWrongAnswer());

    }

    @Test
    void 게임_볼_개수_규칙만큼_스트라이크가_아니면_오답을_알림() {
    // given
        int strikeCount = NUMBER_BALLS - 1;
        int ballCount = 1;
        List<Integer> countList = new ArrayList<>(Arrays.asList(strikeCount, ballCount));

        // when
        Response response = new Response(countList, NUMBER_BALLS);

        // then
        assertEquals(true, response.isWrongAnswer());

    }


}