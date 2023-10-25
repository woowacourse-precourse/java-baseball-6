package baseball.service;

import baseball.model.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseballServiceTest {
    BaseballService bs = new BaseballService();

    @Test
    @DisplayName("볼 카운트 체크")
    void getBallCount() {
        Number computer = new Number(new ArrayList<>(List.of(1,2,3)));

        Number user = new Number(new ArrayList<>(List.of(2,6,3)));
        int ballCount = bs.getBallCount(computer, user);
        assertEquals(ballCount , 1);

        user = new Number(new ArrayList<>(List.of(4,5,6)));
        ballCount = bs.getBallCount(computer , user);
        assertEquals(ballCount , 0);
    }

    @Test
    @DisplayName("스트라이크 카운트 체크")
    void getStrikeCount() {
        Number computer = new Number(new ArrayList<>(List.of(1,2,3)));

        Number user = new Number(new ArrayList<>(List.of(1,2,3)));
        int strikeCount = bs.getStrikeCount(computer, user);
        assertEquals(strikeCount , 3);

        user = new Number(new ArrayList<>(List.of(4,5,6)));
        strikeCount = bs.getStrikeCount(computer , user);
        assertEquals(strikeCount , 0);
    }
}